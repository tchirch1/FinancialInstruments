package com.utamatisi.app.db;

import com.utamatisi.app.models.domain.Stock;
import com.utamatisi.app.models.milestone.BusinessDateMilestonedImpl;
import com.utamatisi.app.models.milestone.MilestonedObject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAO<M extends MilestonedObject> extends AbstractDAO<M> {
    public GenericDAO(SessionFactory factory) {
        super(factory);
    }

    public List<M> findAll() {
        List<M> objects = list(namedQuery(getTableName() + ".findAll"));
        return objects;
    }
    public M create(M object) {
        M persist = persist(object);
        return persist;
    }

    public void delete(Long id) {
        M object = get(id);
        object.delete();
        currentSession().saveOrUpdate(object);
    }

    public abstract String getTableName();
}

