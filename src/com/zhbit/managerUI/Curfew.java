package com.zhbit.managerUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Curfew extends JPanel {
	private JTable table;
	private String MANAGER_ID;
	private JLabel labImage;
	private ImageIcon image;
	private DefaultTableModel defaultTableModel;
	private Vector<String> headvector ;
	private Manager manager;
	
	private TableRowSorter<TableModel> sorter;
	
	private JFrame jframe;
	private JTextField jtfFilter;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	/**
	 * Create the panel.
	 */
	public Curfew (JFrame jf, Manager m){
		this.jframe = jf;
		this.manager = m;
		setSize(800,600);
	     setLayout(null);
	     
	     JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	     scrollPane.setBounds(90, 189, 612, 216);
	     add(scrollPane);
	     
	     table = new JTable();
	     table.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	     		Integer n = table.getSelectedRow();
				textField_1.setText((String)table.getValueAt(n, 1));

				textField_2.setText((String) table.getValueAt(n, 2));
			
				textField_3.setText((String) table.getValueAt(n, 6));		
				
				textField_4.setText((String) table.getValueAt(n, 9));	
				
				}
	     
	     });
	     scrollPane.setViewportView(table);
	     headvector = new Vector<String>();
	     headvector.add("记录号");
	     headvector.add("学号");
	     headvector.add("姓名");
	     headvector.add("宿舍楼栋");
	     headvector.add("房间号");
	     headvector.add("床号");
	     headvector.add("夜归时间");
	     headvector.add("第几次夜归");
	     headvector.add("值班宿管");
	     headvector.add("晚归原因");
	     
	     defaultTableModel = new DefaultTableModel();
	     
	     defaultTableModel.setColumnCount(10);
	     
	     defaultTableModel.setDataVector(null,headvector);
	     table.setModel(defaultTableModel);
	     table.setFont(new Font("宋体", Font.PLAIN, 15));
	     
	 	table.setAutoResizeMode(table.AUTO_RESIZE_OFF);  //自动调整表格列的宽度，不更改其他列的大小，而是更改整个表格的大小
		sorter = new TableRowSorter<TableModel>(table.getModel());
		
		table.setRowSorter(sorter);
		
			
	     JLabel label = new JLabel("夜归记录表");
	     label.setFont(new Font("微软雅黑", Font.BOLD, 25));
	     label.setBounds(90, 119, 155, 34);
	     add(label);
	     
		 
		 jtfFilter = new JTextField();
		 jtfFilter.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
		 		
		 	}
		 });
		 jtfFilter.setBounds(90, 495, 113, 21);
		 add(jtfFilter);
		 jtfFilter.setColumns(10);
		 
		 JButton button = new JButton("查询");
		 button.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
		 	}
		 });
		 button.setBounds(213, 494, 67, 23);
		 add(button);
		 
		 JLabel lblNewLabel = new JLabel("学号");
		 lblNewLabel.setBounds(90, 428, 30, 15);
		 add(lblNewLabel);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(121, 425, 82, 21);
		 add(textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel label_1 = new JLabel("姓名");
		 label_1.setBounds(213, 428, 30, 15);
		 add(label_1);
		 
		 textField_2 = new JTextField();
		 textField_2.setBounds(243, 425, 66, 21);
		 add(textField_2);
		 textField_2.setColumns(10);
		 
		 JLabel label_2 = new JLabel("夜归时间");
		 label_2.setBounds(319, 428, 54, 15);
		 add(label_2);
		 
		 textField_3 = new JTextField();
		 textField_3.setBounds(372, 425, 148, 21);
		 add(textField_3);
		 textField_3.setColumns(10);
		 
		 JButton button_1 = new JButton("添加夜归记录");
		 button_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		

					try {
						if(insertCurfew() == true)
							JOptionPane.showMessageDialog(jframe, "添加成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
						else
							JOptionPane.showMessageDialog(jframe, "添加失败，请重新填写信息" , "系统信息", JOptionPane.WARNING_MESSAGE);
					} catch (HeadlessException | DataBaseException
							| QueryResultIsNullException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(jframe, "数据库错误，添加记录失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
		 	}
		 	
		 });
		 button_1.setBounds(593, 463, 109, 23);
		 add(button_1);
		 
		 
		 JLabel label_3 = new JLabel("原因");
		 label_3.setBounds(530, 428, 30, 15);
		 add(label_3);
		 
		 textField_4 = new JTextField();
		 textField_4.setBounds(564, 425, 138, 21);
		 add(textField_4);
		 textField_4.setColumns(10);
		 
		 JButton button_2 = new JButton("刷新");
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
		 button_2.setBounds(609, 541, 93, 23);
		 add(button_2);


		 
		 JButton button_3 = new JButton("重置");
		 button_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		textField_1.setText("");
		 		textField_2.setText("");
		 		textField_3.setText("");
		 		textField_4.setText("");
		 		
		 	}
		 });
		 button_3.setBounds(490, 463, 93, 23);
		 add(button_3);
		 

	     image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		 labImage = new JLabel(image);
		 labImage.setBounds(0, 0, 800, 600);
		 add(labImage);
		 this.setOpaque(false);
		 
		}
	
	    
		public void showInfo() throws DataBaseException, QueryResultIsNullException{
			Vector<Object> vector = manager.getAllCurfewRecord();
			defaultTableModel.setDataVector(vector, headvector);
		}
		
		
		public boolean insertCurfew() throws DataBaseException, QueryResultIsNullException{
			
			String StuId, StuName, Curfew, Rmark, DMid;
			StuId = textField_1.getText();
			StuName = textField_2.getText();
			Curfew  = textField_3.getText();
			Rmark = textField_4.getName();
			
			DMid = manager.getId();
			
			return  manager.insertCurfew(StuId, StuName, Curfew, Rmark, DMid);		
			
			
		}
				
		
}
