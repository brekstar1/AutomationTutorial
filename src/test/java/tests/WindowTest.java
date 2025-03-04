package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        TabHelper tabHelper = new TabHelper(getDriver());

        By windowsMenuElement = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(windowsMenuElement);

        By windowsElement = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickJSLocator(windowsElement);

        //NewTab
        By newTabElement = By.id("tabButton");
        elementHelper.clickLocator(newTabElement);
        System.out.println("Url-ul curent este: "+getDriver().getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //New Window
        By newWindowElement = By.id("windowButton");
        elementHelper.clickLocator(newWindowElement);
        System.out.println("Url-ul curent este: "+getDriver().getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
