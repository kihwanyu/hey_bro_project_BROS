package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GroupRegistor_UI extends JPanel {
	private JPanel superPanel;
	private JPanel mainPanel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4430678642605584542L;

	public GroupRegistor_UI(JPanel superPanel){
		//JFrame mf = new JFrame("모임 만들기");

		this.setBounds(0, 0, 800, 500);
		this.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(800, 500);
		mainPanel.setBackground(Color.white);
		
		//창 이름
		JLabel title = new JLabel("모임 만들기");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(316,10);
		title.setSize(300, 30);
		
		//모임명 라벨
		JLabel gName = new JLabel("모임명 : ");
		gName.setLocation(70,80);
		gName.setSize(200, 30);
		//모임명 텍스트 필드
		JTextField gntf = new JTextField(20);
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		
		//콘텐츠 라벨
		JLabel glike = new JLabel("모임 관심사 : ");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		// 콘텐츠 텍스트 필드
		JTextField gltf = new JTextField(20);
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);
		
		//비밀번호 입력 라벨
		JLabel gPw = new JLabel("비밀번호입력 : ");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		//비밀번호 입력 텍스트 필드
		JTextField gPwtf = new JTextField(20);
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);
		
		//비밀번호 재 입력 라벨
		JLabel regPw = new JLabel("비밀번호 재입력 : ");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//비밀번호 재 입력 텍스트 필드
		JTextField regPwtf = new JTextField(20);
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);
		
		//모임 내용 라벨
		JLabel content = new JLabel("모임 내용");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// 텍스트
		JTextField ctf = new JTextField(20);
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);
		
		//공지사항 라벨
		JLabel news = new JLabel("공지사항");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//텍스트
		JTextField newstf = new JTextField(20);
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);
		
		//추가버튼
		JButton btn = new JButton("완료");
		btn.setLocation(440,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Main_UI();
			}
			
		});
		
		JButton back_btn = new JButton("뒤로가기");
		back_btn.setLocation(250,400);
		back_btn.setSize(100, 30);
		back_btn.setBackground(new Color(5, 150, 255));
		back_btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == back_btn){
					new Main_UI();
				}
			}
			
		});
		
		mainPanel.add(title, "North");
		mainPanel.add(gName);
		mainPanel.add(gntf);
		mainPanel.add(glike);
		mainPanel.add(gltf);
		mainPanel.add(gPw);
		mainPanel.add(gPwtf);
		mainPanel.add(regPw);
		mainPanel.add(regPwtf);
		mainPanel.add(content);
		mainPanel.add(ctf);
		mainPanel.add(news);
		mainPanel.add(newstf);
		mainPanel.add(btn , "South");
		mainPanel.add(back_btn, "South");
		
		this.add(mainPanel);
		
		//mf.setVisible(true);
		//mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void nextPage(JPanel loadPanel) {		
		this.removeAll();//현재 패널 지우고
		this.mainPanel =  loadPanel; //2번 패널 객체를 담음
		this.add(mainPanel); //다시 패널을 올려줌
		this.repaint(); //다시 적용(갱신)
	}
}

