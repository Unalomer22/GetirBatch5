package com.getir.step_definitions;

import com.getir.pages.BasePage;
import com.getir.pages.BasketPage;
import com.getir.pages.LoginPage;
import com.getir.utilities.ScrollHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {


    LoginPage loginPage = new LoginPage();
    BasketPage basketPage = new BasketPage();

    @Given("User open the getir app and enters {string} and {string}")
    public void userOpenTheGetirAppAndEntersAnd(String username, String password) throws InterruptedException {

        loginPage.login(username, password);
        loginPage.waitUntil(loginPage.dondurma);

    }


    @Then("User login successfully")
    public void user_login_successfully() {
        String actualText=loginPage.dondurma.getText();
        String expectedText = "Dondurma";
        Assert.assertEquals(expectedText,actualText);

    }


    @And("User clicks basket button")
    public void userClicksBasketButton() {

        loginPage.basketBtn.click();

    }

    @And("User verify that basket is empty and able to see {string}")
    public void userVerifyThatBasketIsEmptyAndAbleToSee(String expectedText) {

        Assert.assertEquals(expectedText,basketPage.basketText.getText());
        basketPage.backBtn.click();


    }

    @And("User able to see all menu list in console and verify that size is {int}")
    public void userAbleToSeeAllMenuListInConsoleAndVerifyThatSizeIs(int expectedSize) {

        int actualSize= loginPage.menuList.size();
        Assert.assertEquals(expectedSize,actualSize);


    }

    @And("User clicks second category which is {string}")
    public void userClicksSecondCategoryWhichIs(String categoryName) {

        basketPage.getCategory(categoryName);

    }

    @And("User adds two different items")
    public void userAddsTwoDifferentItems() {

        basketPage.addItem.click();
        basketPage.addItem.click();

    }

    @And("User scroll down to {string}")
    public void userScrollDownTo(String itemText) {
        new ScrollHelper().scrollVerticalHelper(itemText);
    }

    @Then("User verify that {string}")
    public void userVerifyThat(String expectedAmount) {

       String actualAmount= basketPage.total.getText();

        Assert.assertEquals(expectedAmount,actualAmount);

    }
}
