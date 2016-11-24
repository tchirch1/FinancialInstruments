package com.utamatisi.app.db;

import com.google.common.base.Optional;
import com.utamatisi.app.models.domain.Stock;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class StockDAO extends AbstractDAO<Stock> {
    public StockDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Stock> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Stock create(Stock Stock) {
        Stock persist = persist(Stock);
        return persist;
    }
    public List<Stock> findAll() {
        return list(namedQuery("Stock.findAll"));
    }

    public void delete(Long id) {
        Stock Stock = findById(id).get();
        Stock.delete();
        currentSession().saveOrUpdate(Stock);
    }

}

