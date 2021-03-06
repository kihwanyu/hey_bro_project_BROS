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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controller.GroupController;
import Model.vo.Session;

public class LeaveGroup_UI extends JFrame {
	
	/**
	 * 
	 */

	//
	private Session session = new Session();
	private GroupController gc = new GroupController();
	public LeaveGroup_UI(Session session, String gName) {
		//JFrame mf = new JFrame();
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * 그래서 프레임의 위치를
		 * (모니터화면 가로 - 프레임화면 가로) / 2,
		 * (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
		 */
		this.setLocation((screenSize.width - frameSize.width)/4, (screenSize.height - frameSize.height)/4);
		this.session = session;

		this.setSize(800, 500);
		this.setLayout(null);
		this.setTitle("Hey~bro");
		this.setResizable(false);

		//


		//메인패널
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);



		//臾멸뎄 ?씪踰?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/leavegroup.png").getImage().getScaledInstance(800, 500, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(0, 0, 800, 500);

		//?깉?눜踰꾪듉
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/delete_bt.PNG").getImage().getScaledInstance(100, 39, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(350, 397, 100, 39);
		
		//?솗?씤 泥댄겕
		JRadioButton check = new JRadioButton();
		check.setBackground(null);
		check.setBounds(271, 360, 16, 25);
		check.setOpaque(false);
		
		label2.addMouseListener(new MouseListener(){

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
				if(check.isSelected()){
					gc.process("LeaveGroup.do", session, gName);
					JOptionPane.showMessageDialog(null, "그룹을 탈퇴했습니다.");
					mainPage();
				} else {
					JOptionPane.showMessageDialog(null, "안내사항 확인 버튼을 눌러주세요.");
				}
				
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
		
		

		

		//버튼 뒤로가기 
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
				new Leader_Calendar_UI(session, gName);				
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
	
	public void mainPage() {		
		this.setVisible(false);//현재 프레임의 비전을끄고
		try {
			this.add(new Main_UI(session)); //새로운 프레임을 만든다.
		} catch (Exception e) {
		}
		
	}
	
	
	
	

}
