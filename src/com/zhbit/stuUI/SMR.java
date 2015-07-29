package com.zhbit.stuUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

public class SMR extends JPanel {
	private JTable tableSMR;
	private JTextField textField;
	private ImageIcon image;
	private Student student;
	private DefaultTableModel defaultTableModel;
	private Vector<Object> headVector;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */

	private JLabel labImage;
	private JRadioButton radioButton;

	private TableRowSorter<TableModel> sorter;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JComboBox comboBox;
	private JButton button_2;
	private JFrame jframe;

	private Vector<Object> comv = null;
	
	public SMR(JFrame jf, Student stu) {
		this.student = stu;
		this.jframe = jf;
		setSize(800,600);
		setLayout(null);
		
		JLabel label = new JLabel("维修信息");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(112, 53, 100, 34);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 113, 673, 308);
		add(scrollPane);
		
		tableSMR = new JTable();
		scrollPane.setViewportView(tableSMR);
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(15);
		defaultTableModel.setRowCount(11);
		defaultTableModel.setValueAt(123, 1, 1);
		headVector = new Vector<Object>();
		headVector.add("记录号");
		headVector.add("学号");
		headVector.add("姓名");
		headVector.add("宿舍楼号");
		headVector.add("宿舍号");
		headVector.add("床号");
		headVector.add("物品号");
		headVector.add("物品名称");
		headVector.add("报修日期");
		headVector.add("维修日期");
		headVector.add("是否维修");
		headVector.add("维修员");
		headVector.add("备注");
		defaultTableModel.setDataVector(null, headVector);
		tableSMR.setModel(defaultTableModel);
		
		tableSMR.setAutoResizeMode(tableSMR.AUTO_RESIZE_OFF);  //自动调整表格列的宽度，不更改其他列的大小，而是更改整个表格的大小
		scrollPane.setViewportView(tableSMR);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		sorter = new TableRowSorter<TableModel>(tableSMR.getModel());
		
		tableSMR.setRowSorter(sorter);
		
		
		radioButton = new JRadioButton("只显示未维修");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "否";
				if(radioButton.isSelected()==false){
					sorter.setRowFilter(null);
				}
				else{
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
		
		radioButton.setOpaque(false);
		
		radioButton.setBounds(430, 467, 100, 23);
		add(radioButton);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = textField_1.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
		 		
			}
		});
		textField_1.setBounds(112, 468, 100, 21);
		add(textField_1);
		textField_1.setColumns(10);
		/*
		JRadioButton radioButton_1 = new JRadioButton("维修物品");
		radioButton_1.setBounds(300, 468, 81, 23);
		add(radioButton_1);
		*/
	
	/*	
		JRadioButton radioButton_2 = new JRadioButton("维修日期");
		radioButton_2.setBounds(381, 468, 81, 23);
		add(radioButton_2);
		*/
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = textField_1.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
		 	
			}
		});
		button.setBounds(222, 467, 57, 23);
		add(button);
		
		

		
		textField_2 = new JTextField();
		textField_2.setBounds(289, 526, 131, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		
		Vector v = new Vector();
		
		
		try {
			comv = getItem();
			
			for(int i=1; i <= comv.size(); i++){
				v.add(i);
			}
			
		//	System.out.println(comv);
			
			comboBox = new JComboBox();
			//comboBox.add(comboBox, 1);
			comboBox.setModel(new DefaultComboBoxModel(v));
			comboBox.setBounds(222, 526, 57, 21);
			add(comboBox);
			
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					
					textField_2.setText(comv.get((int) comboBox.getSelectedItem()-1).toString());
					
				}
			});
			
	
			
		} catch (DataBaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String s;
		s = comboBox.getSelectedItem().toString();
		textField_2.setText(comv.get(0).toString());
		
		JLabel label_1 = new JLabel("备注");
		label_1.setBounds(430, 529, 54, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(466, 526, 174, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_1 = new JButton("添加报修");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					insetItemMa();
				} catch (DataBaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "添加失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				JOptionPane.showMessageDialog(jframe,"添加成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
				
			}
		});
		button_1.setBounds(119, 525, 93, 23);
		add(button_1);
		

		
		button_2 = new JButton("刷新");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					showInfo();
				} catch (DataBaseException | QueryResultIsNullException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "刷新失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_2.setBounds(571, 467, 93, 23);
		add(button_2);
		

		ImageIcon image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
	}

	public void showInfo() throws DataBaseException, QueryResultIsNullException{
	//	System.out.println(student.getMaintenanceRecord());
		defaultTableModel.setDataVector(student.getMaintenanceRecord(), headVector);
	}
	
	
	public Vector<Object> getItem() throws DataBaseException{
		
		return student.getItem();
	}
	
	public boolean insetItemMa() throws DataBaseException{
		String item, rmark, bedNum, dormId, id,  roomId;
		id = student.getId();
		dormId = student.getDormID();
		roomId = student.getRoomID();
		bedNum = student.getBedNum();
		rmark = textField_3.getText();
		String itemId;

		itemId = comboBox.getSelectedItem().toString();
		
		if(itemId.compareTo("9") <= 0 ){
			itemId = "0"+itemId;
		}
	//System.out.println(itemId);
		
	//System.out.println(itemId);			
	
		return student.insertItemMa(id, dormId, roomId, bedNum, itemId, rmark);
	}
	
}
