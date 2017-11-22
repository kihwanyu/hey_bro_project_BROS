package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchIDPW_UI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082337671775367566L;

	public SearchIDPW_UI(){
		
		//JFrame mf = new JFrame();
		this.setBounds(0,0,800,500);
	
		
		//panel1 : 아이디 찾기
		//JPanel pan1 = new JPanel();
		this.setLayout(null);
				
		JLabel lb1 = new JLabel("아이디 찾기");
		lb1.setLocation(170, 50);
		lb1.setSize(300,50);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		
		JTextField text = new JTextField(15);
		text.setLocation(100, 150);
		text.setSize(250, 30);
		text.setText("이름");
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
		text2.setText("생년월일");
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
		text3.setText("이메일 주소");
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
		
		this.add(text);
		this.add(text2);
		this.add(lb1);
		this.add(text3);
		this.add(idBtn);
		
		
		//panel2 찾기
		
		//JPanel pan2 = new JPanel();
		this.setLayout(null);
		//this.setBackground(Color.PINK);
		JLabel lb2 = new JLabel("비밀번호 찾기");
		lb2.setLocation(480, 50);
		lb2.setSize(200,50);
		lb2.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
				
		this.add(lb2);
				
		JTextField text4 = new JTextField(15);
		text4.setLocation(440, 150);
		text4.setSize(250, 30);
		text4.setText("아이디");
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
		text5.setText("생년월일");
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
		text6.setText("이메일 주소");
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
		
		//패널에 컴포넌트 담기
		
		this.add(text4);
		this.add(text5);
		this.add(lb2);
		this.add(text6);
		this.add(pwBtn);
		
		//메인 프레임 담기

		
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
