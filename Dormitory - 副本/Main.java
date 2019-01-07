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
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.scene.input.*;
public  class Main extends Application {
	@Override
	public void start (Stage primaryStage) {
		BorderPane pane = new BorderPane();
		ImageView badge = new ImageView(new Image("school.jpg"));
		
		badge.setFitHeight(150);
		badge.setFitWidth(300);
		pane.setTop(badge);
		
		
		Label labelname= new Label("��ӭ������ʦ�����ҹ���ϵͳ!");
		Font font=new Font("Monospaced",18);//���������ʽ�ʹ�С
        labelname.setFont(font);
		pane.setCenter(labelname);

		
		HBox hBxh = new HBox(15);
		hBxh.setPadding(new Insets(0,15,15,30));
		hBxh.getChildren().add(new Label("ѧ�ţ�"));
		TextField tfxh = new TextField();
		hBxh.getChildren().add(tfxh);
		
		HBox hBkey = new HBox(15);
		hBkey.setPadding(new Insets(0,15,15,30));
		hBkey.getChildren().add(new Label("���룺"));
		TextField tfkey = new TextField();
		hBkey.getChildren().add(tfkey);
		
		Button btOK = new Button("login");
		HBox hBbtok = new HBox(15);
		hBbtok.getChildren().add(btOK);
		hBbtok.setAlignment(Pos.CENTER);
		hBbtok.setPadding(new Insets(0,15,35,30));
		
		VBox vBlist = new VBox(0);
		vBlist.getChildren().add(hBxh);
		vBlist.getChildren().add(hBkey);
		vBlist.getChildren().add(hBbtok);
//		���ñ���		
//		BackgroundImage myBI= new BackgroundImage(new Image("school.jpg",300,400,false,true),
//		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//		          BackgroundSize.DEFAULT);
//		pane.setBackground(new Background(myBI));
		
		primaryStage.getIcons().add(new Image("xiaohui.jpg"));
		
		pane.setBottom(vBlist);
		
		Scene scene = new Scene(pane,300,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("��½��");
		
		primaryStage.show();
	}



}

