package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Christie {

    public Christie() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    // @FindBy(xpath = "//*[text()='Clearance projectors']")
    @FindBy(linkText = "Clearance projectors")
    public WebElement clearanceProjectors;

    @FindBy(linkText = "Used Projectors")
    public WebElement usedProjectors;

    @FindBy(linkText = "Refurbished Projectors")
    public WebElement refurnishedProjectors;

    @FindBy(linkText = "Projector Lenses")
    public WebElement lenses;

    @FindBy(xpath = "//*[@id='CollectionSection']/div[4]/ul/li[5]/a")
    public WebElement  nextPageArrow;

    //method to perform the hover over
    public static void hoverOver(WebElement targetElement ){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(targetElement).perform();
    }

    // method for getting all the items in the page
    public static List<WebElement> getAllItemsReturn() {
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__title']"));
    }




    public static void mouseHover(WebElement targetElement){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(targetElement).perform();


    }

    public static void scrollDown(String object){

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("Window.scrollBy(0,1000)");
    }

}

    /*

    public Christie(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//ul[@id='MenuParent-1']//li")
    public WebElement clearanceProjectDropdown;

    @FindBy(xpath = "(//a[@class='site-nav__link'])[3]")
    public WebElement usedSelection;
    // @FindBy(xpath = "//*[text()='Clearance projectors']")
    @FindBy(linkText = "Clearance projectors")
    public WebElement clearanceProjectors;

    @FindBy(linkText = "Used Projectors")
    public  WebElement usedProjectors;

    @FindBy(linkText = "Refurbished Projectors")
    public  WebElement refurnishedProjectors;


    public static void hoverOver(WebElement targetElement ){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(targetElement).perform();
    }

    public static List<WebElement> getAllItemsReturn() {
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__title']"));
    }
}
*/

