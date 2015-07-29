package com.zhbit.managerUI;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

public class LeaveComeStu extends JPanel {
	private JTable tableLeaveComeStu;
	private JLabel labImage;
	private ImageIcon image;
	/**
	 * Create the panel.
	 */
	private DefaultTableModel defaultTableModel;
	private Vector<String> headvector ;
	private Manager manager;
	
	private TableRowSorter<TableModel> sorter;
	
	private JFrame jframe;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField jtfFilter;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private	JRadioButton radioButton;
	private JRadioButton radioButton_1;
		
	
	public LeaveComeStu(JFrame jf, Manager m) {
		
    		this.jframe = jf;
    		this.manager = m;
    		setSize(800,600);
    	     setLayout(null);
    	     
    	     JScrollPane scrollPane = new JScrollPane();
    		 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    		 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    	     scrollPane.setBounds(66, 135, 672, 232);
    	     add(scrollPane);
    	     
    	     tableLeaveComeStu = new JTable();
    	     
    	     
    	     tableLeaveComeStu.addMouseListener(new MouseAdapter() {
    	     	@Override
    	     	public void mouseClicked(MouseEvent e) {
    	     		
    	     		Integer n = tableLeaveComeStu.getSelectedRow();
    	     		textField.setText((String)tableLeaveComeStu.getValueAt(n, 1));
    				textField_1.setText((String)tableLeaveComeStu.getValueAt(n, 2));
    				textField_2.setText((String)tableLeaveComeStu.getValueAt(n, 6));
    				textField_3.setText((String)tableLeaveComeStu.getValueAt(n, 8));
    				
    				String s ;
    				
    				s = (String)tableLeaveComeStu.getValueAt(n, 7);
    				if(s.equals("L"))
    					radioButton.setSelected(true);
    				else
    					radioButton_1.setSelected(true);
    				
    				}
    	     
    	     });
    	     scrollPane.setViewportView(tableLeaveComeStu);
    	     
    	     
    	     headvector = new Vector<String>();
    	     headvector.add("记录号");
    	     headvector.add("学号");
    	     headvector.add("姓名");
    	     headvector.add("宿舍楼");
    	     headvector.add("房间号");
    	     headvector.add("床号");
    	     headvector.add("离返日期");
    	     headvector.add("离/返校");
    	     headvector.add("备注");
    	     defaultTableModel = new DefaultTableModel();
    	     
    	     defaultTableModel.setColumnCount(9);
    	     defaultTableModel.setRowCount(11);
    	     
    	     defaultTableModel.setDataVector(null,headvector);
    	     tableLeaveComeStu.setModel(defaultTableModel);
    	     tableLeaveComeStu.setFont(new Font("宋体", Font.PLAIN, 15));
    	     
    	     tableLeaveComeStu.setAutoResizeMode(tableLeaveComeStu.AUTO_RESIZE_OFF);  //自动调整表格列的宽度，不更改其他列的大小，而是更改整个表格的大小
    		sorter = new TableRowSorter<TableModel>(tableLeaveComeStu.getModel());
    		
    		tableLeaveComeStu.setRowSorter(sorter);
    		
       
        
        tableLeaveComeStu.setFont(new Font("宋体", Font.PLAIN, 15));
        
        JLabel labLeaveComeStu = new JLabel("离返校记录表");
        labLeaveComeStu.setFont(new Font("微软雅黑", Font.BOLD, 25));
        labLeaveComeStu.setBounds(66, 59, 180, 34);
        add(labLeaveComeStu);
        
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(66, 390, 30, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 387, 86, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(194, 390, 30, 15);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 387, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("日期");
		label_1.setBounds(301, 390, 30, 15);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(333, 387, 97, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		
		radioButton = new JRadioButton("离校");
		radioButton.setOpaque(false);
		buttonGroup.add(radioButton);
		radioButton.setBounds(436, 386, 49, 23);
		add(radioButton);
		
		radioButton_1 = new JRadioButton("返校");
		radioButton_1.setOpaque(false);
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(487, 386, 56, 23);
		add(radioButton_1);
		
		JLabel label_2 = new JLabel("备注");
		label_2.setBounds(543, 390, 30, 15);
		add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(583, 387, 155, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("添加离返校记录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(insertLCRecord() == true){
						JOptionPane.showMessageDialog(jframe, "添加成功，点击刷新按钮即可查看到新纪录" , "系统信息", JOptionPane.WARNING_MESSAGE);
					}else
						JOptionPane.showMessageDialog(jframe, "添加失败，请重新填写信息" , "系统信息", JOptionPane.WARNING_MESSAGE);
				} catch (HeadlessException | DataBaseException
						| QueryResultIsNullException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
					JOptionPane.showMessageDialog(jframe, "数据库错误，添加失败" , "系统信息", JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		button.setBounds(612, 418, 126, 23);
		add(button);
		
		jtfFilter = new JTextField();
		jtfFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
				
			}
		});
		jtfFilter.setBounds(66, 444, 118, 21);
		add(jtfFilter);
		jtfFilter.setColumns(10);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = jtfFilter.getText();
				if(text.trim().length()==0)
					sorter.setRowFilter(null);
				else{
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
		button_1.setBounds(198, 443, 56, 23);
		add(button_1);
		
		JButton button_2 = new JButton("重置");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);			
				
			}
		});
		button_2.setBounds(524, 418, 66, 23);
		add(button_2);
		
		JButton button_3 = new JButton("刷新");
		button_3.addActionListener(new ActionListener() {
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
		button_3.setBounds(645, 486, 93, 23);
		add(button_3);

        
        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}

	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		
		Vector<Object> Datavector = manager.getAllLiveComeStu();
		
		 defaultTableModel.setDataVector(Datavector,headvector);
		 
	}

	public boolean insertLCRecord() throws DataBaseException, QueryResultIsNullException{
		String StuId, StuName, Data, LC, Mark;
		
		StuId = textField.getText();
		StuName = textField_1.getText();
		Data = textField_2.getText();
		Mark = textField_3.getText();
		LC = "L";
		if(radioButton.isSelected())
			LC =  "L";
		else if(radioButton_1.isSelected())
			LC = "C";
		else{
			JOptionPane.showMessageDialog(jframe, "请选定离/返校" , "系统信息", JOptionPane.WARNING_MESSAGE);
		}
		
		return manager.insertLCRecord(StuId, StuName, Data, LC, Mark);
		
	}
}
