package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
		
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/maxresdefault.jpg").getImage().getScaledInstance(796, 530, 0);
		JLabel background=new JLabel(new ImageIcon(icon));
		background.setBounds(0, 0, 796, 530);
		this.add(background);
		
		JPanel bgPanel = new JPanel();
		bgPanel.setSize(800, 500);
		bgPanel.setOpaque(false);
		
		//Group registration
		JLabel title = new JLabel("모임추가");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(316,25);
		title.setSize(300, 30);
		
		//Group Name
		JLabel gName = new JLabel("모 임 명");
		gName.setLocation(70,80);
		gName.setSize(200, 30);
		//�뜝�룞�삕�뜝�뙂紐뚯삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JTextField gntf = new JTextField(20);
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		
		
		
		//Group Interests
		JLabel glike = new JLabel("모 임  관 심 사");
		glike.setLocation(440,80);
		glike.setSize(200, 30);
		// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JTextField gltf = new JTextField(20);
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);
		
		//Input pw
		JLabel gPw = new JLabel("비 밀 번 호  ");
		gPw.setLocation(60,120);
		gPw.setSize(200, 30);
		//�뜝�룞�삕艅섇뜝�떕占� �뜝�뙃琉꾩삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JPasswordField gPwtf = new JPasswordField(20);
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);
		
		//Check pw
		JLabel regPw = new JLabel("비 밀 번 호  재 입 력");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//�뜝�룞�삕艅섇뜝�떕占� �뜝�룞�삕 �뜝�뙃琉꾩삕 �뜝�뙏�룞�삕�듃 �뜝�떗�벝�삕
		JPasswordField regPwtf = new JPasswordField(20);
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);
		
		//Group Content
		JLabel content = new JLabel("모 임  내 용");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// �뜝�뙏�룞�삕�듃
		JTextField ctf = new JTextField(20);
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);
		
		//Notification
		JLabel news = new JLabel("공 지 사 항");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//�뜝�뙏�룞�삕�듃
		JTextField newstf = new JTextField(20);
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);
		
		//Confirm button
		JButton btn = new JButton("확 인");
		btn.setLocation(400,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));

		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(gPwtf.getText().equals(regPwtf.getText())){
					
					
				}
				
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				c.process("GroupRegister.do", gntf.getText(), gltf.getText(), gPwtf.getText(), ctf.getText(), newstf.getText(), session.getUserId());
				JOptionPane.showMessageDialog(null, "그룹 생성이 완료되었습니다.", "title", JOptionPane.PLAIN_MESSAGE);
				//로그인 페이지로 이동
				main_UI(); //수정
				
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
		
		//Cancel Button
		JButton btn2 = new JButton("뒤로 가기");
		btn2.setLocation(250,400);
		btn2.setSize(100, 30);
		btn2.setBackground(new Color(5, 150, 255));
		btn2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				main_UI(); //수정
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
		
		
		background.add(title, "North");
		background.add(gName);
		background.add(gntf);
		background.add(glike);
		background.add(gltf);
		background.add(gPw);
		background.add(gPwtf);
		background.add(regPw);
		background.add(regPwtf);
		background.add(content);
		background.add(ctf);
		background.add(news);
		background.add(newstf);
		background.add(btn );
		background.add(btn2);
		background.add(bgPanel);
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

