package BO.Customer;

import BO.SuperBO;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    public  boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public List<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    CustomerDTO searchByIdCustomer(String id) throws SQLException, ClassNotFoundException;
}