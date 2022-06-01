package org.gymbrain.instabot.tools;

import org.gymbrain.instabot.configuration.ChromeDriverCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    private final ChromeDriver chromeDriver;

    public Utils() {
        chromeDriver = ChromeDriverCreator.getInstance();
    }

    public WebElement getElement(String path) {
        return chromeDriver.findElement(new By.ByXPath(path));
    }

    public WebDriverWait driverWait(){
        return new WebDriverWait(chromeDriver,40);
    }

}
