package uk.sponte.automation.seleniumpom.tests.mock;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import uk.sponte.automation.seleniumpom.PageFactory;
import uk.sponte.automation.seleniumpom.dependencies.DependencyFactory;

/**
 * Created by n450777 on 30/11/2015.
 * Verifies that user can add factories for objects
 */
public class RegisteringCustomFactoriesTests {

    @Test
    public void canUseAlternativeWebDriverFactory() {

        DependencyFactory<WebDriver> driverFactory = new DependencyFactory<WebDriver>() {
            @Override
            public WebDriver get() {
                return new ChromeDriver();
            }
        };

        PageFactory pageFactory = new PageFactory(driverFactory);
        WebDriver driver = pageFactory.getDriver();
        Assert.assertEquals(EventFiringWebDriver.class, driver.getClass());
        driver.quit();
    }
}
