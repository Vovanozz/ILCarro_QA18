package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

public void fillSearchForm(){

   type(By.id("city"), "Tel Aviv");
   wd.findElement(By.cssSelector(".pac-item")).click();
   wd.findElement(By.id("dates")).click();
   wd.findElement(By.xpath("//div[@class='mat-calendar-arrow']")).click();
   wd.findElement(By.xpath("//div[text()= 2024 ]")).click();
   wd.findElement(By.xpath("//div[text()=' MAR ']")).click();
   wd.findElement(By.xpath("//div[contains(text(),'16')]")).click();
   wd.findElement(By.xpath("//div[contains(text(),'21')]")).click();


}
    public void submitSearchForm(){
        wd.findElement(By.cssSelector("button[type='submit']")).submit();
    }
}
