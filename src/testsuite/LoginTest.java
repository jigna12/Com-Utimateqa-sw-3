package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

/*1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’*/

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")); //Find SingIn and click on the ‘Sign In’ link
        String ActualMsg = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        System.out.println("Actual Message:" +ActualMsg);
        messageValidation("Welcome Back!",ActualMsg);//Validate actual and expected message
    }
    /*2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
 or password.'*/

    @Test
    public void verifyTheErrorMessage()
    {
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")); //Find SingIn and click on the ‘Sign In’ link
        sendTextToElement(By.id("user[email]"),"Prime Testing");//Find the username text and Enter the invalid username
        sendTextToElement(By.name("user[password]"),"Prime123");//Find the password text and Enter the invalid password
        clickOnElement(By.cssSelector("input.button"));//Find the signin button and click on
        String ActualMsg = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        System.out.println("Actual Message =" +ActualMsg);
        messageValidation("Invalid email or password.",ActualMsg);//Validate actual and expected message
    }
    @After
    public void closedown()
    {
        closeBrowser();
    }
}
