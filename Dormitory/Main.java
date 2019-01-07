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
		Stage secondStage = new Stage();//创建寝室舞台
		Stage thirdStage = new Stage();//创建单独寝室舞台
		Stage passwordErrorStage = new Stage();//密码输入错误舞台
		Stage modifyStage = new Stage();//修改密码舞台
		Stage newPassionErrorStage = new Stage();//新密码不一致舞台
		Stage newPassionSucceedStage = new Stage();//密码修改成功舞台
		Stage checkInStage[][][] = new Stage[3][10][4];//寝室入住舞台
		Stage checkOutStage[][][] = new Stage[3][10][4];//寝室退房舞台
		Stage userRepeatStage = new Stage();
		
		
		LoginUI loginui = new LoginUI();//创建各种需要的类
		passwordError passworderror = new passwordError();
		Roominfo roominfo = new Roominfo();
		Roomboard roomboard[][] = new Roomboard[3][10];
		modify modiFy = new modify();
		newPassionError newPassionerror = new newPassionError();
		newPassionSucceed newPassionsucceed = new newPassionSucceed();
		checkIn checkin[][][] = new checkIn[3][10][4];
		checkOut checkout[][][] = new checkOut[3][10][4];
		userRepeat userrepeat = new userRepeat();
		
		
		studentInfo studentinfo = new studentInfo();	//由于是用readutf读入  所以需要生成编码格式正确的学生信息
		studentinfo.createStudent();                  //用于生成utf学生信息
		
		Pane checkOutpane[][][] = new Pane[3][10][4];//创建各种面板
		Pane checkInpane[][][] = new Pane[3][10][4];
		Pane modiFypane = modiFy.getpane();
		Pane RoomBoardpane[][] = new Pane[3][10];
		Pane passwordErrorpane = passworderror.getpane();
		Pane newpasswordErrorpane = newPassionerror.getpane();
		Pane newpasswordSucceedpane = newPassionsucceed.getpane();
		Pane userRepeatpane = userrepeat.getpane();
		
		Scene checkOutScene[][][] = new Scene[3][10][4];//对于每个寝室创建对应的退房面板
		Scene checkInScene[][][] = new Scene[3][10][4];//对于每个寝室  创建对应的入住面板
		Scene modiFyScene = new Scene(modiFypane,300,400);
		Scene RoomBoardscene[][] = new Scene[3][10];
		Scene passwordErrorScene = new Scene(passwordErrorpane,200,160); 
		Scene newpasswordErrorScene = new Scene(newpasswordErrorpane,160,160);
		Scene newpasswordSucceedScene = new Scene(newpasswordSucceedpane,160,160);
		Scene userrepeatScene = new Scene(userRepeatpane,160,160);
		
		userRepeatStage.setScene(userrepeatScene);
		passwordErrorStage.setScene(passwordErrorScene);
		passwordErrorStage.setTitle("信息错误");
		passworderror.exit.setOnAction(e->{
			passwordErrorStage.close();
			primaryStage.show();
		});
		
		newPassionErrorStage.setScene(newpasswordErrorScene);
		newPassionErrorStage.setTitle("两次密码不一致");
		newPassionerror.exit.setOnAction(e->{
			newPassionErrorStage.close();
			modifyStage.show();
		});
		
		newPassionSucceedStage.setScene(newpasswordSucceedScene);
		newPassionSucceedStage.setTitle("修改成功");
		newPassionsucceed.exit.setOnAction(e->{
			newPassionSucceedStage.close();
			primaryStage.show();
		});
		
		mainpane=loginui.getpane();
		Scene scene = new Scene(mainpane,300,400);
		//loginui.init();   //用于生成管理员账号
		roominfo.init();   //生成寝室信息
		primaryStage.setScene(scene);
		primaryStage.setTitle("登陆界面");
		primaryStage.show();
		roominfo.txname.setEditable(false);
		roominfo.txstudentId.setEditable(false);
		secondStage.setTitle("寝室查询");
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
					output.writeUTF("管理员");
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
		
		
		//login界面按钮添加时间
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
		
		
		//更新页面二各种代表寝室的button颜色
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
							checkInStage[x][y][k].setTitle("学生入住");
							checkInStage[x][y][k].show();
							thirdStage.close();
						
						}else {
							
							checkout[x][y][k].studentId=checkout[x][y][k].studentId;
							checkout[x][y][k].init();
							checkOutStage[x][y][k].setTitle("信息查看及退房");
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




