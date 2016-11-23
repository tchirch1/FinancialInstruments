package model;

import controller.Valuable;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public interface Stock<V> extends Valuable<V> {
    String companyName();

    String symbol();

    String market();

    void updateValue(double newValue);

    double volatility();
}
