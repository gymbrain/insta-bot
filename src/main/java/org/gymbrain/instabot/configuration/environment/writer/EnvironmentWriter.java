package org.gymbrain.instabot.configuration.environment.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.Properties;

public class EnvironmentWriter {
    private static final Logger logger = LogManager.getLogger(EnvironmentWriter.class);


    public static void writeProperty(Properties properties) {
        properties.forEach((key, value) -> writeProperty(key.toString(), value.toString()));

    }

    public static void writeProperty(String key, String value) {
        System.setProperty(key, value);
        logger.info(MessageFormat.format("property '{'{0}'}' set with value '{'{1}'}'", key, value));
    }
}
