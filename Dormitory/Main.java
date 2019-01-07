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
	BorderPane mainpane = new BorderPane();
	@Override
	public void start (Stage primaryStage) throws IOException {
		Stage secondStage = new Stage();//����������̨
		Stage thirdStage = new Stage();//��������������̨
		Stage passwordErrorStage = new Stage();//�������������̨
		Stage modifyStage = new Stage();//�޸�������̨
		Stage newPassionErrorStage = new Stage();//�����벻һ����̨
		Stage newPassionSucceedStage = new Stage();//�����޸ĳɹ���̨
		Stage checkInStage[][][] = new Stage[3][10][4];//������ס��̨
		Stage checkOutStage[][][] = new Stage[3][10][4];//�����˷���̨
		Stage userRepeatStage = new Stage();
		
		
		LoginUI loginui = new LoginUI();//����������Ҫ����
		passwordError passworderror = new passwordError();
		Roominfo roominfo = new Roominfo();
		Roomboard roomboard[][] = new Roomboard[3][10];
		modify modiFy = new modify();
		newPassionError newPassionerror = new newPassionError();
		newPassionSucceed newPassionsucceed = new newPassionSucceed();
		checkIn checkin[][][] = new checkIn[3][10][4];
		checkOut checkout[][][] = new checkOut[3][10][4];
		userRepeat userrepeat = new userRepeat();
		
		
		studentInfo studentinfo = new studentInfo();	//��������readutf����  ������Ҫ���ɱ����ʽ��ȷ��ѧ����Ϣ
		studentinfo.createStudent();                  //��������utfѧ����Ϣ
		
		Pane checkOutpane[][][] = new Pane[3][10][4];//�����������
		Pane checkInpane[][][] = new Pane[3][10][4];
		Pane modiFypane = modiFy.getpane();
		Pane RoomBoardpane[][] = new Pane[3][10];
		Pane passwordErrorpane = passworderror.getpane();
		Pane newpasswordErrorpane = newPassionerror.getpane();
		Pane newpasswordSucceedpane = newPassionsucceed.getpane();
		Pane userRepeatpane = userrepeat.getpane();
		
		Scene checkOutScene[][][] = new Scene[3][10][4];//����ÿ�����Ҵ�����Ӧ���˷����
		Scene checkInScene[][][] = new Scene[3][10][4];//����ÿ������  ������Ӧ����ס���
		Scene modiFyScene = new Scene(modiFypane,300,400);
		Scene RoomBoardscene[][] = new Scene[3][10];
		Scene passwordErrorScene = new Scene(passwordErrorpane,200,160); 
		Scene newpasswordErrorScene = new Scene(newpasswordErrorpane,160,160);
		Scene newpasswordSucceedScene = new Scene(newpasswordSucceedpane,160,160);
		Scene userrepeatScene = new Scene(userRepeatpane,160,160);
		
		userRepeatStage.setScene(userrepeatScene);
		passwordErrorStage.setScene(passwordErrorScene);
		passwordErrorStage.setTitle("��Ϣ����");
		passworderror.exit.setOnAction(e->{
			passwordErrorStage.close();
			primaryStage.show();
		});
		
		newPassionErrorStage.setScene(newpasswordErrorScene);
		newPassionErrorStage.setTitle("�������벻һ��");
		newPassionerror.exit.setOnAction(e->{
			newPassionErrorStage.close();
			modifyStage.show();
		});
		
		newPassionSucceedStage.setScene(newpasswordSucceedScene);
		newPassionSucceedStage.setTitle("�޸ĳɹ�");
		newPassionsucceed.exit.setOnAction(e->{
			newPassionSucceedStage.close();
			primaryStage.show();
		});
		
		mainpane=loginui.getpane();
		Scene scene = new Scene(mainpane,300,400);
		//loginui.init();   //�������ɹ���Ա�˺�
		roominfo.init();   //����������Ϣ
		primaryStage.setScene(scene);
		primaryStage.setTitle("��½����");
		primaryStage.show();
		roominfo.txname.setEditable(false);
		roominfo.txstudentId.setEditable(false);
		secondStage.setTitle("���Ҳ�ѯ");
		Scene Roominfoscene = new Scene(roominfo.getpane(),600,400);
		secondStage.setScene(Roominfoscene);
		roominfo.btLogout.setOnAction(x->{
			secondStage.close();
			primaryStage.show();
			loginui.setVecode();
		});
		
		modifyStage.setScene(modiFyScene);
		modiFy.btBack.setOnAction(e->{
			modifyStage.close();
			primaryStage.show();
		});
		modiFy.btModify.setOnAction(e->{
			if(modiFy.equal()) {
				
				try (DataOutputStream output = new DataOutputStream(new FileOutputStream("admin.txt"));) {
					output.writeUTF("admin");
					output.writeDouble(0.1);
					output.writeUTF(modiFy.tfmodify.getText());
					output.writeDouble(0.1);
					output.writeUTF("����Ա");
					output.writeDouble(0.1);
					
				}catch (IOException ex) {
					ex.printStackTrace();
				}
				modifyStage.close();
				newPassionSucceedStage.show();
				
			}else {
				modifyStage.close();
				newPassionErrorStage.show();
			}
		});
		
		
		//login���水ť���ʱ��
		loginui.Vecode.setOnAction(e->{
			loginui.setVecode();
		});
		loginui.btOK.setOnAction(e->{
			try {
				if(loginui.equal()) {
					roominfo.txname.setText(loginui.userid.getText());
					roominfo.txstudentId.setText(loginui.userxh.getText());
					roominfo.txname.setEditable(false);
					roominfo.txstudentId.setEditable(false);
					primaryStage.close();
					secondStage.show();
					return;
					
				}else {
					loginui.setVecode();
					primaryStage.close();
					passwordErrorStage.show();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		loginui.btModify.setOnAction(e->{
			try {
				if(loginui.equal()) {
					modifyStage.show();
					primaryStage.close();
					modiFy.tfgh.setText(loginui.tfxh.getText());
					modiFy.tfgh.setEditable(false);
					return;
					
				}else {
					primaryStage.close();
					passwordErrorStage.show();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		//����ҳ������ִ������ҵ�button��ɫ
		roominfo.updateColor();
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<10;j++)
			{
				roomboard[i][j]= new Roomboard();
				RoomBoardpane[i][j]=roomboard[i][j].getpane();
				RoomBoardscene[i][j]= new Scene(RoomBoardpane[i][j],300,400);
				roomboard[i][j].Roomid=String.valueOf(i*100+100+j+1);
				final int x = i;
				final int y = j;
				roominfo.dor[i][j].dorm.setOnAction(e->{
					thirdStage.setTitle(roomboard[x][y].Roomid);
					thirdStage.setScene(RoomBoardscene[x][y]);

						roomboard[x][y].updateButton();

					secondStage.close();
					thirdStage.show();
				});
				
				
				roomboard[x][y].exit.setOnAction(e->{
					thirdStage.close();
					secondStage.show();
				});
				
				
				for(int kk=0;kk<4;kk++)
				{
					final int k=kk;
					checkin[x][y][k]= new checkIn();
					checkInpane[x][y][k] = checkin[x][y][k].getpane();
					checkInScene[x][y][k] = new Scene(checkInpane[x][y][k],400,200);
					checkInStage[x][y][k] = new Stage();
					checkInStage[x][y][k].setScene(checkInScene[x][y][k]);
					
					
					checkout[x][y][k] = new checkOut();
					checkOutpane[x][y][k] = checkout[x][y][k].getpane();
					checkOutScene[x][y][k] = new Scene(checkOutpane[x][y][k],400,400);
					checkOutStage[x][y][k] = new Stage();
					checkOutStage[x][y][k].setScene(checkOutScene[x][y][k]);
					
					
					roomboard[x][y].Bed[k].setOnAction(e->{
						if(checkin[x][y][k].flag==0) {
							checkin[x][y][k].Roomid = String.valueOf(x*100+100+y+1);
							checkin[x][y][k].Bedid = k+1;
							checkInStage[x][y][k].setTitle("ѧ����ס");
							checkInStage[x][y][k].show();
							thirdStage.close();
						
						}else {
							
							checkout[x][y][k].studentId=checkout[x][y][k].studentId;
							checkout[x][y][k].init();
							checkOutStage[x][y][k].setTitle("��Ϣ�鿴���˷�");
							checkOutStage[x][y][k].show();
							thirdStage.close();
						}
					});
					checkin[x][y][k].btBack.setOnAction(e->{
						checkInStage[x][y][k].close();
						thirdStage.show();
					});
					checkout[x][y][k].btBack.setOnAction(e->{
						checkOutStage[x][y][k].close();
						thirdStage.show();
					});
					checkin[x][y][k].btCheckIn.setOnAction(e->{
						int r=Integer.parseInt(checkin[x][y][k].tfStudentId.getText());
						System.out.println(checkin[x][y][k].tfStudentId);
						System.out.println(checkin[x][y][k].tfStudentId.getText());
						System.out.println("debug:"+r);
						if(r>=2018001&&r<=2018030) {
						checkin[x][y][k].flag=1;
						checkin[x][y][k].studentIn();
						roomboard[x][y].updateButton();
						checkout[x][y][k].studentId=checkin[x][y][k].tfStudentId.getText();
						try {
							roominfo.updateColor();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						checkInStage[x][y][k].close();
						thirdStage.show();
						}else {
							userRepeatStage.show();
							
							
							
						}
					});
					checkout[x][y][k].btCheckOut.setOnAction(e->{
						checkin[x][y][k].flag=0;
						checkout[x][y][k].studentOut();
						roomboard[x][y].updateButton();
						try {
							roominfo.updateColor();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						checkOutStage[x][y][k].close();
						thirdStage.show();
						
					});
					
				}
			}
		}
		
	}
private int valueOf(String text) {
	// TODO Auto-generated method stub
	return 0;
}



}




