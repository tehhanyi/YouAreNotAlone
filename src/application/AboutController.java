package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutController implements Initializable {
	 @FXML
	 private Text animation;
	 @FXML
	 private Text animation1;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

//        double msgWidth = animation.getLayoutBounds().getWidth() + 200;
//	    KeyValue initKeyValue = new KeyValue(animation.translateXProperty(), 960);
//	    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);
//	    KeyValue endKeyValue = new KeyValue(animation.translateXProperty(), -1.0*(msgWidth));
//	    KeyFrame endFrame = new KeyFrame(Duration.seconds(3), endKeyValue);
//	    Timeline timeline = new Timeline(initFrame, endFrame);
//	    timeline.setCycleCount(Timeline.INDEFINITE);
//	    timeline.play();
//	    
//	    KeyValue initKeyValue1 = new KeyValue(animation1.translateXProperty(), 960);
//	    KeyFrame initFrame1 = new KeyFrame(Duration.ZERO, initKeyValue1);
//	    KeyValue endKeyValue1 = new KeyValue(animation1.translateXProperty(), -1.0*(msgWidth));
//	    KeyFrame endFrame1 = new KeyFrame(Duration.seconds(3), endKeyValue1);
//	    Timeline timeline1 = new Timeline(initFrame1, endFrame1);
//	    timeline1.setCycleCount(Timeline.INDEFINITE);
//	    timeline1.play();
		String str = "HOW ARE YOU, REALLY?  HOW ARE YOU, REALLY?  HOW ARE YOU, REALLY?  HOW ARE YOU, REALLY?  HOW ARE YOU, REALLY?";
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.03),
                event -> {
                    if (i.get() > str.length()) {
                        timeline.stop();
                    } else {
                    	animation.setText(str.substring(0, i.get()));
                    	animation1.setText(str.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
	}
	
    @FXML
    void Home(ActionEvent event) throws IOException {
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
    		Scene scene = new Scene(root,960,560);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Home = new Stage();
    		Home.getIcons().add(new Image("/img/WNRS.png"));
    		Home.initModality(Modality.APPLICATION_MODAL);
    		Home.setScene(scene);
    		Home.show();
    		Stage About = (Stage)((Node)event.getSource()).getScene().getWindow();
    		About.close();
    }   

    @FXML
    void GotoIGpost(MouseEvent event) throws MalformedURLException, IOException, URISyntaxException{Desktop.getDesktop().browse(new URL("https://www.instagram.com/p/CRn896nHhhT").toURI());}
	@FXML
    void GotoWNRS(MouseEvent event) throws MalformedURLException, IOException, URISyntaxException {Desktop.getDesktop().browse(new URL("https://www.werenotreallystrangers.com").toURI());}
    @FXML
    void GotoMBTI(MouseEvent event) throws MalformedURLException, IOException, URISyntaxException {Desktop.getDesktop().browse(new URL("https://www.16personalities.com").toURI());}
}

