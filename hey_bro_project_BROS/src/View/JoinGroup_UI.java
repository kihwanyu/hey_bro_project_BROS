package View;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinGroup_UI extends JPanel {
	private JPanel panel;
	private JFrame superFrame;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public JoinGroup_UI(JFrame frame){
		this.superFrame = frame;
		//JFrame mf = new JFrame();
		panel = new JPanel();
		this.setBounds(0,0,800,500);
		this.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		//panel.setBounds(0, 0, 800, 500);
		//panel.setLayout(null);
		//�� ����
		JLabel lb1 = new JLabel("��������");

		lb1.setLocation(350, 50);
		lb1.setSize(200, 100);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 28));


		//�޺��ڽ� ����
		String [] groups = {"������ �������ּ���", "BROS", "������ ����ȸ", "������ ����ȸ"};


		JComboBox<String> groupList = new JComboBox<>(groups);
		groupList.setSelectedIndex(0);
		groupList.setLocation(200, 150);
		groupList.setSize(390, 50);

		groupList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); //������ �޺��ڽ�
				String name = (String)cb.getSelectedItem(); //���õ� �������� ��Ʈ�����ٰ� ����ȯ�ؼ� ����

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
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2){
				Dialog sd = new Dialog(frame,"���� ����");
				sd.setBounds(300, 100, 500, 300);
				sd.setLayout(null);
				
				JLabel title = new JLabel("GROUP NAME");
				title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
				title.setLocation(145,10);
				title.setSize(300, 30);
				sd.add(title);
				 
				String result = JOptionPane.showInputDialog("������ �Է��ϼ���");
		            System.out.println(result);

				}
			}
		});
		//���������ӿ� ���
		//this.add(panel);
		panel.add(lb1);
		panel.add(groupList);
		panel.add(btn1);
		panel.add(btn2);
		this.add(panel);

		/*btn2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				new GroupJoin_Pw_UI();

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
		});*/

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
				nextPage(panel);				
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
		superFrame.setVisible(false);
	}
	public void nextPage(JPanel loadPanel) {		
		this.remove(this.panel);//���� �г� �����
		this.panel =  loadPanel; //2�� �г� ��ü�� ����
		this.add(panel); //�ٽ� �г��� �÷���
		this.repaint(); //�ٽ� ����(����)
	}
}
