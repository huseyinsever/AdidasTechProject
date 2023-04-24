package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdidasTech_Steps {
    DialogContent dc=new DialogContent();
    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @Given("Navigate to basqar")
    public void navigateToBasqar() {
        GWD.getDriver().get("https://www.demoblaze.com/index.html");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Customer navigation through product categories: Phones, Laptops and Monitors")
    public void customerNavigationThroughProductCategoriesPhonesLaptopsAndMonitors() {
        List<String> expectedList=new ArrayList<>();
        expectedList.add("CATEGORIES");
        expectedList.add("Phones");
        expectedList.add("Laptops");
        expectedList.add("Monitors");

        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(expectedList.get(i),dc.categoriesList.get(i).getText());
        }
        dc.findAndClick("laptops");

    }

    @And("Navigate to Laptop → SonyVaio-iEight and click on AddToCart Accept pop up confirmation.")
    public void navigateToLaptopSonyVaioIAndClickOnAddToCartAcceptPopUpConfirmation() {
        GWD.Bekle();
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.sonyVaio_i7);
        GWD.Bekle();
        dc.findAndClick("sonyVaio_i7");
        dc.findAndClick("addToCart");
        GWD.Bekle();
        GWD.getDriver().switchTo().alert().accept();
        dc.findAndClick("productStoreIcon");
    }

    @And("Navigate to Laptop → Dell-iSeven-Eightgb and click on AddToCart Accept pop up confirmation.")
    public void navigateToLaptopDellIGbAndClickOnAddToCartAcceptPopUpConfirmation() {
        dc.findAndClick("laptops");
        GWD.Bekle();
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.dell_i7_8GB);
        GWD.Bekle();
        dc.findAndClick("dell_i7_8GB");
        dc.findAndClick("addToCart");
        GWD.Bekle();
        GWD.getDriver().switchTo().alert().accept();
    }

    @And("Navigate to Cart → Delete Dell-iSeven-Eightgb from cart.")
        public void navigateToCartDeleteDellIGbFromCart() {
        dc.findAndClick("cart");
        wait.until(ExpectedConditions.visibilityOf(dc.itemVisible));
        dc.deleteItemClick();
    }

    @And("Click on Place order")
    public void clickOnPlaceOrder() {
        GWD.Bekle();
        dc.findAndClick("placeOrder");
    }

    @And("Fill in all web form fields.")
    public void fillInAllWebFormFields() {
        GWD.Bekle();
        dc.findAndSend("name", "Joselu");
        dc.findAndSend("country", "Espana");
        dc.findAndSend("city", "Barcelona");
        dc.findAndSend("creditCard", "012355455466598");
        dc.findAndSend("month", "October");
        dc.findAndSend("year", "2022");
    }

    @And("Click on Purchase")
    public void clickOnPurchase() {
       dc.findAndClick("purchase");
    }

    @And("Capture and log purchase Id and Amount.")
    public void captureAndLogPurchaseIdAndAmount() throws IOException {
        GWD.Bekle();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime now=LocalDateTime.now();
        String purchaseSS= "logPurchaseIDandAmount" + dtf.format(now) + ".png";
        GWD.Bekle();
        File purchaseScreenshotFile = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(purchaseScreenshotFile, new File("PurchaseSS" + purchaseSS));
    }

    @And("Assert purchase amount equals expected.")
    public void assertPurchaseAmountEqualsExpected() {
        dc.verifyText("verifyText","Thank you for your purchase!");
        Assert.assertTrue(dc.amount.getText().contains("790"));
    }

    @Then("Click on Ok")
    public void clickOnOk() {
        dc.findAndClick("OK");
    }


}
