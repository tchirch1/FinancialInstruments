package com.utamatisi.app.db;

import com.google.common.base.Optional;
import com.utamatisi.app.models.domain.Portfolio;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 10:47 PM.
 */
public class PortfolioDAO extends GenericDAO<Portfolio> {
    public PortfolioDAO(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getTableName() {
        return "Portfolio";
    }

}
