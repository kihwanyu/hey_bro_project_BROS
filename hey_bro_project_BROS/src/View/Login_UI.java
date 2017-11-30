package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Controller.MemberController;
import Model.vo.Session;

public class Login_UI extends JFrame{
	//
	/**
	 * 
	 */
	MemberController c = new MemberController();
	///세션역활을 해줄 세션 클래스
	Session session = new Session();

	private static final long serialVersionUID = 4965601877104326133L;
	private JPanel panel;
	private JButton btnLogin;
	private JButton btnInit;
	private JButton btnIdPw;
	private JPasswordField passText;
	private JTextField userText;
	//

	public Login_UI() {
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
		// setting
		this.setTitle("HEY~BRO");
		this.setResizable(false);
		this.setBounds(400, 200, 800, 500);
		panel = new JPanel();
		panel.setBounds(400, 200, 800, 500);

		this.placeLoginPanel(panel);

		this.add(panel);


		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void placeLoginPanel(JPanel panel){
		panel.setLayout(null); 
		JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/Starry Night Over the Rhone 2.jpg"));
		background.setBounds(0, 0, 800, 500);
		panel.add(background);


		JLabel userLabel = new JLabel("I    D");
		userLabel.setBounds(230, 190, 80, 25);
		background.add(userLabel);
		userLabel.setForeground(new Color(227, 237, 247));
		JLabel passLabel = new JLabel("P W");
		passLabel.setBounds(230, 220, 80, 25);
		background.add(passLabel);
		passLabel.setForeground(new Color(227, 237, 247));

		JLabel loginLabel = new JLabel("L  O  G  I  N");
		loginLabel.setBounds(340, 150, 100, 25);
		loginLabel.setForeground(new Color(227, 237, 247));
		loginLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
		background.add(loginLabel);

		userText = new JTextField(20);
		userText.setBounds(320, 190, 160, 25);
		panel.add(userText);
		passText = new JPasswordField(20);
		passText.setBounds(320, 220, 160, 25);
		panel.add(passText);


		btnInit = new JButton("회원가입");
		btnInit.setBounds(230, 260, 115, 25);
		background.add(btnInit);
		btnInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(490, 220, 100, 25);
		background.add(btnLogin);


		btnIdPw = new JButton("ID/PW찾기");
		btnIdPw.setBounds(365, 260, 115, 25);
		background.add(btnIdPw);

		clickEvent(btnInit,new MemberRegister_UI(this));
		clickEvent(btnIdPw,new FindMember_UI(this));
		userText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				userText.setText("");
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
		passText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				passText.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						passText.setText("");
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
		btnLogin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				/*String passwordStr = "";
				StringBuilder sb = new StringBuilder();

				char[] passwordChar = passText.getPassword();

				for(int i = 0; i < passwordChar.length; i++){
					sb.append(passwordChar[i]);
				}*/
				Boolean result = c.process("Login.do", userText.getText(), passText.getText());
				if(result){	
					//로그인 성공시 비밀번호와 패스워드를 세션으로 얻는다.
					session.setUserId(userText.getText());
					session.setUserPw(passText.getText());

					new Main_UI(session);
					frameSetVisible();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패 \n\"아이디와 비밀번호를 다시확인해주세요.\"");
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
	}	
	public void frameSetVisible(){
		this.setVisible(false);
	}
	public void clickEvent(JButton button, JPanel panel){
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				nextPage(panel);
				//panel을 새로고침 해준다.
				//간혹 GUI오류에 의해 나오지 않는 컴포넌트를 다시 띄워준다.
				panel.revalidate();
				panel.repaint();
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
	public void nextPage(JPanel loadPanel) {		
		this.remove(this.panel);//현재 패널 지우고
		//this.panel =  loadPanel; //2번 패널 객체를 담음
		this.add(loadPanel); //다시 패널을 올려줌
		this.repaint(); //다시 적용(갱신)
	}
}