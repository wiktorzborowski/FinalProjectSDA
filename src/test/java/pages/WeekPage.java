package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeekPage extends BasePage{
    @FindBy(how = How.XPATH, using = "//div[@class='crayons-story__body']//h2")
    WebElement message;

    public WebElement getFirstMessage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://dev.to/top/week"));
        return message;
    }

    public String messageText() {
        return message.getText();
    }

}
