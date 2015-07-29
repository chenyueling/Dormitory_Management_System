package com.zhbit.managerUI;

import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.*;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.queryResult.AllMaintanceRecord;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View_MR_Stu_It extends JPanel {
	private JTable tableView_MR_Stu_It;
	private JTextField jtfFilter;
	private String MANAGER_ID;
	private Manager manager;
	private JLabel labImage;
	private ImageIcon image;
	private Vector<Object> headvector;
	private DefaultTableModel defaultTableModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JRadioButton radioButton;

	private JTable table;

	private TableRowSorter<TableModel> sorter;
	
	private AllMaintanceRecord allMaintanceRecord =null;
	
	private JFrame jframe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	public View_MR_Stu_It(JFrame jf, Manager m) {
		
		this.jframe = jf;
		this.manager = m;
		this.MANAGER_ID = MANAGER_ID;
		setSize(800,600);
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(32, 129, 732, 252);
		add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer n = table.getSelectedRow();
				textField.setText((String)table.getValueAt(n, 0));
				if(table.getValueAt(n, 11) != "空")
					textField_1.setText((String) table.getValueAt(n, 11));
				else 
					textField_1.setText("");
			//textField_1.setText((String) table.getValueAt(n, 11));
				if(table.getValueAt(n, 9) != "空")
					textField_2.setText((String) table.getValueAt(n, 9));		
				else
					textField_2.setText("");
				}
		});
		
		
		scrollPane.setViewportView(table);
		

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(13);
		defaultTableModel.setRowCount(13);
		defaultTableModel.setValueAt(123, 1, 1);
		
		
		
		//头部信息
		headvector = new Vector<Object>();
		headvector.add("\u7F16\u53F7");
		headvector.add("\u5B66\u53F7");
		headvector.add("\u59D3\u540D");
		headvector.add("\u5BBF\u820D\u697C");
		headvector.add("\u623F\u95F4");
		headvector.add("\u5E8A\u4F4D");
		headvector.add("\u7269\u54C1\u53F7");
		headvector.add("\u7269\u54C1\u540D\u79F0"); 
		headvector.add("\u4FDD\u4FEE\u65F6\u95F4");
		headvector.add("\u7EF4\u4FEE\u65F6\u95F4");
		headvector.add("\u662F\u5426\u7EF4\u4FEE");
		headvector.add("\u7EF4\u4FEE\u5458");
		headvector.add("\u5907\u6CE8");
		
		

		defaultTableModel.setDataVector(null,headvector );
		table.setModel(defaultTableModel);
		table.setFont(new Font("宋体", Font.PLAIN, 15));
	
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);  //自动调整表格列的宽度，不更改其他列的大小，而是更改整个表格的大小
	 
		sorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(sorter);
		
		
		
		JLabel labView_MR_Stu_It = new JLabel("维修记录");
		labView_MR_Stu_It.setFont(new Font("微软雅黑", Font.BOLD, 25));
		labView_MR_Stu_It.setBounds(44, 75, 121, 27);
		add(labView_MR_Stu_It);
		

		final JRadioButton radioButton_1 = new JRadioButton("编号");
		radioButton_1.setOpaque(false);
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(223, 473, 49, 23);
		add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("学号");
		radioButton_2.setOpaque(false);
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(270, 473, 54, 23);
		add(radioButton_2);
		
		final JRadioButton radioButton_3 = new JRadioButton("学生姓名");
		radioButton_3.setOpaque(false);
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(320, 473, 73, 23);
		add(radioButton_3);
		
		final JRadioButton radioButton_4 = new JRadioButton("维修工号");
		radioButton_4.setOpaque(false);
		buttonGroup.add(radioButton_4);
		radioButton_4.setBounds(394, 473, 80, 23);
		add(radioButton_4);
		
		final JRadioButton radioButton_5 = new JRadioButton("所有");
		radioButton_5.setOpaque(false);
		buttonGroup.add(radioButton_5);
		radioButton_5.setBounds(473, 473, 49, 23);
		add(radioButton_5);
		
		
		jtfFilter = new JTextField();
		jtfFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		System.out.println(radioButton_1.isSelected());

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
	
					if( radioButton_1.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 0));
					}else if(radioButton_2.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 1));
					}else if(radioButton_3.isSelected()== true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 2));
					}else if(radioButton_4.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 11));
					}else if(radioButton_5.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text));
					}else {
						JOptionPane.showMessageDialog(jframe, "请选中查询方式" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		jtfFilter.setBounds(93, 474, 121, 21);
		add(jtfFilter);
		jtfFilter.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
	
					if( radioButton_1.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 0));
					}else if(radioButton_2.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 1));
					}else if(radioButton_3.isSelected()== true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 2));
					}else if(radioButton_4.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 11));
					}else if(radioButton_5.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text));
					}else {
						JOptionPane.showMessageDialog(jframe, "请选中查询方式" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
					
				
			}
		});
		btnNewButton.setBounds(350, 502, 69, 23);
		add(btnNewButton);
		
		radioButton = new JRadioButton("只显示未维修");
		radioButton.setOpaque(false);
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
		radioButton.setBounds(643, 473, 106, 23);
		add(radioButton);
		
		JButton button_6 = new JButton("修改选中条维修记录");
		button_6.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
