package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
}
@Test
    public void registrationPositiveTest(){
        app.getUser().openRegistrationForm();
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        String name="Jon";
        String lastName="Snow";
        String email="jonsnow"+i+"@gmail.com";
        String password="JonSnow12345$";
        app.getUser().fillRegistrationForm(name,lastName,email,password);
        app.getUser().clickCheckBox();
        app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isRegisteredSuccess());
    Assert.assertTrue(app.getUser().isLogged());

}@Test
    public void registrationEmailNegativeTest(){
        app.getUser().openRegistrationForm();
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        String name="Jon";
        String lastName="Snow";
        String email="jonsnow"+i+"gmail.com";
        String password="JonSnow12345$";
        app.getUser().fillRegistrationForm(name,lastName,email,password);
        app.getUser().clickCheckBox();
    Assert.assertTrue(app.getUser().isRegisteredFailedFromEmail());
    Assert.assertFalse(app.getUser().isLogged());
    Assert.assertTrue(app.getUser().yallaButtonNotActive());

}@Test
    public void registrationPasswordNegativeTest(){
        app.getUser().openRegistrationForm();
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        String name="Jon";
        String lastName="Snow";
        String email="jonsnow"+i+"@gmail.com";
        String password="jon";
        app.getUser().fillRegistrationForm(name,lastName,email,password);
        app.getUser().clickCheckBox();
    Assert.assertTrue(app.getUser().isRegisteredFailedFromPassword());
    Assert.assertFalse(app.getUser().isLogged());
    Assert.assertFalse(app.getUser().yallaButtonIsActive());

}
@AfterMethod
    public void postCondition(){
        app.getUser().closeDialogContainer();
}
}
