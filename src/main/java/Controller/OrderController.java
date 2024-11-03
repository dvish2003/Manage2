/*
package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.Ijse.Animation1.Animation1;
import lk.Ijse.BO.BOFactory;
import lk.Ijse.BO.BookingBO.BookingBO;
import lk.Ijse.BO.CustomerBO.CustomerBO;
import lk.Ijse.BO.CustomerBO.CustomerBOImpl;
import lk.Ijse.BO.EmployeeBO.EmployeeBO;
import lk.Ijse.BO.LocationBO.LocationBO;
import lk.Ijse.BO.OrderBO.OrderBO;
import lk.Ijse.BO.OrderBO.OrderDetailBO;
import lk.Ijse.BO.OrderBO.PlaceOrderBO;
import lk.Ijse.BO.PaymentBO.PaymentBO;
import lk.Ijse.BO.ProductBO.ProductBO;
import lk.Ijse.BO.ProductShowroomBO.ProductShowRoomJoinBO;
import lk.Ijse.BO.ProductShowroomBO.Product_ShowRoom_BO;
import lk.Ijse.BO.RegisterBO.RegisterBO;
import lk.Ijse.BO.ShworoomBO.ShowRoomBO;
import lk.Ijse.BO.ShworoomBO.ShowRoomBOImpl;
import lk.Ijse.DAO.BookingDAO.BookingDAO;
import lk.Ijse.DAO.BookingDAO.BookingDAOImpl;
import lk.Ijse.DAO.EmployeeDAO.EmployeeDAO;
import lk.Ijse.DAO.EmployeeDAO.EmployeeDAOImpl;
import lk.Ijse.DAO.LocationDAO.LocationDAO;
import lk.Ijse.DAO.LocationDAO.LocationDAOImpl;
import lk.Ijse.DAO.OrderDAO.*;
import lk.Ijse.DAO.PaymentDAO.PaymentDAO;
import lk.Ijse.DAO.PaymentDAO.PaymentDAOImpl;
import lk.Ijse.DAO.ProductDAO.ProductDAO;
import lk.Ijse.DAO.ProductDAO.ProductDAOImpl;
import lk.Ijse.DAO.ProductShowroomDAO.ProductShowRoomJoinDAO;
import lk.Ijse.DAO.ProductShowroomDAO.ProductShowRoomJoinDAOImpl;
import lk.Ijse.DAO.ProductShowroomDAO.Product_ShowRoom_DAO;
import lk.Ijse.DAO.ProductShowroomDAO.Product_ShowRoom_DAOImpl;
import lk.Ijse.DAO.RegisterDAO.RegisterDAO;
import lk.Ijse.DAO.RegisterDAO.RegisterDAOImpl;
import lk.Ijse.DAO.ShworoomDAO.ShowRoomDAO;
import lk.Ijse.DAO.ShworoomDAO.ShowRoomDAOImpl;
import lk.Ijse.Db.DbConnection;
import lk.Ijse.Entity.Customer;
import lk.Ijse.Entity.Products;
import lk.Ijse.Entity.ShowRoom;
import lk.Ijse.dto.*;
import lk.Ijse.Util.CustomerRegex;
import lk.Ijse.Util.CustomerTextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


public class OrderController {


    @FXML
    private Button btnPrintBill;

    @FXML
    private Label LblOrderDate;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnNewCus;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPrBack;


    @FXML
    private AnchorPane orderPane;

    @FXML
    private ComboBox<String> cmbCustomerID;

    @FXML
    private ComboBox<String> cmbProductID;

    @FXML
    private ComboBox<String> cmbShowRoomID;

    @FXML
    private TableColumn<?, ?> colOrAction;

    @FXML
    private TableColumn<?, ?> colOrPrDesc;

    @FXML
    private TableColumn<?, ?> colOrPrID;

    @FXML
    private TableColumn<?, ?> colOrPrQty;

    @FXML
    private TableColumn<?, ?> colOrPrTotal;
    @FXML
    private TableView<Product_ShowRoomDTO> colPSTable;

    @FXML
    private TableColumn<?, ?> colJoinPR;

    @FXML
    private TableColumn<?, ?> colJoinSW;

    @FXML
    private TableColumn<?, ?> colOrPrUnitPrice;
    @FXML
    private TableView<CartTm> colOrderTel;
    @FXML
    private Label lblLocationShowRoom;

    @FXML
    private Label lblCustomerName;
    @FXML
    private Label lblQtyOnHand;


    @FXML
    private Label lblOrderID;

    @FXML
    private Label lblPayDate;

    @FXML
    private Label lblProductID;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblPaymentAmount;

    @FXML
    private Label lblPaymentID;
    private ObservableList<CartTm> obList = FXCollections.observableArrayList();


    @FXML
    private TextField txtQty;

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

  //  ShowRoomBO showRoomBO = (ShowRoomBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Booking);
    ShowRoomBO showRoomBO = new ShowRoomBOImpl();
    ProductShowRoomJoinBO productShowRoomJoinBO = (ProductShowRoomJoinBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.ProductShowRoomJoin);
    Product_ShowRoom_BO productShowRoomBo = (Product_ShowRoom_BO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Product_ShowRoom);
    ProductBO productBo = (ProductBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Products);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Customer);
    LocationBO locationBO = (LocationBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Location);
    OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Order);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Payment);
    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.OrderDetail);
    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Register);
    BookingBO bookingBO = (BookingBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Booking);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Employee);
      Animation1 animation1 = new Animation1();

    public void initialize() throws ClassNotFoundException {
        setDate();
        getCurrentOrderId();
        getCustomerIds();
        getCurrentPayId();
        applyButtonAnimations();
        applyLabelAnimations();
        getShowRoomIds();
        getProductIds();
        setCellValueFactory();
        loadAllPS();
        applyComboBoxStyles();



        cmbCustomerID.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                cmbShowRoomID.requestFocus();
            }
        });

        cmbShowRoomID.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                cmbProductID.requestFocus();
            }
        });

        cmbProductID.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                txtQty.requestFocus();
            }
        });



        colOrderTel.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtQty.requestFocus();
            }
        });

    }
    private void setCellValueFactory() {
        colOrPrID.setCellValueFactory(new PropertyValueFactory<>("P_ID"));
        colOrPrDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colOrPrUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colOrPrQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colOrPrTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colOrAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
        colJoinPR.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colJoinSW.setCellValueFactory(new PropertyValueFactory<>("showRoomId"));


    }

    private void loadAllPS() throws ClassNotFoundException {
        ObservableList<Product_ShowRoomDTO> obList = FXCollections.observableArrayList();

        try {
            List<Product_ShowRoomDTO> ps = productShowRoomBo.getAll();
            for (Product_ShowRoomDTO psList : ps) {
                Product_ShowRoomDTO tm = new Product_ShowRoomDTO(

                        psList.getShowRoomId(),
                        psList.getProductID()

                );

                obList.add(tm);
            }

            colPSTable.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void applyButtonAnimations() {
        animation1.applyAnimation(btnAddToCart);
        animation1.applyAnimation(btnNewCus);
        animation1.applyAnimation(btnPlaceOrder);
        animation1.applyAnimation(btnPrBack);
        animation1.applyAnimation(btnPrBack);
        animation1.applyAnimation(btnPrintBill);
        animation1.addHoverHandlers(btnAddToCart);
        animation1.addHoverHandlers(btnNewCus);
        animation1.addHoverHandlers(btnPlaceOrder);
        animation1.addHoverHandlers(btnPrBack);
        animation1.addHoverHandlers(btnPrBack);
        animation1.addHoverHandlers(btnPrintBill);

    }

    private void applyLabelAnimations() {
       animation1. applyAnimation(lblCustomerName);
       animation1. applyAnimation(lblQtyOnHand);
       animation1. applyAnimation(lblOrderID);
       animation1. applyAnimation(lblPayDate);
       animation1. applyAnimation(LblOrderDate);
       animation1. applyAnimation(lblUnitPrice);
       animation1. applyAnimation(lblPaymentAmount);
       animation1. applyAnimation(lblPaymentID);
       animation1. applyAnimation(lblLocationShowRoom);
       animation1. applyAnimation(lblProductID);



    }

    private void getCustomerIds() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<String> idList = customerBO.getIds();

            for(String id : idList) {
                obList.add(id);
            }

            cmbCustomerID.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getCurrentOrderId() throws ClassNotFoundException {
        try {
            String currentId = orderBO.getCurrentId();

            String nextOrderId = generateNextOrderId(currentId);
            lblOrderID.setText(nextOrderId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextOrderId(String currentId) {
        if (currentId != null) {
            String[] split = currentId.split("O");
            int idNum = Integer.parseInt(split[1]);
            idNum++;
            return "O" + String.format("%03d", idNum);
        }
        return "O001";
    }


    private void setDate() {
        LocalDate now = LocalDate.now();
        lblPayDate.setText(String.valueOf(now));
        LblOrderDate.setText(String.valueOf(now));
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
    String P_Id = lblProductID.getText();
    String Description =cmbProductID.getValue();
    int Unit_Price = Integer.parseInt(lblUnitPrice.getText());
    int Qty = Integer.parseInt(txtQty.getText());
    int Total_Price = Unit_Price * Qty;

        JFXButton btnRemove = new JFXButton("remove");
        btnRemove.setCursor(Cursor.HAND);
        btnRemove.setOnAction((e) -> {
            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if(type.orElse(no) == yes) {
                CartTm selectedIndex = colOrderTel.getSelectionModel().getSelectedItem();
                obList.remove(selectedIndex);

                colOrderTel.refresh();
                calculateNetTotal();
            }
        });
        for (int i = 0; i < colOrderTel.getItems().size(); i++) {
            if(P_Id.equals(colOrPrID.getCellData(i))){
                CartTm tm = obList.get(i);
                Qty += tm.getQty();
                Total_Price = Qty*Unit_Price;
                 tm.setQty(Qty);
                 tm.setTotal(Total_Price);

                 colOrderTel.refresh();
                 calculateNetTotal();
                 return;

            }
        }
        CartTm tm = new CartTm(P_Id,Description,Qty,Unit_Price,Total_Price,btnRemove);
        obList.add(tm);

        colOrderTel.setItems(obList);
        calculateNetTotal();
        txtQty.setText("");
    }

    private void calculateNetTotal() {
        int netTotal = 0;
        for (int i = 0; i < colOrderTel.getItems().size(); i++) {
            netTotal += (int) colOrPrTotal.getCellData(i);
        }
        lblPaymentAmount.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnNewCusOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CustomerForm.fxml"));
        Parent rootNode = loader.load();
        orderPane.getChildren().clear();
        orderPane.getChildren().add(rootNode);
        rootNode.setTranslateX(orderPane.getWidth());
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rootNode);
        transition.setToX(0);
        transition.play();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException, JRException, ClassNotFoundException {
        String orderID = lblOrderID.getText();
        String customerID = cmbCustomerID.getValue();
        String paymentID = lblPaymentID.getText();
        Date date = Date.valueOf(LocalDate.now());
        int Amount = Integer.parseInt(lblPaymentAmount.getText());

        var order = new OrderDTO(orderID, customerID, paymentID, date);
        List<OrderDetailDTO> odList = new ArrayList<>();

        for (int i = 0; i < colOrderTel.getItems().size(); i++) {
            CartTm tm = obList.get(i);
            OrderDetailDTO od = new OrderDetailDTO(
                    tm.getP_ID(),
                    orderID,
                    tm.getQty(),
                    tm.getUnitPrice()

            );

            odList.add(od);

        }

        PaymentDTO paymentDTO = new PaymentDTO(paymentID, Amount, date);
        PlaceOrderDTO po = new PlaceOrderDTO(order, odList, paymentDTO);

        boolean isPlaced = PlaceOrderBO.placeOrder(po);

        if (isPlaced) {
            obList.clear();
            colOrderTel.setItems(obList);
            cmbProduct
            oID.getSelectionModel().clearSelection();
            cmbCustomerID.getSelectionModel().clearSelection();
            cmbShowRoomID.getSelectionModel().clearSelection();
            lblLocationShowRoom.setText("");
            lblCustomerName.setText("");
            lblPaymentAmount.setText("");
            lblProductID.setText("");
           lblUnitPrice.setText("");
           lblQtyOnHand.setText("");
            txtQty.clear();

            getCurrentOrderId();
            getCurrentPayId();

            new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
          //  btnPrintBillOnAction(null);

        } else {
            new Alert(Alert.AlertType.WARNING, "Order Placed Unsuccessfully!").show();        }
    }

    @FXML
    void btnPrBackOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DashBoard_from.fxml"));
        Parent rootNode = loader.load();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);

        stage.show();
    }



    @FXML
    void cmbCustomerIDOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = cmbCustomerID.getValue();
        try {
            Customer customer = customerBO.searchById1(id);
if (customer != null){
    lblCustomerName.setText(customer.getName());
} else {
    lblCustomerName.setText("Customer Not Found ");

}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbProductIDOnAction(ActionEvent event) throws ClassNotFoundException {
        String Desc = String.valueOf(cmbProductID.getValue());
        try {
            Products products = productBo.searchByName(Desc);
            if(products != null) {
                lblProductID.setText(products.getProduct_id());
                lblUnitPrice.setText(String.valueOf(products.getProduct_unitPrice()));
                lblQtyOnHand.setText(String.valueOf(products.getShowRoom_qtyOnHand()));
            }else{
            lblProductID.setText("not Found");
            lblUnitPrice.setText("not Found");
            lblQtyOnHand.setText("not Found");
}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void getProductIds() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = productBo.getNames();
            obList.addAll(idList);
            cmbProductID.setItems(obList);
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error occurred while fetching Products IDs: " + e.getMessage());
        }

    }

    @FXML
    void cmbShowRoomIDOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = String.valueOf(cmbShowRoomID.getValue());
        try {
            ShowRoom showRoom = showRoomBO.searchById(id);
            if (showRoom != null){
                lblLocationShowRoom.setText(showRoom.getShowRoomLocation());

            } else {
                lblLocationShowRoom.setText("ShowRoom Not Found");


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getShowRoomIds() throws ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = showRoomBO.getIds();
            obList.addAll(idList);
            cmbShowRoomID.setItems(obList);
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Error occurred while fetching showroom IDs: " + e.getMessage());
        }
    }
    private void getCurrentPayId() throws ClassNotFoundException {
        try {
            String currentId = paymentBO.getCurrentId();

            String nextPayId = generateNextPay(currentId);
            lblPaymentID.setText(nextPayId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextPay(String currentId) {
        if (currentId != null && currentId.startsWith("P")) {

                int idNum = Integer.parseInt(currentId.substring(1)) + 1;
                return "P" + String.format("%03d", idNum);

        }
        return "P001";
    }
    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void QtyK(KeyEvent keyEvent) {
        CustomerRegex.setTextColor(CustomerTextField.NUMBER,txtQty);

    }
    @FXML
    private void btnPrintBillOnAction(ActionEvent event) throws JRException, SQLException {
           JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/Reports/OrderBillReport.jrxml");
        JRDesignQuery jrDesignQuery = new JRDesignQuery();
        jrDesignQuery.setText("SELECT o.Order_id, c.Customer_Name, p.Product_Description, od.Qty, od.Product_UnitPrice, py.Payment_Amount\n" +
                "FROM `Order` o\n" +
                "JOIN Customer c ON o.Customer_id = c.Customer_id\n" +
                "JOIN OrderDetails od ON o.Order_id = od.Order_id\n" +
                "JOIN Product p ON od.Product_id = p.Product_id\n" +
                "JOIN Payment py ON o.Payment_id = py.Payment_id\n" +
                "WHERE o.Order_id = (\n" +
                "    SELECT MAX(Order_id)\n" +
                "    FROM `Order`\n" +
                ");\n");
        jasperDesign.setQuery(jrDesignQuery);
           JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);



        JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperReport, null,DbConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);



    }

    public void applyComboBoxStyles() {
        cmbProductID.setStyle(" -fx-text-fill: white;");
        cmbShowRoomID.setStyle(" -fx-text-fill: white;");
        cmbCustomerID.setStyle(" -fx-text-fill: white;");


    }
}
*/
