package com.one.ui.pages;

import com.one.framework.Browser;
import com.one.ui.domains.Product;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.handler.codec.socks.SocksRequestType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.one.locators.ClassName.LOGO;
import static com.one.locators.ClassName.OrderComplete;
import static com.one.locators.ClassName.SORT;
import static com.one.locators.Id.INVENTORY_CONTAINER;
import static com.one.locators.Id.LOGIN;
import static com.one.locators.ClassName.ShppoingCartLink;
import static com.one.locators.Id.AddToCartButton;
import static com.one.locators.Id.checkoutButton;
import static com.one.locators.Id.FirstName;
import static com.one.locators.Id.LastName;
import static com.one.locators.Id.PostalCode;
import static com.one.locators.Id.ContinueButton;
import static com.one.locators.Id.FinishButton;
import static com.one.locators.XPathSelector.*;

public class ProductsContent {

    //private static final Logger logger = LoggerFactory.getLogger(ProductsContent.class);

    private Browser browser;

    public ProductsContent(Browser browser) {
        this.browser = browser;
    }

/*    public ProductsTable<Product> getProductsList() {
        return new ProductsTable<>(browser.await(INVENTORY_CONTAINER),
                cells -> new Product(cells.get(0).getText(),
                       // cells.get(1).getText(),
                       // cells.get(2).getText(),
                        cells.get(1).getText())
        );
    }*/

    public Product getProductFromPosition(int row) {
        return getProductsList().get(row);
    }

    private List<Product> getProductsList() {
        List<Product> rows = new ArrayList<>();
        browser.await(INVENTORY_LIST).findElements(INVENTORY_ITEM).forEach(content -> {
                    String text = content.toString();
                    // split by new line
                    List<String> info = new ArrayList<>();
                    String[] lines = text.split("\\r?\\n");
                    for (String line : lines) {
                        info.add(line);
                    }
                    try {
                        Product newProduct = new Product(info.get(0),
                                info.get(1),
                                info.get(2),
                                info.get(3));
                        rows.add(newProduct);

                    } catch (Exception e) {
                        //logger.error("Product structure is not the expected one");
                    }
                });
        return rows;
    }
    
 
    public void sortBy(){
   
        browser.findElement(PRODUCT_ITEM_VALUE).click();
    }
    
    public String getAddToCartButtonText(){ return browser.getText(AddToCartButton); }
    
    public String getCheckOutCompleteMessage(){ return browser.getText(OrderComplete); }
    
    public void AddCart(){
    	
    	
    
        browser.findElement(AddToCartButton).click();
        browser.findElement(ShppoingCartLink).click();
        browser.findElement(checkoutButton).click();
        browser.findElement(FirstName).sendKeys("Dinesh");
        browser.findElement(LastName).sendKeys("Jegadeeshan");
        browser.findElement(PostalCode).sendKeys("625016");
        browser.findElement(ContinueButton).click();
        browser.findElement(FinishButton).click();
    }
}
