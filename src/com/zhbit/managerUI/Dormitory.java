package com.zhbit.managerUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.queryResult.DormitoryBuildingInfo;

public class Dormitory extends JPanel {
	private JTextField txtDormID;
	private JTextField txtStuSex;
	private JTextField txtCollege;
	private JTextField txtEtime;
	private JTextField txtConNum;
	private JTextField txtLiveNum;
	private JLabel labImage;
	private ImageIcon image;
	private String MANAGER_ID;
	private Manager manager;
	/**
	 * Create the panel.
	 */
	public Dormitory(Manager m) {
		this.manager = m;
		this.MANAGER_ID = MANAGER_ID;
		setSize(800,600);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("宿舍楼信息");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
        lblNewLabel.setBounds(195, 101, 125, 40);
        add(lblNewLabel);
        
        JLabel labDormID = new JLabel("宿舍楼ID");
        labDormID.setFont(new Font("宋体", Font.PLAIN, 15));
        labDormID.setBounds(195, 164, 72, 21);
        add(labDormID);
        
        JLabel labStuSex = new JLabel("学生性别");
        labStuSex.setFont(new Font("宋体", Font.PLAIN, 15));
        labStuSex.setBounds(195, 206, 72, 21);
        add(labStuSex);
        
        JLabel labCollege = new JLabel("学院");
        labCollege.setFont(new Font("宋体", Font.PLAIN, 15));
        labCollege.setBounds(195, 251, 54, 21);
        add(labCollege);
        
        JLabel labEtime = new JLabel("入学时间");
        labEtime.setFont(new Font("宋体", Font.PLAIN, 15));
        labEtime.setBounds(195, 296, 72, 21);
        add(labEtime);
        
        JLabel labLiveNum = new JLabel("实住人数");
        labLiveNum.setFont(new Font("宋体", Font.PLAIN, 15));
        labLiveNum.setBounds(195, 344, 72, 21);
        add(labLiveNum);
        
        txtDormID = new JTextField();
        txtDormID.setBounds(292, 164, 288, 21);
        add(txtDormID);
        txtDormID.setColumns(10);
        
        txtStuSex = new JTextField();
        txtStuSex.setColumns(10);
        txtStuSex.setBounds(292, 206, 288, 21);
        add(txtStuSex);
        
        txtCollege = new JTextField();
        txtCollege.setColumns(10);
        txtCollege.setBounds(292, 251, 288, 21);
        add(txtCollege);
        
        txtEtime = new JTextField();
        txtEtime.setColumns(10);
        txtEtime.setBounds(292, 296, 288, 21);
        add(txtEtime);
        
        txtConNum = new JTextField();
        txtConNum.setColumns(10);
        txtConNum.setBounds(292, 387, 288, 21);
        add(txtConNum);
        
        JLabel labConNum = new JLabel("容纳人数");
        labConNum.setFont(new Font("宋体", Font.PLAIN, 15));
        labConNum.setBounds(195, 387, 72, 21);
        add(labConNum);
        
        txtLiveNum = new JTextField();
        txtLiveNum.setColumns(10);
        txtLiveNum.setBounds(292, 344, 288, 21);
        add(txtLiveNum);
        
        image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		this.setOpaque(false);
	}
	public void  showInfo() throws DataBaseException, QueryResultIsNullException{
		Editable(false);
		DormitoryBuildingInfo dormitoryBuildingInfo= manager.getDormitory();
		 txtDormID.setText(dormitoryBuildingInfo.getDormId());
		 txtCollege.setText(dormitoryBuildingInfo.getCollege());
		 txtEtime.setText(dormitoryBuildingInfo.getEtime());
		 txtConNum.setText(dormitoryBuildingInfo.getConNum());
		 txtLiveNum.setText(dormitoryBuildingInfo.getLiveNum());
		 txtStuSex.setText(dormitoryBuildingInfo.getStuSex());
	}
	
	private void Editable(boolean statue){
		  txtStuSex.setEditable(statue);
		  txtDormID.setEditable(statue);
		  txtCollege.setEditable(statue);
		  txtLiveNum.setEditable(statue);
		  txtConNum.setEditable(statue);
		  txtEtime.setEditable(statue);
	}
}
