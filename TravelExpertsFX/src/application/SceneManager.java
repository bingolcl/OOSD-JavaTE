package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Agent;
import view.AgentMenuController;
import view.RegisterViewController;
import view.RootLayoutController;

/** Manages control flow for logins */
public class SceneManager {
	
	private Agent currentAgent;
	private String sessionID = "Agent";

  public SceneManager() {
  }

  /**
   * Callback method invoked to notify that a user has been authenticated.
   * Will show the main application screen.
 * @throws SQLException 
 * @throws ClassNotFoundException 
   */ 
  public void authenticated(Agent agent) throws ClassNotFoundException, SQLException {
	  this.currentAgent = agent;
	  initRootLayout();
  }
  
  public void initRootLayout() {
	  BorderPane rootPane = new BorderPane();
	  FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/view/AgentMenu.fxml"));
	  FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));	  
	  
      try {   	  
    	  Main.pstage.close();
          // Load root layout from fxml file.
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
          rootPane = (BorderPane) loader.load();          
          Main.rootController = (RootLayoutController) loader.getController();
          Main.rootLayout = rootPane;
          rootPane.setLeft(menuLoader.load());
          rootPane.setCenter(mainLoader.load());
          // Show the scene containing the root layout.
          Stage stage2 = new Stage();
          stage2.setMaximized(true);
          Scene scene2 = new Scene(rootPane);
          scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
          stage2.setScene(scene2); 
          stage2.initStyle(StageStyle.UNDECORATED);
          Main.scene = scene2;
          stage2.show();
          
          
          
      } catch (IOException ex) {          
          Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
      }     
      
  }
  
}
