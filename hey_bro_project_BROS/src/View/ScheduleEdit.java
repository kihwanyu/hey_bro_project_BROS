package View;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScheduleEdit extends JFrame{
   JPanel mp = new JPanel();
   
   public void scheduleEdit(){
      
         this.setBounds(100, 50, 800, 500);
         this.setLayout(null);
         mp.setSize(800, 500);
         mp.setLayout(null);
         //창 타이틀
         JLabel titleL = new JLabel("일정 수정");
         titleL.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
         titleL.setBounds(150, 30, 120, 50);

         //일정(년/월/일).
         JComboBox<String> yearList = new JComboBox<>();
         JComboBox<String> monthList = new JComboBox<>();
         JComboBox<String> dateList = new JComboBox<>();
         int[] year = new int[80];
         int[] month = new int [12];
         int[] date = new int [31];

         for(int i = 0; i < year.length; i++){
            year[i] = 1940+i;
            yearList.addItem(String.valueOf(year[i]).toString());
         }
         for(int i = 0; i < month.length; i++){
            month[i] = 1+i;
            monthList.addItem(String.valueOf(month[i]).toString());
         }

         for(int i = 0; i < 31; i++){
            date[i] = 1+i;
            dateList.addItem(String.valueOf(date[i]).toString());   
         }

         yearList.setSelectedIndex(0); 
         yearList.setLocation(450, 40);
         yearList.setSize(55,30);
         monthList.setSelectedIndex(0);
         monthList.setLocation(507, 40);
         monthList.setSize(40,30);
         dateList.setLocation(550, 40);
         dateList.setSize(40,30);

         //제목입력 라벨과 텍스트필드
         JLabel tftitle = new JLabel("제목 입력 : ");
         tftitle.setBounds(160, 90, 120, 30);
         JTextField titleTf = new JTextField();
         titleTf.setBounds(280, 90, 320, 30);

         //내용입력 라벨과 텍스트 필드
         JLabel contentsL = new JLabel("내용 입력");
         contentsL.setBounds(350, 130, 120, 30);
         JTextField contentsTf = new JTextField();
         contentsTf.setBounds(140, 170, 460, 200);

         //시작시간 라벨
         JLabel startL = new JLabel("시작 시간");
         startL.setBounds(160, 370, 120, 50);
         //시작 시간 과 분
         JComboBox<String> hourList1 = new JComboBox<>();
         int[] hour1 = new int[24];
         for(int i = 0; i < hour1.length; i++){
            hour1[i] = 1+i;
            hourList1.addItem(String.valueOf(hour1[i]).toString());
         }
         hourList1.setLocation(230, 380);
         hourList1.setSize(50,30);

         JComboBox<String> miniteList1 = new JComboBox<>();
         int[] minite1 = new int[60];
         for(int i = 0; i < minite1.length; i++){
            minite1[i] = 1+i;
            miniteList1.addItem(String.valueOf(minite1[i]).toString());
         }
         miniteList1.setLocation(290, 380);
         miniteList1.setSize(50,30);
         //종료시간 라벨
         JLabel endL = new JLabel("종료 시간");
         endL.setBounds(390, 370, 120,50);
         //종료 시간 과 분
         JComboBox<String> hourList2 = new JComboBox<>();
         int[] hour2 = new int[24];
         for(int i = 0; i < hour2.length; i++){
            hour2[i] = 1+i;
            hourList2.addItem(String.valueOf(hour2[i]).toString());
         }
         hourList2.setLocation(460, 380);
         hourList2.setSize(50,30);

         JComboBox<String> miniteList2 = new JComboBox<>();
         int[] minite2 = new int[60];
         for(int i = 0; i < minite2.length; i++){
            minite2[i] = 1+i;
            miniteList2.addItem(String.valueOf(minite2[i]).toString());
         }
         miniteList2.setLocation(520, 380);
         miniteList2.setSize(50,30);

         this.add(mp);
         mp.add(yearList);
         mp.add(monthList);
         mp.add(dateList);

         mp.add(miniteList1);
         mp.add(hourList1);
         mp.add(miniteList2);
         mp.add(hourList2);
         mp.add(contentsL);
         mp.add(contentsTf);
         mp.add(startL);
         mp.add(endL);
         mp.add(titleL);
         mp.add(tftitle);
         mp.add(titleTf);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

   public static void main(String[] args) {
      ScheduleEdit s = new ScheduleEdit();
      s.scheduleEdit();

   }

}