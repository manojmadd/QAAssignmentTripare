package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://claude.ai/public/artifacts/1e02a9a5-4f20-4f19-a7ba-6c3f16c6eab9");
        
        acceptCookiesIfPresent();
        switchToClaudeFrame();  // ✅ Added here
    }

    protected void acceptCookiesIfPresent() {
        try {
            WebElement acceptBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-testid='consent-accept']")
                )
            );
            acceptBtn.click();
        } catch (Exception e) {
            // Cookie popup not shown → continue
        }
    }

    // ✅ New method for frame switch and Timing tab
    protected void switchToClaudeFrame() {
        wait.until(
            ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[@title='Claude content']")
            )
        );
    }
    protected void openTimingChallengesTab() {
        WebElement timingTab = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(normalize-space(),'Timing Challenges')]")
            )
        );
        timingTab.click();
    }
    protected void openFlakySelectorsTab() {
        WebElement flakySelector = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-tab='selectors']")
            )
        );
        flakySelector.click();
    }
    
    protected void openResponsiveTab() {
        WebElement openResponsiveTab = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-tab='responsive']")
            )
        );
        openResponsiveTab.click();
    }
    



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
