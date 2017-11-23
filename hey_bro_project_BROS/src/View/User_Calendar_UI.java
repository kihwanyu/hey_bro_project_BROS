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

public class User_Calendar_UI{

   public void calendar(){
      JFrame mf = new JFrame();      
      mf.setLayout(null);
      mf.setBackground(Color.WHITE);
      //프레임 크기
      mf.setBounds(400, 200, 800, 500);
      //프레임 이름
      mf.setTitle("Hey~bro");
      mf.setResizable(false);

      //달력 패널 
      JPanel cjp = new JPanel();
      cjp.setBounds(250, 100, 500, 300);
      cjp.setLayout(new GridLayout(5,7,0,50));
      Object[] obj = new Object[36];
      for (int i = 1; i < obj.length; i++) {
         String str2 = String.valueOf(i);
         cjp.add(new JButton(str2));   
      }
   /*   JTextField[] text = new JTextField[35];
      for (int i = 1; i <= text.length; i++) {
         text[i].setSize(40, 50);
      }
      text[0].setLocation(250, 150);*/
      
      // 모임 내용 텍스트 필드
      JTextField gtf = new JTextField();
      gtf.setText("모임 내용");
      gtf.setSize(170, 160);
      gtf.setLocation(15, 40);

      //요일 패널
      JPanel dayP = new JPanel();
      dayP.setBounds(250, 75, 500, 30);
      dayP.setLayout(new GridLayout(1,7));
      String[] days = {"일","월","화","수","목","금","토"}; 
      for (int i = 0; i < 7; i++) {
         String str = days[i];
         dayP.add(new JTextField("         "+str));
      }
//
      // 상단 날짜표시 스피너
      JPanel cPanel = new JPanel(); 
      cPanel.setBounds(425, 30, 150, 30);
      Calendar calendar = Calendar.getInstance();

      Date value = calendar.getTime(); // 현재날짜
      calendar.add(calendar.YEAR, -50); // 현재날짜에서 50 년 뺀것

      Date start = calendar.getTime();
      calendar.add(Calendar.YEAR, 100);//+50 하면 현재 날짜

      Date end = calendar.getTime();

      SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.YEAR);
      JSpinner spinner3 = new JSpinner(dateModel);
      spinner3.setEditor(new JSpinner.DateEditor(spinner3, "yyyy/mm"));
      cPanel.add(spinner3);
      
      //우측 상단 리스트 버튼 
      JButton listB = new JButton("L I S T");
      listB.setBounds(675, 30, 70, 30);

      JPanel mainPanel = new JPanel();
      mainPanel.setBackground(Color.WHITE);
      mainPanel.setSize(800, 500);
      JPanel userPanel = new JPanel();


      userPanel.setLocation(0, 0);
      userPanel.setBackground(Color.LIGHT_GRAY);
      userPanel.setSize(200, 500);
      //icon_ : 좌측버튼
      //icon : 우측버튼
      


      Image icon_1 = new ImageIcon("img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
      JButton edit = new JButton(new ImageIcon(icon_1));
      edit.setLocation(10, 210);
      edit.setSize(180, 52);

      Image icon_2 = new ImageIcon("img/button2.PNG").getImage().getScaledInstance(205, 48, 0);
      JButton qa = new JButton(new ImageIcon(icon_2));
      qa.setLocation(10, 280);
      qa.setSize(180, 52);

      Image icon_3 = new ImageIcon("img/button3.PNG").getImage().getScaledInstance(206, 50, 0);
      JButton out = new JButton(new ImageIcon(icon_3));
      out.setLocation(10, 350);
      out.setSize(180, 52);

      //text
      JLabel text1 = new JLabel("님은 모임장입니다.");
      text1.setLocation(70, 3);
      text1.setSize(120, 50);
      JLabel text2 = new JLabel("조성식");
      text2.setLocation(25, 3);
      text2.setSize(60, 50);

      Image icon_4 = new ImageIcon("img/button4.PNG").getImage().getScaledInstance(48, 45, 0);
      JLabel png = new JLabel(new ImageIcon(icon_4));
      png.setLocation(0, 3);
      png.setSize(48, 45);

      mf.add(cjp);
      
      mf.add(gtf);
      mf.add(dayP);
      mf.add(cPanel);
      mf.add(listB);
      mf.add(png);
      mf.add(edit);
      mf.add(qa);
      mf.add(out);
      mf.add(text1);
      mf.add(text2);
      mf.add(userPanel);
      mf.add(mainPanel);


      mf.setVisible(true);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String[] args){
      User_Calendar_UI u = new User_Calendar_UI();
      u.calendar();
   }
}