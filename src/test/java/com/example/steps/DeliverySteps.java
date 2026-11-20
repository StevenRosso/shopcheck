package com.example.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.shop.DeliveryCalculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.math.BigDecimal;

public class DeliverySteps {

    private String method = "standard";
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal charge;

    @Given("the shopper chooses {word} delivery")
    public void theShopperChoosesDelivery(String method) {
        this.method = method;
    }

    @Given("a basket with a subtotal of {bigdecimal}")
    public void aBasketWithASubtotalOf(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @When("the delivery charge is calculated")
    public void theDeliveryChargeIsCalculated() {
        charge = DeliveryCalculator.charge(subtotal, method);
    }

    @Then("the delivery charge is {bigdecimal}")
    public void theDeliveryChargeIs(BigDecimal expected) {
        assertThat(charge).as("delivery charge").isEqualByComparingTo(expected);
    }
}
