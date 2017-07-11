package chris.d.barran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by chris on 11/07/2017.
 */
public class RichtoneHomePage {

    private WebDriver webDriver;

    By secondHandLink = By.linkText("2nd Hand");

    public RichtoneHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getHomePageTitle(){
        return webDriver.getTitle();
    }

    public RichtoneSecondHandPage goToSecondHandPage() {
        WebElement link = webDriver.findElement(secondHandLink);
        link.click();
        return new RichtoneSecondHandPage(webDriver);
    }

}
