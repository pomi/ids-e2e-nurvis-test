import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by omm on 6/23/2017.
 */
public class SeleniumTest {
    static String url = "https://nl.integration.thomascook.io/search?resortCode=spanje-mallorca-alle&goingTo=Mallorca%2C%20Spanje&depAirport=0&sbDepAirport=0&origin=Alle%20luchthavens&flexible=true&when=20170716&duration=15&occupation=2&departureDate=20170713%2C20170719&start=0&end=9&sort=recommendation_asc&brochureName=1";

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}
