package br.com.furb.groupad_client.view;

import javax.swing.JOptionPane;

public class TelaArquivo extends javax.swing.JFrame {

    private boolean naFilaDeEdicao = false;
    private boolean editando = false;

    public TelaArquivo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldURLArquivo = new javax.swing.JTextField();
        jButtonVai = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSolicitaEdicao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaConteudoArquivo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome arquivo:");

        jButtonVai.setText("Vai!");
        jButtonVai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaiActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSolicitaEdicao.setText("Pedir para editar");
        jButtonSolicitaEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolicitaEdicaoActionPerformed(evt);
            }
        });

        jTextAreaConteudoArquivo.setEditable(false);
        jTextAreaConteudoArquivo.setColumns(20);
        jTextAreaConteudoArquivo.setRows(5);
        jScrollPane2.setViewportView(jTextAreaConteudoArquivo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldURLArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVai))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addComponent(jButtonSolicitaEdicao)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldURLArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSolicitaEdicao))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButtonVaiActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (editando) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar alterações feitas?", "Você tem permissão para salvar", JOptionPane.INFORMATION_MESSAGE);
            switch (opcao) {
                case JOptionPane.OK_OPTION:
                    //salva
                    editando = false;
                    break;
                case JOptionPane.NO_OPTION:
                    //Avisa que acabou de editar e vai para outra pagina
                    editando = false;
                    break;
                default:
                    // não faz nada
                    break;
            }
        } else if (naFilaDeEdicao) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja sair da fila de edição?", "Você está na fila", JOptionPane.INFORMATION_MESSAGE);
            switch (opcao) {
                case JOptionPane.OK_OPTION:
                    //avisa que vai sair da fila
                    break;
                default:
                    //não faz nada
            }
        }
    }                                          

    private void jButtonSolicitaEdicaoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        //Pede para editar
        naFilaDeEdicao = true;
        //Se tiver autorização:
        editando = true;
        naFilaDeEdicao = false;
        jTextAreaConteudoArquivo.setEditable(true);
        jButtonSalvar.setEnabled(true);
    }                                                     

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //Salva arquivo (put)
        jTextAreaConteudoArquivo.setEditable(false);
        jButtonSalvar.setEnabled(false);
        editando = false;
    }                                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArquivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArquivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSolicitaEdicao;
    private javax.swing.JButton jButtonVai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaConteudoArquivo;
    private javax.swing.JTextField jTextFieldURLArquivo;
    // End of variables declaration                   
}
