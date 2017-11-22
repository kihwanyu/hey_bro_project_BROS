package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	private MainProcess main;
	private TestFrm testFrm;
	private JButton btnLogin;
	private JButton btnInit;
	private JButton btnIdPw;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;

	public static void main(String[] args) {
		//new LoginView();
		//400 200 800 500
	}

	public Login() {
		// setting
		setTitle("LOGIN");
		setSize(280, 150);
		setResizable(false);
		setBounds(400, 200, 800, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		// add
		add(panel);
		// visiible
		setVisible(true);
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
		passText.addActionListener(new ActionListener() {          
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();        
			}
		});

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
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
		
		btnIdPw = new JButton("ID/PWã��");
		btnIdPw.setBounds(365, 260, 115, 25);
		panel.add(btnIdPw);
		btnIdPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
	}

	public void isLoginCheck(){
		if(userText.getText().equals("test") && new String(passText.getPassword()).equals("1234")){
			JOptionPane.showMessageDialog(null, "Success");
			bLoginCheck = true;

			// �α��� �����̶�� �Ŵ���â ����
			if(isLogin()){
				main.showFrameTest(); // ����â �޼ҵ带 �̿��� â����
			}                  
		}else{
			JOptionPane.showMessageDialog(null, "...");
		}
	}

	// mainProcess�� ����
	public void setMain(MainProcess main) {
		this.main = main;
	}

	public boolean isLogin() {     
		return bLoginCheck;
	}
}