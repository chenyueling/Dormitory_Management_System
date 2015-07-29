package com.zhbit.stuUI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.*;
import com.zhbit.entity.*;
import java.awt.Color;
import com.zhbit.excetion.*;
import com.zhbit.form.UpdatePersonalInfoForm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuInfo extends JPanel {
	private JTextField txtSID;
	private JTextField txtHome;
	private JTextField txtMajor;
	private JTextField txtSDorm;
	private JTextField txtCollege;
	private JTextField txtClass;
	private JTextField txtSPhone;
	private JTextField txtETime;
	private JTextField txtSName;
	private JRadioButton radWoman;
	private JRadioButton radMan;
	private JButton butAlter;
	private JButton butSava;
	private JLabel labImage;
	private ImageIcon image;
	private String STUDENT_ID;
	private Student student = null;
	private final ButtonGroup butGroup_Sex = new ButtonGroup();
	/**
	 * Create the panel.
	 */
//	public StuInfo (){
//		
//	}
	
	public StuInfo(Student s) {
		this.student = s;
		setLayout(null);
		setSize(800,600);
		
		JLabel labSID = new JLabel("学   号");
		labSID.setFont(new Font("宋体", Font.PLAIN, 14));
		labSID.setBounds(139, 89, 62, 34);
		add(labSID);
		
		txtSID = new JTextField();
		txtSID.setFont(new Font("宋体", Font.PLAIN, 14));
		txtSID.setBounds(205, 95, 121, 23);
		add(txtSID);
		txtSID.setColumns(10);
		
		JLabel labSName = new JLabel("姓   名");
		labSName.setFont(new Font("宋体", Font.PLAIN, 14));
		labSName.setBounds(456, 89, 54, 34);
		add(labSName);
		
		txtSName = new JTextField();
		txtSName.setFont(new Font("宋体", Font.PLAIN, 14));
		txtSName.setBounds(520, 96, 121, 23);
		add(txtSName);
		txtSName.setColumns(10);
		
		JLabel labSex = new JLabel("性   别");
		labSex.setFont(new Font("宋体", Font.PLAIN, 14));
		labSex.setBounds(139, 157, 54, 15);
		add(labSex);
		
		radWoman = new JRadioButton("女");
		butGroup_Sex.add(radWoman);
		radWoman.setFont(new Font("宋体", Font.PLAIN, 14));
		radWoman.setBounds(265, 153, 47, 23);
		add(radWoman);
		
		radMan = new JRadioButton("男");
		butGroup_Sex.add(radMan);
		radMan.setFont(new Font("宋体", Font.PLAIN, 14));
		radMan.setBounds(216, 153, 47, 23);
		add(radMan);
		
		JLabel labSDorm = new JLabel("宿 舍 号");
		labSDorm.setFont(new Font("宋体", Font.PLAIN, 14));
		labSDorm.setBounds(454, 389, 56, 15);
		add(labSDorm);
		
		txtSDorm = new JTextField();
		txtSDorm.setFont(new Font("宋体", Font.PLAIN, 14));
		txtSDorm.setBounds(520, 385, 121, 23);
		add(txtSDorm);
		txtSDorm.setColumns(10);
		
		JLabel labCollege = new JLabel("学    院");
		labCollege.setFont(new Font("宋体", Font.PLAIN, 14));
		labCollege.setBounds(139, 329, 62, 15);
		add(labCollege);
		
		txtCollege = new JTextField();
		txtCollege.setFont(new Font("宋体", Font.PLAIN, 14));
		txtCollege.setBounds(205, 325, 121, 23);
		add(txtCollege);
		txtCollege.setColumns(10);
		
		JLabel labClass = new JLabel("班    级");
		labClass.setFont(new Font("宋体", Font.PLAIN, 14));
		labClass.setBounds(139, 391, 62, 15);
		add(labClass);
		
		txtClass = new JTextField();
		txtClass.setFont(new Font("宋体", Font.PLAIN, 14));
		txtClass.setBounds(205, 385, 121, 23);
		add(txtClass);
		txtClass.setColumns(10);
		
		JLabel labPhone = new JLabel("电   话");
		labPhone.setFont(new Font("宋体", Font.PLAIN, 14));
		labPhone.setBounds(139, 214, 54, 15);
		add(labPhone);
		
		txtSPhone = new JTextField();
		txtSPhone.setFont(new Font("宋体", Font.PLAIN, 14));
		txtSPhone.setBounds(205, 210, 121, 23);
		add(txtSPhone);
		txtSPhone.setColumns(10);
		
		JLabel labHome = new JLabel("籍   贯");
		labHome.setForeground(Color.BLACK);
		labHome.setFont(new Font("宋体", Font.PLAIN, 14));
		labHome.setBounds(456, 163, 54, 15);
		add(labHome);
		
		txtHome = new JTextField();
		txtHome.setFont(new Font("宋体", Font.PLAIN, 14));
		txtHome.setBounds(520, 159, 121, 23);
		add(txtHome);
		txtHome.setColumns(10);
		
		JLabel labMajor = new JLabel("专    业");
		labMajor.setFont(new Font("宋体", Font.PLAIN, 14));
		labMajor.setBounds(456, 325, 62, 15);
		add(labMajor);
		
		txtMajor = new JTextField();
		txtMajor.setFont(new Font("宋体", Font.PLAIN, 14));
		txtMajor.setBounds(520, 321, 121, 23);
		add(txtMajor);
		txtMajor.setColumns(10);
		
		JLabel labETime = new JLabel("入校日期");
		labETime.setFont(new Font("宋体", Font.PLAIN, 14));
		labETime.setBounds(139, 444, 62, 18);
		add(labETime);
		
		txtETime = new JTextField();
		txtETime.setFont(new Font("宋体", Font.PLAIN, 14));
		txtETime.setBounds(205, 442, 121, 23);
		add(txtETime);
		txtETime.setColumns(10);
		
		JLabel labjiben = new JLabel("基本信息：");
		labjiben.setFont(new Font("宋体", Font.PLAIN, 16));
		labjiben.setBounds(95, 38, 88, 15);
		add(labjiben);
		
		JLabel labxueye = new JLabel("学业信息：");
		labxueye.setFont(new Font("宋体", Font.PLAIN, 16));
		labxueye.setBounds(95, 272, 88, 15);
		add(labxueye);
		
		
		butAlter = new JButton("修改");
		butAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editable(true);
			}
		});
		butAlter.setFont(new Font("华文楷体", Font.PLAIN, 15));
		butAlter.setBounds(490, 493, 70, 34);
		add(butAlter);
		
		butSava = new JButton("保存");
		butSava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePersonalInfoForm studentPersonalForm = new UpdatePersonalInfoForm();
				if((!student.getHome().equals(txtHome.getText().trim()))&&!(student.getPhone().equals(txtHome.getText().trim()))){		
				try {
					studentPersonalForm.setHome(txtHome.getText());
					studentPersonalForm.setPhone(txtSPhone.getText());
					student.UpdatePersonalInfo(studentPersonalForm);
				} catch (UpdateDataException e1) {
					// TODO 自动生成的 catch 块
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"数据库更新失败，修改失败", "系统信息", JOptionPane.WARNING_MESSAGE);
				} catch (DataBaseException e1) {
					// TODO 自动生成的 catch 块
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"数据库错误，修改失败", "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				
				JOptionPane.showMessageDialog(null,"修改成功", "系统信息", JOptionPane.WARNING_MESSAGE);
				Editable(false);
			}else{
					JOptionPane.showMessageDialog(null,"您没有修改任何内容", "系统信息", JOptionPane.WARNING_MESSAGE);
					Editable(false);
				}
			}
		});
		butSava.setFont(new Font("华文楷体", Font.PLAIN, 15));
		butSava.setBounds(571, 493, 70, 34);
		add(butSava);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		
		this.setOpaque(false);
	}
	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		Editable(false);
		txtSID.setText(student.getId());
		txtSName.setText(student.getName());
		if(student.getSex().equals("女")){
			radWoman.setSelected(true);
		}else {
			radMan.setSelected(true);
		}
		txtHome.setText(student.getHome());
		txtSPhone.setText(student.getPhone());
		
		txtCollege.setText(student.getCollege());
		txtMajor.setText(student.getMajor());
		txtClass.setText(student.getClassNumber());
		txtETime.setText(student.getStuETime());
		txtSDorm.setText(student.getDormID()+"-"+student.getRoomID());	 
	}
	
	private void Editable(boolean statue){
		butSava.setEnabled(statue);
		butAlter.setEnabled(!statue);
		radWoman.setEnabled(false);
		radMan.setEnabled(false);
		txtSID.setEditable(false);
		txtSName.setEditable(false);
		txtHome.setEditable(statue);
		txtSPhone.setEditable(statue);
		txtCollege.setEditable(false);
		txtMajor.setEditable(false);
		txtClass.setEditable(false);
		txtETime.setEditable(false);
		txtSDorm.setEditable(false);	
	}
}
