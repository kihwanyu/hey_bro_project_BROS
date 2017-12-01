package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.MemberController;
import Model.vo.Member;
import Model.vo.Session;

public class User_Celendar_UI extends JFrame{
   
   private MemberController c = new MemberController();
   private Member m = new Member();
   public User_Celendar_UI(JFrame superFrame/*����*/, String groupSession,Session session){
      //JFrame mf = new JFrame();      
      m = c.process("MemberSatting.do", session);
      this.setLayout(null);
    //  this.setBackground(Color.WHITE);
      //������ ũ��
      this.setBounds(100, 50, 1100, 800);
      //������ �̸�
      this.setTitle("Hey~bro");
      this.setResizable(false);
      

      //�޷� �г� 
      JPanel cjp = new JPanel();
      cjp.setBounds(300, 130, 700, 500);
      cjp.setLayout(new GridLayout(6, 7, 0, 70));
      cjp.setOpaque(false);
      Object[] obj = new Object[43];
      for (int i = 1; i < obj.length; i++) {
         String str2 = String.valueOf(i);
         cjp.add(new JButton(str2));   
      }
      
      
      
      //�޷� ù�� ���� �ؽ�Ʈ�ʵ�
      JPanel text1 = new JPanel();
      text1.setBounds(300, 155, 700, 70);
      text1.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text1.add(new JTextField(str));
      }
      //�޷� �ι�°�� ���� �ؽ�Ʈ�ʵ�
      JPanel text2 = new JPanel();
      text2.setBounds(300, 250, 700, 70);
      text2.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text2.add(new JTextField(str));
      }
      //�޷� ����°�� ���� �ؽ�Ʈ�ʵ�
      JPanel text3 = new JPanel();
      text3.setBounds(300, 346, 700, 70);
      text3.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text3.add(new JTextField(str));
      }
      //�޷� �׹�°�� ���� �ؽ�Ʈ�ʵ�
      JPanel text4 = new JPanel();
      text4.setBounds(300, 440, 700, 70);
      text4.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text4.add(new JTextField(str));
      }
      //�޷� �ټ���°�� ���� �ؽ�Ʈ�ʵ�
      JPanel text5 = new JPanel();
      text5.setBounds(300, 536, 700, 70);
      text5.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text5.add(new JTextField(str));
      }
      //�޷� ������°�� ���� �ؽ�Ʈ�ʵ�
      JPanel text6 = new JPanel();
      text6.setBounds(300, 631, 700, 70);
      text6.setLayout(new GridLayout(1,7,0,0));
      for (int i = 0; i < 7; i++) {
         String str = "";
         text6.add(new JTextField(str));
      }



      // ���� ���� �ؽ�Ʈ �ʵ�
      JTextField gtf = new JTextField();
      gtf.setText("���� ����");
      gtf.setSize(170, 160);
      gtf.setLocation(35, 130);

      //���� �г�
      JPanel dayP = new JPanel();
      dayP.setBounds(300, 100, 700, 30);
      dayP.setLayout(new GridLayout(1,7));
      String[] days = {"��","��","ȭ","��","��","��","��"}; 
      for (int i = 0; i < 7; i++) {
         String str = days[i];
         dayP.add(new JTextField("              "+str));
      }
      //
      // ��� ��¥ǥ�� ���ǳ�
      JPanel cPanel = new JPanel(); 
      cPanel.setBounds(594, 30, 110, 30);
      Calendar calendar = Calendar.getInstance();
      cPanel.setOpaque(false);

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
      listB.setBounds(900, 20, 100, 40);

      //�ڷΰ��� ��ư
      JButton backB = new JButton("�ڷΰ���");
      backB.setBounds(69, 670, 100, 30);

      JPanel mainPanel = new JPanel();
      //mainPanel.setBackground(Color.WHITE);
      mainPanel.setSize(1100, 800);
   //   mainPanel.setOpaque(false);
      JPanel userPanel = new JPanel();
     
      JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/GS2840-1000x1000.png"));
		background.setLocation(0, 0);
		background.setSize(1100, 800);
		this.add(background);

      userPanel.setLocation(0, 0);
      userPanel.setBackground(Color.pink);
      userPanel.setSize(240, 800);
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
      out.setLocation(30, 530);
      out.setSize(180, 52);

      //text
      JLabel textGl = new JLabel("���� ���ӿ��Դϴ�.");
      textGl.setLocation(90, 43);
      textGl.setSize(120, 50);
      JLabel textGln = new JLabel(m.getUserName());
      textGln.setLocation(45, 43);
      textGln.setSize(60, 50);

      Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
      JLabel png = new JLabel(new ImageIcon(icon_4));
      png.setLocation(0, 3);
      png.setSize(48, 45);

      this.add(cjp);

      this.add(text1);
      this.add(text2);
      this.add(text3);
      this.add(text4);
      this.add(text5);
      this.add(text6);

      this.add(backB);
      this.add(gtf);
      this.add(dayP);
      this.add(cPanel);
      this.add(listB);
      this.add(png);
      /*mf.add(edit);
      mf.add(qa);*/
      this.add(out);
      this.add(textGl);
      this.add(textGln);
      this.add(userPanel);
      this.add(mainPanel);


      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //����
      backB.addMouseListener(new MouseListener(){

         @Override
         public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

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
            superFrame.setVisible(true);
            frameSetVisible();

         }

         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

         }

      });
   }
   //����//
   public void frameSetVisible(){
      this.setVisible(false);
   }
   /*public static void main(String[] args){
      User_Celendar_UI u = new User_Celendar_UI();
      u.calendar();
   }*/
}