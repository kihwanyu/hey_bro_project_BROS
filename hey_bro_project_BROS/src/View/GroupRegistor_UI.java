package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.Controller;
import Model.vo.Member;
import Model.vo.Session;

public class GroupRegistor_UI extends JPanel {
	private	static boolean loginBoolean = false; //27일 조성식 수정
	private JFrame superFrame; //수정
	private Controller c = new Controller();
	private Member m = new Member(); //수정
	private Session session; //수정
	//private JPanel mainPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4430678642605584542L;

	public GroupRegistor_UI(JFrame superFrame, JPanel panel, Session session /*JFrame superFrame, JPanel panel 수정*/){
		//	JFrame mf = new JFrame("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝占�");
		//
		
		m = c.process("MemberSatting.do", session); //수정
		this.session = session; //수정
		this.superFrame = superFrame; //수정
		this.setBounds(0, 0, 800, 500);
		this.setLayout(null);

		JPanel bgPanel = new JPanel();
		bgPanel.setSize(800, 500);
		bgPanel.setBackground(Color.white);

		//Group registration
		JLabel title = new JLabel("모임추가");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(316,10);
		title.setSize(300, 30);

		//Group Name
		JLabel gName = new JLabel("모임명");
		gName.setLocation(70,80);
		gName.setSize(200, 30);
		//�뜝�룞�삕�뜝�뙂紐뚯삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JTextField gntf = new JTextField(20);
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);



		//Group Interests
		JLabel glike = new JLabel("모임 관심사");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JTextField gltf = new JTextField(20);
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);

		//Input pw
		JLabel gPw = new JLabel("비밀번호 입력");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		//�뜝�룞�삕艅섇뜝�떕占� �뜝�뙃琉꾩삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JPasswordField gPwtf = new JPasswordField(20);
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);

		//Check pw
		JLabel regPw = new JLabel("비밀번호 재입력");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//�뜝�룞�삕艅섇뜝�떕占� �뜝�룞�삕 �뜝�뙃琉꾩삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JPasswordField regPwtf = new JPasswordField(20);
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);

		//Group Content
		JLabel content = new JLabel("모임 내용");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// �뜝�뙏�룞�삕�듃
		JTextField ctf = new JTextField(20);
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);

		//Notification
		JLabel news = new JLabel("공지사항");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//�뜝�뙏�룞�삕�듃
		JTextField newstf = new JTextField(20);
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);

		//Confirm button
		JButton btn = new JButton("확인");
		btn.setLocation(400,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));
		btn.setEnabled(false);
		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {

				if(gPwtf.getText().equals(regPwtf.getText())){

					c.process("GroupRegister.do", gntf.getText(), gltf.getText(), gPwtf.getText(), ctf.getText(), newstf.getText(), session.getUserId());
					JOptionPane.showMessageDialog(null, "그룹 생성이 완료되었습니다.", "title", JOptionPane.PLAIN_MESSAGE);
					//로그인 페이지로 이동
					main_UI(); //수정
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "title", JOptionPane.PLAIN_MESSAGE);
				}



			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
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

		});

		//조성식 수정
		gntf.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				loginBoolean = false;
				btn.setEnabled(false);				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		//Cancel Button
		JButton btn2 = new JButton("뒤로 가기");
		btn2.setLocation(250,400);
		btn2.setSize(100, 30);
		btn2.setBackground(new Color(5, 150, 255));
		btn2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				main_UI(); //수정

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
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

		});
		
		//조성식 수정
		JButton groupOverlab = new JButton("중복");
		groupOverlab.setBounds(350, 80, 60, 28);
		groupOverlab.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
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
				boolean result = c.process("MemberIdOverlap.do", gntf.getText());

				System.out.println(result);
				if(result){
					JOptionPane.showMessageDialog(null, "사용가능한 모임명 입니다.");
					//가입하기 버튼 활성화
					loginBoolean = true;
					btn.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "모임명이 중복 되었습니다.");
				}				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		regPwtf.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				loginBoolean = false;
				btn.setEnabled(false);				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		this.add(groupOverlab);
		this.add(title, "North");
		this.add(gName);
		this.add(gntf);
		this.add(glike);
		this.add(gltf);
		this.add(gPw);
		this.add(gPwtf);
		this.add(regPw);
		this.add(regPwtf);
		this.add(content);
		this.add(ctf);
		this.add(news);
		this.add(newstf);
		this.add(btn );
		this.add(btn2);
		this.add(bgPanel);
		//this.add(mainPanel);

		//mf.setVisible(true);
		//mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void loginPage() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Login_UI()); //새로운 프레임을 만든다.
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

