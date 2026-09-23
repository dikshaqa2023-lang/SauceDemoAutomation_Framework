package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;

public class PurchaseTest extends BaseTest {

   @Test
    public void purchaseProduct() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage();
        Assert.assertEquals(productsPage.getProductsTitle(), "Products");

        productsPage.addBackpackToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isBackpackDisplayed());

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterCustomerDetails("Saloni", "Sharma", "452001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!");
    }
}
