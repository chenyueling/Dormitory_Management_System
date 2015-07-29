package com.zhbit.managerUI;


import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class StuKuaidi extends JPanel {
	private JTable table;
	private JTextField textField;
	private String MANAGER_ID;
	private ImageIcon image;
	private JLabel labImage;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField jtfFilter;
	private JTextField textField_4;
	private JTextField textField_5;
	private JRadioButton radioButton_7;
	private Manager manager;
	private Vector<Object> headvector;
	private Vector<Object> Datavector;
	
	/**
	 * Create the panel.
	 */
	/*
	public StuKuaidi(){
		
	}
	*/

	private DefaultTableModel defaultTableModel;
	private TableRowSorter<TableModel> sorter;
	private JFrame jframe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_6;
	private JTextField textField_7;
	
	
	public StuKuaidi(JFrame jf, Manager m) {
		this.jframe = jf;
		this.manager = m;
		
		this.MANAGER_ID = MANAGER_ID;
		
		setLayout(null);
		
		JLabel label = new JLabel("快递记录表");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(38, 55, 155, 34);
		add(label);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(39, 110, 727, 231);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer n = table.getSelectedRow();
				
//System.out.println(table.getValueAt(n, 0));
				
				textField.setText((String)table.getValueAt(n, 0));
				textField_1.setText((String) table.getValueAt(n, 5));
				
				if(table.getValueAt(n, 9) != "空")
					textField_2.setText((String) table.getValueAt(n, 9));		
				else
					textField_2.setText("");
				}
		});
		
		scrollPane.setViewportView(table);
		
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(11);
		defaultTableModel.setRowCount(11);
		defaultTableModel.setValueAt(123, 1, 1);
		
		
		
		//头部信息
		headvector = new Vector<Object>();
		headvector.add("\u8BB0\u5F55\u53F7");
		headvector.add("\u516C\u53F8\u540D");
		headvector.add("\u5BBF\u820D\u697C");
		headvector.add("\u623F\u95F4");
		headvector.add("\u5B66\u53F7");
		headvector.add("\u5B66\u751F\u59D3\u540D");
		headvector.add("\u8054\u7CFB\u7535\u8BDD");
		headvector.add( "\u662F\u5426\u9886\u53D6"); 
		headvector.add("\u5230\u4EF6\u65E5\u671F");
		headvector.add("\u9886\u53D6\u65E5\u671F");
		headvector.add("\u5907\u6CE8");


		defaultTableModel.setDataVector(null,headvector );
		table.setModel(defaultTableModel);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("宋体", Font.PLAIN, 15));
		//table.setForeground(Color.PINK);
		
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);  //自动调整表格列的宽度，不更改其他列的大小，而是更改整个表格的大小
		
		sorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(sorter);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(82, 351, 61, 21);
		add(textField);
		textField.setColumns(20);
		JButton button = new JButton("领取快递");
		button.setBounds(603, 350, 105, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//System.out.println(textField.getText().length() +" "+table.getSelectedRow());
//System.out.println(table.getValueAt(table.getSelectedRow(), 7));

				if(textField.getText().length() == 0){
					JOptionPane.showMessageDialog(jframe, "未选中行，请将鼠标移至目标行点击。" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				else if(table.getValueAt( table.getSelectedRow(), 7).equals("是") || table.getValueAt( table.getSelectedRow(), 7).equals("是")){
					JOptionPane.showMessageDialog(jframe, "此快递已经领取" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}else if(textField_2.getText().length() < 10){
					JOptionPane.showMessageDialog(jframe, "请按规定填写日期，格式如（2013-01-01）" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}else{
					
					if(updateRecord() == true){
			//System.out.println(textField.getText());
						
						String s = "是";
						table.setValueAt(textField_2.getText(), table.getSelectedRow(), 9);
						table.setValueAt(s, table.getSelectedRow(), 7);
					
						
						JOptionPane.showMessageDialog(jframe, "修改成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		

		
		JLabel label_1 = new JLabel("记录号");
		label_1.setBounds(38, 354, 49, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("姓名");
		label_2.setBounds(162, 354, 54, 15);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(199, 351, 89, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("领取日期");
		label_3.setBounds(313, 354, 54, 15);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(377, 351, 150, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		jtfFilter = new JTextField();
		jtfFilter.setBounds(38, 407, 103, 21);
		add(jtfFilter);
		jtfFilter.setColumns(10);
		
		final JRadioButton radioButton_1 = new JRadioButton("记录号");
		radioButton_1.setOpaque(false);
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(147, 406, 61, 23);
		add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("学号");
		radioButton_2.setOpaque(false);
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(212, 406, 49, 23);
		add(radioButton_2);
		
		final JRadioButton radioButton_3 = new JRadioButton("姓名");
		radioButton_3.setOpaque(false);
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(263, 406, 54, 23);
		add(radioButton_3);
		
		final JRadioButton radioButton_4 = new JRadioButton("房间号");
		radioButton_4.setOpaque(false);
		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(319, 406, 68, 23);
		add(radioButton_4);
		
		final JRadioButton radioButton_5 = new JRadioButton("快递公司");
		radioButton_5.setOpaque(false);
		buttonGroup.add(radioButton_5);
		radioButton_5.setBounds(388, 406, 82, 23);
		add(radioButton_5);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
	
					if( radioButton_1.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 0));
					}else if(radioButton_2.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 4));
					}else if(radioButton_3.isSelected()== true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 5));
					}else if(radioButton_4.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 3));
					}else if(radioButton_5.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 1));
					}else {
						JOptionPane.showMessageDialog(jframe, "请选中查询方式" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		button_1.setBounds(482, 406, 93, 23);
		add(button_1);
		
		radioButton_7 = new JRadioButton("只显示未领取快递");
		radioButton_7.setOpaque(false);
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "否";
				if(radioButton_7.isSelected()==false){
					sorter.setRowFilter(null);
				}
				else{
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
		radioButton_7.setBounds(644, 406, 121, 23);
		add(radioButton_7);
		
		JLabel label_4 = new JLabel("公司名");
		label_4.setBounds(38, 468, 54, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("学  号");
		label_5.setBounds(38, 499, 40, 15);
		add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(82, 465, 103, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(82, 493, 103, 21);
		add(textField_5);
		textField_5.setColumns(10);

		JLabel label_6 = new JLabel("到件日期");
		label_6.setBounds(199, 468, 49, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("备    注");
		label_7.setBounds(199, 496, 49, 15);
		add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(251, 465, 103, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(251, 493, 103, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_2 = new JButton("添加到件信息");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Cmid, StuId, Data, Mark;
				
				if(insertRecord() == true){
		//System.out.println(textField.getText());
	
					try {
						showInfo();
					} catch (DataBaseException | QueryResultIsNullException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(jframe, "刷新失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
					
					JOptionPane.showMessageDialog(jframe, "添加成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		button_2.setBounds(388, 492, 120, 23);
		add(button_2);
		
		JButton button_3 = new JButton("刷新");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					showInfo();
					sorter.setRowFilter(null);
				} catch (DataBaseException | QueryResultIsNullException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "刷新失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_3.setBounds(603, 492, 93, 23);
		add(button_3);
		

		ImageIcon image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
	}
	

	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
		Datavector = manager.getAllExpressInfo(manager.getDormId());
		 defaultTableModel.setDataVector(Datavector,headvector);
		 
	}
	
	public boolean insertRecord(){
		String Cmid, StuId, Data, Mark;
		
		Cmid = textField_4.getText();
		StuId = textField_5.getText();
		Data = textField_6.getText();
		Mark = textField_7.getText();
		
		return manager.insertRecord(Cmid, StuId, Data, Mark);
		
	}
	
	public boolean updateRecord(){
		int Record;
	
		String Data;
		
		Record = Integer.parseInt( textField.getText() );
	
		Data = textField_2.getText();
		
		return manager.updateExpressTransceiver(Record, Data);
		
	}
	
}
