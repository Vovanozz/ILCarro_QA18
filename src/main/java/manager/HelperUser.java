package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));

    }

public void fillLoginForm(String email,String password){
    type(By.id("email"), email);
    type(By.id("password"),password);
}
public void submitLogin(){
      click(By.xpath("//button[.=\"Y’alla!\"]"));
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
        return wd.findElement(By.xpath("//button[contains(text(),'Y’alla!')]")).isEnabled();
}
public boolean yallaButtonNotActive(){
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
}
    public boolean isLoginFormDisplayed(){
        if(wd.findElements(By.xpath("//div[@class='login-registration-container']")).size()!=0){
            return true;
        }else {return false;
    }
}}
