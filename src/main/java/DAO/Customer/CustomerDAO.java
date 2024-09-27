package DAO.Customer;

import DAO.CrudDAO;
import Entity.CustomerEntity;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerEntity> {
    CustomerEntity searchById(String id) throws SQLException, ClassNotFoundException;

    List<String> getCustomerId();
}