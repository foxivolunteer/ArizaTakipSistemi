/*
/*  YETKİ = 3 EN ALT SEVİYE KULLANICI
 *  YETKİ = 5 ORTA SEVİYE PERSONEL 
 *  YETKİ = 0 EN ÜST SEVİYE SÜPER ADMİN
 */

package loginpages;

import Admin.PersonelForm;
import SuperAdmin.SuperAdminForm;
import Client.KullaniciForm;
import components.YeniUye;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class Login extends javax.swing.JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	KullaniciForm kullaniciForm = null;
	SuperAdminForm adminForm = null;
	PersonelForm personelForm = null;

	public Login() throws ClassNotFoundException, SQLException {
		initComponents();
		conn = baglanti.baglan();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		pass = new javax.swing.JLabel();
		username = new javax.swing.JTextField();
		password = new javax.swing.JPasswordField();
		uname = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		hata = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Arıza Takip Sistemi");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setResizable(false);
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Aharoni", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N
		pass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		pass.setText("ŞİFRE");
		username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		uname.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		uname.setText("KULLANICI ADI (ABSİCİL)");
		jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jButton1.setText("LOGIN");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jButton2.setText("KAPAT");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jButton3.setText("Yeni Üye");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel1.setText("* Kullanıcı adı ve şifreniz yok ise yeni üye butonuna basın.");

		jLabel2.setText("*Arıza kaydı açmak için kullanıcı adınızı (sicilinizi) ve şifrenizi giriniz.");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
								.addComponent(uname, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18, 18, 18).addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(79, 79, 79)
										.addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(6, 6, 6))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jButton3)
												.addGap(26, 26, 26)))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(77, 77, 77)
												.addComponent(jButton2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButton1))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(64, 64, 64).addComponent(
												password, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
												javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGap(50, 50, 50))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(uname).addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(22, 22, 22)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pass).addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2).addComponent(jButton3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
						.addContainerGap(13, Short.MAX_VALUE)));

		hata.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
		hata.setForeground(new java.awt.Color(204, 0, 0));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(hata,
								javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(58, 58, 58)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(hata, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			// String sql = "SELECT * FROM user WHERE username ='"+username.getText()+"' and
			// password ='"+password.getText()+"'" ;
			String sql = "SELECT * FROM user WHERE sicil =? and  password =?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username.getText());
			pst.setString(2, password.getText());
			rs = pst.executeQuery();

			while (rs.next()) {
				String isim = rs.getString("ad");
				String soyIsim = rs.getString("soyad");
				String sicil = rs.getString("sicil");
				int durum = rs.getInt("yetki");

				if (durum == 0) {
					adminForm = new SuperAdminForm(isim, soyIsim, sicil);
					adminForm.setVisible(true);
					this.dispose();
				} else if (durum == 5) {
					personelForm = new PersonelForm(isim, soyIsim, sicil);
					personelForm.setVisible(true);
					this.dispose();

				} else if (durum == 3) {
					kullaniciForm = new KullaniciForm(isim, soyIsim, sicil);
					kullaniciForm.setVisible(true);
					this.dispose();

				} else {

					hataMesaj("BİLİNMEYEN KULLANICI");

				}

			}
			Timer timer = new Timer(2000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					hata.setText("");
					repaint();
				}

			});
			timer.setRepeats(false);
			timer.setCoalesce(true);
			timer.start();

			hata.setText("KULLANICI ADI VEYA ŞİFRE HATALI!!");

		} catch (SQLException | ClassNotFoundException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (PropertyVetoException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
		}

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		YeniUye uyeForm = new YeniUye(this, true);
		uyeForm.setVisible(true);

	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Login Login = new Login();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = Login.getSize().width;
					int h = Login.getSize().height;
					int x = (dim.width - w) / 2;
					int y = (dim.height - h) / 2;
					Login.setLocation(x, y);
					Login.setVisible(true);
					// Determine the new location of the window

				} catch (ClassNotFoundException ex) {
					Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				} catch (SQLException ex) {
					Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel hata;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel pass;
	private javax.swing.JPasswordField password;
	private javax.swing.JLabel uname;
	private javax.swing.JTextField username;
	// End of variables declaration//GEN-END:variables

	private void hataMesaj(String hatamesaji) {
		JOptionPane.showMessageDialog(this, hatamesaji);

	}
}
