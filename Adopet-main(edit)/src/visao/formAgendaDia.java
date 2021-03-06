/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import ModeloDao.DaoAgenda;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConection.ConexaoBD;

/**
 *
 * @author USUARIO
 */
public class formAgendaDia extends javax.swing.JFrame {
ConexaoBD conex=new ConexaoBD();
BeansAgenda agenda=new BeansAgenda();
BeansAgenda agen=new BeansAgenda();
DaoAgenda daoAgenda= new DaoAgenda();
String dtHoje;
String status;
    /**
     * Creates new form formAg
     */
    public formAgendaDia() {
        initComponents();
        Calendar data = Calendar.getInstance();
        Date d =data.getTime();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format(d);
        
        
        dtHoje=dateFormat.format(d);
        status="aberto";
        
        preencherTabela("select * from agendamento inner join clientes on agenda_cliente_id=cliente_id inner join pets on agenda_pet_id=id_pet where agenda_data ='"+dtHoje+"'and agenda_status='"+status+"' order by agenda_turno");
    }
public void preencherTabela(String Sql){ //METODO PRENCHER TABELAS
    ArrayList dados=new ArrayList();
    String[]colunas=new String[]{"ID","Nome","Turno","Data","Pet","Status"};
    conex.conexao();
    conex.executaSql(Sql);
    try{
        conex.rs.first();
        do{
            dados.add(new Object[]{conex.rs.getInt("agenda_codigo"),conex.rs.getString("cliente_nome"),conex.rs.getString("agenda_turno"),conex.rs.getString("agenda_data"),conex.rs.getString("nome_pet"), conex.rs.getString("agenda_status")}); //inserindo array nas tabelas
        }while(conex.rs.next());
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(rootPane, "N??o h?? atendimento hoje");
        
    }
    ModeloTabela modelo= new ModeloTabela(dados, colunas);
    tabelaAgenda.setModel(modelo);
   tabelaAgenda.getColumnModel().getColumn(0).setPreferredWidth(30);
    tabelaAgenda.getColumnModel().getColumn(0).setResizable(false);
    tabelaAgenda.getColumnModel().getColumn(1).setPreferredWidth(180);
    tabelaAgenda.getColumnModel().getColumn(1).setResizable(false);
    tabelaAgenda.getColumnModel().getColumn(2).setPreferredWidth(180);
    tabelaAgenda.getColumnModel().getColumn(2).setResizable(false);
    tabelaAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
   tabelaAgenda.getColumnModel().getColumn(3).setResizable(false);
    tabelaAgenda.getColumnModel().getColumn(4).setPreferredWidth(80);
   tabelaAgenda.getColumnModel().getColumn(4).setResizable(false);
    tabelaAgenda.getColumnModel().getColumn(5).setPreferredWidth(80);
   tabelaAgenda.getColumnModel().getColumn(5).setResizable(false);
    
    tabelaAgenda.getTableHeader().setReorderingAllowed(false);
    tabelaAgenda.setAutoResizeMode(tabelaAgenda.AUTO_RESIZE_OFF);//impede o usurio de alterar tamanho da tabela
    tabelaAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    conex.desconecta();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgenda);

        jLabel2.setText("Agendamento do dia");

        jButton1.setText("Encaminhar para Canil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/agenda_icone.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 193));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agenda do Dia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(808, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    daoAgenda.alterar(agen);
   preencherTabela("select * from agendamento inner join clientes on agenda_cliente_id=cliente_id inner join pets on agenda_pet_id=id_pet where agenda_data ='"+dtHoje+"'and agenda_status='"+status+"' order by agenda_turno");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendaMouseClicked
String agenda_cod=""+tabelaAgenda.getValueAt(tabelaAgenda.getSelectedRow(),0);
        conex.conexao();
        conex.executaSql("select * from agendamento where agenda_codigo='"+agenda_cod+"'");
        try{
            conex.rs.first();
            agen.setStatus("atendimento");
            agen.setAgendaCod(conex.rs.getInt("agenda_codigo"));
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Selecionar dados" + ex);
        }
       

        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAgendaMouseClicked

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
            java.util.logging.Logger.getLogger(formAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAgendaDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formAgendaDia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAgenda;
    // End of variables declaration//GEN-END:variables
}
