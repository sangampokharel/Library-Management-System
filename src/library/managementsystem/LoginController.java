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
import java.sql.SQLException;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author dell-i5
 */
public class LoginController implements Initializable {
    Connection conn;
    ResultSet rs;
    PreparedStatement psd;
    javaConnect db=new javaConnect();
    private Label label;
    @FXML
    private JFXButton log;
    @FXML
    private JFXButton sign;
    @FXML
    private JFXButton forgot;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    
    public LoginController(){
         conn=db.DbConnection();
    }
    //whenlogin is pressed
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
     String user1=user.getText();
     String pass1=pass.getText();
     
     String sql="SELECT * FROM `account`WHERE username='"+user1+"' && password='"+pass1+"'";
     psd=conn.prepareStatement(sql);
     rs=psd.executeQuery();
     if(rs.next()){
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
         rs.close();
         psd.close();
     }else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong Security answer");
            alert.setHeaderText("Thanks for your information");
            alert.setContentText("problem with Security question");
                        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
        System.out.println("Pressed OK.");
    }
});
     }
       
    }
    
    //when forgot is pressed
    @FXML
    public void forgotButton(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forgot.fxml"));
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
    //when signup button is pressed
    public void SignUp(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign up.fxml"));
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
        // TODO
    }    

    
    
}
