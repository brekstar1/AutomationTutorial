package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTablesMenu();

        String firstNameValue = "Andrei";
        String lastNameValue = "Savu";
        String emailValue = "test@tester.com";
        String ageValue = "26";
        String salaryValue = "5000";
        String departamentValue = "IT";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.addNewEntry(firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departamentValue,4);

        String editsalaryValue = "2500";
        String editdepartamentValue = "HR";
        String editAgeValue = "27";

        webTablePage.editNewEntry(editsalaryValue,editdepartamentValue,editAgeValue,4);

        webTablePage.deleteNewEntry(3);
    }
}
