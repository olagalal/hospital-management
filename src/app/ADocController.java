/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.PatientControl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Patient;

/**
 * FXML Controller class
 *
 * @author Mahmoud Qussai
 */
public class ADocController implements Initializable {
    @FXML
    private Button bNew;
    @FXML
    private Button bSearch;
    @FXML
    private Button bEdit;
    @FXML
    private Button bDelete;
    @FXML
    private Button bBack;
    @FXML
    private Button bExit;
    @FXML
    private TextField fName;
    @FXML
    private TextField fSpec;
    @FXML
    private TextField fPhone;
    @FXML
    private TextField fSearch;
    
    PatientControl pp = new PatientControl();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void toNew(ActionEvent event) {
    }

    @FXML
    private void toSearch(ActionEvent event) {
    }

    @FXML
    private void toEdit(ActionEvent event) {
    }

    @FXML
    private void toDelete(ActionEvent event) {
    }

    @FXML
    private void toBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void toExit(ActionEvent event) {
        System.exit(0);
    }
    
}
