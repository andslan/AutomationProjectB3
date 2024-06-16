package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {

     /*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset password
    5. validate - Enter the email address associated with yor account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */

    public static void main(String[] args) throws InterruptedException {
        // 1. open chrome
        // 2. go to docuport

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        // 3. click on forgot password
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        // 4. validate url contains: reset-password
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(DocuportConstants.RESET_PASSWORD)) {
            System.out.println("Actual url matches expected one");
        } else {
            System.err.println("Actual url does NOT match expected one");
        }

        WebElement validatedMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));
        String actualValidatedMessage = validatedMessage.getText();

        if (actualValidatedMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }

        // 6.
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if (cancelButton.isDisplayed()) {
            System.out.println("Test passed - cancel is displayed");
        } else {
            System.err.println("Test failed - cancel is NOT displayed");
        }

        if (sendButton.isDisplayed()) {
            System.out.println("Test passed - send is displayed");
        } else {
            System.err.println("Test failed - send is NOT displayed");
        }

        // 9. click send

        sendButton.click();

        Thread.sleep(3000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(3000);

        String actualSuccessMessage = successMessage.getText();

        // System.out.println("actualSuccessMessage = " + actualSuccessMessage);

        try{
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }




    }
}
