package DAO.Order;

import Entity.OrderEntity;

import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(OrderEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<OrderEntity> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
