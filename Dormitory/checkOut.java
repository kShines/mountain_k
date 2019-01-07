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
public class checkOut {
	BorderPane pane = new BorderPane();
	String Roomid;
	int Bedid;
	String studentId ;
	Button btCheckOut = new Button("Check Out");
	Button btBack = new Button("Back");
	Label laStudentId = new Label("学号：");
	TextField tfStudentId = new TextField();
	Label laName = new Label("姓名：");
	TextField tfName = new TextField();
	Label laSchool = new Label("学院： ");
	TextField tfSchool = new TextField();
	Label laMajor = new Label("专业：");
	TextField tfMajor = new TextField();
	Label laClass = new Label("班级：");
	TextField tfClass = new TextField();
	Label laRoom = new Label("寝室：");
	TextField tfRoom = new TextField();
	
	HBox lalist1 = new HBox(15);
	HBox lalist2 = new HBox(15);
	HBox lalist3 = new HBox(15);
	HBox lalist4 = new HBox(15);
	HBox lalist5 = new HBox(15);
	HBox lalist6 = new HBox(15);
	HBox btlist = new HBox(15);
	
	String info[] = new String[300];
	
	VBox all = new VBox(15);
	public checkOut() {
		studentId = tfStudentId.getText();
		for(int i=0;i<300;i++)
		{
			info[i]= new String();
		}
		lalist1.getChildren().add(laStudentId);
		lalist1.getChildren().add(tfStudentId);
		lalist1.setAlignment(Pos.CENTER);
		lalist2.getChildren().add(laName);
		lalist2.getChildren().add(tfName);
		lalist2.setAlignment(Pos.CENTER);
		lalist3.getChildren().add(laSchool);
		lalist3.getChildren().add(tfSchool);
		lalist3.setAlignment(Pos.CENTER);
		lalist4.getChildren().add(laMajor);
		lalist4.getChildren().add(tfMajor);
		lalist4.setAlignment(Pos.CENTER);
		lalist5.getChildren().add(laClass);
		lalist5.getChildren().add(tfClass);
		lalist5.setAlignment(Pos.CENTER);
		lalist6.getChildren().add(laRoom);
		lalist6.getChildren().add(tfRoom);
		lalist6.setAlignment(Pos.CENTER);
		btlist.getChildren().add(btCheckOut);
		btlist.getChildren().add(btBack);
		btlist.setAlignment(Pos.CENTER);
		all.getChildren().add(lalist1);
		all.getChildren().add(lalist2);
		all.getChildren().add(lalist3);
		all.getChildren().add(lalist4);
		all.getChildren().add(lalist5);
		all.getChildren().add(lalist6);
		all.getChildren().add(btlist);
		all.setPadding(new Insets(80,0,0,0));
		pane.setCenter(all);
	}
	
	public BorderPane getpane() {
		return pane;
	}
	public void init() {
		try {
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
					if(info[x].equals(studentId)) {
						//System.out.println("init is ok");
						tfStudentId.setText(info[x+0]);
						tfName.setText(info[x+1]);
						tfSchool.setText(info[x+2]);
						tfMajor.setText(info[x+3]);
						tfClass.setText(info[x+4]);
						tfRoom.setText(info[x+5]);
						break;
					}
					
				}
			}
			
		}
		catch (EOFException ex) {
			System.out.println("studentinfo all read");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}
	public void studentOut() {//修改寝室信息  修改学生信息
		try {
			//System.out.println("studentxh:"+studentId);
			try (DataInputStream input = new DataInputStream(new FileInputStream("roominfo.txt"));) {
				int f = 0,x;
				while(true) {//寝室信息有5个
					x=f;
					info[f++] = input.readUTF();
					double tmp = input.readDouble();
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					if(info[f-1].equals(studentId)) {
						info[f-1]="0";
					}
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					if(info[f-1].equals(studentId)) {
						info[f-1]="0";
					}
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					if(info[f-1].equals(studentId)) {
						info[f-1]="0";
					}
					info[f++] = input.readUTF();
					tmp = input.readDouble();
					if(info[f-1].equals(studentId)) {
						info[f-1]="0";
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
			System.out.println("ysk:  "+studentId);
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

				if(info[x].equals(studentId)) {
					info[x+5]="0";
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