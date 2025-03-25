package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.TabWindowLocators;

public class TabWindowPage extends BasePage{

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTab(){
        elementHelper.clickLocator(TabWindowLocators.newTabElement);
        LoggerUtility.infoLog("The user clicks on New Tab button.");
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The focus is changed to tab 2.");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The current tab is closed.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The focus is changed to parent tab.");
    }

    public void interactWithWindow(){
        elementHelper.clickLocator(TabWindowLocators.newWindowElement);
        LoggerUtility.infoLog("The user clicks on New Window button.");
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The focus is changed to tab 2.");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The current tab is closed.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The focus is changed to the first tab.");
    }
}
