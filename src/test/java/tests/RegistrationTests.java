package tests;

import models.User;
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
        int i=(int)((System.currentTimeMillis()/1000)%3600);
    User user= User.builder()
            .name("Jon")
            .lastName("Snow")
            .email("jonsnow"+i+"@gmail.com")
            .password("JonSnow12345$"+i)
            .build();
    app.getUser().openRegistrationForm();
    app.getUser().fillRegistrationForm(user);
    app.getUser().clickCheckBox();
    app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isRegisteredSuccess());
    Assert.assertTrue(app.getUser().isLogged());

}@Test
    public void registrationEmailNegativeTest(){
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        User user= User.builder()
                .name("Jon")
                .lastName("Snow")
                .email("jonsnow"+i+"gmail.com")
                .password("JonSnow12345$"+i)
                .build();
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckBox();
    Assert.assertTrue(app.getUser().isRegisteredFailedFromEmail());
    Assert.assertFalse(app.getUser().isLogged());
    Assert.assertTrue(app.getUser().yallaButtonNotActive());

}@Test
    public void registrationPasswordNegativeTest(){
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        User user= User.builder()
                .name("Jon")
                .lastName("Snow")
                .email("jonsnow"+i+"@gmail.com")
                .password("jon")
                .build();
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
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
