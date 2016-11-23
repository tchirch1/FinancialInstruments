package simulations;

import controller.OptionPricer;
import controller.UsefulFunctions;
import model.Option;
import simulations.MonteCarloSimulation;

import java.util.List;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class MonteCarloOptionPricer<T extends Option> implements OptionPricer<T>, MonteCarloSimulation {

    private final int n;
    private final int m;

    public MonteCarloOptionPricer(int N, int M) {
        n = N;
        m = M;
    }

    private static double getValue(String type, double underlier, double strike) {
        return Option.CALL.equals(type) ? UsefulFunctions.max(underlier - strike, 0) : UsefulFunctions.max(strike - underlier, 0);
    }

    @Override
    public Double valueOf(Option option) {
        final double s0 = option.getPriceOfUnderlier();
        final double deltaT = option.getTimeToMaturity() / N();
        final double volatility = option.getVolatility();
        final double mu = 0.1 - (volatility * volatility / 2);
        final double strike = option.getStrike();
        final String type = option.getType();
        List<Double> unitNormal;
        double totalExpectedValue = 0.0;
        for (int i = 0; i < M(); i++) {
            unitNormal = UsefulFunctions.randomGaussian(N());
            double value = s0;
            for (int j = 0; j < N(); j++) {
                value *= (Math.exp(mu * deltaT + volatility * Math.sqrt(deltaT) * unitNormal.get(j)));
            }
            totalExpectedValue += getValue(type, value, strike);
        }
        return totalExpectedValue / M();
    }

    @Override
    public int N() {
        return this.n;
    }

    @Override
    public int M() {
        return this.m;
    }

}
