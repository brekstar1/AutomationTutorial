package pages;

import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithAcceptAlert(){
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        LoggerUtility.infoLog("The user clicks on Click me button to see the Accept Alert.");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user presses the Accept  button.");
    }

    public void interactWithTimerAlert(){
        elementHelper.clickLocator(AlertLocators.alertTimerElement);
        LoggerUtility.infoLog("The user clicks on Click me button to see the Timer Alert.");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user presses the Accept  button.");
    }

    public void interactWithCancelAlert(){
        elementHelper.clickLocator(AlertLocators.alertOkCancelElement);
        LoggerUtility.infoLog("The user clicks on Click me button to see the Cancel Alert.");
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("The user presses the Cancel  button.");
    }

    public void interactWithValueAlert(AlertModel testData){
        elementHelper.clickLocator(AlertLocators.alertTextElement);
        LoggerUtility.infoLog("The user clicks on Click me button to see the Fill with value Alert.");
        alertHelper.fillTextAlert(testData.getPromptData());
        LoggerUtility.infoLog("The user fills the alert text box with value: " + testData.getPromptData());
    }
}
