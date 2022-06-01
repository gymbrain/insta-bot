package org.gymbrain.instabot.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gymbrain.instabot.configuration.ChromeDriverCreator;
import org.gymbrain.instabot.configuration.environment.InstagramConstants;
import org.gymbrain.instabot.configuration.environment.WebDriverConstants;
import org.gymbrain.instabot.configuration.environment.reader.EnvironmentReader;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainRunner {
    private static final Logger logger = LogManager.getLogger(MainRunner.class);
    private String baseUrl;
    private String username;
    private String password;
    private ChromeDriver ch;

    public void execute() {
        loadProperties();
        openBrowser();
    }

    private void loadProperties() {
        logger.info("load properties");
        baseUrl = EnvironmentReader.readProperty(InstagramConstants.BASE_URL);
        username = EnvironmentReader.readProperty(InstagramConstants.USERNAME);
        password = EnvironmentReader.readProperty(InstagramConstants.PASSWORD);
        password = EnvironmentReader.readProperty(WebDriverConstants.CHROME_DRIVER_URL);
        logger.info("finish load properties");
    }

    private void openBrowser() {
        logger.info("open browser");
        ch = ChromeDriverCreator.getInstance();
        ch.get(baseUrl);
    }
}
