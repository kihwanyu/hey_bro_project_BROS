package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JoinGroup_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public JoinGroup_UI(){
		JFrame mf = new JFrame();
		mf.setBounds(400,200,800,500);
		mf.setLayout(null);
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
		
		//���������ӿ� ���
		
		mf.add(lb1);
		mf.add(groupList);
		mf.add(btn1);
		mf.add(btn2);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
