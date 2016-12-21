package app.models.domain;

import app.models.milestone.BusinessDateMilestonedImpl;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 2:30 PM.
 */
@Entity
@Table(name = "stock")
@NamedQueries({@NamedQuery(name = "Stock.findAll", query = Stock.GENERIC_SELECT)})
public class Stock extends BusinessDateMilestonedImpl
{

    public static final String GENERIC_SELECT = "select s from Stock s  where s.businessDateTo >= CURRENT_TIMESTAMP";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "value", nullable = false)
    private double value;

    public Stock()
    {
    }

    public Stock(String companyName, String symbol, double value)
    {
        this.companyName = companyName;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stock)) {
            return false;
        }

        final Stock that = (Stock) o;

        return Objects.equals(this.id, that.id) && Objects.equals(this.companyName, that.companyName) && Objects.equals(this.symbol, that.symbol);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, companyName, symbol);
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}
