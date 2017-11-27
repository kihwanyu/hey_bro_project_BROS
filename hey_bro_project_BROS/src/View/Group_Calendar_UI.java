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
	////
	public void calendar(){
		JFrame mf = new JFrame();      
		JButton[] date_bt = new JButton[42];
		mf.setLayout(null);
		mf.setBackground(Color.WHITE);
		//프레임 크기
		mf.setBounds(100, 50, 1100, 800);
		//프레임 이름
		mf.setTitle("Hey~bro");
		mf.setResizable(false);
		int y = 155;
		//달력 패널 
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
			//System.out.println(y);
			date_text[i].setBounds(300, y, 700, 70);
			date_text[i].setLayout(new GridLayout(1,7,0,0));
			y += 95;
		}
		for(int i = 0; i < date_text.length; i++){
			for(int j = 0; j < date_textField[i].length; j++){
				//System.out.println(j);
				date_text[i].add(date_textField[i][j]);
			}
		}

		// 모임 내용 텍스트 필드
		JTextField gtf = new JTextField();
		gtf.setText("모임 내용");
		gtf.setSize(170, 160);
		gtf.setLocation(35, 130);

		//요일 패널
		JPanel dayP = new JPanel();
		dayP.setBounds(300, 100, 700, 30);
		dayP.setLayout(new GridLayout(1,7));
		String[] days = {"일","월","화","수","목","금","토"}; 
		for (int i = 0; i < 7; i++) {
			String str = days[i];
			dayP.add(new JTextField("              "+str));
		}
		//
		// 상단 날짜표시 스피너
		JPanel cPanel = new JPanel(); 
		cPanel.setBounds(594, 30, 110, 30);

		Calendar calendar = new GregorianCalendar(2018,8,28);
		
		Date value = utilTodayCalendar.getTime(); // 현재날짜
		utilTodayCalendar.add(utilTodayCalendar.MONTH, -1); 
		//1금요일~7목요일
		Date start = utilTodayCalendar.getTime();
		utilTodayCalendar.add(Calendar.YEAR, 50);//+50 하면 현재 날짜

		Date end = utilTodayCalendar.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.MONTH);
		JSpinner dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy/MM"));
		
		cPanel.add(dateSpinner);

		//int dateOperationMonth = calendar.get(Calendar.MONTH)+1;
		/*String[] date_str = new String[6];
		date_str = String.valueOf(dateSpinner.getValue()).split(" ");
		System.out.println(dateSpinner.getValue());*/
		//dateOperationCalendar = new GregorianCalendar(2017,dateOperationMonth,1);
		//int key = dateOperationCalendar.get(Calendar.DAY_OF_WEEK); // 월요일
		//System.out.println("Calendar" + dateOperationCalendar.toString());
		//System.out.println("dateOperationCalendar_Calendar.DAY_OF_WEEK = " + dateOperationCalendar.get(Calendar.DAY_OF_WEEK));
		//System.out.println(dateOperationCalendar.get(Calendar.DAY_OF_MONTH));

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year + " "+ month + " " +date+" "+ day_of_week);
		System.out.println();
		ArrayList<String> dateList = new ArrayList<>();
		int date_valueArr = 0;
		int day_of_weekArr = 0;
		for(int i = 0; i < date_bt.length; i++){
			date_bt[i] = new JButton(String.valueOf(i));
			System.out.println(date_bt[i].getText());
		}
		switch (day_of_week) {
		case 1:
			day_of_weekArr = 5;
			break;
		case 2:
			day_of_weekArr = 6; 
			break;
		case 3:
			day_of_weekArr = 0;
			break;
		case 4:
			day_of_weekArr = 1;
			break;
		case 5:
			day_of_weekArr = 2;
			break;
		case 6:
			day_of_weekArr = 3;
			break;
		case 7:
			day_of_weekArr = 4;
			break;
		default:
			
			break;
		}
		if((0 == (year % 4) && 0 != (year %100)) || 0 == year%400) {
			if(month==2) {
				date_valueArr = 29;
			}
			else if(month==4||month==6||month==9||month==11){
				date_valueArr = 30;
			}
			else {
				date_valueArr = 31;
			}
		}
		else if(month==2){
			date_valueArr = 28;
		}
		else if(month==4||month==6||month==9||month==11){
			date_valueArr = 30;
		}
		else {
			date_valueArr = 31;
		}
		for(int i = 0; i < day_of_weekArr; i++){
			dateList.add("");
		}
		for(int i = 0; i < date_valueArr; i++){
			dateList.add(String.valueOf(i+1).toString());
		}
		for(int i = date_valueArr; i < date_bt.length; i ++){
			dateList.add("");
		}
		/*if((0 == (year % 4) && 0 != (year %100)) || 0 == year%400) {
			//System.out.println("들어옴!");
			if(month==2) {
				for(int i = 0; i < 29; i++){
						dateList.add(String.valueOf(i+1).toString());
					
				}
			}
			else if(month==4||month==6||month==9||month==11){
				for(int i = 0; i < 30; i++){
					dateList.add(String.valueOf(i+1).toString());
				}
			}
			else {
				for(int i = 0; i < 31; i++){
					dateList.add(String.valueOf(i+1).toString());
				}
			}
		}
		else if(month==2){
			for(int i = 0; i < 28; i++){
				dateList.add(String.valueOf(i+1).toString());
			}
		}
		else if(month==4||month==6||month==9||month==11){
			switch (day_of_week) {
			case 4:
				break;
			case 6:
				for(int i = 0; i < 3; i++){
					dateList.add(i,"");
				}
				break;

			default:
				break;
			}
			
			for(int i = 0; i < 30; i++){
				dateList.add(String.valueOf(i+1).toString());
			}
			for(int i = 30; i < date_bt.length; i++){
				dateList.add("");
			}
		}
		else {
			for(int i = 0; i < date_bt.length; i++){
				
				dateList.add(String.valueOf(i+1).toString());
			}
		}*/
		
		
		
		int count = 0;
		for(int i = 0; i < date_bt.length; i++){
			date_bt[i].setText(dateList.get(count).toString());
			System.out.println(count);
			count++;
		}
		
		for(int i = 0; i < dateList.size(); i++){
			System.out.println("arrayList["+i+"] : " + dateList.get(i) );
		}
		//우측 상단 리스트 버튼 
		JButton listB = new JButton("L I S T");
		listB.setBounds(900, 20, 100, 40);

		//뒤로가기 버튼
		JButton backB = new JButton("뒤로가기");
		backB.setBounds(69, 670, 100, 30);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setSize(1100, 800);
		JPanel userPanel = new JPanel();


		userPanel.setLocation(0, 0);
		userPanel.setBackground(Color.LIGHT_GRAY);
		userPanel.setSize(240, 800);
		//icon_ : 좌측버튼
		//icon : 우측버튼



		/*   Image icon_1 = new ImageIcon("hey_bro_project_BROS/src/View/img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
      JButton edit = new JButton(new ImageIcon(icon_1));
      edit.setLocation(30, 420);
      edit.setSize(180, 52);*/

		Image icon_2 = new ImageIcon("hey_bro_project_BROS/src/View/img/Group_edit.PNG").getImage().getScaledInstance(205, 48, 0);
		JButton qa = new JButton(new ImageIcon(icon_2));
		qa.setLocation(30, 490);
		qa.setSize(180, 52);

		Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/모임 삭제 버튼.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton out = new JButton(new ImageIcon(icon_3));
		out.setLocation(30, 560);
		out.setSize(180, 52);

		//text
		JLabel textGl = new JLabel("님은 모임장입니다.");
		textGl.setLocation(90, 43);
		textGl.setSize(120, 50);
		JLabel textGln = new JLabel("조성식");
		textGln.setLocation(45, 43);
		textGln.setSize(60, 50);

		Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
		JLabel png = new JLabel(new ImageIcon(icon_4));
		png.setLocation(0, 3);
		png.setSize(48, 45);

		

		/*mf.add(text1);
		mf.add(text2);
		mf.add(text3);
		mf.add(text4);
		mf.add(text5);
		mf.add(text6);*/



		for(int i = 0; i < date_textField.length; i++){
			mf.add(date_text[i]);
		}
		for(int i = 0; i < date_bt.length; i++){
			cjp.add(date_bt[i]);
		}
		
		mf.add(cjp);
		
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

		mf.revalidate();
		mf.repaint();
	}

	public static void main(String[] args){
		Group_Calendar_UI u = new Group_Calendar_UI();
		u.calendar();
	}
}