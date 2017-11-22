package View;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Transfer extends JFrame{
	
	public Transfer(){
		JFrame mf = new JFrame();
		
		this.setLayout(null);
		//mf.setBackground(Color.WHITE);

		//프레임 크기
		this.setBounds(400, 200, 385, 420);
		//프레임 이름
		this.setTitle("Hey~bro");
		//사이즈 조절불가
		this.setResizable(false);
		
			
		//
		
		//메인 이미지
		Image icon = new ImageIcon("hey_bro_project_BROS/src/View/img/Transfer.PNG").getImage().getScaledInstance(380, 389, 0);
		JLabel transfer = new JLabel(new ImageIcon(icon));
		transfer.setBounds(0, 0, 380, 430);
		
		//메인 패널
		JPanel main = new JPanel();
		main.setBounds(0, 0, 380, 430);
		main.add(transfer);
		
		
		//버튼 뒤로가기 양도하기
		Image backI = new ImageIcon("hey_bro_project_BROS/src/View/img/back.PNG").getImage().getScaledInstance(112, 44, 0);
		JButton back = new JButton(new ImageIcon(backI));
		back.setBounds(50, 300, 114, 45);

		
		Image tf_btI = new ImageIcon("hey_bro_project_BROS/src/View/img/tf_bt.PNG").getImage().getScaledInstance(114, 45, 0);
		JButton tf_bt = new JButton(new ImageIcon(tf_btI));
		tf_bt.setBounds(220, 300, 114, 45);
		
		
		
		String[] member = {"구주승", "조성식", "임성진", "유기환", "한정란", "김한송"};
		JComboBox memberList = new JComboBox(member);
		memberList.setSelectedIndex(0);
		memberList.setBounds(100, 150, 200, 20);
		
	
		
		this.add(memberList);
		this.add(back);
		this.add(tf_bt);
		this.add(main);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*public static void main(String[] args){
		new Transfer();
	}*/
	
	
	
	
}
