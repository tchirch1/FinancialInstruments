package simulations;

import model.Option;
import org.junit.Assert;
import org.junit.Test;

import java.util.DoubleSummaryStatistics;

import static org.junit.Assert.*;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 2:52 PM.
 */
public class BinomialTreePricerTest
{
    @Test
    public void price()
    {
        BinomialTreePricer bin = new BinomialTreePricer(23.0, 20.0, 2);
        Assert.assertEquals(Double.valueOf(23.0), bin.valueOf(null));
    }

}