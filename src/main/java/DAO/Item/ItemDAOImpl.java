package DAO.Item;

import Config.FactoryConfiguration;
import Entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(ItemEntity entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ItemEntity entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(id);
        session.delete(itemEntity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        List<ItemEntity> allItems = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        allItems = session.createQuery("from ItemEntity").list();
        transaction.commit();
        session.close();
        return allItems;
    }
    @Override
    public ItemEntity searchById(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        ItemEntity item = session.get(ItemEntity.class, id);
        transaction.commit();
        session.close();
        return item;
    }


    @Override
    public List<String> getItemCode() {
        Session session = null;
        Transaction transaction = null;
        List<String> itemCode = new ArrayList<>();

        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Use HQL to fetch only the customer IDs
            itemCode = session.createQuery("SELECT i.id FROM ItemEntity i", String.class).list();

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
        return itemCode;
    }

}
