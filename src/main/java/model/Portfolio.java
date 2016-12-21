package model;

import controller.PassThruValuer;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.tuple.Tuples;

import java.util.List;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class Portfolio
{

    private List<Pair<Stock, Double>> stocks = FastList.newList();
    private List<Pair<Option, Double>> options = FastList.newList();

    private Portfolio(List<Pair<Stock, Double>> stockList)
    {
        stocks.addAll(stockList);
    }

    private static Pair<Stock, Double> createPair(Stock toAdd, double quantity)
    {
        return Tuples.pair(toAdd, quantity);
    }

    static Portfolio newPortfolioWith(List<Pair<Stock, Double>> stockList)
    {
        return new Portfolio(stockList);
    }

    public Stock addStock(Stock stock, double quantity)
    {
        stocks.add(createPair(stock, quantity));
        return stock;
    }

    public Portfolio withAll(List<Pair<Stock, Double>> stockList)
    {
        this.stocks.addAll(stockList);
        return this;
    }

    public Portfolio with(Stock toAdd, double quantity)
    {
        this.stocks.add(createPair(toAdd, quantity));
        return this;
    }

    List<Pair<Stock, Double>> getStocks()
    {
        return this.stocks;
    }

    double getValue()
    {
        double value = 0.0;
        for (Pair<Stock, Double> pair : this.stocks) {
            value += pair.getTwo() * pair.getOne().value(new PassThruValuer());
        }
        return value;
    }

}
