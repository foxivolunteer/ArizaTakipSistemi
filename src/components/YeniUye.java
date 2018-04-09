package components;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loginpages.Login;
import loginpages.baglanti;

public class YeniUye extends javax.swing.JDialog {
	public String duzenlenenAdmin;
	public Connection conn = null;
	public PreparedStatement pst = null;
	public PreparedStatement pst2 = null;
	public ResultSet rs = null;
	private static final DateFormat tarihFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public YeniUye(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		ortala();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		uyeAd = new javax.swing.JTextField();
		uyeSoyad = new javax.swing.JTextField();
		uyeSifre = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		uyeSicil = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		uyeBirim = new javax.swing.JTextField();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Yeni Üye Kayıt Formu");
		setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel1.setText("Ad");
		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("Soy Ad");
		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel3.setText("Şifre");
		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel5.setText("Sicil");
		jButton1.setText("Kaydet");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("İptal");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel6.setText("Çalıştığınız Birim");
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(77, 77, 77)
						.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(70, 70, 70))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel5).addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel6)
								.addComponent(jLabel3))
						.addGap(106, 106, 106)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(uyeSicil).addComponent(uyeSifre).addComponent(uyeBirim)
								.addComponent(uyeSoyad).addComponent(uyeAd))
						.addGap(57, 57, 57)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addComponent(uyeAd,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(
										jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(jLabel1)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(uyeSoyad, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(uyeSicil, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3).addComponent(uyeSifre, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(uyeBirim, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addGap(49, 49, 49)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2))
						.addContainerGap(17, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		this.dispose();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		String uyeAdi, uyeSoyadi, uyeSicili, uyeDuzenlenenSicil, uyeSifresi, uyeDurumu = "Aktif";
		uyeAdi = uyeAd.getText().replace(" ", "");
		uyeSoyadi = uyeSoyad.getText().replace(" ", "");
		uyeSicili = uyeSicil.getText().replace(" ", "");
		uyeSifresi = uyeSifre.getText();
		int yetki = 3, gorev = 0;
		String uyeKaydetSQL = "INSERT INTO user (sicil, password, ad, soyad, yetki, gorev, durum, tarih) "
				+ "VALUES (UPPER('" + uyeSicili + "'),'" + uyeSifresi + "','" + uyeAdi + "','" + uyeSoyadi + "'," + "'"
				+ yetki + "','" + gorev + "','" + uyeDurumu + "','" + tarihGetir() + "')";
		String uyeVarmiSQL = "SELECT * FROM user WHERE sicil ='" + uyeSicili + "'";
		try {
			conn = baglanti.baglan();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(YeniUye.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			pst = conn.prepareStatement(uyeVarmiSQL);
		} catch (SQLException ex) {
			Logger.getLogger(YeniUye.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			pst2 = conn.prepareStatement(uyeKaydetSQL);
		} catch (SQLException ex) {
			Logger.getLogger(YeniUye.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (uyeAdi.isEmpty() || uyeSoyadi.isEmpty() || uyeSicili.isEmpty() || uyeSifresi.isEmpty()) {
			hatamesaj("BOŞ ALAN BIRAKMAYINIZ!!");

		} else {
			try {
				rs = pst.executeQuery();
			} catch (SQLException ex) {
				Logger.getLogger(YeniUye.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				if (rs.next()) {

					hatamesaj("BU SİCİL İLE DAHA ÖNCEDEN KAYIT YAPILMIŞ \n"
							+ "ŞİFRENİZİ UNUTTUYSANIZ BİLGİ İŞLEM İLE GÖRÜŞÜNÜZ...");
				} else {

					pst2.executeUpdate();
					hatamesaj("KAYIT BAŞARIYLA TAMAMLANDI!\n SİCİL VE ŞİFRENİZ İLE OTURUM AÇABİLİRSİNİZ");
					conn.close();
					conn = null;
					pst = null;
					pst2 = null;
					this.dispose();
				}
			} catch (SQLException ex) {
				Logger.getLogger(YeniUye.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField uyeAd;
	private javax.swing.JTextField uyeBirim;
	private javax.swing.JTextField uyeSicil;
	private javax.swing.JTextField uyeSifre;
	private javax.swing.JTextField uyeSoyad;
	// End of variables declaration//GEN-END:variables

	private void hatamesaj(String hata) {
		JOptionPane.showMessageDialog(this, hata);
	}

	private static String tarihGetir() {
		java.util.Date today = new java.util.Date();
		return tarihFormat.format(today.getTime());
	}

	private void ortala() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		this.setLocation(x, y);
	}
}
