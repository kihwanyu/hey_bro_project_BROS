package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.GroupController;
import Controller.MemberController;
import Model.vo.Member;
import Model.vo.Session;

public class GroupSearch_UI extends JPanel {
	private JPanel panel;
	private JFrame superFrame;
	private JPanel superPanel;
	private JPanel tempPanel;
	private GroupController gc = new GroupController(); //수정
	private MemberController mc = new MemberController(); //수정
	private Member m = new Member(); //수정
	private Session session; //수정
	private ArrayList<String> groupArr = new ArrayList<>();
	private String [] groups;
	private JComboBox<String> groupList;
	private String groupSession;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276751205814558579L;

	public GroupSearch_UI(JFrame superFrame, JPanel superPanel, Session session/*수정*/){


		m = mc.process("MemberSatting.do", session); //수정
		this.session = session; //수정
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


		//배경
		JLabel background=new JLabel(new ImageIcon("hey_bro_project_BROS/src/View/img/maxresdefault.png"));
		background.setBounds(0, 0, 800, 500);
		this.add(background);

		//라벨 생성
		JLabel lb1 = new JLabel("모임참여");

		lb1.setLocation(340, 3);
		lb1.setSize(200, 100);
		lb1.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
		lb1.setForeground(new Color(79, 43, 11));


		//콤보박스 생성
		String [] groups = new String[3];

		JComboBox<String> groupList = new JComboBox<>(groups);
		groupList.setSelectedIndex(0);
		groupList.setLocation(200, 230);
		groupList.setSize(390, 50);

		//그룹장 검색 라벨 + 텍스트 필드
		JLabel gNlabel = new JLabel();
		gNlabel.setText("그룹장 검색");
		gNlabel.setBounds(200, 150, 100, 50);
		JTextField gNtf = new JTextField();
		gNtf.setBounds(290, 150, 220, 50);
		JButton gNbut= new JButton("확인");
		gNbut.setBounds(530, 150, 60, 50);
		gNbut.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				try{
				if(session.getUserId().equals(gNtf.getText())){
					JOptionPane.showMessageDialog(null, "검색하신 모임장이 본인입니다.\n 모임입장을 이용해주세요.");
					new Main_UI(session);
					frameSetVisible();
				}else{
					groupArr = gc.process("GroupListSearch.do", gNtf.getText());

					String[] groups_values = new String[groupArr.size()];
					//
					groupList.removeAllItems();

					for(int i = 0; i < groupArr.size(); i++) {
						groups_values[i] = groupArr.get(i);
						groupList.addItem(groups_values[i]);
						// System.out.println(groups_values[i]);
					}
					//System.out.println(groups[1]);

					//groupList = new JComboBox<>(groups_values);
					groupList.setSelectedIndex(0);
					groupList.setLocation(200, 230);
					groupList.setSize(390, 50);
				}
				}catch(Exception r){
					JOptionPane.showMessageDialog(null, "검색하신 모임장의 모임이 없습니다.\n 다시 입력해주세요.");
				}

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



		//버튼 생성

		JButton btn1 = new JButton("뒤로 가기");
		btn1.setLocation(200, 300);
		btn1.setSize(180, 50);

		JButton btn2 = new JButton("입장하기");
		btn2.setLocation(410, 300);
		btn2.setSize(180, 50);

		//메인프레임에 담기
		//this.add(panel);
		background.add(gNlabel);
		background.add(gNbut);
		background.add(gNtf);
		background.add(lb1);
		background.add(groupList);
		background.add(btn1);
		background.add(btn2);
		this.add(panel);
		clickEvent(btn1, superPanel);

		btn2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(!gNtf.getText().equals("")){
					groupSession = groupList.getItemAt(groupList.getSelectedIndex());
					new GroupJoin_Pw_UI(superFrame, groupSession, session);
					frameSetVisible();

				}else{
					JOptionPane.showMessageDialog(null, "그룹장을 입력하세요.");
					
				}

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
				main_UI(); //수정            
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
		this.remove(this.panel);//현재 패널 지우고
		//this.panel =  loadPanel; //2번 패널 객체를 담음
		this.add(loadPanel); //다시 패널을 올려줌
		this.repaint(); //다시 적용(갱신)

	}

	//수정
	public void main_UI() {      
		superFrame.setVisible(false);//현재 프레임의 비전을끄고
		try {
			superFrame.add(new Main_UI(session)); //새로운 프레임을 만든다.
		} catch (Exception e) {

		}

	}
}