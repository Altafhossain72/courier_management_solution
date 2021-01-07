package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

public class PlaceOrderController extends PlaceOrderDAO{
	
	@FXML
	private Button placeOrderButton , backButton;
	
	@FXML
	private ComboBox<String> sourceCityBox, sourceStateBox , destinationCityBox , destinationStateBox;
	
	@FXML 
	private TextField sourcePinField , destinationPinField , sourceAddressField , destinationAddressField ;

    static String name , pwd;
    
	ObservableList<String> sourceStateList=FXCollections.observableArrayList("Dhaka","Barisal","Chittagong","Comilla","Rajshahi");
	ObservableList<String> sourceCityList=FXCollections.observableArrayList("Mohakhali","Chipatoli","Halishohor","Mirpur","Shewla","Notunbajar");
	ObservableList<String> destinationStateList=FXCollections.observableArrayList("Dhaka","Barisal","Chittagong","Comilla","Rajshahi");
	ObservableList<String> destinationCityList=FXCollections.observableArrayList("Mohakhali","Chipatoli","Halishohor","Mirpur","Shewla","Notunbajar");
	ObservableList<String> sourceCityListMH=FXCollections.observableArrayList("Mohakhali","");
	ObservableList<String> sourceCityListGA=FXCollections.observableArrayList("Chipatoli");
	ObservableList<String> sourceCityListWB=FXCollections.observableArrayList("Halishohor");
	ObservableList<String> sourceCityListKA=FXCollections.observableArrayList("Shewla");
	ObservableList<String> sourceCityListAP=FXCollections.observableArrayList("Halishohor");
	ObservableList<String> destinationCityListMH=FXCollections.observableArrayList("Mohakhali","Chipatoli");
	ObservableList<String> destinationCityListGA=FXCollections.observableArrayList("Chipatoli");
	ObservableList<String> destinationCityListWB=FXCollections.observableArrayList("Halishohor");
	ObservableList<String> destinationCityListKA=FXCollections.observableArrayList("Shewla");
	ObservableList<String> destinationCityListAP=FXCollections.observableArrayList("Mirpur");

	@FXML
	private TextField packageNameField;

	@FXML
	private RadioButton FragileYesButton, FragileNoButton;

	@FXML
	private ToggleButton RegularDeliveryButton;

	@FXML
	private ToggleButton ExpressDeliveryButton;
    @FXML
    private ToggleGroup preferences;
    @FXML
    private ToggleGroup preferences1;
	
    public void setText (String name, String password)
    {
    	this.name = name;
    	this.pwd = password;
    	System.out.println(name);
    }
          @FXML
	   private void initialize() {
		   sourceStateBox.setValue("State");
		   sourceStateBox.setItems(sourceStateList);
		   
		   destinationStateBox.setValue("State");
		   destinationStateBox.setItems(destinationStateList);
		   
		   sourceCityBox.setValue("City");
		   sourceCityBox.setItems(sourceCityList);

		   destinationCityBox.setValue("City");
		   destinationCityBox.setItems(destinationCityList);
	   }
	   
	   @SuppressWarnings("unchecked")
	@FXML
	  public void CityChoice() {
		   if(sourceStateBox.getValue().equals("Dhaka")) {
			//   sourceCityBox.setValue("Noakhali");
			   sourceCityBox.setItems(sourceCityListMH);
		   } else if(sourceStateBox.getValue().equals("Barisal")) {
			   sourceCityBox.setValue("Chipatoli");
			   sourceCityBox.setItems(sourceCityListGA);
		   } else if(sourceStateBox.getValue().equals("Chittagong")) {
			   sourceCityBox.setValue("Halishohor");
			   sourceCityBox.setItems(sourceCityListWB);
		   } else if(sourceStateBox.getValue().equals("Comilla")) {
			   sourceCityBox.setValue("Mirpur");
			   sourceCityBox.setItems(sourceCityListAP);
		   } else if(sourceStateBox.getValue().equals("Rajshahi")) {
			   sourceCityBox.setValue("Shewla");
			   sourceCityBox.setItems(sourceCityListKA);
			   }
	   }
	
	   @SuppressWarnings("unchecked")
		@FXML
		   public void destCityChoice() {
			   if(destinationStateBox.getValue().equals("Dhaka")) {
				   //sourceCityBox.setValue("Noakhali");
				   destinationCityBox.setItems(destinationCityListMH);
			   } else if(destinationStateBox.getValue().equals("Barisal")) {
				   //destinationCityBox.setValue("Feni");
				   destinationCityBox.setItems(destinationCityListGA);
			   } else if(destinationStateBox.getValue().equals("Chittagong")) {
				   //destinationCityBox.setValue("Maijdi");
				   destinationCityBox.setItems(destinationCityListWB);
			   } else if(destinationStateBox.getValue().equals("Comilla")) {
			//	   destinationCityBox.setValue("Shajek");
				   destinationCityBox.setItems(destinationCityListAP);
			   } else if(destinationStateBox.getValue().equals("Rajshahi")) {
				//   sourceCityBox.setValue("Bandarban");
				   destinationCityBox.setItems(destinationCityListKA);
				   }
		   }
	   
