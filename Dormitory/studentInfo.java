

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

public class studentInfo {
	int x;
	public void createStudent() {
		x=1;
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("studentInfo.txt"));) {
			
			output.writeUTF("2018001");
			output.writeDouble(0.1);
			output.writeUTF("��è");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018002");
			output.writeDouble(0.1);
			output.writeUTF("��¹");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018003");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018004");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018005");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018006");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018007");
			output.writeDouble(0.1);
			output.writeUTF("��Ѽ");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018008");
			output.writeDouble(0.1);
			output.writeUTF("��");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018009");
			output.writeDouble(0.1);
			output.writeUTF("���");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018010");
			output.writeDouble(0.1);
			output.writeUTF("��");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018011");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018012");
			output.writeDouble(0.1);
			output.writeUTF("��");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018013");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018014");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018015");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����101");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018016");
			output.writeDouble(0.1);
			output.writeUTF("��ţ");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018017");
			output.writeDouble(0.1);
			output.writeUTF("���");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018018");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018019");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018020");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018021");
			output.writeDouble(0.1);
			output.writeUTF("��è");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018022");
			output.writeDouble(0.1);
			output.writeUTF("��¹");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018023");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018024");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018025");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018026");
			output.writeDouble(0.1);
			output.writeUTF("����");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018027");
			output.writeDouble(0.1);
			output.writeUTF("��Ѽ");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018028");
			output.writeDouble(0.1);
			output.writeUTF("�й�");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			

			
			output.writeUTF("2018029");
			output.writeDouble(0.1);
			output.writeUTF("�к�");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			
			output.writeUTF("2018030");
			output.writeDouble(0.1);
			output.writeUTF("�л�");
			output.writeDouble(0.1);
			output.writeUTF("����Ժ");
			output.writeDouble(0.1);
			output.writeUTF("�����ѧ");
			output.writeDouble(0.1);
			output.writeUTF("����102");
			output.writeDouble(0.1);
			output.writeUTF("0");
			output.writeDouble(0.1);
			

			
		
			
		}		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
