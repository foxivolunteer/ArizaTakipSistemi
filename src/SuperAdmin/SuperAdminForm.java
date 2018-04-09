package SuperAdmin;

import components.IstatistiklerInternalFrame;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class SuperAdminForm extends javax.swing.JFrame {
	private static int BOY;
	private static int EN;
	public String ad, soyAd, sicil;
	private SuperAdminInternalFrame adminEkran = null;
	private GenelArizalarInternalFrame genelArizaEkrani = null;

	public SuperAdminForm(String isim, String soyIsim, String sicil)
			throws PropertyVetoException, ClassNotFoundException, SQLException {
		this.ad = isim;
		this.soyAd = soyIsim;
		this.sicil = sicil;
		initComponents();
		ayarlariYap();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		desktop = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		personelDuzenleme = new javax.swing.JMenuItem();
		istatistikler = new javax.swing.JMenuItem();
		raporlar = new javax.swing.JMenuItem();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Arıza Takip Ekranı");
		desktop.setName("desktop"); // NOI18N
		javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
		desktop.setLayout(desktopLayout);
		desktopLayout.setHorizontalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 816, Short.MAX_VALUE));
		desktopLayout.setVerticalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 504, Short.MAX_VALUE));

		jMenu1.setText("Personel İşlemleri");
		jMenu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu1ActionPerformed(evt);
			}
		});

		personelDuzenleme.setText("Personel Düzenleme");
		personelDuzenleme.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				personelDuzenlemeActionPerformed(evt);
			}
		});
		jMenu1.add(personelDuzenleme);

		istatistikler.setText("İstatistikler");
		istatistikler.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				istatistiklerActionPerformed(evt);
			}
		});
		jMenu1.add(istatistikler);
		raporlar.setText("Raporlar");
		jMenu1.add(raporlar);
		jMenuBar1.add(jMenu1);
		setJMenuBar(jMenuBar1);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desktop));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING));
		pack();
	}

	private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenu1ActionPerformed

	}

	private void personelDuzenlemeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_personelDuzenlemeActionPerformed
		try {
			adminEkran = new SuperAdminInternalFrame();
			adminEkran.setVisible(true);
			desktop.add(adminEkran);
			adminEkran.setSelected(true);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SuperAdminForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SuperAdminForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (PropertyVetoException ex) {
			Logger.getLogger(SuperAdminForm.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void istatistiklerActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			IstatistiklerInternalFrame istatistiklerInternalFrame = new IstatistiklerInternalFrame();
			istatistiklerInternalFrame.setVisible(true);
			desktop.add(istatistiklerInternalFrame);
			istatistiklerInternalFrame.setLocation(0, 0);
			istatistiklerInternalFrame.setSelected(true);
			istatistiklerInternalFrame.setMaximum(true);
		} catch (PropertyVetoException ex) {
			Logger.getLogger(SuperAdminForm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private javax.swing.JDesktopPane desktop;
	private javax.swing.JMenuItem istatistikler;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem personelDuzenleme;
	private javax.swing.JMenuItem raporlar;

	private void ayarlariYap() throws ClassNotFoundException, SQLException, PropertyVetoException {
		genelArizaEkrani = new GenelArizalarInternalFrame();
		genelArizaEkrani.setVisible(true);
		desktop.add(genelArizaEkrani);
		genelArizaEkrani.setMaximum(true);
	}
}
