package model;

import controller.UsefulFunctions;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class PortfolioTest
{

    private static final double TOLERANCE = 0.01;

    @Test
    public void testCreate()
    {
        Stock stock1 = IssuedEquityStock.create("Virtual Tree Owners", "VTO", "Kabarnet Stock Exchange", 0.08, 0.25);
        Stock stock2 = IssuedEquityStock.create("Dalai Lama Fellows", "DLF", "San Francisco Stock Exchange", 80.08, 0.25);
        Pair<Stock, Double> pair = Tuples.pair(stock1, 23.0);
        Pair<Stock, Double> pair1 = Tuples.pair(stock2, 5.0);
        final FastList<Pair<Stock, Double>> stockList = FastList.newListWith(pair, pair1);
        Portfolio portfolio = Portfolio.newPortfolioWith(stockList);
        Assert.assertEquals(portfolio.getStocks().size(), 2);
        Assert.assertEquals(portfolio.getValue(), 402.24, TOLERANCE);
        stock1.updateValue(0.23);
        Assert.assertEquals(portfolio.getValue(), 405.69, TOLERANCE);
    }

    @Test
    public void gaussian()
    {
        List<Double> randomGaussian = UsefulFunctions.randomGaussian(10000000);
        double mean = UsefulFunctions.mean(randomGaussian);
        double variance = UsefulFunctions.variance(randomGaussian);
        Assert.assertEquals(0.00, mean, TOLERANCE);
        Assert.assertEquals(1.00, variance, TOLERANCE);
    }

}