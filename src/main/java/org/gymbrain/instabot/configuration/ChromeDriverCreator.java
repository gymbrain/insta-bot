package org.gymbrain.instabot.configuration;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator {
    private ChromeDriverCreator() {
    }

    public static ChromeDriver getInstance() {
        return ChromeDriverCreatorHelper.CHROME_DRIVER;
    }

    private static class ChromeDriverCreatorHelper {
        private static final ChromeDriver CHROME_DRIVER = new ChromeDriver();
    }
}
