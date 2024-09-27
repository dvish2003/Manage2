package DAO;


import BO.Order.OrderBOImpl;
import DAO.Customer.CustomerDAOImpl;
import DAO.Item.ItemDAOImpl;
import DAO.Order.OrderDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOType {
        Customer,Item,Order
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){

            case Customer:
                return new CustomerDAOImpl();
            case Item:
                return new ItemDAOImpl();
                case Order:
                    return  new OrderDAOImpl();
            default:
                return null;

        }
    }
}
