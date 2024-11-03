package BO.placeOrderBO;

import BO.SuperBO;
import dto.PlaceOrder;

import java.util.List;

public interface PlaceOderBO extends SuperBO {
    List<String> getCustomerId();

    List<String> getItemCode();

    boolean placeOrder (PlaceOrder placeOrder);


}
