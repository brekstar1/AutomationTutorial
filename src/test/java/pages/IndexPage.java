package pages;

import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertWindowFrameMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsMenuElement);
    }

    public void clickOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsElement);
    }

    public void clickOnFramesSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.framesPage);
    }

    public void clickOnWindowsSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.windowsElement);
    }

    public void clickOnFormsMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenuElement);
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormElement);
    }

    public void clickOnElementsMenu(){
        elementHelper.clickJSLocator(IndexLocators.elementsMenuElement);
    }

    public void clickOnWebTablesMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTablesElement);
    }
}
