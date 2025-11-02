package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaBuscaFuncionario extends javax.swing.JDialog {

    public TelaBuscaFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/hotel.png")).getImage());
        initComponents();
    }

    public JButton getjButtonCarregar() {
        return jButtonCarregar;
    }

    public JButton getjButtonFiltar() {
        return jButtonFiltar;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JTable getjTableDados() {
        return jTableDados;
    }

    public JTextField getjTFFiltro() {
        return jTFFiltro;
    }

    public void setjTFFiltro(JTextField jTFFiltro) {
        this.jTFFiltro = jTFFiltro;
    }

    public JComboBox<String> getjCBFiltro() {
        return jCBFiltro;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPaneltitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jPanelFiltros = new javax.swing.JPanel();
        jCBFiltro = new javax.swing.JComboBox<>();
        jLabelFiltrar = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jTFFiltro = new javax.swing.JTextField();
        jButtonCarregar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonFiltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Projeto de Gestão Hoteleira");
        setAlwaysOnTop(true);
        setResizable(false);

        jPaneltitulo.setBackground(new java.awt.Color(153, 255, 102));
        jPaneltitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabelTitulo.setForeground(new java.awt.Color(0, 51, 204));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("BUSCA :: FUNCIONARIO");
        jLabelTitulo.setToolTipText("");

        javax.swing.GroupLayout jPaneltituloLayout = new javax.swing.GroupLayout(jPaneltitulo);
        jPaneltitulo.setLayout(jPaneltituloLayout);
        jPaneltituloLayout.setHorizontalGroup(
                jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPaneltituloLayout.setVerticalGroup(
                jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE));

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Id", "Nome", "CPf", "Status"
                }));
        jTableDados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableDados);
        if (jTableDados.getColumnModel().getColumnCount() > 0) {
            jTableDados.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableDados.getColumnModel().getColumn(1).setMaxWidth(270);
            jTableDados.getColumnModel().getColumn(2).setMaxWidth(150);
            jTableDados.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
                jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1));
        jPanelDadosLayout.setVerticalGroup(
                jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE));

        jPanelFiltros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCBFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nome", "CPF" }));

        jLabelFiltrar.setText("Filtrar Por");

        jLabelValor.setText("Valor");

        jButtonCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Load.png")));
        jButtonCarregar.setText("Carregar");
        jButtonCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarActionPerformed(evt);
            }
        });

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png")));
        jButtonSair.setText("Fechar");

        jButtonFiltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png")));
        jButtonFiltar.setText("Filtar");

        javax.swing.GroupLayout jPanelFiltrosLayout = new javax.swing.GroupLayout(jPanelFiltros);
        jPanelFiltros.setLayout(jPanelFiltrosLayout);
        jPanelFiltrosLayout.setHorizontalGroup(
                jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelFiltrosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                                .addComponent(jButtonCarregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonSair))
                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                                .addGroup(jPanelFiltrosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelFiltrar))
                                                .addGroup(jPanelFiltrosLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jLabelValor)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTFFiltro,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 258,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                                .addComponent(jButtonFiltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        jPanelFiltrosLayout.setVerticalGroup(
                jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanelFiltrosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFiltrar)
                                        .addComponent(jLabelValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelFiltrosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTFFiltro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonFiltar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFiltrosLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCarregar)
                                        .addComponent(jButtonSair))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPaneltitulo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPaneltitulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelDados, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)));

        pack();
        setLocationRelativeTo(null);
    }

    private void jButtonCarregarActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(TelaBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBuscaFuncionario dialog = new TelaBuscaFuncionario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonCarregar;
    private javax.swing.JButton jButtonFiltar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jCBFiltro;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPaneltitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFFiltro;
    private javax.swing.JTable jTableDados;

    public javax.swing.JLabel getjLabelFiltrar() {
        return jLabelFiltrar;
    }

    public javax.swing.JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public javax.swing.JLabel getjLabelValor() {
        return jLabelValor;
    }

    public javax.swing.JPanel getjPanelDados() {
        return jPanelDados;
    }

    public javax.swing.JPanel getjPanelFiltros() {
        return jPanelFiltros;
    }

    public javax.swing.JPanel getjPaneltitulo() {
        return jPaneltitulo;
    }

    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }
}
