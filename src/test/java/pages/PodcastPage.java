package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PodcastPage extends BasePage{
    @FindBy(how = How.XPATH, using = "//*/h1")
    WebElement podcastTitle;

    @FindBy(how = How.XPATH, using = "//*[@class='butt play-butt']")
    WebElement playButton;

    @FindBy(how = How.XPATH, using = "//*[@class='butt pause-butt']")
    WebElement pauseButton;

    public String getPodcastTitle() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(podcastTitle));
        return podcastTitle.getText().trim();
    }

    public void PlayPodcast() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(playButton));
        playButton.click();
    }

    public boolean GetPlayingStatus() {
        return playButton.isEnabled();
    }

    public boolean GetPausedStatus() {
        return pauseButton.isEnabled();
    }

    public void StopPodcast() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(pauseButton));
        pauseButton.click();
    }
}
