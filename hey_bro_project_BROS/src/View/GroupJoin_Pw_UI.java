package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;

public class GroupJoin_Pw_UI extends JFrame {
	/**
	 * 
	 */
	Controller c = new Controller();
	private JFrame superFrame;
	private JFrame present;
	private String groupSession;
	private static final long serialVersionUID = 5827244684650823215L;

	public GroupJoin_Pw_UI(JFrame superFrame, String groupSession){
		this.groupSession = groupSession;
		this.superFrame = superFrame;
		this.present = this;
		//JFrame mf = new JFrame("���� ����");
		this.setTitle("���� ����");
		this.setBounds(300, 100, 500, 300);
		this.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(500, 300);
		mainPanel.setBackground(Color.white);
		
		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.yellow);
		subPanel.setLocation(142,8);
		subPanel.setSize(200, 35);
		
		//â �̸�
		JLabel title = new JLabel("GROUP NAME");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(145,10);
		title.setSize(300, 30);

		//���Ӹ�˻� ��
		JLabel gPw = new JLabel("PASSWORD : ");
		gPw.setLocation(40,80);
		gPw.setSize(200, 30);
		//���Ӹ�˻� �ؽ�Ʈ �ʵ�
		JTextField gPwtf = new JTextField(20);
		gPwtf.setLocation(130, 80);
		gPwtf.setSize(200, 30);

		//������ư
		JButton btn1 = new JButton("��������");
		btn1.setLocation(340,80);
		btn1.setSize(100, 29);
		btn1.setBackground(new Color(5, 150, 255));
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean result = c.process("groupJoin.do", gPwtf.getText(), groupSession);
				//System.out.println(gPwtf.getText());
				//System.out.println(groupSession);
				if(result){
				new User_Celendar_UI(present, groupSession);
				frameSetVisible();		
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �����ʽ��ϴ�.");
				}		
			}
			
		});

		//�ڷΰ��� ��ư
		JButton btn2 = new JButton("�ڷΰ���");
		btn2.setLocation(195,180);
		btn2.setSize(100, 29);
		btn2.setBackground(new Color(5, 150, 255));
		
		this.add(title);
		this.add(gPw);
		this.add(gPwtf);
		this.add(btn1);
		this.add(btn2);
		this.add(subPanel);
		this.add(mainPanel);
			
		this.setVisible(true);
		btn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				superFrame.setVisible(true);
				frameSetVisible();
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
}
