package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.MemberController;
import Model.vo.Member;
import Model.vo.Session;

public class MemberUpdate_UI extends JPanel {
	//

	/**
	 * 
	 */
	static private MemberController c = new MemberController();
	static private Member m = new Member();
	private static String pictureUrl = null;
	private static JLabel userIng_lb;
	private static String gender_text = "남"; // 디폴트 인자
	private static JFrame superFrame;
	private static Session session;
	private static final long serialVersionUID = 3878058214731925430L;
	
	public MemberUpdate_UI(JFrame superFrame, Session session){
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
		m = c.process("MemberSatting.do", session);
		
		this.session = session;
		String defaltImgUrl = m.getPictureUrl();
		
		this.superFrame = superFrame;
		
		final int MEMBER_LIBEL_LOCATION_X = 80;
		final int MEMBER_TEXT_LOCATION_X = MEMBER_LIBEL_LOCATION_X+110; 
		
		JLabel title_lb = new JLabel("회원 정보 수정");
		title_lb.setOpaque(false);
		 JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/maxresdefault (1).png"));
			background.setBounds(0, 0, 800, 500);
			this.add(background);
	      
	    
	      
	      
		JLabel id_lb = new JLabel("아 이 디  \n");
		id_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 50);
		id_lb.setSize(150,50);
		id_lb.setForeground(new Color(54, 58, 66));
		JLabel pw_lb1 = new JLabel("비 밀 번 호  \n");
		pw_lb1.setLocation(MEMBER_LIBEL_LOCATION_X, 90);
		pw_lb1.setSize(150,50);
		pw_lb1.setForeground(new Color(54, 58, 66));
		JLabel pw_lb2 = new JLabel("비 밀 번 호  확 인\n");
		pw_lb2.setLocation(MEMBER_LIBEL_LOCATION_X, 130);
		pw_lb2.setSize(150,50);
		pw_lb2.setForeground(new Color(54, 58, 66));
		JLabel name_lb = new JLabel("이       름  \n");
		name_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 210);
		name_lb.setSize(150,50);
		name_lb.setForeground(new Color(54, 58, 66));
		JLabel birthday_lb = new JLabel("생 년 월 일  \n");
		birthday_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 250);
		birthday_lb.setSize(150,50);
		birthday_lb.setForeground(new Color(54, 58, 66));
		JLabel email_lb = new JLabel("E - M a i l  ");
		email_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 290);
		email_lb.setSize(150,50);
		email_lb.setForeground(new Color(54, 58, 66));
		
		Image userIng_img = new ImageIcon(defaltImgUrl).getImage().getScaledInstance(200, 200, 0);
		userIng_lb = new JLabel();
		
		userIng_lb.setIcon(new ImageIcon(userIng_img));
		
		userIng_lb.setLocation(MEMBER_LIBEL_LOCATION_X+400, 10);	
		userIng_lb.setSize(300,300);
		
		JButton imageOpen_Bt = new JButton("이미지 가져오기");
		imageOpen_Bt.setLocation(MEMBER_TEXT_LOCATION_X+320, 285);
		imageOpen_Bt.setSize(150,40);
		JButton update_bt = new JButton("수정 하기");
		update_bt.setLocation(MEMBER_TEXT_LOCATION_X+270, 350);
		update_bt.setSize(150,40);
		JButton cancle_bt = new JButton("뒤로 가기");
		cancle_bt.setLocation(MEMBER_TEXT_LOCATION_X, 350);
		cancle_bt.setSize(150, 40);
		
		
		
		//아이디
		JTextField id_text = new JTextField(10);
		id_text.setText(m.getUserId());
		id_text.setLocation(MEMBER_TEXT_LOCATION_X, 60);
		id_text.setSize(150,30);
		id_text.setEditable(false);
		//비밀번호
		JPasswordField pw_text1 = new JPasswordField(10);
		pw_text1.setText(m.getUserPw());
		pw_text1.setLocation(MEMBER_TEXT_LOCATION_X, 100);
		pw_text1.setSize(150,30);
		//비밀번호 재입력
		JPasswordField pw_text2 = new JPasswordField(10);
		pw_text2.setText(m.getUserPw());
		pw_text2.setLocation(MEMBER_TEXT_LOCATION_X, 140);
		pw_text2.setSize(150,30);
		JTextField name_text = new JTextField(10);
		//이름
		name_text.setText(m.getUserName());
		name_text.setLocation(MEMBER_TEXT_LOCATION_X, 220);
		name_text.setSize(150,30);
		//생일(년/월/일).
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
		System.out.println(m.getBirthday());
		int user_year = Integer.parseInt(m.getBirthday().substring(0,4));
		System.out.println(user_year);
		int user_month = Integer.parseInt(m.getBirthday().substring(4,6));
		System.out.println(user_month);
		int user_date = Integer.parseInt(m.getBirthday().substring(6,8));
		System.out.println(user_date);
		
		yearList.setSelectedIndex(user_year-1940); 
		yearList.setLocation(MEMBER_TEXT_LOCATION_X, 260);
		yearList.setSize(55,30);
		monthList.setSelectedIndex(user_month-1);
		monthList.setLocation(MEMBER_TEXT_LOCATION_X+62, 260);
		monthList.setSize(40,30);
		dateList.setLocation(MEMBER_TEXT_LOCATION_X+110, 260);
		dateList.setSize(40,30);
		dateList.setSelectedIndex(user_date-1);
		//이메일.
		JTextField email_text = new JTextField(10);
		email_text.setText(m.getEmail());
		email_text.setLocation(MEMBER_TEXT_LOCATION_X, 300);
		email_text.setSize(150,30);
		
		//성별.
		JRadioButton man = new JRadioButton("남");
		man.setLocation(MEMBER_TEXT_LOCATION_X+10, 180);
		man.setSize(90,30);
		man.setOpaque(false);
		JRadioButton woman = new JRadioButton("여");
		woman.setLocation(MEMBER_TEXT_LOCATION_X+100, 180);
		woman.setSize(90,30);
		woman.setOpaque(false);
		ButtonGroup gender = new ButtonGroup();
		if(m.getGender().equals("남")){
			man.setSelected(true);
		} else {
			woman.setSelected(true);
		}
		
		gender.add(man);
		gender.add(woman);
		
		this.setBounds(0,0,800,500);

		
		background.add(title_lb);
		//this.add(background);
		background.add(id_lb);

		background.add(id_text);
		background.add(pw_lb1);
		background.add(pw_text1);
		background.add(pw_lb2);
		background.add(pw_text2);
		background.add(name_text);
		background.add(name_lb);
		background.add(man);
		background.add(woman);
		background.add(birthday_lb);
		background.add(yearList);
		background.add(monthList);
		
		background.add(email_lb);
		background.add(email_text);		
		background.add(userIng_lb);
		background.add(imageOpen_Bt);
		background.add(update_bt);
		background.add(cancle_bt);

		background.add(dateList);
		
		textDelete(id_text);
		textDelete(pw_text1);
		textDelete(pw_text2);
		textDelete(name_text);
		textDelete(email_text);
		
		birthdayComboList(monthList , yearList, monthList, dateList, date);
		birthdayComboList(yearList , yearList, monthList, dateList, date);
		
		this.setLayout(null);
		man.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_text = "남";
			}
		});
		woman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_text = "여";
			}
		});
		imageOpen_Bt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				pictureUrl = imgOpen();	
				
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
		update_bt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String month_text;
				String date_text;
				int monthCompareValue = Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex()));
				int dateCompareValue = Integer.parseInt(dateList.getItemAt(dateList.getSelectedIndex()));
				if(monthCompareValue < 10){
					month_text="0"+monthCompareValue;
				} else {
					month_text=String.valueOf(monthCompareValue).toString();
				}
				if(dateCompareValue < 10){
					date_text="0"+dateCompareValue;
				} else {
					date_text=String.valueOf(dateCompareValue).toString();
				}
				String birthday = yearList.getItemAt(yearList.getSelectedIndex()) 
									+ month_text + date_text;
						
				m = new Member(id_text.getText(), pw_text1.getText(), name_text.getText()
						, gender_text, birthday, email_text.getText(), pictureUrl);
				
				if(pw_text1.getText().equals(pw_text2.getText())){
					c.process("MemberUpdate.do", m);
					JOptionPane.showMessageDialog(null, "정보수정이 성공적으로 이루어졌습니다.");
					//로그인 페이지로 이동
					mainPage();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가  일치 하지 않습니다.\n다시입력해주세요.");
				}
				
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
	
		cancle_bt.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				main_UI();
				//메인으로
				
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
	}
	
	
	//text박스 클릭시 텍스트박스에 있는 문자열을 지워주는 메소드.
	public void textDelete(JTextField tf){
		tf.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				tf.setText("");				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				tf.setText("");
			}
		});
	}
	//윤년을 계산하여, 월에 대한 일을 List에 저장하는 메소드. 
	public void birthdayComboList(JComboBox<String> standard, JComboBox<String> yearList,
			 JComboBox<String> monthList, JComboBox<String> dateList, int[] date){
		standard.addItemListener(new ItemListener() {
			
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
	}
	public String imgOpen(){
		FileDialog fileOpen = new FileDialog(superFrame, "파일열기", FileDialog.LOAD);
		fileOpen.setDirectory("c:\\");
		fileOpen.setVisible(true);
		String fileDirectory = fileOpen.getDirectory() + fileOpen.getFile();
		if(fileOpen.getFile() == null) return fileDirectory;
		fileDirectory = fileDirectory.replaceAll("\\\\","\\\\\\\\");
		System.out.println(fileDirectory);
		// \는 \\\\로 입력해야한다. \\는 \\\\로 입력해야 오류가 발생하지않는다.
		// replaceAll("\\\\","\\\\\\\\")은 문자열 에서 "\"를 "\\"로 고친다.
		Image newImage = new ImageIcon(fileDirectory).getImage().getScaledInstance(200, 200, 0);
		userIng_lb.setIcon(new ImageIcon(newImage));
		 

		this.revalidate();
		this.repaint();
		return fileDirectory;
	}
	public void mainPage() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Main_UI(session)); //새로운 프레임을 만든다.
		} catch (Exception e) {
		}
		
	}
	
	public void main_UI() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Main_UI(session)); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}
		
	}
	
}
	