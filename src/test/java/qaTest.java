import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import formates.homePage;

@RunWith(Parameterized.class)
public class qaTest {
    @Rule
    public driverSettings driverFactory = new driverSettings();
    private final int questionNumber;
    private final int answerNumber;
    private final String answerText;
    public qaTest(int questionNumber, int answerNumber, String answerText) {
        this.questionNumber = questionNumber;
        this.answerNumber = answerNumber;
        this.answerText = answerText;
    }

    @Parameterized.Parameters
    public static Object[][] getListData() {
        return new Object[][] {
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void ListTest() {
        homePage objHomePage = new homePage(driverFactory.getDriver());

        objHomePage.clickList(questionNumber);
        String actualAnswer = objHomePage.listAnswer(answerNumber);
        MatcherAssert.assertThat(actualAnswer, containsString(answerText));
    }
}
