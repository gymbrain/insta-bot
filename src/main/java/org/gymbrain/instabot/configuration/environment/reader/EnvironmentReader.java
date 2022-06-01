package org.gymbrain.instabot.configuration.environment.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;

public class EnvironmentReader {
    private static final Logger logger = LogManager.getLogger(EnvironmentReader.class);

    public static String readProperty(String key) {
        String value = System.getProperty(key);
        logger.info(MessageFormat.format("property '{'{0}'}' loaded with value '{'{1}'}'", key, value));
        return value;
    }
}
