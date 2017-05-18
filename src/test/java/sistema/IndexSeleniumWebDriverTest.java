
package sistema;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Edilva
 */
public class IndexSeleniumWebDriverTest {
    
    private static WebDriver driver;
    
    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @Before
    public void setUp() {
        driver.get("http://localhost:8080/avaliacao-praticas/faces/index.xhtml");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
    
    @Test
    public void testaTituloDaPagina(){
        assertEquals("Álbuns", driver.getTitle());
    }
    
    @Test
    public void testaIndex() throws InterruptedException {
    
        WebElement submitBtn = driver.findElement(By.id("index"));
        submitBtn.click();
        Thread.sleep(2000L);
        
        String currentUrl = driver.getCurrentUrl();
        
        assertEquals("http://localhost:8080/avaliacao-praticas/faces/index.xhtml", currentUrl);
        
    }
}
