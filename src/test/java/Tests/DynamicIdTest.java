package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class DynamicIdTest extends BaseTest {

    @Test
    public void dynamicIdHandling() {
    	openFlakySelectorsTab();
        driver.findElement(By.xpath("//button[@data-testid='regenerate-ids']")).click();

        driver.findElement(By.xpath("//div[@data-name='Beta']")).click();

//        AssertJUnit.assertTrue(driver.getPageSource().contains("Beta"));
        Assert.assertEquals(
        	    driver.findElement(By.xpath("//div[@data-testid='selected-item']")).getText().trim(),
        	    "Selected: Beta"
        	);
    }
}

