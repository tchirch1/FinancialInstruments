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
public class PortfolioDAO extends AbstractDAO<Portfolio> {
    public PortfolioDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Portfolio> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Portfolio create(Portfolio portfolio) {
        Portfolio persist = persist(portfolio);
        return persist;
    }
    public List<Portfolio> findAll() {
        return list(namedQuery("Portfolio.findAll"));
    }

    public void delete(Long id) {
        Portfolio portfolio = findById(id).get();
        portfolio.delete();
        currentSession().saveOrUpdate(portfolio);
    }

}
