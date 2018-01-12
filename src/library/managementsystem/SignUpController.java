/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.managementsystem;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell-i5
 */
public class SignUpController implements Initializable {
Connection conn;
ResultSet rs;
PreparedStatement psd;
javaConnect db=new javaConnect();
    @FXML
    private ComboBox<String> combo;
    @FXML
    private JFXButton create;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField pass;
    @FXML
    private TextField ans;
    @FXML
    private JFXButton back;

    public SignUpController(){
        conn=db.DbConnection();
        
        
    }
    
    //When user clicks the user Button
    @FXML
   public void CreateButton(ActionEvent event){
       try{
           String sql="INSERT INTO `account`(username,Name,password,sec_Q,Answer)VALUES(?,?,?,?,?)";
           psd=conn.prepareStatement(sql);
           psd.setString(1, username.getText());
           psd.setString(2, name.getText());
           psd.setString(3, pass.getText());
           psd.setString(4,combo.getSelectionModel().getSelectedItem().toString());
           psd.setString(5, ans.getText());
           psd.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("data register successfully");
            alert.setHeaderText("Thanks for your information");
            alert.setContentText("new Account Created sucessfully");
            alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
        System.out.println("Pressed OK.");
    }
});
           rs.close();
           psd.close();
       }catch(Exception e){
           System.out.println(e);
       }
   }
   
   //when user clicks the Back Button
@FXML
   public void BackButton(ActionEvent event){
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            Stage stage = new Stage();
           // stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            //stage.setTitle("ABC");
            stage.setScene(new Scene(root1));  
            stage.show();
            
       
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo.getItems().removeAll(combo.getItems());
    combo.getItems().addAll("What is your Mother Tongue?", " What is your NickName?", "Who is your first ChildHood Friend?","What is your School Name");
    combo.getSelectionModel().select("Select Questions?");
    }    
    
}
