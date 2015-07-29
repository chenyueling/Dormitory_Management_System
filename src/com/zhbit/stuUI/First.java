package com.zhbit.stuUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class First extends JPanel {

	private JLabel labImage;
	private ImageIcon image;
	/**
	 * Create the panel.
	 */
	public First() {
		setSize(800,600);
		setLayout(null);	
	
		image = new ImageIcon("src\\bigImage\\欢迎界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
	}
}
