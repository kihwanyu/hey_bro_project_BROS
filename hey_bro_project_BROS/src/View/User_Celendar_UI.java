package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

public class User_Celendar_UI{

	public void calendar(){
		JFrame mf = new JFrame();      
		mf.setLayout(null);
		mf.setBackground(Color.WHITE);
		//������ ũ��
		mf.setBounds(400, 200, 800, 500);
		//������ �̸�
		mf.setTitle("Hey~bro");
		mf.setResizable(false);

		//�޷� �г� 
		JPanel cjp = new JPanel();
		cjp.setBounds(250, 100, 500, 300);
		cjp.setLayout(new GridLayout(5,7,0,50));
		Object[] obj = new Object[36];
		for (int i = 1; i < obj.length; i++) {
			String str2 = String.valueOf(i);
			cjp.add(new JButton(str2));   
		}
		//�޷� ù�� ���� �ؽ�Ʈ�ʵ�
		JPanel text1 = new JPanel();
		text1.setBounds(250, 120, 500, 50);
		text1.setLayout(new GridLayout(1,7,0,0));
		for (int i = 0; i < 7; i++) {
			String str = "";
			text1.add(new JTextField(str));
		}
		//�޷� �ι�°�� ���� �ؽ�Ʈ�ʵ�
		JPanel text2 = new JPanel();
		text2.setBounds(250, 190, 500, 50);
		text2.setLayout(new GridLayout(1,7,0,0));
		for (int i = 0; i < 7; i++) {
			String str = "";
			text2.add(new JTextField(str));
		}
		//�޷� ����°�� ���� �ؽ�Ʈ�ʵ�
		JPanel text3 = new JPanel();
		text3.setBounds(250, 260, 500, 50);
		text3.setLayout(new GridLayout(1,7,0,0));
		for (int i = 0; i < 7; i++) {
			String str = "";
			text3.add(new JTextField(str));
		}
		//�޷� �׹�°�� ���� �ؽ�Ʈ�ʵ�
		JPanel text4 = new JPanel();
		text4.setBounds(250, 330, 500, 50);
		text4.setLayout(new GridLayout(1,7,0,0));
		for (int i = 0; i < 7; i++) {
			String str = "";
			text4.add(new JTextField(str));
		}
		//�޷� �ټ���°�� ���� �ؽ�Ʈ�ʵ�
		JPanel text5 = new JPanel();
		text5.setBounds(250, 400, 500, 50);
		text5.setLayout(new GridLayout(1,7,0,0));
		for (int i = 0; i < 7; i++) {
			String str = "";
			text5.add(new JTextField(str));
		}



		// ���� ���� �ؽ�Ʈ �ʵ�
		JTextField gtf = new JTextField();
		gtf.setText("���� ����");
		gtf.setSize(170, 160);
		gtf.setLocation(15, 40);

		//���� �г�
		JPanel dayP = new JPanel();
		dayP.setBounds(250, 70, 500, 30);
		dayP.setLayout(new GridLayout(1,7));
		String[] days = {"��","��","ȭ","��","��","��","��"}; 
		for (int i = 0; i < 7; i++) {
			String str = days[i];
			dayP.add(new JTextField("         "+str));
		}
		//
		// ��� ��¥ǥ�� ���ǳ�
		JPanel cPanel = new JPanel(); 
		cPanel.setBounds(425, 20, 150, 30);
		Calendar calendar = Calendar.getInstance();

		Date value = calendar.getTime(); // ���糯¥
		calendar.add(calendar.YEAR, -50); // ���糯¥���� 50 �� ����

		Date start = calendar.getTime();
		calendar.add(Calendar.YEAR, 100);//+50 �ϸ� ���� ��¥

		Date end = calendar.getTime();

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		JSpinner spinner3 = new JSpinner(dateModel);
		spinner3.setEditor(new JSpinner.DateEditor(spinner3, "yyyy/mm"));
		cPanel.add(spinner3);

		//���� ��� ����Ʈ ��ư 
		JButton listB = new JButton("L I S T");
		listB.setBounds(675, 20, 70, 30);
		
		//�ڷΰ��� ��ư
		JButton backB = new JButton("�ڷΰ���");
		backB.setBounds(49, 420, 100, 30);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setSize(800, 500);
		JPanel userPanel = new JPanel();


		userPanel.setLocation(0, 0);
		userPanel.setBackground(Color.LIGHT_GRAY);
		userPanel.setSize(200, 500);
		//icon_ : ������ư
		//icon : ������ư



		/*Image icon_1 = new ImageIcon("img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
		JButton edit = new JButton(new ImageIcon(icon_1));
		edit.setLocation(10, 210);
		edit.setSize(180, 52);

		Image icon_2 = new ImageIcon("img/button2.PNG").getImage().getScaledInstance(205, 48, 0);
		JButton qa = new JButton(new ImageIcon(icon_2));
		qa.setLocation(10, 280);
		qa.setSize(180, 52);*/

		Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/����Ż���ư.PNG").getImage().getScaledInstance(206, 50, 0);
		JButton out = new JButton(new ImageIcon(icon_3));
		out.setLocation(10, 350);
		out.setSize(180, 52);

		//text
		JLabel textGl = new JLabel("���� ���ӿ��Դϴ�.");
		textGl.setLocation(70, 3);
		textGl.setSize(120, 50);
		JLabel textGln = new JLabel("������");
		textGln.setLocation(25, 3);
		textGln.setSize(60, 50);

		Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
		JLabel png = new JLabel(new ImageIcon(icon_4));
		png.setLocation(0, 3);
		png.setSize(48, 45);

		mf.add(cjp);

		mf.add(text1);
		mf.add(text2);
		mf.add(text3);
		mf.add(text4);
		mf.add(text5);

		mf.add(backB);
		mf.add(gtf);
		mf.add(dayP);
		mf.add(cPanel);
		mf.add(listB);
		mf.add(png);
		/*mf.add(edit);
		mf.add(qa);*/
		mf.add(out);
		mf.add(textGl);
		mf.add(textGln);
		mf.add(userPanel);
		mf.add(mainPanel);


		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		User_Celendar_UI u = new User_Celendar_UI();
		u.calendar();
	}
}
