package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.MemberController;

public class FindMember_UI extends JPanel{
	//

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082337671775367566L;

	MemberController c = new MemberController();
	private static JFrame superFrame;
	
	public FindMember_UI(JFrame superFrame){
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
		this.superFrame = superFrame;
		JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/Starry Night Over the Rhone 2.jpg"));
		background.setBounds(0, 0, 800, 500);
		this.add(background);
		
		//JFrame mf = new JFrame();
		this.setSize(800,500);
	
		
		//panel1 : 아이디 찾기
		//JPanel pan1 = new JPanel();
		this.setLayout(null);
				
		JLabel lb1 = new JLabel("아이디  찾기");
		lb1.setLocation(145, 50);
		lb1.setSize(300,50);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		lb1.setForeground(new Color(227, 237, 247));
		
		JTextField text = new JTextField(15);
		text.setLocation(100, 150);
		text.setSize(250, 30);
		text.setText(" 이 름");
		text.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text.setText("");
				
			}
		});
		
		JTextField text2 = new JTextField(15);
		text2.setLocation(100, 200);
		text2.setSize(250, 30);
		text2.setText(" 생 년 월 일");
		text2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text2.setText("");
				
			}
		});
		
		JTextField text3 = new JTextField(15);
		text3.setLocation(100, 250);
		text3.setSize(250, 30);
		text3.setText(" 이 메 일  주 소");
		text3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text3.setText("");
				
			}
		});
		JButton idBtn = new JButton("아이디 찾기");
		idBtn.setLocation(100, 300);
		idBtn.setSize(250, 30);
		
		//패널에 컴포넌트 담기 
		
		background.add(text);
		background.add(text2);
		background.add(lb1);
		background.add(text3);
		background.add(idBtn);
		
		
		//panel2 찾기
		
		//JPanel pan2 = new JPanel();
		this.setLayout(null);
		//this.setBackground(Color.PINK);
		JLabel lb2 = new JLabel("비밀번호 찾기");
		lb2.setLocation(480, 50);
		lb2.setSize(200,50);
		lb2.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		lb2.setForeground(new Color(227, 237, 247));
		
		this.add(lb2);
				
		JTextField text4 = new JTextField(15);
		text4.setLocation(440, 150);
		text4.setSize(250, 30);
		text4.setText(" 아 이 디");
		text4.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text4.setText("");
				
			}
		});
		
		JTextField text5 = new JTextField(15);
		text5.setLocation(440, 200);
		text5.setSize(250, 30);
		text5.setText(" 생 년 월 일");
		text5.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text5.setText("");
				
			}
		});
				
		JTextField text6 = new JTextField(15);
		text6.setLocation(440, 250);
		text6.setSize(250, 30);
		text6.setText(" 이 메 일  주 소");
		text6.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				text6.setText("");
				
			}
		});
		
				
		JButton pwBtn = new JButton("비밀번호 찾기");
		pwBtn.setLocation(440, 300);
		pwBtn.setSize(250, 30);
		
		JLabel back = new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/prevButton.png"));
		background.add(back);
		back.setBounds(20, 395, 45, 45);
		back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			 loginPage();
			 
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
		
		//패널에 컴포넌트 담기
		
		background.add(text4);
		background.add(text5);
		background.add(lb2);
		background.add(text6);
		background.add(pwBtn);
		
		//메인 프레임 담기

		
		idBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String str = c.process("FindIdMember.do", text.getText(), text2.getText(), text3.getText());
				JOptionPane.showMessageDialog(null, str);
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
		pwBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String str = c.process("FindPwMember.do", text4.getText(), text5.getText(), text6.getText());
				JOptionPane.showMessageDialog(null, str);			
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
	
	public void loginPage() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Login_UI()); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}
		
	}

}
