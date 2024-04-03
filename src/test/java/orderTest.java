import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import formates.homePage;
import formates.orderPage;

@RunWith(Parameterized.class)
public class orderTest {
    @Rule
    public driverSettings driverFactory = new driverSettings();
    private final String name;
    private final String surname;
    private final String data;
    private final String number;
    private final String adres;
    private final String period;
    private final String chosenButton;
    private final int metroPoint;

    public orderTest(String chosenButton, String name, String family, String adres, int metroPoint, String number, String data, String period) {
        this.chosenButton = chosenButton;
        this.name = name;
        this.adres = adres;
        this.metroPoint = metroPoint;
        this.data = data;
        this.surname = family;
        this.number = number;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Top","Настя", "Черных", "ул. Микрорайон", 1, "88005553535", "20", "двое суток"},
                {"Bottom", "Никита", "Редин", "ул. Райан Гослинг", 2, "+78005555555", "15", "сутки"},
        };
    }

    @Test
    public void orderTest() {
        orderPage objOrderPage = new orderPage(driverFactory.getDriver());
        homePage objHomePage = new homePage(driverFactory.getDriver());

        if (chosenButton == "Top") {
            objHomePage.clickOrderTopButton();
        } else objHomePage.clickOrderBottomButton();

        objOrderPage.order(name, surname, adres, metroPoint, number, data, period);
        MatcherAssert.assertThat(objOrderPage.headerOrderConfirm(), containsString("Заказ оформлен"));
    }
}

