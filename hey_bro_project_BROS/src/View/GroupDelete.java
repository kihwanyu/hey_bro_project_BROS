package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Model.vo.Session;

public class GroupDelete extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -956000051309938863L;

	private Session session = new Session();
	public GroupDelete(Session session) {
		//JFrame mf = new JFrame();
		// �������� ����� ���մϴ�.
		Dimension frameSize = this.getSize();
		// �� ������� ũ�⸦ ���մϴ�.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * �׷��� �������� ��ġ��
		 * (�����ȭ�� ���� - ������ȭ�� ����) / 2,
		 * (�����ȭ�� ���� - ������ȭ�� ����) / 2 �̷��� �����Ѵ�.
		 */
		this.setLocation((screenSize.width - frameSize.width)/4, (screenSize.height - frameSize.height)/4);
		this.session = session;

		this.setSize(800, 500);
		this.setLayout(null);
		this.setTitle("Hey~bro");
		this.setResizable(false);

		//


		//�����г�
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);



		//문구 ?���?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/delete.PNG").getImage().getScaledInstance(612, 358, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(100, 70, 612, 358);

		//?��?��버튼
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/delete_bt.PNG").getImage().getScaledInstance(100, 39, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(350, 375, 100, 39);

		//?��?�� 체크
		JRadioButton check = new JRadioButton();
		check.setBackground(null);
		check.setBounds(280, 345, 20, 20);

		//��ư �ڷΰ��� �絵�ϱ�
		Image backI = new ImageIcon("hey_bro_project_BROS/src/View/img/back.PNG").getImage().getScaledInstance(110, 44, 0);
		JButton back = new JButton(new ImageIcon(backI));
		back.setBounds(660, 15, 110, 39);

		this.add(back);
		this.add(check);
		this.add(label2);
		this.add(label);
		this.add(bg);

		back.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Group_Calendar_UI(session);				
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

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*public static void main(String[] args){
		new GroupDelete();
	}*/
}
