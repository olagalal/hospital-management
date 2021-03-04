/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author Mahmoud Qussai
 */
public class LoginController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button bLogin;
    @FXML
    private Label exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setAction(ActionEvent event) throws IOException {
        
        Parent root = null;
        if(username.getText().equals("admin")&&password.getText().equals("admin")){
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        }else if(username.getText().equals("doctor")&&password.getText().equals("doctor")){
            root = FXMLLoader.load(getClass().getResource("User.fxml"));
        }else if(username.getText().length()>0&&password.getText().length()>0){
            root = FXMLLoader.load(getClass().getResource("ErrorMessage.fxml"));            
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void toExit(MouseEvent event) {
        System.exit(0);
    }
    
}
