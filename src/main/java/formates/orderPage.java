package formates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderPage {
    private WebDriver driver;

    public orderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка Далее
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //Поле ввода Имя
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");

    //Поле ввода Фамилия
    private By familyInput = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле ввода Адреса
    private By adressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле ввода Метро
    private By metroInput = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле ввода номера
    private By numberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Поле ввода Даты
    private By dataInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Список выбора Срока
    private By rentalPeriodDrop = By.xpath(".//div[@class='Dropdown-placeholder']");

    //Кнопка Да
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Заголовок оформленного заказа
    private By orderConfirm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    //Кнопка Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickMetro(int metroPoint) {
        driver.findElement(metroInput).click();
        driver.findElement(By.xpath(".//li[@data-index='" + metroPoint + "']")).click();
    }
    public void setName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setData(String data) {
        String dataXpath = ".//div[@class='react-datepicker__day react-datepicker__day--0" + data + "react-datepicker__day--weekend' or @class='react-datepicker__day react-datepicker__day--0" + data + "']";
        driver.findElement(dataInput).click();
        driver.findElement(By.xpath(dataXpath)).click();
    }

    public void setFamily(String family) {
        driver.findElement(familyInput).clear();
        driver.findElement(familyInput).sendKeys(family);
    }

    public void setAdress(String adress) {
        driver.findElement(adressInput).clear();
        driver.findElement(adressInput).sendKeys(adress);
    }

    public void setNumber(String number) {
        driver.findElement(numberInput).clear();
        driver.findElement(numberInput).sendKeys(number);
    }

    public void clickRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodDrop).click();
        driver.findElement(By.xpath(".//div[text()='"+ rentalPeriod + "']")).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public String headerOrderConfirm() {
        return driver.findElement(orderConfirm).getText();
    }

    public void order (String name, String family, String adress, int metroPoint, String number, String data, String period) {
        setName(name);
        setFamily(family);
        setAdress(adress);
        clickMetro(metroPoint);
        setNumber(number);
        clickNextButton();
        setData(data);
        clickRentalPeriod(period);
        clickOrderButton();
        clickYesButton();
    }
}
