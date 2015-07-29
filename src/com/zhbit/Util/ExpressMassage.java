package com.zhbit.Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
/**
 * 快递消息提示弹出窗口
 * @author chenyueling
 *
 */
public class ExpressMassage extends JFrame {
	
	
	private JPanel contentPane;
	private JFrame frame=this;
	private int remindTime=100000+5000; 
	private JComboBox comboBox;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private Vector<String> headVector;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpressMassage frame = new ExpressMassage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private Student student;

	/**
	 * Create the frame.
	 */
	public ExpressMassage(Student stu) {
		
		this.student = stu;
		
		setTitle("新快递信息");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"15", "30", "45", "60","本次登录不再提示"}));
		comboBox.setBounds(216, 165, 72, 21);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("修改提醒时间");
		label.setBounds(107, 166, 92, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("分钟后再提示");
		label_1.setBounds(304, 166, 92, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				remindTime=Integer.parseInt(comboBox.getSelectedItem().toString())*60*1000;
			}
		});
		button.setBounds(303, 217, 93, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 12, 348, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(0, 0, 348, 143);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		table.setFillsViewportHeight(true);
		defaultTableModel = new DefaultTableModel();
		table.setModel(defaultTableModel);
		headVector = new Vector<String>();
		headVector.add("快递记录号");
		headVector.add("快递公司");
		headVector.add("到件日期");
		headVector.add("备注");

		defaultTableModel.setDataVector(null, headVector);
		
		scrollPane_1.setViewportView(table);
	}
 
	public int getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(int remindTime) {
		this.remindTime = remindTime;
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
		Vector<Object> vector = student.showPersonalExpressInfo();
		defaultTableModel.setDataVector(vector, headVector);
	}
	
	
	
	
}
