package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RegisterViewController{

	private BorderPane rootLayout;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtPostal;

    @FXML
    private TextField txtBPhone;

    @FXML
    private TextField txtPPhone;

    @FXML
    private TextField txtEMail;

    @FXML
    private Button btnRegister;
    
    @FXML
    private Button btnBack;

    @FXML
    void btnBack_onClick(ActionEvent event) throws IOException {
    	this.rootLayout = Main.rootLayout;
        AnchorPane accountPage = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		rootLayout.setRight(accountPage);
    }

    @FXML
    void btnRegister_onClick(ActionEvent event) throws IOException {
    	this.rootLayout = Main.rootLayout;
        AnchorPane accountPage = (AnchorPane)FXMLLoader.load(getClass().getResource("Account.fxml"));
		rootLayout.setRight(accountPage);
    }

    @FXML
    void initialize() {
        assert txtFName != null : "fx:id=\"txtFName\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtLName != null : "fx:id=\"txtLName\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtCountry != null : "fx:id=\"txtCountry\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtProvince != null : "fx:id=\"txtProvince\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtCity != null : "fx:id=\"txtCity\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtPostal != null : "fx:id=\"txtPostal\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtBPhone != null : "fx:id=\"txtBPhone\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtPPhone != null : "fx:id=\"txtPPhone\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert txtEMail != null : "fx:id=\"txtEMail\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert btnRegister != null : "fx:id=\"btnRegister\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'RegisterView.fxml'.";
        
        Main.rootController.onPage("lblRegister");

    }
}
