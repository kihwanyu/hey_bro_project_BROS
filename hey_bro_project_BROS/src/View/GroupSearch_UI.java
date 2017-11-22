package View;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GroupSearch_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1823416224145672077L;

	public GroupSearch_UI(){
		JFrame mf = new JFrame("모임 검색");
		mf.setBounds(300, 100, 500, 300);
		mf.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(500, 300);
		mainPanel.setBackground(Color.white);
		
		JPanel subPanel = new JPanel();
		subPanel.setBackground(Color.yellow);
		subPanel.setLocation(192,8);
		subPanel.setSize(100, 35);
		
		//창 이름
		JLabel title = new JLabel("Search");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(195,10);
		title.setSize(300, 30);

		//모임명검색 라벨
		JLabel gName = new JLabel("모임명 : ");
		gName.setLocation(50,80);
		gName.setSize(200, 30);
		//모임명검색 텍스트 필드
		JTextField gntf = new JTextField(20);
		gntf.setLocation(120, 80);
		gntf.setSize(200, 30);

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
		mf.add(gName);
		mf.add(gntf);
		mf.add(btn1);
		mf.add(btn2);
		mf.add(subPanel);
		mf.add(mainPanel);
		
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
