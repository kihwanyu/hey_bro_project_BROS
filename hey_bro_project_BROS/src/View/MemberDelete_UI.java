package View;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class MemberDelete_UI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557046076929215948L;

	public MemberDelete_UI() {
		//JFrame mf = new JFrame();
		
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
		JRadioButton check = new JRadioButton();
		check.setBackground(null);
		check.setBounds(270, 335, 20, 20);
		
		this.add(check);
		this.add(label2);
		this.add(name);
		this.add(label);
		this.add(bg);
	}

}
