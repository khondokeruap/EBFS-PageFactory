package com.ebfs.qa.pages;

import com.ebfs.qa.properties.HomePageProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.ebfs.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import com.ebfs.qa.properties.ProductCartProerties;

public class ProductCartPage extends TestBase {
    @FindBy(xpath = ProductCartProerties.CART_SUM_ITEM_DISPLAY_XPATH)
    @CacheLookup
    WebElement itemDisplayed;
    @FindBy(xpath = ProductCartProerties.DELETE1)
    WebElement delete1;
    @FindBy(xpath = ProductCartProerties.MIN1_XPATH)
    WebElement minus1;
    @FindBy(xpath = ProductCartProerties.PRINTED_DRESS2_ADD_XPATH)
    WebElement printDress2Add;
    @FindBy(xpath = ProductCartProerties.TOTAL_SHIPPING_COST_XPATH)
    WebElement shippingCost;
    @FindBy(xpath = ProductCartProerties.TOTAL_COST_XPATH)
    WebElement totalCost;
    @FindBy(xpath = ProductCartProerties.CONTINUE_SHOP_XPATH)
    WebElement contShopping;
    @FindBy(xpath = ProductCartProerties.CONTINUE_CHK_OUT_XPATH)
    WebElement contShipping;
    @FindBy(xpath = ProductCartProerties.ADDRESS_PROCESS_XPATH)
    WebElement addressProcessCont;
    @FindBy(xpath = ProductCartProerties.SHIPPING_OPTIONS_XPATH)
    WebElement shippingOprions;
    @FindBy(xpath = ProductCartProerties.TERMS_CHECK_XPATH)
    WebElement chkTerms;
    @FindBy(xpath = ProductCartProerties.SHIPPING_PROCEED_XPATH)
    WebElement shippingProceedFinal;
    @FindBy(xpath = ProductCartProerties.PAY_WIRE_XPATH)
    WebElement bankWire;
    @FindBy(xpath = ProductCartProerties.PAY_CHECK_XPATH)
    WebElement bankCheck;
    @FindBy(xpath = ProductCartProerties.PAY_CARD_XPATH)
    WebElement bankCard;
    @FindBy(xpath = ProductCartProerties.GIFT_OPTION_XPATH)
    WebElement gift;
    @FindBy(xpath = ProductCartProerties.GIFT_TEXTBOX_XPATH)
    WebElement giftText;

    public ProductCartPage() {
        PageFactory.initElements(driver, this);
    }
    public boolean verifyCartSummaryItemDisplayed(){
        return itemDisplayed.isDisplayed();
    }
    public boolean verifyCartSummaryDelete1Displayed(){return itemDisplayed.isDisplayed(); }

    public boolean verifyCartSummaryShippingCostDisplayed(){return shippingCost.isDisplayed(); }
    public boolean verifyCartSummaryTotalCostDisplayed(){return totalCost.isDisplayed(); }
    public boolean verifyCartSummaryContShoppingDisplayed(){return contShopping.isDisplayed();  }
    public boolean verifyDiffShipOptionsDisplayed(){return shippingOprions.isDisplayed();  }
    public boolean verifyBankWireDisplayed(){return bankWire.isDisplayed();  }
    public boolean verifyBankCheckDisplayed(){return bankCheck.isDisplayed();  }
    public boolean verifyBankCardDisplayed(){return bankCard.isDisplayed();  }
    public boolean verifyGiftOptionDisplayed(){return gift.isDisplayed();  }
}
