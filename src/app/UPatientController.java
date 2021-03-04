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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Patient;

/**
 * FXML Controller class
 *
 * @author Mahmoud Qussai
 */
public class UPatientController implements Initializable {
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
    private TableView<Patient> table;
    @FXML
    private TextField fName;
    @FXML
    private TextField fAge;
    @FXML
    private TextField fPhone;
    @FXML
    private TextField fSearch;
    @FXML
    private TextField fBloodType;
    
    private final TableColumn<Patient, String> columnName = new TableColumn("Name");
    private final TableColumn<Patient, Integer> columnAge = new TableColumn("Age");
    private final TableColumn<Patient, String> columnPhone = new TableColumn("Phone");
    private final TableColumn<Patient, String> columnBloodType = new TableColumn("Blood Type");

    
    PatientControl cPatient = new PatientControl();
    static int tempID;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnBloodType.setCellValueFactory(new PropertyValueFactory<>("bloodType"));
        
        columnName.prefWidthProperty().bind(table.widthProperty().divide(3));
        columnAge.prefWidthProperty().bind(table.widthProperty().divide(9));
        columnPhone.prefWidthProperty().bind(table.widthProperty().divide(3));
        columnBloodType.prefWidthProperty().bind(table.widthProperty().divide(5));
                
        table.getColumns().addAll(columnName, columnAge, columnPhone, columnBloodType);
        table.setItems(cPatient.getAllUsers());
               
    }
  
    @FXML
    private void toNew(ActionEvent event) {
        Patient mPatient = new Patient();
        mPatient.setName(fName.getText());
        mPatient.setAge(Integer.parseInt(fAge.getText()));
        mPatient.setPhone(fPhone.getText());
        mPatient.setBloodType(fBloodType.getText());
        cPatient.insert(mPatient);
        
        fName.setText("");
        fAge.setText("");
        fPhone.setText("");
        fBloodType.setText("");
        
        table.setItems(cPatient.getAllUsers());
        
    }

    @FXML
    private void toSearch(ActionEvent event) {
        table.setItems(cPatient.Search(fSearch.getText()));
    }
    
    @FXML
    private void toView(ActionEvent event) {
        table.setItems(cPatient.getAllUsers());
    }

    @FXML
    private void toEdit(ActionEvent event) {
        Patient mPatient = new Patient();
        mPatient.setName(fName.getText());
        mPatient.setAge(Integer.parseInt(fAge.getText()));
        mPatient.setPhone(fPhone.getText());
        mPatient.setBloodType(fBloodType.getText());
        mPatient.setId(tempID);
        
        fName.setText("");
        fAge.setText("");
        fPhone.setText("");
        fBloodType.setText("");
        
        cPatient.update(mPatient);
        table.setItems(cPatient.getAllUsers());
    }

    @FXML
    private void toDelete(ActionEvent event) {
        Patient mPatient = new Patient();
        mPatient.setId(tempID);
        
        fName.setText("");
        fAge.setText("");
        fPhone.setText("");
        fBloodType.setText("");
        
        cPatient.delete(tempID);
        table.setItems(cPatient.getAllUsers());
    }

    @FXML
    private void toBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
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

    @FXML
    private void setAction(MouseEvent event) {
        Patient p = table.getSelectionModel().getSelectedItem();
        fName.setText(p.getName());
        fAge.setText(Integer.toString(p.getAge()));
        fPhone.setText(p.getPhone());
        fBloodType.setText(p.getBloodType());
        
        tempID = p.getId();
    }

    
}
