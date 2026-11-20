package com.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shop.ShoppingCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.math.BigDecimal;

public class CartSteps {

    private ShoppingCart cart = new ShoppingCart();

    @Given("an empty cart")
    public void anEmptyCart() {
        cart = new ShoppingCart();
    }

    @When("I add {int} {string} priced at {bigdecimal}")
    public void iAdd(int quantity, String product, BigDecimal price) {
        cart.add(product, price, quantity);
    }

    @Then("the cart contains {int} item(s)")
    public void theCartContainsItems(int expected) {
        assertThat(cart.itemCount()).isEqualTo(expected);
    }

    @Then("the cart total is {bigdecimal}")
    public void theCartTotalIs(BigDecimal expected) {
        assertThat(cart.total()).isEqualByComparingTo(expected);
    }
}
