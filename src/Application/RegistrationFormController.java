package application;
import java.io.IOException;
import java.sql.SQLException;
//import java.util.Optional;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
//import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;


public class RegistrationFormController extends DaoModel{
	
	
	private TextField userIdField;
	
    private TextField fNameField;
    
    private TextField lNameField;

    private TextField addressField;
    
    private TextField emailField;

    private PasswordField passwordField;

    private TextField contactNoField;
    private Button submitButton;
    public int i=0;
    
    
    
    @FXML
    public void onsignIn(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 450, 450));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    public void onsignUp(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("LoginDemoProj.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 450, 600));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    public void onAdminLogin(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     @FXML
    protected void handleBackButtonAction(ActionEvent event) {
    	//backButton.getScene().getWindow().
    }
    
    @FXML
    public void onAboutUs(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("AboutUs.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 450, 450));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    public void onContactUs(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("ContactUs.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 450, 450));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();
        if(userIdField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your User ID");
            
            return;
        }
        if(fNameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            
            return;
        }
        if(lNameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your last name");
            
            return;
        }
        if(addressField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Address");
            
            return;
        }
        if(emailField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            
            return;
        }
        if(passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            
            return;
        }
        
        if(contactNoField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Contact Number");
            
            return;
        }
        String userID=userIdField.getText();
        String ufname=fNameField.getText();
        String ulname=lNameField.getText();
        String address=addressField.getText();
        String email=emailField.getText();
        String pass=passwordField.getText();
        String num=contactNoField.getText();
        //DaoModel d= new DaoModel();
        System.out.println(userIdField.getText());
        
			try {
				String s;
				s = insertTable(userID, ufname, ulname, address, email, pass, num );
				return;
				//AnchorPane root;
				//Parent root = null;
				/*try {
					root = FXMLLoader.load(getClass().getResource("/application/UserLogin.fxml"));
				 
				Stage stage = new Stage();
				stage.setScene(new Scene(root, 450, 450));
				stage.show();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			} catch (SQLException e) {
				AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Status!", "Duplicate user ID");
				System.out.println("duplicate");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



        	
        	
     
        
    }
}