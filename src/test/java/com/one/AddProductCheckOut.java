package com.one;
import com.one.framework.Browser;
import com.one.framework.WebDriverConfig;
import com.one.ui.domains.Product;
import com.one.ui.pages.LoginForm;
import com.one.ui.pages.ProductsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.Reporter;

import javax.inject.Inject;

@ContextConfiguration(classes = {LoginForm.class, WebDriverConfig.class, Browser.class})
public class AddProductCheckOut extends AbstractTestNGSpringContextTests{

	  @Autowired
	    private LoginForm loginForm;

	    @Inject
	    private Browser browser;

	    private ProductsContent productsContent;
	    private Product product;

	
	    //TODO - add tests for Add Product and Checkout
	    @Test
	    public void verifyAddCart_cHeckOut() {
	        SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(productsContent.getAddToCartButtonText().matches("Add to cart"), "Wrong Add to cart button text or Add to cart button not found");
        	productsContent.AddCart();
	        softAssert.assertTrue(productsContent.getCheckOutCompleteMessage().matches("THANK YOU FOR YOUR ORDER"), "Order not placed properly");
	    }

	
	  @BeforeClass(alwaysRun = true)
	    @Parameters({"username", "password"})
	    public void beforeTestMethod(String username, String password) {
	        productsContent = new ProductsContent(browser);
	        loginForm.loginAs(username, password);
	    }
}
