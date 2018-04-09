package Admin;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.JFrame;

public class PersonelForm extends javax.swing.JFrame {

	private static int BOY;
	private static int EN;
	public String ad, soyAd, sicil;
	private ArizalarInternalFrame arizaEkran = null;

	public PersonelForm(String isim, String soyIsim, String sicil)
			throws PropertyVetoException, ClassNotFoundException, SQLException {
		this.ad = isim;
		this.soyAd = soyIsim;
		this.sicil = sicil;
		initComponents();
		ayarlariYap();
		arizalariYukle();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		desktop = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Arıza Takip Ekranı");

		desktop.setName("desktop"); // NOI18N

		javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
		desktop.setLayout(desktopLayout);
		desktopLayout.setHorizontalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 816, Short.MAX_VALUE));
		desktopLayout.setVerticalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 431, Short.MAX_VALUE));

		jMenu1.setText("Arızalar");
		jMenu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu1ActionPerformed(evt);
			}
		});
		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desktop));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desktop));

		pack();
	}

	private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	// Form Components
	private javax.swing.JDesktopPane desktop;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;

	private void arizalariYukle() throws PropertyVetoException, ClassNotFoundException, SQLException {
		arizaEkran = new ArizalarInternalFrame(desktop, ad, soyAd, sicil);
		desktop.add(arizaEkran);
		arizaEkran.setMaximum(true);
		arizaEkran.show();
	}

	private void ayarlariYap() {
		// do nothing
	}

}
