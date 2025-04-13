package io.project.step_definitions;

import io.cucumber.java.*;
import io.project.utilities.BrowserUtils;
import io.project.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook {

    private static final Logger LOG = LogManager.getLogger();

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("................START AUTOMATION................LOOP CAMP");
    }
    @After
    public void tearDown(Scenario scenario){
        //only takes screenshot when scenario is failed
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        LOG.info("................FINISH AUTOMATION................LOOP CAMP");
        Driver.closeDriver();
    }

   // @AfterStep
    public void takeScreenshot(Scenario scenario){
        BrowserUtils.takeScreenshot();
 //       final byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
 //       scenario.attach(screenshot, "image/png", scenario.getName());  // OR USE THIS
    }
}
