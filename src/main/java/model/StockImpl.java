package model;

import controller.PassThruValuer;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 12:06 PM.
 */
public class StockImpl<V extends PassThruValuer> implements Stock<V>
{

    private final String companyName;
    private final String symbol;
    private final String market;
    private double value;
    private double volatility;

    public StockImpl(String companyName, String symbol, String market, double currentValue, double volatility)
    {
        this.companyName = companyName;
        this.symbol = symbol;
        this.market = market;
        this.value = currentValue;
        this.volatility = volatility;
    }

    public String companyName()
    {
        return this.companyName;
    }

    public String symbol()
    {
        return this.symbol;
    }

    private double value()
    {
        return this.value;
    }

    public void updateValue(double newValue)
    {
        this.value = newValue;
    }

    @Override
    public double volatility()
    {
        return this.volatility;
    }

    public String market()
    {
        return this.market;
    }

    @Override
    public double value(V valuer)
    {
        return valuer.valueOf(Double.valueOf(this.value()));
    }


}
