package com.zhbit.stuUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;


public class SKuaidi extends JPanel {
	private JTable tableSKuaidi;
	private JTextField textField;
	private JLabel labImage;
	private ImageIcon image;
	private Student student;
	private DefaultTableModel defaultTableModel;
	private Vector<Object> headVector;
	private JFrame jframe;
	private JRadioButton radioButton;

	private TableRowSorter<TableModel> sorter;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	
	/**
	 * Create the panel.
	 */
	public SKuaidi(JFrame jf, Student student) {
		this.student = student;
		this.jframe = jf;
		setSize(800,600);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 140, 670, 288);
		add(scrollPane);
		
		
		tableSKuaidi = new JTable();
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.setColumnCount(15);
		defaultTableModel.setRowCount(6);
		defaultTableModel.setValueAt(123, 1, 1);
	/*	headVector.add("记录号");
		headVector.add("公司名");
		headVector.add("是否领取");
		headVector.add("到件日期");
		headVector.add("领取日期");
		headVector.add("备注");*/
		headVector = new Vector<Object>();
		headVector.add("\u8BB0\u5F55\u53F7");
		headVector.add("\u516C\u53F8\u540D");
		headVector.add("\u5BBF\u820D\u697C");
		headVector.add("\u623F\u95F4");
		headVector.add("\u5B66\u53F7");
		headVector.add("\u5B66\u751F\u59D3\u540D");
		headVector.add("\u8054\u7CFB\u7535\u8BDD");
		headVector.add( "\u662F\u5426\u9886\u53D6"); 
		headVector.add("\u5230\u4EF6\u65E5\u671F");
		headVector.add("\u9886\u53D6\u65E5\u671F");
		headVector.add("\u5907\u6CE8");
		defaultTableModel.setDataVector(null,headVector);
		tableSKuaidi.setModel(defaultTableModel);
		scrollPane.setViewportView(tableSKuaidi);

		tableSKuaidi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		tableSKuaidi.setFont(new Font("宋体", Font.PLAIN, 15));
		
		sorter = new TableRowSorter<TableModel>(tableSKuaidi.getModel());
		tableSKuaidi.setRowSorter(sorter);	
		
		JLabel label = new JLabel("快递信息");
		label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		label.setBounds(99, 50, 107, 40);
		add(label);
		
		radioButton = new JRadioButton("只显示未领取快递");
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
		radioButton.setBounds(587, 456, 121, 23);
		add(radioButton);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 11));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = textField.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
				
			}
		});
		textField.setBounds(102, 500, 121, 21);
		add(textField);
		textField.setColumns(10);
		

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("快递公司");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(235, 499, 73, 23);
		add(rdbtnNewRadioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("日期");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(312, 499, 57, 23);
		add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("记录号");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(368, 499, 61, 23);
		add(radioButton_2);
		
		JButton button = new JButton("查            询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = textField.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
	
					if( rdbtnNewRadioButton.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 1));
					}else if(radioButton_1.isSelected() == true){
						sorter.setRowFilter(RowFilter.regexFilter(text));
					}else if(radioButton_2.isSelected()== true){
						sorter.setRowFilter(RowFilter.regexFilter(text, 0));
					}else {
						JOptionPane.showMessageDialog(jframe, "请选中查询方式" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		button.setBounds(235, 535, 182, 23);
		add(button);
		
		
		JButton button_1 = new JButton("签收");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tableSKuaidi.getValueAt( tableSKuaidi.getSelectedRow(), 7).equals("是") || tableSKuaidi.getValueAt( tableSKuaidi.getSelectedRow(), 7).equals("是"))
					JOptionPane.showMessageDialog(jframe, "此快递已经领取" , "系统信息", JOptionPane.WARNING_MESSAGE);
				else if(textField.getText().length() < 10 ){
					JOptionPane.showMessageDialog(jframe, "请填写日期。（2013-06-01）" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				else{	
					try {
						if(updateRecord() == true){
							//System.out.println(textField.getText());
										
							String s = "是";
							tableSKuaidi.setValueAt(textField_1.getText(), tableSKuaidi.getSelectedRow(), 9);
							tableSKuaidi.setValueAt(s, tableSKuaidi.getSelectedRow(), 7);
						
							JOptionPane.showMessageDialog(jframe, "修改成功" , "系统信息", JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException | DataBaseException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(jframe, "修改成失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}
				}
		}});
		button_1.setBounds(470, 456, 93, 23);
		add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 11));
		textField_1.setBounds(339, 457, 121, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("日期");
		label_1.setBounds(294, 460, 35, 15);
		add(label_1);

		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		defaultTableModel.setDataVector(student.getPersonalExpressInfo(), headVector);
	}
	
	
	

	public boolean updateRecord() throws DataBaseException{
		int Record;
	
		String Data = "";
		
		Record = Integer.parseInt( textField.getText() );
		
		
		Data = textField_1.getText();
		
		
		
		return student.updateExpressTransceiver(Record, Data);
		
	}
}
