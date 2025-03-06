package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private FrameHelper frameHelper;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        frameHelper = new FrameHelper(driver);
    }

    public void interactFirstIFrame(){
        frameHelper.switchToIFrame("frame1");
        elementHelper.printLocatorText(FrameLocators.textElement);
        frameHelper.switchToParentFrame();
    }

    public void interactSecondIFrame(){
        frameHelper.switchToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.text2Element);
    }
}
