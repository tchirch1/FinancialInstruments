package com.utamatisi.app.db;

import com.google.common.base.Optional;
import com.utamatisi.app.models.domain.Todo;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class TodoDAO extends GenericDAO<Todo> {
    public TodoDAO(SessionFactory factory) {
        super(factory);
    }
    @Override
    public String getTableName() {
        return "Todo";
    }
}

