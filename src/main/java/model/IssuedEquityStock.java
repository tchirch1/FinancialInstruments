package model;

import controller.PassThruValuer;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class IssuedEquityStock extends StockImpl<PassThruValuer>
{

    private IssuedEquityStock(String companyName, String symbol, String market, double currentValue, double volatility)
    {
        super(companyName, symbol, market, currentValue, volatility);
    }

    public static IssuedEquityStock create(String companyName, String symbol, String market, double currentValue, double volatility)
    {
        return new IssuedEquityStock(companyName, symbol, market, currentValue, volatility);
    }
}
