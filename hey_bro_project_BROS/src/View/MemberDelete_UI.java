package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controller.Controller;
import Model.vo.Member;
import Model.vo.Session;

public class MemberDelete_UI extends JPanel {
	private JPanel panel;	//����
	private JFrame superFrame;	//����
	private JPanel superPanel; 	//����
	private JPanel tempPanel;	//����
	private Controller c = new Controller(); //����
	private Member m = new Member(); //����
	private Session session; //����
	JRadioButton check = new JRadioButton();
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557046076929215948L;

	public MemberDelete_UI(JFrame superFrame, JPanel superPanel, Session session/*����*/) {
		//JFrame mf = new JFrame();
		m = c.process("MemberSatting.do", session); //����
		this.session = session; //����
		this.panel = this.tempPanel; //����
		this.superFrame = superFrame; //����
		this.tempPanel = this.panel; //����
		this.superPanel = superPanel; //����
		
		this.setBounds(0, 0, 800, 500);
		this.setLayout(null);
		
		//배경?��
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);
	
		//?��?��?���? ?���?
		String userName = "������";
		JLabel name = new JLabel(userName);
		name.setBounds(380, 179, 50, 50);
		
		//문구 ?���?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/out.PNG").getImage().getScaledInstance(612, 358, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(100, 70, 612, 358);
		
		//?��?��버튼
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button.PNG").getImage().getScaledInstance(111, 47, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(350, 375, 111, 47);
		
		//?��?�� 체크
		check.setBackground(null);
		check.setBounds(270, 335, 20, 20);
		
		this.add(check);
		this.add(label2);
		this.add(name);
		this.add(label);
		this.add(bg);
		
		clickEvent(label2, superPanel); //����
	}
	
	//����
	public void clickEvent(JButton button, JPanel panel){
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
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
				if(check.isSelected()){
					c.process("MemberDelete.do", session);
					loginPage();	
					JOptionPane.showMessageDialog(null, "ȸ���� Ż��Ǿ����ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "����� �������ּ���.");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});

			
			
	
	}
	//����
	public void loginPage() {		
		superFrame.setVisible(false);//���� �������� ����������
		try {
			superFrame.add(new Login_UI()); //���ο� �������� �����.
		} catch (Exception e) {

		}
	}
}
