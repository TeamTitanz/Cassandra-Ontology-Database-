/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassandraontologyconnections;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author kjtdi
 */
public class RelationshipForms extends javax.swing.JFrame {

    ArrayList<String[]> relatedTablesList = new ArrayList<String[]>();
    ArrayList<String[]> childTablesList = new ArrayList<String[]>();
    ArrayList<String[]> parentTablesList = new ArrayList<String[]>();
    ArrayList<String> allTablesList = new ArrayList<String>();

    /**
     * Creates new form RelationshipForms
     */
    public RelationshipForms() {
        initComponents();

        //open ListData file and read the file. Append names of tables included in the lines of the file to arraylist.
        try (BufferedReader br = new BufferedReader(new FileReader("ListData.txt"))) {
//            String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls";
//            HSSFWorkbook workbook = new HSSFWorkbook();

            String line;
            while ((line = br.readLine()) != null) {

                String relatedTables[] = line.split(",");
                relatedTablesList.add(relatedTables);

//                //creating excel files for relationship tables. this is use only for one time.
//                for (int i = 0; i < relatedTables.length; i++) {
//
//                    try {
//
//                        String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + relatedTables[i].trim() + ".xls";
//                        HSSFWorkbook workbook = new HSSFWorkbook();
//                        HSSFSheet sheet = workbook.createSheet("FirstSheet");
//
//                        FileOutputStream fileOut = new FileOutputStream(filename);
//                        workbook.write(fileOut);
//                        fileOut.close();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//            FileOutputStream fileOut = new FileOutputStream(filename);
//            workbook.write(fileOut);
//            fileOut.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("ChildTableData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String tempData[] = line.split(":");
                if(tempData.length > 1) {
                    childTablesList.add(tempData[1].split(","));
                } else {
                    childTablesList.add(new String[1]);
                }
               
            }
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("ParentTableData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String tempData[] = line.split(":");
                if(tempData.length > 1) {
                    parentTablesList.add(tempData[1].split(","));
                } else {
                    parentTablesList.add(new String[1]);
                }
               
            }
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        relatedTableJList2 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        cassandraTablesComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        relatedTableJList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        childClassesJList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        parentClassesJList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();

        relatedTableJList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                relatedTableJList2ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(relatedTableJList2);

        jLabel2.setText("Child Classes");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cassandraTablesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "accuser", "act", "action_power", "area_of_practice", "argument", "bill", "co_operation", "co_operative", "code_of_conduct", "court", "declarative_power", "decree", "defendant", "directive", "employee", "employer", "epistemology_epistemic_role", "exclusionary_right", "executive_order", "foundation", "hohfeldian_power", "immunity", "incoperated_public_limited", "initial_claim", "international_agreement", "judge", "judgment", "jury", "law", "lawyer", "legal_document", "legal_expression", "legal_firm", "legal_norm", "legal_person", "legal_principle", "legal_source", "legalcase", "legislator", "legislature", "limited_company", "natural_person", "obligative_right", "observation", "organization", "potestative_expression", "president", "problem", "prolamation", "public_body", "reason", "resolution", "right", "state", "statute", "surprise", "treaty", "voluntary_association_society" }));
        cassandraTablesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cassandraTablesComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(cassandraTablesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 382, -1));

        relatedTableJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                relatedTableJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(relatedTableJList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 117, 356, 175));

        childClassesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                childClassesJListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(childClassesJList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 117, 346, 175));

        jLabel1.setText("Child Classes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 97, -1, -1));

        parentClassesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                parentClassesJListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(parentClassesJList);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 350, 175));

        jLabel3.setText("Parent Classes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cassandraTablesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cassandraTablesComboBoxActionPerformed
        //set related tables to JList data model
        String[] relatedTables = relatedTablesList.get(cassandraTablesComboBox.getSelectedIndex());
        DefaultListModel relatedTablesModel = new DefaultListModel();
        for (int i = 0; i < relatedTables.length; i++) {
            relatedTablesModel.addElement(relatedTables[i]);
        }
        relatedTableJList.setModel(relatedTablesModel);
        
        //set related tables to Child JList data model
        String[] childTables = childTablesList.get(cassandraTablesComboBox.getSelectedIndex());
        DefaultListModel childTablesModel = new DefaultListModel();
        for (int i = 0; i < childTables.length; i++) {
            childTablesModel.addElement(childTables[i]);
        }
        childClassesJList.setModel(childTablesModel);
        
        //set related tables to Parent JList data model
        String[] parentTables = parentTablesList.get(cassandraTablesComboBox.getSelectedIndex());
        DefaultListModel parentTableListModel = new DefaultListModel();
        for (int i = 0; i < parentTables.length; i++) {
            parentTableListModel.addElement(parentTables[i]);
        }
        parentClassesJList.setModel(parentTableListModel);


        //open excel file
        Desktop dt = Desktop.getDesktop();
        String selectedTable = cassandraTablesComboBox.getSelectedItem().toString().trim();
        try {
            dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + selectedTable + ".xls"));
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cassandraTablesComboBoxActionPerformed

    private void relatedTableJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_relatedTableJListValueChanged
        //open excel file
        if (relatedTableJList.getSelectedValue() != null) {

            Desktop dt = Desktop.getDesktop();
            String selectedTable = relatedTableJList.getSelectedValue().toString().trim();
            try {
                dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + selectedTable + ".xls"));
            } catch (IOException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_relatedTableJListValueChanged

    private void childClassesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_childClassesJListValueChanged
        //open excel file
        if (childClassesJList.getSelectedValue() != null) {

            Desktop dt = Desktop.getDesktop();
            String selectedTable = childClassesJList.getSelectedValue().toString().trim();
            try {
                dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + selectedTable + ".xls"));
            } catch (IOException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_childClassesJListValueChanged

    private void relatedTableJList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_relatedTableJList2ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_relatedTableJList2ValueChanged

    private void parentClassesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_parentClassesJListValueChanged
        //open excel file
        if (parentClassesJList.getSelectedValue() != null) {

            Desktop dt = Desktop.getDesktop();
            String selectedTable = parentClassesJList.getSelectedValue().toString().trim();
            try {
                dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + selectedTable + ".xls"));
            } catch (IOException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_parentClassesJListValueChanged

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
            java.util.logging.Logger.getLogger(RelationshipForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelationshipForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelationshipForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelationshipForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelationshipForms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cassandraTablesComboBox;
    private javax.swing.JList childClassesJList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList parentClassesJList;
    private javax.swing.JList relatedTableJList;
    private javax.swing.JList relatedTableJList2;
    // End of variables declaration//GEN-END:variables
}
