package tests;

import manager.ProviderData;
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
    public void registrationPositiveTest(User user){
        int i=(int)((System.currentTimeMillis()/1000)%3600);

    logger.info("registrationPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());

    app.getUser().openRegistrationForm();
    app.getUser().fillRegistrationForm(user);
    app.getUser().clickCheckBox();
    app.getUser().submitForm();

    logger.info("registrationPositiveTest completed");

    Assert.assertTrue(app.getUser().isRegisteredSuccess());
    Assert.assertTrue(app.getUser().isLogged());
}
@Test(dataProvider = "registrationCSV",dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user){
        logger.info("registrationPositiveTest starts with: " + user.getEmail() + " & " + user.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckBox();
        app.getUser().submitForm();

        logger.info("registrationPositiveTest completed");

        Assert.assertTrue(app.getUser().isRegisteredSuccess());
        Assert.assertTrue(app.getUser().isLogged());}
@Test
    public void registrationEmailNegativeTest(User user){
        int i=(int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckBox();
    Assert.assertTrue(app.getUser().isRegisteredFailedFromEmail());
    Assert.assertFalse(app.getUser().isLogged());
    Assert.assertTrue(app.getUser().yallaButtonNotActive());

}@Test
    public void registrationPasswordNegativeTest(User user){
        int i=(int)((System.currentTimeMillis()/1000)%3600);
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
