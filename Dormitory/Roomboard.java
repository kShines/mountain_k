import javafx.application.Application;
import java.util.Scanner;
import javafx.scene.control.*;
import javafx.application.Application;
import java.util.Scanner;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
public class Roomboard {
	BorderPane pane = new BorderPane();
	String Roomid;
	Label tag = new Label();
	
	VBox BedList = new VBox(20);
	Button Bed[] = new Button[4];
	
	//Rectangle rr = new Rectangle(25,20,20,20);
	//rr.setArcWidth(15);
//	VBox exlist = new VBox(15);
//	Label ex1Label = new Label();
//	Label ex2Label = new Label();
//	Label ex3Label = new Label();
	
	VBox exitButton = new VBox();
	Button exit = new Button("后退");
	
	public Roomboard(){
		tag.setTextFill(Color.BLUE);
		tag.setText(Roomid);
		pane.setTop(tag);
		
		exit= new Button("返回");
		exit.setPadding(new Insets(10,10,10,10));
		exitButton.getChildren().add(exit);
		exitButton.setPadding(new Insets(0,10,30,130));
		pane.setBottom(exitButton);
//		ex1Label.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
//		ex1Label.setText("如果显示为空");
//		ex2Label.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
//		ex2Label.setText("点击床位入住");
		//ex3Label.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
//		ex3Label.setText("help");
//		exlist.setPadding(new Insets(15,50,15,15));
//		exlist.getChildren().add(ex3Label);
//		exlist.getChildren().add(ex1Label);
//		exlist.getChildren().add(ex2Label);
//		pane.setRight(exlist);
		
		
		for(int i=0;i<4;i++)
		{
			Bed[i]= new Button("空");
			setLayout(null);
			//Bed[i].setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
			Bed[i].setPadding(new Insets(30,20,10,20));
			BedList.getChildren().add(Bed[i]);
			Bed[i].setPrefSize(200, 100);
		}
		BedList.setPadding(new Insets(20,20,20,40));
		BedList.setAlignment(Pos.CENTER);
		pane.setCenter(BedList);
		
		
	}
	
	private void setLayout(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void updateButton() {
		try {
			try (DataInputStream input = new DataInputStream(new FileInputStream("roominfo.txt"));) {
				while(true) {
					String string1 = input.readUTF();
					double tmp = input.readDouble();
					String bed0 = input.readUTF();
					tmp = input.readDouble();
					String bed1 = input.readUTF();
					tmp = input.readDouble();
					String bed2 = input.readUTF();
					tmp = input.readDouble();
					String bed3 = input.readUTF();
					tmp = input.readDouble();
					System.out.println(string1);
					System.out.println(Roomid);
					System.out.println(bed0);
					System.out.println(bed1);
					System.out.println(bed2);
					System.out.println(bed3);
					
					if(string1.equals(Roomid)) {

	    				if(bed0.equals("0")) {

	    					Bed[0].setText("可点击入住");
	    					Bed[0].setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
	    				}else {
	    					Bed[0].setText(bed0);
	    					Bed[0].setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
	    				}
	    				if(bed1.equals("0")) {
	    					Bed[1].setText("可点击入住");
	    					Bed[1].setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
	    				}else {
	    					Bed[1].setText(bed1);
	    					Bed[1].setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
	    				}
	    				if(bed2.equals("0")) {
	    					Bed[2].setText("可点击入住");
	    					Bed[2].setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
	    				}else {
	    					Bed[2].setText(bed2);
	    					Bed[2].setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
	    				}
	    				if(bed3.equals("0")) {
	    					Bed[3].setText("可点击入住");
	    					Bed[3].setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
	    				}else {
	    					Bed[3].setText(bed3);
	    					Bed[3].setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
	    				}
						
						break;
					}
				}
			}
		}
		catch (EOFException ex) {
			System.out.println("bed is wrong");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	

	public BorderPane getpane() {
		return pane;
	}
}
