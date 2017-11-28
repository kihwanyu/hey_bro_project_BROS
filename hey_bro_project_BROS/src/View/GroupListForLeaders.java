package View;

import java.awt.Dimension;
import java.awt.Font;
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

public class GroupListForLeaders  extends JPanel{
	
	private JPanel mainPanel;
	private JFrame superFrame;
	private Member m = new Member();
	private Group g = new Group();
	private Schedule s = new Schedule();
	private Session session = new Session();
	Properties prop = new Properties();
	
	
	public GroupListForLeaders(Session session){
	
		JFrame mf = new JFrame();		
		mf.setBounds(300, 100, 800, 500);
		mf.setLayout(null); 
		
	
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		
		
		JLabel lb1 = new JLabel(g.getgName());
		lb1.setBounds(30, 10, 100, 40);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		
		Image icon = new ImageIcon(m.getPictureUrl()).getImage().getScaledInstance(48, 45, 0);;
		JLabel lb2 = new JLabel(new ImageIcon(icon));
		lb2.setBounds(1, 28, 80, 80);
		
		//Profile 
		JLabel lb3 = new JLabel(m.getUserId() + "은 모임장입니다.");								
		lb3.setBounds(70, 20, 200, 100);
		lb3.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		
		JLabel lb4 = new JLabel(g.getContent());
		lb4.setBounds(20, 60, 250, 110);
		lb4.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		
		JButton btn = new JButton("모임 정보 수정");
		btn.setBounds(20, 230, 220, 50);
		
		JButton btn2 = new JButton("모임장 위임");
		btn2.setBounds(20, 290, 220, 50);
		
		JButton btn3 = new JButton("모임 삭제");
		btn3.setBounds(20, 350, 220, 50);
		
		
			
		 
		JLabel currentMonth = new JLabel();
		Calendar today = new GregorianCalendar();
		String cmonth = Integer.valueOf(today.get(Calendar.MONTH)+1).toString() + "월"; 
		currentMonth.setText(cmonth);
		currentMonth.setBounds(300, 75, 150, 100);
		currentMonth.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	
		//table1
		
		
		Object [][] data = null;
		for(int i =0; i<prop.size();i++){			
			data[i] = new Object[] {s.getDate(), s.getStartHour(), s.getStartMin(), s.getEndHour(), s.getEndMin(), s.getsContent()};			
		}
		
		 String[] columnNames = {"일", "시작시간", "종료시간", "일정명" , "일정내용" };		
		 

	      DefaultTableModel dtm = new DefaultTableModel(	data, columnNames	  
	    		/* new Object[][]  {		            
								  	      {"16","15:00" , "17:00", "프로젝트 기획 발표", "발표"},
								  	      {"18","11:00" , "17:00", "보고서 제출", "보고서 작성"},		  	      
								  	      },		  	      
		  	     new String[] {"일", "시작시간", "종료시간", "일정명" , "일정내용" }*/
		  	      );
	      
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
	     
		
		 JButton back = new JButton("뒤로 가기");
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
		panel.add(btn2);
		panel.add(btn3);	
		panel.add(currentMonth);
		panel.add(th);
		panel.add(table);
		panel.add(sp);	
		panel.add(back);
		
		mf.add(panel);
	
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	
	
}

