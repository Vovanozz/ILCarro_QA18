package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
    @Test
    public void loginPositiveTest(){
        User user= User.builder()
                .email("vladimir@gmail.com")
                .password("Vova12345$")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }
    @Test
    public void loginNegativeTestEmail(){
        User user= User.builder()
                .email("vladimirgmail.com")
                .password("Vova12345$")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        Assert.assertTrue(app.getUser().isLoggedFailed());

//        Assert.assertTrue(app.getUser().yallaButtonNotActive());
//        Assert.assertEquals(app.getUser().getErrorText(),"It'snot look like email");
//        Assert.assertFalse(app.getUser().isLogged());

    }
    @Test
    public void loginNegativeTestPassword(){
        User user= User.builder()
                .email("vladimir@gmail.com")
                .password("vov")
                .build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
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
