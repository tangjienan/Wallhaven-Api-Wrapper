import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

/**
 * Created by donezio on 1/26/19.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "/Users/macbookpro/Desktop/wallhaven_api_wrapper/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://alpha.wallhaven.cc/toplist");


        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("thumbs")));


        List<WebElement> lists = myDynamicElement.findElements(By.tagName("li"));
        System.out.println(lists.size());

        for (WebElement e : lists) {
            String str =  e.findElement(By.tagName("figure")).getAttribute("data-wallpaper-id");
            System.out.println(str);
        }

        //System.out.println(myDynamicElement);

    }
}
