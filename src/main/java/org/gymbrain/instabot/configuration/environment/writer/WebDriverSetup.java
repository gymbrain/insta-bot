package org.gymbrain.instabot.configuration.environment.writer;

import org.gymbrain.instabot.configuration.environment.WebDriverConstants;

import java.util.Properties;

public class WebDriverSetup {
    private final String chromeDriver;

    private WebDriverSetup(WebDriverSetupBuilder webDriverSetupBuilder) {
        this.chromeDriver = webDriverSetupBuilder.chromeDriver;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty(WebDriverConstants.CHROME_DRIVER_URL, chromeDriver);
        return properties;
    }

    public static class WebDriverSetupBuilder {
        private final String chromeDriver;

        public WebDriverSetupBuilder(String chromeDriver) {
            this.chromeDriver = chromeDriver;
        }

        public WebDriverSetup build() {
            return new WebDriverSetup(this);
        }
    }
}
