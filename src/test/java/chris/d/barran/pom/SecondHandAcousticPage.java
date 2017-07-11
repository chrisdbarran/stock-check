package chris.d.barran.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by chris on 11/07/2017.
 */
public class SecondHandAcousticPage {

    private WebDriver webDriver;

    By secondHandTaylorAcousticLink = By.linkText("Taylor");


    public SecondHandAcousticPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String title(){
        return webDriver.getTitle();
    }

    public SecondHandTaylorAcousticPage navigateToSecondHandTaylorAcousticPage() {
        WebElement link = webDriver.findElement(secondHandTaylorAcousticLink);
        link.click();
        return new SecondHandTaylorAcousticPage(webDriver);
    }
}
