package microestrutura;

import javax.swing.WindowConstants;

/**
 *
 * @author Mateus Junges <contato@mateusjunges.com>
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fundo = new javax.swing.JPanel();
        jpanel_header = new javax.swing.JPanel();
        text_title = new java.awt.Label();
        jpanel_footer = new javax.swing.JPanel();
        label_myName = new java.awt.Label();
        label_curso = new java.awt.Label();
        jPanel_center = new javax.swing.JPanel();
        jPanel_centerHeader = new javax.swing.JPanel();
        label_explicacao = new java.awt.Label();
        jPanel_content = new javax.swing.JPanel();
        lable_T = new java.awt.Label();
        lable_h = new java.awt.Label();
        lable_alpha = new java.awt.Label();
        label_dR = new java.awt.Label();
        label_dr0 = new java.awt.Label();
        text_T = new javax.swing.JTextField();
        text_h = new javax.swing.JTextField();
        text_alpha = new javax.swing.JTextField();
        text_dR = new javax.swing.JTextField();
        text_dR0 = new javax.swing.JTextField();
        label_exp_T = new java.awt.Label();
        label_exp_h = new java.awt.Label();
        label_exp_alpha = new java.awt.Label();
        label_exp_dR = new java.awt.Label();
        label_exp_dR0 = new java.awt.Label();
        button_desenhar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_fundo.setBackground(new java.awt.Color(255, 255, 255));

        jpanel_header.setBackground(new java.awt.Color(255, 255, 255));

        text_title.setAlignment(java.awt.Label.CENTER);
        text_title.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        text_title.setText("Superfície Microestruturada");

        javax.swing.GroupLayout jpanel_headerLayout = new javax.swing.GroupLayout(jpanel_header);
        jpanel_header.setLayout(jpanel_headerLayout);
        jpanel_headerLayout.setHorizontalGroup(
            jpanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(text_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanel_headerLayout.setVerticalGroup(
            jpanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_headerLayout.createSequentialGroup()
                .addComponent(text_title, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpanel_footer.setBackground(new java.awt.Color(255, 255, 255));

        label_myName.setAlignment(java.awt.Label.CENTER);
        label_myName.setBackground(new java.awt.Color(255, 255, 255));
        label_myName.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        label_myName.setText("Mateus Junges");

        label_curso.setAlignment(java.awt.Label.CENTER);
        label_curso.setBackground(new java.awt.Color(255, 255, 255));
        label_curso.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        label_curso.setText("Engenharia de Computação");

        javax.swing.GroupLayout jpanel_footerLayout = new javax.swing.GroupLayout(jpanel_footer);
        jpanel_footer.setLayout(jpanel_footerLayout);
        jpanel_footerLayout.setHorizontalGroup(
            jpanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_myName, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(label_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpanel_footerLayout.setVerticalGroup(
            jpanel_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_myName, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(label_curso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_center.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_centerHeader.setBackground(new java.awt.Color(255, 255, 255));

        label_explicacao.setAlignment(java.awt.Label.CENTER);
        label_explicacao.setFont(new java.awt.Font("DialogInput", 0, 36)); // NOI18N
        label_explicacao.setText("Informe os parâmetros necessários:");

        javax.swing.GroupLayout jPanel_centerHeaderLayout = new javax.swing.GroupLayout(jPanel_centerHeader);
        jPanel_centerHeader.setLayout(jPanel_centerHeaderLayout);
        jPanel_centerHeaderLayout.setHorizontalGroup(
            jPanel_centerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_explicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        jPanel_centerHeaderLayout.setVerticalGroup(
            jPanel_centerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_explicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel_content.setBackground(new java.awt.Color(255, 255, 255));

        lable_T.setAlignment(java.awt.Label.CENTER);
        lable_T.setBackground(new java.awt.Color(255, 255, 255));
        lable_T.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lable_T.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lable_T.setText("T:");

        lable_h.setBackground(new java.awt.Color(255, 255, 255));
        lable_h.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lable_h.setName("h:"); // NOI18N
        lable_h.setText("h:");

        lable_alpha.setBackground(new java.awt.Color(255, 255, 255));
        lable_alpha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lable_alpha.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lable_alpha.setText("α:");

        label_dR.setBackground(new java.awt.Color(255, 255, 255));
        label_dR.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        label_dR.setText("dR:");

        label_dr0.setBackground(new java.awt.Color(255, 255, 255));
        label_dr0.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        label_dr0.setText("dR0:");

        text_T.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        text_T.setToolTipText("Quantidade de Riblets a serem desenhados");
        text_T.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text_h.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        text_h.setToolTipText("Altura da base ao topo do Riblet. Igual para todos.");
        text_h.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text_alpha.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        text_alpha.setToolTipText("Ângulo de abertura no topo do Riblet");
        text_alpha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text_dR.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        text_dR.setToolTipText("Distância entre os centros de cada um dos Riblets");
        text_dR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        text_dR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_dRActionPerformed(evt);
            }
        });

        text_dR0.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        text_dR0.setToolTipText("Distância do início até o centro do primeiro Riblet");
        text_dR0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_exp_T.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label_exp_T.setName(""); // NOI18N
        label_exp_T.setText("Informe o tamanho da amostra");

        label_exp_h.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label_exp_h.setText("Informe a altura do Riblet:");

        label_exp_alpha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label_exp_alpha.setText("Informe o angulo do topo do Riblet:");

        label_exp_dR.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label_exp_dR.setText("Informe a distância entre os centros dos Riblets");

        label_exp_dR0.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label_exp_dR0.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label_exp_dR0.setName(""); // NOI18N
        label_exp_dR0.setText("Informe a distância do início para o primeiro Riblet");

        javax.swing.GroupLayout jPanel_contentLayout = new javax.swing.GroupLayout(jPanel_content);
        jPanel_content.setLayout(jPanel_contentLayout);
        jPanel_contentLayout.setHorizontalGroup(
            jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_contentLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lable_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lable_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lable_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dr0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_exp_dR0, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(label_exp_T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_T)
                    .addComponent(text_h)
                    .addComponent(text_dR)
                    .addComponent(label_exp_h, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_alpha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_exp_alpha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_dR0)
                    .addComponent(label_exp_dR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );
        jPanel_contentLayout.setVerticalGroup(
            jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_contentLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(label_exp_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_T)
                    .addComponent(lable_T, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(label_exp_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_contentLayout.createSequentialGroup()
                        .addComponent(text_h, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_exp_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel_contentLayout.createSequentialGroup()
                        .addComponent(lable_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_contentLayout.createSequentialGroup()
                        .addComponent(lable_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(jPanel_contentLayout.createSequentialGroup()
                        .addComponent(text_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(label_exp_dR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_dR, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(label_exp_dR0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_dr0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_dR0, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        text_T.getAccessibleContext().setAccessibleName("");

        button_desenhar.setBackground(new java.awt.Color(4, 137, 6));
        button_desenhar.setText("Desenhar");
        button_desenhar.setToolTipText("Desenhar os riblets com os dados informados");
        button_desenhar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_desenharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_centerLayout = new javax.swing.GroupLayout(jPanel_center);
        jPanel_center.setLayout(jPanel_centerLayout);
        jPanel_centerLayout.setHorizontalGroup(
            jPanel_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_centerHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_centerLayout.createSequentialGroup()
                        .addComponent(jPanel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_centerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_desenhar, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel_centerLayout.setVerticalGroup(
            jPanel_centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_centerLayout.createSequentialGroup()
                .addComponent(jPanel_centerHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_desenhar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_fundoLayout = new javax.swing.GroupLayout(panel_fundo);
        panel_fundo.setLayout(panel_fundoLayout);
        panel_fundoLayout.setHorizontalGroup(
            panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpanel_footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_fundoLayout.setVerticalGroup(
            panel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fundoLayout.createSequentialGroup()
                .addComponent(jpanel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanel_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_dRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_dRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_dRActionPerformed

    private void button_desenharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_desenharMouseClicked
        // TODO add your handling code here:
        String s_tamanho_amostra = text_T.getText();
        String s_altura = text_h.getText();
        String s_alpha = text_alpha.getText();
        String s_dR = text_dR.getText();
        String s_dR_0 = text_dR0.getText();
        
        //Verifica se um dos parâmetros está vazio:
        if (s_tamanho_amostra.isEmpty() || s_altura.isEmpty() || s_alpha.isEmpty() || s_dR.isEmpty() || s_dR_0.isEmpty()){
            modal_CamposIncompletos modal = new modal_CamposIncompletos();
            modal.setLocationRelativeTo(this);
            modal_CamposIncompletos.setLabelTitle("Ops...");
            modal_CamposIncompletos.setLabelDescription("Preencha todos os campos!");
            modal.setSize(400, 400);
            modal.setVisible(true);
        }else{ //se os campos são válidos:
            int tamanho_amostra; //tamnaho da amostra
            float altura; //altura do riblet
            float alpha; //angulo de abertura do  riblet
            float dR; //distancia entre os centros dos riblets
            float dR_0; //distancia do inicio até o primeiro riblet
            
            
            tamanho_amostra = Integer.parseInt(s_tamanho_amostra); //converte a variavel de string para float
            altura = Float.parseFloat(s_altura); //converte a variavel de string para float
            alpha = Float.parseFloat(s_alpha); //converte a variavel de string para float
            dR = Float.parseFloat(s_dR); //converte a variavel de string para float
            dR_0 = Float.parseFloat(s_dR_0); //converte a variavel de string para float  
            
            Riblet r = new Riblet( tamanho_amostra, altura, alpha, dR, dR_0);

            r.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            r.setSize(820,620);
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        }      
    }//GEN-LAST:event_button_desenharMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            TelaInicial tela = new TelaInicial();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton button_desenhar;
    private static javax.swing.JPanel jPanel_center;
    private javax.swing.JPanel jPanel_centerHeader;
    private javax.swing.JPanel jPanel_content;
    private javax.swing.JPanel jpanel_footer;
    private javax.swing.JPanel jpanel_header;
    private java.awt.Label label_curso;
    private java.awt.Label label_dR;
    private java.awt.Label label_dr0;
    private java.awt.Label label_exp_T;
    private java.awt.Label label_exp_alpha;
    private java.awt.Label label_exp_dR;
    private java.awt.Label label_exp_dR0;
    private java.awt.Label label_exp_h;
    private java.awt.Label label_explicacao;
    private static java.awt.Label label_myName;
    private java.awt.Label lable_T;
    private java.awt.Label lable_alpha;
    private java.awt.Label lable_h;
    private javax.swing.JPanel panel_fundo;
    private static javax.swing.JTextField text_T;
    private static javax.swing.JTextField text_alpha;
    private static javax.swing.JTextField text_dR;
    private static javax.swing.JTextField text_dR0;
    private static javax.swing.JTextField text_h;
    private java.awt.Label text_title;
    // End of variables declaration//GEN-END:variables
}
