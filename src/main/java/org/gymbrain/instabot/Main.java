package org.gymbrain.instabot;

import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gymbrain.instabot.configuration.environment.writer.EnvironmentWriter;
import org.gymbrain.instabot.configuration.environment.writer.InstagramSetup;
import org.gymbrain.instabot.configuration.environment.writer.WebDriverSetup;
import org.gymbrain.instabot.runner.MainRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws MalformedURLException {
        init();
//        System.setProperty("os.name","linux");
//        System.setProperty("os.version","20");
        new MainRunner().execute();
    }

    private static void init() throws MalformedURLException {
        logger.trace("The initialize of application");
        loadConfiguration();
    }

    private static void loadConfiguration() throws MalformedURLException {
        logger.trace("load properties");
        loadWebDriverProperties();
        loadAccountProperties();
        loadOverrideProperties();
    }

    private static void loadOverrideProperties() throws MalformedURLException {
        logger.trace("load override properties");
        File file = new File("resources/override.properties");
        URL[] urls = {file.toURI().toURL()};
        ClassLoader loader = new URLClassLoader(urls);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("override", Locale.getDefault(), loader);
        Properties properties = new Properties();
        try (Reader reader = Files.newReader(file, StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        resourceBundle.keySet().forEach(key -> {
            properties.setProperty(key, resourceBundle.getString(key));
        });
        EnvironmentWriter.writeProperty(properties);
    }

    private static void loadWebDriverProperties() {
        logger.trace("load webdriver properties");
        WebDriverSetup webDriver = new WebDriverSetup.WebDriverSetupBuilder("/home/mohammad/Documents/Project/insta-bot/chromedriver")
                .build();
        Properties properties = webDriver.getProperties();
        EnvironmentWriter.writeProperty(properties);
    }

    private static void loadAccountProperties() {
        logger.trace("load instagram properties");
        InstagramSetup instagramSetup = new InstagramSetup.InstagramSetupBuilder("gymbrain_ir", "Mo.9063069090", "https://www.instagram.com/").build();
        Properties properties = instagramSetup.getProperties();
        EnvironmentWriter.writeProperty(properties);
    }
}
