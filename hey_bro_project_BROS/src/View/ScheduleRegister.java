package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import Controller.ScheduleController;
import Model.vo.Session;

public class ScheduleRegister extends JFrame{
	/**
	 * 
	 */
	//
	private static final long serialVersionUID = 1438654689820281120L;
	private JPanel mp = new JPanel();
	private ScheduleController sc = new ScheduleController();
	private Session session = new Session();
	private String year;
	private String month;
	private String date;

	public ScheduleRegister(Session session, String year, String month, String date, String gName){
		this.session = session;
		this.year = year;
		this.month = month;
		this.date = date;
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * 그래서 프레임의 위치를
		 * (모니터화면 가로 - 프레임화면 가로) / 2,
		 * (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
		 */
		this.setLocation((screenSize.width - frameSize.width)/4, (screenSize.height - frameSize.height)/4);

		this.setSize(800, 500);
		this.setLayout(null);
		mp.setSize(800, 500);
		mp.setLayout(null);
		//창 타이틀
		JLabel titleL = new JLabel("일정 추가");
		titleL.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
		titleL.setBounds(150, 10, 120, 50);

		//제목입력 라벨과 텍스트필드
		JLabel tftitle = new JLabel("제목 입력 : ");
		tftitle.setBounds(160, 70, 120, 30);
		JTextField titleTf = new JTextField();
		titleTf.setBounds(280, 70, 320, 30);

		//내용입력 라벨과 텍스트 필드
		JLabel contentsL = new JLabel("내용 입력");
		contentsL.setBounds(350, 110, 120, 30);
		JTextField contentsTf = new JTextField();
		contentsTf.setBounds(140, 150, 460, 170);

		//시작시간 라벨
		JLabel startL = new JLabel("시작 시간");
		startL.setBounds(160, 350, 120, 50);
		//시작 시간 과 분
		JComboBox<String> hourList1 = new JComboBox<>();
		int[] hour1 = new int[24];
		for(int i = 0; i < hour1.length; i++){
			hour1[i] = 1+i;
			hourList1.addItem(String.valueOf(hour1[i]).toString());
		}
		hourList1.setLocation(230, 360);//
		hourList1.setSize(50,30);

		JComboBox<String> miniteList1 = new JComboBox<>();
		int[] minite1 = new int[59];
		for(int i = 0; i < minite1.length; i++){
			minite1[i] = 0+i;
			miniteList1.addItem(String.valueOf(minite1[i]).toString());
		}
		miniteList1.setLocation(290, 360);
		miniteList1.setSize(50, 30);
		//종료시간 라벨
		JLabel endL = new JLabel("종료 시간");
		endL.setBounds(390, 350, 120, 50);
		//종료 시간 과 분
		JComboBox<String> hourList2 = new JComboBox<>();
		int[] hour2 = new int[24];
		for(int i = 0; i < hour2.length; i++){
			hour2[i] = 1+i;
			hourList2.addItem(String.valueOf(hour2[i]).toString());
		}
		hourList2.setLocation(460, 360);
		hourList2.setSize(50,30);

		JComboBox<String> miniteList2 = new JComboBox<>();
		int[] minite2 = new int[59];
		for(int i = 0; i < minite2.length; i++){
			minite2[i] = 0+i;
			miniteList2.addItem(String.valueOf(minite2[i]).toString());
		}
		miniteList2.setLocation(520, 360);
		miniteList2.setSize(50,30);
		JButton scheduleRegister_bt = new JButton("일정 추가");
		scheduleRegister_bt.setLocation(650, 100);
		scheduleRegister_bt.setSize(100,30);
		scheduleRegister_bt.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				String startTime_h = (String) hourList1.getSelectedItem();
				String startTime_m = (String) miniteList1.getSelectedItem();
				String endTime_h = (String) hourList2.getSelectedItem();
				String endTime_m = (String) miniteList2.getSelectedItem();
				String yearStr = year;
				String monthStr = month;
				String dateStr = date;
				if(Integer.parseInt(startTime_h) < 10){
					startTime_h = "0" + startTime_h;
				}
				if(Integer.parseInt(startTime_m) < 10){
					startTime_m = "0" + startTime_m;
				}
				if(Integer.parseInt(endTime_h) < 10){
					endTime_h = "0" + endTime_h;
				}
				if(Integer.parseInt(endTime_m) < 10){
					endTime_m = "0" + endTime_m;
				}
				if(Integer.parseInt(year) < 10){
					yearStr = "0"+year;
				}
				if(Integer.parseInt(month) < 10){
					monthStr = "0"+month;
				}
				if(Integer.parseInt(date) < 10){
					dateStr = "0"+date;
				}
				sc.process("ScheduleRegister.do", gName, session.getUserId(), yearStr+"/"+monthStr+"/"+dateStr, startTime_h+":"+startTime_m, endTime_h+":"+endTime_m, titleTf.getText(),contentsTf.getText());
				JOptionPane.showMessageDialog(null, "일정이 추가되었습니다.", "title", JOptionPane.PLAIN_MESSAGE);
				new Leader_Calendar_UI(session, gName);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JButton return_bt = new JButton("뒤로가기");
		return_bt.setLocation(650, 30);
		return_bt.setSize(100,30);
		this.add(mp);

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
		mp.add(scheduleRegister_bt);
		mp.add(return_bt);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scheduleRegister_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
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
		return_bt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new GroupListForMembers(session, year, month, date, gName);
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
	}
	public void thisSetVisibleFalse(){
		this.setVisible(false);
	}

}