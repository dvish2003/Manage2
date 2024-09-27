package BO.Customer;

import DAO.Customer.CustomerDAO;
import DAO.DAOFactory;
import Entity.CustomerEntity;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOmpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Customer);
    @Override
    public  boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new CustomerEntity(customer.getId(),customer.getName(),customer.getPhone()));
    }

    @Override
    public boolean update(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new CustomerEntity(customer.getId(),customer.getName(),customer.getPhone()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    public List<CustomerDTO> getAll() throws SQLException, ClassNotFoundException{
    List<CustomerDTO> customerDTOS = new ArrayList<>();
    List<CustomerEntity> customerEntities = customerDAO.getAll();
    for (CustomerEntity customerEntity : customerEntities) {
    customerDTOS.add(new CustomerDTO(customerEntity.getId(),customerEntity.getName(),customerEntity.getPhone()));
    }
return customerDTOS;
}
    @Override
    public CustomerDTO searchByIdCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerEntity customer = customerDAO.searchById(id);
        CustomerDTO Result = new CustomerDTO();
        Result.setId(Integer.parseInt(customer.getId()));
        Result.setName(customer.getName());
        Result.setPhone(customer.getPhone());
        return  Result;
    }
}
