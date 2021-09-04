package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController implements Initializable {
	@FXML
    private Text projname;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String str = "You Are Not Alone";
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.2),
                event -> {
                    if (i.get() > str.length()) {
                        timeline.stop();
                    } else {
                        projname.setText(str.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
	}
	
    @FXML
    void Chat(ActionEvent event) {
    	try {
    		Stage Home = (Stage)((Node)event.getSource()).getScene().getWindow();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Chat.fxml"));
    		Scene scene = new Scene(root,960,560);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Chat1 = new Stage();
    		Chat1.getIcons().add(new Image(logo));
    		Chat1.initModality(Modality.APPLICATION_MODAL);
    		Chat1.setScene(scene);
    		Chat1.show();
    		Home.close();
    	}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }

    @FXML
    void Quiz(ActionEvent event) {
    	try {
    		Stage Home = (Stage)((Node)event.getSource()).getScene().getWindow();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz.fxml"));
    		Scene scene = new Scene(root,960,560);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Chat1 = new Stage();
    		Chat1.getIcons().add(new Image(logo));
    		Chat1.setScene(scene);
    		Chat1.show();
    		Home.close(); 
    	}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    @FXML
    void AboutUs(ActionEvent event) {
    	try {
    		Stage Home = (Stage)((Node)event.getSource()).getScene().getWindow();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("About.fxml"));
    		Scene aboutscene = new Scene(root,1366,768);
    		aboutscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage About = new Stage();
    		About.getIcons().add(new Image(logo));
    		//Chat1.initModality(Modality.APPLICATION_MODAL);
    		About.setScene(aboutscene);
    		About.show();
    		Home.close(); 
    	}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    String logo = "/img/WNRS.png";
	
}
