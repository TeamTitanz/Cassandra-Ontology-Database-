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
    ArrayList<String> allTablesList = new ArrayList<String>();

    /**
     * Creates new form RelationshipForms
     */
    public RelationshipForms() {
        initComponents();

        //open ListData file and read the file. Append names of tables included in the lines of the file to arraylist.
        try (BufferedReader br = new BufferedReader(new FileReader("ListData.txt"))) {
            String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();

            String line;
            while ((line = br.readLine()) != null) {

                String relatedTables[] = line.split(",");
                relatedTablesList.add(relatedTables);

                for (int i = 0; i < relatedTables.length; i++) {
                    if (!relatedTables[i].trim().equals("")) {
                        boolean isExist = false;
                        for (int j = 0; j < allTablesList.size(); j++) {
                            if (allTablesList.get(j).equals(relatedTables[i].trim())) {
                                isExist = true;
                            }
                        }

                        if (!isExist) {
                            HSSFSheet sheet = workbook.createSheet(String.valueOf(allTablesList.size()));
                            allTablesList.add(relatedTables[i].trim());
                        }
                    }
                }

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
            }

            File f = new File(filename);
            if (!f.exists()) {
                FileOutputStream fileOut = new FileOutputStream(filename);
                workbook.write(fileOut);
                fileOut.close();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }

        //creating excel files for basic tables. this is use only for one time.
        try (BufferedReader br = new BufferedReader(new FileReader("BasicTables.txt"))) {
            String line;
            //creating excel files. this is use only for one time.
            String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls";
            File f = new File(filename);
            //Read the spreadsheet that needs to be updated
            FileInputStream fsIP = new FileInputStream(new File(filename));
            //Access the workbook                  
            HSSFWorkbook wb = new HSSFWorkbook(fsIP);

            while ((line = br.readLine()) != null) {
                if (!f.exists()) {
                    HSSFSheet sheet = wb.createSheet(String.valueOf(allTablesList.size()));
                }
                allTablesList.add(line.trim());
            }

            if (!f.exists()) {
                FileOutputStream fileOut = new FileOutputStream(filename);
                wb.write(fileOut);
                fileOut.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
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

        cassandraTablesComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        relatedTableJList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cassandraTablesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "accuser", "act", "action_power", "area_of_practice", "argument", "bill", "co_operation", "co_operative", "code_of_conduct", "court", "declarative_power", "decree", "defendant", "directive", "employee", "employer", "epistemology_epistemic_role", "executive_order", "foundation", "hohfeldian_power", "immunity", "incoperated_public_limited", "initial_claim", "international_agreement", "judge", "judgment", "jury", "law", "lawyer", "legal_document", "legal_expression", "legal_firm", "legal_norm", "legal_person", "legal_principle", "legal_source", "legalcase", "legislator", "legislature", "limited_company", "natural_person", "organization", "president", "problem", "prolamation", "public_body", "resolution", "right", "state", "statute", "surprise", "treaty", "voluntary_association_society", " " }));
        cassandraTablesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cassandraTablesComboBoxActionPerformed(evt);
            }
        });

        relatedTableJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                relatedTableJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(relatedTableJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cassandraTablesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(cassandraTablesComboBox)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

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

        //open excel file
        Desktop dt = Desktop.getDesktop();
        String selectedTable = cassandraTablesComboBox.getSelectedItem().toString().trim();

        try {
            String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls";
            //Read the spreadsheet that needs to be updated
            FileInputStream fsIP = new FileInputStream(new File(filename));
            //Access the workbook                  
            HSSFWorkbook wb = new HSSFWorkbook(fsIP);
            
            int selectedIndex = -1;
            for(int i=0;i<allTablesList.size();i++) {
                if(allTablesList.get(i).equals(selectedTable)){
                    selectedIndex = i;
                }
            }
            wb.setActiveSheet(selectedIndex);

            FileOutputStream fileOut = new FileOutputStream(new File(filename));
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls"));
        } catch (IOException ex) {
            Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cassandraTablesComboBoxActionPerformed

    private void relatedTableJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_relatedTableJListValueChanged
        //open excel file
        if (relatedTableJList.getSelectedValue() != null) {
            try {
                String filename = "C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\test.xls";
                //Read the spreadsheet that needs to be updated
                FileInputStream fsIP = new FileInputStream(new File(filename));
                //Access the workbook                  
                HSSFWorkbook wb = new HSSFWorkbook(fsIP);
                wb.setActiveSheet(1);

                FileOutputStream fileOut = new FileOutputStream(new File(filename));
                wb.write(fileOut);
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            }

            Desktop dt = Desktop.getDesktop();
            String selectedTable = relatedTableJList.getSelectedValue().toString().trim();
            try {
                dt.open(new File("C:\\Users\\kjtdi\\OneDrive\\Documents\\NetBeansProjects\\CassandraOntologyConnections\\sheets\\" + selectedTable + ".xls"));
            } catch (IOException ex) {
                Logger.getLogger(RelationshipForms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_relatedTableJListValueChanged

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList relatedTableJList;
    // End of variables declaration//GEN-END:variables
}
