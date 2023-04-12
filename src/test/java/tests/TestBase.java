package tests;

import manager.ApplicationManager;
import manager.NGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
@Listeners(NGListener.class)
public class TestBase {
    static ApplicationManager app=new ApplicationManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }
    @AfterSuite
    public void tearDown(){
        app.stop();
    }

    @BeforeMethod
    public void started(Method method){
        logger.info("   #### Start test "+ method.getName());

    }
    @AfterMethod
    public void finished(){
        logger.info("   ####  Finished ####");


}}
