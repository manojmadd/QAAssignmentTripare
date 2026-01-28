package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class DelayedButtonTest extends BaseTest {

    @Test
    public void delayedButtonFlow() {
    	openTimingChallengesTab();
        WebElement startProcessBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Start Process']")
                )
        );
        startProcessBtn.click();

        WebElement confirmBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-testid='confirm-button']")
            )
        );

        confirmBtn.click();

        Assert.assertTrue(
            driver.getPageSource().contains("Action Completed Successfully!"),
            "Success message not visible"
        );
    }
}

