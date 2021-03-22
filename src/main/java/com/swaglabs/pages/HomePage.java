package com.swaglabs.pages;

import com.swaglabs.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.swaglabs.base.BasePage.driver;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//div[@class='app_logo']")
    private static WebElement appLogo;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private static List<WebElement> items;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public static String verifyTitle(){
        return ElementUtil.doGetPageTitle();
    }

    public static boolean isLogoDisplayed(){
        return ElementUtil.doIsDisplayed(appLogo);
    }

    public static void clickItem(String ItemName){
        for(WebElement item : items){
            if(item.getText().equals(ItemName)){
                ElementUtil.doClick(item);
                break;
            }
        }
    }


}
