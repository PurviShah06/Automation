import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.geom.Crossings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Registration_Automation
{
    static WebDriver driver;
    public  static void Sleep1(int time)
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static  void WaitUntilElementClickable(By by,int waittime)
    {
        WebDriverWait wait =new WebDriverWait(driver,waittime);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String GetText(By by)
    {
        return driver.findElement(by).getText();
    }
    public static  void clickable(By by)
    {
        driver.findElement(by).click();
    }
    public static long TimeStamp() {

        return (System.currentTimeMillis());
    }
    public static void SelectDropDownTextvalue(By by, String text){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    public static void SelectDropDownIndexValue(By by, int indexvalue){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);
    }
    public static void SelectDropDownVisibleText(By by, String textvalue){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);
    }
    public static void SendKeyElements(By by,String Text1){
        driver.findElement(by).sendKeys(Text1);
    }
    @BeforeMethod
    public static void ChromeHomeOpen()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    public static void WhenClickablemehtodNotWorking(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
   @AfterMethod
      public static void CloseApplication(){
        driver.close();
    }
    @Test(priority = 0)
    public  void Registration()
    {
        clickable(By.xpath("//a[@class='ico-register']"));
        WaitUntilElementClickable(By.id("register-button"),10);
        clickable(By.xpath("//input[@id=\"gender-female\"]"));
        //WaitUntilElementClickable(By.xpath("\"//input[@id=\\\"FirstName\\\"]\""),30);
        Sleep1(3);
        SendKeyElements(By.xpath("//input[@id=\"FirstName\"]"),"Purvi");
        SendKeyElements(By.xpath("//input[@id=\"LastName\"]"),"Shah");
        SelectDropDownTextvalue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"6");
        SelectDropDownIndexValue(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),5);
        SelectDropDownVisibleText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1981");
        String Email="Textx1+"+TimeStamp()+"@gmail.com";
        SendKeyElements(By.xpath("//input[@id=\"Email\"]"),Email);
        SendKeyElements(By.xpath("//input[@id=\"Company\"]"),"Xyz ltd.");
        SendKeyElements(By.xpath("//input[@id=\"Password\"]"),"polo12");
        SendKeyElements(By.xpath("//input[@id=\"ConfirmPassword\"]"),"polo12");
        clickable(By.xpath("//input[@id=\"Newsletter\"]"));
       // WaitUntilElementClickable(By.xpath("//input[@id=\"register-button\"]"),60);
        Sleep1(3);
        clickable(By.xpath("//input[@id=\"register-button\"]"));
        String expectedText="Your registration completed";
        //WaitUntilElementClickable(By.linkText("Your registration completed"),40);
        Sleep1(3);
        String actualtext= driver.findElement(By.linkText("Your registration completed")).getText();
        Assert.assertEquals(actualtext,expectedText);
        System.out.println(actualtext);
        Sleep1(6);
        WhenClickablemehtodNotWorking(By.xpath("//input[@name=\"register-continue\"]"));
        clickable(By.xpath("//input[@name=\"register-continue\"]"));
        EmailSentVerification();
    }
    public void EmailSentVerification(){
       WaitUntilElementClickable(By.xpath("//a[text()=\"Computers \"]"),10);
        clickable(By.xpath("//a[text()=\"Computers \"]"));
       WaitUntilElementClickable(By.xpath("//a[text()=\" Desktops \"]"),30);
        Sleep1(5);
        clickable(By.xpath("//a[text()=\" Desktops \"]"));
     // WaitUntilElementClickable(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/h2[1]/a"),30);
        Sleep1(5);
         clickable(By.xpath("//div[@class=\"product-grid\"]/div[1]/div[2]/div[1]/div[2]/h2[1]/a"));
     //  WaitUntilElementClickable(By.xpath("//input[@value=\"Email a friend\"]"),30);
        Sleep1(5);
        clickable(By.xpath("//input[@value=\"Email a friend\"]"));
        SendKeyElements(By.xpath("//input[@id=\"FriendEmail\"]"),"friendmail@gmail.com");
        //SendKeyElements(By.xpath("//input[@id=\"YourEmailAddress\"]"),"das");
        SendKeyElements(By.xpath("//textarea[@id=\"PersonalMessage\"]"),"Please Refer Products and Review it");
        clickable(By.xpath("//input[@name=\"send-email\"]"));
    }
    @Test(priority = 1)
    public static void VerificationofElectronicsAddtoCart(){

        WhenClickablemehtodNotWorking(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));
        clickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));//click on Eclectrinics
        WhenClickablemehtodNotWorking(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a"));
        clickable(By.xpath("//div[@class=\"item-grid\"]/div[2]/div[1]/h2/a"));//Clickaction on Cell PhoneButton
        WhenClickablemehtodNotWorking(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));
        clickable(By.xpath("//div[@class=\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));//Select on "Add to cart"
        WaitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]"),80);
        clickable(By.xpath("//div[@class=\"item-grid\"]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]"));
        WhenClickablemehtodNotWorking(By.cssSelector("span.close"));
        clickable(By.cssSelector("span.close"));
        clickable(By.linkText("Shopping cart"));
        String expectedText="HTC One M8 Android L 5.0 Lollipop";
        WaitUntilElementClickable(By.xpath("//tbody/tr[1]/td[4]/a"),40);
        String actualText =GetText(By.xpath("//tbody/tr[1]/td[4]/a"));
        Assert.assertEquals(actualText,expectedText,"");
        System.out.println(actualText);
        String expectedText1="Nokia Lumia 1020";
        WaitUntilElementClickable(By.xpath("//tbody/tr[2]/td[4]/a"),20);
        String actualText1 =GetText(By.xpath("//tbody/tr[2]/td[4]/a"));
        Assert.assertEquals(actualText1,expectedText1);
        System.out.println(actualText1);
    }

}
