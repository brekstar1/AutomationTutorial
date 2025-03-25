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
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void interactWithWindow(){
        elementHelper.clickLocator(TabWindowLocators.newWindowElement);
        LoggerUtility.infoLog("The user clicks on New Window button.");
        System.out.println("Url-ul curent este: "+driver.getCurrentUrl());
        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
