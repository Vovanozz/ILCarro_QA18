package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test
    public void typeSearchForm(){
    app.getSearch().fillSearchForm();
    app.getSearch().submitSearchForm();
        Assert.assertTrue(app.getSearch().isElementPresent(By.xpath("//div[@class='search-results']")));



    }

}
