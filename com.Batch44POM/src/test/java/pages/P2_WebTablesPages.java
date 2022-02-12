package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P2_WebTables {
    public P2_WebTables(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(css = "    @FindBy(css = \"\")\n")
    public WebElement TabloElement;

}
