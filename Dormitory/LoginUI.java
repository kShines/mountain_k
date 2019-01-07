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

public class LoginUI {
	
	private static final String NULL = null;
	BorderPane pane = new BorderPane();
	ImageView badge = new ImageView(new Image("school.jpg"));
	Label labelname= new Label("欢迎来到杭师大寝室管理系统!");
	HBox hBxh = new HBox(15);
	TextField tfxh = new TextField();
	HBox hBkey = new HBox(15);
	//TextField tfkey = new TextField();
	PasswordField tfkey = new PasswordField();
	VBox vBlist = new VBox(0);
	TextField userid = new TextField();
	TextField userxh = new TextField();
	Button btOK = new Button("Login ");
	HBox hBbtok = new HBox(15);
	Button btModify = new Button("Modify");
	int r;
	TextField tfVeCode = new TextField();
	HBox hBVeCode = new HBox(10);
	
	Button Vecode = new Button();
	
	public  LoginUI() {
		badge.setFitHeight(150);
		badge.setFitWidth(300);
		pane.setTop(badge);
		
		Font font=new Font("Monospaced",18);//设置字体格式和大小
	   // labelname.setForeground(Color.BLUE);//设置前景色
	    labelname.setFont(font);
		pane.setCenter(labelname);
		
		setVecode();
		tfVeCode.setPrefWidth(100);
		tfVeCode.setPadding(new Insets(0,0,0,10));
		Vecode.setPadding(new Insets(3,0,0,10));
		hBVeCode.setPadding(new Insets(0,15,15,30));
		hBVeCode.getChildren().add(new Label("验证码："));
		hBVeCode.getChildren().add(tfVeCode);
		hBVeCode.getChildren().add(Vecode);
		
		
		hBxh.setPadding(new Insets(0,15,15,30));
		hBxh.getChildren().add(new Label("工号："));
		hBxh.getChildren().add(tfxh);
		
		
		hBkey.setPadding(new Insets(0,15,15,30));
		hBkey.getChildren().add(new Label("密码："));
		hBkey.getChildren().add(tfkey);
		
		hBbtok.getChildren().add(btOK);
		hBbtok.getChildren().add(btModify);
		hBbtok.setAlignment(Pos.CENTER);
		hBbtok.setPadding(new Insets(0,15,35,30));
		
		vBlist.getChildren().add(hBxh);
		vBlist.getChildren().add(hBkey);
		vBlist.getChildren().add(hBVeCode);
		vBlist.getChildren().add(hBbtok);
//		//设置背景		
//		BackgroundImage myBI= new BackgroundImage(new Image("school.jpg",300,400,false,true),
//		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//		          BackgroundSize.DEFAULT);
//		pane.setBackground(new Background(myBI));
		
		pane.setBottom(vBlist);
	}
	public BorderPane getpane() {
		return pane;
	}
	public void init() throws IOException {
		

			try (DataOutputStream output = new DataOutputStream(new FileOutputStream("admin.txt"));) {
			output.writeUTF("admin");
			output.writeDouble(0.1);
			output.writeUTF("123456");
			output.writeDouble(0.1);
			output.writeUTF("管理员");
			output.writeDouble(0.1);
			}
		
			catch (IOException ex) {
				ex.printStackTrace();
				}
		
		
		
	}
	
	public boolean equal() throws IOException {
		String struser = new String();
		String strpassword = new String();
		String strname = new String();
		try (DataInputStream input = new DataInputStream(new FileInputStream("admin.txt"));) {
			struser = input.readUTF();
			double tmp = input.readDouble();
			strpassword = input.readUTF();
			tmp = input.readDouble();
			strname = input.readUTF();
			tmp = input.readDouble();
			if(tfxh.getText().equals(struser)&&tfkey.getText().equals(strpassword)&&tfVeCode.getText().equals(String.valueOf(r))) {
			userid.setText(strname);
			userxh.setText(struser);
			System.out.println("ok");
			return true;
		}else {
			System.out.println("no");
		}
		}
		
	
	catch (EOFException ex) {
		System.out.println("All data were read.");
	}


		return false;
	}
	public void setVecode() {
		r=0;
		int t=4;
		while(t>0)
		{
			t--;
			r=(int) (r*10+(Math.random())*10);
		}
		r=r%10000;
		if(r<1000)r+=1000;
		System.out.println(r);
		Vecode.setText(String.valueOf(r));
	}
}
