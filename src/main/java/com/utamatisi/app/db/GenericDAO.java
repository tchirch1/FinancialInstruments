package com.utamatisi.app.db;

import com.utamatisi.app.models.milestone.MilestonedObject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericDAO<M extends MilestonedObject> extends AbstractDAO<M> implements DatabaseObject<M>
{

    public GenericDAO(SessionFactory factory)
    {
        super(factory);
    }

    @Override
    public String getTableName()
    {
        return null;
    }

    @Override
    public M create(M object)
    {
        M persist = persist(object);
        return persist;
    }

    @Override
    public List<M> findAll()
    {
        List<M> objects = list(namedQuery(getTableName() + ".findAll"));
        return objects;
    }

    @Override
    public M findById(Long id)
    {
        return get(id);
    }

    @Override
    public void update(M object)
    {
        currentSession().saveOrUpdate(object);
    }

    @Override
    public void delete(M object)
    {
        object.delete();
        currentSession().saveOrUpdate(object);
    }

    public void delete(Long id)
    {
        this.delete(this.findById(id));
    }

}

