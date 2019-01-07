
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
public class userRepeat {
	BorderPane pane = new BorderPane();
	Text text = new Text(50,50,"该学生不存在！");
	public userRepeat() {
		text.setX(60);
		text.setY(40);
		text.setStyle("-fx-background-color:red;-fx-border-color:red; -fx-border-width:3");
		pane.setCenter(text);
	}
	public Pane getpane() {
		return pane;
	}
	
}

