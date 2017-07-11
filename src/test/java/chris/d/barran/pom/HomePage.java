package chris.d.barran.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by chris on 11/07/2017.
 */
public class HomePage {

    private WebDriver webDriver;

    By secondHandLink = By.linkText("2nd Hand");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String title(){
        return webDriver.getTitle();
    }

    public SecondHandPage navigateToSecondHandPage() {
        WebElement link = webDriver.findElement(secondHandLink);
        link.click();
        return new SecondHandPage(webDriver);
    }

}
