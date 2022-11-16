import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;

public class SelenideTests {
    public SelenideTests(){
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        Configuration.browserSize="1920x1080";
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        open("http://the-internet.herokuapp.com/dropdown");
        // Selecting  certain option
        $("#dropdown").selectOption(2);
        Thread.sleep(4000);
        $("#dropdown").getSelectedOption().shouldHave(text("tion 2"),value("2"));
    }
}
