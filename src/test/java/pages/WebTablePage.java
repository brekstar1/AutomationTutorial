package pages;

import loggerUtility.LoggerUtility;
import modelObject.WebTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;

import java.util.List;

public class WebTablePage extends BasePage {
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewEntry(WebTableModel testData) {
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator, testData.getNewTableSize() - 1);
        LoggerUtility.infoLog("The user sees that the starting table has " + (testData.getNewTableSize() - 1) + " lines.");
        elementHelper.clickLocator(WebTableLocators.addElement);
        LoggerUtility.infoLog("The user clicks on Add button.");
        elementHelper.fillLocator(WebTableLocators.firstNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstNameValue());
        elementHelper.fillLocator(WebTableLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());
        elementHelper.fillLocator(WebTableLocators.emailElement, testData.getUserEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getUserEmailValue());
        elementHelper.fillLocator(WebTableLocators.ageElement, testData.getAgeValue());
        LoggerUtility.infoLog("The user fills Age with value: " + testData.getAgeValue());
        elementHelper.fillLocator(WebTableLocators.salaryElement, testData.getSalaryValue());
        LoggerUtility.infoLog("The user fills Salary with value: " + testData.getSalaryValue());
        elementHelper.fillLocator(WebTableLocators.departamentElement, testData.getDepartmentValue());
        LoggerUtility.infoLog("The user fills Department with value: " + testData.getDepartmentValue());
        elementHelper.clickLocator(WebTableLocators.submitElement);
        LoggerUtility.infoLog("The user clicks on Submit button.");
        elementHelper.validateSizeList(WebTableLocators.addTableElement, testData.getNewTableSize());
        LoggerUtility.infoLog("The user sees that the starting table has " + testData.getNewTableSize() + " lines.");

        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElement);
        String rowText = addTableElementList.get(testData.getNewTableSize() - 1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstNameValue()));
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        Assert.assertTrue(rowText.contains(testData.getUserEmailValue()));
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
    }

    public void editNewEntry(WebTableModel testData) {
        elementHelper.clickLocator(WebTableLocators.editElement);
        LoggerUtility.infoLog("The user clicks on Edit button.");
        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement, testData.getEditSalaryValue());
        LoggerUtility.infoLog("The user clears and fills Salary with value: " + testData.getEditSalaryValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement, testData.getEditDepartmentValue());
        LoggerUtility.infoLog("The user clears and fills Department with value: " + testData.getEditDepartmentValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement, testData.getEditAgeValue());
        LoggerUtility.infoLog("The user clears and fills Age with value: " + testData.getEditAgeValue());

        elementHelper.clickLocator(WebTableLocators.editSubmitElement);
        LoggerUtility.infoLog("The user clicks on Submit button.");

        elementHelper.validateSizeList(WebTableLocators.editTableElement, testData.getNewTableSize());
        LoggerUtility.infoLog("The user sees that the table has " + testData.getNewTableSize() + " lines.");

        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElement);
        String editrowText = editTableElementList.get(testData.getNewTableSize() - 1).getText();
        Assert.assertTrue(editrowText.contains(testData.getEditDepartmentValue()));
        Assert.assertTrue(editrowText.contains(testData.getEditSalaryValue()));
        Assert.assertTrue(editrowText.contains(testData.getEditAgeValue()));
    }

    public void deleteNewEntry(WebTableModel testData) {
        elementHelper.clickLocator(WebTableLocators.deleteElement);
        LoggerUtility.infoLog("The user clicks on Delete button.");

        elementHelper.validateSizeList(WebTableLocators.deleteTableElement, testData.getActualTableSize());
        LoggerUtility.infoLog("The user sees that the table has " + testData.getNewTableSize() + " lines.");
    }
}
