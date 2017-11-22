package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MemberRegister_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -753271555181998155L;

	public MemberRegister_UI(){
		final int MEMBER_LIBEL_LOCATION_X = 80;
		final int MEMBER_TEXT_LOCATION_X = 190; 
		
		JFrame fr = new JFrame("회원가입");
		JPanel title_p = new JPanel();
		JPanel panel_m = new JPanel();
		panel_m.setLayout(null);
		panel_m.setLocation(0, 0);
		
		JLabel title_lb = new JLabel("회원가입");
		
		JLabel id_lb = new JLabel("아이디 : \n");
		id_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 50);
		id_lb.setSize(150,50);
		JLabel pw_lb1 = new JLabel("비밀번호 : \n");
		pw_lb1.setLocation(MEMBER_LIBEL_LOCATION_X, 90);
		pw_lb1.setSize(150,50);
		JLabel pw_lb2 = new JLabel("비밀번호 재입력 : \n");
		pw_lb2.setLocation(MEMBER_LIBEL_LOCATION_X, 130);
		pw_lb2.setSize(150,50);
		JLabel name_lb = new JLabel("이름 : \n");
		name_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 210);
		name_lb.setSize(150,50);
		JLabel birthday_lb = new JLabel("생년월일 : \n");
		birthday_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 250);
		birthday_lb.setSize(150,50);
		JLabel email_lb = new JLabel("E-Mail");
		email_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 290);
		email_lb.setSize(150,50);
		
		Image userIng_img = new ImageIcon("hey_bro_project_BROS/src/Model/Data/img/dog.jpg").getImage().getScaledInstance(200, 200, 0);

		JLabel userIng_lb = new JLabel();
		
		userIng_lb.setIcon(new ImageIcon(userIng_img));
		userIng_lb.setLocation(MEMBER_LIBEL_LOCATION_X+400, 10);	
		userIng_lb.setSize(300,300);
		
		JButton overlap_bt = new JButton("중복검사"); 
		overlap_bt.setLocation(MEMBER_TEXT_LOCATION_X+160, 59);
		overlap_bt.setSize(90,30);
		JButton imageOpen_Bt = new JButton("이미지 가져오기");
		imageOpen_Bt.setLocation(MEMBER_TEXT_LOCATION_X+320, 285);
		imageOpen_Bt.setSize(150,40);
		JButton register_bt = new JButton("가입 하기");
		register_bt.setLocation(MEMBER_TEXT_LOCATION_X+215, 350);
		register_bt.setSize(150,40);
		JButton deleteAll_bt = new JButton("다시 쓰기");
		deleteAll_bt.setLocation(MEMBER_TEXT_LOCATION_X+50, 350);
		deleteAll_bt.setSize(150,40);
		
		JTextField id_text = new JTextField(10);
		id_text.setLocation(MEMBER_TEXT_LOCATION_X, 60);
		id_text.setSize(150,30);
		JTextField pw_text1 = new JTextField(10);
		pw_text1.setLocation(MEMBER_TEXT_LOCATION_X, 100);
		pw_text1.setSize(150,30);
		JTextField pw_text2 = new JTextField(10);
		pw_text2.setLocation(MEMBER_TEXT_LOCATION_X, 140);
		pw_text2.setSize(150,30);
		JTextField name_text = new JTextField(10);
		name_text.setLocation(MEMBER_TEXT_LOCATION_X, 220);
		name_text.setSize(150,30);
		JComboBox<String> yearList = new JComboBox<>();
		JComboBox<String> monthList = new JComboBox<>();
		JComboBox<String> dateList = new JComboBox<>();
		int[] year = new int[80];
		int[] month = new int [12];
		int[] date = new int [31];
		
		for(int i = 0; i < year.length; i++){
			year[i] = 1940+i;
			yearList.addItem(String.valueOf(year[i]).toString());
		}
		for(int i = 0; i < month.length; i++){
			month[i] = 1+i;
			monthList.addItem(String.valueOf(month[i]).toString());
		}
		
		for(int i = 0; i < 31; i++){
			date[i] = 1+i;
			dateList.addItem(String.valueOf(date[i]).toString());	
		}
		
		yearList.setSelectedIndex(0); 
		yearList.setLocation(MEMBER_TEXT_LOCATION_X, 260);
		yearList.setSize(55,30);
		monthList.setSelectedIndex(0);
		monthList.setLocation(MEMBER_TEXT_LOCATION_X+62, 260);
		monthList.setSize(40,30);
		dateList.setLocation(MEMBER_TEXT_LOCATION_X+110, 260);
		dateList.setSize(40,30);
		
		JTextField email_text = new JTextField(10);
		email_text.setLocation(MEMBER_TEXT_LOCATION_X, 300);
		email_text.setSize(150,30);
		
		JRadioButton man = new JRadioButton("남");
		man.setLocation(MEMBER_TEXT_LOCATION_X+10, 180);
		man.setSize(90,30);
		JRadioButton woman = new JRadioButton("여");
		woman.setLocation(MEMBER_TEXT_LOCATION_X+100, 180);
		woman.setSize(90,30);
		ButtonGroup gender = new ButtonGroup();
		
		gender.add(man);
		gender.add(woman);
		
		fr.setBounds(400,200,800,500);
		fr.add(title_p,"North");
		fr.add(panel_m);
		
		title_p.add(title_lb);
		panel_m.add(id_lb);
		panel_m.add(overlap_bt);
		panel_m.add(id_text);
		panel_m.add(pw_lb1);
		panel_m.add(pw_text1);
		panel_m.add(pw_lb2);
		panel_m.add(pw_text2);
		panel_m.add(name_text);
		panel_m.add(name_lb);
		panel_m.add(man);
		panel_m.add(woman);
		panel_m.add(birthday_lb);
		panel_m.add(yearList);
		panel_m.add(monthList);
		
		panel_m.add(email_lb);
		panel_m.add(email_text);
		panel_m.add(userIng_lb);
		panel_m.add(imageOpen_Bt);
		panel_m.add(register_bt);
		panel_m.add(deleteAll_bt);
		panel_m.add(dateList);
		
		yearList.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				dateList.removeAllItems();
				System.out.println(Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex())));
				int year = Integer.parseInt(yearList.getItemAt(yearList.getSelectedIndex()));
				int month = Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex()));
				 if((0 == (year % 4) && 0 != (year %100)) || 0 == year%400) {
					if(month==2) {
						for(int i = 0; i < 29; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
					else if(month==4||month==6||month==9||month==11){
						for(int i = 0; i < 30; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
					else {
						for(int i = 0; i < 31; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
				}
				else if(month==2){
					for(int i = 0; i < 28; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
				else if(month==4||month==6||month==9||month==11){
					for(int i = 0; i < 30; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
				else {
					for(int i = 0; i < 31; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
			}
		});
		monthList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				dateList.removeAllItems();
				System.out.println(Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex())));
				int year = Integer.parseInt(yearList.getItemAt(yearList.getSelectedIndex()));
				int month = Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex()));
				 if((0 == (year % 4) && 0 != (year %100)) || 0 == year%400) {
					if(month==2) {
						for(int i = 0; i < 29; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
					else if(month==4||month==6||month==9||month==11){
						for(int i = 0; i < 30; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
					else {
						for(int i = 0; i < 31; i++){
							date[i] = 1+i;
							dateList.addItem(String.valueOf(date[i]).toString());	
						}
					}
				}
				else if(month==2){
					for(int i = 0; i < 28; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
				else if(month==4||month==6||month==9||month==11){
					for(int i = 0; i < 30; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
				else {
					for(int i = 0; i < 31; i++){
						date[i] = 1+i;
						dateList.addItem(String.valueOf(date[i]).toString());	
					}
				}
			}
		});
		deleteAll_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id_text.setText("");
				pw_text1.setText("");
				pw_text2.setText("");
				name_text.setText("");
				gender.clearSelection();					
				yearList.setSelectedIndex(0);
				monthList.setSelectedIndex(0);;
				dateList.setSelectedIndex(0);
				
				email_text.setText("");				
			}
		});
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
	