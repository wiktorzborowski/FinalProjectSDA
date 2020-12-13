package pages;

import org.openqa.selenium.WebDriver;
import testingUtils.BaseDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public final WebDriver driver;

    public BasePage() {
        this.driver = BaseDriver.driver;
        PageFactory.initElements(this.driver, this);
    }
}
