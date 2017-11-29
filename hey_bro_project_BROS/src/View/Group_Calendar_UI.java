package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.ScheduleController;
import Model.vo.Group;
import Model.vo.Schedule;
import Model.vo.Session;

public class Group_Calendar_UI extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1411365908257953013L;
	////
	private JButton date_bt[];
	private JComboBox<String> monthList;
	private ArrayList<String> dateList = new ArrayList<>();
	private Session session = new Session();
	private JSpinner dateSpinner;
	private Group group = new Group();
	private String gName;
	private ArrayList<String> scheduleList = new ArrayList<>();
	private ArrayList<Schedule> tempScheduleList = new ArrayList<>();
	private	ScheduleController sc = new ScheduleController();
	private JTextArea[][] date_textArea = new JTextArea[6][7];
	public Group_Calendar_UI(Session session, String gName/*방이름*/){
		//

		this.gName = gName;
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * 그래서 프레임의 위치를
		 * (모니터화면 가로 - 프레임화면 가로) / 2,
		 * (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
		 */
		this.setLocation((screenSize.width - frameSize.width)/7, (screenSize.height - frameSize.height)/8);
		this.session = session;
		int[] month = new int [12];
		//JFrame this = new JFrame();      
		date_bt = new JButton[42];
		monthList = new JComboBox<>();
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		//프레임 크기
		this.setSize(1100, 800);
		//프레임 이름
		this.setTitle("Hey~bro");
		this.setResizable(false);
		int y = 155;

		//달력 패널 
		JPanel cjp = new JPanel();
		cjp.setBounds(300, 130, 700, 500);
		cjp.setLayout(new GridLayout(6, 7, 0, 70));
		for(int i = 0; i < date_bt.length; i++){
			date_bt[i] = new JButton(String.valueOf(i));
		}
		for(int i = 0; i < month.length; i++){
			month[i] = 1+i;
			monthList.addItem(String.valueOf(month[i]).toString());
		}

		Calendar utilTodayCalendar = new GregorianCalendar();

		JPanel[] date_text = new JPanel[6];

		for(int i = 0; i < date_textArea.length; i++){
			date_text[i] = new JPanel();
			for(int j = 0; j < date_textArea[i].length; j++){
				date_textArea[i][j] = new JTextArea(""); 
				/*sp[i][j] = new JScrollPane(date_textArea[i][j]);
				sp[i][j].setSize(10,10);
				this.add(sp[i][j]); 스크롤이 적용안됨*/
			}
		}
		for(int i = 0; i < date_textArea.length; i++){	
			//System.out.println(y);
			date_text[i].setBounds(300, y, 700, 70);
			date_text[i].setLayout(new GridLayout(1,7,0,0));
			y += 95;
		}
		//수정

		for(int i = 0; i < date_textArea.length; i++){
			for(int j = 0; j < date_textArea[i].length; j++){
				//System.out.println(j);
				date_text[i].add(date_textArea[i][j]);
				date_textArea[i][j].setEditable(false);
				date_textArea[i][j].setBackground(new Color(255,255,245));
				date_textArea[i][j].setLineWrap(true);
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
			JTextField days_text = new JTextField("              "+days[i]);
			//days_text.setEnabled(false);
			dayP.add(days_text);
		}
		//
		// 상단 날짜표시 스피너
		JPanel cPanel = new JPanel(); 
		cPanel.setBounds(594, 30, 110, 30);


		Calendar calendar = new GregorianCalendar(utilTodayCalendar.get(Calendar.YEAR),
				utilTodayCalendar.get(Calendar.MONTH),1);
		//8월은 9 //

		Date value = utilTodayCalendar.getTime(); // 현재날짜
		utilTodayCalendar.add(Calendar.YEAR, -1); 
		//1금요일~7목요일
		Date start = utilTodayCalendar.getTime();
		utilTodayCalendar.add(Calendar.YEAR, 50);//+50 하면 현재 날짜

		Date end = utilTodayCalendar.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		dateSpinner = new JSpinner(dateModel);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy"));
		//dateSpinner.setBackground(Color.WHITE);

		cPanel.add(dateSpinner);
		cPanel.setBackground(Color.WHITE);
		cPanel.setLocation(50+525, 30);
		monthList.setSelectedIndex(calendar.get(Calendar.MONTH));
		monthList.setBounds(50+620, 35, 40, 22);
		tempScheduleList = sc.process("ScheduleSatting.do",gName,
				String.valueOf(calendar.get(Calendar.YEAR)+1),
				String.valueOf(calendar.get(Calendar.MONTH)+1));
		System.out.println(tempScheduleList.size());
		monthList.setVisible(true);
		//달력버튼출력 메소드

		CalendarButtonUpdate(calendar,utilTodayCalendar.get(Calendar.MONTH)+1);



		/*for(int i = 0; i < dateList.size(); i++){
			System.out.println("arrayList["+i+"] : " + dateList.get(i) );
		}*/

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

		Image icon_2 = new ImageIcon("hey_bro_project_BROS/src/View/img/Group_edit.PNG").getImage().getScaledInstance(205, 48, 0);
		JButton groupUpdate_bt = new JButton(new ImageIcon(icon_2));
		groupUpdate_bt.setLocation(30, 490);
		groupUpdate_bt.setSize(180, 52);

		Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/모임 삭제 버튼.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton groupDelete_bt = new JButton(new ImageIcon(icon_3));
		groupDelete_bt.setLocation(30, 560);
		groupDelete_bt.setSize(180, 52);

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

		for(int i = 0; i < date_text.length; i++){
			this.add(date_text[i]);
		}
		for(int i = 0; i < date_bt.length; i++){
			if(!date_bt[i].getText().equals("")){
				date_bt_Click_event(date_bt[i]);
			} else {
				date_bt[i].setEnabled(false);
			}		
			cjp.add(date_bt[i]);
		}
		backB.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Main_UI(session);
				thisSetVisibleFalse();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		dateSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				for(int i = 0; i < date_bt.length; i++){
					date_bt[i].setEnabled(true);
				}
				String[] dateSpinnerYear = String.valueOf(dateSpinner.getValue()).split(" ");
				String monthlistValue = String.valueOf(monthList.getSelectedItem());
				CalendarButtonUpdate(new GregorianCalendar(Integer.parseInt(dateSpinnerYear[5]), Integer.parseInt(monthlistValue)-1, 1),Integer.parseInt(monthlistValue));
				for(int i = 0; i < date_bt.length; i++){
					if(!date_bt[i].getText().equals("")){
						date_bt_Click_event(date_bt[i]);
					} else {
						date_bt[i].setEnabled(false);
					}		
				}
			}
		});
		monthList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < date_bt.length; i++){
					date_bt[i].setEnabled(true);
				}
				String[] dateSpinnerYear = String.valueOf(dateSpinner.getValue()).split(" ");
				String monthlistValue = String.valueOf(monthList.getSelectedItem());
				CalendarButtonUpdate(new GregorianCalendar(Integer.parseInt(dateSpinnerYear[5]), Integer.parseInt(monthlistValue)-1 , 1),Integer.parseInt(monthlistValue));
				for(int i = 0; i < date_bt.length; i++){
					if(!date_bt[i].getText().equals("")){
						date_bt_Click_event(date_bt[i]);
					} else {
						date_bt[i].setEnabled(false);
					}		
				}
			}
		});

		groupUpdate_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			@Override
			public void mousePressed(MouseEvent e) {
				new GroupUpdate_UI(session, group, gName);
				thisSetVisibleFalse();
			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		groupDelete_bt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mousePressed(MouseEvent e) {
				new GroupDelete(session, gName);
				thisSetVisibleFalse();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.add(cjp);
		this.add(monthList);
		this.add(backB);
		this.add(gtf);
		this.add(dayP);
		this.add(cPanel);
		this.add(png);
		this.add(groupUpdate_bt);
		this.add(groupDelete_bt);
		this.add(textGl);
		this.add(textGln);
		this.add(userPanel);
		this.add(mainPanel);

		this.setVisible(true);

		this.revalidate();
		this.repaint();
	}
	public void CalendarButtonUpdate(Calendar calendar, int monthValue){
		dateList.clear();
		
		int year = calendar.get(Calendar.YEAR);
		int month = monthValue;

		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

		int date_valueArr = 0;
		int day_of_weekArr = 0;

		switch (day_of_week) {
		case 1:
			day_of_weekArr = 0;
			break;
		case 2:
			day_of_weekArr = 1; 
			break;
		case 3:
			day_of_weekArr = 2;
			break;
		case 4:
			day_of_weekArr = 3;
			break;
		case 5:
			day_of_weekArr = 4;
			break;
		case 6:
			day_of_weekArr = 5;
			break;
		default:
			day_of_weekArr = 6;
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
		for(int i = date_valueArr+3; i < date_bt.length; i ++){
			dateList.add("");
		}		

		for(int i = 0; i < date_bt.length; i++){
			try {
				date_bt[i].setText(dateList.get(i).toString());
			} catch (Exception e) {
				break;
			}			
		}
		for(int i = 0; i < date_bt.length; i++){
			try {
				date_bt[i].setText(dateList.get(i).toString());

			} catch (Exception e) {
				break;
			}			
		}
		//달력 텍스트 에어리어 띄우기
		int count = 0;
		for(int i = 0; i < dateList.size(); i++){
			
			if(!dateList.get(i).equals("")){
				String[] tempScheduleListDate_str = tempScheduleList.get(count).getDate().split("/");
				if(Integer.parseInt(tempScheduleListDate_str[2])<10){
					tempScheduleListDate_str[2] = tempScheduleListDate_str[2].substring(1);
				}

				if(String.valueOf(year).equals(tempScheduleListDate_str[0])&&
						String.valueOf(month).equals(tempScheduleListDate_str[1])&&
						dateList.get(i).equals(tempScheduleListDate_str[2])){
					String str = "["+ tempScheduleList.get(count).getTitle() + "] " + tempScheduleList.get(count).getTitle() + "\n";
					System.out.println(tempScheduleList.get(count).getDate());
					scheduleList.add(str);
					System.out.println(scheduleList.toString());
					count++;
				} else {
					scheduleList.add("");
				}
			} else {
				scheduleList.add("");
			}
		}
		count = 0;
		for(int i = 0; i < date_textArea.length; i++){			
			for(int j = 0; j < date_textArea[i].length; j++){
				date_textArea[i][j].setText(scheduleList.get(count));
				count++;
				System.out.println(date_textArea[i][j].getText());
			}
		}
		this.revalidate();
		this.repaint();
	}

	public void date_bt_Click_event(JButton button){
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}
			@Override
			public void mousePressed(MouseEvent e) {

			}
			@Override
			public void mouseExited(MouseEvent e) {

			}
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] dateSpinnerYear = String.valueOf(dateSpinner.getValue()).split(" ");
				String monthListValue = String.valueOf(monthList.getSelectedItem());
				new GroupListForMembers(session,dateSpinnerYear[5],monthListValue,button.getText(), gName);
				thisSetVisibleFalse();
			}
		});
	}
	public void thisSetVisibleFalse(){
		this.setVisible(false);
	}
	public static void main(String[] args){
		Session session = new Session("11", "11");

		new Group_Calendar_UI(session, "BROS");	
	}
}