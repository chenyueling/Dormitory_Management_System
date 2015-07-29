package com.zhbit.managerUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class StuInOut_Add extends JPanel {
	private JTextField txtRecordNum;
	private JTextField txtStuID;
	private JTextField txtStuName;
	private JTextField txtDormId;
	private JTextField textField_4;
	private JTextField txtRoomId;
	private JTextField txtBedId;
	private JTextField textField_7;
	
	private String STUDENT_ID;
	private JLabel labImage;
	private ImageIcon image;
	/**
	 * Create the panel.
	 */
	
	
	public StuInOut_Add(String STUDENT_ID) {
		setSize(800,600);
		setLayout(null);
		
		JLabel label = new JLabel("学生入住\\退宿登记");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(81, 107, 223, 34);
		add(label);
		
		JLabel labRecordNum = new JLabel("记录号");
		labRecordNum.setFont(new Font("宋体", Font.PLAIN, 15));
		labRecordNum.setBounds(100, 178, 54, 18);
		add(labRecordNum);
		
		JLabel labStuID = new JLabel("学号");
		labStuID.setFont(new Font("宋体", Font.PLAIN, 15));
		labStuID.setBounds(100, 243, 54, 18);
		add(labStuID);
		
		JLabel labStuName = new JLabel("姓名");
		labStuName.setFont(new Font("宋体", Font.PLAIN, 15));
		labStuName.setBounds(100, 303, 54, 18);
		add(labStuName);
		
		JLabel labDormId = new JLabel("宿舍楼号");
		labDormId.setFont(new Font("宋体", Font.PLAIN, 15));
		labDormId.setBounds(94, 363, 60, 18);
		add(labDormId);
		
		JLabel labRemark = new JLabel("备注（原因）");
		labRemark.setFont(new Font("宋体", Font.PLAIN, 15));
		labRemark.setBounds(94, 420, 93, 18);
		add(labRemark);
		
		JLabel labRoomId = new JLabel("宿舍号");
		labRoomId.setFont(new Font("宋体", Font.PLAIN, 15));
		labRoomId.setBounds(421, 178, 54, 18);
		add(labRoomId);
		
		JLabel labBedId = new JLabel("床号");
		labBedId.setFont(new Font("宋体", Font.PLAIN, 15));
		labBedId.setBounds(421, 243, 54, 18);
		add(labBedId);
		
		JLabel labDate = new JLabel("日期");
		labDate.setFont(new Font("宋体", Font.PLAIN, 15));
		labDate.setBounds(421, 303, 54, 18);
		add(labDate);
		
		JLabel labIn_Out = new JLabel("出/入");
		labIn_Out.setFont(new Font("宋体", Font.PLAIN, 15));
		labIn_Out.setBounds(421, 363, 54, 18);
		add(labIn_Out);
		
		txtRecordNum = new JTextField();
		txtRecordNum.setBounds(184, 177, 214, 21);
		add(txtRecordNum);
		txtRecordNum.setColumns(10);
		
		txtStuID = new JTextField();
		txtStuID.setColumns(10);
		txtStuID.setBounds(184, 242, 214, 21);
		add(txtStuID);
		
		txtStuName = new JTextField();
		txtStuName.setColumns(10);
		txtStuName.setBounds(184, 302, 214, 21);
		add(txtStuName);
		
		txtDormId = new JTextField();
		txtDormId.setColumns(10);
		txtDormId.setBounds(184, 362, 214, 21);
		add(txtDormId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(184, 419, 515, 21);
		add(textField_4);
		
		txtRoomId = new JTextField();
		txtRoomId.setColumns(10);
		txtRoomId.setBounds(485, 177, 214, 21);
		add(txtRoomId);
		
		txtBedId = new JTextField();
		txtBedId.setColumns(10);
		txtBedId.setBounds(485, 242, 214, 21);
		add(txtBedId);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(485, 302, 214, 21);
		add(textField_7);
		
		JButton butCancel = new JButton("取消");
		butCancel.setFont(new Font("宋体", Font.PLAIN, 15));
		butCancel.setBounds(606, 480, 93, 23);
		add(butCancel);
		
		JButton butOk = new JButton("确认");
		butOk.setFont(new Font("宋体", Font.PLAIN, 15));
		butOk.setBounds(503, 480, 93, 23);
		add(butOk);
		
		JRadioButton rbIn = new JRadioButton("入住");
		rbIn.setFont(new Font("宋体", Font.PLAIN, 15));
		rbIn.setBounds(507, 361, 60, 23);
		add(rbIn);
		
		JRadioButton rbOut = new JRadioButton("退宿");
		rbOut.setFont(new Font("宋体", Font.PLAIN, 15));
		rbOut.setBounds(610, 361, 60, 23);
		add(rbOut);
		

        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
}