   	 @SuppressWarnings("unchecked")
 	@FXML
 	    protected void handleSubmitButtonAction(ActionEvent event) {
 	        Window owner = placeOrderButton.getScene().getWindow();
 	        
 	        if(packageNameField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter your Package name!");
 	            
 	            return;
 	        }
 	        if(sourceAddressField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Source Address!");
 	            
 	            return;
 	        }
 	        
 	        if(sourceStateBox.getValue().toString().equals("State")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Source state!");
 	        	return;
 	        }
 	        if(sourceCityBox.getValue().toString().equals("City")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Source city!");
 	        	return;
 	        }
 	        
 	        if(sourcePinField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Pin code of source address!");
 	            
 	            return;
 	        }
 	        
 	        if(sourcePinField.getLength() < 6 || sourcePinField.getLength() >= 7) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "PIN should be of only 6 digit. Please re-enter valid PIN.");
 	            
 	            return;
 	        }
 	        
 	        if(destinationAddressField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Destination Address!");
 	            
 	            return;
 	        }
 	        
 	      
 	        if(destinationStateBox.getValue().toString().equals("State")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select Destination state!");
 	        	return;
 	        
 	        }
 	        
 	        if(destinationCityBox.getValue().toString().equals("City")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Destination city!");
 	        	return;
 	        }
 	        
 	        if(destinationPinField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Pin code of destination address!");
 	            
 	            return;
 	        }

 	        if(destinationPinField.getLength() < 6 || destinationPinField.getLength() >= 7) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "PIN should be of only 6 digit. Please re-enter valid PIN.");
 	            
 	            return;
 	        }
 	        
 	       if(FragileYesButton.isSelected()) {
 	    	   System.out.println("Fragile Package");
 	       } else if(FragileNoButton.isSelected()) {
 	    	   System.out.println("Normal Package");
 	    	   
 	       } else {
 	    	   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select the package type!");
 	    	   return;
 	       }
 	       
 	       if(RegularDeliveryButton.isSelected()) {
 	    	   System.out.println("Regular Delivery");
 	       } else if(ExpressDeliveryButton.isSelected()) {
 	    	   System.out.println("Express Delivery");
 	    	   
 	       } else {
 	    	   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select the delivery type!");
 	    	   return;
 	       }
 	       
 	       
 	        String sourceAddress=sourceAddressField.getText();
 	        String sourcePin=sourcePinField.getText();
 	        String destinationAddress=destinationAddressField.getText();
 	        String destinationPin=destinationPinField.getText();
 	        String pkgName=packageNameField.getText();
 	        String sourceState=sourceStateBox.getValue().toString();
 	        String destState=destinationStateBox.getValue().toString();
 	        String sourceCity=sourceCityBox.getValue().toString();
 	        String destCity=destinationCityBox.getValue().toString();
 	        String userID=name;
 	        
 	        //DaoModel d= new DaoModel();
 	        System.out.println("sourceAddress="+sourceAddress);
 	        System.out.println("sorcePin="+sourcePin);
 	        System.out.println("destinationAddress="+destinationAddress);
 	        System.out.println("destinationPin="+destinationPin);
 	        System.out.println("pkgName="+pkgName);
 	        System.out.println("sourceState="+sourceState);
 	        System.out.println("sourceCity="+sourceCity);
 	        System.out.println("destState="+destState);
 	        System.out.println("destCity="+destCity);
 	        System.out.println("Order placed by User:" +userID);
 	       
 	        
 	        String cost1 = findCostBySrcDest (sourceState, sourceCity, destCity, destState);
 	        System.out.println("Cost=" +cost1);
 	        int cost=Integer.parseInt(cost1);
 	        
 	        
 	        
 	       
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(getClass().getResource("ViewPlacedOrder.fxml"));
 	        try {
 	    loader.load();
 	    } catch (IOException e) {
 	    // TODO Auto-generated catch block
 	    e.printStackTrace();
 	    }
 	        ViewPlacedOrderController vpoc = loader.getController();
 	        double finalcost;
 	        double FragileCost=0;
 	        double expressCost=0;
 	        
 	        if(FragileYesButton.isSelected() && (ExpressDeliveryButton.isSelected())) {
 	        	FragileCost=100;
 	        	expressCost=100;
 	        	finalcost=cost+200;
 	        	
 	        } else if(FragileYesButton.isSelected() && (RegularDeliveryButton.isSelected())){
 	        	FragileCost=100;
 	        	expressCost=0;
 	        	finalcost=cost+100;
 	        	
 	        } else if(FragileNoButton.isSelected() && (ExpressDeliveryButton.isSelected())){
 	        	FragileCost=0;
 	        	expressCost=100;
 	        	finalcost=cost+100;}
 	        	else {
 	        	FragileCost=0;
 	        	expressCost=0;
 	        	finalcost=cost;
 	        }
 	        
 	        System.out.println("finalCost="+finalcost);
 	        String Fragile="";
 	        if(FragileYesButton.isSelected()) {
 	        	Fragile="Fragile Package";
 	        } else if(FragileNoButton.isSelected()) {
 	        	Fragile="Normal Package";
 	        }
 	        
 	        String DeliveryType="";
 	        if(RegularDeliveryButton.isSelected()) {
 	        	DeliveryType="Regular";
 	        } else if(ExpressDeliveryButton.isSelected()) {
 	        	DeliveryType="Express";
 	        }
 	    String costFinal=Double.toString(finalcost);
 	    String costFragile=Double.toString(FragileCost);
 	    String costExpress=Double.toString(expressCost);
 	    System.out.println("costFinal="+costFinal);
 	    vpoc.setText(pkgName,sourceAddress,sourceCity,sourceState,sourcePin,destinationAddress,destCity,destState,destinationPin,costFinal,Fragile,DeliveryType,userID,costFragile,costExpress);
 	    Parent p = loader.getRoot();
 	    Stage stage = new Stage();
 	    stage.setScene(new Scene(p));
 	    stage.show();
 	 }
		
 }   
