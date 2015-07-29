package com.zhbit.managerUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class mhelpText extends JPanel {

	private JLabel labImage;
	private ImageIcon image;
	
	/**
	 * Create the panel.
	 */
	public mhelpText() {
		setSize(800,600);
		setLayout(null);
		
		JLabel label = new JLabel("一、用户管理");
		label.setBounds(69, 72, 536, 29);
		add(label);
		
		JLabel label_1 = new JLabel("点击“修改”按钮，就可以修改自己的电话号码");
		label_1.setBounds(112, 125, 536, 29);
		add(label_1);
		
		JLabel label_2 = new JLabel("2、密码修改");
		label_2.setBounds(89, 152, 536, 29);
		add(label_2);
		
		JLabel label_3 = new JLabel("1、个人信息");
		label_3.setBounds(89, 97, 536, 29);
		add(label_3);
		
		JLabel label_4 = new JLabel("输入新旧密码确认，若输入的旧密码和旧密码相等，则修改成功，否则失败。");
		label_4.setBounds(112, 178, 536, 29);
		add(label_4);
		
		JLabel label_5 = new JLabel("二、寝室管理");
		label_5.setBounds(69, 205, 536, 29);
		add(label_5);
		
		JLabel label_6 = new JLabel("1、宿舍楼信息");
		label_6.setBounds(89, 232, 536, 29);
		add(label_6);
		
		JLabel label_7 = new JLabel("点击便可看到用户所管宿舍楼的信息");
		label_7.setBounds(112, 257, 536, 29);
		add(label_7);
		
		JLabel label_8 = new JLabel("2、宿舍分配信息");
		label_8.setBounds(89, 285, 536, 29);
		add(label_8);
		
		JLabel label_9 = new JLabel("在宿舍那里选择舍长或者宿舍员，填写学号入住日期，点击学生入住便可。在查查");
		label_9.setBounds(112, 311, 536, 29);
		add(label_9);
		
		JLabel label_10 = new JLabel("询旁边的文本框填写随机列的字段，点击查询便可。其他类似。");
		label_10.setBounds(99, 337, 536, 29);
		add(label_10);
		
		JLabel label_11 = new JLabel("三、信息查询");
		label_11.setBounds(69, 362, 536, 29);
		add(label_11);
		
		JLabel label_12 = new JLabel("1、学生信息查询");
		label_12.setBounds(89, 387, 536, 29);
		add(label_12);
		
		JLabel label_13 = new JLabel("在查询按钮旁边的文本框写随机列的字段，便可显示相应的消息。");
		label_13.setBounds(112, 411, 536, 29);
		add(label_13);
		
		JLabel label_14 = new JLabel("2、夜归信息");
		label_14.setBounds(89, 438, 536, 29);
		add(label_14);
		
		JLabel label_15 = new JLabel("添加夜归记录：在下面的文本框填写相应的信息，点击“添加夜归记录”即可。");
		label_15.setBounds(112, 461, 536, 29);
		add(label_15);
		
		JLabel label_16 = new JLabel("查询：与上一样。");
		label_16.setBounds(112, 488, 536, 29);
		add(label_16);
		
		JLabel label_17 = new JLabel("其他界面类似。");
		label_17.setBounds(89, 516, 536, 29);
		add(label_17);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
	}
}
