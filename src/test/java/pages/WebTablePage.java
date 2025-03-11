package pages;

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

    public void addNewEntry(String firstNameValue,String lastNameValue,String emailValue,
    String ageValue,String salaryValue,String departamentValue,int tableSize){
        elementHelper.validateSizeList(WebTableLocators.initialTableElementLocator,tableSize-1);
        elementHelper.clickLocator(WebTableLocators.addElement);
        elementHelper.fillLocator(WebTableLocators.firstNameElement,firstNameValue);
        elementHelper.fillLocator(WebTableLocators.lastNameElement,lastNameValue);
        elementHelper.fillLocator(WebTableLocators.emailElement,emailValue);
        elementHelper.fillLocator(WebTableLocators.ageElement,ageValue);
        elementHelper.fillLocator(WebTableLocators.salaryElement,salaryValue);
        elementHelper.fillLocator(WebTableLocators.departamentElement,departamentValue);
        elementHelper.clickLocator(WebTableLocators.submitElement);
        elementHelper.validateSizeList(WebTableLocators.addTableElement,tableSize);

        List<WebElement> addTableElementList = driver.findElements(WebTableLocators.addTableElement);
        String rowText = addTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(rowText.contains(firstNameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(emailValue));
        Assert.assertTrue(rowText.contains(departamentValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(ageValue));
    }

    public void editNewEntry(String editsalaryValue,String editdepartamentValue,String editageValue, int tableSize){
        elementHelper.clickLocator(WebTableLocators.editElement);

        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartamentElement = driver.findElement(By.id("department"));
        editdepartamentElement.clear();
        editdepartamentElement.sendKeys(editdepartamentValue);

        WebElement editAgeElement = driver.findElement(By.id("age"));
        editAgeElement.clear();
        editAgeElement.sendKeys(editageValue);

        elementHelper.clickLocator(WebTableLocators.editSubmitElement);

        elementHelper.validateSizeList(WebTableLocators.editTableElement,tableSize);

        List<WebElement> editTableElementList = driver.findElements(WebTableLocators.editTableElement);
        String editrowText = editTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(editrowText.contains(editdepartamentValue));
        Assert.assertTrue(editrowText.contains(editsalaryValue));
        Assert.assertTrue(editrowText.contains(editageValue));
    }

    public void deleteNewEntry(int tableSize){
        elementHelper.clickLocator(WebTableLocators.deleteElement);

        elementHelper.validateSizeList(WebTableLocators.deleteTableElement,tableSize);
    }
}
