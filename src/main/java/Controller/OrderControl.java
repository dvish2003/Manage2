package Controller;


import BO.BOFactory;
import BO.Customer.CustomerBO;
import BO.Item.ItemBO;
import BO.Order.OrderBO;
import BO.placeOrderBO.PlaceOderBO;
import Tm.CartTm;
import com.jfoenix.controls.JFXButton;
import dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderControl {
    public Button btnBack;
    public TableColumn colAction;
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
    private TableView<CartTm> tblOrder;

    @FXML
    private Label LblQty;

    @FXML
    private Label Lblprice;
    @FXML
    private TextField txtOrderID;


    @FXML
    private TextField txtQty;


    private ObservableList<CartTm> obList = FXCollections.observableArrayList();

    @FXML
    private TextField txtTotal;
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Customer);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Item);
    PlaceOderBO po = (PlaceOderBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.PaceOrder);
    OrderBO ob = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Order);

    public void initialize() throws SQLException, ClassNotFoundException {
       getCustomerIds();
       getItemIds();
       setCllValueFactory();

    }

    private void setCllValueFactory() {
        colOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colItemID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));

    }


   /* @FXML
    void btnCartOnAction(ActionEvent event) {
        String oID = txtOrderID.getText();
      String cusID = cmbCusID.getValue();
      String itemCode = cmbItemID.getValue();
      String qty = txtQty.getText();
      int price = Integer.parseInt(Lblprice.getText());
      String ItemName = lblName.getText();
      int total = price * Integer.parseInt(qty);

        for (int i = 0; i < tblOrder.getItems().size(); i++) {
         if(itemCode.equals(colItemID.getCellData(i))){
             CartTm cartTm = obList.get(i);
             qty += cartTm.getItemQuantity();
             total = price * Integer.parseInt(qty);
             cartTm.setItemQuantity(qty);
             cartTm.setTotal(total);


             tblOrder.refresh();
             calculateNetTotal();
             return;

         }
         CartTm cartTm = new CartTm(oID,cusID,itemCode,ItemName,price,qty,total);
         obList.add(cartTm);
         calculateNetTotal();
         tblOrder.setItems(obList);
        }
    }
    */
   @FXML
   void btnCartOnAction(ActionEvent event) {
       String oID = txtOrderID.getText();
       String cusID = cmbCusID.getValue();
       String itemCode = cmbItemID.getValue();
       String qty = txtQty.getText();
       int price = Integer.parseInt(Lblprice.getText());
       String ItemName = lblName.getText();
       int total = price * Integer.parseInt(qty);


       JFXButton btnRemove = new JFXButton("remove");
       btnRemove.setCursor(Cursor.HAND);
       btnRemove.setOnAction((e) -> {
                   ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
                   ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

                   Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

                   if(type.orElse(no) == yes) {
                       CartTm selectedIndex = tblOrder.getSelectionModel().getSelectedItem();
                       obList.remove(selectedIndex);

                       tblOrder.refresh();
                       calculateNetTotal();
                   }
                   });
       for (int i = 0; i < tblOrder.getItems().size(); i++) {
           if (itemCode.equals(colItemID.getCellData(i))) {
               CartTm cartTm = obList.get(i);
               int updatedQty = Integer.parseInt(cartTm.getItemQuantity() + qty);
               int updatedTotal = price * updatedQty;
               cartTm.setItemQuantity(String.valueOf(updatedQty));
               cartTm.setTotal(updatedTotal);

               // Refresh the TableView to show updated values
               tblOrder.refresh();
               calculateNetTotal();
               return;
           }
       }

       CartTm cartTm = new CartTm(oID, cusID, itemCode,ItemName, price, qty, total,btnRemove);
       obList.add(cartTm);
       tblOrder.setItems(obList);
       calculateNetTotal();
   }
    /*  @FXML
    void btnCartOnAction(ActionEvent event) {
      String oID = txtOrderID.getText();
      String cusID = cmbCusID.getValue();
      String itemCode = cmbItemID.getValue();
      String qty = txtQty.getText();
      int price = Integer.parseInt(Lblprice.getText());
      String ItemName = lblName.getText();
      int total = price * Integer.parseInt(qty);

        // Check if item already exists in the cart
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            if (itemCode.equals(colItemID.getCellData(i))) {
                CartTm cartTm = obList.get(i);
                int updatedQty = cartTm.getQty() + qty;
                int updatedTotal = price * updatedQty;
                cartTm.setQty(updatedQty);
                cartTm.setTotal(updatedTotal);

                // Refresh the TableView to show updated values
                tblOrder.refresh();
                calculateNetTotal();
                return;
            }
        }

        // Add new item to the cart
        CartTm cartTm = new CartTm(oID, cusID, itemCode, itemName, price, qty, total);
        obList.add(cartTm);
        tblOrder.setItems(obList);
        calculateNetTotal();
    }*/

    private void calculateNetTotal() {
        int netTotal = 0;
        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            netTotal += (int) colTotal.getCellData(i);
        }
        txtTotal.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        String oID = txtOrderID.getText();
        String cusID = cmbCusID.getValue();
        String itemCode = cmbItemID.getValue();
        String qty = txtQty.getText();
        int price = Integer.parseInt(Lblprice.getText());
        String ItemName = lblName.getText();
        int total = Integer.parseInt(txtTotal.getText());

        OrderDTO orderDTO = new OrderDTO(oID,cusID,itemCode,total);
        List<OrderDetailDTO> odList = new ArrayList<>();

        for (int i = 0; i < tblOrder.getItems().size(); i++) {
            CartTm tm = obList.get(i);
            OrderDetailDTO od = new OrderDetailDTO(
                    tm.getOrderID(),
                    tm.getItemID(),
                    tm.getItemQuantity(),
                    tm.getItemPrice()
            );
            odList.add(od);

        }

        PlaceOrder placeOrder = new PlaceOrder(orderDTO,odList);
