package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

public class HomePage extends BasePage{
    private static String HOMEPAGE_URL = "http://dev.to/";

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    //@FindBy(how = How.XPATH, using = "//a[@href='https://dev.to/pod']")
//    @FindBy(how = How.CSS, using = "#sidebar-nav > div > a.sidebar-navigation-link.crayons-link.crayons-link--block.xh-highlight")
//    WebElement podcastsElement;

    @FindBy(how = How.XPATH, using = "//a[@href='/top/week'][contains(.,'Week')]")
    WebElement weekTab;

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void ClickWeekTab() {
        weekTab.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/top/week"));
    }

    public void ClickPodcastsLink() {
        List<WebElement> elements = driver.findElements(By.xpath("//a[@href='https://dev.to/pod']"));
        IntStream.range(0, elements.size())
                .filter(i -> elements.get(i).isDisplayed() && elements.get(i)
                        .isEnabled()).findFirst().ifPresent(i -> elements.get(i).click());
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/pod"));
    }
}
