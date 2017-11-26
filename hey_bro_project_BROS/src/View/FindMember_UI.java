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
import javax.swing.JTextField;

import Controller.Controller;

public class FindMember_UI extends JPanel{
	//

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082337671775367566L;

	Controller c = new Controller();
	private static JFrame superFrame;
	
	public FindMember_UI(){
		
		//JFrame mf = new JFrame();
		this.setBounds(0,0,800,500);
		JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/Starry Night Over the Rhone 22.jpg"));
		
		background.setBounds(0, 0, 796, 530);
		this.add(background);
		
		//panel1 : 아이디 찾기
		//JPanel pan1 = new JPanel();
		this.setLayout(null);
				
		JLabel lb1 = new JLabel("아이디 찾기");
		lb1.setLocation(155, 50);
		lb1.setSize(300,50);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		lb1.setOpaque(false);
		
		JTextField text = new JTextField(15);
		text.setLocation(100, 150);
		text.setSize(250, 30);
		text.setText("이 름");
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
		text2.setText("생 년 월 일");
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
		text3.setText("이 메 일  주 소");
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
		JLabel lb2 = new JLabel("비밀번호  찾기");
		lb2.setLocation(490, 50);
		lb2.setSize(200,50);
		lb2.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		lb2.setOpaque(false);
	
		this.add(lb2);
				
		JTextField text4 = new JTextField(15);
		text4.setLocation(440, 150);
		text4.setSize(250, 30);
		text4.setText("아 이 디");
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
		text5.setText("생 년 월 일");
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
		text6.setText("이 메 일  주 소");
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
		
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/Button-Back-2-512.png").getImage().getScaledInstance(40, 40, 0);
	      JLabel back = new JLabel(new ImageIcon(icon));
	      back.setBounds(10, 390, 50, 50);
	      background.add(back);
	      back.setOpaque(false);
	      
	      back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
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
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				new Login_UI();
				
			}
	    	  
	      });
		
	}
	
	

}
