package BO.placeOrderBO;

import Config.FactoryConfiguration;
import DAO.Customer.CustomerDAO;
import DAO.DAOFactory;
import DAO.Item.ItemDAO;
import DAO.Order.OrderDAO;
import dto.PlaceOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlaceOrderBOImpl implements PlaceOderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Customer);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Item);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Order);

    @Override
    public List<String> getCustomerId() {

        return customerDAO.getCustomerId();
    }

    @Override
    public List<String> getItemCode() {

        return itemDAO.getItemCode();
    }

    @Override
    public boolean placeOrder(PlaceOrder placeOrder) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
try {

} catch (Exception e) {
    throw new RuntimeException(e);
}
        return false;
    }
}
