package com.zhbit.stuUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class shelpText extends JPanel {
	
	ImageIcon image;
	JLabel labImage;
	
	/**
	 * Create the panel.
	 */
	public shelpText() {
		setSize(800,600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("一、用户管理");
		lblNewLabel.setBounds(91, -27, 153, 27);
		add(lblNewLabel);
		
		JLabel label = new JLabel("1、学生信息管理");
		label.setBounds(102, 97, 153, 27);
		add(label);
		
		JLabel label_1 = new JLabel("点击修改便可修改自己的手机号码和籍贯");
		label_1.setBounds(111, 119, 216, 27);
		add(label_1);
		
		JLabel label_2 = new JLabel("2、修改密码");
		label_2.setBounds(101, 145, 216, 27);
		add(label_2);
		
		JLabel label_3 = new JLabel("输入旧新密码便可修改");
		label_3.setBounds(111, 170, 216, 27);
		add(label_3);
		
		JLabel label_4 = new JLabel("二、信息查询");
		label_4.setBounds(91, 197, 216, 27);
		add(label_4);
		
		JLabel label_5 = new JLabel("1、维修信息");
		label_5.setBounds(101, 223, 216, 27);
		add(label_5);
		
		JLabel label_6 = new JLabel("表格如果想看后面被挡住的信息，可以拉动下面的滚动条，也可以在用鼠标放在列与列");
		label_6.setBounds(111, 250, 464, 27);
		add(label_6);
		
		JLabel label_7 = new JLabel("查询快件：点击“只显示未领取快递”便可仅仅显示未领取的快递消息；若查询快递公司，");
		label_7.setBounds(111, 451, 484, 27);
		add(label_7);
		
		JLabel label_8 = new JLabel("之间调节列距。下面的文本框可以输入任何列的内容，点击查询按钮便可显示相应的消息。");
		label_8.setBounds(91, 274, 488, 27);
		add(label_8);
		
		JLabel label_9 = new JLabel("“只显示未维修”便可仅仅显示未维修的消息。下面的下拉框是物品报修的物品，选择");
		label_9.setBounds(111, 300, 488, 27);
		add(label_9);
		
		JLabel label_10 = new JLabel("要报修的物品，填写备注，点击“添加报修”按钮，点击“刷新”按钮，便可看到自己刚才");
		label_10.setBounds(91, 326, 488, 27);
		add(label_10);
		
		JLabel label_11 = new JLabel("报修的信息。");
		label_11.setBounds(91, 351, 488, 27);
		add(label_11);
		
		JLabel label_12 = new JLabel("表格的显示跟维修信息一样。");
		label_12.setBounds(111, 401, 488, 27);
		add(label_12);
		
		JLabel label_13 = new JLabel("2、快递信息");
		label_13.setBounds(101, 376, 216, 27);
		add(label_13);
		
		JLabel label_14 = new JLabel("签收快件：在日期旁边的文本框填上日期点击签收便可签收快件。");
		label_14.setBounds(111, 427, 488, 27);
		add(label_14);
		
		JLabel label_15 = new JLabel("可以不写全名，后点击查询；若查询日期，需输入月-日的格式，后点击查询；若通过记录号，");
		label_15.setBounds(91, 476, 504, 27);
		add(label_15);
		
		JLabel label_16 = new JLabel("则直接输入记录号后点击查询。");
		label_16.setBounds(91, 502, 504, 27);
		add(label_16);
		
		JLabel label_17 = new JLabel("一、用户管理");
		label_17.setBounds(91, 73, 216, 27);
		add(label_17);
	
		ImageIcon image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		
		
	}
}
