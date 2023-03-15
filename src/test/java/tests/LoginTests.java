package tests;

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
        String email="vladimir@gmail.com";
        String password="Vova12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);

        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedSuccess());
        // Assert.assertTrue(app.getUser().yallaButtonIsActive());
       // app.getUser().closeDialogContainer();
//        app.getUser().pause(5000);
//        Assert.assertEquals(app.getUser().getMessage(),"Logged in success");
//
//        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test
    public void loginNegativeTestEmail(){
        String email="vladimirgmail.com";
        String password="Vova12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        Assert.assertTrue(app.getUser().isLoggedFailed());

//        Assert.assertTrue(app.getUser().yallaButtonNotActive());
//        Assert.assertEquals(app.getUser().getErrorText(),"It'snot look like email");
//        Assert.assertFalse(app.getUser().isLogged());

    }
    @Test
    public void loginNegativeTestPassword(){
        String email="vladimir@gmail.com";
        String password="vov";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        app.getUser().submitForm();
        Assert.assertEquals(app.getUser().getMessage(),"\"Login or Password incorrect\"");
        app.getUser().closeDialogContainer();
        Assert.assertTrue(app.getUser().isLoginFormDisplayed());
        Assert.assertFalse(app.getUser().isLogged());
    }
    @Test
    public void emptyEmailFieldTest(){
        String email="";
        String password="Vova12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        Assert.assertEquals(app.getUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getUser().yallaButtonNotActive());
        Assert.assertFalse(app.getUser().isLogged());

    }@Test
    public void emptyPasswordFieldTest(){
        String email="vladimir@gmail.com";
        String password="";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        //without clicking on the form field, an empty password error message is not displayed. bug or feature?
        app.getUser().click(By.xpath("//div[@class='login-registration-container']"));
        Assert.assertEquals(app.getUser().getErrorText(),"Password is required");
        Assert.assertTrue(app.getUser().yallaButtonNotActive());
        Assert.assertFalse(app.getUser().isLogged());

    }
@AfterMethod
    public void postCondition(){
        app.getUser().closeDialogContainer();
}
}
