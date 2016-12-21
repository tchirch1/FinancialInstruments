package com.utamatisi.app.db;

import com.utamatisi.app.models.domain.Todo;
import org.hibernate.SessionFactory;

public class TodoDAO extends GenericDAO<Todo>
{

    public TodoDAO(SessionFactory factory)
    {
        super(factory);
    }

    @Override
    public String getTableName()
    {
        return "Todo";
    }
}

