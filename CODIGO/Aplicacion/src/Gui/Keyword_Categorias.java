/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logica.BLCategoria;
import Logica.BLDbpedia;
import Logica.BLDocumento;
import Logica.BLKey;
import clases.Categorias;
import clases.Dbpedia;
import clases.Documentos;
import clases.Keywords;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Smart
 */
public class Keyword_Categorias extends javax.swing.JFrame {

    BLDocumento bldocument = new BLDocumento();
    Documentos document = new Documentos();
    BLKey blkey = new BLKey();
    Keywords keyword = new Keywords();
    Dbpedia dbpedia = new Dbpedia();
    BLDbpedia bldbp = new BLDbpedia();
    Categorias skos = new Categorias();
    BLCategoria blskos = new BLCategoria();
    ArrayList al = new ArrayList();
    ArrayList ale = new ArrayList();
    ArrayList list = new ArrayList();
    ArrayList<Documentos> lstestudiante;
    ArrayList<Dbpedia> lstdbpedia;
    ArrayList<Keywords> lstkeys;

    public Keyword_Categorias() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Palabra clave segun la su categoria skos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 21, -1, -1));

        jLabel2.setText("Categoria_Skos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 67, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Immunology", "1970s_introductions", "2010s_in_Saudi_Arabia", "2012_in_Asia", "Abdomen", "Abnormal_clinical_and_laboratory_findings", "Abnormal_psychology", "Acoustic_measurement", "Actuarial_science", "Acute_phase_proteins", "Adulthood", "Alternative_medical_systems", "Alternative_medical_treatments", "Alternative_medicine", "Anatomical_pathology", "Anatomy", "Ancient_Hinduism", "Ancient_history", "Ancient_India", "Angiology", "Animal_anatomy", "Animal_diseases", "Animal_diseases_by_causative_agent", "Animal_viral_diseases", "Animal_virology", "Animals", "Anthropometry", "Anthrozoology", "Anti-inflammatory_agents", "Anti-inflammatory_and_antirheumatic_products", "Antimicrobial_drugs", "Antineoplastic_and_immunomodulating_drugs", "Antipredator_adaptations", "Antiprotozoal_agents", "Antithrombotic_agents", "Applied_and_interdisciplinary_physics", "Applied_mathematics", "Applied_psychology", "Applied_sciences", "Applied_statistics", "Aromatic_compounds", "Arthropod_anatomy", "Asian_traditional_medicine", "Autoimmune_diseases", "Azines", "Bactericides", "Bat_diseases", "Betacoronaviruses", "Biochemistry", "Biocides", "Biological_contamination", "Biologically-based_therapies", "Biology", "Biology_and_culture", "Biology_of_gender", "Biopharmaceuticals", "Biostatistics", "Biotechnology", "Biotechnology_products", "Blood", "Blood_disorders", "Blood_tests", "Bodybuilding", "Botany", "Brahmin_communities", "Branches_of_biology", "Branches_of_geography", "Branches_of_philosophy", "Branches_of_psychology", "Business_economics", "Cancer", "Cancer_treatments", "Cardiac_electrophysiology", "Cardiac_procedures", "Cardiology", "Cardiovascular_diseases", "Cardiovascular_system", "Causes_of_death", "Causes_of_events", "Cell_signaling", "Cells", "Cellular_processes", "Central_nervous_system", "Chemical_engineering", "Chemical_mixtures", "Chemical_reaction_engineering", "Chemical_reactions", "Chemical_substances_by_utilization", "Chemicals_in_medicine", "Chemistry", "Chemotherapy", "Child_development", "Chronic_lower_respiratory_diseases", "Civilizations", "Clinical_medicine", "Clinical_pharmacology", "Clinical_research", "Coagulation_system", "Cognition", "Colloids", "Communication_by_type", "Computational_problems", "Computer_data", "Computer_graphics", "Computer_graphics_algorithms", "Computer_vision", "Concurrency_control", "Condensed_matter_physics", "Constructivism", "Consumer_protection", "Continuum_mechanics", "Coronaviridae", "Corticosteroids", "Cultural_geography", "Cultural_globalization", "Cultural_politics", "Cultural_studies", "Culture_terminology", "Cutaneous_conditions", "Data", "Data_collection_in_research", "Data_management", "Databases", "Death", "Death_by_country", "Death_in_Asia", "Demography", "Dietetics", "Digital_signal_processing", "Disease_outbreaks", "Diseases_and_disorders", "Diseases_and_disorders_by_system", "Disorders_of_endocrine_pancreas", "Distributed_computing", "Doping_in_sport", "Drug_discovery", "Drugs", "Drugs_acting_on_the_genito-urinary_system", "Drugs_by_mechanism_of_action", "Drugs_in_sport", "Dynamics_(mechanics)", "EC_3.4", "Economic_liberalism", "Economic_systems", "Education", "Educational_psychology", "Effects_of_external_causes", "Emergency_medical_procedures", "Emergency_medicine", "Emerging_technologies", "Endocrine", "Endocrine_diseases", "Endocrine_pancreas", "Endocrine_system", "Environment_and_society", "Environmental_science", "Environmental_social_science", "Environmental_studies", "Enzyme_kinetics", "Epidemiology", "Ethics", "Euthenics", "Evidence-based_practices", "Evolutionarily_significant_biological_phenomena", "Evolutionary_dynamics", "Experimental_medical_treatments", "Families_(biology)", "Finance", "Fluid_mechanics", "Food_safety_in_the_United_States", "Foot", "Forecasting", "Forensics", "Forensics", "Formal_sciences", "Fringe_science", "Genetics", "Glands", "Global_business_organization", "Glycobiology", "Health", "Health_by_country", "Health_care", "Health_economics", "Health_in_Asia", "Health_in_India", "Health_informatics", "Health_policy", "Health_research", "Health_sciences", "Healthcare_occupations", "Healthcare_quality", "Healthcare_quality", "Heart", "Heart_diseases", "Heterocyclic_compounds_(2_rings)", "Hindu_philosophy", "Hindu_studies", "Hinduism_and_science", "Histology", "Historical_eras", "History", "History_of_ancient_medicine", "History_of_biology_by_subdiscipline", "History_of_botany", "History_of_medicine", "History_of_medieval_medicine", "Hormonal_agents", "Hormones_by_action", "Hormones_of_the_hypothalamus-pituitary_axis", "Hormones_of_the_hypothalamus-pituitary-adrenal_axis", "Hormones_of_the_hypothalamus-pituitary-gonad_axis", "Hormones_of_the_suprarenal_cortex", "Human_anatomy", "Human_anatomy_by_organ", "Human_behavior", "Human_biology", "Human_body", "Human_development", "Human_diseases_and_disorders", "Human_geography", "Human_head_and_neck", "Hypersensitivity", "Image_processing", "Imaging", "Immune_system", "Immunology", "Immunosuppressants", "Indian_society", "Indian_traditions", "Individualism", "Industries", "Industry", "Infectious_diseases", "Information_retrieval", "Information_technology_management", "Injuries", "Injuries", "Injuries_by_region_of_body", "Insurance", "Interdisciplinary_subfields_of_sociology", "Internal_medicine", "International_business", "International_relations", "Interpersonal_communication", "Inverse_problems", "Labour_relations", "Law_enforcement_techniques", "Learning", "Life", "Life_sciences", "Lipids", "Lower_respiratory_tract_diseases", "Lung_disorders", "Lymphocytes", "Macrolides", "Malaria", "Manual_therapy", "Massage", "Mathematical_finance", "Matter", "Medical_and_health_organizations_based_in_the_United_States", "Medical_anthropology", "Medical_diagnosis", "Medical_emergencies", "Medical_equipment", "Medical_humanities", "Medical_hygiene", "Medical_imaging", "Medical_imaging_by_system", "Medical_law", "Medical_lists", "Medical_physics", "Medical_research", "Medical_specialties", "Medical_statistics", "Medical_tests", "Medical_treatments", "Medicinal_chemistry", "Medicine", "Membrane_proteins", "Memory", "Mental_health", "Metabolic_disorders", "Metabolism", "Microbiology", "Mouth", "Multiculturalism", "Multidimensional_signal_processing", "National_agencies_for_drug_regulation", "Natural_environment_based_therapies", "Natural_hazards", "Naturopathy", "Negative-sense_single-stranded_RNA_viruses", "Neoplasms", "Neuroanatomy", "Neurological_disorders_by_disease_category", "Neurology", "Neuroscience", "Nidovirales", "Nuclear_technology", "Nursing", "Nutrition", "Old_age", "Olfaction", "Organ_systems", "Organ_systems", "Organic_compounds", "Organochlorides", "Organs_(anatomy)", "Oxygen_compounds", "Pathology", "Patient", "Pedagogy", "Personal_life", "Pfizer", "Pharmaceutical_industry", "Pharmaceutical_sciences", "Pharmaceutics", "Pharmaceutics", "Pharmacognosy", "Pharmacologists", "Pharmacology", "Pharmacy", "Pharmacy_in_the_United_States", "Phases_of_matter", "Phases_of_matter", "Philosophical_theories", "Philosophy_by_topic", "Philosophy_of_life", "Physical_chemistry", "Physiology", "Piping", "Podiatry", "Poisoning_and_certain_other_consequences_of_external_causes", "Politics_by_issue", "Polyketide_antibiotics", "Population", "Population_ecology", "Poultry_diseases", "Production_and_manufacturing", "Products", "Products_by_company", "Protein_structure", "Proteins_by_function", "Proteins_by_structure", "Pseudo-scholarship", "Psychiatric_diseases_and_disorders", "Psychology", "Public_health", "Public_sphere", "Pulmonology", "Radiography", "Radiology", "Rates", "Regional_science", "Relation_of_economics_to_other_disciplines", "Religious_philosophical_concepts", "Reproductive_system", "Rescue", "Research_by_field", "Research_methods", "Respiratory_diseases", "Risk_management", "Safety", "Saudi_Arabian_society", "Science", "Science_experiments", "Self", "Senescence", "Sensory_systems", "Service_industries", "Sex_hormones", "Sexuality", "Signal_processing", "Signal_transduction", "Skeletal_disorders", "Social_engineering_(political_science)", "Social_epistemology", "Social_institutions", "Social_issues", "Social_sciences", "Social_theories", "Society", "Sociological_theories", "Sociology", "Soft_matter", "Solid_mechanics", "South_Asia", "South_Asian_traditional_medicine", "Special_education", "Speculative_fiction", "Statistics", "Stereotypes", "Steroid_hormones", "Steroids", "Subfields_of_ecology", "Subfields_of_evolutionary_biology", "Surface_science", "Symptoms_and_signs", "Technology_assessment", "Technology_by_type", "Terminology", "Tests", "Theories", "Theory_of_medicine", "Therapy", "Thymus", "Time", "Torso", "Trade", "Traditional_knowledge", "Traditional_medicine_in_India", "Trilobites", "Tuberculosis", "Type_I_hypersensitivity", "Types_of_cancer", "Types_of_databases", "Types_of_scientific_fallacy", "Ultrasound", "United_States_Department_of_Health_and_Human_Services_agencies", "Urinary_system", "Utility_software_by_type", "Vaccines", "Value_(ethics)", "Vascular_diseases", "Veterinary_medicine", "Viral_diseases", "Viral_respiratory_tract_infections", "Virology", "Virus_families", "Virus_taxonomy", "Viruses", "Wealth", "Wikipedia_categories_named_after_government_agencies", "Wikipedia_categories_named_after_medical_and_health_organizations", "Wikipedia_maintenance", "Working_conditions", "Works_about_history", "World", "World_Health_Organization", "Zoology", "Zoonoses" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 240, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Keywords"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 630, 140));

        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 530, 230));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        try {
            Listar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Keyword_Categorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Keyword_Categorias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Inicio DOCUMENTSKOS = new Inicio();
        DOCUMENTSKOS.setLocationRelativeTo(null);
        this.setVisible(false);
        DOCUMENTSKOS.setVisible(true);

        Documentos_Categorias a = new Documentos_Categorias();
        a.setLocationRelativeTo(null);
        this.setVisible(false);
        a.setVisible(false);

        Documentos_keywords b = new Documentos_keywords();
        b.setLocationRelativeTo(null);
        this.setVisible(false);
        b.setVisible(false);

        Keyword_Categorias c = new Keyword_Categorias();
        c.setLocationRelativeTo(null);
        this.setVisible(false);
        c.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     *
     */
    public void Listar() throws ClassNotFoundException, SQLException {
        //Como el método de la BL retorna un ArrayList de la clase Estudiantes
        //Aqui lo recuperamos
        String objeto = "'http://dbpedia.org/resource/Category:" + (String) this.jComboBox1.getSelectedItem() + "'";
        skos.setObjeto(objeto);
        ArrayList<Categorias> listskos = blskos.ConsultaLista2(skos);

        al.clear();
        for (Categorias sujetosskos : listskos) {
            String suketoskos = "'" + sujetosskos.getSujeto() + "'";
            al.add(suketoskos);

        }
        ale.clear();
        for (int i = 0; i < al.size(); i++) {
            String sujetodbpedia = (String) al.get(i);
            System.out.println("dbepia-sujto" + sujetodbpedia);
            dbpedia.setObjeto(sujetodbpedia);
            System.out.println("dbepia" + dbpedia);
            lstdbpedia = bldbp.ConsultaLista2(dbpedia);
            System.out.println("LISTADE" + lstdbpedia);
            for (Dbpedia sujetodbp : lstdbpedia) {
                String doises = "'" + sujetodbp.getSujeto() + "'";

                ale.add(doises);
            }

        }
        list.clear();
        for (int i = 0; i < ale.size(); i++) {
            String recurso = (String) ale.get(i);
            keyword.setDbepedia(recurso);
            lstkeys = blkey.ConsultaListaKey(keyword);
            System.out.println("palabra" + lstkeys);
            for (Keywords palabra : lstkeys) {
                String palabras = "'" + palabra.getDoi() + "'";

                list.add(palabras);
            }

        }
//        System.out.println("listadepalabras"+list);

        Object columnas[] = {"KEYWORDS"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        jTable1.setModel(modelo);
     
        modelo.removeTableModelListener(jTable1);
        int numDatos = modelo.getRowCount();
        for (int i = 0; i < numDatos; i++) {
            modelo.removeRow(0);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            String nombres = (String) list.get(i);
//            System.out.println("palaabra-clave"+nombres);
            String modeloTemp[] = {nombres};
            modelo.addRow(modeloTemp);

        }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Keyword_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keyword_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keyword_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keyword_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keyword_Categorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
