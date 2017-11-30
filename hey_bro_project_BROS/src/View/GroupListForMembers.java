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
	private ArrayList<Schedule> tableList = new ArrayList<>();
	public GroupListForMembers(Session session, String year, String month, String date, String gName){
		// �������� ����� ���մϴ�.
		Dimension frameSize = this.getSize();
		// �� ������� ũ�⸦ ���մϴ�.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * �׷��� �������� ��ġ��
		 * (�����ȭ�� ���� - ������ȭ�� ����) / 2,
		 * (�����ȭ�� ���� - ������ȭ�� ����) / 2 �̷��� �����Ѵ�.
		 */


		this.session = session;
		this.year = year;
		this.month = month;
		this.date = date;
		//System.out.println("year:"+year);
		//System.out.println("month:"+month);
		//System.out.println("date:"+date);
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
		String cmonth = year + " �� " + month + " �� " + date + " ��"; 
		String yearStr = year;
		String monthStr = month;
		String dateStr = date;
		currentMonth.setText(cmonth);
		currentMonth.setBounds(100, 35, 400, 100);
		currentMonth.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		if(Integer.parseInt(year) < 10){
			yearStr = "0"+year;
		}
		if(Integer.parseInt(month) < 10){
			monthStr = "0"+month;
		}
		if(Integer.parseInt(date) < 10){
			dateStr = "0"+date;
		}
		String smonth = yearStr + "/" + monthStr + "/" + dateStr;
		//System.out.println("smonth:"+smonth);
		list.clear();
		list = sc.process("ScheduleSatting.do", gName);
		/*for (int i = 0; i < list.size(); i++) {
			
			System.out.println("First_list Ȯ�� : " + list.get(i));
		}*/
		for(int i = 0; i < list.size(); i++){
			//System.out.println(list.get(i).getDate());
			if((smonth.equals(list.get(i).getDate()))){
				//System.out.println("���� list Ȯ�� : " + list.get(i));
				tableList.add(list.get(i));
			}
		}
		for (int i = 0; i < tableList.size(); i++) {
			
			//System.out.println("tableList Ȯ�� : " + tableList.get(i));
		}

		//table1
		String str;

		String[][] str_arr = new String[tableList.size()][4];

		String[] copy;

	//	System.out.println("copy.length : " + copy.length);
		String strN;
		String strT;
		String strS;
		String strE;
		String strti;
		String strc;
		ArrayList<String> copyList = new ArrayList<>();
		for(int i = 0; i < tableList.size(); i++){
				strN = String.valueOf(tableList.get(i).getNumber());
				System.out.println("strN:"+strN);
				strT = tableList.get(i).getUserName();
				strS = tableList.get(i).getStartTime();
				strE = tableList.get(i).getEndTime();
				strti = tableList.get(i).getTitle();
				strc = tableList.get(i).getContents();
				copyList.add(strN+ ", " + strT+ ", " + strS + ", " + strE + ", " + strti + ", " + strc);
		}
		//
		copy = copyList.toString().split(", ");
		
		Object[][] data = new Object[tableList.size()][6];
		int count = 0;
		for(int i = 0; i < data.length; i++){	
			
			for(int j = 0; j < data[i].length; j++){
				data[i][j] = copy[count].replace("[", "");
				data[i][j] = String.valueOf(data[i][j]).replace("]", "");
				count++;
			}
		}
		/*for(int i = 0; i < data.length; i++){	
			for(int j = 0; j < data[i].length; j++){
				System.out.println(data[i][j]);
			}
		}*/

		String[] columnNames = {"��ȣ","ID","���۽ð�", "����ð�", "������" , "��������" };		

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
		
		//table.add//
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					//
					@Override
					public void mousePressed(MouseEvent e) {
						int row = table.getSelectedRow();
						int column =table.getSelectedColumn();
						new ScheduleUpdate_UI().scheduleEdit(session,copyList,tableList,row,column);
						
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
						if(e.getButton()==1) {
						new ScheduleUpdate_UI();
						isVisible();
						//System.out.println("����");
						}
					}
				});

		JScrollPane sp = new JScrollPane(table);




		JButton back = new JButton("�ڷ� ����");
		back.setBounds(900,70,100,30);
		JButton scheduleRegister_bt = new JButton("���� �߰�");
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
