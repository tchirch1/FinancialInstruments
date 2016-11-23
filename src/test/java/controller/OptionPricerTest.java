package controller;

import model.Option;
import model.IssuedEquityStock;
import org.junit.Assert;
import org.junit.Test;
import simulations.MonteCarloOptionPricer;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class OptionPricerTest {
    private static final OptionPricer MC_PRICER = new MonteCarloOptionPricer<>(1000, 100000);
    private static final OptionPricer BS_PRICER = new BlackScholesPricer();

    @Test
    public void testCallOption() {
        doCompare(Option.CALL);
    }

    @Test
    public void testPutOption() {
        doCompare(Option.PUT);
    }

    private void doCompare(String call) {
        Option option = new Option(call, 2.0, IssuedEquityStock.create("Apple Inc.", "AAPL", "NASDAQ", 111.1, 0.25), 115.0);
     //   Assert.assertEquals(option.value(MC_PRICER), option.value(BS_PRICER), 0.0001);
    }

}