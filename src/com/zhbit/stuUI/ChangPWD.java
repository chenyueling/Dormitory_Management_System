package com.zhbit.stuUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.zhbit.entity.Manager;
import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.PasswordNotMatchException;
import com.zhbit.excetion.UpdateSuccessException;
import com.zhbit.form.UpdatePassWordForm;


public class ChangPWD extends JPanel {
	private JPasswordField txtOldPWD;
	private JPasswordField txtNewPWD;
	private JPasswordField txtCheckNewPWD;
	private JButton butOk;
	private JLabel labImage;
	private ImageIcon image;
	private Student student;
	/**
	 * Create the panel.
	 */


	
	public ChangPWD(Student stu) {
		this.student = stu;
		setSize(800,600);
        setLayout(null);
        
        JLabel labOldPWD = new JLabel("旧密码");
        labOldPWD.setFont(new Font("宋体", Font.PLAIN, 15));
        labOldPWD.setBounds(245, 190, 54, 15);
        add(labOldPWD);
        
        JLabel labNewPWD = new JLabel("新密码");
        labNewPWD.setFont(new Font("宋体", Font.PLAIN, 15));
        labNewPWD.setBounds(245, 257, 54, 15);
        add(labNewPWD);
        
        JLabel labCheckNewPWD = new JLabel("确认新密码");
        labCheckNewPWD.setFont(new Font("宋体", Font.PLAIN, 15));
        labCheckNewPWD.setBounds(245, 315, 93, 20);
        add(labCheckNewPWD);
        
        butOk = new JButton("确认");
        butOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		UpdatePassWordForm updatePassWordForm = new UpdatePassWordForm();
        		updatePassWordForm.setOldPassword(txtOldPWD.getText().trim());
        		updatePassWordForm.setNewassword(txtNewPWD.getText().trim());
        		updatePassWordForm.setNewPassword1(txtCheckNewPWD.getText().trim());
        		if(updatePassWordForm.getNewassword().equals(updatePassWordForm.getNewPassword1())){
        			try {
        				student.PasswordUpdate(updatePassWordForm);
					} catch (PasswordNotMatchException e) {
						JOptionPane.showMessageDialog(null, "旧密码错误,修改失败!", "系统信息", JOptionPane.WARNING_MESSAGE);
						//e.printStackTrace();
					} catch (DataBaseException e) {
						// TODO 自动生成的 catch 块
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库错误,修改失败!", "系统信息", JOptionPane.WARNING_MESSAGE);
					} catch (UpdateSuccessException e) {
						JOptionPane.showMessageDialog(null, "密码修改成功,请牢记密码", "系统信息", JOptionPane.WARNING_MESSAGE);
					}
        		}else{
        			JOptionPane.showMessageDialog(null, "新密码输入不一致", "系统信息", JOptionPane.WARNING_MESSAGE);
        		}
        	}
        });
        butOk.setFont(new Font("宋体", Font.PLAIN, 15));
        butOk.setBounds(267, 415, 93, 23);
        add(butOk);
        
        JButton butCancel = new JButton("取消");
        butCancel.setFont(new Font("宋体", Font.PLAIN, 15));
        butCancel.setBounds(448, 415, 93, 23);
        add(butCancel);
        
        txtOldPWD = new JPasswordField();
        txtOldPWD.setBounds(356, 186, 185, 23);
        add(txtOldPWD);
        
        txtNewPWD = new JPasswordField();
        txtNewPWD.setBounds(356, 253, 185, 23);
        add(txtNewPWD);
        
        txtCheckNewPWD = new JPasswordField();
        txtCheckNewPWD.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode()==KeyEvent.VK_ENTER){
					butOk.doClick(); 
					}
        	}
        });
        txtCheckNewPWD.setBounds(356, 314, 185, 23);
        add(txtCheckNewPWD);
        
        JLabel lblNewLabel_4 = new JLabel("修改密码");
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 25));
        lblNewLabel_4.setBounds(245, 121, 115, 34);
        add(lblNewLabel_4);
        
        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}

}
