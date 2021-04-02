package dao;

import java.sql.SQLException;
import java.util.List;

/**
 * CRUD template
 * <p>
 *     <li>1. C reate</li>
 *     <li>2. R etrieve</li>
 *     <li>3. U pdate</li>
 *     <li>4. D elete</li>
 * </p>
 * @param <E>
 */
public interface Dao<E> {
    E create(E entity) throws SQLException;

    E retrieve(int primaryKey) throws SQLException;

    List<E> retrieveAll() throws SQLException;

    void update(E entity) throws SQLException;

    void delete(E entity) throws SQLException;
}
