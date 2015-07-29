package com.zhbit.stuUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class About extends JPanel {
	
	
	private JLabel labImage;
	private ImageIcon image;
	/**
	 * Create the panel.
	 */
	public About() {
		setBackground(new Color(255, 255, 255));
		setSize(800,600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(About.class.getResource("/bigImage/图标.png")));
		lblNewLabel.setBounds(110, 206, 200, 232);
		add(lblNewLabel);
		
		JLabel label = new JLabel("关于宿舍管理系统");
		label.setFont(new Font("宋体", Font.BOLD, 31));
		label.setBounds(248, 58, 305, 72);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("宿舍管理系统5.0正式版");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 28));
		lblNewLabel_1.setBounds(352, 207, 376, 59);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("制作人：廖瑞华  陈岳凌");
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 28));
		lblNewLabel_2.setBounds(352, 281, 386, 72);
		add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("洪惜玉 尧莉菁 鲜璐");
		label_1.setFont(new Font("楷体", Font.BOLD, 28));
		label_1.setBounds(433, 366, 295, 72);
		add(label_1);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
	}

}
