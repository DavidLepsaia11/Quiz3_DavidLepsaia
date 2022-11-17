import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTests {

    public SelenideTests(){
        Configuration.timeout=20000;
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        Configuration.reportsFolder = "src/main/recources/failed";

        baseUrl="http://the-internet.herokuapp.com";
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        open(baseUrl +"/dropdown");
        // Selecting  certain option
        $("#dropdown").selectOption(2);
        Thread.sleep(4000);
        $("#dropdown").getSelectedOption().shouldHave(text("tion 2"),value("2"));
    }

    @Test
    public void inputTest() throws InterruptedException {
        open(baseUrl +"/inputs");
        $("input[type='number']").setValue("100");
        Thread.sleep(4000);
        $("input[type='number']").shouldBe(empty);
    }

    @Test
    public void textBoxTest() throws InterruptedException
    {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("David_Lepsaia");
        $("#userEmail").setValue("dLepsaia@gmail.com");
        $("#currentAddress").setValue("Baker Street N21");
        $("#permanentAddress").setValue("Baker Street N21");
        Thread.sleep(4000);
        $("#submit").click();
        Thread.sleep(4000);
        //ElementsCollection collection = $$(By.cssSelector(".mb-1"));
        $$(By.cssSelector(".mb-1")).shouldHave(size(4));
    }
}
