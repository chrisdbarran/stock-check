package chris.d.barran;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by chris on 11/07/2017.
 */
public class CheckStock {

    private WebDriver webDriver;

    RichtoneHomePage richtoneHomePage;
    RichtoneSecondHandPage richtoneSecondHandPage;

    String homePage = "http://www.richtonemusic.co.uk/";

    Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");

    @BeforeTest
    public void beforeTest() {

        // Shut up HTMLUnit's ridiculous logging.
        logger.setLevel(Level.OFF);

        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
        driver.get(homePage);
        webDriver = driver;
    }

    @Test(priority = 0)
    public void testGetHomePage() {
        richtoneHomePage = new RichtoneHomePage(webDriver);
        String homePageTitle = richtoneHomePage.getHomePageTitle();
        Assert.assertTrue(homePageTitle.contains("Rich Tone Music Sheffield - Homepage - Rich Tone Music"));
    }

    @Test(priority = 1)
    public void testClickSecondHandTab() {

        richtoneSecondHandPage = richtoneHomePage.goToSecondHandPage();
        Assert.assertTrue(richtoneSecondHandPage.getSecondHandPageTitle().contains("2nd Hand - Rich Tone Music"));
    }
}
