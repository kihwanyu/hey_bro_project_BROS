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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.glass.events.WindowEvent;

import Controller.GroupController;
import Model.vo.Group;
import Model.vo.Session;

public class GroupUpdate_UI extends JFrame{
	/**
	 * 
	 */
	static private Group g = new Group();
	private GroupController gc = new GroupController();
	private Session session;
	private static final long serialVersionUID = 1436779561881168592L;

	public GroupUpdate_UI(Session session, Group g, String groupName){
		//
		this.session = session;
		System.out.println(groupName);
		//System.out.println("����?");
		g = gc.process("GroupSetting.do", groupName, true);
		String leader = g.getLeader();
		System.out.println(leader);
		
		
		JFrame mf = new JFrame("���� ����");
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
		this.setSize(800, 500);
		this.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setSize(800, 500);
		mainPanel.setBackground(Color.white);

		//â �̸�
		JLabel title = new JLabel("���� ����");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(330,20);
		title.setSize(300, 30);
		title.setForeground(new Color(74, 84, 91));

		//���
		 JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/tidying-up-art-ursus-wehrli-1.png"));
		background.setBounds(0, 0, 800, 500);
		this.add(background);
		
		//���Ӹ� ��
		JLabel gName = new JLabel("���Ӹ� : ");
		gName.setLocation(70,80);
		gName.setSize(200, 30);
		gName.setForeground(new Color(74, 84, 91));

		//���Ӹ� �ؽ�Ʈ �ʵ�
		JTextField gntf = new JTextField(20);
		gntf.setText(g.getgName());
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		gntf.setEditable(false);

		//������ ��
		JLabel glike = new JLabel("���� ���ɻ� : ");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		glike.setForeground(new Color(74, 84, 91));
		// ������ �ؽ�Ʈ �ʵ�
		JTextField gltf = new JTextField(20);
		gltf.setText(g.getInterests());
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);
		

		//��й�ȣ �Է� ��
		JLabel gPw = new JLabel("��й�ȣ�Է� : ");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		gPw.setForeground(new Color(244, 250, 255));
		//��й�ȣ �Է� �ؽ�Ʈ �ʵ�
		JTextField gPwtf = new JTextField(20);
		gPwtf.setText(g.getPw());
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);

		//��й�ȣ �� �Է� ��
		JLabel regPw = new JLabel("��й�ȣ ���Է� : ");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		regPw.setForeground(new Color(74, 84, 91));
		//��й�ȣ �� �Է� �ؽ�Ʈ �ʵ�
		JTextField regPwtf = new JTextField(20);
		regPwtf.setText(g.getPw());
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);

		//���� ���� ��
		JLabel content = new JLabel("���� ����");
		content.setLocation(170,180);
		content.setSize(200, 30);
		content.setForeground(new Color(244, 250, 255));
		// �ؽ�Ʈ
		JTextArea  ctf = new JTextArea ();
		ctf.setText(g.getContent());
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);

		//�������� ��
		JLabel news = new JLabel("��������");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		news.setForeground(new Color(74, 84, 91));
		//�ؽ�Ʈ
		JTextArea newstf = new JTextArea();
		newstf.setText(g.getNews());
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);
		
		JButton backBtn = new JButton("�ڷΰ���");
		backBtn.setLocation(250,400);
		backBtn.setSize(100, 30);
		backBtn.setBackground(new Color(5, 150, 255));
		backBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				new Leader_Calendar_UI(session, groupName);	
				setVisible();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//�߰���ư
		JButton btn = new JButton("���� �Ϸ�");
		btn.setLocation(441, 400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));
		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
				Group group = new Group(gntf.getText(), gltf.getText(), gPwtf.getText(), ctf.getText(), newstf.getText(), leader);
				gc.process("GroupUpdate.do", group);
				
				if(gPwtf.getText().equals(regPwtf.getText())){
					JOptionPane.showMessageDialog(null, "���Ӽ����� ���������� �̷�������ϴ�.");
					
					new Leader_Calendar_UI(session, groupName);
					setVisible();
					
				}else{
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ ���� �ʽ��ϴ�.\n�ٽ� �Է����ּ���");
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(background);
		background.add(title, "North");
		background.add(gName);
		background.add(gntf);
		background.add(glike);
		background.add(gltf);
		background.add(gPw);
		background.add(gPwtf);
		background.add(regPw);
		background.add(regPwtf);
		background.add(content);
		background.add(ctf);
		background.add(news);
		background.add(newstf);
		background.add(backBtn); //�ڷΰ���
		background.add(btn , "South");
		this.add(mainPanel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setVisible(){
		this.setVisible(false);
	}
}
