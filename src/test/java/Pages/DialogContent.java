package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends Parent{
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css = "div[class='list-group']>a")
    public List<WebElement> categoriesList;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptops;

    @FindBy(linkText = "Sony vaio i7")
    public WebElement sonyVaio_i7;

    @FindBy(css = "[class='btn btn-success btn-lg']")
    private WebElement addToCart;

    @FindBy(css = "a[class='navbar-brand']")
    private WebElement productStoreIcon;

    @FindBy(linkText = "Dell i7 8gb")
    public WebElement dell_i7_8GB;

    @FindBy(css = "a[id='cartur']")
    private WebElement cart;

    @FindBy(css = "[src='imgs/dell.jpg']")
    public WebElement itemVisible;

    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    private WebElement deleteItem;

    @FindBy(css = "button[data-target='#orderModal']")
    private WebElement placeOrder;

    @FindBy(css = "[id=name]")
    private WebElement nameInput;

    @FindBy(css = " [id=country]")
    private WebElement countryInput;

    @FindBy(css = " [id=city]")
    private WebElement cityInput;

    @FindBy(css = " [id=card]")
    private WebElement creditCardInput;

    @FindBy(css = " [id=month]")
    private WebElement monthInput;

    @FindBy(css = " [id=year]")
    private WebElement yearInput;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement verifyText;

    @FindBy(xpath = "//*[text()='Amount: 790 USD']")
    public WebElement amount;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement OK;















    WebElement myElement;

    public void findAndClick(String element){
        switch (element){
            case "laptops":myElement=laptops;break;
            case "sonyVaio_i7":myElement=sonyVaio_i7;break;
            case "addToCart":myElement=addToCart;break;
            case "productStoreIcon":myElement=productStoreIcon;break;
            case "dell_i7_8GB":myElement=dell_i7_8GB;break;
            case "cart":myElement=cart;break;
            case "deleteItem":myElement=deleteItem;break;
            case "placeOrder":myElement=placeOrder;break;
            case "purchase":myElement=purchase;break;
            case "OK":myElement=OK;break;

        }
        clickFunction(myElement);
    }

    public void findAndSend(String element, String value){
        switch (element){
            case "name":myElement=nameInput;break;
            case "country":myElement=countryInput;break;
            case "city":myElement=cityInput;break;
            case "creditCard":myElement=creditCardInput;break;
            case "month":myElement=monthInput;break;
            case "year":myElement=yearInput;break;

        }
        sendKeysFunction(myElement,value);
    }

    public void verifyText(String element, String text){
        switch (element){
            case "verifyText":myElement=verifyText;break;
            case "amount":myElement=amount;break;
        }
        verifyContainsText(myElement,text);
    }


    public void deleteItemClick(){
        Actions actions=new Actions(GWD.getDriver());
        actions.moveToElement(deleteItem).click().build().perform();
    }














}
