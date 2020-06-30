import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Electronics {
    static WebDriver driver;

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[text()=\"Computers \"] ")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();

        driver.findElement(By.cssSelector("span.close")).click();
        driver.findElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.linkText("Shopping cart")).click();
        String pageText1 =driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).getText();
        System.out.println(pageText1);
        WebDriverWait wait=new WebDriverWait(driver,10);
        String pageText2 =driver.findElement(By.linkText("HTC One Mini Blue")).getText();
        System.out.println(pageText2);
        driver.close();
    }
}
