package View;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GroupDelete extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -956000051309938863L;
	public GroupDelete() {
		//JFrame mf = new JFrame();

		this.setBounds(300, 250, 800, 500);
		this.setLayout(null);
		//mf.setTitle("Hey~bro");
		//mf.setResizable(false);

		//
		
		
		//∏ﬁ¿Œ∆–≥Œ
		JPanel bg = new JPanel();
		bg.setSize(800, 500);
		bg.setBackground(Color.LIGHT_GRAY);



		//Î¨∏Íµ¨ ?ùºÎ≤?
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/delete.PNG").getImage().getScaledInstance(612, 358, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setBounds(100, 70, 612, 358);

		//?Éà?á¥Î≤ÑÌäº
		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/delete_bt.PNG").getImage().getScaledInstance(100, 39, 0);
		JButton label2 = new JButton(new ImageIcon(icon2));
		label2.setBounds(350, 375, 100, 39);

		//?ôï?ù∏ Ï≤¥ÌÅ¨
		JRadioButton check = new JRadioButton();
		check.setBackground(null);
		check.setBounds(280, 345, 20, 20);

		//πˆ∆∞ µ⁄∑Œ∞°±‚ æÁµµ«œ±‚
		Image backI = new ImageIcon("hey_bro_project_BROS/src/View/img/back.PNG").getImage().getScaledInstance(110, 44, 0);
		JButton back = new JButton(new ImageIcon(backI));
		back.setBounds(660, 15, 110, 39);
		
		this.add(back);
		this.add(check);
		this.add(label2);
		this.add(label);
		this.add(bg);

		//mf.setVisible(true);
		//mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*public static void main(String[] args){
		new GroupDelete();
	}*/
}
