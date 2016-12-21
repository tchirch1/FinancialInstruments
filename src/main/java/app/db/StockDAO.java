package app.db;

import app.models.domain.Stock;
import org.hibernate.SessionFactory;

public class StockDAO extends GenericDAO<Stock>
{

    public StockDAO(SessionFactory factory)
    {
        super(factory);
    }

    @Override
    public String getTableName()
    {
        return "Stock";
    }
}

