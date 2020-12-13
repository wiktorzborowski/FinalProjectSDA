package devToTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testingUtils.BaseDriver;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("---------SCENARIO " + scenario.getName() + " STARTED---------");
        BaseDriver.StartDriver();
    }


    @After
    public void DestroyWebDriver(){


        BaseDriver.DestroyDriver();
    }
}
