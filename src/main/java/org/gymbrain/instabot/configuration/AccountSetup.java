package org.gymbrain.instabot.configuration;

import java.util.Properties;

public class AccountSetup {
    private final String username;
    private final String password;

    private AccountSetup(AccountSetupBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("insta.username", username);
        properties.setProperty("insta.password", password);
        return properties;
    }

    public static class AccountSetupBuilder {
        private final String username;
        private final String password;

        public AccountSetupBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public AccountSetup build() {
            return new AccountSetup(this);
        }
    }
}
