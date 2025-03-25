package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void interactFirstIFrame(){
        frameHelper.switchToIFrame("frame1");
        LoggerUtility.infoLog("The focus is changed to frame 1.");
        elementHelper.printLocatorText(FrameLocators.textElement);
        LoggerUtility.infoLog("The frame message is seen.");
        frameHelper.switchToParentFrame();
        LoggerUtility.infoLog("The focus is changed to parent frame.");
    }

    public void interactSecondIFrame(){
        frameHelper.switchToIFrame("frame2");
        LoggerUtility.infoLog("The focus is changed to frame 2.");
        elementHelper.printLocatorText(FrameLocators.text2Element);
        LoggerUtility.infoLog("The frame message is seen.");
    }
}
