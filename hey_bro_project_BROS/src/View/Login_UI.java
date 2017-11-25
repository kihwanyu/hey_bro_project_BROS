package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Model.vo.Session;
import sun.security.util.Password;

public class Login_UI extends JFrame{
	/**
	 * 
	 */
	Controller c = new Controller();
	//���ǿ�Ȱ�� ���� ���� Ŭ����
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
	

		btnInit = new JButton("ȸ������");
		btnInit.setBounds(230, 260, 115, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});

		btnLogin = new JButton("�α���");
		btnLogin.setBounds(490, 220, 100, 25);
		panel.add(btnLogin);
	
		
		btnIdPw = new JButton("ID/PWã��");
		btnIdPw.setBounds(365, 260, 115, 25);
		panel.add(btnIdPw);
		
		clickEvent(btnInit,new MemberRegister_UI(this));
		clickEvent(btnIdPw,new SearchIDPW_UI());
		
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
					//�α��� ������ ��й�ȣ�� �н����带 �������� ��´�.
					session.setUserId(userText.getText());
					session.setUserPw(passText.getText());
					
					new Main_UI(session);
					frameSetVisible();
				} else {
					JOptionPane.showMessageDialog(null, "�α��� ���� \n\"���̵�� ��й�ȣ�� �ٽ�Ȯ�����ּ���.\"");
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
				//panel�� ���ΰ�ħ ���ش�.
				//��Ȥ GUI������ ���� ������ �ʴ� ������Ʈ�� �ٽ� ����ش�.
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
		this.remove(this.panel);//���� �г� �����
		//this.panel =  loadPanel; //2�� �г� ��ü�� ����
		this.add(loadPanel); //�ٽ� �г��� �÷���
		this.repaint(); //�ٽ� ����(����)
	}
}