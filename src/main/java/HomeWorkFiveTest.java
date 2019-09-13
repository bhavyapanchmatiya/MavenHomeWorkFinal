import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HomeWorkFiveTest {

    protected static WebDriver driver;



    public static String rendomDate(){

        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");

        return format.format(new Date());
    }

    public static void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }}

    @BeforeMethod

    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        //Open the Browser
        driver = new ChromeDriver();
        //Maximise the Browser window screen
        driver.manage().window().fullscreen();
        //Set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Open the website
        driver.get("https://demo.nopcommerce.com/");

    }


    @Test
    public void UserShouldBeAbleToRegisterSuccessfully(){

        //Click on Register Button
        driver.findElement(By.linkText("Register")).click();
        //Enter First Name
        driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Bhavya");
        //Enter Last Name
        driver.findElement(By.id("LastName")).sendKeys("Panchmatiya");
        //Enter Email
        driver.findElement(By.name("Email")).sendKeys("Bhavyah" + rendomDate() + "@gmail.com");
        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("abcd123");
        //Enter Confirm Password
        driver.findElement(By.xpath("//input[@data-val-equalto-other='*.Password']")).sendKeys("abcd123");
        //Click on Register
        driver.findElement(By.xpath("//input[@class='button-1 register-next-step-button']")).click();
        //Expected Result
        String expectedResults = ("Your registration completed");
        //Actual Result
        String actualResults = driver.findElement(By.xpath("//div[@class='result']")).getText();
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResults,expectedResults);
    }




    @Test
    public void UserShouldBeAbleToRefferAProductToFriend(){
        //Click on Register Button
        driver.findElement(By.linkText("Register")).click();
        //Enter First Name
        driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Bhavya");
        //Enter Last Name
        driver.findElement(By.id("LastName")).sendKeys("Panchmatiya");
        //Enter Email
        driver.findElement(By.name("Email")).sendKeys("Bhavya" + rendomDate() +"@gmail.com");
        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("abcd123");
        //Enter Confirm Password
        driver.findElement(By.xpath("//input[@data-val-equalto-other='*.Password']")).sendKeys("abcd123");
        //Click on Register
        driver.findElement(By.xpath("//input[@class='button-1 register-next-step-button']")).click();
        //Back to Homepage
        driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
        //Click on Macbook Pro 13 inch
        driver.findElement(By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']")).click();
        //Click on Email a Friend
        driver.findElement(By.xpath("//input[@value='Email a friend']")).click();
        //Type Friend's Email
        driver.findElement(By.name("FriendEmail")).sendKeys("patel.mitesh20@gmail.com");
        //Type Personal Message
        driver.findElement(By.xpath("//textarea[@class='your-email']")).sendKeys("Yo buy me this laptop bro :)");
        //Click on Send Email
        driver.findElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']")).click();
        //Expected Result
        String expectedResults = ("Your message has been sent.");
        //Actual Result
        String actualResults = driver.findElement(By.xpath("//div[@class='result']")).getText();
        //Comparision between Actual Result and Expected Result
        Assert.assertEquals(actualResults,expectedResults);
    }

    @ Test
    public void UserShouldBeNavigateToCameraAndPhotoPage(){
        //Click on Electronics
        driver.findElement(By.xpath("//h2/a[@title='Show products in category Electronics']")).click();
        //Click on Camera & Photo
        driver.findElement(By.xpath("//div/h2/a[@title='Show products in category Camera & photo']")).click();
        //Expected Result
        String expectedResult = ("Nikon D5500 DSLR");
        //Actual Result
        String actualResult = driver.findElement(By.linkText("Nikon D5500 DSLR")).getText();
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResult,actualResult);
    }


    @Test

    public void UserShouldBeAbleToSelectJewelleryBetween$700To$3000 (){
        //Click on Jewellery
        driver.findElement(By.linkText("Jewelry")).click();
        //Select $700 to $3000
        driver.findElement(By.xpath("//a[@href='//demo.nopcommerce.com/jewelry?price=700-3000']")).click();
        //Expected Result
        String expectedResult = driver.findElement(By.className("product-title")).getText();
        //Actual Result
        String actualResult = driver.findElement(By.linkText("Vintage Style Engagement Ring")).getText();
        //Comparision of Expected Result and Actual Result
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test


    public void UserShouldBeAbleToAddTwoBooksInShoppingBasket (){

        //Click on Books
        driver.findElement(By.linkText("Books")).click();
        //Add First Book to Cart
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[3]/div[2]/input[1]")).click();
        sleep(10000);
        //Add Another Book to Cart
        driver.findElement(By.xpath("//input[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/38/1/1\"),!1']")).click();
        //Click on Shopping Cart
        driver.findElement(By.linkText("Shopping cart")).click();
        //Expected Result
        String expectedResult = ("Discount Code");
        //Actual Result
        String actualResult = driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[1]/div[1]/div[1]/div[1]/strong")).getText();
        //Comparision with Expected and Actual Result
        Assert.assertEquals(expectedResult,actualResult);
    }




    @AfterMethod
    public void browserClose() {
        //driver.quit();

    }
}







