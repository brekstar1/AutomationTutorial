package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertWindowFrameMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsMenuElement);
        LoggerUtility.infoLog("The user clicks on AlertWindow Menu");
    }

    public void clickOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsElement);
        LoggerUtility.infoLog("The user clicks on AlertWindow Sub-Menu");
    }

    public void clickOnFramesSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.framesPage);
        LoggerUtility.infoLog("The user clicks on Frames Sub-Menu");
    }

    public void clickOnWindowsSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.windowsElement);
        LoggerUtility.infoLog("The user clicks on Windows Sub-Menu");
    }

    public void clickOnFormsMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenuElement);
        LoggerUtility.infoLog("The user clicks on Forms Menu");
    }

    public void clickOnFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormElement);
        LoggerUtility.infoLog("The user clicks on Forms Sub-Menu");
    }

    public void clickOnElementsMenu(){
        elementHelper.clickJSLocator(IndexLocators.elementsMenuElement);
        LoggerUtility.infoLog("The user clicks on Elements Menu");
    }

    public void clickOnWebTablesMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTablesElement);
        LoggerUtility.infoLog("The user clicks on WebTables Menu");
    }
}
