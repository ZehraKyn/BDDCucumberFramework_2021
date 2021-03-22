package com.swaglabs.pages;

import com.swaglabs.utils.ElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.swaglabs.base.BasePage.driver;

public class CheckoutStepTwo {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private static WebElement item;

    public CheckoutStepTwo(){
        PageFactory.initElements(driver, this);
    }

    public static String getItemName(){
        return ElementUtil.doGetText(item);
    }
}
