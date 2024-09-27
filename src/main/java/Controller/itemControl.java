package Controller;

import BO.BOFactory;
import BO.Item.ItemBO;
import dto.ItemDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class itemControl {

    public TableColumn colPrice;

    public TextField txtPrice;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Item);


    public void initialize() throws ClassNotFoundException {
        setCellValueFactory();
        loadAllItem();
        clearTextFiled();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("itemQty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
    }

    private void loadAllItem() {
        ObservableList<ItemDTO> obList = FXCollections.observableArrayList();
        try {
            List<ItemDTO> itemDTOS = itemBO.getAll();
            for (ItemDTO itemDTO : itemDTOS) {
                ItemDTO item = new ItemDTO(
                        itemDTO.getId(),
                        itemDTO.getItemName(),
                        itemDTO.getItemQty(),
                        itemDTO.getItemPrice()
                );
                obList.add(item);
            }
            tblItem.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    String id = txtId.getText();
    try {
        boolean isDelete = itemBO.delete(id);
        if (isDelete) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item delete successfully!").show();
            clearTextFiled();
            loadAllItem();

        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String QTY = txtDescription.getText();
        int itemPrice = Integer.parseInt(txtPrice.getText());

        ItemDTO obj = new ItemDTO(id, name, QTY,itemPrice);
      try {
          boolean isSaved = itemBO.save(obj);
          if (isSaved) {
              new Alert(Alert.AlertType.CONFIRMATION, "Item saved successfully!").show();
              clearTextFiled();
              loadAllItem();

          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String QTY = txtDescription.getText();
        int itemPrice = Integer.parseInt(txtPrice.getText());

        ItemDTO obj = new ItemDTO(id, name, QTY,itemPrice);
        try {
            boolean isUpdate = itemBO.update(obj);
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Update successfully!").show();
                clearTextFiled();
                loadAllItem();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void clearTextFiled(){
        txtId.clear();
        txtName.clear();
        txtPrice.clear();
        txtDescription.clear();
    }
}
