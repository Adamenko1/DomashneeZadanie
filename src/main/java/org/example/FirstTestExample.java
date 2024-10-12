package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestExample {

    WebDriver wd;

    @BeforeTest()
    public void beforeTestFixture() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        wd = WebDriverManager
                .chromedriver()
                .capabilities(chromeOptions)
                .create();
    }

    @Test()
    public void firstTest() {
        wd.get("https://stackoverflow.com/");
        wd.manage().window().maximize();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        By mainPagePLocator = By.xpath("/html/body/div[5]/div[3]/section[1]/div[1]/h2");
        WebElement mainPagePWebElement = wd.findElement(mainPagePLocator);
        String mainPagePWebElementText = mainPagePWebElement.getText();
        System.out.println(mainPagePWebElementText);
        Assert.assertEquals(mainPagePWebElementText, "Services for companies of all shapes & sizes");

        By mainPageFullBusinessSolutionsButtonLocator = By.xpath("/html/body/div[5]/div[3]/section[1]/div[2]/div[1]/div/a[1]");
        WebElement mainPageFullBusinessSolutionsButtonElement = wd.findElement(mainPageFullBusinessSolutionsButtonLocator);
        mainPageFullBusinessSolutionsButtonElement.click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        By ExploreTeamsTextLocator = By.xpath("/html/body/div[1]/header/div[1]/p");
        WebElement ExploreTeamsWebElement = wd.findElement(ExploreTeamsTextLocator);
        String ExploreTeamsTextElement = ExploreTeamsWebElement.getText();
        System.out.println(mainPagePWebElementText);
        Assert.assertEquals(ExploreTeamsTextElement, "The enterprise knowledge management platform for more productive and innovative teams.");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        wd.navigate().to("https://stackoverflow.com/");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        By SignUpLocator = By.xpath("/html/body/header/div/nav/ol/li[4]/a");
        WebElement SignUpElement = wd.findElement(SignUpLocator);
        SignUpElement.click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        By JoinStackOverflowTextLocator = By.xpath("/html/body/div[1]/aside/div/h1/div/span/strong");
        WebElement JoinStackOverflowElement = wd.findElement(JoinStackOverflowTextLocator);
        String JoinStackOverflowTextElement = JoinStackOverflowElement.getText();
        System.out.println(mainPagePWebElementText);
        Assert.assertEquals(JoinStackOverflowTextElement, "Join Stack Overflow");

        By SignUpModelEmailLocator = By.xpath("/html/body/div[1]/aside/div/div[1]/div/form/div[1]/div/input");
        WebElement SignUpModelEmailElement = wd.findElement(SignUpModelEmailLocator);
        SignUpModelEmailElement.sendKeys("Здравствуйте, как дела?");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        wd.quit();
    }
}
