package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupJoin_Pw_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5827244684650823215L;

	public GroupJoin_Pw_UI(){
		JFrame mf = new JFrame("모임 참여");
		mf.setBounds(300, 100, 500, 300);
		mf.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(500, 300);
		mainPanel.setBackground(Color.white);
		
		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.yellow);
		subPanel.setLocation(142,8);
		subPanel.setSize(200, 35);
		
		//창 이름
		JLabel title = new JLabel("GROUP NAME");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(145,10);
		title.setSize(300, 30);

		//모임명검색 라벨
		JLabel gPw = new JLabel("PASSWORD : ");
		gPw.setLocation(40,80);
		gPw.setSize(200, 30);
		//모임명검색 텍스트 필드
		JTextField gPwtf = new JTextField(20);
		gPwtf.setLocation(130, 80);
		gPwtf.setSize(200, 30);

		//참여버튼
		JButton btn1 = new JButton("모임참여");
		btn1.setLocation(340,80);
		btn1.setSize(100, 29);
		btn1.setBackground(new Color(5, 150, 255));

		//뒤로가기 버튼
		JButton btn2 = new JButton("뒤로가기");
		btn2.setLocation(195,180);
		btn2.setSize(100, 29);
		btn2.setBackground(new Color(5, 150, 255));
		
		mf.add(title);
		mf.add(gPw);
		mf.add(gPwtf);
		mf.add(btn1);
		mf.add(btn2);
		mf.add(subPanel);
		mf.add(mainPanel);
			
		mf.setVisible(true);
	}
}
