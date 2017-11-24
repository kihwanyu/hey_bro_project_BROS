package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.vo.Session;

public class GroupRegistor_UI extends JPanel {
	//private JPanel mainPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4430678642605584542L;

	public GroupRegistor_UI(Session session){
	//	JFrame mf = new JFrame("占쏙옙占쏙옙 占쏙옙占쏙옙占�");
		//
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
		//占쏙옙占쌈몌옙 占쌔쏙옙트 占십듸옙
		JTextField gntf = new JTextField(20);
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		
		
		
		//Group Interests
		JLabel glike = new JLabel("모임 관심사 : ");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		// 占쏙옙占쏙옙占쏙옙 占쌔쏙옙트 占십듸옙
		JTextField gltf = new JTextField(20);
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);
		
		//Input pw
		JLabel gPw = new JLabel("비밀번호 입력 : ");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		//占쏙옙橘占싫� 占쌉뤄옙 占쌔쏙옙트 占십듸옙
		JPasswordField gPwtf = new JPasswordField(20);
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);
		
		//Check pw
		JLabel regPw = new JLabel("비밀번호 재입력 : ");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//占쏙옙橘占싫� 占쏙옙 占쌉뤄옙 占쌔쏙옙트 占십듸옙
		JPasswordField regPwtf = new JPasswordField(20);
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);
		
		//Group Content
		JLabel content = new JLabel("모임 내용");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// 占쌔쏙옙트
		JTextField ctf = new JTextField(20);
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);
		
		//Notification
		JLabel news = new JLabel("공지사항");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//占쌔쏙옙트
		JTextField newstf = new JTextField(20);
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);
		
		//Confirm button
		JButton btn = new JButton("확인");
		btn.setLocation(400,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));

		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			
				if(gPwtf.getPassword().equals(regPwtf.getPassword())){
					
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
		
		//Cancel Button
		JButton btn2 = new JButton("뒤로 가기");
		btn2.setLocation(250,400);
		btn2.setSize(100, 30);
		btn2.setBackground(new Color(5, 150, 255));
		btn2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				new	Main_UI(session);
				
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
	
}

