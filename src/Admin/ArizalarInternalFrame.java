/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import loginpages.baglanti;



    




public class ArizalarInternalFrame extends javax.swing.JInternalFrame {

    public Connection conn = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;
    public ArrayList<String> list = new ArrayList<>();
    public String birim, sicil;
    private static final DateFormat tarihFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    DefaultTableModel model = null;
    JDesktopPane desk;
    
    
    
    
    
    
    
    
    public ArizalarInternalFrame(JDesktopPane desk, String isim, String soyIsim, String sicil) throws ClassNotFoundException, SQLException {
        
        this.desk = desk;
        this.sicil = sicil;
        initComponents();
        tabloGoruntusunuAyarla();
        arizaListesiniDoldur();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yenile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        arizaTablosu = new javax.swing.JTable();

        setIconifiable(true);
        setMaximizable(true);
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
        arizaTablosu.setForeground(new java.awt.Color(255, 0, 51));
        arizaTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "KAYDI AÇAN KİŞİ", "BİRİM", "ODA NUMARASI", "HATA MESAJI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            arizaTablosu.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arizaTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arizaTablosuMouseClicked
//        Object o = new Object();
       
        
//        int dialogResult = JOptionPane.showConfirmDialog(this, onayPaneli,"Onay Penceresi",JOptionPane.DEFAULT_OPTION);
        
        Object[] options = {"ONAYLA", "IPTAL"};
        int secilenDeger = JOptionPane.showOptionDialog(null, "Mesaj Onaylanacak Emin misiniz?", "Dikkat!!",
        JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[1]);
                 
        if (secilenDeger == 0)//Secilen deger YES
        {
            try {
                String onaySQL = "UPDATE arizalar SET durum =0, onay_tarihi='"+tarihGetir()+"' WHERE id ='"+model.getValueAt(arizaTablosu.getSelectedRow(),0)+"'";
                conn = baglanti.baglan();
                pst = conn.prepareStatement(onaySQL);
                pst.executeUpdate();
            } catch (ClassNotFoundException ex){
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.getDataVector().removeAllElements();
            try {
                arizaListesiniDoldur();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            arizaTablosu.revalidate();
        }
        else//Secilen deger NO
            
        {
            //birsey yapma.            
            
        }
        
       
        
        
        
        
       
        
    }//GEN-LAST:event_arizaTablosuMouseClicked

    private void yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileActionPerformed
         model.getDataVector().removeAllElements();
            try {
                arizaListesiniDoldur();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ArizalarInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            arizaTablosu.revalidate();
        
        
        
    }//GEN-LAST:event_yenileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable arizaTablosu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton yenile;
    // End of variables declaration//GEN-END:variables

    private void arizaListesiniDoldur() throws ClassNotFoundException, SQLException {
        
            model =(DefaultTableModel) arizaTablosu.getModel();
            String SQL ="SELECT * FROM arizalar WHERE personel = '"+sicil+"' and durum = '1'";
            conn = baglanti.baglan();
            pst = conn.prepareStatement(SQL);
            rs = pst.executeQuery();        
            
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("id"),rs.getString("gonderen_personel"), rs.getString("birim"), rs.getString("oda_numarasi"), rs.getString("mesaj")});
                
            }
            conn.close();
            pst = null;
            rs = null;
    }   
    
    private void onayMesaj(String hatamesaji){      
    JOptionPane.showMessageDialog(this, hatamesaji);
    }
    
    private static String tarihGetir() {
        java.util.Date today = new java.util.Date();
        return tarihFormat.format(today.getTime());
    }

    private void tabloGoruntusunuAyarla(){
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        arizaTablosu.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        arizaTablosu.getColumnModel().getColumn(0).setPreferredWidth(5);
        arizaTablosu.getColumnModel().getColumn(1).setPreferredWidth(5);
        arizaTablosu.getColumnModel().getColumn(2).setPreferredWidth(200);
        arizaTablosu.getColumnModel().getColumn(4).setPreferredWidth(600);
 
    }
}
