package com.utamatisi.app.models.domain;

import com.utamatisi.app.models.milestone.BusinessDateMilestonedImpl;

import javax.persistence.*;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 10:34 PM.
 */
@Entity
@Table(name = "portfolio")
@NamedQueries({@NamedQuery(name = "Portfolio.findAll", query = Portfolio.GENERIC_SELECT)})
public class Portfolio extends BusinessDateMilestonedImpl
{

    public static final String GENERIC_SELECT = "select p from Portfolio p  where p.businessDateTo >= CURRENT_TIMESTAMP";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "portfolioNumber", nullable = false)
    private String portfolioNumber;

    @Column(name = "stockId", nullable = false)
    private String stockId;

    @Column(name = "stockCount")
    private double stockCount;

    public Portfolio()
    {
    }

    public Portfolio(String portfolioNumber, String stockId, double stockCount)
    {
        this.portfolioNumber = portfolioNumber;
        this.stockId = stockId;
        this.stockCount = stockCount;
    }

    public String getPortfolioNumber()
    {
        return portfolioNumber;
    }

    public void setPortfolioNumber(String portfolioNumber)
    {
        this.portfolioNumber = portfolioNumber;
    }

    public String getStockId()
    {
        return stockId;
    }

    public void setStockId(String stockId)
    {
        this.stockId = stockId;
    }

    public double getStockCount()
    {
        return stockCount;
    }

    public void setStockCount(double stockCount)
    {
        this.stockCount = stockCount;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
