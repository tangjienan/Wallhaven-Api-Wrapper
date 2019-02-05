package api;

import model.Thumb;
import model.Wallpaper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by donezio on 1/27/19.
 */
public class WebDriver {
    static {
        System.setProperty("webdriver.gecko.driver", "/Users/macbookpro/Desktop/wallhaven_api_wrapper/chromedriver");
    }

    public List<Thumb> getTumbsFromUrl(String url) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(url);


        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("thumbs")));

        List<WebElement> lists = myDynamicElement.findElements(By.tagName("li"));
        System.out.println(lists.size());

        List<Thumb> res = new ArrayList<Thumb>();

        for (WebElement e : lists) {
            WebElement figure = e.findElement(By.tagName("figure"));
            String id =  figure.getAttribute("data-wallpaper-id");
            WebElement img = figure.findElement(By.tagName("a"));
            String picUrl = img.getAttribute("href");
            String[] dimension = figure.findElement(By.className("thumb-info")).findElement(By.className("wall-res")).getAttribute("innerHTML").split("x");
            Thumb tmp = new Thumb(Integer.parseInt(dimension[0].trim()),Integer.parseInt(dimension[1].trim()), id, picUrl);
            res.add(tmp);
        }

        return res;
    }


    public Wallpaper getWallpaperFromUrl(String str) {
        //TODO: add login support
        boolean login = false;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://alpha.wallhaven.cc/wallpaper/" + str);


        WebElement wallpaper = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("wallpaper")));

        WebElement info = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("sidebar-content")));

        String[] resolution = info.findElement(By.tagName("h3")).getAttribute("innerHTML").split("x");

        String height = resolution[0].trim();
        String width = resolution[1].trim();

        List<WebElement> tags = info.findElement(By.id("tags")).findElements(By.tagName("li"));

        Set<String> tagsSet = new HashSet<>();
        for (WebElement e : tags) {
            e = e.findElement(By.tagName("a"));
            tagsSet.add(e.getAttribute("innerHTML"));
        }

        //List<WebElement> purityElements = info.findElement(By.id("wallpaper-purity-form")).findElements(By.tagName("label"));
        List<WebElement> purityElements = info.findElement(By.id("wallpaper-purity-form")).findElements(By.xpath("*"));
        // purity tag

        String purity = "";
        if (login) {
            for (WebElement e : purityElements) {
                System.out.println(e.getTagName());
            }
        } else {
            for (int i = 0; i < purityElements.size(); i++) {

                if (purityElements.get(i).getAttribute("checked") != null && purityElements.get(i).getAttribute("checked").equals("true")) {
                    purity = purityElements.get(i + 1).getAttribute("innerHTML");
                    i = i + 1;
                }
            }
        }

        WebElement properties = info.findElement(By.tagName("dl"));
        List<WebElement> es = properties.findElements(By.tagName("dd"));
        WebElement link = info.findElement(By.className("blockform"));


        String favorites = "";
        try
        {
            favorites = es.get(4).findElement(By.tagName("a")).getAttribute("innerHTML");
        }
        catch (NoSuchElementException ee)
        {
            if (ee.toString().contains("NoSuchElementException"))
            {
                favorites = "0";
            }
        }
        String tinyUrl = link.findElement(By.tagName("input")).getAttribute("value");
        String fullUrl = wallpaper.getAttribute("src");
        String alt = wallpaper.getAttribute("alt");
        String id = wallpaper.getAttribute("data-wallpaper-id");
        String uploader = es.get(0).findElement(By.className("username")).getAttribute("innerHTML");
        String time = es.get(0).findElement(By.tagName("time")).getAttribute("innerHTML");
        String category = es.get(1).getAttribute("innerHTML");
        String size = es.get(2).getAttribute("innerHTML");
        String views = es.get(3).getAttribute("innerHTML");


        Wallpaper wallpaperObj = new Wallpaper(height,width,alt, id, fullUrl);
        wallpaperObj.addProperty("TinyUrl", tinyUrl);
        wallpaperObj.addProperty("FullUrl", fullUrl);
        wallpaperObj.addProperty("Alt", alt);
        wallpaperObj.addProperty("Id", id);
        wallpaperObj.addProperty("Uploader", uploader);
        wallpaperObj.addProperty("TimeCreated", time);
        wallpaperObj.addProperty("Category", category);
        wallpaperObj.addProperty("Size", size);
        wallpaperObj.addProperty("Views", views);
        wallpaperObj.addProperty("Purity", purity);
        wallpaperObj.setTages(tagsSet);


        return wallpaperObj;
    }
}
