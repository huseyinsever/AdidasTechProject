package Pages;

import Utilities.GWD;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Parent {

    public void sendKeysFunction(WebElement element,String value){
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);

    }

    public void clickFunction(WebElement element){
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
        GWD.getDriver().switchTo().window(GWD.getDriver().getWindowHandle());
    }

    public void verifyContainsText(WebElement element,String text){
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

    }

    public void waitUntilLoading(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));

    }

    public void waitSectionLoading(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//mat-tab-body[@role='tabpanel' or @aria-labelledby='mat-tab-label-16-1'])[2]//div")));
    }

    public void waitEditButtonVerify(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Active ']")));

    }

    /*

    public void scrollToElement(WebElement element, double scrollingPrecision) {

        String doubleCevirilmisHali=String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle, element);
    }
        --->   VERİLEN ELEMENTE HASSAS KAYDIRMA YAPMAK İÇİN BU KOD KULLACILACAKTIR
     */


   //---------------------------------------------------------------------------------------------//

  //  JavascriptExecutor js= (JavascriptExecutor)driver;
  //  js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); --> Bu scroll sayfanin en asagisina kaydırır.

  //  JavascriptExecutor js= (JavascriptExecutor)driver;
  //  js.executeScript("window.scrollTo(document.body.scrollHeight, 0)"); --> Bu scroll sayfanın en yukarısına kaydırır.
}
