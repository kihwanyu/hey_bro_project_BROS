package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupUpdate_UI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1436779561881168592L;

	public GroupUpdate_UI(){
		JFrame mf = new JFrame("���� ����");
		
		mf.setBounds(400, 200, 800, 500);
		mf.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(800, 500);
		mainPanel.setBackground(Color.white);
		
		//â �̸�
		JLabel title = new JLabel("���Ӽ���");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(330,10);
		title.setSize(300, 30);
		
		//���Ӹ� ��
		JLabel gName = new JLabel("���Ӹ� : ");
		gName.setLocation(70,80);
		gName.setSize(200, 30);
		//���Ӹ� �ؽ�Ʈ �ʵ�
		JTextField gntf = new JTextField(20);
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		
		//������ ��
		JLabel glike = new JLabel("���� ���ɻ� : ");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		// ������ �ؽ�Ʈ �ʵ�
		JTextField gltf = new JTextField(20);
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);
		
		//��й�ȣ �Է� ��
		JLabel gPw = new JLabel("��й�ȣ�Է� : ");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		//��й�ȣ �Է� �ؽ�Ʈ �ʵ�
		JTextField gPwtf = new JTextField(20);
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);
		
		//��й�ȣ �� �Է� ��
		JLabel regPw = new JLabel("��й�ȣ ���Է� : ");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//��й�ȣ �� �Է� �ؽ�Ʈ �ʵ�
		JTextField regPwtf = new JTextField(20);
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);
		
		//���� ���� ��
		JLabel content = new JLabel("���� ����");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// �ؽ�Ʈ
		JTextField ctf = new JTextField(20);
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);
		
		//�������� ��
		JLabel news = new JLabel("��������");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//�ؽ�Ʈ
		JTextField newstf = new JTextField(20);
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);
		
		//�߰���ư
		JButton btn = new JButton("�����Ϸ�");
		btn.setLocation(340,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));
		
		mf.add(title, "North");
		mf.add(gName);
		mf.add(gntf);
		mf.add(glike);
		mf.add(gltf);
		mf.add(gPw);
		mf.add(gPwtf);
		mf.add(regPw);
		mf.add(regPwtf);
		mf.add(content);
		mf.add(ctf);
		mf.add(news);
		mf.add(newstf);
		mf.add(btn , "South");
		mf.add(mainPanel);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
