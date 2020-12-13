package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PodcastsPage extends BasePage{
    @FindBy(how = How.XPATH, using = "//*/h3")
    WebElement podcastEntry;

    public WebElement getFirstPodcast() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        return podcastEntry;
    }

    public String getPodcastTitle(WebElement element){
        return podcastEntry.getText().trim();
    }
}
