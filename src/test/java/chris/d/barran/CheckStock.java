package chris.d.barran;


import chris.d.barran.pom.*;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by chris on 11/07/2017.
 */
public class CheckStock {

    private WebDriver webDriver;

    HomePage homePage;
    SecondHandPage secondHandPage;
    SecondHandAcousticPage secondHandAcousticPage;
    SecondHandTaylorAcousticPage secondHandTaylorAcousticPage;

    String homePageUrl = "http://www.richtonemusic.co.uk/";

    Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");

    @BeforeTest
    public void beforeTest() {

        // Shut up HTMLUnit's ridiculous logging.
        logger.setLevel(Level.OFF);

        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
        driver.get(homePageUrl);
        webDriver = driver;
    }

    @Test(priority = 0)
    public void testNavigateToHomePage() {
        homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.title().contains("Rich Tone Music Sheffield - Homepage - Rich Tone Music"));
    }

    @Test(priority = 1)
    public void testNavigateToSecondHandPage() {
        secondHandPage = homePage.navigateToSecondHandPage();
        Assert.assertTrue(secondHandPage.title().contains("2nd Hand - Rich Tone Music"));
    }

    @Test(priority = 2)
    public void testNavigateToSecondHandAcousticPage() {
        secondHandAcousticPage = secondHandPage.navigateToSecondHandAcousticPage();
        Assert.assertTrue(secondHandAcousticPage.title().contains("2nd Hand Acoustic Guitars - Rich Tone Music"));
    }

    @Test(priority = 3)
    public void testNavigateToSecondHandTaylorAcousticPage() {
        secondHandTaylorAcousticPage = secondHandAcousticPage.navigateToSecondHandTaylorAcousticPage();
        Assert.assertTrue(secondHandTaylorAcousticPage.title().contains("2nd Hand Taylor Acoustic Guitars - Rich Tone Music"));
    }

    @Test(priority = 4)
    public void testHaveTaylorGuitarsInStock() {
        Assert.assertTrue(secondHandTaylorAcousticPage.hasGuitarsInStock());
    }


}
