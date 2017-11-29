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
	private static String gender_text = "��"; // ����Ʈ ����
	private static JFrame superFrame;
	private static Session session;
	private static final long serialVersionUID = 3878058214731925430L;
	
	public MemberUpdate_UI(JFrame superFrame, Session session){
		// �������� ����� ���մϴ�.
				Dimension frameSize = this.getSize();
				// �� ������� ũ�⸦ ���մϴ�.
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				/*
				* �׷��� �������� ��ġ��
				* (�����ȭ�� ���� - ������ȭ�� ����) / 2,
				* (�����ȭ�� ���� - ������ȭ�� ����) / 2 �̷��� �����Ѵ�.
				*/
				this.setLocation((screenSize.width - frameSize.width)/4, (screenSize.height - frameSize.height)/4);
		m = c.process("MemberSatting.do", session);
		
		this.session = session;
		String defaltImgUrl = m.getPictureUrl();
		
		this.superFrame = superFrame;
		
		final int MEMBER_LIBEL_LOCATION_X = 80;
		final int MEMBER_TEXT_LOCATION_X = MEMBER_LIBEL_LOCATION_X+110; 
		
		JLabel title_lb = new JLabel("ȸ�� ���� ����");
		title_lb.setOpaque(false);
		 JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/maxresdefault (1).png"));
			background.setBounds(0, 0, 800, 500);
			this.add(background);
	      
	    
	      
	      
		JLabel id_lb = new JLabel("�� �� ��  \n");
		id_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 50);
		id_lb.setSize(150,50);
		id_lb.setForeground(new Color(54, 58, 66));
		JLabel pw_lb1 = new JLabel("�� �� �� ȣ  \n");
		pw_lb1.setLocation(MEMBER_LIBEL_LOCATION_X, 90);
		pw_lb1.setSize(150,50);
		pw_lb1.setForeground(new Color(54, 58, 66));
		JLabel pw_lb2 = new JLabel("�� �� �� ȣ  Ȯ ��\n");
		pw_lb2.setLocation(MEMBER_LIBEL_LOCATION_X, 130);
		pw_lb2.setSize(150,50);
		pw_lb2.setForeground(new Color(54, 58, 66));
		JLabel name_lb = new JLabel("��       ��  \n");
		name_lb.setLocation(MEMBER_LIBEL_LOCATION_X, 210);
		name_lb.setSize(150,50);
		name_lb.setForeground(new Color(54, 58, 66));
		JLabel birthday_lb = new JLabel("�� �� �� ��  \n");
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
		
		JButton imageOpen_Bt = new JButton("�̹��� ��������");
		imageOpen_Bt.setLocation(MEMBER_TEXT_LOCATION_X+320, 285);
		imageOpen_Bt.setSize(150,40);
		JButton update_bt = new JButton("���� �ϱ�");
		update_bt.setLocation(MEMBER_TEXT_LOCATION_X+270, 350);
		update_bt.setSize(150,40);
		JButton cancle_bt = new JButton("�ڷ� ����");
		cancle_bt.setLocation(MEMBER_TEXT_LOCATION_X, 350);
		cancle_bt.setSize(150, 40);
		
		
		
		//���̵�
		JTextField id_text = new JTextField(10);
		id_text.setText(m.getUserId());
		id_text.setLocation(MEMBER_TEXT_LOCATION_X, 60);
		id_text.setSize(150,30);
		id_text.setEditable(false);
		//��й�ȣ
		JPasswordField pw_text1 = new JPasswordField(10);
		pw_text1.setText(m.getUserPw());
		pw_text1.setLocation(MEMBER_TEXT_LOCATION_X, 100);
		pw_text1.setSize(150,30);
		//��й�ȣ ���Է�
		JPasswordField pw_text2 = new JPasswordField(10);
		pw_text2.setText(m.getUserPw());
		pw_text2.setLocation(MEMBER_TEXT_LOCATION_X, 140);
		pw_text2.setSize(150,30);
		JTextField name_text = new JTextField(10);
		//�̸�
		name_text.setText(m.getUserName());
		name_text.setLocation(MEMBER_TEXT_LOCATION_X, 220);
		name_text.setSize(150,30);
		//����(��/��/��).
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
		//�̸���.
		JTextField email_text = new JTextField(10);
		email_text.setText(m.getEmail());
		email_text.setLocation(MEMBER_TEXT_LOCATION_X, 300);
		email_text.setSize(150,30);
		
		//����.
		JRadioButton man = new JRadioButton("��");
		man.setLocation(MEMBER_TEXT_LOCATION_X+10, 180);
		man.setSize(90,30);
		man.setOpaque(false);
		JRadioButton woman = new JRadioButton("��");
		woman.setLocation(MEMBER_TEXT_LOCATION_X+100, 180);
		woman.setSize(90,30);
		woman.setOpaque(false);
		ButtonGroup gender = new ButtonGroup();
		if(m.getGender().equals("��")){
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
				gender_text = "��";
			}
		});
		woman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gender_text = "��";
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
					JOptionPane.showMessageDialog(null, "���������� ���������� �̷�������ϴ�.");
					//�α��� �������� �̵�
					mainPage();
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ��  ��ġ ���� �ʽ��ϴ�.\n�ٽ��Է����ּ���.");
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
				//��������
				
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
	
	
	//text�ڽ� Ŭ���� �ؽ�Ʈ�ڽ��� �ִ� ���ڿ��� �����ִ� �޼ҵ�.
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
	//������ ����Ͽ�, ���� ���� ���� List�� �����ϴ� �޼ҵ�. 
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
		FileDialog fileOpen = new FileDialog(superFrame, "���Ͽ���", FileDialog.LOAD);
		fileOpen.setDirectory("c:\\");
		fileOpen.setVisible(true);
		String fileDirectory = fileOpen.getDirectory() + fileOpen.getFile();
		if(fileOpen.getFile() == null) return fileDirectory;
		fileDirectory = fileDirectory.replaceAll("\\\\","\\\\\\\\");
		System.out.println(fileDirectory);
		// \�� \\\\�� �Է��ؾ��Ѵ�. \\�� \\\\�� �Է��ؾ� ������ �߻������ʴ´�.
		// replaceAll("\\\\","\\\\\\\\")�� ���ڿ� ���� "\"�� "\\"�� ��ģ��.
		Image newImage = new ImageIcon(fileDirectory).getImage().getScaledInstance(200, 200, 0);
		userIng_lb.setIcon(new ImageIcon(newImage));
		 

		this.revalidate();
		this.repaint();
		return fileDirectory;
	}
	public void mainPage() {		
		superFrame.setVisible(false);//���� �������� ����������
		try {
			superFrame.add(new Main_UI(session)); //���ο� �������� �����.
		} catch (Exception e) {
		}
		
	}
	
	public void main_UI() {		
		superFrame.setVisible(false);//���� �������� ����������
		try {
			superFrame.add(new Main_UI(session)); //���ο� �������� �����.
		} catch (Exception e) {

		}
		
	}
	
}
	