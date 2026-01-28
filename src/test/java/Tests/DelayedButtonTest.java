package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class DelayedButtonTest extends BaseTest {

    @Test(invocationCount = 10)
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

        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement successMessage = shortWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@data-testid='success-message']")
                )
        );

        String messageText = successMessage.getText().trim();

        Assert.assertTrue(
                messageText.contains("Confirmed Successfully"),
                "Success message text is incorrect!"
        );

    }
}

