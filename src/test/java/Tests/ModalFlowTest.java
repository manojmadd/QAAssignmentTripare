package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class ModalFlowTest extends BaseTest {

    @Test
    public void modalConfirmationFlow() {
    	
    	openResponsiveTab();
        driver.findElement(By.xpath("//button[@data-testid='open-modal']")).click();

        driver.findElement(By.xpath("//button[@data-testid='show-nested']")).click();
        driver.findElement(By.xpath("//button[@data-testid='final-confirm']")).click();

        Assert.assertEquals(
        	    driver.findElement(By.xpath("//div[@data-testid='modal-result']")).getText().trim(),
        	    "Result: confirmed"
        );

    }
}

