
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
public class AlbumSeleniumWebDriverTest {
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
    public void testaCriarAlbum() throws InterruptedException {
        WebElement nomeAlbum = driver.findElement(By.id("formulario1:nomeAlbum"));
        nomeAlbum.sendKeys("Família");
        Thread.sleep(2000L);
        
        WebElement submitBtn = driver.findElement(By.id("formulario1:criarAlbum"));
        submitBtn.click();
        Thread.sleep(2000L);
        
    }
}
