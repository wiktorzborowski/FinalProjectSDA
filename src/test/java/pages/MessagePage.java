package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage extends BasePage{
    @FindBy(how = How.XPATH, using = "//div[@class='crayons-article__header__meta']//h1")
    WebElement messageTitle;

    public String getMessageTitle() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(messageTitle));
        return messageTitle.getText();
    }
}
