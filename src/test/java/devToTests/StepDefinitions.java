package devToTests;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.*;
import testingUtils.ScenarioData;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    HomePage homePage = new HomePage();
    WeekPage weekPage = new WeekPage();
    MessagePage messagePage = new MessagePage();
    PodcastsPage podcastsPage = new PodcastsPage();
    PodcastPage podcastPage = new PodcastPage();
    String firstMessageTitle;
    String firstPodcastTitle;

    @Given("Home page is open")
    public void homePageIsOpen() {
        homePage.openHomePage();
    }

    @When("I enter Weekly tab")
    public void iEnterWeeklyTab() {
        homePage.ClickWeekTab();
    }

    @And("Click the first message")
    public void clickTheFirstMessage() {
        firstMessageTitle = weekPage.messageText();
        weekPage.getFirstMessage().click();
    }

    @Then("The message is opened")
    public void theMessageIsOpened() {
        assertTrue(firstMessageTitle.equals(messagePage.getMessageTitle()));
    }

    @When("I enter Podcasts page")
    public void iEnterPodcastsPage() {
        homePage.ClickPodcastsLink();
    }

    @And("Click the first entry")
    public void clickTheFirstEntry() {
        WebElement firstPodcast = podcastsPage.getFirstPodcast();
        firstPodcastTitle = podcastsPage.getPodcastTitle(firstPodcast);
        firstPodcast.click();
    }

    @Then("The entry is opened")
    public void theEntryIsOpened() {
        String actualTitle = podcastPage.getPodcastTitle();
        assertTrue(firstPodcastTitle.contains(actualTitle));
    }

    @And("I can play podcast")
    public void iCanPlayPodcast() {
        podcastPage.PlayPodcast();
        assertTrue(podcastPage.GetPlayingStatus());
    }

    @And("I can stop podcast")
    public void iCanStopPodcast() {
        podcastPage.StopPodcast();
        assertTrue(podcastPage.GetPausedStatus());
    }

    @After
    public void tearDown(Scenario scenario){
        ScenarioData.scenarioName = scenario.getName();
        ScenarioData.scenarioStatus = scenario.getStatus();
    }
}
