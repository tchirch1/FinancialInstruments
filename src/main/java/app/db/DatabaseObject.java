package app.db;

import app.models.milestone.MilestonedObject;

import java.util.List;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 1:40 PM.
 */
public interface DatabaseObject<M extends MilestonedObject>
{

    String getTableName();

    List<M> findAll();

    M findById(Long id);

    M create(M object);

    void update(M object);

    void delete(M object);

}
