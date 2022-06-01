package org.gymbrain.instabot.configuration.environment.writer;

import org.gymbrain.instabot.configuration.environment.InstagramConstants;

import java.util.Properties;

public class InstagramSetup {
    private final String username;
    private final String password;
    private final String baseUrl;

    private InstagramSetup(InstagramSetupBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.baseUrl = builder.baseUrl;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty(InstagramConstants.USERNAME, username);
        properties.setProperty(InstagramConstants.PASSWORD, password);
        properties.setProperty(InstagramConstants.BASE_URL, baseUrl);
        return properties;
    }

    public static class InstagramSetupBuilder {
        private final String username;
        private final String password;
        private final String baseUrl;

        public InstagramSetupBuilder(String username, String password, String baseUrl) {
            this.username = username;
            this.password = password;
            this.baseUrl = baseUrl;
        }

        public InstagramSetup build() {
            return new InstagramSetup(this);
        }
    }
}
