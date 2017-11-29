package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.GroupController;
import Model.vo.Group;
import Model.vo.Session;

public class GroupUpdate_UI extends JFrame{
	/**
	 * 
	 */
	static private Group g = new Group();
	private GroupController gc = new GroupController();
	private Session session;
	private static final long serialVersionUID = 1436779561881168592L;

	public GroupUpdate_UI(Session session, Group g, String groupName){
		
		this.session = session;
		System.out.println(groupName);
		System.out.println("하이?");
		g = gc.process("GroupSetting.do", groupName, true);
		String leader = g.getLeader();
		System.out.println(leader);
		
		
		JFrame mf = new JFrame("모임 수정");
		// 프레임의 사이즈를 구합니다.
		Dimension frameSize = this.getSize();
		// 내 모니터의 크기를 구합니다.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * 그래서 프레임의 위치를
		 * (모니터화면 가로 - 프레임화면 가로) / 2,
		 * (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
		 */
		this.setLocation((screenSize.width - frameSize.width)/4, (screenSize.height - frameSize.height)/4);
		this.setSize(800, 500);
		this.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setSize(800, 500);
		mainPanel.setBackground(Color.white);

		//창 이름
		JLabel title = new JLabel("모임수정");
		title.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		title.setLocation(330,10);
		title.setSize(300, 30);


		//모임명 라벨
		JLabel gName = new JLabel("모임명 : ");
		gName.setLocation(70,80);
		gName.setSize(200, 30);

		//모임명 텍스트 필드
		JTextField gntf = new JTextField(20);
		gntf.setText(g.getgName());
		gntf.setLocation(150, 80);
		gntf.setSize(200, 30);
		gntf.setEditable(false);

		//콘텐츠 라벨
		JLabel glike = new JLabel("모임 관심사 : ");
		glike.setLocation(450,80);
		glike.setSize(200, 30);
		// 콘텐츠 텍스트 필드
		JTextField gltf = new JTextField(20);
		gltf.setText(g.getInterests());
		gltf.setLocation(540, 80);
		gltf.setSize(200, 30);

		//비밀번호 입력 라벨
		JLabel gPw = new JLabel("비밀번호입력 : ");
		gPw.setLocation(50,120);
		gPw.setSize(200, 30);
		//비밀번호 입력 텍스트 필드
		JTextField gPwtf = new JTextField(20);
		gPwtf.setText(g.getPw());
		gPwtf.setLocation(150, 120);
		gPwtf.setSize(200, 30);

		//비밀번호 재 입력 라벨
		JLabel regPw = new JLabel("비밀번호 재입력 : ");
		regPw.setLocation(425, 120);
		regPw.setSize(200, 30);
		//비밀번호 재 입력 텍스트 필드
		JTextField regPwtf = new JTextField(20);
		regPwtf.setText(g.getPw());
		regPwtf.setLocation(540, 120);
		regPwtf.setSize(200, 30);

		//모임 내용 라벨
		JLabel content = new JLabel("모임 내용");
		content.setLocation(170,180);
		content.setSize(200, 30);
		// 텍스트
		JTextField ctf = new JTextField(20);
		ctf.setText(g.getContent());
		ctf.setLocation(50, 220);
		ctf.setSize(300, 160);

		//공지사항 라벨
		JLabel news = new JLabel("공지사항");
		news.setLocation(565, 180);
		news.setSize(200, 30);
		//텍스트
		JTextField newstf = new JTextField(20);
		newstf.setText(g.getNews());
		newstf.setLocation(440, 220);
		newstf.setSize(300, 160);

		//추가버튼
		JButton btn = new JButton("수정완료");
		btn.setLocation(340,400);
		btn.setSize(100, 30);
		btn.setBackground(new Color(5, 150, 255));
		btn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
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
				Group group = new Group(gntf.getText(), gltf.getText(), gPwtf.getText(), ctf.getText(), newstf.getText(), leader);
				gc.process("GroupUpdate.do", group);
				
				if(gPwtf.getText().equals(regPwtf.getText())){
					JOptionPane.showMessageDialog(null, "모임수정이 성공적으로 이루어졌습니다.");
					new Group_Calendar_UI(session, groupName);
					
				}else{
					JOptionPane.showMessageDialog(null, "비밀번호가 일치 하지 않습니다.\n다시 입력해주세요");
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		this.add(title, "North");
		this.add(gName);
		this.add(gntf);
		this.add(glike);
		this.add(gltf);
		this.add(gPw);
		this.add(gPwtf);
		this.add(regPw);
		this.add(regPwtf);
		this.add(content);
		this.add(ctf);
		this.add(news);
		this.add(newstf);
		this.add(btn , "South");
		this.add(mainPanel);

		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
