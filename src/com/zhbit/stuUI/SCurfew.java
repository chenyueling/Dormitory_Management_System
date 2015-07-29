package com.zhbit.stuUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

import java.awt.Font;
import java.util.Vector;

public class SCurfew extends JPanel {
	private JTable table;
	private Student student;
	private JLabel labImage;
	private ImageIcon image;
	private DefaultTableModel defaultTableModel;
	private Vector<Object> headVector;
	/**
	 * Create the panel.
	 */
	public SCurfew() {
		
	}
	public SCurfew(Student student) {
		// TODO Auto-generated constructor stub
		this.student = student;
		setSize(800,600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 153, 558, 298);
		add(scrollPane);
		
		table = new JTable();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(20);
		defaultTableModel.setRowCount(6);
		defaultTableModel.setValueAt(123, 1, 1);
		headVector = new Vector<Object>();
		headVector.add("记录号");
		headVector.add("夜归时间");
		headVector.add("第几次夜归");
		headVector.add("夜归原因");
		headVector.add("值班宿管");
		defaultTableModel.setDataVector(null,headVector);
		table.setModel(defaultTableModel);
			
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("夜归记录");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblNewLabel.setBounds(109, 79, 168, 39);
		add(lblNewLabel);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		defaultTableModel.setDataVector(student.getPersonalCurfewInfo(), headVector);
	}
	
}
