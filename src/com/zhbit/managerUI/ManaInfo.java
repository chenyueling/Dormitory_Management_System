package com.zhbit.managerUI;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.excetion.UpdateDataException;
import com.zhbit.form.UpdatePersonalInfoForm;
import com.zhbit.queryResult.DormitoryBuildingInfo;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManaInfo extends JPanel {
	private JRadioButton rbStuMan;
	private JRadioButton rbStuWoman;
	private JRadioButton rbWoman;
	private JRadioButton rbMan;
	private JTextField txtDMID;
	private JTextField txtDMName;
	private JTextField txtDMPhone;
	private JTextField txtDormID;
	private JTextField txtCollege;
	private JTextField txtLiveNum;
	private JTextField txtConNum;
	private JTextField txtETime;
	private JLabel labImage;
	private ImageIcon image;
	private String MANAGER_ID;
	private TextArea txtARemark;
	private Manager manager=null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	/**
	 * Create the panel.
	 */
//	public ManaInfo(){
//		
//	}
//	
	public ManaInfo(Manager m) {
		this.manager = m;
		this.MANAGER_ID = MANAGER_ID;
		setSize(800,600);
		setLayout(null);
		
		JLabel labDMID = new JLabel("工   号");
		labDMID.setFont(new Font("宋体", Font.PLAIN, 17));
		labDMID.setBounds(70, 84, 76, 31);
		add(labDMID);
		
		txtDMID = new JTextField();
		txtDMID.setFont(new Font("宋体", Font.PLAIN, 16));
		txtDMID.setBounds(155, 84, 172, 27);
		add(txtDMID);
		txtDMID.setColumns(10);
		
		JLabel labDMName = new JLabel("姓   名");
		labDMName.setFont(new Font("宋体", Font.PLAIN, 17));
		labDMName.setBounds(404, 84, 76, 31);
		add(labDMName);
		
		txtDMName = new JTextField();
		txtDMName.setFont(new Font("宋体", Font.PLAIN, 16));
		txtDMName.setColumns(10);
		txtDMName.setBounds(489, 84, 172, 27);
		add(txtDMName);
		
		JLabel labDMSex = new JLabel("性    别");
		labDMSex.setFont(new Font("宋体", Font.PLAIN, 17));
		labDMSex.setBounds(70, 142, 76, 31);
		add(labDMSex);
		
		rbMan = new JRadioButton("男");
		buttonGroup.add(rbMan);
		rbMan.setFont(new Font("宋体", Font.PLAIN, 17));
		rbMan.setBounds(163, 147, 60, 23);
		add(rbMan);
		
		rbWoman = new JRadioButton("女");
		buttonGroup.add(rbWoman);
		rbWoman.setFont(new Font("宋体", Font.PLAIN, 17));
		rbWoman.setBounds(231, 147, 60, 23);
		add(rbWoman);
		
		JLabel labDMPhone = new JLabel("电   话");
		labDMPhone.setFont(new Font("宋体", Font.PLAIN, 17));
		labDMPhone.setBounds(404, 142, 76, 31);
		add(labDMPhone);
		
		txtDMPhone = new JTextField();
		txtDMPhone.setFont(new Font("宋体", Font.PLAIN, 16));
		txtDMPhone.setColumns(10);
		txtDMPhone.setBounds(489, 142, 172, 27);
		add(txtDMPhone);
		
		JLabel labDormID = new JLabel("所管楼号");
		labDormID.setFont(new Font("宋体", Font.PLAIN, 17));
		labDormID.setBounds(70, 267, 75, 31);
		add(labDormID);
		
		txtDormID = new JTextField();
		txtDormID.setFont(new Font("宋体", Font.PLAIN, 16));
		txtDormID.setColumns(10);
		txtDormID.setBounds(155, 267, 172, 27);
		add(txtDormID);
		
		JLabel labCollege = new JLabel("学   院");
		labCollege.setFont(new Font("宋体", Font.PLAIN, 17));
		labCollege.setBounds(404, 267, 75, 31);
		add(labCollege);
		
		JLabel labInfo = new JLabel("个人资料：");
		labInfo.setFont(new Font("幼圆", Font.PLAIN, 15));
		labInfo.setBounds(48, 23, 102, 41);
		add(labInfo);
		
		JLabel labDormInfo = new JLabel("所管宿舍资料：");
		labDormInfo.setFont(new Font("幼圆", Font.PLAIN, 15));
		labDormInfo.setBounds(70, 201, 128, 41);
		add(labDormInfo);
		
		txtCollege = new JTextField();
		txtCollege.setFont(new Font("宋体", Font.PLAIN, 16));
		txtCollege.setColumns(10);
		txtCollege.setBounds(489, 267, 172, 27);
		add(txtCollege);
		
		JLabel labLiveNum = new JLabel("实住人数");
		labLiveNum.setHorizontalAlignment(SwingConstants.CENTER);
		labLiveNum.setFont(new Font("宋体", Font.PLAIN, 17));
		labLiveNum.setBounds(70, 393, 75, 31);
		add(labLiveNum);
		
		txtLiveNum = new JTextField();
		txtLiveNum.setFont(new Font("宋体", Font.PLAIN, 16));
		txtLiveNum.setColumns(10);
		txtLiveNum.setBounds(155, 393, 172, 27);
		add(txtLiveNum);
		
		JLabel labConNum = new JLabel("容纳人数");
		labConNum.setHorizontalAlignment(SwingConstants.CENTER);
		labConNum.setFont(new Font("宋体", Font.PLAIN, 17));
		labConNum.setBounds(404, 393, 75, 31);
		add(labConNum);
		
		txtConNum = new JTextField();
		txtConNum.setFont(new Font("宋体", Font.PLAIN, 16));
		txtConNum.setColumns(10);
		txtConNum.setBounds(489, 393, 172, 27);
		add(txtConNum);
		
		JLabel labStuSex = new JLabel("学生性别");
		labStuSex.setHorizontalAlignment(SwingConstants.CENTER);
		labStuSex.setFont(new Font("宋体", Font.PLAIN, 17));
		labStuSex.setBounds(70, 330, 75, 31);
		add(labStuSex);
		
		JLabel labETime = new JLabel("入学时间");
		labETime.setHorizontalAlignment(SwingConstants.CENTER);
		labETime.setFont(new Font("宋体", Font.PLAIN, 17));
		labETime.setBounds(404, 330, 75, 31);
		add(labETime);
		
		txtETime = new JTextField();
		txtETime.setFont(new Font("宋体", Font.PLAIN, 16));
		txtETime.setColumns(10);
		txtETime.setBounds(489, 330, 172, 27);
		add(txtETime);
		
		JLabel labRemark = new JLabel("备    注");
		labRemark.setHorizontalAlignment(SwingConstants.CENTER);
		labRemark.setFont(new Font("宋体", Font.PLAIN, 17));
		labRemark.setBounds(71, 457, 75, 31);
		add(labRemark);
		
		txtARemark = new TextArea();
		txtARemark.setFont(new Font("Dialog", Font.PLAIN, 13));
		txtARemark.setBounds(155, 457, 292, 110);
		add(txtARemark);
		
		JButton butAlter = new JButton("修改");
		butAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Editable(true);
			}
		});
		butAlter.setBounds(489, 536, 76, 31);
		add(butAlter);
		
		JButton butSave = new JButton("保存");
		butSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Editable(false);
				
				UpdatePersonalInfoForm updatePersonalInfoForm = new UpdatePersonalInfoForm();
				String phone=txtDMPhone.getText().trim();
				if(phone.equals(manager.getPhone())== false){                            //如果修改的资料有改变
				updatePersonalInfoForm.setPhone(phone);
				try {
					manager.UpdatePersonalInfo(updatePersonalInfoForm);
				} catch (UpdateDataException e) {
					// TODO 自动生成的 catch 块
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null,"更新失败", "系统信息", JOptionPane.WARNING_MESSAGE);
				} catch (DataBaseException e) {
					// TODO 自动生成的 catch 块
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null,"数据库错误，更新失败", "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				JOptionPane.showMessageDialog(null,"修改成功", "系统信息", JOptionPane.WARNING_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"您没有改动任何资料", "系统信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		butSave.setBounds(585, 536, 76, 31);
		add(butSave);
		
		rbStuMan = new JRadioButton("男");
		buttonGroup_1.add(rbStuMan);
		rbStuMan.setFont(new Font("宋体", Font.PLAIN, 17));
		rbStuMan.setBounds(163, 330, 60, 23);
		add(rbStuMan);
		
		rbStuWoman = new JRadioButton("女");
		buttonGroup_1.add(rbStuWoman);
		rbStuWoman.setFont(new Font("宋体", Font.PLAIN, 17));
		rbStuWoman.setBounds(231, 330, 96, 23);
		add(rbStuWoman);
		
		image = new ImageIcon("src\\bigImage\\背景界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, 800, 600);
		add(labImage);
		
		this.setOpaque(false);
		
	}
	
	public void init(){
		
	}
	


	
	public void showInfo() throws DataBaseException, QueryResultIsNullException{
		Editable(false);
		DormitoryBuildingInfo dormitoryBuildingInfo= manager.getDormitory();
		txtDMID.setText(manager.getId());
		 txtDMName.setText(manager.getName());
		 txtDMPhone.setText(manager.getPhone());
		 if(manager.getSex().equals("女")){
			 rbWoman.setSelected(true);
		 }else{
			 rbMan.setSelected(true);
		 }
	
		 txtDormID.setText(dormitoryBuildingInfo.getDormId());
		 txtCollege.setText(dormitoryBuildingInfo.getCollege());
		 txtETime.setText(dormitoryBuildingInfo.getEtime());
		 txtConNum.setText(dormitoryBuildingInfo.getConNum());
		 txtLiveNum.setText(dormitoryBuildingInfo.getLiveNum());
		 txtARemark.setText("计算机学院");
		 if(dormitoryBuildingInfo.getStuSex().equals("女")){
			rbStuWoman.setSelected(true); 
		 }else{
			 rbStuMan.setSelected(true);
		 }
		 
		 
	}
	
	private void Editable(boolean statue){
		txtDMID.setEditable(false);
		txtDMName.setEditable(false);
		txtDMPhone.setEditable(statue);
		  
		  
		  txtDormID.setEditable(false);
		  txtCollege.setEditable(false);
		  txtLiveNum.setEditable(false);
		  txtConNum.setEditable(false);
		  txtETime.setEditable(false);
		
	}
	
}
