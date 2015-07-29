package com.zhbit.managerUI;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import com.zhbit.entity.Manager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class StuOut extends JPanel{
	public StuOut() {
		setLayout(null);
		
		JLabel label = new JLabel("学生退宿登记");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(105, 79, 164, 34);
		add(label);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(105, 238, 37, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(143, 235, 126, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setBounds(293, 234, 57, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 138, 509, 60);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
	}
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
	private Manager manager;
	private JFrame jframe;
	private JTextField textField;
	private JTable table;
	
	public StuOut(JFrame jf, Manager m){
		this.jframe = jf;
		this.manager = m;
		
		setSize(800,600);
		setLayout(null);
		


        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
}
