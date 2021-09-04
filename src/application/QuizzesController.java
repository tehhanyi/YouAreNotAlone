package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuizzesController{
	String typeMBTI;
	
	@FXML
    private URL location;
    @FXML
    private Button oneNext;
    @FXML
    private ToggleButton A;
    @FXML
    private ToggleButton B;
    @FXML
    private ToggleButton C;
    
    @FXML
    void onSelectA(ActionEvent event) {
    	oneNext.setVisible(true);
    	B.setSelected(false);
    }

	@FXML
    void onSelectB(ActionEvent event) {
    	oneNext.setVisible(true);
    	A.setSelected(false);
	}
	
	@FXML
    void onSelectC(ActionEvent event) {
    	oneNext.setVisible(true);
	}
	
	@FXML
    void next(ActionEvent event){
    	try {
    		String filename = location.toString();
    		filename = filename.substring(filename.indexOf('Q')+4);
    		filename = filename.substring(0, filename.indexOf('.'));
    		int ID = Integer.parseInt(filename); 
    		if(A.isSelected()) store("A",ID);
    		if(B.isSelected()) store("B",ID);
    		//if(C.isSelected()) store("C",ID);
    		
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz"+(ID+1)+".fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("quiz.css").toExternalForm());
			Stage Quiz = new Stage();
			Quiz.setScene(scene);
    		Quiz.getIcons().add(new Image(logo));
			Quiz.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	@FXML
    void back(ActionEvent event) {
    	try {
    		//removeLine();
    		String filename = location.toString();
    		filename = filename.substring(filename.indexOf('Q')+4);
    		filename = filename.substring(0, filename.indexOf('.'));
    		int ID = Integer.parseInt(filename); 
    		
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz"+(ID-1)+".fxml"));
			Scene scene = new Scene(root,960,560);
			scene.getStylesheets().add(getClass().getResource("quiz.css").toExternalForm());
			Stage Quiz = new Stage();
			Quiz.setScene(scene);
    		Quiz.getIcons().add(new Image(logo));
			Quiz.show();
			Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		quiz.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	@FXML
    void backQuiz(ActionEvent event) {
    	try {
    		Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Quiz.fxml"));
    		Scene scene = new Scene(root,960,560);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage Quiz = new Stage();
    		Quiz.getIcons().add(new Image(logo));
    		Quiz.initModality(Modality.APPLICATION_MODAL);
    		Quiz.setScene(scene);
    		Quiz.show();
    		quiz.close();
    	}
    	catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
	@FXML
    void doneQuiz(ActionEvent event) throws IOException {
		List<String> ans = new ArrayList<>(); //use list in case need to add on more questions
		
		File file = new File("MBTI.txt");
		Scanner sc = new Scanner(file);
		if(A.isSelected())
			store("A",26);
		if(B.isSelected())
			store("B",26);
		while(sc.hasNextLine())
			ans.add(sc.nextLine());
		sc.close();
		for (int i=0;i<ans.size();i++)
			System.out.println(ans.get(i));
		
		int E = 0, I = 0, S = 0, N = 0, T = 0, F = 0, J = 0, P = 0;
		for (int i=0;i<ans.size();i++)
		{
			if(ans.get(i).equals("A1"))J+=2;
	    	if(ans.get(i).equals("B1"))P+=2;
	    	if(ans.get(i).equals("A2"))S+=2;
	    	if(ans.get(i).equals("B2"))N+=2;
	    	if(ans.get(i).equals("A3"))E+=2;
	    	if(ans.get(i).equals("B3"))I+=2;
	    	if(ans.get(i).equals("A4"))F++;
	    	if(ans.get(i).equals("B4"))T+=2;
	    	if(ans.get(i).equals("A5"))N++;
	    	if(ans.get(i).equals("B5"))S++;
	    	if(ans.get(i).equals("A6"))E+=2;
	    	if(ans.get(i).equals("B6"))I++;
	    	if(ans.get(i).equals("A7"))J++;
	    	if(ans.get(i).equals("B7"))P++;
	    	if(ans.get(i).equals("C7"))P++;
	    	if(ans.get(i).equals("A8"))J++;
	    	if(ans.get(i).equals("B8"))P+=2;
	    	if(ans.get(i).equals("A9"))E+=2;
	    	if(ans.get(i).equals("B9"))I++;
	    	if(ans.get(i).equals("A10"))S++;
	    	if(ans.get(i).equals("B10"))N+=2;
	    	if(ans.get(i).equals("A11"))J+=2;
	    	if(ans.get(i).equals("B11"))P++;
	    	if(ans.get(i).equals("A12"))S++;
	    	if(ans.get(i).equals("B12"))N+=2;
	    	if(ans.get(i).equals("A13"))E++;
	    	if(ans.get(i).equals("B13"))I+=2;
	    	if(ans.get(i).equals("A14"))F++;
	    	if(ans.get(i).equals("B14"))T+=2;
	    	//if(ans[i]=="A15")do nothing
	    	if(ans.get(i).equals("B15"))S++;
	    	if(ans.get(i).equals("A16"))E+=2;
	    	if(ans.get(i).equals("B16"))I+=2;
	    	if(ans.get(i).equals("A17"))J+=2;
	    	if(ans.get(i).equals("B17"))P+=2;
	    	if(ans.get(i).equals("A18"))J++;
	    	if(ans.get(i).equals("B18"))P++;
	    	if(ans.get(i).equals("A19"))J++;
	    	if(ans.get(i).equals("B19"))P++;
	    	if(ans.get(i).equals("A20"))S+=2;
	    	if(ans.get(i).equals("B20"))N+=2;
	    	if(ans.get(i).equals("A21"))E+=2;
	    	if(ans.get(i).equals("B21"))I+=2;
	    	if(ans.get(i).equals("A22"))F+=2;
	    	if(ans.get(i).equals("B22"))T+=2;
	    	if(ans.get(i).equals("A23"))S+=2;
	    	if(ans.get(i).equals("B23"))N++;
	    	if(ans.get(i).equals("A24"))E++;
	    	if(ans.get(i).equals("B24"))I++;
	    	if(ans.get(i).equals("A25"))J++;
	    	if(ans.get(i).equals("B25"))P++;
	    	//if(ans[i]=="C25") do nothing
	    	if(ans.get(i).equals("A26"))E++;
	    	//if(ans[i]=="B26")do nothing
		}
    	String scores = "E:"+E+" I:"+I+" S:"+S+" N:"+N+" F:"+F+" T:"+T+" J:"+J+" P:"+P;
    	typeMBTI = findMBTI(E,I,S,N,F,T,J,P);
		System.out.println(scores+"\nMBTI: "+typeMBTI);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Result.fxml"));
        BorderPane root =loader.load();
        TypeController controller = loader.getController();
        controller.fetchMBTI(typeMBTI);
        Scene result = new Scene(root,1366,768);
        result.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        Stage Result = new Stage();
        Result.setScene(result);
		Result.getIcons().add(new Image(logo ));
        Result.show();
        Stage quiz = (Stage)((Node)event.getSource()).getScene().getWindow();
        quiz.close();
    }
	
	private void store(String ans, int id)throws IOException {
    	FileWriter fw = new FileWriter("MBTI.txt",  true);
        PrintWriter storeans = new PrintWriter(fw);
    	if (ans == "A")
    		storeans.println("A" +id);
    	else if (ans == "B")
    		storeans.println("B" +id);
    	storeans.close();
    }
	
//	private void removeLine() { //remove last line in MBTI.txt
//		
//	}
//    
    String findMBTI(int e, int i, int s, int n, int f, int t, int j, int p) {
    	String[] MBTI = new String[4];
    	String finalMBTI = "";
    	if (i>=e)
    		MBTI[0] = "I";
    	else
    		MBTI[0]= "E";
    	if (n>=s)
    		MBTI[1] = "N";
    	else
    		MBTI[1]= "S";
    	if (f>=t)
    		MBTI[2] = "F";
    	else
    		MBTI[2]= "T";
    	if (p>=j)
    		MBTI[3] = "P";
    	else
    		MBTI[3]= "J";
    	
    	for(int m=0;m<MBTI.length;m++)
    		finalMBTI +=  MBTI[m];
		return finalMBTI;
	}
    String logo = "/img/WNRS.png";

}