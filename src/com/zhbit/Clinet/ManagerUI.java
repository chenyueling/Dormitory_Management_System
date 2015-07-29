package com.zhbit.Clinet;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.zhbit.entity.Manager;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.managerUI.ChangPWD;
import com.zhbit.managerUI.Curfew;
import com.zhbit.managerUI.Dormitory;
import com.zhbit.managerUI.DormitoryInfo;
import com.zhbit.managerUI.First;
import com.zhbit.managerUI.LeaveComeStu;
import com.zhbit.managerUI.ManaInfo;
import com.zhbit.managerUI.StuInOut_Add;
import com.zhbit.managerUI.StuKuaidi;
import com.zhbit.managerUI.StuOut;
import com.zhbit.managerUI.View_MR_Stu_It;
import com.zhbit.managerUI.View_Student_College;
import com.zhbit.managerUI.mhelpText;
import com.zhbit.managerUI.About;
import java.awt.Toolkit;
/**
 * 管理员界面
 * @author chenyueling
 *
 */
@SuppressWarnings("serial")
public class ManagerUI extends JFrame {

	private CardLayout card;
	private JPanel contentPane = null;
	private JPanel paneFirst;
	private JPanel paneMInfo;	//管理员信息
	private JPanel paneChangPWD;	//修改密码
	
	private JPanel paneDormitory;	//宿舍基本信息
	private JPanel paneDormitoryInfo;	//宿舍学生具体信息
	private JPanel paneStuInOut_Add;	//学生宿舍入宿退宿
	
	private JPanel paneView_Student_College;	//学生信息查询
	private JPanel paneView_MR_Stu_It;	//维修记录	
	private JPanel paneCurfew;  //夜归信息
	private JPanel paneLeaveComeStu;    //离返校记录
	private JPanel paneStuKuaidi; //快递信息
	
	private JPanel panemhelptext;
	private JPanel paneAbout;
	
