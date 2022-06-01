package org.gymbrain.instabot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gymbrain.instabot.configuration.AccountSetup;
import org.gymbrain.instabot.configuration.WebDriverSetup;

import java.text.MessageFormat;
import java.util.Properties;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        init();
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
        System.setProperties(properties);
        printProperties(properties);
    }

    private static void loadAccountProperties() {
        logger.trace("load account properties");
        AccountSetup accountSetup = new AccountSetup.AccountSetupBuilder("jalili_dev", "Mo.9063069090").build();
        Properties properties = accountSetup.getProperties();
        System.setProperties(properties);
        printProperties(properties);
    }

    private static void printProperties(Properties properties) {
        properties.forEach((o, o2) -> logger.info(MessageFormat.format("property '{'{0}'}' -> '{'{1}'}' was set to environment.", o, o2)));
    }
}
