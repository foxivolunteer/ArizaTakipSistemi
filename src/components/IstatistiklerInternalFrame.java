package components;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import loginpages.baglanti;

public class IstatistiklerInternalFrame extends javax.swing.JInternalFrame {
	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;
	public ArrayList<String> list = new ArrayList<>();
	public String birim, sicil;
	private static final DateFormat tarihFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	DefaultTableModel model = null;
	JDesktopPane desk;

	public IstatistiklerInternalFrame() {
		initComponents();
		istatistikleriYukle();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		onPanel = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		istatistikTablosu = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		setClosable(true);
		istatistikTablosu.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "PERSONEL", "BUGÜN", "GENEL", "BEKLEYEN İŞ" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		istatistikTablosu.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(istatistikTablosu);
		if (istatistikTablosu.getColumnModel().getColumnCount() > 0) {
			istatistikTablosu.getColumnModel().getColumn(0).setResizable(false);
			istatistikTablosu.getColumnModel().getColumn(0).setPreferredWidth(100);
			istatistikTablosu.getColumnModel().getColumn(1).setResizable(false);
			istatistikTablosu.getColumnModel().getColumn(1).setPreferredWidth(20);
			istatistikTablosu.getColumnModel().getColumn(2).setResizable(false);
			istatistikTablosu.getColumnModel().getColumn(2).setPreferredWidth(20);
			istatistikTablosu.getColumnModel().getColumn(3).setResizable(false);
			istatistikTablosu.getColumnModel().getColumn(3).setPreferredWidth(20);
		}

		jLabel1.setText("TOPLAM KAYIT");

		jTextField1.setEditable(false);
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel2.setText("ÜYE SAYISI");

		jTextField2.setEditable(false);

		jLabel3.setText("EN ÇOK KAYIT GELEN BİRİM");

		jTextField3.setEditable(false);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jTextField1).addComponent(jTextField2)
								.addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
						.addContainerGap(237, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(124, Short.MAX_VALUE)));

		javax.swing.GroupLayout onPanelLayout = new javax.swing.GroupLayout(onPanel);
		onPanel.setLayout(onPanelLayout);
		onPanelLayout.setHorizontalGroup(onPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
				.addGroup(onPanelLayout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		onPanelLayout
				.setVerticalGroup(onPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onPanelLayout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										195, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				onPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				onPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}
	private javax.swing.JTable istatistikTablosu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JPanel onPanel;

	private void istatistikleriYukle() {
		try {
			model = (DefaultTableModel) istatistikTablosu.getModel();
			String adminler = "SELECT * FROM user WHERE yetki =5";
			conn = baglanti.baglan();
			pst = conn.prepareStatement(adminler);
			rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("ad") + " " + rs.getString("soyad"), rs.getString("yetki"),
						rs.getString("yetki"), rs.getString("gorev") });
			}
			conn.close();
			pst = null;
			rs = null;
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(IstatistiklerInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
