package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByPage {





    public List<WebElement> getBrowseByOption() {
        Select browseByOption = getBrowseBySelect();
        return browseByOption.getOptions();

    }


    public List<String> getBrowseByOptionText() {
        return getBrowseByOption().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSortByOptionText() {
        return getSortBySelect().getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public Select getBrowseBySelect(){
        WebElement element = getDriver().findElement(By.id("BrowseBy"));
        return new Select(element);
    }

    public WebDriver getDriver(){
        return Driver.getDriver();
    }


    public Select getSortBySelect(){
        WebElement element = getDriver().findElement(By.id("SortBy"));
        return new Select(element);
    }


    public static Comparator<String> NumberComparatorAsc = new Comparator<String>() {
        @Override
        public int compare(String t1, String t2) {

            int val1 = safeString2Int(t1.replace(" ", ""));
            int val2 = safeString2Int(t2.replace(" ", ""));

            return val1 - val2;
        }
    };

    public static Comparator<String> NumberComparatorDsc = new Comparator<String>() {
        @Override
        public int compare(String t1, String t2) {

            int val1 = safeString2Int(t1.replace(" ", ""));
            int val2 = safeString2Int(t2.replace(" ", ""));

            return val2 - val1;
        }
    };


    public static int safeString2Int(String value) {
        boolean var1 = false;

        int total;
        try {
            total = Integer.valueOf(value);
        } catch (NumberFormatException var3) {
            total = -1;
        }

        return total;
    }

    public List<WebElement> getAllItemsTitles() {
        //p[@class='grid-link__title']
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__title']"));
    }

    public List<WebElement> getAllItemsPrices() {
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__meta']"));
    }

    public List<String> getAllItemsPricesTexts() {
        return getAllItemsPrices().stream().map(WebElement::getText).map(each ->each.substring(each.lastIndexOf("$")+1)).collect(Collectors.toList());
    }



    /*





    public List<WebElement> getBrowseByOption() {
        Select browseByOption = getBrowseBySelect();
        return browseByOption.getOptions();

    }


    public List<String> getBrowseByOptionText() {
        return getBrowseByOption().stream().map(WebElement::getText).collect(Collectors.toList());
    }


*/




}
