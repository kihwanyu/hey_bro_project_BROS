package View;

import java.awt.Font;

import javax.swing.*;

import Model.vo.Session;

public class ScheduleRegister extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1438654689820281120L;
	private JPanel mp = new JPanel();
	private Session session = new Session();
	private String year;
	private String month;
	private String date;

	public ScheduleRegister(Session session, String year, String month, String date){
		this.session = session;
		this.year = year;
		this.month = month;
		this.date = date;
		
		this.setBounds(100, 50, 800, 500);
		this.setLayout(null);
		mp.setSize(800, 500);
		mp.setLayout(null);
		//â Ÿ��Ʋ
		JLabel titleL = new JLabel("���� �߰�");
		titleL.setFont(new Font(Font.DIALOG, Font.BOLD, 26));
		titleL.setBounds(150, 30, 120, 50);

		//�����Է� �󺧰� �ؽ�Ʈ�ʵ�
		JLabel tftitle = new JLabel("���� �Է� : ");
		tftitle.setBounds(160, 90, 120, 30);
		JTextField titleTf = new JTextField();
		titleTf.setBounds(280, 90, 320, 30);

		//�����Է� �󺧰� �ؽ�Ʈ �ʵ�
		JLabel contentsL = new JLabel("���� �Է�");
		contentsL.setBounds(350, 130, 120, 30);
		JTextField contentsTf = new JTextField();
		contentsTf.setBounds(140, 170, 460, 200);

		//���۽ð� ��
		JLabel startL = new JLabel("���� �ð�");
		startL.setBounds(160, 370, 120, 50);
		//���� �ð� �� ��
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
		//����ð� ��
		JLabel endL = new JLabel("���� �ð�");
		endL.setBounds(390, 370, 120,50);
		//���� �ð� �� ��
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

	/*   public static void main(String[] args) {
      ScheduleRegister s = new ScheduleRegister();
      s.scheduleRegister();

   }*/

}