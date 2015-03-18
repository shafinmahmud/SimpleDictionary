
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {

    
    public String Mp3string = "";
    public MainFrame() {
        initComponents();
        setLocation(500, 200);
    };

    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user_search_word = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        scrolpane = new javax.swing.JScrollPane();
        pane = new javax.swing.JPanel();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Dictionary");
        setName(""); 
        setResizable(false);

        jLabel1.setText("Word :");

        user_search_word.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_search_wordActionPerformed(evt);
            }
        });

        submit.setText("Search");
        submit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        pane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneLayout = new javax.swing.GroupLayout(pane);
        pane.setLayout(paneLayout);
        paneLayout.setHorizontalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        paneLayout.setVerticalGroup(
            paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        scrolpane.setViewportView(pane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(user_search_word, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(submit))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrolpane, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user_search_word, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit))
                .addGap(27, 27, 27)
                .addComponent(scrolpane)
                .addGap(36, 36, 36))
        );

        pack();
    }

    private void user_search_wordActionPerformed(java.awt.event.ActionEvent evt) {                                                 
         
        
    }                                                

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
        String st = user_search_word.getText();
        if(st != null){
        Image definition;
        definition = null;
        try {
            URL url = new URL("http://www.ovidhan.org/getmeaning.php?word=" + st);
            definition = ImageIO.read(url);

        } catch (IOException e) {
        }
        if (definition == null ) {
            JOptionPane.showMessageDialog(null, "Unable to find !!!");
        } else {
            label.setText("");
            label.setIcon(new ImageIcon(definition));
        }
       }
        user_search_word.setText("");
    }                                      

   
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
           public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    private javax.swing.JPanel pane;
    private javax.swing.JScrollPane scrolpane;
    private javax.swing.JButton submit;
    private javax.swing.JTextField user_search_word;
    
}
