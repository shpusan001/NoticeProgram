/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciever;

import java.awt.Color;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 * @공지를 받아서 표시하는 화면
 * @반복자 패턴
 *
 * @author 이상훈
 */
public class UserPage extends javax.swing.JFrame implements JFrameColor {

    /**
     * Creates new form UserPage
     */
    String id;
    DefaultListModel listModel = new DefaultListModel();

    public UserPage() {
    }

    public UserPage(String _id) {
        initComponents();
        id = _id;
        tf_id.setText(id);
        list_title.setModel(listModel);
        SqlController.getSqlController().sqlConnect();
        loadNotice();
        changeColor(ThemeManager.getThemeManager().color);
    }

    @Override
    public void changeColor(Color _color) {
        this.getContentPane().setBackground(_color);
    }

    public void loadNotice() {
        listModel.clear();
        LoadNoticeManager.getLoadNoticeManager().loadNotice(id);
        Iterator<NoticePack> iterator = LoadNoticeManager.getLoadNoticeManager().notices.iterator();
        while (iterator.hasNext()) {
            listModel.addElement(iterator.next().getTitle());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list_title = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tp_content = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        btn_refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mbtn_setting = new javax.swing.JMenu();
        mbtn_changeTheme = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notice Program (Reciever)");

        list_title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list_titleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(list_title);

        jLabel1.setText("Messages");

        tp_content.setEditable(false);
        jScrollPane5.setViewportView(tp_content);

        jLabel2.setText("Contents");

        jLabel3.setText("User id");

        tf_id.setEditable(false);
        tf_id.setFocusable(false);

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        mbtn_setting.setText("Setting");

        mbtn_changeTheme.setText("Change Theme");
        mbtn_changeTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbtn_changeThemeActionPerformed(evt);
            }
        });
        mbtn_setting.add(mbtn_changeTheme);

        jMenuBar1.add(mbtn_setting);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_refresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        loadNotice();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void list_titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_titleMousePressed
        // TODO add your handling code here:
        int select = list_title.getSelectedIndex();
        String content = LoadNoticeManager.getLoadNoticeManager().notices.get(select).getContent();
        String date = LoadNoticeManager.getLoadNoticeManager().notices.get(select).getDate();
        String year = date.substring(0, 4);
        String month = date.substring(3, 5);
        String day = date.substring(5, 7);
        date = year + "-" + month + "-" + day;
        String result = "수신날짜:[" + date + "]\n" + content;
        tp_content.setText(result);
    }//GEN-LAST:event_list_titleMousePressed

    private void mbtn_changeThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbtn_changeThemeActionPerformed
        // TODO add your handling code here:
        ThemeManager.getThemeManager().toggleTheme();
        changeColor(ThemeManager.getThemeManager().color);
    }//GEN-LAST:event_mbtn_changeThemeActionPerformed

    /**
     * @param args the command line arguments
     */
    public void run(String _id) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new UserPage(_id).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> list_title;
    private javax.swing.JMenuItem mbtn_changeTheme;
    private javax.swing.JMenu mbtn_setting;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextPane tp_content;
    // End of variables declaration//GEN-END:variables
}
