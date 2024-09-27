package Controller;

import BO.BOFactory;
import BO.Customer.CustomerBO;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class CustomerControl {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableView<CustomerDTO> tblCustomr;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Customer);

    public void initialize() throws ClassNotFoundException {
        setCellValueFactory();
        loadAllCustomers();
        clearTextFiled();
    }

    private void loadAllCustomers() {
        ObservableList<CustomerDTO> obList = FXCollections.observableArrayList();
        try {
            List<CustomerDTO> customerDTOList = customerBO.getAll();
            for (CustomerDTO customerDTO : customerDTOList) {
                CustomerDTO tm = new CustomerDTO(
                        customerDTO.getId(),
                        customerDTO.getName(),
                        customerDTO.getPhone()

                );

                obList.add(tm);
            }

            tblCustomr.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
         String id = txtID.getText();

        try {
            boolean isDelete = customerBO.delete(id);
            if (isDelete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer delete successfully!").show();
                clearTextFiled();
                loadAllCustomers();



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String phone = txtPhone.getText();


        CustomerDTO customerDTO = new CustomerDTO(id, name, phone);

        try {
            boolean isSaved = customerBO.save(customerDTO);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer saved successfully!").show();
                clearTextFiled();
                loadAllCustomers();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String phone = txtPhone.getText();


        CustomerDTO customerDTO = new CustomerDTO(id, name, phone);

        try {
            boolean isSaved = customerBO.update(customerDTO);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Update successfully!").show();
                clearTextFiled();
                loadAllCustomers();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    void clearTextFiled(){
txtPhone.clear();
txtName.clear();
txtID.clear();
    }
}
