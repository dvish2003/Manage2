package BO.placeOrderBO;

import DAO.Customer.CustomerDAO;
import DAO.DAOFactory;
import DAO.Item.ItemDAO;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Customer);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Item);
    @Override
    public List<String> getCustomerId() {

        return customerDAO.getCustomerId();
    }

    @Override
    public List<String> getItemCode() {

        return itemDAO.getItemCode();
    }
}
