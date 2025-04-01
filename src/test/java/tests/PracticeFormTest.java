package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class PracticeFormTest extends SharedData {

    @Test(groups = {TestSuite.REGRESSION_SUITE,TestSuite.FORM_SUITE,
            TestCaseSuite.TICKET_123,TestCaseSuite.TC_459})
    public void metodaTest() {

        PracticeFormModel testData = new PracticeFormModel("src/test/resources/testData/PracticeFormData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();

        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(testData);

        practiceFormPage.validateEntireContent(testData);
    }
}