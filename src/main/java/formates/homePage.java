package formates;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Вверху
    private By orderTopButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка Внизу
    private By orderBottomButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    public void clickList(int questionNumber) {
        WebElement element = driver.findElement(By.xpath(".//div[@id='accordion__heading-" + questionNumber + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public String listAnswer(int answerNumber) {
        By answer = By.xpath(".//div[@id='accordion__panel-" + answerNumber + "']");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(answer)));
        return driver.findElement(answer).getText();

    }

}
