package com.zhbit.Clinet;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.zhbit.Util.AESUtil;
import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.form.LoginForm;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPassword;
	private JFrame sr = this;
	private JButton butLogin ;
	private JLabel labImage;
	private ImageIcon image;
	JComboBox boxUser;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
					final String plafName;
					//plafName = infos[1].getClassName();
					//UIManager.setLookAndFeel(plafName);
					//SwingUtilities.updateComponentTreeUI(frame);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void login(LoginForm loginForm) throws DataBaseException,
			QueryResultIsNullException {

		String sql = null;
		if (loginForm.getUserType().equals("学生")) {
			sql = "select * from StuAccountPassword  where StuId ='"
					+ loginForm.getId() + "' and Password = '"
					+ loginForm.getPassword() + "'";
		}
		if (loginForm.getUserType().equals("管理员")) {
			sql = "select * from DMAccountPassword  where DMId ='"
					+ loginForm.getId() + "' and Password ='"
					+ loginForm.getPassword() + "'";
		}

		Statement stmt = DB.CreateStatement();
		//System.out.println(sql);
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				throw new QueryResultIsNullException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();

		}

	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/bigImage/图标.png")));
		setTitle("宿舍管理系统");
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtID = new JTextField();
		txtID.setFont(new Font("宋体", Font.PLAIN, 17));
		txtID.setBounds(194, 90, 190, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		setResizable(false);
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("宋体", Font.PLAIN, 17));
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					butLogin.doClick(); 
		}
			}
		});
		txtPassword.setBounds(194, 145, 190, 30);
		contentPane.add(txtPassword);

		JLabel labID = new JLabel("账号:");
		labID.setFont(new Font("楷体", Font.BOLD, 17));
		labID.setBounds(132, 93, 52, 27);
		contentPane.add(labID);

		JLabel labPassword = new JLabel("密码:");
		labPassword.setFont(new Font("楷体", Font.BOLD, 17));
		labPassword.setBounds(132, 148, 52, 27);
		contentPane.add(labPassword);

		boxUser = new JComboBox();
		boxUser.setFont(new Font("宋体", Font.PLAIN, 15));
		boxUser.setModel(new DefaultComboBoxModel(new String[] { "管理员", "学生" }));
		boxUser.setBounds(194, 197, 78, 23);
		contentPane.add(boxUser);

		butLogin = new JButton("登录");
		butLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		butLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				LoginForm loginForm = new LoginForm();
				loginForm.setId(txtID.getText());
				loginForm.setPassword(AESUtil.getInstance().encrypt(txtPassword.getText().trim()));
				loginForm.setUserType(boxUser.getSelectedItem().toString());

				try {
					login(loginForm);
					if (loginForm.getUserType().equals("学生")) {
						new StudentUI(loginForm.getId());
						setVisible(false);
					}

					if (loginForm.getUserType().equals("管理员")) {
						new ManagerUI(loginForm.getId());
						setVisible(false);
					}

				} catch (DataBaseException e1) {
					JOptionPane.showMessageDialog(sr, boxUser.getSelectedItem()
							+ "系统异常", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (QueryResultIsNullException e1) {
					JOptionPane.showMessageDialog(sr, boxUser.getSelectedItem()
							+ "用户不存在或密码错误", "系统信息", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}

			}
		});
		butLogin.setBounds(306, 197, 69, 23);
		contentPane.add(butLogin);
	
		image = new ImageIcon("src\\bigImage\\登录界面.jpg");
		labImage = new JLabel(image);
		labImage.setBounds(0, 0, image.getIconWidth(),image.getIconHeight());
		contentPane.add(labImage);
		contentPane.setOpaque(false);
	}

}
