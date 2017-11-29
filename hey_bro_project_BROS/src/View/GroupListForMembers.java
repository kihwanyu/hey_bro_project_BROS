package View;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.ScheduleController;
import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Schedule;
import Model.vo.Session;


public class GroupListForMembers extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2079468117320843313L;

	private Member m = new Member();
	private Group g = new Group();
	private Schedule s = new Schedule();
	private ScheduleController sc = new ScheduleController();
	private Session session = new Session();
	private String year;
	private String month;
	private String date;
	private ArrayList<Schedule> list = new ArrayList<>();
	public GroupListForMembers(Session session, String year, String month, String date, String gName){
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * 그래서 프레임의 위치를
		 * (모니터화면 가로 - 프레임화면 가로) / 2,
		 * (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
		 */


		this.session = session;
		this.year = year;
		this.month = month;
		this.date = date;
		//JFrame mf = new JFrame();		
		this.setBounds(100, 50, 1100, 800);
		this.setLocation((screenSize.width - frameSize.width)/7, (screenSize.height - frameSize.height)/8);
		this.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1100, 800);

		//Group Name
		JLabel lb1 = new JLabel(g.getgName());
		lb1.setBounds(30, 10, 100, 40);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

		//Profile photo
		Image icon = new ImageIcon(m.getPictureUrl()).getImage().getScaledInstance(48, 45, 0);
		JLabel lb2 = new JLabel(new ImageIcon(icon));
		lb2.setBounds(1, 28, 80, 80);	

		JLabel currentMonth = new JLabel();
		String cmonth = year + " 년 " + month + " 월 " + date + " 일"; 
		currentMonth.setText(cmonth);
		currentMonth.setBounds(100, 35, 400, 100);
		currentMonth.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

		list = sc.process("ScheduleList.do", year + month + date, gName);



		//table1
		String str;

		String[] str_arr = new String[list.size()];
		
		System.out.println("str_arr.size() = "+str_arr.length);
		for(int i = 0; i < str_arr.length; i++){
			str_arr[i] = list.get(i).toString();
		}

		Object[][] data = new Object[list.size()][4];
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data.length; j++){
				data[i][j] = new Object();
			}
		}
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				try {
					data[i][j] = str_arr[j];
				} catch (Exception e) {
					break;
				}
				
			}




		}
		/*			Object [][] data = {
					{"a", "b", "c", "d"},
					{"a", "b", "c", "d"},
					{"a", "b", "c", "d"},
					{"a", "b", "c", "d"},
					{"a", "b", "c", "d"},
					{"a", "b", "c", "d"},
			};
		 */



		//Object [][] data = null;
		/*for(int i =0; i<prop.size();i++){			
			data[i] = new Object[] {s.getDate(), s.getStartHour(), s.getStartMin(), s.getEndHour(), s.getEndMin(), s.getsContent()};			
		}*/

		String[] columnNames = {"시작시간", "종료시간", "일정명" , "일정내용" };		

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

		JTable table = new JTable(dtm);
		table.setBounds(100, 180, 900, 500);
		//table.setAutoCreateRowSorter(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(40);
		JTableHeader th = table.getTableHeader();
		th.setBounds(100, 130, 900, 50);
		th.setReorderingAllowed(false);
		th.setResizingAllowed(false);

		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 150));

		JScrollPane sp = new JScrollPane(table);




		JButton back = new JButton("뒤로 가기");
		back.setBounds(900,70,100,30);
		JButton scheduleRegister_bt = new JButton("일정 추가");
		scheduleRegister_bt.setBounds(900,720,100,30);
		back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Group_Calendar_UI(session, gName);
				thisSetVisibleFalse();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		scheduleRegister_bt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new ScheduleRegister(session,year,month,date, gName);
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


		panel.add(lb1);
		panel.add(lb2);	
		panel.add(currentMonth);
		panel.add(th);
		panel.add(table);
		panel.add(sp);
		panel.add(back);	
		panel.add(scheduleRegister_bt);
		this.add(panel);



		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	public void thisSetVisibleFalse(){
		this.setVisible(false);
	}
	/*	public static void main(String[] args){
		Session session = new Session("11", "11");

		new GroupListForMembers(session, "2017", "11", "29");
	}
	 */

}
