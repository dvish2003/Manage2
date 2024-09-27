package Controller;


import BO.BOFactory;
import BO.Customer.CustomerBO;
import BO.Item.ItemBO;
import BO.Order.OrderBO;
import BO.placeOrderBO.PlaceOderBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.List;

public class OrderControl {
   @FXML
    private Label lblName;
    @FXML
    private Button btnCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private ComboBox<String> cmbCusID;

    @FXML
    private ComboBox<String> cmbItemID;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colItemID;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private Label LblQty;

    @FXML
    private Label Lblprice;
    @FXML
    private TextField txtOrderID;


    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtTotal;
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Customer);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Item);
    PlaceOderBO po = (PlaceOderBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.PaceOrder);
    OrderBO ob = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Order);

    public void initialize() throws SQLException, ClassNotFoundException {
       getCustomerIds();
       getItemIds();
    }



    @FXML
    void btnCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusIDOnAction(ActionEvent event) {
    String id = cmbCusID.getSelectionModel().getSelectedItem().toString();
  try {
      CustomerDTO customerDTO = customerBO.searchByIdCustomer(id);
  } catch (Exception e) {
      throw new RuntimeException(e);
  }
    }

    private void getCustomerIds() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> CID = po.getCustomerId();

            for (String s : CID) {
                obList.add(s);
            }
            cmbCusID.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void getItemIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> ItemID = po.getItemCode();

            for (String s : ItemID) {
                obList.add(s);
            }
            cmbItemID.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemIDOnAction(ActionEvent event) {
        String id = cmbItemID.getSelectionModel().getSelectedItem().toString();
        try {
            ItemDTO itemDto = itemBO.searchByItemCode(id);
            if(itemDto == null) {
                txtName.setText(itemDto.getItemName());
                txtOrderID.setText(id);
                txtPrice.setText(String.valueOf(itemDto.getItemPrice()));
                txtQty.setText(itemDto.getItemQty());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
