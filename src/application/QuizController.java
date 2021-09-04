package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuizController {
    
    @FXML
    void onBackbutton(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage Home = new Stage();
			Home.getIcons().add(new Image(logo));
			Home.setScene(scene);
			Home.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void StartQuiz(ActionEvent event) {
    	try {
    		FileWriter fw = new FileWriter("MBTI.txt",  false);
    		fw.close();
    		Stage Home = (Stage)((Node)event.getSource()).getScene().getWindow();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz1.fxml"));
    		Scene quiz = new Scene(root,960,560);
    		quiz.getStylesheets().add(getClass().getResource("quiz.css").toExternalForm());
    		Stage Quiz1 = new Stage();
			Quiz1.getIcons().add(new Image(logo));
    		Quiz1.initModality(Modality.APPLICATION_MODAL);
    		Quiz1.setScene(quiz);
    		Quiz1.show();
    		Home.close();
    	}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    @FXML
    void goToType(ActionEvent event) {
    	try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Types.fxml"));
			Scene scene = new Scene(root,1366,768);
			Stage Type = new Stage();
			Type.getIcons().add(new Image(logo));
			Type.setScene(scene);
			Type.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    String logo = "/img/WNRS.png";

}
