package BO;


import BO.Customer.CustomerBOmpl;
import BO.Item.ItemBOImpl;
import BO.Order.OrderBOImpl;
import BO.placeOrderBO.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
private BOFactory() {

}

public static BOFactory getBoFactory() {
    return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
}
public enum BoType{
    Customer,Item,Order,PaceOrder

}
    public SuperBO getBo(BoType boType){
        switch (boType){

                case Customer:
                return new CustomerBOmpl();
            case Item:
                return new ItemBOImpl();
                case PaceOrder:
                    return  new PlaceOrderBOImpl();
                    case Order:
                        return  new OrderBOImpl();
            default:
                return null;

        }
    }
}
