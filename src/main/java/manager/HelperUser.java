package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));

    }public void openRegistrationForm(){
        click(By.xpath("//a[.=' Sign up ']"));

    }

public void fillLoginForm(String email,String password){
    type(By.id("email"), email);
    type(By.id("password"),password);
}public void fillRegistrationForm(String name,String lastName,String email,String password){
    type(By.id("email"), email);
    type(By.id("password"),password);
    type(By.id("name"),name);
    type(By.id("lastName"),lastName);
}
public void submitForm(){
      //click(By.cssSelector("button[type='submit']"));
      wd.findElement(By.cssSelector("button[type='submit']")).submit();
}
public void clickCheckBox(){

        JavascriptExecutor js  = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");

    }

public void closeDialogContainer(){
        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
}
public String getMessage(){
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
}
public String getErrorText(){
        return wd.findElement(By.cssSelector("div.error")).getText();

}

public void logout(){
        click(By.xpath("//a[.=' Logout ']"));
}
public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
}
public boolean yallaButtonIsActive(){
        return wd.findElement(By.xpath("//button[contains(@type,'submit')]")).isEnabled();
}
public boolean yallaButtonNotActive(){
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
}
    public boolean isLoginFormDisplayed(){
        if(wd.findElements(By.xpath("//div[@class='login-registration-container']")).size()!=0){
            return true;
        }else {return false;
    }
}

    public boolean isLoggedSuccess() {
        WebDriverWait wait=new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    } public boolean isLoggedFailed() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }public boolean isRegisteredSuccess() {
        WebDriverWait wait=new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='You are logged in success']")).getText().contains("logged in success");
    }public boolean isRegisteredFailedFromEmail() {
        WebDriverWait wait=new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.='Wrong email format']"))));
        return wd.findElement(By.xpath("//div[.='Wrong email format']")).getText().contains("email format");
    }public boolean isRegisteredFailedFromPassword() {
        WebDriverWait wait=new WebDriverWait(wd,10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.='Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]']"))));
        return wd.findElement(By.xpath("//div[.='Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]']")).
                getText().contains("Password must contain");
    }

}
