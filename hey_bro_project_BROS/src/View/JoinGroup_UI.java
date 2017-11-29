package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.GroupController;
import Controller.MemberController;
import Model.vo.Group;
import Model.vo.Member;
import Model.vo.Session;

public class JoinGroup_UI extends JPanel {
	private JPanel panel;
	private JFrame superFrame;
	private JPanel superPanel;
	private JPanel tempPanel;
	private MemberController mc = new MemberController(); //����
	private GroupController gc = new GroupController(); //����
	private Member m = new Member(); //����
	private Session session; //����
	private ArrayList<String> groupListArr = new ArrayList<>();
	private Group g;
	private String name;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public JoinGroup_UI(JFrame superFrame, JPanel superPanel, Session session/*����*/){
		System.out.println("����");
		m = mc.process("MemberSatting.do", session); //����
		groupListArr = gc.process("groupCombo.do", session.getUserId());
		for (int i = 0; i < groupListArr.size(); i++) {
			groupListArr.set(i, groupListArr.get(i).replace(".xml", ""));
		}

		this.session = session; //����
		this.panel = this.tempPanel;
		this.superFrame = superFrame;
		this.tempPanel = this.panel;
		this.superPanel = superPanel;
		//JFrame mf = new JFrame();
		panel = new JPanel();
		this.setBounds(0,0,800,500);
		this.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		//panel.setBounds(0, 0, 800, 500);
		//panel.setLayout(null);
		//�� ����
		JLabel lb1 = new JLabel("���� ����");

		lb1.setLocation(350, 50);
		lb1.setSize(200, 100);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 28));


		//�޺��ڽ� ����
		String [] groups = new String[groupListArr.size()];
		groupListArr.toArray(groups);


		JComboBox<String> groupList = new JComboBox<>(groups);
		//groupList.setSelectedIndex(0);
		groupList.setLocation(200, 150);
		groupList.setSize(390, 50);

		groupList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); //������ �޺��ڽ�
				name = (String)cb.getSelectedItem(); //���õ� �������� ��Ʈ�����ٰ� ����ȯ�ؼ� ����


				/*Image img = new ImageIcon("images/"+name + ".PNG").getImage().getScaledInstance(150,150,0); //Ȯ���ڰ� �� �Ȱ��ٴ� ���� �Ͽ�..
            label.setIcon(new ImageIcon(img));*/      
			}
		});

		//��ư ����

		JButton btn1 = new JButton("�ڷΰ���");
		btn1.setLocation(200, 300);
		btn1.setSize(180, 50);

		JButton btn2 = new JButton("�����ϱ�");
		btn2.setLocation(400, 300);
		btn2.setSize(180, 50);

		//���������ӿ� ���
		//this.add(panel);
		panel.add(lb1);
		panel.add(groupList);
		panel.add(btn1);
		panel.add(btn2);
		this.add(panel);
		clickEvent(btn1, superPanel);

		btn2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(name);
				g = gc.process("GroupSetting.do", name, true);
				//
				new Group_Calendar_UI(session, name);
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

		//clickEvent();
	}

	public void clickEvent(JButton button, JPanel panel){
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				main_UI(); //����            
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
	public void PanelSetVisible(){
		this.setVisible(false);
	}
	public void frameSetVisible(){
		superFrame.setVisible(false);
	}
	public void nextPage(JPanel loadPanel) {
		this.remove(this.panel);//���� �г� �����
		//this.panel =  loadPanel; //2�� �г� ��ü�� ����
		this.add(loadPanel); //�ٽ� �г��� �÷���
		this.repaint(); //�ٽ� ����(����)

	}

	//����
	public void main_UI() {      
		superFrame.setVisible(false);//���� �������� ����������
		try {
			superFrame.add(new Main_UI(session)); //���ο� �������� �����.
		} catch (Exception e) {

		}

	}
}