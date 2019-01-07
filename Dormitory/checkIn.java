//import javafx.application.Application;
import java.util.Scanner;
import javafx.scene.control.*;
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
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.scene.input.*;
public class checkIn {
	BorderPane pane = new BorderPane();
	String Roomid;
	int Bedid;
	int flag=0;
	Button btCheckIn = new Button("Check in");
	Button btBack = new Button("Back");
	Label laStudentId = new Label("请输入学号");
	TextField tfStudentId = new TextField();
	String info[] = new String[300];
	HBox lalist = new HBox(15);
	HBox btlist = new HBox(15);
	
	VBox all = new VBox(15);
	public checkIn() {
		for(int i=0;i<300;i++)
		{
			info[i]= new String();
		}
		lalist.getChildren().add(laStudentId);
		lalist.getChildren().add(tfStudentId);
		lalist.setAlignment(Pos.CENTER);
		btlist.getChildren().add(btCheckIn);
		btlist.getChildren().add(btBack);
		btlist.setAlignment(Pos.CENTER);
		all.getChildren().add(lalist);
		all.getChildren().add(btlist);
		all.setPadding(new Insets(80,0,0,0));
		//all.setPadding(new Insets(80,0,0,100));
		pane.setCenter(all);
	}
	
	public BorderPane getpane() {
		return pane;
	}
	public void studentIn() {//修改寝室信息  修改学生信息
		try {
			try (DataInputStream input = new DataInputStream(new FileInputStream("roominfo.txt"));) {
				int f = 0,x;
//				System.out.println("roomid :"+Roomid);
//				System.out.println("bedid :"+Bedid);
//				System.out.println("studentid :"+tfStudentId.getText());
				while(true) {//寝室信息有5个
					x=f;
					info[f++] = input.readUTF();
					double tmp = input.readDouble();
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					info[f++] = input.readUTF();
					tmp = input.readDouble();

					if(info[x].equals(Roomid)) {
						flag=1;
						info[x+Bedid]=tfStudentId.getText();
					}
				}
			}
			
		}
		catch (EOFException ex) {
			System.out.println("roominfo all read");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		try {
			try (DataOutputStream output = new DataOutputStream(new FileOutputStream("roominfo.txt"));) {
				int f = 0,x;
				while(true) {//寝室信息有5个
					output.writeUTF(info[f++]);
					output.writeDouble(0.1);
					output.writeUTF(info[f++]);
					output.writeDouble(0.1);
					output.writeUTF(info[f++]);
					output.writeDouble(0.1);
					output.writeUTF(info[f++]);
					output.writeDouble(0.1);
					output.writeUTF(info[f++]);
					output.writeDouble(0.1);
					if(f==150)break;
				}
			}
			
		}
		catch (EOFException ex) {
			System.out.println("roominfo all read");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	
	
	
	try {//修改学生信息
		try (DataInputStream input = new DataInputStream(new FileInputStream("studentinfo.txt"));) {
			int f = 0,x;
			while(true) {//学生信息有6个
				x=f;
				info[f++] = input.readUTF();
				double tmp = input.readDouble();
				info[f++] = input.readUTF();
				tmp = input.readDouble();
				info[f++] = input.readUTF();
				tmp = input.readDouble();
				info[f++] = input.readUTF();
				tmp = input.readDouble();
				info[f++] = input.readUTF();
				tmp = input.readDouble();
				info[f++] = input.readUTF();
				tmp = input.readDouble();

				if(info[x].equals(tfStudentId.getText())) {
					info[f-1]=Roomid;
				}
			}
		}
		
	}
	catch (EOFException ex1111) {
		System.out.println("roominfo all read");
	}
	catch (IOException ex111) {
		ex111.printStackTrace();
	}
	
	
	try {
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("studentinfo.txt"));) {
			int f = 0,x;
			while(true) {//学生信息有6个
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				output.writeUTF(info[f++]);
				output.writeDouble(0.1);
				if(f==180)break;
			}
		}
		
	}
	catch (EOFException ex11) {
		System.out.println("roominfo all read");
	}
	catch (IOException ex) {
		ex.printStackTrace();
	}
}



	

}