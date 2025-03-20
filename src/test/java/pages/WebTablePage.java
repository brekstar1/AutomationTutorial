package pages;

import modelObject.WebTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;

import java.util.List;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void addNewEntry(WebTableModel testData){
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator,testData.getNewTableSize()-1);
        elementHelper.clickLocator(WebTableLocators.addElement);
        elementHelper.fillLocator(WebTableLocators.firstNameElement,testData.getFirstNameValue());
        elementHelper.fillLocator(WebTableLocators.lastNameElement,testData.getLastNameValue());
        elementHelper.fillLocator(WebTableLocators.emailElement,testData.getUserEmailValue());
        elementHelper.fillLocator(WebTableLocators.ageElement,testData.getAgeValue());
        elementHelper.fillLocator(WebTableLocators.salaryElement,testData.getSalaryValue());
        elementHelper.fillLocator(WebTableLocators.departamentElement,testData.getDepartmentValue());
        elementHelper.clickLocator(WebTableLocators.submitElement);
        elementHelper.validateSizeList(WebTableLocators.addTableElement,testData.getNewTableSize());

        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElement);
        String rowText = addTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstNameValue()));
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        Assert.assertTrue(rowText.contains(testData.getUserEmailValue()));
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
    }

    public void editNewEntry(WebTableModel testData){
        elementHelper.clickLocator(WebTableLocators.editElement);

        elementHelper.clearAndFillLocator(WebTableLocators.editSalaryElement,testData.getEditSalaryValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editDepartmentElement,testData.getEditDepartmentValue());
        elementHelper.clearAndFillLocator(WebTableLocators.editAgeElement,testData.getEditAgeValue());

        elementHelper.clickLocator(WebTableLocators.editSubmitElement);

        elementHelper.validateSizeList(WebTableLocators.editTableElement,testData.getNewTableSize());

        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElement);
        String editrowText = editTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(editrowText.contains(testData.getEditDepartmentValue()));
        Assert.assertTrue(editrowText.contains(testData.getEditSalaryValue()));
        Assert.assertTrue(editrowText.contains(testData.getEditAgeValue()));
    }

    public void deleteNewEntry(WebTableModel testData){
        elementHelper.clickLocator(WebTableLocators.deleteElement);

        elementHelper.validateSizeList(WebTableLocators.deleteTableElement,testData.getActualTableSize());
    }
}
