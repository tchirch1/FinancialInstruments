package app.db;

import app.models.domain.Portfolio;
import org.hibernate.SessionFactory;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 10:47 PM.
 */
public class PortfolioDAO extends GenericDAO<Portfolio>
{

    public PortfolioDAO(SessionFactory factory)
    {
        super(factory);
    }

    @Override
    public String getTableName()
    {
        return "Portfolio";
    }

}
