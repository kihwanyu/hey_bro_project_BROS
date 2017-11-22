package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JoinGroup_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public JoinGroup_UI(){
		JFrame mf = new JFrame();
		mf.setBounds(400,200,800,500);
		mf.setLayout(null);
		//라벨 생성
		JLabel lb1 = new JLabel("모임참여");
		
		lb1.setLocation(350, 50);
		lb1.setSize(200, 100);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		
		
		//콤보박스 생성
		String [] groups = {"모임을 선택해주세요", "BROS", "샛별고 동문회", "샛별대 동문회"};
		
		
		JComboBox<String> groupList = new JComboBox<>(groups);
		groupList.setSelectedIndex(0);
		groupList.setLocation(200, 150);
		groupList.setSize(390, 50);
		
		groupList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); //선택한 콤보박스
				String name = (String)cb.getSelectedItem(); //선택된 아이템을 스트링에다가 형변환해서 담음
				
				/*Image img = new ImageIcon("images/"+name + ".PNG").getImage().getScaledInstance(150,150,0); //확장자가 다 똑같다는 전제 하에..
				label.setIcon(new ImageIcon(img));*/		
			}
		});
		//버튼 생성
		
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(200, 300);
		btn1.setSize(180, 50);
		
		JButton btn2 = new JButton("입장하기");
		btn2.setLocation(400, 300);
		btn2.setSize(180, 50);
		
		//메인프레임에 담기
		
		mf.add(lb1);
		mf.add(groupList);
		mf.add(btn1);
		mf.add(btn2);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
