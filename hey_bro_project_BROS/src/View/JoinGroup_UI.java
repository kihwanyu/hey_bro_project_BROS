package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JoinGroup_UI extends JPanel {
	private JPanel panel;
	private JFrame superFrame;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public JoinGroup_UI(JFrame frame){
		this.superFrame = frame;
		//JFrame mf = new JFrame();
		panel = new JPanel();
		this.setBounds(0,0,800,500);
		this.setLayout(null);
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		//panel.setBounds(0, 0, 800, 500);
		//panel.setLayout(null);
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
		
		JButton btn1 = new JButton("메인으로 가기");
		btn1.setLocation(200, 300);
		btn1.setSize(180, 50);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Main_UI();
			}
			
		});
		
		JButton btn2 = new JButton("입장하기");
		btn2.setLocation(400, 300);
		btn2.setSize(180, 50);
		
		//메인프레임에 담기
		//this.add(panel);
		panel.add(lb1);
		panel.add(groupList);
		panel.add(btn1);
		panel.add(btn2);
		this.add(panel);
		
		btn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				new GroupJoin_Pw_UI();

				frameSetVisible();
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
				nextPage(panel);				
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
	public void frameSetVisible(){
		superFrame.setVisible(false);
	}
	public void nextPage(JPanel loadPanel) {		
		this.remove(this.panel);//현재 패널 지우고
		this.panel =  loadPanel; //2번 패널 객체를 담음
		this.add(panel); //다시 패널을 올려줌
		this.repaint(); //다시 적용(갱신)
	}
}
