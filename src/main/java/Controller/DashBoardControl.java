package Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashBoardControl {

    @FXML
    private Button btnCu;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnOrder;

    @FXML
    void btnCuOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Customer.fxml"));
        Parent rootNode = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/item_Manage.fxml"));
        Parent rootNode = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/order.fxml"));
        Parent rootNode = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.show();
    }

}
