package model;

import controller.PassThruValuer;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class PrivateEquityStock extends StockImpl<PassThruValuer>
{

    private PrivateEquityStock(String companyName, String symbol, String market, double currentValue, double volatility)
    {
        super(companyName, symbol, market, currentValue, volatility);
    }

    public static PrivateEquityStock create(String companyName, String symbol, String market, double currentValue, double volatility)
    {
        return new PrivateEquityStock(companyName, symbol, market, currentValue, volatility);
    }
}
