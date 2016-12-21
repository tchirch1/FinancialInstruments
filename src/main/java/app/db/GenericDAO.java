package app.db;

import app.models.milestone.MilestonedObject;
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
        throw new RuntimeException("Please ensure this is implemented in the DAO class.");
    }

    @Override
    public M create(M object)
    {
        return persist(object);
    }

    @Override
    public List<M> findAll()
    {
        return list(namedQuery(getTableName() + ".findAll"));
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

