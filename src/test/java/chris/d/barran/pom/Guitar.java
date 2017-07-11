package chris.d.barran.pom;

/**
 * Created by chris on 11/07/2017.
 */
public class Guitar {

    private String description;
    private String price;
    private String stock;
    private String url;

    public Guitar(String description, String price, String stock, String url) {
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return description + " - " + price + " - " + stock;
    }
}
