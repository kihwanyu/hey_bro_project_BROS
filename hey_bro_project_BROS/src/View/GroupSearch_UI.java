package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GroupSearch_UI extends JFrame {
	/**
	 * 
	 */
	private JFrame superFrame; //����
	private JFrame present; //����

	private static final long serialVersionUID = -1823416224145672077L;

	public GroupSearch_UI(JFrame superFrame/*����*/){
		this.present = this;	//����
		this.superFrame = superFrame;	//����
		JFrame mf = new JFrame("���� �˻�");
		this.setBounds(600, 300, 500, 300);
		this.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setSize(500, 300);
		mainPanel.setBackground(Color.white);

		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.yellow);
		subPanel.setLocation(192,8);
		subPanel.setSize(100, 35);

		//â �̸�
		JLabel title = new JLabel("Search");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(195,10);
		title.setSize(300, 30);

		//���Ӹ�˻� ��
		JLabel gName = new JLabel("���Ӹ� : ");
		gName.setLocation(50,80);
		gName.setSize(200, 30);
		//���Ӹ�˻� �ؽ�Ʈ �ʵ�
		JTextField gntf = new JTextField(20);
		gntf.setLocation(120, 80);
		gntf.setSize(200, 30);

		//������ư
		JButton btn1 = new JButton("��������");
		btn1.setLocation(340,80);
		btn1.setSize(100, 29);
		btn1.setBackground(new Color(5, 150, 255));
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new User_Celendar_UI(present);
				frameSetVisible();				
			}
			
		});

		

		//�ڷΰ��� ��ư
		JButton btn2 = new JButton("�ڷΰ���");
		btn2.setLocation(195,180);
		btn2.setSize(100, 29);
		btn2.setBackground(new Color(5, 150, 255));
		

		this.add(title);
		this.add(gName);
		this.add(gntf);
		this.add(btn1);
		this.add(btn2);
		this.add(subPanel);
		this.add(mainPanel);


		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//����
		btn2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
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

			@Override
			public void mousePressed(MouseEvent e) {
				superFrame.setVisible(true);
				frameSetVisible();				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
	
	//����
	public void frameSetVisible(){
		this.setVisible(false);
	}
}
