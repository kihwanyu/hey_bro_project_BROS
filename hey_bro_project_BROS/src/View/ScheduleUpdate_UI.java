package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ScheduleController;
import Model.vo.Schedule;
import Model.vo.Session;

public class ScheduleUpdate_UI extends JFrame{
	JPanel mp = new JPanel();

	static private ScheduleController c = new ScheduleController();
	static private Schedule s = new Schedule();
	private ArrayList<String> copyList = new ArrayList<>();
	private Session session;
	private String groupName;
	private String year;
	private String month;
	private String date;
	
	public ScheduleUpdate_UI(Session session, ArrayList<String> copyList, ArrayList<Schedule> tableList, int row, int column, String year, String month, String date, String groupName){
		this.copyList = copyList;
		this.session = session;
		this.year = year;
		this.month = month;
		this.date = date;
		this.groupName = groupName;
		String[] copy;
		String[] datez;

		copy= copyList.toString().split(", ");
		row+=1;
		int title = row*6-2;
		int contents = row*6-1;
		int startTime = row*6-4;
		int endTime = row*6-3;
		String[] start = copy[startTime].split(":");
		int startHour = Integer.parseInt(start[0]);
		int startMinit = Integer.parseInt(start[1]);

		String[] end = copy[endTime].split(":");
		int endHour = Integer.parseInt(end[0]);
		int endMinit = Integer.parseInt(end[1]);


		datez = tableList.toString().split(", ");
		String data = datez[row*8-5];
		String gName = datez[row*8-7];
		int number =Integer.parseInt(datez[row*8-8].replace("[",""));
		String[] ymd = datez[row*8-5].split("/");
		int year0 = Integer.parseInt(ymd[0]);
		int month0 = Integer.parseInt(ymd[1]);
		int date0 = Integer.parseInt(ymd[2]);
		System.out.println("이거다"+datez[row*8-8]);
		this.setBounds(100, 50, 800, 500);
		this.setLayout(null);
		mp.setSize(800, 500);
		mp.setLayout(null);
		//창 타이틀
		JLabel titleL = new JLabel("일정 수정");
		titleL.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
		titleL.setBounds(150, 30, 120, 50);

		
		JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/GS2840-1000x1000.png"));
		background.setLocation(0, 0);
		background.setSize(800, 500);
		mp.add(background);
		
		//일정(년/월/일).
		JComboBox<String> yearList = new JComboBox<>();
		JComboBox<String> monthList = new JComboBox<>();
		JComboBox<String> dateList = new JComboBox<>();
		int[] yearArr = new int[80];
		int[] monthArr = new int [12];
		int[] dateArr = new int [31];

		for(int i = 0; i < yearArr.length; i++){
			yearArr[i] = 1940+i;
			yearList.addItem(String.valueOf(yearArr[i]).toString());
		}
		for(int i = 0; i < monthArr.length; i++){
			monthArr[i] = 1+i;
			monthList.addItem(String.valueOf(monthArr[i]).toString());
		}

		for(int i = 0; i < 31; i++){
			dateArr[i] = 1+i;
			dateList.addItem(String.valueOf(dateArr[i]).toString());   
		}

		yearList.setLocation(450, 40);
		yearList.setSize(55,30);
		yearList.setSelectedIndex(year0-1940);
		
		monthList.setLocation(507, 40);
		monthList.setSize(40,30);
		monthList.setSelectedIndex(month0-1);
		
		dateList.setLocation(550, 40);
		dateList.setSize(40,30);
		dateList.setSelectedIndex(date0-1);
		
		//제목입력 라벨과 텍스트필드
		JLabel tftitle = new JLabel("제목 입력 : ");
		tftitle.setBounds(160, 90, 120, 30);
		JTextField titleTf = new JTextField();
		titleTf.setBounds(280, 90, 320, 30);
		titleTf.setText(copy[title]);

		//내용입력 라벨과 텍스트 필드
		JLabel contentsL = new JLabel("내용 입력");
		contentsL.setBounds(350, 130, 120, 30);
		JTextField contentsTf = new JTextField();
		contentsTf.setBounds(140, 170, 460, 200);
		contentsTf.setText(copy[contents]);

		//시작시간 라벨
		JLabel startL = new JLabel("시작 시간");
		startL.setBounds(160, 370, 120, 50);
		//시작 시간 과 분
		JComboBox<String> hourList1 = new JComboBox<>();
		int[] hour1 = new int[24];
		for(int i = 0; i < hour1.length; i++){
			hour1[i] = i;
			hourList1.addItem(String.valueOf(hour1[i]).toString());
		}
		hourList1.setSelectedIndex(startHour);
		hourList1.setLocation(230, 380);
		hourList1.setSize(50,30);

		JComboBox<String> miniteList1 = new JComboBox<>();
		int[] minite1 = new int[60];
		for(int i = 0; i < minite1.length; i++){
			minite1[i] = i;
			miniteList1.addItem(String.valueOf(minite1[i]).toString());
		}
		miniteList1.setSelectedIndex(startMinit);
		miniteList1.setLocation(290, 380);
		miniteList1.setSize(50,30);
		//종료시간 라벨
		JLabel endL = new JLabel("종료 시간");
		endL.setBounds(390, 370, 120,50);
		//일정 수정버튼
		JButton scheduleUpdate_bt = new JButton("일정 수정");
		scheduleUpdate_bt.setLocation(650, 100);
		scheduleUpdate_bt.setSize(100,30);
		
		String starttime = String.valueOf(hourList1.getSelectedIndex())+":"+String.valueOf(miniteList1.getSelectedIndex());
		

		//뒤로가기 버튼
		JButton return_bt = new JButton("뒤로가기");
		return_bt.setLocation(650, 30);
		return_bt.setSize(100,30);
		return_bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				listPage();
			}
			
		});
		//일정 수정버튼
		JButton scheduleDel_bt = new JButton("일정 삭제");
		scheduleDel_bt.setLocation(650, 170);
		scheduleDel_bt.setSize(100,30);
		//종료 시간 과 분
		JComboBox<String> hourList2 = new JComboBox<>();
		int[] hour2 = new int[24];
		for(int i = 0; i < hour2.length; i++){
			hour2[i] = i;
			hourList2.addItem(String.valueOf(hour2[i]).toString());
		}
		hourList2.setSelectedIndex(endHour);
		hourList2.setLocation(460, 380);
		hourList2.setSize(50,30);

		JComboBox<String> miniteList2 = new JComboBox<>();
		int[] minite2 = new int[60];
		for(int i = 0; i < minite2.length; i++){
			minite2[i] = i;
			miniteList2.addItem(String.valueOf(minite2[i]).toString());
		}
		miniteList2.setSelectedIndex(endMinit);
		miniteList2.setLocation(520, 380);
		miniteList2.setSize(50,30);

		String endtime = String.valueOf(hourList2.getSelectedIndex())+":"+String.valueOf(miniteList2.getSelectedIndex());
		//System.out.println("endtime:"+miniteList2.getSelectedIndex());
		this.add(mp);
		background.add(yearList);
		background.add(monthList);
		background.add(dateList);

		background.add(scheduleDel_bt);
		background.add(return_bt);
		background.add(scheduleUpdate_bt);
		background.add(miniteList1);
		background.add(hourList1);
		background.add(miniteList2);
		background.add(hourList2);
		background.add(contentsL);
		background.add(contentsTf);
		background.add(startL);
		
		background.add(endL);
		background.add(titleL);
		background.add(tftitle);
		background.add(titleTf);
		//
		
		scheduleDel_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				c.process("ScheduleDelete.do", number);
				JOptionPane.showMessageDialog(null, "일정이 삭제되었습니다.");
				listPage();	
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
		
		scheduleUpdate_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				s = new Schedule(number,gName, session.getUserId(),data,starttime,endtime,titleTf.getText(),contentsTf.getText().replace("]",""));
				
				c.process("ScheduleUpdate.do", s);
				JOptionPane.showMessageDialog(null, "일정 수정이 성공적으로 이루어졌습니다.");
				listPage();
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
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void listPage() {		
		this.setVisible(false);//현재 프레임의 비전을끄고
		
		new GroupListForMembers(session, year, month, date, groupName); //새로운 프레임을 만든다.
		
	}
	/*public static void main(String[] args) {
      ScheduleEdit s = new ScheduleEdit();
      s.scheduleEdit();

   }
	 */
}