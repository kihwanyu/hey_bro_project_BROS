package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controller.MemberController;
import Model.vo.Member;
import Model.vo.Session;

public class MemberDelete_UI extends JPanel {
	private JPanel panel;	//����
	private JFrame superFrame;	//����
	private JPanel superPanel; 	//����
	private JPanel tempPanel;	//����
	private MemberController c = new MemberController(); //����
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
		String userName = session.getUserId();
		JLabel name = new JLabel(userName);
		name.setBounds(380, 164, 50, 50);
		
		//문구 ?���?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/memberdeletion.png").getImage().getScaledInstance(800, 490, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(0, 0, 800, 490);
		
		//?��?��버튼
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button.PNG").getImage().getScaledInstance(111, 47, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(340, 395, 111, 47);
		
		//?��?�� 체크
		check.setBackground(null);
		check.setBounds(261, 355, 20, 20);
		check.setOpaque(false);
		
		JLabel back = new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/prevButton.png"));
		label.add(back);
		back.setBounds(20, 395, 45, 45);
		back.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				main_UI();
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
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
	
	public void main_UI() {		
		superFrame.setVisible(false);//���� �������� ����������
		try {
			superFrame.add(new Main_UI(session)); //���ο� �������� �����.
		} catch (Exception e) {

		}
		
	}
}
