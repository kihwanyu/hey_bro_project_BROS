package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Model.vo.Member;
import Model.vo.Session;

public class GroupSearch_UI extends JPanel {
   private JPanel panel;
   private JFrame superFrame;
   private JPanel superPanel;
   private JPanel tempPanel;
   private Controller c = new Controller(); //����
   private Member m = new Member(); //����
   private Session session; //����
   private ArrayList<String> groupArr = new ArrayList<>();
   private String [] groups;
   private JComboBox<String> groupList;
   private String groupSession;
   /**
    * 
    */
   private static final long serialVersionUID = -5276751205814558579L;

   public GroupSearch_UI(JFrame superFrame, JPanel superPanel, Session session/*����*/){
      
      
      m = c.process("MemberSatting.do", session); //����
      this.session = session; //����
      this.panel = this.tempPanel;
      this.superFrame = superFrame;
      this.tempPanel = this.panel;
      this.superPanel = superPanel;
      //JFrame mf = new JFrame();
      panel = new JPanel();
      this.setBounds(0,0,800,500);
      this.setLayout(null);
      panel.setBounds(0, 0, 800, 500);
      panel.setLayout(null);
      //panel.setBounds(0, 0, 800, 500);
      //panel.setLayout(null);
      //�� ����
      JLabel lb1 = new JLabel("��������");

      lb1.setLocation(340, 50);
      lb1.setSize(200, 100);
      lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
      
      
      //�޺��ڽ� ����
      String [] groups = new String[3];
      
      JComboBox<String> groupList = new JComboBox<>(groups);
      groupList.setSelectedIndex(0);
      groupList.setLocation(200, 230);
      groupList.setSize(390, 50);
      
      //�׷��� �˻� �� + �ؽ�Ʈ �ʵ�
      JLabel gNlabel = new JLabel();
      gNlabel.setText("�׷��� �˻�");
      gNlabel.setBounds(200, 150, 100, 50);
      JTextField gNtf = new JTextField();
      gNtf.setBounds(290, 150, 220, 50);
      JButton gNbut= new JButton("Ȯ��");
      gNbut.setBounds(530, 150, 60, 50);
      gNbut.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

         }

         @Override
         public void mousePressed(MouseEvent e) {
            groupArr = c.process("GroupListSearch.do", gNtf.getText(), 1);
            
            String[] groups_values = new String[groupArr.size()];
            //
            groupList.removeAllItems();
            
            for(int i = 0; i < groupArr.size(); i++) {
               groups_values[i] = groupArr.get(i);
               groupList.addItem(groups_values[i]);
               System.out.println(groups_values[i]);
            }
            //System.out.println(groups[1]);
            
            //groupList = new JComboBox<>(groups_values);
            groupList.setSelectedIndex(0);
            groupList.setLocation(200, 230);
            groupList.setSize(390, 50);
            
            
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
      
      
      
      //��ư ����

      JButton btn1 = new JButton("�ڷΰ���");
      btn1.setLocation(200, 300);
      btn1.setSize(180, 50);

      JButton btn2 = new JButton("�����ϱ�");
      btn2.setLocation(410, 300);
      btn2.setSize(180, 50);

      //���������ӿ� ���
      //this.add(panel);
      panel.add(gNlabel);
      panel.add(gNbut);
      panel.add(gNtf);
      panel.add(lb1);
      panel.add(groupList);
      panel.add(btn1);
      panel.add(btn2);
      this.add(panel);
      clickEvent(btn1, superPanel);

      btn2.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

         }

         @Override
         public void mousePressed(MouseEvent e) {
            
            
            groupSession = groupList.getItemAt(groupList.getSelectedIndex());
            new GroupJoin_Pw_UI(superFrame, groupSession, session);
            frameSetVisible();
         }//

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

      //clickEvent();
   }

   public void clickEvent(JButton button, JPanel panel){
      button.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

         }

         @Override
         public void mousePressed(MouseEvent e) {
            main_UI(); //����            
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
   public void PanelSetVisible(){
      this.setVisible(false);
   }
   public void frameSetVisible(){
      superFrame.setVisible(false);
   }
   public void nextPage(JPanel loadPanel) {
      this.remove(this.panel);//���� �г� �����
      //this.panel =  loadPanel; //2�� �г� ��ü�� ����
      this.add(loadPanel); //�ٽ� �г��� �÷���
      this.repaint(); //�ٽ� ����(����)

   }

   //����
   public void main_UI() {      
      superFrame.setVisible(false);//���� �������� ����������
      try {
         superFrame.add(new Main_UI(session)); //���ο� �������� �����.
      } catch (Exception e) {

      }

   }
}