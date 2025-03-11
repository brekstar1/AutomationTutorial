package pageLocators;

import org.openqa.selenium.By;

public class WebTableLocators {

    public static final By initialTableElementLocator = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By addElement = By.id("addNewRecordButton");
    public static final By firstNameElement = By.id("firstName");
    public static final By lastNameElement = By.id("lastName");
    public static final By emailElement = By.id("userEmail");
    public static final By ageElement = By.id("age");
    public static final By salaryElement = By.id("salary");
    public static final By departamentElement = By.id("department");
    public static final By submitElement = By.id("submit");
    public static final By addTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By editElement = By.id("edit-record-4");
    public static final By editSubmitElement = By.id("submit");
    public static final By editTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
    public static final By deleteElement = By.id("delete-record-4");
    public static final By deleteTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
}
