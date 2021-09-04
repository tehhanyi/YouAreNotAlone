package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Chat1Controller implements Initializable {
	int index = 0;
	int i =0;
	Scanner sc = new Scanner(System.in);
	
	private List<Label> messages = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chatbox1.getStyleClass().add("chatbox");
    	Text text = new Text("How are you, really?");
    	text.setWrappingWidth(500);
        text.setFill(Color.RED);
        text.setFont(Font.font("Helvetica", FontPosture.ITALIC, 20));
        chatbox1.getChildren().add(text);
	}
	@FXML
    private Text username;
	@FXML
    private TextArea message;
	@FXML
    private VBox chatbox1;
	@FXML
    private ScrollPane scroll;
    @FXML
    void Question(ActionEvent event) {
    	if (index<10)
    		try
    	 	{
//    			messages.add(new Label("\nSystem: "+questions[index] +"\n"));
//    			messages.get(index).setAlignment(Pos.CENTER_LEFT);
    			Label text = new Label ("System: "+questions[index]);
                text.setTextFill(Color.RED);
            	text.setMaxWidth(550);
                text.setFont(Font.font("Helvetica", FontPosture.ITALIC, 16));
                chatbox1.getChildren().add(text);
            	index++;
            }
    	 	catch (ArrayIndexOutOfBoundsException  e) {
    			JOptionPane.showMessageDialog(null, "Want more questions? Subscribe to our premium chat!");
    	 	}
    }
    @FXML
    void onEnter(KeyEvent event) throws IOException {if (event.getCode().equals(KeyCode.ENTER))Send(null);}
    @FXML
    void Send(ActionEvent event) throws IOException {
    	if (message.getText()!="")
    	{
    		String msg = message.getText();
    		Label text = new Label ("You:\n   "+msg);
            text.setTextFill(Color.BLACK);
            text.setFont(Font.font("Verdana", 18));
//            text.setStyle("-fx-background-color: #ffcccb; -fx-min-width:"+scroll.getWidth()+";");
    		messages.add(text);
//    		messages.get(index).setAlignment(Pos.CENTER_LEFT);
    		chatbox1.getChildren().add(messages.get(i));
			i++;
        	scroll.setVvalue(1.0);	
			message.setText("");
    	}
    }
    
    @FXML
    void onBackbutton(ActionEvent event) {CloseChat(event);}
    
    public void fetchUser(String text, String mbti) {username.setText(text +" , " +mbti);}
    
	private void CloseChat(ActionEvent event) {
		int yes = JOptionPane.showInternalConfirmDialog(null,
    			"Are you sure to\ngo back?", "Go Back?",
    			JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    	if (yes == JOptionPane.YES_OPTION)
    	{
    		Stage Chat = (Stage)((Node)event.getSource()).getScene().getWindow();
    		Chat.close();
    	}
	}
	@FXML
    void receiveText(MouseEvent event) {
		System.out.print("Tommy:");
		Label text1 = new Label("Tommy:\n   " +sc.nextLine());
		text1.setTextFill(Color.DIMGRAY);
        text1.setFont(Font.font("Verdana", 18));
//        text1.setStyle("-fx-background-color: #ADD8E6; -fx-min-width:300px;");
        messages.add(text1);
//		messages.get(index).setAlignment(Pos.CENTER_RIGHT);
		chatbox1.getChildren().add(messages.get(i));
		i++;
    	scroll.setVvalue(1.0);	
	}
	
	String[] questions= {
			"What Do You Think Their Name is?",
			"What Is The Worst Assumption Someone Has Made About You?",
			"What Do You Think They Do For A Living?",
			"What Is Your Defining Characteristic?",
			"What's the Most Unexplainable Thing That's Ever Happened To You?",
			"What's the Most Pain You've Ever Been in That Wasn't Physical?",
			"Based on what you have learned about them, do you have any Netflix Recommendations?",
			"What About Them Most Surprised You?",
			"In a Word, How Would You Describe Our Conversation?"
	};
}

