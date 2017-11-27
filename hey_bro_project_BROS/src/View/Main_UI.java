package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Controller;
import Model.vo.Member;
import Model.vo.Session;

public class Main_UI extends JFrame {
   //
   private JPanel mainPanel;
   private Controller c = new Controller();
   private Member m = new Member();
   private JFrame superFrame; //수정
   /**
    * 
    */
   private static final long serialVersionUID = -5254287704675653795L;

   public Main_UI(Session session){
      //jo1
      //로그인에서 받을 세션을 메인화면으로 가지고 온다.
      //로그인한 아이디로 맴버정보를 가져와 세팅한다.
      m = c.process("MemberSatting.do", session);
      this.superFrame = this; //수정
      
      this.setLayout(null);
      this.setBackground(Color.WHITE);
     
      this.setBounds(400, 200, 800, 500);
      

      mainPanel = new JPanel();
      mainPanel.setOpaque(false);
      
     // mainPanel.setBackground(Color.WHITE);
      JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/20100414201035!Matissedance.png"));
		background.setBounds(0, 0, 800, 500);
		mainPanel.add(background);
      mainPanel.setLayout(null);
      mainPanel.setBounds(0, 0, 800, 500);
      
      JPanel userPanel = new JPanel();
      userPanel.setLocation(0, 0);
      userPanel.setBackground(Color.LIGHT_GRAY);
      userPanel.setSize(200, 500);
      //icon_ : 좌측버튼
      //icon : 우측버튼
      
      //모임추가
      Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/main_1.PNG").getImage().getScaledInstance(140, 139, 0);
      JButton plusLabel = new JButton(new ImageIcon(icon));
      plusLabel.setLocation(250, 200);
      plusLabel.setSize(130, 130);

      //모임참여
      Image icon2 = new ImageIcon("hey_bro_project_BROS/src/View/img/main_2.PNG").getImage().getScaledInstance(140, 139, 0);
      JButton join = new JButton(new ImageIcon(icon2));
      join.setLocation(450, 200);
      join.setSize(130, 130);
      
      //모임입장
      Image icon3 = new ImageIcon("hey_bro_project_BROS/src/View/img/main_3.PNG").getImage().getScaledInstance(139, 139, 0);
      JButton in = new JButton(new ImageIcon(icon3));
      in.setLocation(650, 200);
      in.setSize(130, 130);
      
      //회원 정보 수정
      Image icon_1 = new ImageIcon("hey_bro_project_BROS/src/View/img/button1.PNG").getImage().getScaledInstance(207, 52, 0);
      JButton edit = new JButton(new ImageIcon(icon_1));
      edit.setLocation(10, 100);
      edit.setSize(180, 52);
      
      //Q/A
      clickEvent(edit, new MemberUpdate_UI(this, session));
      Image icon_2 = new ImageIcon("hey_bro_project_BROS/src/View/img/button2.PNG").getImage().getScaledInstance(205, 48, 0);
      JButton qa = new JButton(new ImageIcon(icon_2));
      qa.setLocation(10, 170);
      qa.setSize(180, 52);
      
      //회원탈퇴
      Image icon_3 = new ImageIcon("hey_bro_project_BROS/src/View/img/button3.PNG").getImage().getScaledInstance(206, 50, 0);
      JButton out = new JButton(new ImageIcon(icon_3));
      out.setLocation(10, 350);
      out.setSize(180, 52);
      clickEvent(out, new MemberDelete_UI(this, mainPanel, session)); //수정
      
      //text
      JLabel text1 = new JLabel("님 환영합니다.");
      text1.setLocation(110, 3);
      text1.setSize(100, 50);
      JLabel text2 = new JLabel(m.getUserName());
      text2.setLocation(65, 3);
      text2.setSize(60, 50);

      Image icon_4 = new ImageIcon(m.getPictureUrl()).getImage().getScaledInstance(48, 45, 0);
      JLabel png = new JLabel(new ImageIcon(icon_4));
      png.setLocation(0, 3);
      png.setSize(48, 45);

      background.add(png);
      background.add(plusLabel);
      background.add(join);
      background.add(in);
      background.add(edit);
      background.add(qa);
      background.add(out);
      background.add(text1);
      
      background.add(text2);
      background.add(userPanel);
      this.add(mainPanel);
      
      clickEvent(plusLabel, new GroupRegistor_UI(this, mainPanel, session)); //수정
      clickEvent(join, new GroupSearch_UI(this, mainPanel, session));
      clickEvent(in, new JoinGroup_UI(this, mainPanel, session)); //수정
           
     
      
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //mf.add();

      /*//아이콘 이미지 변경
      try {
         mf.setIconImage(ImageIO.read(new File("img/md.png"))); 
      } catch (IOException e) {
         e.printStackTrace();
      }
       */
   }
   public void clickEvent(JButton button, JPanel panel){
      button.addMouseListener(new MouseListener() {
         
         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
         }
         
         @Override
         public void mousePressed(MouseEvent e) {
            nextPage(panel);         
            panel.revalidate();
            panel.repaint();
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
   }
   
   
   
   
   public void nextPage(JPanel loadPanel) {      
      this.remove(this.mainPanel);//현재 패널 지우고
      this.mainPanel =  loadPanel; //2번 패널 객체를 담음
      this.add(mainPanel); //다시 패널을 올려줌
      this.repaint(); //다시 적용(갱신)
   }
   
   public void frameSetVisible(){
      this.setVisible(false);
   }

}