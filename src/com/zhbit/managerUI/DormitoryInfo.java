package com.zhbit.managerUI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.queryResult.AllDormitoryInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DormitoryInfo extends JPanel {
	private JTable tableDormitoryInfo;
	private JTextField jtfFilter;
	private String MANAGER_ID;
	private Manager manager;
	private JLabel labImage;
	private ImageIcon image;
	private DefaultTableModel defaultTableModel;
	private Vector<Object> headvector;
	private TableRowSorter<TableModel> sorter;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox ;
	private JLabel label_3;
	private JTextField textField_4;
	private JFrame jframe;
	private AllDormitoryInfo allDormitoryInfo = null;
	private JTextField textField_5;
	private JButton button_2;
	private JLabel label_4;
	private JButton button_3;
	private JLabel label_5;
	private JTextField textField_6;
	
	/**
	 * Create the panel.
	 */
	
	
	public DormitoryInfo(JFrame jf, Manager m) {
		this.jframe = jf;
		this.manager = m;
		setSize(800,600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	//	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(85, 130, 619, 300);
		add(scrollPane);
		
		tableDormitoryInfo = new JTable();
		
		
		tableDormitoryInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer n = tableDormitoryInfo.getSelectedRow();
				textField.setText((String)tableDormitoryInfo.getValueAt(n, 0));
				textField_1.setText((String) tableDormitoryInfo.getValueAt(n, 1));
		}});
		
		
		scrollPane.setViewportView(tableDormitoryInfo);
		
	
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(8);
		defaultTableModel.setRowCount(10);
		defaultTableModel.setValueAt(123, 1, 1);
		
		//头部信息
		headvector = new Vector<Object>();
		headvector.add("宿舍楼Id");
		headvector.add("宿舍号");
		headvector.add("舍长");
		headvector.add("舍员1");
		headvector.add("舍员2");
		headvector.add("舍员3");
		headvector.add("实住人数");
		headvector.add("容纳人数"); 
		
		defaultTableModel.setDataVector(null,headvector );
		
		
		tableDormitoryInfo.setModel(defaultTableModel);
		tableDormitoryInfo.setFont(new Font("宋体", Font.PLAIN, 15));
		
		tableDormitoryInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		
		sorter = new TableRowSorter<TableModel>(tableDormitoryInfo.getModel());
		tableDormitoryInfo.setRowSorter(sorter);
		
		
		JLabel labDormitoryInfo = new JLabel("具体宿舍楼信息表");
		labDormitoryInfo.setFont(new Font("微软雅黑", Font.BOLD, 25));
		labDormitoryInfo.setBounds(72, 63, 222, 34);
		add(labDormitoryInfo);
		
		jtfFilter = new JTextField();
		jtfFilter.setFont(new Font("宋体", Font.PLAIN, 15));
		jtfFilter.setColumns(10);
		jtfFilter.setBounds(128, 485, 137, 21);
		add(jtfFilter);
		jtfFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
			}
		});

		JButton butSelect = new JButton("查询");
		butSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = jtfFilter.getText();
				
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));	
			}
		});
		butSelect.setFont(new Font("宋体", Font.PLAIN, 15));
		butSelect.setBounds(273, 485, 93, 23);
		add(butSelect);
		
		
		JLabel label = new JLabel("宿舍楼");
		label.setBounds(85, 457, 54, 15);
		add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(128, 454, 39, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("房间");
		label_1.setBounds(177, 457, 54, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(212, 454, 39, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"舍长", "舍员1", "舍员2", "舍员3"}));
		comboBox.setBounds(263, 454, 66, 21);
		add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(340, 454, 124, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("学生入住");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					int a = insertStu();
					if(a == 0){
						JOptionPane.showMessageDialog(jframe, "入住成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}else if(a == 6) 
						JOptionPane.showMessageDialog(jframe, "入住失败，此学生可能已经入住其他宿舍，请重新填写信息" , "系统信息", JOptionPane.WARNING_MESSAGE);
				} catch (HeadlessException | DataBaseException
						| QueryResultIsNullException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "入住失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		button.setBounds(632, 453, 93, 23);
		add(button);
		
		JLabel label_2 = new JLabel("入住日期");
		label_2.setBounds(471, 457, 54, 15);
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(525, 454, 97, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		
		
		
		label_3 = new JLabel("备  注");
		label_3.setBounds(410, 487, 39, 15);
		add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(459, 485, 163, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button_1 = new JButton("刷    新");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(632, 536, 93, 23);
		add(button_1);

		textField_5 = new JTextField();
		textField_5.setBounds(128, 519, 137, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		button_2 = new JButton("查询该学生");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int [] a = {2,3,4,5};
				
				String text = "";
				
				
					try {
						if(textField_5.getText().length() == 12)
							text = getName(textField_5.getText());
						else 
							JOptionPane.showMessageDialog(jframe, "学号为12位数字，重新填写。" , "系统信息", JOptionPane.WARNING_MESSAGE);	
					
					} catch (DataBaseException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(jframe, "数据库错误，查询失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				
					
					if(text.trim().length()==0)
						sorter.setRowFilter(null);
					else{
						sorter.setRowFilter(RowFilter.regexFilter(text));	
						JOptionPane.showMessageDialog(jframe, "该学生信息显示在上表中，如无结果即是该生无入住信息。请重新填写学号" , "系统信息", JOptionPane.WARNING_MESSAGE);	
						
					}
					
					
			}
		});
		button_2.setBounds(273, 518, 93, 23);
		add(button_2);
		
		label_4 = new JLabel("学  号");
		label_4.setBounds(85, 522, 39, 15);
		add(label_4);
		

		button_3 = new JButton("确认退宿");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(outStu() == true){
						JOptionPane.showMessageDialog(jframe, "退宿成功，刷新即可看到新的宿舍入住情况" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}else
						JOptionPane.showMessageDialog(jframe, "退宿失败，请重新填写学号" , "系统信息", JOptionPane.WARNING_MESSAGE);
				} catch (HeadlessException | DataBaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "数据库错误，退宿失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}							
			}
		});
		button_3.setBounds(275, 552, 93, 23);
		add(button_3);
		
		label_5 = new JLabel("备  注");
		label_5.setBounds(85, 555, 39, 15);
		add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(128, 553, 137, 21);
		add(textField_6);
		textField_6.setColumns(10);
		

		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		
		this.setOpaque(false);
		
		
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
		allDormitoryInfo = manager.getAllDormitoryInfo();
//System.out.println(allDormitoryInfo.getVector());
//System.out.println(allDormitoryInfo.getdormitoryInfos());
		defaultTableModel.setDataVector(allDormitoryInfo.getdormitoryInfos(), headvector);
	}
	
	public boolean outStu() throws DataBaseException{
		String stuId, rmark;
		stuId = textField_5.getText();
		rmark = textField_6.getText();
		
		return  manager.outStu(stuId,rmark);
		
	}
	
	public String getName(String stuId) throws DataBaseException{
	
		return manager.getStuName(stuId);
	}
	
	public int  insertStu() throws DataBaseException, QueryResultIsNullException{
		String DormId, RoomId, BedId, StuId, Data, Rmark;
		
		DormId = textField.getText();
		RoomId = textField_1.getText();
		StuId = textField_2.getText();
		Data = textField_3.getText();
		Rmark = textField_4.getText();
		
		BedId = comboBox.getSelectedItem().toString();
		
		Integer n = tableDormitoryInfo.getSelectedRow();
		
		if(BedId.equals("舍长")){
			BedId = "1";
			if((boolean)tableDormitoryInfo.getValueAt(n, 2).equals("空") == false){
				JOptionPane.showMessageDialog(jframe, "此房间已经有舍长了，请重新选择床位" , "系统信息", JOptionPane.WARNING_MESSAGE);
				return 1;
			}
		}
		else if(BedId.equals("舍员1")){
			BedId = "2";
			if((boolean)tableDormitoryInfo.getValueAt(n, 3).equals("空") == false){
				JOptionPane.showMessageDialog(jframe, "此房间该床位已经有学生了，请重新选择床位" , "系统信息", JOptionPane.WARNING_MESSAGE);
				return 2;
			}
		}
		else if(BedId.equals("舍员2")){
			BedId = "3";
			if((boolean)tableDormitoryInfo.getValueAt(n, 4).equals("空") == false ){
				JOptionPane.showMessageDialog(jframe, "此房间该床位已经有学生了，请重新选择床位" , "系统信息", JOptionPane.WARNING_MESSAGE);
				return 3;
			}
		}
		else{
			BedId = "4";
			if((boolean)tableDormitoryInfo.getValueAt(n, 5).equals("空") == false){
				JOptionPane.showMessageDialog(jframe, "此房间该床位已经有学生了，请重新选择床位" , "系统信息", JOptionPane.WARNING_MESSAGE);
				return 4;
			}
		}
		
		if(textField_3.getText().length() < 10){
			JOptionPane.showMessageDialog(jframe, "请按规定填写日期，格式如（2013-01-01）" , "系统信息", JOptionPane.WARNING_MESSAGE);
			return 5;
		}
		
		if(manager.insertStu(DormId, RoomId, BedId, StuId, Data, Rmark))
			return 0;
		else
			return 6;
		
		
	}
}
