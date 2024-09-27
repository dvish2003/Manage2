package DAO.Item;

import DAO.CrudDAO;
import Entity.ItemEntity;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemEntity> {
    ItemEntity searchById(String id) throws SQLException, ClassNotFoundException;

    List<String> getItemCode();
}
