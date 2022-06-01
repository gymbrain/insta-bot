package org.gymbrain.instabot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gymbrain.instabot.configuration.environment.writer.EnvironmentWriter;
import org.gymbrain.instabot.configuration.environment.writer.InstagramSetup;
import org.gymbrain.instabot.configuration.environment.writer.WebDriverSetup;
import org.gymbrain.instabot.runner.MainRunner;

import java.text.MessageFormat;
import java.util.Properties;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        init();
//        System.setProperty("os.name","linux");
//        System.setProperty("os.version","20");
        new MainRunner().execute();
    }

    private static void init() {
        logger.trace("The initialize of application");
        loadConfiguration();
    }

    private static void loadConfiguration() {
        logger.trace("load properties");
        loadWebDriverProperties();
        loadAccountProperties();
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
        InstagramSetup instagramSetup = new InstagramSetup.InstagramSetupBuilder("jalili_dev", "Mo.9063069090", "https://www.instagram.com/").build();
        Properties properties = instagramSetup.getProperties();
        EnvironmentWriter.writeProperty(properties);
    }
}
