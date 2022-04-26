package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        verifyText("Signing up is easy!",By.xpath("//h1[contains(text(),'Signing up is easy!')]"),"Signing up is easy!");
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        sendTextToElement(By.id("customer.firstName"),"Vimal");
        sendTextToElement(By.id("customer.lastName"),"Patel");
        sendTextToElement(By.id("customer.address.street"),"138 Church Street");
        sendTextToElement(By.id("customer.address.city"),"London");
        sendTextToElement(By.id("customer.address.state"),"Middx");
        sendTextToElement(By.id("customer.address.zipCode"),"NW8 8EX");
        sendTextToElement(By.id("customer.phoneNumber"),"020 7723 5205");
        sendTextToElement(By.id("customer.ssn"),"VP 37 95 95 D");
        sendTextToElement(By.id("customer.username"),"vpatel47");
        sendTextToElement(By.id("customer.password"),"123456");
        sendTextToElement(By.id("repeatedPassword"),"123456");
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        verifyText("Your account was created successfully. You are now logged in.",By.xpath("//div[@id='mainPanel']/div[3]/div[2]/p"),"Your account was created successfully. You are now logged in.");

    }
    @After
    public void close(){
        driver.quit();
    }

}
