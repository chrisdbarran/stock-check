package chris.d.barran;

import chris.d.barran.pom.Guitar;
import chris.d.barran.pom.SecondHandTaylorAcousticPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
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
public class TaylorMiniInStock {

    private WebDriver webDriver;

    SecondHandTaylorAcousticPage secondHandTaylorAcousticPage;

    // Put's as many on one page as possible
    String secondHandTaylorAcousticPageUrl = "http://www.richtonemusic.co.uk/second_hand/acoustic_guitars/taylor.asp";

    Logger logger = Logger.getLogger("com.gargoylesoftware.htmlunit");

    @BeforeTest
    public void beforeTest() {

        // Shut up HTMLUnit's ridiculous logging.
        logger.setLevel(Level.OFF);

        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
        driver.get(secondHandTaylorAcousticPageUrl);
        webDriver = driver;
    }

    @Test(priority = 0)
    public void testHaveNoSecondHandTaylorMiniInStock() {

        String modelRegEx = ".*GS.Mini.*";


        secondHandTaylorAcousticPage = new SecondHandTaylorAcousticPage(webDriver);

        List<Guitar> guitars = secondHandTaylorAcousticPage.findGuitarsOnPage();

        List<Guitar> guitarsInStock = guitars.stream().filter(g -> g.getStock().equalsIgnoreCase("In-Stock") && g.getDescription().matches(modelRegEx)).collect(Collectors.toList());

        guitarsInStock.forEach((guitar) -> { System.out.println(guitar);});

        Assert.assertTrue(guitarsInStock.size() == 0);
    }
}
