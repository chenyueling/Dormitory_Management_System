package com.zhbit.managerUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class View_Student_College extends JPanel {
	private JTable tableStu_College;
	private JTextField jtfFilter;

	private JLabel labImage;
	private ImageIcon image;
	private String MANAGER_ID;
	
	private DefaultTableModel defaultTableModel;
	private Vector<Object> headvector;
	private TableRowSorter<TableModel> sorter;

	
	private JFrame jframe;
	private Manager manager;

	/**
	 * Create the panel.
	 */
	public View_Student_College(JFrame jf, Manager m ) {
		this.jframe = jf;
		
		this.manager = m;
		
		setSize(800,600);
		setLayout(null);
		


		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	//	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(60, 130, 667, 300);
		add(scrollPane);
		
		tableStu_College = new JTable();
		
		scrollPane.setViewportView(tableStu_College);
		
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(9);
		defaultTableModel.setRowCount(10);
		defaultTableModel.setValueAt(123, 1, 1);
		
		//头部信息
		headvector = new Vector<Object>();
		headvector.add("学号");
		headvector.add("姓名");
		headvector.add("性别");
		headvector.add("入学时间");
		headvector.add("学院");
		headvector.add("专业");
		headvector.add("班级");
		headvector.add("籍贯");
		headvector.add("联系电话"); 
		
		defaultTableModel.setDataVector(null,headvector );
		
		
		tableStu_College.setModel(defaultTableModel);
		tableStu_College.setFont(new Font("宋体", Font.PLAIN, 15));
		
		tableStu_College.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		
		sorter = new TableRowSorter<TableModel>(tableStu_College.getModel());
		tableStu_College.setRowSorter(sorter);
		
		
		
		JLabel labView_Stu_College = new JLabel("学生信息");
		labView_Stu_College.setFont(new Font("微软雅黑", Font.BOLD, 25));
		labView_Stu_College.setBounds(60, 78, 113, 34);
		add(labView_Stu_College);
		
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
		jtfFilter.setBounds(85, 452, 127, 21);
		add(jtfFilter);
		jtfFilter.setColumns(10);
		
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
		butSelect.setBounds(222, 451, 93, 23);
		add(butSelect);
		

        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
		Vector<Object> vector = manager.getAllStudentInfo(manager.getDormId());
//System.out.println(vector);
		defaultTableModel.setDataVector(vector, headvector);
	}
	
	
}
