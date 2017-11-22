package View;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main_UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5254287704675653795L;

	public Main_UI(){
		JFrame mf = new JFrame();
		//jo1
		mf.setLayout(null);
		mf.setBackground(Color.WHITE);

		//프레임 크기
		mf.setBounds(400, 200, 800, 500);
		//프레임 이름
		mf.setTitle("Hey~bro");
		//사이즈 조절불가
		mf.setResizable(false);


		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setSize(800, 500);
		JPanel userPanel = new JPanel();


		userPanel.setLocation(0, 0);
		userPanel.setBackground(Color.LIGHT_GRAY);
		userPanel.setSize(200, 500);
		//icon_ : 좌측버튼
		//icon : 우측버튼
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/main_1.PNG").getImage().getScaledInstance(140, 139, 0);
		JButton plusLabel = new JButton(new ImageIcon(icon));

		plusLabel.setLocation(250, 200);
		//userPanel2.setBackground(Color.blue);
		plusLabel.setSize(130, 130);

		Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/main_2.PNG").getImage().getScaledInstance(140, 139, 0);
		JButton join = new JButton(new ImageIcon(icon2));
		
		join.setBounds(450, 200, 130, 130);
	/*	join.setLocation(450, 200);
		//userPanel3.setBackground(Color.green);
		join.setSize(130, 130);
*/
		Image icon3 = new ImageIcon("hey_bro_project_BROS/src/View/img/main_3.PNG").getImage().getScaledInstance(139, 139, 0);
		JButton in = new JButton(new ImageIcon(icon3));

		in.setLocation(650, 200);
		//userPanel4.setBackground(Color.RED);
		in.setSize(130, 130);

		Image icon_1 = new ImageIcon("hey_bro_project_BROS/src/View/img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
		JButton edit = new JButton(new ImageIcon(icon_1));
		edit.setLocation(10, 100);
		edit.setSize(180, 52);

		Image icon_2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button2.PNG").getImage().getScaledInstance(205, 48, 0);
		JButton qa = new JButton(new ImageIcon(icon_2));
		qa.setLocation(10, 170);
		qa.setSize(180, 48);

		Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/button3.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton out = new JButton(new ImageIcon(icon_3));
		out.setLocation(10, 350);
		out.setSize(180, 50);

		//text
		JLabel text1 = new JLabel("님 환영합니다.");
		text1.setLocation(110, 3);
		text1.setSize(100, 50);
		JLabel text2 = new JLabel("조성식");
		text2.setLocation(65, 3);
		text2.setSize(60, 50);

		Image icon_4 = new ImageIcon("hey_bro_project_BROS/src/View/img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
		JLabel png = new JLabel(new ImageIcon(icon_4));
		png.setLocation(0, 3);
		png.setSize(48, 45);
		
		Image icon_5 = new ImageIcon("hey_bro_project_BROS/src/View/img/logout.PNG").getImage().getScaledInstance(149, 49, 0);
		JButton logout = new JButton(new ImageIcon(icon_5));
		logout.setBounds(630, 410, 149, 49);
		
		mf.add(logout);
		mf.add(png);
		mf.add(plusLabel);
		mf.add(join);
		mf.add(in);
		mf.add(edit);
		mf.add(qa);
		mf.add(out);
		mf.add(text1);
		mf.add(text2);
		mf.add(userPanel);
		mf.add(mainPanel);
		//mf.add();

		/*//아이콘 이미지 변경
		try {
			mf.setIconImage(ImageIO.read(new File("img/md.png"))); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		 */

		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
