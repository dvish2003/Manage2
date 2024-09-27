package DAO.Customer;

import Config.FactoryConfiguration;
import Entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public  boolean save(CustomerEntity Entity) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customer = new CustomerEntity(Entity.getId(),Entity.getName(),Entity.getPhone());
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(CustomerEntity Entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(Entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(Integer.parseInt(id));
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
       List<CustomerEntity> allCustomers = new ArrayList<>();
       Session session = FactoryConfiguration.getInstance().getSession();
       Transaction transaction = session.beginTransaction();
       allCustomers = session.createQuery("from CustomerEntity").list();
       transaction.commit();
       session.close();
       return allCustomers;

    }
    @Override
    public CustomerEntity searchById(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        CustomerEntity customer = session.get(CustomerEntity.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<String> getCustomerId() {
        Session session = null;
        Transaction transaction = null;
        List<String> customerIds = new ArrayList<>();

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Use HQL to fetch only the customer IDs
            customerIds = session.createQuery("SELECT c.id FROM CustomerEntity c", String.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customerIds;

    }

}
