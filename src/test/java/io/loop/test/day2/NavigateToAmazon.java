package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {

    /*
    navigate to amazon
    maximize
    navigate back
    navigate forward
    refresh
    */

    public static void main(String[] args) throws InterruptedException {
        // create an instance pf webdriver
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }

}
