package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", "valid"},
            {"standard_user", "wrong_password", "invalid"},
            {"wrong_user", "secret_sauce", "invalid"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expected) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        if ("valid".equalsIgnoreCase(expected)) {
            ProductsPage productsPage = new ProductsPage();
            Assert.assertEquals(productsPage.getProductsTitle(), "Products");
        } else {
            Assert.assertTrue(
                    loginPage.getErrorMessage().toLowerCase()
                            .contains("username and password"));
        }
    }
}
