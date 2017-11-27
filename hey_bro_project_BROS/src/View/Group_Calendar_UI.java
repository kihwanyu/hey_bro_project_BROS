package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Group_Calendar_UI{
	//
	public void calendar(){
		JFrame mf = new JFrame();      
		JButton[] date_bt = new JButton[42];
		mf.setLayout(null);
		mf.setBackground(Color.WHITE);
		//������ ũ��
		mf.setBounds(100, 50, 1100, 800);
		//������ �̸�
		mf.setTitle("Hey~bro");
		mf.setResizable(false);
		int y = 155;
		//�޷� �г� 
		JPanel cjp = new JPanel();
		cjp.setBounds(300, 130, 700, 500);
		cjp.setLayout(new GridLayout(6, 7, 0, 70));

		Calendar utilTodayCalendar = new GregorianCalendar();
		Calendar dateOperationCalendar = new GregorianCalendar(); 

		/*for (int i = 1; i < date_bt.length; i++) {
			date_bt[i] = new JButton();
			String str = String.valueOf(i).toString();
			date_bt[i].setText(str);
			cjp.add(date_bt[i]);   
		}*/

		JPanel[] date_text = new JPanel[6];
		JTextField[][] date_textField = new JTextField[6][7];
		//final int CAL_SIZE = 45;
		for(int i = 0; i < date_textField.length; i++){
			date_text[i] = new JPanel();
			for(int j = 0; j < date_textField[i].length; j++){
				date_textField[i][j] = new JTextField(""); 
			}
		}
		for(int i = 0; i < date_textField.length; i++){	
			System.out.println(y);
			date_text[i].setBounds(300, y, 700, 70);
			date_text[i].setLayout(new GridLayout(1,7,0,0));
			y += 95;
		}
		for(int i = 0; i < date_text.length; i++){
			for(int j = 0; j < date_textField[i].length; j++){
				System.out.println(j);
				date_text[i].add(date_textField[i][j]);
			}
		}

		// ���� ���� �ؽ�Ʈ �ʵ�
		JTextField gtf = new JTextField();
		gtf.setText("���� ����");
		gtf.setSize(170, 160);
		gtf.setLocation(35, 130);

		//���� �г�
		JPanel dayP = new JPanel();
		dayP.setBounds(300, 100, 700, 30);
		dayP.setLayout(new GridLayout(1,7));
		String[] days = {"��","��","ȭ","��","��","��","��"}; 
		for (int i = 0; i < 7; i++) {
			String str = days[i];
			dayP.add(new JTextField("              "+str));
		}
		//
		// ��� ��¥ǥ�� ���ǳ�
		JPanel cPanel = new JPanel(); 
		cPanel.setBounds(594, 30, 110, 30);

		Date value = utilTodayCalendar.getTime(); // ���糯¥
		utilTodayCalendar.add(utilTodayCalendar.MONTH, -1); 

		Date start = utilTodayCalendar.getTime();
		utilTodayCalendar.add(Calendar.YEAR, 50);//+50 �ϸ� ���� ��¥

		Date end = utilTodayCalendar.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.MONTH);
		JSpinner dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy/MM"));
		cPanel.add(dateSpinner);

		int dateOperationMonth = utilTodayCalendar.get(Calendar.MONTH)+2;
		/*String[] date_str = new String[6];
		date_str = String.valueOf(dateSpinner.getValue()).split(" ");
		System.out.println(dateSpinner.getValue());*/
		dateOperationCalendar = new GregorianCalendar(2017,dateOperationMonth,1);
		int key = dateOperationCalendar.get(Calendar.DAY_OF_WEEK); // ������
		//System.out.println("Calendar" + dateOperationCalendar.toString());
		//System.out.println("dateOperationCalendar_Calendar.DAY_OF_WEEK = " + dateOperationCalendar.get(Calendar.DAY_OF_WEEK));
		//System.out.println(dateOperationCalendar.get(Calendar.DAY_OF_MONTH));

		int year = dateOperationCalendar.get(Calendar.YEAR);
		int month = dateOperationCalendar.get(Calendar.MONTH);
		int day_of_week = dateOperationCalendar.get(Calendar.DAY_OF_WEEK);
		
		switch (key) {
		case 6:
			ArrayList<String> dateList = new ArrayList<>();
			if((0 == (year % 4) && 0 != (year %100)) || 0 == year%400) {
				if(month==2) {
					for(int i = 0; i < 29; i++){
						if(day_of_week==4){
							date_bt[i] = new JButton();
							dateList.add(String.valueOf(i+1).toString());
							//String str = String.valueOf(i+1).toString();
							//date_bt[i].setText(str);
						}
					}
				}
				else if(month==4||month==6||month==9||month==11){
					for(int i = 0; i < 30; i++){
						date_bt[i] = new JButton();
						dateList.add(String.valueOf(i+1).toString());
						//String str = String.valueOf(i+1).toString();
						//date_bt[i].setText(str);	
					}
				}
				else {
					for(int i = 0; i < 31; i++){
						date_bt[i] = new JButton();
						date_bt[i] = new JButton();
						dateList.add(String.valueOf(i+1).toString());
						/*String str = String.valueOf(i+1).toString();
						date_bt[i].setText(str);*/
					}
				}
			}
			else if(month==2){
				for(int i = 0; i < 28; i++){
					date_bt[i] = new JButton();
					dateList.add(String.valueOf(i+1).toString());
					/*String str = String.valueOf(i+1).toString();
					date_bt[i].setText(str);*/
				}
			}
			else if(month==4||month==6||month==9||month==11){
				for(int i = 0; i < 30; i++){
					date_bt[i] = new JButton();
					dateList.add(String.valueOf(i+1).toString());
					/*String str = String.valueOf(i+1).toString();
					date_bt[i].setText(str);*/
				}
			}
			else {
				for(int i = 0; i < 31; i++){
					date_bt[i] = new JButton();
					dateList.add(String.valueOf(i+1).toString());
					/*String str = String.valueOf(i+1).toString();
					date_bt[i].setText(str);*/	
				}
			}
			break;

		default:
			break;
		}
		
		//���� ��� ����Ʈ ��ư 
		JButton listB = new JButton("L I S T");
		listB.setBounds(900, 20, 100, 40);

		//�ڷΰ��� ��ư
		JButton backB = new JButton("�ڷΰ���");
		backB.setBounds(69, 670, 100, 30);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setSize(1100, 800);
		JPanel userPanel = new JPanel();


		userPanel.setLocation(0, 0);
		userPanel.setBackground(Color.LIGHT_GRAY);
		userPanel.setSize(240, 800);
		//icon_ : ������ư
		//icon : ������ư



		/*   Image icon_1 = new ImageIcon("hey_bro_project_BROS/src/View/img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
      JButton edit = new JButton(new ImageIcon(icon_1));
      edit.setLocation(30, 420);
      edit.setSize(180, 52);*/

		Image icon_2 = new ImageIcon("hey_bro_project_BROS/src/View/img/Group_edit.PNG").getImage().getScaledInstance(205, 48, 0);
		JButton qa = new JButton(new ImageIcon(icon_2));
		qa.setLocation(30, 490);
		qa.setSize(180, 52);

		Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/���� ���� ��ư.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton out = new JButton(new ImageIcon(icon_3));
		out.setLocation(30, 560);
		out.setSize(180, 52);

		//text
		JLabel textGl = new JLabel("���� �������Դϴ�.");
		textGl.setLocation(90, 43);
		textGl.setSize(120, 50);
		JLabel textGln = new JLabel("������");
		textGln.setLocation(45, 43);
		textGln.setSize(60, 50);

		Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
		JLabel png = new JLabel(new ImageIcon(icon_4));
		png.setLocation(0, 3);
		png.setSize(48, 45);

		mf.add(cjp);

		/*mf.add(text1);
		mf.add(text2);
		mf.add(text3);
		mf.add(text4);
		mf.add(text5);
		mf.add(text6);*/



		for(int i = 0; i < date_textField.length; i++){
			mf.add(date_text[i]);
		}
		mf.add(backB);
		mf.add(gtf);
		mf.add(dayP);
		mf.add(cPanel);
		mf.add(listB);
		mf.add(png);
		//mf.add(edit);
		mf.add(qa);
		mf.add(out);
		mf.add(textGl);
		mf.add(textGln);
		mf.add(userPanel);
		mf.add(mainPanel);


		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public static void main(String[] args){
		Group_Calendar_UI u = new Group_Calendar_UI();
		u.calendar();
	}
}