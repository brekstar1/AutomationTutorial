package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.TabWindowPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class WindowTest extends SharedData {

    @Test(groups = {TestSuite.REGRESSION_SUITE,TestSuite.ALERT_FRAME_SUITE,
            TestCaseSuite.TICKET_123,TestCaseSuite.TC_458})
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowFrameMenu();
        indexPage.clickOnWindowsSubMenu();

        TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
        tabWindowPage.interactWithTab();
        tabWindowPage.interactWithWindow();
    }
}
