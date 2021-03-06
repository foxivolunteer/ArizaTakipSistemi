package SuperAdmin;

import Admin.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import loginpages.baglanti;

public class GenelArizalarInternalFrame extends javax.swing.JInternalFrame {
	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;
	public ArrayList<String> list = new ArrayList<>();
	public ArrayList<String> adminIDList = new ArrayList<>();
	String[] adminListesi;
	public String birim, sicil;
	private static final DateFormat tarihFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	DefaultTableModel model = null;
	JDesktopPane desk;
	Object mesajID = null;
	JComboBox isAktarilacakAdmin;
	Integer secilen = null;

	public GenelArizalarInternalFrame() throws ClassNotFoundException, SQLException {
		initComponents();
		tabloGoruntusunuAyarla();
		arizaListesiniDoldur();

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		yenile = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		arizaTablosu = new javax.swing.JTable();
		aktar = new javax.swing.JButton();
		onayla = new javax.swing.JButton();

		setIconifiable(true);
		setResizable(true);

		yenile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		yenile.setText("YENİLE");
		yenile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				yenileActionPerformed(evt);
			}
		});

		arizaTablosu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		arizaTablosu.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
		arizaTablosu.setForeground(new java.awt.Color(0, 0, 255));
		arizaTablosu.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "PERSONEL", "BİRİM", "ODA NUMARASI", "ARIZA MESAJI" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		arizaTablosu.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		arizaTablosu.setGridColor(new java.awt.Color(0, 204, 204));
		arizaTablosu.setMinimumSize(new java.awt.Dimension(0, 0));
		arizaTablosu.setRowHeight(32);
		arizaTablosu.setRowMargin(5);
		arizaTablosu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		arizaTablosu.getTableHeader().setReorderingAllowed(false);
		arizaTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				arizaTablosuMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(arizaTablosu);
		if (arizaTablosu.getColumnModel().getColumnCount() > 0) {
			arizaTablosu.getColumnModel().getColumn(0).setMinWidth(30);
			arizaTablosu.getColumnModel().getColumn(0).setPreferredWidth(30);
			arizaTablosu.getColumnModel().getColumn(0).setMaxWidth(30);
			arizaTablosu.getColumnModel().getColumn(1).setMinWidth(170);
			arizaTablosu.getColumnModel().getColumn(1).setPreferredWidth(170);
			arizaTablosu.getColumnModel().getColumn(1).setMaxWidth(170);
			arizaTablosu.getColumnModel().getColumn(2).setMinWidth(200);
			arizaTablosu.getColumnModel().getColumn(2).setPreferredWidth(200);
			arizaTablosu.getColumnModel().getColumn(2).setMaxWidth(200);
			arizaTablosu.getColumnModel().getColumn(3).setMinWidth(100);
			arizaTablosu.getColumnModel().getColumn(3).setPreferredWidth(100);
			arizaTablosu.getColumnModel().getColumn(3).setMaxWidth(100);
		}

		aktar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		aktar.setText("İŞ AKTAR");
		aktar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aktarActionPerformed(evt);
			}
		});

		onayla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		onayla.setText("ONAYLA");
		onayla.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onaylaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(27, 27, 27)
						.addComponent(aktar, javax.swing.GroupLayout.PREFERRED_SIZE, 143,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)
						.addComponent(onayla, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(yenile, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
										.addComponent(aktar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(onayla, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		pack();
	}

	private void arizaTablosuMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void yenileActionPerformed(java.awt.event.ActionEvent evt) {
		model.getDataVector().removeAllElements();
		try {
			arizaListesiniDoldur();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
		arizaTablosu.revalidate();
	}

	private void aktarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			isAktarilacakAdmin = new JComboBox();
			String aktarSQL = "SELECT * FROM user WHERE durum = 'Aktif' AND yetki = 5";
			conn = baglanti.baglan();
			Statement pst = conn.createStatement();
			rs = pst.executeQuery(aktarSQL);
			rs = pst.executeQuery(aktarSQL);
			while (rs.next()) {
				isAktarilacakAdmin.addItem(rs.getString("ad") + " " + rs.getString("soyad"));
				adminIDList.add(rs.getString("sicil"));
			}
			conn.close();
			pst = null;
			rs = null;

			try {
				// İŞ AKTARILACAK ADMİN arizaListesiniDoldur() fonksiyonu içerisinde
				// isAktarilacakAdmin combobax a atılıyor.

				String adminID;
				Object mesajID;
				secilen = arizaTablosu.getSelectedRow();
				isAktarilacakAdmin.setSelectedIndex(0);
				JOptionPane.showConfirmDialog(null, isAktarilacakAdmin, "İş Aktarılacak Admin",
						JOptionPane.PLAIN_MESSAGE);
				adminID = adminIDList.get(isAktarilacakAdmin.getSelectedIndex());
				mesajID = arizaTablosu.getModel().getValueAt(secilen, 0);
				String isAktarSQL = "UPDATE arizalar " + "SET personel ='" + adminID + "'" + "WHERE id = '" + mesajID
						+ "'";

				conn = baglanti.baglan();
				pst = conn.prepareStatement(isAktarSQL);
				pst.executeUpdate(isAktarSQL);
				conn.close();
				pst = null;

			} catch (ClassNotFoundException | SQLException ex) {
				Logger.getLogger(GenelArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
			}

			model.getDataVector().removeAllElements();
			try {
				arizaListesiniDoldur();
			} catch (ClassNotFoundException | SQLException ex) {
				Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
			arizaTablosu.revalidate();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(GenelArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void onaylaActionPerformed(java.awt.event.ActionEvent evt) {
		Object[] options = { "ONAYLA", "IPTAL" };
		int secilenDeger = JOptionPane.showOptionDialog(null, "Mesaj Onaylanacak Emin misiniz?", "Dikkat!!",
				JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

		if (secilenDeger == 0)// Secilen deger YES
		{
			try {
				String onaySQL = "UPDATE arizalar SET durum =0, onay_tarihi='" + tarihGetir() + "' WHERE id ='"
						+ model.getValueAt(arizaTablosu.getSelectedRow(), 0) + "'";
				conn = baglanti.baglan();
				pst = conn.prepareStatement(onaySQL);
				pst.executeUpdate();
			} catch (ClassNotFoundException | SQLException ex) {
				Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
			model.getDataVector().removeAllElements();
			try {
				arizaListesiniDoldur();
			} catch (ClassNotFoundException | SQLException ex) {
				Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
			arizaTablosu.revalidate();
		} else// Secilen deger NO
		{
			// birsey yapma.

		}
	}

	private javax.swing.JButton aktar;
	private javax.swing.JTable arizaTablosu;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton onayla;
	private javax.swing.JButton yenile;

	private void arizaListesiniDoldur() throws ClassNotFoundException, SQLException {
		model = (DefaultTableModel) arizaTablosu.getModel();
		String SQL = "SELECT arizalar.id, user.ad,user.soyad,user.sicil,arizalar.birim,arizalar.oda_numarasi,arizalar.mesaj FROM arizalar  "
				+ "INNER JOIN user ON " + "arizalar.personel = user.sicil "
				+ "AND arizalar.durum = 1 AND user.yetki = 5";

		conn = baglanti.baglan();
		Statement pst = conn.createStatement();
		rs = pst.executeQuery(SQL);

		while (rs.next()) {
			model.addRow(new Object[] { rs.getString("id"), rs.getString("ad") + " " + rs.getString("soyad"),
					rs.getString("birim"), rs.getString("oda_numarasi"), rs.getString("mesaj") });

		}

		rs = null;
		conn.close();
		pst = null;
		arizaTablosu.setRowSelectionInterval(0, 0);
	}

	private void onayMesaj(String hatamesaji) {
		JOptionPane.showMessageDialog(this, hatamesaji);
	}

	private static String tarihGetir() {
		java.util.Date today = new java.util.Date();
		return tarihFormat.format(today.getTime());
	}

	private void tabloGoruntusunuAyarla() {
		DefaultTableCellRenderer sola = new DefaultTableCellRenderer();
		DefaultTableCellRenderer ortala = new DefaultTableCellRenderer();
		sola.setHorizontalAlignment(SwingConstants.LEFT);
		ortala.setHorizontalAlignment(SwingConstants.CENTER);
		arizaTablosu.getColumnModel().getColumn(0).setCellRenderer(ortala);
		arizaTablosu.getColumnModel().getColumn(1).setCellRenderer(ortala);
		arizaTablosu.getColumnModel().getColumn(0).setPreferredWidth(5);
		arizaTablosu.getColumnModel().getColumn(1).setPreferredWidth(5);
		arizaTablosu.getColumnModel().getColumn(2).setPreferredWidth(250);
		arizaTablosu.getColumnModel().getColumn(4).setPreferredWidth(845);
	}
}
