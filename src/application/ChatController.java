package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChatController implements Initializable{
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> options = FXCollections.observableArrayList("INTJ","INTP","ENTJ","ENTP","INFJ","INFP","ENJF","ENFP","ISTJ","ISFJ","ESTJ","ESFJ","ISTP","ISFP","ESTP","ESFP","Do not wish to state");
		comboBox.setItems(options);
	}
	@FXML
    private TextField name;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    void ToChat(ActionEvent event) {
    	if (name.getText()!="" && !comboBox.getSelectionModel().isEmpty())
    	{
    	try {
    	    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Chatbox.fxml"));
    		BorderPane first =loader1.load();
    		Chat1Controller controller1 = loader1.getController();
	        controller1.fetchUser(name.getText(),comboBox.getValue());
	        Scene chatscene1 = new Scene(first,600,720);
    		chatscene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Chatbox = new Stage();
    		Chatbox.getIcons().add(new Image(logo));
    		Chatbox.setTitle(name.getText() + "'s Chat Box");
//    		Chatbox.setX(850);
//    		Chatbox.setY(50);
    		Chatbox.setScene(chatscene1);
    		Chatbox.show();
    		
//    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Chat2.fxml"));
//     		BorderPane second =loader2.load();
//     		Chat2Controller controller2 = loader2.getController();
//	        controller2.fetchUser(name.getText(),comboBox.getValue());
//    		Scene chatscene2 = new Scene(second,600,720);
//    		chatscene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//    		Stage Chat2 = new Stage();
//    		Chat2.getIcons().add(new Image(logo));
//    		Chat2.setTitle("Tommy's Chat Box");
//    		Chat2.setX(80);
//    		Chat2.setY(50);
//    		Chat2.setScene(chatscene2);
//    		Chat2.show();
    		
    		//Stage Chat1 = (Stage)((Node)event.getSource()).getScene().getWindow();
			//Chat1.close();
        	}
        	catch(IOException e){
        		System.out.println(e.getMessage());
        	}
    	}
    	else
    		if (name.getText()=="")
    			JOptionPane.showMessageDialog(null, "Please key in your name!");
    		else if (comboBox.getSelectionModel().isEmpty())
    			JOptionPane.showMessageDialog(null, "Please select your personality!");
    }

    @FXML
    void ToQuiz(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz.fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage Quiz = new Stage();
			Quiz.setScene(scene);
			Quiz.initModality(Modality.WINDOW_MODAL);
			Quiz.getIcons().add(new Image(logo));
			Quiz.show();
			Stage Chat1 = (Stage)((Node)event.getSource()).getScene().getWindow();
			Chat1.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onBackbutton(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage Home = new Stage();
			Home.setScene(scene);
			Home.initModality(Modality.WINDOW_MODAL);
    		Home.getIcons().add(new Image(logo));
			Home.show();
			Stage Chat1 = (Stage)((Node)event.getSource()).getScene().getWindow();
			Chat1.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    String logo = "/img/WNRS.png";
}