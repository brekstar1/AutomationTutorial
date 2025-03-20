package tests;

import modelObject.WebTableModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void metodaTest() {

        WebTableModel testData = new WebTableModel("src/test/resources/testData/WebTablesData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTablesMenu();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(testData);

        webTablePage.editNewEntry(testData);

        webTablePage.deleteNewEntry(testData);
    }
}