	@SuppressWarnings("unused")
	private JPanel paneMStuInfo;
	@SuppressWarnings("unused")
	private JPanel paneSelectStudnet;	
	@SuppressWarnings("unused")
	private String MANAGER_ID;
	private Manager manager=null;
	
	
	public ManagerUI(String MANAGER_ID) throws DataBaseException, QueryResultIsNullException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerUI.class.getResource("/bigImage/图标.png")));
		manager = new Manager(MANAGER_ID);
		this.MANAGER_ID=MANAGER_ID;	
		/*Thread thread = new Thread(new ExpressMassageRemind(MANAGER_ID));
		thread.start();*/
		setTitle("宿舍管理员");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 805, 650);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		menuBar.setMargin(new Insets(4, 4, 4, 4));
		menuBar.setForeground(new Color(30, 144, 255));
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		menuBar.setSize(940, 200);
		menuBar.setBorderPainted(true);
		
		JMenu mnNewMenu = new JMenu("   用户信息  ");
		mnNewMenu.setBackground(new Color(192, 192, 192));
		mnNewMenu.setFont(new Font("华文行楷", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem ManagerInfo = new JMenuItem("个人信息");   
		ManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					((ManaInfo) paneMInfo).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "系统异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
				card.show(contentPane,"管理员资料");
				
			}
		});		
		mnNewMenu.add(ManagerInfo);
		
		JMenuItem PassWordUpdate = new JMenuItem("密码修改");       // PasswordUpdate  密码修改
		PassWordUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane,"密码修改");
			}
		});
		mnNewMenu.add(PassWordUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		mnNewMenu.add(separator);
		
		JMenuItem menuItem_4 = new JMenuItem("退出");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(menuItem_4);
		
		JMenu Fix = new JMenu("寝室管理");                       //Fix 宿舍维修
		Fix.setFont(new Font("华文行楷", Font.PLAIN, 15));
		menuBar.add(Fix);
		
		JMenuItem Indemnity = new JMenuItem("宿舍楼信息");    //Indemnity   赔偿表
		Indemnity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane,"宿舍楼信息");
				
				try {
					((Dormitory)paneDormitory).showInfo();
				} catch (DataBaseException e1) {
					//card.show(contentPane,"宿舍楼信息");
					JOptionPane.showMessageDialog(null, "系统异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					//card.show(contentPane,"宿舍楼信息");
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		Fix.add(Indemnity);
		
		JMenuItem repairs = new JMenuItem("宿舍分配信息");                      //repair 报修
		repairs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "宿舍分配信息");
				
				try {
					((DormitoryInfo)paneDormitoryInfo).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有结果", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
				 
			}
		});
		Fix.add(repairs);
		

		
		
		JMenu StudentInfo = new JMenu("   信息查询   "); 
		StudentInfo.setFont(new Font("华文行楷", Font.PLAIN, 15));
		menuBar.add(StudentInfo);
		
		JMenuItem menuItem_3 = new JMenuItem("学生信息查询");                // StudentInfo  学生信息
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "学生信息");
				try {
					((View_Student_College)paneView_Student_College).showInfo();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有结果", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		StudentInfo.add(menuItem_3);
		
	
		
		JMenuItem mntmNewMenuItem = new JMenuItem("夜归信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane,"夜归信息");
				try {
					((Curfew)paneCurfew).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有结果", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		StudentInfo.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("离返校信息");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane,"离返校信息");
				try {
					((LeaveComeStu)paneLeaveComeStu).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有维修记录", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
				
			}
		});
		StudentInfo.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("维修记录");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "维修记录");
				try {
					((View_MR_Stu_It)paneView_MR_Stu_It).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有维修记录", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		StudentInfo.add(menuItem_1);
		
		JMenuItem menuItem = new JMenuItem("快递查询");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane,"快递查询");
				try {
					((StuKuaidi)paneStuKuaidi).showInfo();
				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "数据异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					// TODO 自动生成的 catch 块
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(null, "没有结果", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		StudentInfo.add(menuItem);
		
		JMenu menu = new JMenu("  帮助  ");
		menu.setFont(new Font("华文行楷", Font.PLAIN, 15));
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("如何使用");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "如何使用");
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_5 = new JMenuItem("关于");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "关于");
			}
		});
		
		menu.add(menuItem_5);
		
		JLabel lblNewLabel_1 = new JLabel("                                                        ");
		menuBar.add(lblNewLabel_1);
		
		JLabel label = new JLabel("  欢迎您：");
		menuBar.add(label);
		
		JLabel lblNewLabel_2 = new JLabel(manager.getName());
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		
		menuBar.add(lblNewLabel_2);
		
		card = new CardLayout(0,0);
		contentPane = new JPanel(card);
		
		paneFirst = new First();
		contentPane.add(paneFirst,"首界面");
		
		paneMInfo = new ManaInfo(manager);
		contentPane.add(paneMInfo,"管理员资料");
		
		paneChangPWD = new ChangPWD(manager);
		contentPane.add(paneChangPWD,"密码修改");
		
		paneDormitory = new Dormitory(manager);
		contentPane.add(paneDormitory,"宿舍楼信息");
		
		paneDormitoryInfo = new DormitoryInfo(this,manager);
		contentPane.add(paneDormitoryInfo,"宿舍分配信息");
/*
paneStuInOut_Add= new StuOut(this, manager);
contentPane.add(paneStuInOut_Add,"学生退宿");
*/
		paneView_Student_College = new View_Student_College(this,manager);
		contentPane.add(paneView_Student_College,"学生信息");
		
		paneCurfew = new Curfew(this,manager);
		contentPane.add(paneCurfew,"夜归信息");
		
		paneLeaveComeStu = new LeaveComeStu(this, manager);
		contentPane.add(paneLeaveComeStu,"离返校信息");
		
		paneView_MR_Stu_It = new View_MR_Stu_It(this,manager);
		contentPane.add(paneView_MR_Stu_It,"维修记录");
		
		paneStuKuaidi = new StuKuaidi(this, manager);
		contentPane.add(paneStuKuaidi,"快递查询");
		
		panemhelptext = new mhelpText();
		contentPane.add(panemhelptext,"如何使用");
		
		paneAbout = new About();
		contentPane.add(paneAbout,"关于");
		
		paneAbout = new About();
		
		
		this.getContentPane().add(contentPane);
		card.show(contentPane, "首界面");
		setVisible(true);
		
		
	}
}
