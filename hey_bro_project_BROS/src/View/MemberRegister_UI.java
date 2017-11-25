package View;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;

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

import Controller.Controller;

public class MemberRegister_UI extends JPanel {
	/**
	 * 
	 */

	private Controller c = new Controller();
	private	static boolean loginBoolean = false;
	private static JFrame superFrame;
	private static String pictureUrl = null;
	private static JLabel userIng_lb;
	private static String gender_text = "남"; // 디폴트 인자
	
	private static final long serialVersionUID = -753271555181998155L;

	public MemberRegister_UI(JFrame superFrame){
		this.superFrame = superFrame;
		
		final int MEMBER_LIBEL_LOCATION_X = 80;
		final int MEMBER_TEXT_LOCATION_X = MEMBER_LIBEL_LOCATION_X+110; 
		
		String defaltImgUrl = "hey_bro_project_BROS/src/Model/Data/img/dog.jpg";
		
		JPanel title_p = new JPanel();
		
		this.setLayout(null);
		this.setLocation(0, 0);

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
		JLabel email_lb = new JLabel("E-Mail : ");
		email_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 290);
		email_lb.setSize(150,50);
		
		Image userIng_img = new ImageIcon(defaltImgUrl).getImage().getScaledInstance(200, 200, 0);
		userIng_lb = new JLabel();
		
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
		register_bt.setEnabled(false);
		JButton deleteAll_bt = new JButton("다시 쓰기");
		deleteAll_bt.setLocation(MEMBER_TEXT_LOCATION_X+50, 350);
		deleteAll_bt.setSize(150,40);
		//아이디
		JTextField id_text = new JTextField(10);
		id_text.setText("아이디를 입력해주세요.");
		id_text.setLocation(MEMBER_TEXT_LOCATION_X, 60);
		id_text.setSize(150,30);
		//비밀번호
		JPasswordField pw_text1 = new JPasswordField(10);
		pw_text1.setText("비밀번호를 입력해주세요.");
		pw_text1.setLocation(MEMBER_TEXT_LOCATION_X, 100);
		pw_text1.setSize(150,30);
		//비밀번호 재입력
		JPasswordField pw_text2 = new JPasswordField(10);
		pw_text2.setText("비밀번호를 입력해주세요.");
		pw_text2.setLocation(MEMBER_TEXT_LOCATION_X, 140);
		pw_text2.setSize(150,30);
		JTextField name_text = new JTextField(10);
		//이름
		name_text.setText("이름을 입력해주세요.");
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
		
		yearList.setSelectedIndex(0); 
		yearList.setLocation(MEMBER_TEXT_LOCATION_X, 260);
		yearList.setSize(55,30);
		monthList.setSelectedIndex(0);
		monthList.setLocation(MEMBER_TEXT_LOCATION_X+62, 260);
		monthList.setSize(40,30);
		dateList.setLocation(MEMBER_TEXT_LOCATION_X+110, 260);
		dateList.setSize(40,30);
		//이메일.
		JTextField email_text = new JTextField(10);
		email_text.setText("이메일을 입력해주세요.");
		email_text.setLocation(MEMBER_TEXT_LOCATION_X, 300);
		email_text.setSize(150,30);
		
		//성별.
		JRadioButton man = new JRadioButton("남");
		man.setLocation(MEMBER_TEXT_LOCATION_X+10, 180);
		man.setSize(90,30);
		JRadioButton woman = new JRadioButton("여");
		woman.setLocation(MEMBER_TEXT_LOCATION_X+100, 180);
		woman.setSize(90,30);
		ButtonGroup gender = new ButtonGroup();
		
		gender.add(man);
		gender.add(woman);
		
		this.setBounds(0,0,800,500);
		this.add(title_p,"North");
		
		title_p.add(title_lb);
		
		this.add(id_lb);
		this.add(overlap_bt);
		this.add(id_text);
		this.add(pw_lb1);
		this.add(pw_text1);
		this.add(pw_lb2);
		this.add(pw_text2);
		this.add(name_text);
		this.add(name_lb);
		this.add(man);
		this.add(woman);
		this.add(birthday_lb);
		this.add(yearList);
		this.add(monthList);
		
		this.add(email_lb);
		this.add(email_text);
		this.add(userIng_lb);
		this.add(imageOpen_Bt);
		this.add(register_bt);
		this.add(deleteAll_bt);
		this.add(dateList);
		
		textDelete(id_text);
		textDelete(pw_text1);
		textDelete(pw_text2);
		textDelete(name_text);
		textDelete(email_text);
		
		birthdayComboList(monthList , yearList, monthList, dateList, date);
		birthdayComboList(yearList , yearList, monthList, dateList, date);
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
		//아이디텍스트 이벤트 - 중복검사후 다시 아아디를 바꾸려고하면 가입하기 버튼이 비활성화
		id_text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				loginBoolean = false;
				register_bt.setEnabled(false);
			}
		});
		//중복검사 버튼 이벤트
		overlap_bt.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				boolean result = c.process("MemberIdOverlap.do", id_text.getText());
				
				System.out.println(result);
				if(result){
					 JOptionPane.showMessageDialog(null, "사용가능한 아아디 입니다.");
					 //가입하기 버튼 활성화
					 loginBoolean = true;
					 register_bt.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "아이디가 중복 되었습니다.");
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
		register_bt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
				String month_text;
				String date_text;
				if(loginBoolean){
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
							
					if(pw_text1.getText().equals(pw_text2.getText())){
						c.process("MemberRegister.do", id_text.getText(), pw_text1.getText(), name_text.getText(), gender_text, birthday, email_text.getText(), pictureUrl);
						JOptionPane.showMessageDialog(null, "회원가입이 성공적으로 이루어졌습니다.");
						//로그인 페이지로 이동
						loginPage();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가  일치 하지 않습니다.\n다시입력해주세요.");
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		//모든 텍스트 박스의 문자열을 초기값으로 바꾸어준다.
		deleteAll_bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id_text.setText("아이디를 입력해주세요.");
				pw_text1.setText("비밀번호를 입력해주세요.");
				pw_text2.setText("비밀번호를 입력해주세요.");
				name_text.setText("이름을 입력해주세요.");
				gender.clearSelection();					
				yearList.setSelectedIndex(0);
				monthList.setSelectedIndex(0);;
				dateList.setSelectedIndex(0);
				
				email_text.setText("이메일을 입력해주세요.");				
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
				//System.out.println(Integer.parseInt(monthList.getItemAt(monthList.getSelectedIndex())));
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
	public void loginPage() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Login_UI()); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}
		
	}
}
	