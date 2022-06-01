package org.gymbrain.instabot.configuration.environment.writer;

import java.util.Properties;

public class EnvironmentConfig {
    public void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    public void setProperty(Properties properties) {
        System.setProperties(properties);
    }
}
