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

public class modify {
	
	private static final String NULL = null;
	BorderPane pane = new BorderPane();
	ImageView badge = new ImageView(new Image("school.jpg"));
	Label labelname= new Label("修改密码");
	HBox hBgh = new HBox(15);
	TextField tfgh = new TextField();
	HBox hBmodify = new HBox(15);
	PasswordField tfmodify = new PasswordField();
	HBox hBmodifyagain = new HBox(15);
	PasswordField tfmodifyagain = new PasswordField();
	VBox vBlist = new VBox(0);
	
	TextField userid = new TextField();
	TextField userxh = new TextField();
	Button btBack = new Button("back ");
	HBox hBbtok = new HBox(15);
	Button btModify = new Button("Modify");
	
	public  modify() {
		
		badge.setFitHeight(150);
		badge.setFitWidth(300);
		pane.setTop(badge);
		
		Font font=new Font("Monospaced",18);//设置字体格式和大小
	    labelname.setFont(font);
		pane.setCenter(labelname);
		
		hBgh.setPadding(new Insets(0,15,15,30));
		hBgh.getChildren().add(new Label("工    号   :"));
		hBgh.getChildren().add(tfgh);
		
		hBmodify.setPadding(new Insets(0,15,15,25));
		hBmodify.getChildren().add(new Label("新密码   ："));
		hBmodify.getChildren().add(tfmodify);
		
		hBmodifyagain.setPadding(new Insets(0,15,15,25));
		hBmodifyagain.getChildren().add(new Label("再输一次："));
		hBmodifyagain.getChildren().add(tfmodifyagain);
		
		
		hBbtok.getChildren().add(btBack);
		hBbtok.getChildren().add(btModify);
		hBbtok.setAlignment(Pos.CENTER);
		hBbtok.setPadding(new Insets(0,15,35,30));
		
		vBlist.setPadding(new Insets(10,10,10,10));
		vBlist.getChildren().add(hBgh);
		vBlist.getChildren().add(hBmodify);
		vBlist.getChildren().add(hBmodifyagain);
		vBlist.getChildren().add(hBbtok);
		
		pane.setBottom(vBlist);
	}
	public BorderPane getpane() {
		return pane;
	}


	public boolean equal()  {
		if(tfmodify.getText().equals(tfmodifyagain.getText())){
			return true;
		}else {
			return false;
		}
	}

}