System.out.println(textField.getText().length() +" "+table.getSelectedRow());
				
				if(textField.getText().length() == 0){
					JOptionPane.showMessageDialog(jframe, "未选中行，请将鼠标移至目标行点击。" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				else if(table.getValueAt( table.getSelectedRow(), 10).equals("是") || table.getValueAt( table.getSelectedRow(), 10).equals("是")){
					//此维修记录已经维修，不能更改已经维修的记录
					JOptionPane.showMessageDialog(jframe, "此维修记录已经维修，不能更改已经维修的记录" , "系统信息", JOptionPane.WARNING_MESSAGE);
		//          return;
				}else if(textField_1.getText().length() == 0){
					JOptionPane.showMessageDialog(jframe, "未填写维修员ID" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}else if(textField_2.getText().length() < 10){
					JOptionPane.showMessageDialog(jframe, "请按规定填写日期，格式如（2013-01-01）" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}else{
					if(updateRecord() == true){
						
				//		System.out.println(textField_1.getText());
						
						String s = "是";
						table.setValueAt(textField_2.getText(), table.getSelectedRow(), 9);
						table.setValueAt(s, table.getSelectedRow(), 10);
						table.setValueAt(textField_1.getText(), table.getSelectedRow(), 11);
						
						JOptionPane.showMessageDialog(jframe, "修改成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
	
			}
		});
		button_6.setBounds(489, 412, 149, 23);
		add(button_6);
		
		JLabel label = new JLabel("编号");
		label.setBounds(64, 416, 24, 15);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(93, 413, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("维修员");
		label_1.setBounds(169, 416, 54, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 413, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("维修时间");
		label_2.setBounds(290, 416, 54, 15);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(350, 413, 129, 21);
		add(textField_2);
		textField_2.setColumns(10);
		

		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
		
		try {
			allMaintanceRecord = manager.getAllMaintanceRecord();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			JOptionPane.showMessageDialog(jframe, "数据库连接错误，请重新登录" , "系统信息", JOptionPane.WARNING_MESSAGE);
		} catch (QueryResultIsNullException e1){
			
		}
		
	}
	
	
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
//data = allMaintanceRecord.getAllMaintanceRecord();
//System.out.println(allMaintanceRecord.getAllMaintanceRecord());
		 defaultTableModel.setDataVector(allMaintanceRecord.getAllMaintanceRecord(),headvector);
		 
	}
	
	
	public boolean updateRecord(){
		int Record;
		String MainId;
		String Data;
		
		Record = Integer.parseInt( textField.getText() );
		MainId = textField_1.getText();
		Data = textField_2.getText();
		
		return allMaintanceRecord.updateMaintanceRecord(Record, MainId, Data);
		
	}
}
