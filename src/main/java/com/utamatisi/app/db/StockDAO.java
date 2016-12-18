package com.utamatisi.app.db;

import com.google.common.base.Optional;
import com.utamatisi.app.models.domain.Stock;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class StockDAO extends GenericDAO<Stock> {
    public StockDAO(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getTableName() {
        return "Stock";
    }
}

