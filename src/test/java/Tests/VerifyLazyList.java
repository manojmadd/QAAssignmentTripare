package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class VerifyLazyList extends BaseTest {

    @Test
    public void verifyLazyList() {

    	    openTimingChallengesTab();
    	    By loadMoreBtn = By.xpath("//button[@data-testid='load-more']");
    	    By itemList = By.xpath("//div[@data-testid='item-list']/div");

    	    for (int i = 0; i < 3; i++) {
    	        // Click load more
    	        driver.findElement(loadMoreBtn).click();

    	        // Wait for new items to load
    	        int previousCount = driver.findElements(itemList).size();
    	        wait.until(driver -> driver.findElements(itemList).size() > previousCount);
    	    }

    	    // After all clicks, get all items
    	    List<WebElement> items = driver.findElements(By.xpath("//div[@data-testid='item-list']/div"));

    	    // Assert total items = 15
    	    Assert.assertEquals(items.size(), 15, "Expected 15 items after 3 load more clicks");

    	    // Check for active and pending text
    	    boolean hasActive = items.stream().anyMatch(e -> e.getText().contains("active"));
    	    boolean hasPending = items.stream().anyMatch(e -> e.getText().contains("pending"));

    	    Assert.assertTrue(hasActive && hasPending, "Expected both active and pending items");
    	
    }
}

