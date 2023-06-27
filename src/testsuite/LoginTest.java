package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    // Create a Calss userShouldNavigateToLoginPageSuccessfully

    /**
     * userShouldNavigateToLoginPageSuccessfully
     * click on the ‘Sign In’ link
     * Verify the text ‘Welcome Back!’
     */

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        /**
         * click on the ‘Sign In’ link
         * Enter invalid username
         * Enter invalid password
         * Click on Login button
         * Verify the error message ‘Invalid email or password.’
         */
        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        // Enter invalid username
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("komprim@gmail.com");

        // Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("komprim@gmail.com");

        // Click on Login button
        driver.findElement(By.xpath("//button[@data-sitekey='6LdhwsclAAAAAHilv5EFCsSoCU6bTSlfgfuMFlBm']")).click();

        // Verify the error message ‘Invalid email or password.’

        String expectedText = "Invalid email or password.";

        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() { closeBrowser();
    }
}