boolean isPlace = po.placeOrder(placeOrder);

if(isPlace){
    obList.clear();
    lblName.setText("");
    Lblprice.setText("");
    LblQty.setText("");
    cmbItemID.getSelectionModel().clearSelection();
    cmbCusID.getSelectionModel().clearSelection();
    txtOrderID.clear();
    txtQty.clear();
    txtTotal.clear();
    new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();

} else {
    new Alert(Alert.AlertType.WARNING, "Order Placed Unsuccessfully!").show();
}

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
        String id = cmbItemID.getValue();
        try {
            ItemDTO itemDto = itemBO.searchByItemCode(id);
            if(itemDto != null) {
                lblName.setText(itemDto.getItemName());
                Lblprice.setText(String.valueOf(itemDto.getItemPrice()));
                LblQty.setText(itemDto.getItemQty());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
        Parent rootNode = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();
    }
}
/*package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.BO.BOFactory;
import lk.ijse.BO.custome.CustomerBO;
import lk.ijse.BO.custome.ItemBO;
import lk.ijse.BO.custome.OrderBo;
import lk.ijse.BO.custome.PlaceOderBO;
import lk.ijse.DTO.CustomerDTO;
import lk.ijse.DTO.ItemDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderFormController {

    @FXML
    private AnchorPane anpPlaceOrder;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblTotal;

    @FXML
    private TableView<?> tblPlaceOrder;


    @FXML
    private ComboBox<String> comCustomerId;

    @FXML
    private ComboBox<String> comItemCode;

    @FXML
    private Label lblCusName;


    @FXML
    private TextField txtQty;

    OrderBo orderBo = (OrderBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDER);
    PlaceOderBO placeOderBO = (PlaceOderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PLACEORDER);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ITEM);


    public void initialize() throws SQLException, ClassNotFoundException {
        genaretNextOrderId();
        setDate();
        getCustomerId();
        getItemCode();
    }

    private void getItemCode() {
        ObservableList<String> codes = FXCollections.observableArrayList();
        List<String> itemIdList = placeOderBO.getItemCode();

        for (String itemCode : itemIdList) {
            codes.add(itemCode);
        }
        comItemCode.setItems(codes);
    }

    private void getCustomerId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> cusIdList = placeOderBO.getCustomerId();

        for (String id : cusIdList) {
            obList.add(id);
        }
        comCustomerId.setItems(obList);

    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        lblOrderDate.setText(String.valueOf(now));
    }

    private void genaretNextOrderId() throws SQLException, ClassNotFoundException {
        String id = orderBo.generateNextIdOrder();
        lblOrderId.setText(id);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage;
        stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/HomeForm.fxml"))));
        stage.setTitle("Home Form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void comCustomerIdOnAction(ActionEvent event) {
        String cusId = comCustomerId.getValue();

        try {
            CustomerDTO customer = customerBO.searchByIdCustomer(cusId);
            if(customer != null) {
                lblCusName.setText(customer.getName());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void comItemCodeOnAction(ActionEvent event) {
        String itemCode = comItemCode.getValue();
        try {
            ItemDTO item = itemBO.searchByItemCode(itemCode);
            if(item != null) {
                lblDesc.setText(item.getItemDesc());
                lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
                lblPrice.setText(String.valueOf(item.getItemPrice()));
            }
            txtQty.requestFocus();
        }catch(SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
        btnAddToCartOnAction(event);
    }

    private void btnAddToCartOnAction(ActionEvent event) {

    }

}
*/