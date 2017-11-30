package View;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
	private Session session;
	private String groupName;
	private String year;
	private String month;
	private String date;
	public void scheduleEdit(Session session, ArrayList<String> copyList, ArrayList<Schedule> tableList, int row, int column, String year, String month, String date, String groupName){
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

		System.out.println("�̰Ŵ�"+datez[row*8-8]);
		this.setBounds(100, 50, 800, 500);
		this.setLayout(null);
		mp.setSize(800, 500);
		mp.setLayout(null);
		//â Ÿ��Ʋ
		JLabel titleL = new JLabel("���� ����");
		titleL.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
		titleL.setBounds(150, 30, 120, 50);

		//����(��/��/��).
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
		
		//�����Է� �󺧰� �ؽ�Ʈ�ʵ�
		JLabel tftitle = new JLabel("���� �Է� : ");
		tftitle.setBounds(160, 90, 120, 30);
		JTextField titleTf = new JTextField();
		titleTf.setBounds(280, 90, 320, 30);
		titleTf.setText(copy[title]);

		//�����Է� �󺧰� �ؽ�Ʈ �ʵ�
		JLabel contentsL = new JLabel("���� �Է�");
		contentsL.setBounds(350, 130, 120, 30);
		JTextField contentsTf = new JTextField();
		contentsTf.setBounds(140, 170, 460, 200);
		contentsTf.setText(copy[contents]);

		//���۽ð� ��
		JLabel startL = new JLabel("���� �ð�");
		startL.setBounds(160, 370, 120, 50);
		//���� �ð� �� ��
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
		//����ð� ��
		JLabel endL = new JLabel("���� �ð�");
		endL.setBounds(390, 370, 120,50);
		//���� ������ư
		JButton scheduleUpdate_bt = new JButton("���� ����");
		scheduleUpdate_bt.setLocation(650, 100);
		scheduleUpdate_bt.setSize(100,30);
		
		String starttime = String.valueOf(hourList1.getSelectedIndex())+":"+String.valueOf(miniteList1.getSelectedIndex());
		
		//�ڷΰ��� ��ư
		JButton return_bt = new JButton("�ڷΰ���");
		return_bt.setLocation(650, 30);
		return_bt.setSize(100,30);
		//���� ������ư
		JButton scheduleDel_bt = new JButton("���� ����");
		scheduleDel_bt.setLocation(650, 170);
		scheduleDel_bt.setSize(100,30);
		//���� �ð� �� ��
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
		mp.add(yearList);
		mp.add(monthList);
		mp.add(dateList);

		mp.add(scheduleDel_bt);
		mp.add(return_bt);
		mp.add(scheduleUpdate_bt);
		mp.add(miniteList1);
		mp.add(hourList1);
		mp.add(miniteList2);
		mp.add(hourList2);
		mp.add(contentsL);
		mp.add(contentsTf);
		mp.add(startL);
		mp.add(endL);
		mp.add(titleL);
		mp.add(tftitle);
		mp.add(titleTf);
		
		
		scheduleDel_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				c.process("ScheduleDelete.do", number);
				Listpage();	
				JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.");
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
				JOptionPane.showMessageDialog(null, "���� ������ ���������� �̷�������ϴ�.");
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
	public void Listpage() {		
		this.setVisible(false);//���� �������� ����������
		
		new GroupListForMembers(session, year, month, date, groupName); //���ο� �������� �����.
		
	}
	/*public static void main(String[] args) {
      ScheduleEdit s = new ScheduleEdit();
      s.scheduleEdit();

   }
	 */
}