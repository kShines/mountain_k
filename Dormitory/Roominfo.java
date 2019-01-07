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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;

public class Roominfo {
	BorderPane pane = new BorderPane();
	HBox hbinfo = new HBox(15);
	VBox vbname = new VBox(15);
	VBox vbinfo = new VBox(15);
	VBox vbButton = new VBox(15);
	VBox vbLogout = new VBox(15);
	Label nameLabel = new Label("姓名：");
	Label studentIdLabel = new Label("工号：");
	Font font=new Font("Monospaced",15);//设置字体格式和大小
	TextField txname = new TextField("待填");
	TextField txstudentId = new TextField("待填");
	Button btLogout = new Button("logout");
	
	Label explain = new Label("说明：");
	Text text = new Text("点击可查看寝室");
	Button btYellow = new Button("未满");
	Button btRed = new Button("已满");
	VBox vbyrlist = new VBox(15);
	HBox hblist[]= new HBox[6];
	VBox vblist = new VBox();
	dormitoryButton dor[][] = new dormitoryButton[3][10];
	public Roominfo() throws IOException {
		vbyrlist.setPadding(new Insets(10,50,10,10));
		vblist.setPadding(new Insets(10,10,10,10));
		text.setStyle("-fx-background-color:blue;-fx-border-color:blue; -fx-border-width:3");
		btRed.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
		btYellow.setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
		
		vbyrlist.getChildren().add(explain);
		vbyrlist.getChildren().add(text);
		vbyrlist.getChildren().add(btRed);
		vbyrlist.getChildren().add(btYellow);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<10;j++)
			{
				dor[i][j] = new dormitoryButton();
				dor[i][j].setDorm(new Button(String.valueOf((100*(i+1)+j+1))));
			}
		}
		
		for(int i=0;i<6;i++) {
			hblist[i]= new HBox(20);
			hblist[i].setPadding(new Insets(10,10,10,10));
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<5;j++)
			{
				hblist[i*2].getChildren().add(dor[i][j].dorm);
			}
			for(int j=5;j<10;j++)
			{
				hblist[i*2+1].getChildren().add(dor[i][j].dorm);
			}
		}
		for(int i=0;i<6;i++)
		{
			vblist.getChildren().add(hblist[i]);
		}
		
		
		vbname.setPadding(new Insets(10,10,10,50));
		nameLabel.setFont(font);
		studentIdLabel.setFont(font);
		vbname.getChildren().add(nameLabel);
		vbname.getChildren().add(studentIdLabel);
		
		vbinfo.setPadding(new Insets(10,10,10,10));
		vbinfo.getChildren().add(txname);
		vbinfo.getChildren().add(txstudentId);
		
		
		vbLogout.setPadding(new Insets(10,10,10,10));
		vbLogout.getChildren().add(btLogout);
		
		hbinfo.getChildren().add(vbname);
		hbinfo.getChildren().add(vbinfo);
		hbinfo.getChildren().add(vbLogout);
		
		pane.setLeft(vblist);
		pane.setBottom(hbinfo);
		pane.setRight(vbyrlist);
		
	}
	public void updateColor() throws IOException {
		String roomid = new String();
		String roomStateOne = new String();
		String roomStateTwo = new String();
		String roomStateThree = new String();
		String roomStateFour = new String();
		try {
			try (DataInputStream input21 = new DataInputStream(new FileInputStream("roominfo.txt"));) 
				{
				while(true) {
					roomid = input21.readUTF();
					double tmp= input21.readDouble();
					roomStateOne = input21.readUTF();
					tmp= input21.readDouble();
					roomStateTwo = input21.readUTF();
					tmp= input21.readDouble();
					roomStateThree = input21.readUTF();
					tmp= input21.readDouble();
					roomStateFour = input21.readUTF();
					tmp= input21.readDouble();
					int rone =Integer.parseInt(roomStateOne);
					int rtwo =Integer.parseInt(roomStateTwo);
					int rthree =Integer.parseInt(roomStateThree);
					int rfour =Integer.parseInt(roomStateFour);
					int id=Integer.parseInt(roomid);
					final int x=id/100-1;
					final int y=id%100-1;
					dor[x][y].num=0;
					if(rone==0)dor[x][y].num++;
					if(rtwo==0)dor[x][y].num++;
					if(rthree==0)dor[x][y].num++;
					if(rfour==0)dor[x][y].num++;
					if(dor[x][y].num!=0) {
						dor[x][y].dorm.setText(String.valueOf(x*100+100+y+1)+" :"+(4-dor[x][y].num)+"/4");
						dor[x][y].dorm.setStyle("-fx-background-color:yellow;-fx-border-color:yellow; -fx-border-width:3");
					}else {
						dor[x][y].dorm.setText(String.valueOf(x*100+100+y+1)+" :"+(4-dor[x][y].num)+"/4");
						dor[x][y].dorm.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
					}
					
				}
			}
			}
			catch (EOFException ex) {
			System.out.println("ID or password is wrong.");
			}
			catch (IOException ex) {
			ex.printStackTrace();
			}

	}
	public BorderPane getpane() {
		return pane;
	}
	public void init() throws IOException {
		

		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("roominfo.txt"));) {
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<10;j++)
				{
					output.writeUTF(String.valueOf(i*100+100+j+1));
					output.writeDouble(0.1);
					output.writeUTF(String.valueOf(0));
					output.writeDouble(0.1);
					output.writeUTF(String.valueOf(0));
					output.writeDouble(0.1);
					output.writeUTF(String.valueOf(0));
					output.writeDouble(0.1);
					output.writeUTF(String.valueOf(0));
					output.writeDouble(0.1);
				}
			}
		}
	
		catch (IOException ex) {
			ex.printStackTrace();
			}
	
	
	
}
	
}
class dormitoryButton {
	Button dorm;
	int num=0;
	public void setDorm(Button dorm) {
		this.dorm = dorm;
	}
//	public void setButtonColor() {
//		
//	}
	@Override
	public String toString() {
		return "dormitoryButton [dorm=" + dorm + ", num=" + num + "]";
	}
	
	
}

