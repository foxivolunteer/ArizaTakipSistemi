/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import loginpages.Login;
import loginpages.baglanti;

/**
 *
 * @author Administrator
 */
public class KullaniciFormInternalFrame extends javax.swing.JInternalFrame {

    public Connection conn = null;
    public PreparedStatement pst = null;
    public PreparedStatement pst2 = null;
    public ResultSet rs = null;
    public ResultSet rs2 = null;
    public ArrayList<String> list = new ArrayList<>();
    public String ad, soyAd, sicil;
    private static final DateFormat tarihFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public KullaniciFormInternalFrame() throws ClassNotFoundException, SQLException {
        initComponents();
        birimleriYukle();
        ayarlariYap();

    }

    private void ortala() {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        this.setLocation(x, y - 20);

    }

    public KullaniciFormInternalFrame(String ad, String soyAd, String sicil) throws ClassNotFoundException, SQLException {
        this.ad = ad;
        this.soyAd = soyAd;
        this.sicil = sicil;
        initComponents();
        birimleriYukle();
        ortala();
        ayarlariYap();
    }

    private void ayarlariYap() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("<html>Sol taraftan çalıştığınız birimi seçtikten sonra oda ve dahili telefon numaranızı girin.<br>").
                append("Kayıt formunu kaydet butonuna basarak kaydedebilirsiniz. Sorun ile ilgili kısa süre içerisinde ilgilenilecektir...</html>");
        mesaj.setText(sb.toString());
        ziyaretci.setText(this.getAd() + " " + this.getSoyAd());
    }

    private static String tarihGetir() {
        java.util.Date today = new java.util.Date();
        return tarihFormat.format(today.getTime());
    }

    private void birimleriYukle() throws ClassNotFoundException, SQLException {
        conn = baglanti.baglan();
        try {
            String sql = "SELECT * FROM birimler";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                list.add(rs.getString("birimler"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListModel ls = new AbstractListModel() {

            @Override
            public int getSize() {
                return list.size();
            }

            @Override
            public Object getElementAt(int index) {
                return list.get(index);
            }
        };
        jList1.setModel(ls);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ziyaretci = new javax.swing.JLabel();
        mesaj = new javax.swing.JLabel();
        odaNo = new javax.swing.JTextField();
        dahiliNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hataMesaj = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        kaydet = new javax.swing.JButton();
        temizle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arıza Takip Sistemi");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arıza Kayıt Formu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        jList1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList1.setToolTipText("");
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.setName("birimlerlistesi"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Çalıştığınız Birim");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Merhaba");

        ziyaretci.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ziyaretci.setForeground(new java.awt.Color(255, 0, 51));
        ziyaretci.setText("adSoyad");

        mesaj.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mesaj.setForeground(new java.awt.Color(0, 0, 255));
        mesaj.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        mesaj.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mesaj.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Oda Numarası");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Dahili Telefon Numarası");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        hataMesaj.setColumns(10);
        hataMesaj.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        hataMesaj.setLineWrap(true);
        hataMesaj.setRows(8);
        hataMesaj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hataMesajKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(hataMesaj);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Yaşanılan Sorun");

        kaydet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kaydet.setForeground(new java.awt.Color(0, 0, 255));
        kaydet.setText("KAYDET");
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });

        temizle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        temizle.setForeground(new java.awt.Color(0, 0, 255));
        temizle.setText("TEMİZLE");
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(ziyaretci))
                            .addComponent(mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(temizle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(odaNo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(dahiliNo)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)))
                .addGap(89, 89, 89))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ziyaretci))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(odaNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dahiliNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kaydet)
                            .addComponent(temizle))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
        odaNo.setText("");
        dahiliNo.setText("");
        hataMesaj.setText("");
    }//GEN-LAST:event_temizleActionPerformed

    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed

        String birimi = null;
        String odaNumarasi = null;
        String dahili = null;
        String uyemesaj = null;
        String personel = null;
        int arizaDurumu = 1;
        Integer secilen = null;
        boolean kayit = false;
        int formKontrol = 0;

        secilen = jList1.getSelectedIndex();
        odaNumarasi = odaNo.getText();
        dahili = dahiliNo.getText();
        uyemesaj = hataMesaj.getText();
        try {
            baglanti.baglantiKapat(conn);
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (secilen != -1) {
            birimi = jList1.getModel().getElementAt(secilen).toString();
            kayit = true;
        }

        if (secilen == -1) {
            hatamesaj("Sol Menüden Birim Seçin!!");
        } else if (odaNumarasi.isEmpty()) {
            hatamesaj("Oda Numaranızı Girin!!");
        } else if (dahili.isEmpty()) {
            hatamesaj("Dahhili Telefon Numaranızı Girin!!" + "\n" + "Örn: 5660 - 4552 - YOK");
        } else if (uyemesaj.isEmpty()) {
            hatamesaj("Sorun İle İlgili Açıklama Girin!!");
        }

        if (!odaNumarasi.isEmpty() && !dahili.isEmpty() && !uyemesaj.isEmpty() && kayit) {

            try {

                String hangiAdminSQL = "SELECT * FROM user WHERE yetki = '5' AND durum ='Aktif' ORDER BY ariza_tarih ASC LIMIT 1  ";
                conn = null;
                conn = baglanti.baglan();
                pst2 = conn.prepareStatement(hangiAdminSQL);
                rs2 = pst2.executeQuery();
                if (rs2.next()) {
                    personel = rs2.getString("sicil");
                }
                conn.close();
                pst2 = null;
                rs2 = null;

                try {
                    conn = baglanti.baglan();
                    String hataSQL = "INSERT INTO arizalar (birim, oda_numarasi, dahili, mesaj, mesaj_tarihi, "
                            + "personel, gonderen_personel, durum) VALUES ('" + birimi + "', '" + odaNumarasi + "', '" + dahili + "', '" + uyemesaj + "',"
                            + " '" + tarihGetir() + "', '" + personel + "','" + sicil + "', '" + arizaDurumu + "')";
                    String adminTarihGuncelleSQL = "UPDATE user SET ariza_tarih = '" + tarihGetir() + "' WHERE sicil ='" + personel + "'";

                    pst = conn.prepareStatement(hataSQL);
                    pst.executeUpdate();
                    pst2 = conn.prepareStatement(adminTarihGuncelleSQL);
                    pst2.executeUpdate();

                    hatamesaj("Mesajınız Kaydedilmiştir. Yetkili Personel En Kısa Sürede Sorun İle İlgilenecektir\n"
                            + " Başka Kayıt Açmayınız.!!");

                    if (pst != null) {
                        try {
                            pst.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    this.dispose();
                    System.exit(0);

                } catch (ClassNotFoundException ex) {
                    hatamesaj("BİLİNMEYEN BİR HATA OLUŞTU!!");
                    Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    hatamesaj("BİLİNMEYEN BİR HATA OLUŞTU!!");
                    Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (pst != null) {
                        try {
                            pst.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(KullaniciFormInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_kaydetActionPerformed

    private void hataMesajKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hataMesajKeyPressed
//         if(hataMesaj.getText().length()>=100)
//    {
//        hataMesaj.setText(hataMesaj.getText().substring(0, 100));
//    }
    }//GEN-LAST:event_hataMesajKeyPressed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new ClientForm().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dahiliNo;
    private javax.swing.JTextArea hataMesaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kaydet;
    private javax.swing.JLabel mesaj;
    private javax.swing.JTextField odaNo;
    private javax.swing.JButton temizle;
    private javax.swing.JLabel ziyaretci;
    // End of variables declaration//GEN-END:variables

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    private void hatamesaj(String hata) {
        JOptionPane.showMessageDialog(this, hata);
    }

}
