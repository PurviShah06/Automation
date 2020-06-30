import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class computer
{
    static WebDriver driver;

    public static void main(String[] args)
    {  System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[text()=\"Computers \"] ")).click();
        //  driver.findElement(By.xpath("//a[text()=\"Desktops \" ]")).;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a")).click();
        String pageText=driver.findElement(By.xpath("//a[text()= \"Build your own computer\"]")).getText();
        System.out.println(pageText);
        driver.close();
    }
}
