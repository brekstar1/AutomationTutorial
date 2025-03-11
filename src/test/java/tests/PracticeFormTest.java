package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnFormSubMenu();

        String firstNameValue = "Andrei";
        String lastNameValue = "Savu";
        String emailValue = "test@test.com";
        String genderValue = "Male";
        String mobileValue = "4078044220";
        List<String> subjectValues = Arrays.asList("Arts","Accounting","Maths");
        List<String> hobbyValues = Arrays.asList("Sports","Reading","Music");
        String pictureValue = "src/test/resources/Screenshot 2025-01-26 102012.png";
        String addressValue = "Strada Marsa, nr.2, sector 4,Bucuresti";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";

        PracticeFormPage practiceFormPage= new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(firstNameValue,lastNameValue,emailValue,genderValue,mobileValue,
                subjectValues,hobbyValues,pictureValue,addressValue,stateInputValue,cityInputValue);

        practiceFormPage.validateEntireContent(expectedMessage,firstNameValue,lastNameValue,emailValue,genderValue,mobileValue,
                subjectValues,hobbyValues,pictureValue,addressValue,stateInputValue,cityInputValue);
    }
}