package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GroupListForLeaders  {
	public void groupList(){
		
	/*	JFrame mf = new JFrame();		
		mf.setBounds(300, 100, 800, 500);
		mf.setLayout(null);*/
		
	
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		
		
		JLabel lb1 = new JLabel("BROS");
		lb1.setBounds(30, 10, 100, 40);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/images (1).png").getImage().getScaledInstance(40, 40, 0);
		JLabel lb2 = new JLabel(new ImageIcon(icon));
		lb2.setBounds(1, 28, 80, 80);
		
		JLabel lb3 = new JLabel("조성식님은 모임장입니다.");
		lb3.setBounds(70, 20, 200, 100);
		lb3.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		
		JLabel lb4 = new JLabel("BROS는 KH정보교육원의 1조 모임으로..");
		lb4.setBounds(20, 60, 250, 110);
		lb4.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		
		JButton btn = new JButton("모임 정보 수정");
		btn.setBounds(20, 230, 220, 50);
		
		JButton btn2 = new JButton("모임장 위임");
		btn2.setBounds(20, 290, 220, 50);
		
		JButton btn3 = new JButton("모임 삭제");
		btn3.setBounds(20, 350, 220, 50);
		
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/if_button-previous_85591.png").getImage().getScaledInstance(30, 30, 0);
		JLabel prev = new JLabel(new ImageIcon(icon2));
		prev.setBounds(430, 50,30,30 );
		
		JLabel year = new JLabel();
		Calendar today = new GregorianCalendar();
		String cyear = Integer.valueOf(today.get(Calendar.YEAR)).toString(); 
		year.setText(cyear);
		year.setBounds(512, 16, 200, 100);
		year.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		
		
		
		Image icon3 = new ImageIcon("hey_bro_project_BROS/src/View/img/if_button-next_85587.png").getImage().getScaledInstance(30, 30, 0);
		JLabel next = new JLabel(new ImageIcon(icon3));
		next.setBounds(600, 50,30,30 );
		
		 
		JLabel currentMonth = new JLabel();
	
		String cmonth = Integer.valueOf(today.get(Calendar.MONTH)).toString() + "월"; 
		currentMonth.setText(cmonth);
		currentMonth.setBounds(300, 75, 150, 100);
		currentMonth.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
	
		//table1
		
		
		 Object[][] data= {		            
	  	      {"16","15:00" , "17:00", "프로젝트 기획 발표", "발표"},
	  	      {"18","11:00" , "17:00", "보고서 제출", "보고서 작성"},		  	      
	  	      };
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
	     
		
	      //table 2
	      
	      
	      Object[][] data2= {		            
		  	      {"16","15:00" , "17:00", "프로젝트 기획 발표", "발표"},
		  	      {"18","11:00" , "17:00", "보고서 제출", "보고서 작성"},		  	      
		  	      };
			 String[] columnNames2 = {"일", "시작시간", "종료시간", "일정명" , "일정내용" };		
			 

		      DefaultTableModel dtm2 = new DefaultTableModel(	data2, columnNames2	  
		    		/* new Object[][]  {		            
									  	      {"16","15:00" , "17:00", "프로젝트 기획 발표", "발표"},
									  	      {"18","11:00" , "17:00", "보고서 제출", "보고서 작성"},		  	      
									  	      },		  	      
			  	     new String[] {"일", "시작시간", "종료시간", "일정명" , "일정내용" }*/
			  	      );
		      
		      JTable table2 = new JTable(dtm2);
		      table2.setBounds(290, 270, 420, 30);
		      table2.setAutoCreateRowSorter(true);
		      table2.getTableHeader().setReorderingAllowed(false);
		      
		      JTableHeader th2 = table2.getTableHeader();
		      th2.setBounds(290, 250, 420, 20);
		      th2.setReorderingAllowed(false);
		      th2.setResizingAllowed(false);
		      
		      table2.setFillsViewportHeight(true);
		      table2.setPreferredScrollableViewportSize(new Dimension(500, 150));
			
		      JScrollPane sp2 = new JScrollPane( table2);
	      
		      
		      JButton calendar = new JButton("Calendar");
		      calendar.setBounds(650,20,100,30);
		      
	      
	      
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(btn);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(prev);
		panel.add(next);
		panel.add(year);
		panel.add(currentMonth);
		panel.add(th);
		panel.add(table);
		panel.add(sp);
		panel.add(th2);
		panel.add(table2);
		panel.add(sp2);
		panel.add(calendar);
		
		/*mf.add(panel);
	
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
	}
	
	/*
	public static void main(String[] args){
		GroupList gl = new GroupList();
		gl.groupList();
	}*/
}

