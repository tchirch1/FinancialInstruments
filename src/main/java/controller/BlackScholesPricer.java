package controller;

import model.Option;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class BlackScholesPricer<T extends Option> implements OptionPricer<T>
{

    @Override
    public Double valueOf(T option)
    {
        double S = option.getPriceOfUnderlier();
        double K = option.getStrike();
        double r = 0.1; //get from database
        double sigma = option.getVolatility();
        double T = option.getTimeToMaturity();
        String type = option.getType();
        double d1 = (Math.log(S / K) + (r + sigma * sigma / 2) * T) / (sigma * Math.sqrt(T));
        double d2 = d1 - sigma * Math.sqrt(T);
        return Option.PUT.equals(type) ? Math.exp(-1 * r * T) * K * Gaussian.cdf(-1 * d2) - S * Gaussian.cdf(-1 * d1) : S * Gaussian.cdf(d1) - Math.exp(-1 * r * T) * K * Gaussian.cdf(d2);
    }
}
