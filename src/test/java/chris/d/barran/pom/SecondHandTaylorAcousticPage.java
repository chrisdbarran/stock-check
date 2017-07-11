package chris.d.barran.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/07/2017.
 */
public class SecondHandTaylorAcousticPage {
    private WebDriver webDriver;

    By mainContainerId = By.id("main_container");

    public SecondHandTaylorAcousticPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String title() {
        return webDriver.getTitle();
    }

    public boolean hasGuitarsInStock() {
        WebElement mainContainer = webDriver.findElement(mainContainerId);
        List<WebElement> itemsInStock = mainContainer.findElements(By.className("stock_1"));
        return !itemsInStock.isEmpty();
    }

    public List<Guitar> findGuitarsOnPage() {
        WebElement mainContainer = webDriver.findElement(mainContainerId);
        List<WebElement> summaryItems = mainContainer.findElements(By.className("summary_item"));

        List<Guitar> guitars = new ArrayList<Guitar>();

        for(WebElement item : summaryItems)
        {
            // summary_image
            // summary_description
            String description = item.findElement(By.cssSelector("div.summary_description > a")).getText();
            // #main_container > div > div:nth-child(1) > div.summary_sub-price > a > span
            String stock = item.findElement(By.cssSelector("div.summary_sub-price > a > span")).getText();

            // div.summary_image > a
            String url = item.findElement(By.cssSelector("div.summary_image > a")).getAttribute("href");

            //div.summary_sub-price > a > strong
            String price = item.findElement(By.cssSelector("div.summary_sub-price > a > strong")).getText();

            guitars.add(new Guitar(description,price,stock,url));
        }

        return guitars;
    }
}
