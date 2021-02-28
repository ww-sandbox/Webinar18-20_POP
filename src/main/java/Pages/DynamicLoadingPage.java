package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {
    public DynamicLoadingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ("#start > button"))
    private WebElement startButton;

    @FindBy(id = "loading")
    private WebElement loadingBar;

    @FindBy(css = "#finish > h4")
    private WebElement finishTextHeader;

    public DynamicLoadingPage clickStartButton(){
        startButton.click();

        return this;
    }

    public DynamicLoadingPage checkLoadingStarted(){
        waitForElementToBeVisible(loadingBar);

        return this;
    }

    public DynamicLoadingPage checkLoadingFinished(){
        waitForElementToBeInvisible(loadingBar);

        return this;
    }

    public String finishLoadingConfirmation(){
        waitForElementToBeVisible(finishTextHeader);

        return finishTextHeader.getText();
    }

}
