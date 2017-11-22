package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_UI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4965601877104326133L;
	private JPanel panel;
	private JButton btnLogin;
	private JButton btnInit;
	private JButton btnIdPw;
	private JPasswordField passText;
	private JTextField userText;
	//

	public Login_UI() {
		// setting
		this.setTitle("LOGIN");
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
		
		JLabel userLabel = new JLabel("ID");
		userLabel.setBounds(230, 190, 80, 25);
		panel.add(userLabel);
		JLabel passLabel = new JLabel("PW");
		passLabel.setBounds(230, 220, 80, 25);
		panel.add(passLabel);
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setBounds(345, 150, 80, 25);
		panel.add(loginLabel);
		
		userText = new JTextField(20);
		userText.setBounds(320, 190, 160, 25);
		panel.add(userText);
		passText = new JPasswordField(20);
		passText.setBounds(320, 220, 160, 25);
		panel.add(passText);
	

		btnInit = new JButton("회원가입");
		btnInit.setBounds(230, 260, 115, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(490, 220, 100, 25);
		panel.add(btnLogin);
	
		
		btnIdPw = new JButton("ID/PW찾기");
		btnIdPw.setBounds(365, 260, 115, 25);
		panel.add(btnIdPw);
		
		clickEvent(btnLogin,new Main_UI());
		clickEvent(btnInit,new MemberRegister_UI());
		clickEvent(btnIdPw,new SearchIDPW_UI());
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
		this.panel =  loadPanel; //2번 패널 객체를 담음
		this.add(panel); //다시 패널을 올려줌
		this.repaint(); //다시 적용(갱신)
	}
}