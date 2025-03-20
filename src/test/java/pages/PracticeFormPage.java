package pages;

import loggerUtility.LoggerUtility;
import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.PracticeFormLocators;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(PracticeFormModel testData) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstNameValue());

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(PracticeFormLocators.emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getEmailValue());

        List<WebElement> genderElement = elementHelper.getListelements(PracticeFormLocators.genderLocator);
        switch (testData.getGenderValue()) {
            case "Male":
                elementHelper.clickJSLocator(genderElement.get(0));
                break;
            case "Female":
                elementHelper.clickJSLocator(genderElement.get(1));
                break;
            case "Other":
                elementHelper.clickJSLocator(genderElement.get(2));
                break;
            default:
                System.out.println("Nu exista alte valori");
                break;
        }
        LoggerUtility.infoLog("The user fills Gender with value: " + testData.getGenderValue());

        elementHelper.fillLocator(PracticeFormLocators.mobileElement, testData.getMobileValue());
        LoggerUtility.infoLog("The user fills Mobile with value: " + testData.getMobileValue());

        for (String subject : testData.getSubjectValues()) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectsElement, subject, Keys.ENTER);
            LoggerUtility.infoLog("The user fills Subject with value: " + subject);
        }

        List<WebElement> hobbiesElement = elementHelper.getListelements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (testData.getHobbyValues().contains(hobby.getText())) {
                elementHelper.clickJSLocator(hobby);
                LoggerUtility.infoLog("The user checks Hobby box: " + hobby.getText());
            }
        }

        File file = new File(testData.getPictureValue());
        elementHelper.fillLocator(PracticeFormLocators.pictureElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads Picture with path: " + testData.getPictureValue());

        elementHelper.fillLocator(PracticeFormLocators.addressElement, testData.getAddressValue());
        LoggerUtility.infoLog("The user fills Address with value: " + testData.getAddressValue());

        elementHelper.clickJSLocator(PracticeFormLocators.stateElement);
        elementHelper.fillPressLocator(PracticeFormLocators.stateInputElement, testData.getStateInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user fills State with value: " + testData.getStateInputValue());

        elementHelper.clickJSLocator(PracticeFormLocators.cityElement);
        elementHelper.fillPressLocator(PracticeFormLocators.cityInputElement, testData.getCityInputValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user fills State with value: " + testData.getCityInputValue());

        elementHelper.clickJSLocator(PracticeFormLocators.submitElement);
        LoggerUtility.infoLog("The user clicks on Submit button");
    }

    public void validateEntireContent(PracticeFormModel testData) {
        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, testData.getExpectedMessage());
        LoggerUtility.infoLog("The user validates the presence of the Thank you message: " + testData.getExpectedMessage());


        List<WebElement> tableContentList = elementHelper.getListelements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() + ' ' + testData.getLastNameValue());
        LoggerUtility.infoLog("The user validates the presence of First Name "+testData.getFirstNameValue()+" and Last Name "+testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());
        LoggerUtility.infoLog("The user validates the Email value: "+testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());
        LoggerUtility.infoLog("The user validates the Gender value: "+testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileValue());
        LoggerUtility.infoLog("The user validates the Mobile value: "+testData.getMobileValue());

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);
        LoggerUtility.infoLog("The user validates the Subjects value: "+testData.getSubjectValues());

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbyValues());
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);
        LoggerUtility.infoLog("The user validates the Hobbies value: "+testData.getHobbyValues());

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(testData.getPictureValue());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);
        LoggerUtility.infoLog("The user validates Picture uploaded: "+testData.getPictureValue());

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        elementHelper.validateElementContainsText(tableContentList.get(8), testData.getAddressValue());
        LoggerUtility.infoLog("The user validates Address value: "+testData.getAddressValue());

        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getStateInputValue() + ' ' + testData.getCityInputValue());
        LoggerUtility.infoLog("The user validates State Value "+testData.getStateInputValue()+" and City Value "+testData.getCityInputValue());
    }
}
