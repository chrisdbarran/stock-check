package chris.d.barran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by chris on 11/07/2017.
 */
public class RichtoneSecondHandPage {

    private WebDriver webDriver;


    public RichtoneSecondHandPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getSecondHandPageTitle(){
        return webDriver.getTitle();
    }
}
