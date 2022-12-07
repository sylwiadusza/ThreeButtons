package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KomunikatGoodAnswer {
    WebDriver driver;

    @Given("Uzytkownik znajduje sie na stronie {string}")
    public void uzytkownik_znajduje_sie_na_stronie(String adresStrony) {
        System.out.println("Uzytkownik znajduje się na stronie");
        driver = new ChromeDriver();
        driver.navigate().to(adresStrony);
    }

    @When("Uzytkownik klika w przycik B1 lub B2 według sekwencji wyswitlonej w kolumnie Test Step")
    public void uzytkownik_klika_w_przycik_b1_lub_b2_według_sekwencji_wyswitlonej_w_kolumnie_test_step() throws InterruptedException {
        System.out.println("Uzytkownik wykonuje sekwencje znakow");
        WebElement b1 = driver.findElement(By.name("btnButton1"));
        WebElement b2 = driver.findElement(By.name("btnButton2"));
        String testStep1 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/code")).getText();
        String testStep2 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/code")).getText();
        String testStep3 = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/code")).getText();
        System.out.println(testStep1);
        System.out.println(testStep2);
        System.out.println(testStep3);
        String[] testSteps = new String[3];
        testSteps[0] = testStep1;
        testSteps[1] = testStep2;
        testSteps[2] = testStep3;
        for (String testStep : testSteps) {
            Thread.sleep(500); //zwolnienie aplikacji
            if ("B1".equals(testStep)) {
                b1.click();
            } else {
                b2.click();
            }
        }
    }

    @When("Uzytkownik klika w przycisk CHECK SOLUTION")
    public void uzytkownik_klika_w_przycisk_check_solution() throws InterruptedException {
        Thread.sleep(500); //zwolnienie aplikacji
        System.out.println("Uzytkownik klika przycik CHECK SOLUTION");
        driver.findElement(By.name("end")).click();

    }

    @Then("Uzytkownik otrzymuje informacje OK. Good answer")
    public void uzytkownik_otrzymuje_informacje_ok_good_answer() throws InterruptedException {
        Thread.sleep(500); //zwolnienie aplikacji
        System.out.println("Uzytkownik otrzymuje odpowiedz OK. Good answer");
        Assert.assertEquals("OK. Good answer", driver.findElement(By.className("wrap")).getText());

    }

}
