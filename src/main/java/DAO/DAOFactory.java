package DAO;


import BO.Order.OrderBOImpl;
import DAO.Customer.CustomerDAOImpl;
import DAO.Item.ItemDAOImpl;
import DAO.Order.OrderDAOImpl;
import DAO.PlaceOrderDAO.PlaceOrderDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        Customer,Item,Order,PlaceOrder
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){

            case Customer:
                return new CustomerDAOImpl();
            case Item:
                return new ItemDAOImpl();
                case Order:
                    return  new OrderDAOImpl();
                    case PlaceOrder:
                        return  new PlaceOrderDAOImpl();
            default:
                return null;

        }
    }
}
