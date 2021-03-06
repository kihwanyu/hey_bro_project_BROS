package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Controller.GroupController;
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
	private ArrayList<String> scheduleList = new ArrayList<>();
	private ArrayList<Schedule> tempScheduleList = new ArrayList<>();
	private Session session = new Session();
	private JSpinner dateSpinner;
	JTextArea[][] date_textArea = new JTextArea[6][7];
	private Group group = new Group();
	private String gName;
	private GroupController gc = new GroupController();


	private ScheduleController sc = new ScheduleController();
	public Group_Calendar_UI(Session session, String gName/*방이름*/){

		group = gc.process("GroupSetting.do", gName, true);
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
		//this.setBackground(Color.WHITE);
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
			}
		}
		for(int i = 0; i < date_textArea.length; i++){	
			//System.out.println(y);
			date_text[i].setBounds(300, y, 700, 70);
			date_text[i].setLayout(new GridLayout(1,7,0,0));
			y += 95;
		}
		for(int i = 0; i < date_text.length; i++){
			for(int j = 0; j < date_textArea[i].length; j++){
				//System.out.println(j);
				date_text[i].add(date_textArea[i][j]);
				date_textArea[i][j].setLineWrap(true);
				//date_textArea[i][j].setEnabled(false);
				date_textArea[i][j].setBackground(Color.WHITE);
			}
		}

		// 모임 내용 텍스트 필드
		JTextArea gtf = new JTextArea();
		gtf.setText(group.getContent());
		gtf.setSize(170, 160);
		gtf.setLocation(35, 130);
		gtf.setLineWrap(true);

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

		monthList.setVisible(true);
		//달력버튼출력 메소드
		tempScheduleList.clear();
		tempScheduleList = sc.process("ScheduleSatting.do", gName);
		CalendarButtonUpdate(calendar,utilTodayCalendar.get(Calendar.MONTH)+1);


		//뒤로가기 버튼
		JButton backB = new JButton("뒤로가기");
		backB.setBounds(69, 670, 100, 30);

		//종료버튼
		JButton exitBtn = new JButton("종료");
		exitBtn.setBounds(980, 30, 100, 30);
		exitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setSize(1100, 800);
		
	

		JPanel userPanel = new JPanel();
		userPanel.setLocation(0, 0);
		userPanel.setBackground(Color.ORANGE);
		userPanel.setSize(240, 800);
		//icon_ : 좌측버튼
		//icon : 우측버튼

		/*Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/모임 삭제 버튼.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton groupLeave_bt = new JButton(new ImageIcon(icon_3));
		groupLeave_bt.setLocation(30, 560);
		groupLeave_bt.setSize(180, 52);*/

		//text
		JLabel textGl = new JLabel("님은 모임원입니다.");
		textGl.setLocation(90, 43);
		textGl.setSize(120, 50);
		JLabel textGln = new JLabel(session.getUserId());
		textGln.setLocation(45, 43);
		textGln.setSize(60, 50);

		Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
		JLabel png = new JLabel(new ImageIcon(icon_4));
		png.setLocation(0, 3);
		png.setSize(48, 45);

		for(int i = 0; i < date_textArea.length; i++){
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
		/*groupLeave_bt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new LeaveGroup_UI(session, gName);
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
		});*/
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


		this.add(exitBtn);
		this.add(cjp);
		this.add(monthList);
		this.add(backB);
		this.add(gtf);
		this.add(dayP);
		this.add(cPanel);
		this.add(png);
		//this.add(groupLeave_bt);
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
		scheduleList.clear();

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
		ArrayList<Schedule> thisMonthScheduleList = new ArrayList<>();
		//SimpleDateFormat dateParse = new SimpleDateFormat("yyyy/MM");

		String thisMonthDate = year+"/"+month;
		for(int i = 0; i < tempScheduleList.size(); i++){
			String[] tempScheduleStr = String.valueOf(tempScheduleList.get(i).getDate()).split("/");
			if(Integer.parseInt(tempScheduleStr[1])<10){
				tempScheduleStr[1] = tempScheduleStr[1].substring(1);
			}
			String tempScheduleStrYearMonth = tempScheduleStr[0] +"/" + tempScheduleStr[1];
			if(tempScheduleStrYearMonth.equals(thisMonthDate)){
				thisMonthScheduleList.add(tempScheduleList.get(i));
			}	
		}

		int count = 0;
		int temp = 0;
		int indexTemp = 0;
		boolean countingQuestion = true;
		for(int i = 0; i < dateList.size(); i++){
			countingQuestion = true;
			if(!dateList.get(i).equals("")){

				try {
					//System.out.println(tempScheduleList.get(count).getDate());
					String[] tempScheduleStr = String.valueOf(thisMonthScheduleList.get(count).getDate()).split("/");
					if(Integer.parseInt(tempScheduleStr[2])<10){
						tempScheduleStr[2] = tempScheduleStr[2].substring(1);
						//System.out.println(tempScheduleStr[2]);
					}
					if(Integer.parseInt(tempScheduleStr[1])<10){
						tempScheduleStr[1] = tempScheduleStr[1].substring(1);
						//System.out.println(tempScheduleStr[2]);
					}
					if(temp!=0){
						if(temp==Integer.parseInt(tempScheduleStr[2])&&
								String.valueOf(year).equals(tempScheduleStr[0])&&
								String.valueOf(month).equals(tempScheduleStr[1])){
							//System.out.println(temp);
							StringBuilder sb = new StringBuilder();
							String str = "["+thisMonthScheduleList.get(count).getUserName()+"] " + thisMonthScheduleList.get(count).getTitle()+"\n";
							System.out.println(str);
							sb.append(scheduleList.get(indexTemp));
							System.out.println(scheduleList.get(indexTemp));
							sb.append(str);
							scheduleList.set(indexTemp, sb.toString());
							countingQuestion = false;
							count++;
							i--;
						}
					} 
					if(countingQuestion){
						if(dateList.get(i).equals(tempScheduleStr[2])&&
								String.valueOf(year).equals(tempScheduleStr[0])&&
								String.valueOf(month).equals(tempScheduleStr[1])){
							String str = "["+thisMonthScheduleList.get(count).getUserName()+"] " + thisMonthScheduleList.get(count).getTitle() +"\n";
							scheduleList.add(str);
							if(temp < Integer.parseInt(tempScheduleStr[2])){ 
								temp = Integer.parseInt(tempScheduleStr[2]);
								indexTemp = i;
							}				
							count++;
						} else {
							scheduleList.add("");
						}
					}	
				} catch (IndexOutOfBoundsException e) {
					System.out.println();
				}						
			} else {
				scheduleList.add("");
			} 
		}
		count = 0;
		for(int i = 0; i < date_textArea.length; i++){
			for(int j = 0; j < date_textArea[i].length; j++){
				try {
					date_textArea[i][j].setText(scheduleList.get(count));
					count++;
				} catch (Exception e) {
					break;
				}		
			}
		}
		System.out.println(scheduleList.toString());
		for(int i = 0; i < date_bt.length; i++){
			try {
				date_bt[i].setText(dateList.get(i).toString());
			} catch (Exception e) {
				break;
			}			
		}
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
				SimpleDateFormat dateParse = new SimpleDateFormat("yyyy");
				String dateSpinnerYear = dateParse.format(dateSpinner.getValue());
				String monthListValue = String.valueOf(monthList.getSelectedItem());
				new GroupListForMembers(session,dateSpinnerYear,monthListValue,button.getText(), gName);
				thisSetVisibleFalse();
			}
		});
	}
	public void thisSetVisibleFalse(){
		this.setVisible(false);
	}
}