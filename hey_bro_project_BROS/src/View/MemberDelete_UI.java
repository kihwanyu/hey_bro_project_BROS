package View;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class MemberDelete_UI {
	public MemberDelete_UI() {
		JFrame mf = new JFrame();
		
		mf.setBounds(300, 250, 800, 500);
		mf.setLayout(null);
		mf.setTitle("Hey~bro");
		mf.setResizable(false);
		
		
		//Î∞∞Í≤Ω?Éâ
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);
	
		//?öå?õê?ù¥Î¶? ?ùºÎ≤?
		String userName = "¡∂º∫Ωƒ";
		JLabel name = new JLabel(userName);
		name.setBounds(380, 179, 50, 50);
		
		
		//Î¨∏Íµ¨ ?ùºÎ≤?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/out.PNG").getImage().getScaledInstance(612, 358, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(100, 70, 612, 358);
		
		//?Éà?á¥Î≤ÑÌäº
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button.PNG").getImage().getScaledInstance(111, 47, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(350, 375, 111, 47);
		
		//?ôï?ù∏ Ï≤¥ÌÅ¨
		JRadioButton check = new JRadioButton();
		check.setBackground(null);
		check.setBounds(270, 335, 20, 20);
		
		mf.add(check);
		mf.add(label2);
		mf.add(name);
		mf.add(label);
		mf.add(bg);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
