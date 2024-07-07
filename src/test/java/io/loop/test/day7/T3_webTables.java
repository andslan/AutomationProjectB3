package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class T3_webTables extends TestBase {

    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, "advisor");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement user = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        user.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        assertEquals(actualFullName,expectedFullName, "Actual matches expected");

        System.out.println("actualFullName = " + actualFullName);

    }
}
