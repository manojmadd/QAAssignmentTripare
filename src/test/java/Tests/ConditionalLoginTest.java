package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class ConditionalLoginTest extends BaseTest {

    
    @Test
    public void conditionalLoginFlow() {

        openFlakySelectorsTab();

        // Admin login
        driver.findElement(By.xpath("//button[@data-testid='login-admin']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//p[@class='text-purple-300 font-medium']")
        ));
        Assert.assertTrue(driver.findElement(
            By.xpath("//p[@class='text-purple-300 font-medium']")
        ).isDisplayed());
        Assert.assertTrue(driver.findElements(
            By.xpath("//p[@class='text-blue-300 font-medium']")
        ).isEmpty());

        // Logout
        driver.findElement(By.xpath("//button[@data-testid='logout-button']")).click();

        // Standard login
        driver.findElement(By.xpath("//button[@data-testid='login-standard']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//p[@class='text-blue-300 font-medium']")
        ));
        Assert.assertTrue(driver.findElement(
            By.xpath("//p[@class='text-blue-300 font-medium']")
        ).isDisplayed());
        Assert.assertTrue(driver.findElements(
            By.xpath("//p[@class='text-purple-300 font-medium']")
        ).isEmpty());
    }

}
