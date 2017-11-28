package View;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Schedule;
import Model.vo.Session;


public class GroupListForMembers extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2079468117320843313L;
	private JPanel mainPanel;
	private JFrame superFrame;
	private Member m = new Member();
	private Group g = new Group();
	private Schedule s = new Schedule();
	private Session session = new Session();
	private String year;
	private String month;
	private String date;
	public GroupListForMembers(Session session, String year, String month, String date){
		this.year = year;
		this.month = month;
		this.date = date;
		//JFrame mf = new JFrame();		
		this.setBounds(300, 100, 800, 500);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		
		//Group Name
		JLabel lb1 = new JLabel(g.getgName());
		lb1.setBounds(30, 10, 100, 40);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

		//Profile photo
		Image icon = new ImageIcon(m.getPictureUrl()).getImage().getScaledInstance(48, 45, 0);;
		JLabel lb2 = new JLabel(new ImageIcon(icon));
		lb2.setBounds(1, 28, 80, 80);
		
		//Profile 
		JLabel lb3 = new JLabel(m.getUserId() + "�� ���ӿ��Դϴ�.");								
		lb3.setBounds(70, 20, 200, 100);
		lb3.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		
		//Group Description
		JLabel lb4 = new JLabel(g.getContent());
		lb4.setBounds(20, 60, 250, 110);
		lb4.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		
		
		//Leave the group
		JButton btn = new JButton("���� ������");
		btn.setBounds(20, 350, 220, 50);
		
		JLabel currentMonth = new JLabel();
		Calendar today = new GregorianCalendar();
		String cmonth = Integer.valueOf(today.get(Calendar.MONTH)+1).toString() + "��"; 
		currentMonth.setText(cmonth);
		currentMonth.setBounds(300, 75, 150, 100);
		currentMonth.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	
		//table1
		 /*Object [][] data = {
				{"a", "b", "c"}
				};*/
		
		
		Object [][] data = null;
		/*for(int i =0; i<prop.size();i++){			
			data[i] = new Object[] {s.getDate(), s.getStartHour(), s.getStartMin(), s.getEndHour(), s.getEndMin(), s.getsContent()};			
		}*/
		 
		 String[] columnNames = {"��", "���۽ð�", "����ð�", "������" , "��������" };		
		 
	      DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
	      
	      JTable table = new JTable(dtm);
	      table.setBounds(290, 160, 420, 30);
	      table.setAutoCreateRowSorter(true);
	      table.getTableHeader().setReorderingAllowed(false);
	      
	      JTableHeader th = table.getTableHeader();
	      th.setBounds(290, 140, 420, 20);
	      th.setReorderingAllowed(false);
	      th.setResizingAllowed(false);
	      
	      table.setFillsViewportHeight(true);
	      table.setPreferredScrollableViewportSize(new Dimension(500, 150));
		
	      JScrollPane sp = new JScrollPane(table);
	     
		
	      
		      
		 JButton back = new JButton("�ڷ� ����");
		 back.setBounds(650,20,100,30);
		 back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		      
	      
	      
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);		
		panel.add(btn);		
		panel.add(currentMonth);
		panel.add(th);
		panel.add(table);
		panel.add(sp);
		panel.add(back);		
		this.add(panel);
	
		
		
		this.setVisible(true);
//		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	
}
