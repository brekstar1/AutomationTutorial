package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementHelper elementHelper = new ElementHelper(getDriver());

        By elementsMenuElement = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenuElement);

        By webTablesElement = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJSLocator(webTablesElement);

        //identificam o lista de elemente
        By initialTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        int expectedTableSize = 3;
        elementHelper.validateSizeList(initialTableElementLocator,expectedTableSize);

        //Identificam un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickLocator(addElement);

        By firstNameElement = By.id("firstName");
        String firstNameValue = "Andrei";
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement = By.id("lastName");
        String lastNameValue = "Savu";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement = By.id("userEmail");
        String emailValue = "test@tester.com";
        elementHelper.fillLocator(emailElement,emailValue);

        By ageElement = By.id("age");
        String ageValue = "26";
        elementHelper.fillLocator(ageElement,ageValue);

        By salaryElement = By.id("salary");
        String salaryValue = "5000";
        elementHelper.fillLocator(salaryElement,salaryValue);

        By departamentElement = By.id("department");
        String departamentValue = "IT";
        elementHelper.fillLocator(departamentElement,departamentValue);

        By submitElement = By.id("submit");
        elementHelper.clickLocator(submitElement);

        //Validam ca avem 4 randuri in tabel
        By addTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(addTableElement,4);

        //Validam continutul tabelului
        List<WebElement> addTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String rowText = addTableElementList.get(3).getText();
        Assert.assertTrue(rowText.contains(firstNameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(emailValue));
        Assert.assertTrue(rowText.contains(departamentValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(ageValue));

        //Edit Functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        WebElement editsalaryElement = getDriver().findElement(By.id("salary"));
        editsalaryElement.clear();
        String editsalaryValue = "2500";
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartamentElement = getDriver().findElement(By.id("department"));
        editdepartamentElement.clear();
        String editdepartamentValue = "HR";
        editdepartamentElement.sendKeys(editdepartamentValue);

        WebElement editageElement = getDriver().findElement(By.id("age"));
        editageElement.clear();
        String editageValue = "27";
        editageElement.sendKeys(editageValue);

        By editSubmitElement = By.id("submit");
        elementHelper.clickLocator(editSubmitElement);

        //Validam valorile modificate
        By editTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(editTableElement,4);

        //Validam continutul tabelului
        List<WebElement> editTableElementList = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        String editrowText = editTableElementList.get(3).getText();
        Assert.assertTrue(editrowText.contains(editdepartamentValue));
        Assert.assertTrue(editrowText.contains(editsalaryValue));
        Assert.assertTrue(editrowText.contains(editageValue));

        //Delete
        By deleteElement = By.id("delete-record-4");
        elementHelper.clickLocator(deleteElement);

        By deleteTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
        elementHelper.validateSizeList(deleteTableElement,3);
    }

}
