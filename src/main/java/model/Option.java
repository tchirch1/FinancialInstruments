package model;

import controller.BlackScholesPricer;
import controller.PassThruValuer;
import simulations.MonteCarloOptionPricer;
import controller.OptionPricer;
import controller.Valuable;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class Option implements Valuable<OptionPricer> {
    public static final String CALL = "Call";
    public static final String PUT = "Put";
    private static final OptionPricer<Option> MONTE_CARLO_OPTION_PRICER = new MonteCarloOptionPricer<>(10000, 10000);
    private static final OptionPricer<Option> BLACK_SCHOLES_PRICER = new BlackScholesPricer<>();
    private final String type;
    private final double timeToMaturity;
    private final Stock<PassThruValuer> underlierStock;
    private final double strike;

    public Option(String type, double timeToMaturity, Stock<PassThruValuer> underlierStock, double strike) {
        this.type = type;
        this.timeToMaturity = timeToMaturity;
        this.underlierStock = underlierStock;
        this.strike = strike;
    }

    public double getPriceOfUnderlier() {
        return underlierStock.value(PassThruValuer.create());
    }

    public double getVolatility() {
        return underlierStock.volatility();
    }

    @Override
    public double value(OptionPricer valuer) {
        return (double) valuer.valueOf(this);
    }

    public String getType() {
        return this.type;
    }

    public double getStrike() {
        return this.strike;
    }

    public double getTimeToMaturity() {
        return timeToMaturity;
    }

    public Stock<PassThruValuer> getUndelier() {
        return underlierStock;
    }
}
