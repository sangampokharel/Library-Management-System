/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.managementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell-i5
 */
public class ForgotController implements Initializable {

Connection conn;
ResultSet rs;
PreparedStatement psd;
javaConnect db=new javaConnect();
    @FXML
    private Button forgot;
    @FXML
    private TextField usernames;
    @FXML
    private TextField textfield2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textfield4;
    
    @FXML
    private TextField textfield5;

public ForgotController(){
     conn=db.DbConnection();
}
public void search1() throws SQLException{
    String al=usernames.getText();
    String sql="SELECT * FROM `account` WHERE username='"+al+"'";
    
        psd=conn.prepareStatement(sql);
        rs=psd.executeQuery();
        if(rs.next()){
            usernames.setText(rs.getString(1));
            textfield2.setText(rs.getString(2));
            textField3.setText(rs.getString(4));
            
            
        }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("no username");
            alert.setHeaderText("sorry");
            alert.setContentText("please register ");
                         alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
        System.out.println("Pressed OK.");
    }
});   
    }
        
   
    
    
}
//when retrieve is clicked
@FXML
public void Retrive(){
     String al=usernames.getText();
     String a2=textfield4.getText();
        String sql="SELECT * FROM `account` WHERE Answer='"+a2+"'";
    try {
         psd=conn.prepareStatement(sql);
        rs=psd.executeQuery();
        if(rs.next()){
            textfield5.setText(rs.getString(3));
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
    } catch (SQLException ex) {
        Logger.getLogger(ForgotController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
//when user click search Button
    @FXML
    public void Search() throws SQLException{
    search1();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
