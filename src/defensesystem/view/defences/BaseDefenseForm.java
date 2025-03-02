/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package defensesystem.view.defences;

/**
 *
 * @author senukab
 */



import defensesystem.util.Event;
import defensesystem.util.Observer;
import defensesystem.view.controller.MainControllerForm;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class BaseDefenseForm extends javax.swing.JFrame implements Observer {
    private MainControllerForm mainController;

    /**
     * Creates new form BaseDefenseForm
     */
    public BaseDefenseForm(String title, MainControllerForm mainController) {
        
        this.mainController = mainController;

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setCloseListener();
                

    }
    

    public String toString() {
        return this.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        defenseTitle.setText(title);
    }
    
    public void setCloseListener() {
        Observer obj = (Observer) this;
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                mainController.updateMainController(obj, "remove");
                dispose();
            }
        });
    }
    

    public void update(Event event) {
        
        if (event.getPosition() != -1) {
            positionSlider.setValue(event.getPosition());
        }
        
        if (event.isAreaCleared()) {
            areaClearedLabel.setForeground(Color.GREEN);
            areaClearedLabel.setText("Area Cleared");
        } else {
            areaClearedLabel.setForeground(Color.RED);
            areaClearedLabel.setText("Area Not Cleared!");
        }
        
        if (event.getChatText() != null) {   
            
            StyledDocument doc = generalChatTextPane.getStyledDocument();


            Color color = Color.CYAN;

            SimpleAttributeSet alignment = new SimpleAttributeSet();

               StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_JUSTIFIED);
            
            StyleConstants.setForeground(alignment, event.getChatSender().equals(getTitle()) ? Color.GREEN : color);

            try {
                doc.insertString(doc.getLength(),
                        "[" + event.getChatType().name() + "] " + (
                            event.getChatSender().equals(getTitle()) ? "You" : event.getChatSender()
                       ) + " - " + event.getChatText() + "\n",
                        
                        alignment);
            } catch (BadLocationException ex) {
                Logger.getLogger(BaseDefenseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            doc.setParagraphAttributes(doc.getLength(), 1, alignment, false);

        }
        
        
        if (event.getObjective() != null) {
            objectiveLabel.setText(event.getObjective());
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

        defenseTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generalChatTextPane = new javax.swing.JTextPane();
        generalChatTextField = new javax.swing.JTextField();
        chatTypeCombo = new javax.swing.JComboBox<>();
        areaClearedLabel = new javax.swing.JLabel();
        positionSlider = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        areaClearedLabel1 = new javax.swing.JLabel();
        objectiveLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Base Defense");
        setBackground(new java.awt.Color(48, 48, 48));
        setForeground(java.awt.Color.pink);

        defenseTitle.setBackground(new java.awt.Color(0, 102, 102));
        defenseTitle.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        defenseTitle.setForeground(new java.awt.Color(255, 255, 153));
        defenseTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defenseTitle.setText("Base Defense Title");
        defenseTitle.setOpaque(true);

        generalChatTextPane.setEditable(false);
        jScrollPane1.setViewportView(generalChatTextPane);

        generalChatTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                generalChatTextFieldKeyReleased(evt);
            }
        });

        chatTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Channel", "Private Channel (Main Control)" }));

        areaClearedLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        areaClearedLabel.setForeground(new java.awt.Color(255, 51, 51));
        areaClearedLabel.setText("Area Not Cleared ");

        positionSlider.setMajorTickSpacing(20);
        positionSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        positionSlider.setPaintLabels(true);
        positionSlider.setPaintTicks(true);
        positionSlider.setSnapToTicks(true);
        positionSlider.setValue(0);
        positionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSliderStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 153));
        jLabel11.setText("Position");

        areaClearedLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        areaClearedLabel1.setForeground(new java.awt.Color(255, 255, 255));
        areaClearedLabel1.setText("Objective:");

        objectiveLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        objectiveLabel.setText("Awaiting orders...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defenseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chatTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addComponent(generalChatTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(areaClearedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(areaClearedLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objectiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(positionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defenseTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaClearedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areaClearedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objectiveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(chatTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generalChatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(positionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void positionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSliderStateChanged
       mainController.updateMainController(this, positionSlider.getValue());
        update(new Event(positionSlider.getValue()));
    }//GEN-LAST:event_positionSliderStateChanged

    private void generalChatTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generalChatTextFieldKeyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           String text = generalChatTextField.getText().strip();
           if (!text.equals("")) {
               
               Event event = new Event(text, chatTypeCombo.getSelectedIndex() == 0 ? Event.ChatTypeEnum.GENERAL : Event.ChatTypeEnum.PRIVATE, getTitle());
               
               
               if (chatTypeCombo.getSelectedIndex() == 1) {
                   mainController.updatePrivateChat(event, this);
               } else {
                   mainController.updateChat(event);

               }
               
               generalChatTextField.setText(" ");
               
           }
        }
    }//GEN-LAST:event_generalChatTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatDark look and feel */
        
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        }
        catch (Exception e) {
             System.err.println("Failed to initialize FlatLaf.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new BaseDefenseForm("Base", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaClearedLabel;
    private javax.swing.JLabel areaClearedLabel1;
    private javax.swing.JComboBox<String> chatTypeCombo;
    private javax.swing.JLabel defenseTitle;
    private javax.swing.JTextField generalChatTextField;
    private javax.swing.JTextPane generalChatTextPane;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel objectiveLabel;
    private javax.swing.JSlider positionSlider;
    // End of variables declaration//GEN-END:variables
}
