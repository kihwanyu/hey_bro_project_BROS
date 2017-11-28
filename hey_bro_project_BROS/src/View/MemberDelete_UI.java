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
	private JPanel panel;	//수정
	private JFrame superFrame;	//수정
	private JPanel superPanel; 	//수정
	private JPanel tempPanel;	//수정
	private MemberController c = new MemberController(); //수정
	private Member m = new Member(); //수정
	private Session session; //수정
	JRadioButton check = new JRadioButton();
	//
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557046076929215948L;

	public MemberDelete_UI(JFrame superFrame, JPanel superPanel, Session session/*수정*/) {
		//JFrame mf = new JFrame();
		m = c.process("MemberSatting.do", session); //수정
		this.session = session; //수정
		this.panel = this.tempPanel; //수정
		this.superFrame = superFrame; //수정
		this.tempPanel = this.panel; //수정
		this.superPanel = superPanel; //수정
		
		this.setBounds(0, 0, 800, 500);
		this.setLayout(null);
		
		//諛곌꼍?깋
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);
	
		//?쉶?썝?씠由? ?씪踰?
		String userName = session.getUserId();
		JLabel name = new JLabel(userName);
		name.setBounds(380, 164, 50, 50);
		
		//臾멸뎄 ?씪踰?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/memberdeletion.png").getImage().getScaledInstance(800, 490, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(0, 0, 800, 490);
		
		//?깉?눜踰꾪듉
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button.PNG").getImage().getScaledInstance(111, 47, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(340, 395, 111, 47);
		
		//?솗?씤 泥댄겕
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
		
		clickEvent(label2, superPanel); //수정
	}
	
	//수정
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
					JOptionPane.showMessageDialog(null, "회원이 탈퇴되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "약관에 동의해주세요.");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});

			
			
	
	}
	//수정
	public void loginPage() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Login_UI()); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}
	}
	
	public void main_UI() {		
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Main_UI(session)); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}
		
	}
}
