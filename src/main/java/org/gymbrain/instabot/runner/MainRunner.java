package org.gymbrain.instabot.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gymbrain.instabot.configuration.ChromeDriverCreator;
import org.gymbrain.instabot.configuration.environment.InstagramConstants;
import org.gymbrain.instabot.configuration.environment.reader.EnvironmentReader;
import org.gymbrain.instabot.tools.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainRunner {
    private static final Logger logger = LogManager.getLogger(MainRunner.class);
    private final ChromeDriver ch;
    private final Utils utils;
    private String baseUrl;
    private String username;
    private String password;
    private String query;

    public MainRunner() {
        ch = ChromeDriverCreator.getInstance();
        utils = new Utils();
    }

    public void execute() {
        loadProperties();
        openBrowser();
        login();
        search();
    }

    private void loadProperties() {
        logger.info("load properties");
        baseUrl = EnvironmentReader.readProperty(InstagramConstants.BASE_URL);
        username = EnvironmentReader.readProperty(InstagramConstants.USERNAME);
        password = EnvironmentReader.readProperty(InstagramConstants.PASSWORD);
        query = EnvironmentReader.readProperty(InstagramConstants.QUERY);
        logger.info("finish load properties");
    }

    private void openBrowser() {
        logger.info("open browser");
        ch.get(baseUrl);
    }

    private void login() {
        WebElement usernameInput = utils.getElement("//*[@id=\"loginForm\"]/div/div[1]/div/label/input");
        WebElement passwordInput = utils.getElement("//*[@id=\"loginForm\"]/div/div[2]/div/label/input");
        WebElement loginButton = utils.getElement("//*[@id=\"loginForm\"]/div/div[3]/button");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


    private void search() {
        WebElement searchInput = utils.driverWait()
                .until(ExpectedConditions.visibilityOfElementLocated(
                        new By.ByXPath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input")
                ));
        searchInput.sendKeys(query);
    }
}
