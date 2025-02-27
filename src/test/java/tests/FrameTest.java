package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(getDriver());
        FrameHelper frameHelper = new FrameHelper(getDriver());

        By alertsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertsMenu);

        By framesPage = By.xpath("//span[text()='Frames']");
        elementHelper.clickJSLocator(framesPage);

        frameHelper.switchToIFrame("frame1");

        By textElement = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement);

        frameHelper.switchToParentFrame();

        frameHelper.switchToIFrame("frame2");

        By text2Element = By.id("sampleHeading");
        elementHelper.printLocatorText(text2Element);
    }
}