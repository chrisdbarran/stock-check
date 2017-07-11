package chris.d.barran.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by chris on 11/07/2017.
 */
public class SecondHandPage {

    private WebDriver webDriver;

    By secondHandAcousticLink = By.linkText("Acoustic Guitars");


    public SecondHandPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String title(){
        return webDriver.getTitle();
    }

    public SecondHandAcousticPage navigateToSecondHandAcousticPage() {
        WebElement link = webDriver.findElement(secondHandAcousticLink);
        link.click();
        return new SecondHandAcousticPage(webDriver);
    }
}
