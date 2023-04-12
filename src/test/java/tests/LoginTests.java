package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void loginPositiveTest(User user) {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }
    @Test
    public void loginPositiveTestConfig() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }
    @Test(dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
    public void loginPositiveTestFromFile(User user) {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }


    @Test
    public void loginNegativeTestWrongEmail() {
        User data = new User().withEmail("vladimirgmail.com").withPassword("Vova12345$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        Assert.assertTrue(app.getUser().isLoggedFailed());
    }




    @Test
    public void loginNegativeTestPassword(){
       User data=new User().withEmail("vladimir@gmail.com").withPassword("vova12345");
        app.getUser().openLoginForm();
       app.getUser().fillLoginForm(data);
        app.getUser().submitForm();
        Assert.assertEquals(app.getUser().getMessage(),"\"Login or Password incorrect\"");
        app.getUser().closeDialogContainer();
        Assert.assertTrue(app.getUser().isLoginFormDisplayed());
        Assert.assertFalse(app.getUser().isLogged());
    }

@AfterMethod
    public void postCondition(){
        app.getUser().closeDialogContainer();
}
}
