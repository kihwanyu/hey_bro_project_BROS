package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchIDPW_UI {

	public void searchIdPw(){
		
		JFrame mf = new JFrame();
		mf.setBounds(400,200,800,500);
	
		
		//panel1 : ���̵� ã��
		JPanel pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.setLocation(0, 0);
		pan1.setSize(400, 500);
		
				
		JLabel lb1 = new JLabel("���̵� ã��");
		lb1.setLocation(170, 50);
		lb1.setSize(300,50);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		
		
		JTextField text = new JTextField(15);
		text.setLocation(100, 150);
		text.setSize(250, 30);
		text.setText("�̸�");
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
		text2.setText("�������");
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
		text3.setText("�̸��� �ּ�");
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
		JButton idBtn = new JButton("���̵� ã��");
		idBtn.setLocation(100, 300);
		idBtn.setSize(250, 30);
		
		//�гο� ������Ʈ ���
		
		pan1.add(text);
		pan1.add(text2);
		pan1.add(lb1);
		pan1.add(text3);
		pan1.add(idBtn);
		
		
		//panel2 ã��
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(null);
		pan2.setLocation(400, 0);
		pan2.setSize(200, 500);
				
		JLabel lb2 = new JLabel("��й�ȣ ã��");
		lb2.setLocation(480, 50);
		lb2.setSize(200,50);
		lb2.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
				
		pan2.add(lb2);
				
		JTextField text4 = new JTextField(15);
		text4.setLocation(440, 150);
		text4.setSize(250, 30);
		text4.setText("���̵�");
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
		text5.setText("�������");
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
		text6.setText("�̸��� �ּ�");
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
		
				
		JButton pwBtn = new JButton("��й�ȣ ã��");
		pwBtn.setLocation(440, 300);
		pwBtn.setSize(250, 30);
		
		//�гο� ������Ʈ ���
		
		pan2.add(text4);
		pan2.add(text5);
		pan2.add(lb2);
		pan2.add(text6);
		pan2.add(pwBtn);
		
		//���� ������ ���
		
		mf.add(pan1);		
		mf.add(pan2);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
