package com.zhbit.stuUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import com.zhbit.entity.*;

public class StuPassword extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel labImage;
	private String STUDENT_ID;
	private ImageIcon image;
	private Student student;
	/**
	 * Create the panel.
	 */
	public StuPassword()
	{
	}	
	public StuPassword(Student s) {
		this.student = s;
		setSize(800,600);
		setLayout(null);
		
		JLabel labjiumima = new JLabel("旧 密 码");
		labjiumima.setFont(new Font("宋体", Font.PLAIN, 16));
		labjiumima.setBounds(168, 111, 87, 34);
		add(labjiumima);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(264, 111, 198, 29);
		add(passwordField);
		
		JLabel labxinmima = new JLabel("新 密 码");
		labxinmima.setFont(new Font("宋体", Font.PLAIN, 16));
		labxinmima.setBounds(168, 204, 80, 15);
		add(labxinmima);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(265, 193, 198, 29);
		add(passwordField_1);
		
		JLabel labqueren = new JLabel("确定密码");
		labqueren.setFont(new Font("宋体", Font.PLAIN, 16));
		labqueren.setBounds(168, 289, 80, 15);
		add(labqueren);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(264, 278, 198, 29);
		add(passwordField_2);
		
		JButton buttonqueding = new JButton("确定");
		buttonqueding.setFont(new Font("宋体", Font.PLAIN, 15));
		buttonqueding.setBounds(344, 488, 93, 34);
		add(buttonqueding);
		
		JButton buttonchongzhi = new JButton("重置");
		buttonchongzhi.setFont(new Font("宋体", Font.PLAIN, 15));
		buttonchongzhi.setBounds(493, 488, 93, 34);
		add(buttonchongzhi);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		
		this.setOpaque(false);

	}
}
