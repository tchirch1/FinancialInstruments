package model;

import controller.PassThruValuer;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class PrivateEquityStock<V extends PassThruValuer> implements Stock<V> {
    @Override
    public double value(V valuer) {
        return 0;
    }

    @Override
    public String companyName() {
        return null;
    }

    @Override
    public String symbol() {
        return null;
    }

    @Override
    public String market() {
        return null;
    }

    @Override
    public void updateValue(double newValue) {

    }

    @Override
    public double volatility() {
        return 0;
    }
}
