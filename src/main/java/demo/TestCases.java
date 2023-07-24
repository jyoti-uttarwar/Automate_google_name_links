package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//import org.junit.Assert;
import org.openqa.selenium.By;

//Selenium Imports
import org.openqa.selenium.WebElement;




public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    
    public void TC_PostOnLinkedin() throws InterruptedException{
        System.out.println("Start Test case: TC_PostOnLinkedin");
        // Load the url  "https://www.linkedin.com/"
        driver.get("https://www.linkedin.com/");
        Thread.sleep(1000);
        // Locate the Email Id Using Locator "ID" "session_key"
        WebElement eleUserId = driver.findElement(By.id("session_key"));
        // Enter emailId  "abc1234@gmail.com"
        eleUserId.sendKeys("abc1234@gmail.com");
        // Locate password Using Locator "ID" "session_password"
        WebElement elePassword = driver.findElement(By.id("session_password"));
        // Enter password  "abc1234"
        elePassword.sendKeys("abc1234");
        // Locate & click "SignIn" button Using Locator "XPath" "//button[@data-id='sign-in-form__submit-btn']"
        WebElement eleSignInBtn = driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
        eleSignInBtn.click();

        Thread.sleep(1000);       
        
        //Locate & click "Analytics & tools" Using Locator "XPath" "//div[contains(@class,'feed-identity-module artdeco-card overflow-hidden mb2')]/a[@href='/dashboard/']"
        driver.findElement(By.xpath("//div[contains(@class,'feed-identity-module artdeco-card overflow-hidden mb2')]/a[@href='/dashboard/']")).click();
        Thread.sleep(1000);   
        // Locate & store "Profile viewer" Using Locator "XPath" "(//p[@class='text-body-large-bold t-black'])[3]"
        WebElement eleProfileViewer = driver.findElement(By.xpath("(//p[@class='text-body-large-bold t-black'])[3]"));
        // Print the "Profile Viewers"  
        System.out.println("Total Profile Viewer : " + eleProfileViewer.getText());
        // Locate & store "Post Impressions"  Using Locator "XPath" "(//p[@class='text-body-large-bold t-black'])[1]"
        WebElement elePostImpressions = driver.findElement(By.xpath("(//p[@class='text-body-large-bold t-black'])[1]"));
        // Print the "Post Impressions" 
        System.out.println("Total Post Impressions : " + elePostImpressions.getText()); 
        // Navigate to back page  
        driver.navigate().back();
        Thread.sleep(500);
        // Locate & click "Start a Post"  Using Locator "XPath" "//div[contains(@class,'share-box-feed-entry__top-bar')]/button"
        driver.findElement(By.xpath("//div[contains(@class,'share-box-feed-entry__top-bar')]/button")).click();
        Thread.sleep(500);        
        // Ckeck Post To status  Using Locator "XPath" "//div[contains(@class,'truncate artdeco-entity-lockup__subtitle ember-view')]"
        WebElement elePostTo = driver.findElement(By.xpath("//div[contains(@class,'truncate artdeco-entity-lockup__subtitle ember-view')]"));
        // If the status is not "Connection only" then select the status as same   
        //     1. Locate & click "Post To" button Using Locator "XPath" "//button[contains(@class,'share-unified-settings-entry-button')]"
        //     2. Locate & Select "Connection Only" option Using Locator "XPath" "//button[contains(@id,'CONNECTIONS_ONLY')]"
        //     3. Locate & click on "Done"  Using Locator "XPath" "//div[contains(@class,'share-box-footer__main-actions')]/button[2]"
        if(!elePostTo.getText().contains("Connections Only"))
        {
            driver.findElement(By.xpath("//button[contains(@class,'share-unified-settings-entry-button')]")).click();
            driver.findElement(By.xpath("//button[contains(@id,'CONNECTIONS_ONLY')]")).click();
            driver.findElement(By.xpath("//div[contains(@class,'share-box-footer__main-actions')]/button[2]")).click();
            Thread.sleep(500);
        }
        String strPost = "The future depends on what you do today.";
        // Locate & Enter the text to post  Using Locator "XPath" "//div[contains(@class,'ql-editor ql-blank')]/p"
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]/p")).sendKeys(strPost);
        // Locate & click "Post" button Using Locator "XPath" "//span[text()='Post']"
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(500);
        // Verify the status of post & print on console Using Locator "XPath" "//p[@class='artdeco-toast-item__message']/span"
        WebElement elePostStatus = driver.findElement(By.xpath("//p[@class='artdeco-toast-item__message']/span"));
        if(elePostStatus.getText().contains("Post successful."))
         System.out.println("Post successful.");
        else
         System.out.println("Post does not successful.");        
        System.out.println("end Test case: TC_PostOnLinkedin");
    }
}
 