/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class TP3 extends WindowAdapter implements ActionListener {
   
    /************************************
     * CONSTANTES DE CLASSE
     ************************************/
    //largeur et hauteur de l'ecran de l'ordinateur
    public final static int LARG_ECRAN = 
            Toolkit.getDefaultToolkit().getScreenSize().width;
    public final static int HAUT_ECRAN = 
            Toolkit.getDefaultToolkit().getScreenSize().height;
    //largeur et hauteur de la fenetre principale
    public final static int LARG_FENETRE = 1000;
    public final static int HAUT_FENETRE = 630;

    //fichier d'enregistrement des matrices (Ã  la racine du projet)
    public final static String FIC_MATRICES = "matrices.txt";

    //titre de la fenÃªtre principale
    public final static String TITRE_FENETRE = "CALCULATEUR MATRICES";
   
   
    //...


    /************************************
     * VARIABLES D'INSTANCE
     ************************************/
    
    private JComboBox listeMatrices;
    private JComboBox listeMatrices2;
    private JComboBox nbLignesReponse;
    private JComboBox nbColonnesReponse;
    private JComboBox nbLignesReponse2;
    private JComboBox nbColonnesReponse2;
    private JComboBox listeMatricesPlus;
    private JComboBox listeMatricesPlus2;
    
    private JButton boutonNouvelle;
    private JButton boutonEditer;
    private JButton boutonLignePlus;
    private JButton boutonColonnePlus;
    private JButton boutonLigneMoins;
    private JButton boutonColonneMoins;
    private JButton boutonTransposee;
    private JButton boutonSauvegarder;
    private JButton boutonSupprimer;
    private JButton boutonNouvelle2;
    private JButton boutonEditer2;
    private JButton boutonLignePlus2;
    private JButton boutonColonnePlus2;
    private JButton boutonLigneMoins2;
    private JButton boutonColonneMoins2;
    private JButton boutonTransposee2;
    private JButton boutonSauvegarder2;
    private JButton boutonSupprimer2;
    private JButton boutonAddition;
    private JButton boutonMultiplication;
    private JButton boutonSauvegarder4;
    private JButton boutonSupprimerMatrice;
    private JButton boutonSupprimerMatrice2;
    
    private JLabel multPar;
    private JLabel multPar2;
    private JLabel nouveauNom;
    private JLabel nouveauNom2;
    private JLabel nom4;
    private JLabel nouveauNom4;
    
    private JTextArea texteZone1Depart;
    private JTextArea multReponse;
    private JTextArea additionReponse;
    private JTextArea texteZone2Depart;
    private JTextArea multReponse2;
    private JTextArea matriceZone4;
    
    private ArrayList<Double> elements;
    private ArrayList<Double> elements2;
    private ArrayList<TP3> tableauMatrice = new ArrayList<TP3>();
    
    private JTextField [] cellules;
    private JTextField [] cellules3;
    private JTextField [] cellules2;
    private JTextField [] cellulesPlus;
    private JTextField [] cellulesPlus2;
    private JTextField [] cellulesMoins;
    private JTextField [] cellulesMoins2;
    private JTextField [] cellule6;
    
    
    private JTextField nomSaisi;
    private JTextField nomSaisi2;
    private JTextField nomSaisi4;
    
    
    private String [] listeNomMatrice;
    
    
    private String nbLignesS;
    private String nbColonnesS;
    private String nbLignesS2;
    private String nbColonnesS2;
    private String nom;
    
    private int nbLignes;
    private int nbColonnes;
    private int nbLignes2;
    private int nbColonnes2;
    
    private ActionListener ecouteurBoutonNouvelle;
    private ActionListener ecouteurBoutonNouvelle2;
    private ActionListener ecouteurBoutonOk;
    private ActionListener ecouteurBoutonOk2;
    private ActionListener ecouteurBoutonEditer;
    private ActionListener ecouteurBoutonEditer2;
    private ActionListener ecouteurLignes;
    private ActionListener ecouteurColonnes;
    private ActionListener ecouteurLignePlus;
    private ActionListener ecouteurColonnePlus;
    private ActionListener ecouteurLigneMoins;
    private ActionListener ecouteurColonneMoins;
    private ActionListener ecouteurLignes2;
    private ActionListener ecouteurColonnes2;
    private ActionListener ecouteurLignePlus2;
    private ActionListener ecouteurColonnePlus2;
    private ActionListener ecouteurLigneMoins2;
    private ActionListener ecouteurColonneMoins2;
    private ActionListener ecouteurBoutonAddition;
    private ActionListener ecouteurBoutonMultiplication;
    private ActionListener ecouteurBoutonSauvegarder;
    private ActionListener ecouteurBoutonSauvegarder2;
    private ActionListener ecouteurBoutonTransposee;
    private ActionListener ecouteurBoutonTransposee2;
    private ActionListener ecouteurBoutonmultPar;
    private ActionListener ecouteurBoutonmultPar2;
    private ActionListener ecouteurBoutonOkSauv;
    private ActionListener ecouteurBoutonOkSauv2;
    private ActionListener ecouteurBoutonSauvegarder4;
    private ActionListener ecouteurBoutonOkSauv4;
    private ActionListener ecouteurBoutonSupprimerMatrice;
    private ActionListener ecouteurBoutonSupprimerMatrice2;
    /************************************
     * COMPOSANTS GRAPHIQUES
     ************************************/
    //fenetre principale
    private JFrame fenetre;
   
    private JPanel zone1;
    private JPanel zone2;
    private JPanel zone3;
    private JPanel zone4;
    private Object BorderFactory;
    
    private JPanel choixNombreLC;
    private JPanel choixNombreLC2;
    private JPanel grilleMatrice;
    private JPanel grilleMatrice5;
    private JPanel grilleMatricePlus;
    private JPanel grilleMatriceMoins;
    private JPanel grilleMatrice2;
    private JPanel grilleMatricePlus2;
    private JPanel grilleMatriceMoins2;
    private JPanel grilleResultat;
    private JPanel grilleTransposee;
    private JPanel grilleTransposee2;
    private JPanel grilleMultPar;
    private JPanel grilleMultPar2;
    
    private JPanel demandeNom;
    private JPanel demandeNom2;
    private JPanel demandeNom4;
 

    /**
     * Constructeur qui initialise l'application.
    */
    public TP3() {
        init(); 
    }
    
    /**
     * Constructeur de matrices.
    */
    public TP3(String nom, int nbLignes, int nbColonnes, ArrayList<Double> matrice ) {
        this.nom = nom;
        this.nbLignes = nbLignes;
        this.nbColonnes= nbColonnes;
        
        for (int i = 0; i < nbLignes * nbColonnes; i++ ) {
            
            this.elements.add(i, matrice.get(i));
        
        }
    }
    /**
     * Constructeur de matrices.
    */
    public TP3(String nom, int nbLignes, int nbColonnes) {
        this.nom = nom;
        this.nbLignes = nbLignes;
        this.nbColonnes= nbColonnes;
        this.elements = new ArrayList<Double>();
        
        for (int i = 0; i < nbLignes * nbColonnes; i++ ) {
            
            this.elements.add(i, 0.0);
        
        }
    }
    
    TP3 nouvelleMatrice2;
    TP3 nouvelleMatrice;
    TP3 matriceTransposee;
    TP3 matriceResultat;
    /**
    * Initialisation des composants graphiques.
    */
    private void init() {
        
        //lecture du fichier matrice.txt
        lectureStockageFichier();
        //FENETRE JFRAME
        fenetre = new JFrame(TITRE_FENETRE);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        //centrer la fenetre principale dans l'Ã©cran
        fenetre.setBounds(LARG_ECRAN / 2 - LARG_FENETRE / 2, 
                          HAUT_ECRAN / 2 - HAUT_FENETRE / 2, 
                          LARG_FENETRE, HAUT_FENETRE);
        fenetre.setLayout(null);
   
        zone1 = new JPanel(null);
        zone1.setBounds(0, 0, (LARG_FENETRE/9) * 4 + 1, (HAUT_FENETRE/8)*5);
        ((JPanel)zone1).setBorder(new LineBorder(Color.BLACK));
        zone1.setLayout(null);
        listeMatrices = new JComboBox(getListeNomMatrice(tableauMatrice));
        listeMatrices.setBounds((zone1.getWidth()/4) - 10, 25, 110, 25);
        listeMatrices.setBackground(Color.WHITE);
        zone1.add(listeMatrices);
        
        boutonSupprimerMatrice = new JButton("Supprimer");
        boutonSupprimerMatrice.setBackground(Color.WHITE);
        boutonSupprimerMatrice.setBounds((zone1.getWidth()/4) * 2, 25, 110, 25);
        boutonSupprimerMatrice.setBorder(null);
        boutonSupprimerMatrice.setEnabled(true); 
        zone1.add(boutonSupprimerMatrice);
        texteZone1Depart = new JTextArea();
        texteZone1Depart.setText("                                                                                                     "
                                 + "                                                                                                     "
                                 + "                                                                                                     "
                                 + "  Créez une nouvelle matrice en cliquant sur le bouton        Nouvelle ci-dessous "
                                 + "  ou choisissez une matrice                existante dans la liste déroulante ci-dessus."); 
        texteZone1Depart.setLineWrap(true);
        texteZone1Depart.setWrapStyleWord(true); 
        texteZone1Depart.setEditable(false);
        texteZone1Depart.setBounds( ((zone1.getWidth() - 300)/2), 95, 300, 150);
        texteZone1Depart.setBackground(Color.WHITE);
        zone1.add(texteZone1Depart);
        boutonNouvelle = new JButton("Nouvelle");
        boutonNouvelle.setBackground(Color.WHITE);
        boutonNouvelle.setBounds(10, 300, 90, 25);
        boutonNouvelle.setBorder(null);
        zone1.add(boutonNouvelle);
        boutonEditer = new JButton("Éditer");
        boutonEditer.setBackground(Color.WHITE);
        boutonEditer.setBounds((zone1.getWidth()/4) + 7, 300, 90, 25);
        boutonEditer.setBorder(null);
        boutonEditer.setEnabled(false);
        zone1.add(boutonEditer);
        boutonLignePlus = new JButton("+ Ligne");
        boutonLignePlus.setBackground(Color.WHITE);
        boutonLignePlus.setBounds((zone1.getWidth()/4) * 2 + 4, 300, 90, 25);
        boutonLignePlus.setBorder(null);
        boutonLignePlus.setEnabled(false);
        zone1.add(boutonLignePlus);
        boutonColonnePlus = new JButton("+ Colonne");
        boutonColonnePlus.setBackground(Color.WHITE);
        boutonColonnePlus.setBounds((zone1.getWidth()/4) * 3, 300, 90, 25);
        boutonColonnePlus.setBorder(null);
        boutonColonnePlus.setEnabled(false);
        zone1.add(boutonColonnePlus);
        boutonLigneMoins = new JButton("- Ligne");
        boutonLigneMoins.setBackground(Color.WHITE);
        boutonLigneMoins.setBounds(10, 345, 90, 25);
        boutonLigneMoins.setBorder(null);
        boutonLigneMoins.setEnabled(false);
        zone1.add(boutonLigneMoins);
        boutonColonneMoins = new JButton("- Colonne");
        boutonColonneMoins.setBackground(Color.WHITE);
        boutonColonneMoins.setBounds((zone1.getWidth()/4)+ 7, 345, 90, 25);
        boutonColonneMoins.setBorder(null);
        boutonColonneMoins.setEnabled(false);
        zone1.add(boutonColonneMoins);
        boutonTransposee = new JButton("Transposée");
        boutonTransposee.setBackground(Color.WHITE);
        boutonTransposee.setBounds((zone1.getWidth()/4) * 2 + 4, 345, 90, 25);
        boutonTransposee.setBorder(null);
        boutonTransposee.setEnabled(false);
        zone1.add(boutonTransposee);
        multPar = new JLabel();
        multPar.setText("Mult. par"); 
        multPar.setBounds((zone1.getWidth()/4) * 3, 345, 50, 25);
        multPar.setEnabled(false);
        zone1.add(multPar);
        multReponse = new JTextArea();
        multReponse.setBounds((zone1.getWidth()/4) * 3 + 60, 348, 40, 20);
        multReponse.setBackground(Color.WHITE);
        multReponse.setEnabled(false);
        zone1.add(multReponse);
        fenetre.getContentPane().add(zone1);
        
        
        zone2 = new JPanel();
        zone2.setBounds((LARG_FENETRE/9)* 5 - 1, 0, (LARG_FENETRE/9) * 4, (HAUT_FENETRE/8)*5);
        ((JPanel)zone2).setBorder(new LineBorder(Color.BLACK));
        zone2.setLayout(null);
        listeMatrices2 = new JComboBox(getListeNomMatrice(tableauMatrice));
        listeMatrices2.setBounds((zone2.getWidth()/4) - 10, 25, 110, 25);
        listeMatrices2.setBackground(Color.WHITE);
        zone2.add(listeMatrices2);
        boutonSupprimerMatrice2 = new JButton("Supprimer");
        boutonSupprimerMatrice2.setBackground(Color.WHITE);
        boutonSupprimerMatrice2.setBounds((zone2.getWidth()/4) * 2, 25, 110, 25);
        boutonSupprimerMatrice2.setBorder(null);
        boutonSupprimerMatrice2.setEnabled(true);
        zone2.add(boutonSupprimerMatrice2);
        texteZone2Depart = new JTextArea();
        texteZone2Depart.setText("                                                                                                     "
                                 + "                                                                                                     "
                                 + "                                                                                                     "
                                 + "  Créez une nouvelle matrice en cliquant sur le bouton        Nouvelle ci-dessous "
                                 + "  ou choisissez une matrice                existante dans la liste déroulante ci-dessus."); 
        texteZone2Depart.setLineWrap(true);
        texteZone2Depart.setWrapStyleWord(true); 
        texteZone2Depart.setEditable(false);
        texteZone2Depart.setBounds( ((zone2.getWidth() - 300)/2), 95, 300, 150);
        texteZone2Depart.setBackground(Color.WHITE);
        zone2.add(texteZone2Depart);
        boutonNouvelle2 = new JButton("Nouvelle");
        boutonNouvelle2.setBackground(Color.WHITE);
        boutonNouvelle2.setBounds(10, 300, 90, 25);
        boutonNouvelle2.setBorder(null);
        zone2.add(boutonNouvelle2);
        boutonEditer2 = new JButton("Éditer");
        boutonEditer2.setBackground(Color.WHITE);
        boutonEditer2.setBounds((zone2.getWidth()/4) + 7, 300, 90, 25);
        boutonEditer2.setBorder(null);
        boutonEditer2.setEnabled(false);
        zone2.add(boutonEditer2);
        boutonLignePlus2 = new JButton("+ Ligne");
        boutonLignePlus2.setBackground(Color.WHITE);
        boutonLignePlus2.setBounds((zone2.getWidth()/4) * 2 + 4, 300, 90, 25);
        boutonLignePlus2.setBorder(null);
        boutonLignePlus2.setEnabled(false);
        zone2.add(boutonLignePlus2);
        boutonColonnePlus2 = new JButton("+ Colonne");
        boutonColonnePlus2.setBackground(Color.WHITE);
        boutonColonnePlus2.setBounds((zone2.getWidth()/4) * 3, 300, 90, 25);
        boutonColonnePlus2.setBorder(null);
        boutonColonnePlus2.setEnabled(false);
        zone2.add(boutonColonnePlus2);
        boutonLigneMoins2 = new JButton("- Ligne");
        boutonLigneMoins2.setBackground(Color.WHITE);
        boutonLigneMoins2.setBounds(10, 345, 90, 25);
        boutonLigneMoins2.setBorder(null);
        boutonLigneMoins2.setEnabled(false);
        zone2.add(boutonLigneMoins2);
        boutonColonneMoins2 = new JButton("- Colonne");
        boutonColonneMoins2.setBackground(Color.WHITE);
        boutonColonneMoins2.setBounds((zone2.getWidth()/4)+ 7, 345, 90, 25);
        boutonColonneMoins2.setBorder(null);
        boutonColonneMoins2.setEnabled(false);
        zone2.add(boutonColonneMoins2);
        boutonTransposee2 = new JButton("Transposée");
        boutonTransposee2.setBackground(Color.WHITE);
        boutonTransposee2.setBounds((zone1.getWidth()/4) * 2 + 4, 345, 90, 25);
        boutonTransposee2.setBorder(null);
        boutonTransposee2.setEnabled(false);
        zone2.add(boutonTransposee2);
        multPar2 = new JLabel();
        multPar2.setText("Mult. par"); 
        multPar2.setBounds((zone2.getWidth()/4) * 3, 345, 50, 25);
        multPar2.setEnabled(false);
        zone2.add(multPar2);
        multReponse2 = new JTextArea();
        multReponse2.setBounds((zone2.getWidth()/4) * 3 + 60, 348, 40, 20);
        multReponse2.setBackground(Color.WHITE);
        multReponse2.setEnabled(false);
        zone2.add(multReponse2);
        fenetre.getContentPane().add(zone2);
        
        
        zone3 = new JPanel();
        zone3.setBounds((LARG_FENETRE/9)* 4, 0, (LARG_FENETRE/9), (HAUT_FENETRE/8)*5);
        ((JPanel)zone3).setBorder(new LineBorder(Color.BLACK));
        zone3.setLayout(null);
        boutonAddition = new JButton(" + ");
        boutonAddition.setBackground(Color.WHITE);
        boutonAddition.setBounds(((zone3.getWidth())- 35)/2, (zone3.getHeight()/2)-40, 35, 25);
        boutonAddition.setBorder(null);
        boutonAddition.setEnabled(true);
        boutonAddition.setVisible(true);
        zone3.add(boutonAddition);
        boutonMultiplication = new JButton(" x ");
        boutonMultiplication.setBackground(Color.WHITE);
        boutonMultiplication.setBounds(((zone3.getWidth())- 35)/2, (zone3.getHeight()/2)+ 20, 35, 25);
        boutonMultiplication.setBorder(null);
        boutonMultiplication.setEnabled(true);
        zone3.add(boutonMultiplication);
        fenetre.getContentPane().add(zone3);
        
        zone4 = new JPanel();
        zone4.setBounds(0,((HAUT_FENETRE/8)*5 - 1), LARG_FENETRE, ((HAUT_FENETRE/8)*3));
        ((JPanel)zone4).setBorder(new LineBorder(Color.BLACK));
        zone4.setLayout(null);
        nom4 = new JLabel("Matrice");
        nom4.setBounds(70, 15, 70, 40);
        zone4.add(nom4);
        nom4.setVisible(false);
        matriceZone4 = new JTextArea();
        matriceZone4.setEditable(false);
        matriceZone4.setBounds(260, 20, 350, 180);
        matriceZone4.setVisible(false);
        zone4.add(matriceZone4);
        boutonSauvegarder4 = new JButton("Sauvegarder");
        boutonSauvegarder4.setBackground(Color.WHITE);
        boutonSauvegarder4.setBounds(700, 30, 80, 20);
        boutonSauvegarder4.setBorder(null);
        boutonSauvegarder4.setEnabled(true);
        boutonSauvegarder4.setVisible(false);
        zone4.add(boutonSauvegarder4);
        fenetre.getContentPane().add(zone4);
        grilleMatrice = new JPanel(new GridLayout(1,1, 5, 6));  
        grilleMatrice.setBounds( (zone1.getWidth()/2)- (1 * 48 / 2), 
        (zone1.getHeight()/3)- (1 * 25 / 5),1 * 48, 1 * 25);
        grilleMatrice2 = new JPanel(new GridLayout(1,1, 5, 6));  
        grilleMatrice2.setBounds( (zone1.getWidth()/2)- (1 * 48 / 2), 
        (zone1.getHeight()/3)- (1 * 25 / 5),1 * 48, 1 * 25);
        listeMatrices.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent evenement){
                        if (evenement.getStateChange() == ItemEvent.SELECTED) {
                            
                            for (int i = 0; i < tableauMatrice.size(); i++) {
                                
                                if (listeMatrices.getSelectedItem() == tableauMatrice.get(i).nom) {
                                    
                                    grilleMatrice.setVisible(true);
                                    
                                    
                                    grilleMatricePlus = new JPanel(new GridLayout(tableauMatrice.get(i).nbLignes, tableauMatrice.get(i).nbColonnes, 5, 6));  
                                    grilleMatricePlus.setBounds( (zone1.getWidth()/2)- (tableauMatrice.get(i).nbColonnes * 48 / 2), 
                                    (zone1.getHeight()/3)- (tableauMatrice.get(i).nbLignes * 25 / 5), tableauMatrice.get(i).nbColonnes * 48, tableauMatrice.get(i).nbLignes * 25);
                                    
                                    cellulesPlus = new JTextField[tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes];
                                    for (int j = 0 ; j < ((tableauMatrice.get(i).nbLignes) * tableauMatrice.get(i).nbColonnes) ; j++) {

                                        cellulesPlus[j] = new JTextField();
                                        cellulesPlus[j].setFont(new Font("Courier", Font.PLAIN, 12));
                                        cellulesPlus[j].setText(Double.toString(tableauMatrice.get(i).elements.get(j)));
                                        cellulesPlus[j].setHorizontalAlignment(SwingConstants.LEFT);
                                        cellulesPlus[j].setBackground(Color.WHITE);
                                        cellulesPlus[j].setEditable(false);
                                        grilleMatricePlus.add(cellulesPlus[j]);
                                    }

                                    

                                    grilleMatrice.setVisible(false);

                                    zone1.add(grilleMatricePlus);

                                    grilleMatrice = grilleMatricePlus;
                                    texteZone1Depart.setVisible(false);
                                    cellules = new JTextField [tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes];
                                    nouvelleMatrice = new TP3("",tableauMatrice.get(i).nbLignes,tableauMatrice.get(i).nbColonnes);
                                    nouvelleMatrice.elements.clear();
                                    for (int j = 0 ; j < (tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes); j++) {
                                        cellules[j] = cellulesPlus[j];
                                        tableauMatrice.get(i).elements.set(j, Double.parseDouble(cellules[j].getText())); 
                                        nouvelleMatrice.elements.add(j, Double.parseDouble(cellules[j].getText()));
                                    }
                                    boutonEditer.setEnabled(true);
                                    boutonTransposee.setEnabled(true);
                                    multReponse.setEnabled(true);
                                 }
                            }
                        }
                    }
                }
        );
        
      listeMatrices2.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent evenement){
                        if (evenement.getStateChange() == ItemEvent.SELECTED) {
                            
                            for (int i = 0; i < tableauMatrice.size(); i++) {
                                System.out.println(listeMatrices2.getSelectedItem());
                                if (listeMatrices2.getSelectedItem() == tableauMatrice.get(i).nom) {
                                    
                                    grilleMatrice2.setVisible(true);
                                    
                                    
                                    grilleMatricePlus2 = new JPanel(new GridLayout(tableauMatrice.get(i).nbLignes, tableauMatrice.get(i).nbColonnes, 5, 6));  
                                    grilleMatricePlus2.setBounds( (zone2.getWidth()/2)- (tableauMatrice.get(i).nbColonnes * 48 / 2), 
                                    (zone2.getHeight()/3)- (tableauMatrice.get(i).nbLignes * 25 / 5), tableauMatrice.get(i).nbColonnes * 48, tableauMatrice.get(i).nbLignes * 25);
                                    
                                    cellulesPlus2 = new JTextField[tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes];
                                    for (int j = 0 ; j < ((tableauMatrice.get(i).nbLignes) * tableauMatrice.get(i).nbColonnes) ; j++) {

                                        cellulesPlus2[j] = new JTextField();
                                        cellulesPlus2[j].setFont(new Font("Courier", Font.PLAIN, 12));
                                        cellulesPlus2[j].setText(Double.toString(tableauMatrice.get(i).elements.get(j)));
                                        cellulesPlus2[j].setHorizontalAlignment(SwingConstants.LEFT);
                                        cellulesPlus2[j].setBackground(Color.WHITE);
                                        cellulesPlus2[j].setEditable(false);
                                        grilleMatricePlus2.add(cellulesPlus2[j]);
                                        
                                    }

                                    

                                    grilleMatrice2.setVisible(false);

                                    zone2.add(grilleMatricePlus2);

                                    grilleMatrice2 = grilleMatricePlus2;
                                    texteZone2Depart.setVisible(false);
                                    cellules2 = new JTextField [tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes];
                                    nouvelleMatrice2 = new TP3("",tableauMatrice.get(i).nbLignes,tableauMatrice.get(i).nbColonnes);
                                    nouvelleMatrice2.elements.clear();
                                    for (int j = 0 ; j < (tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes); j++) {
                                        cellules2[j] = cellulesPlus2[j];
                                        tableauMatrice.get(i).elements.set(j, Double.parseDouble(cellules2[j].getText()));
                                        nouvelleMatrice2.elements.add(Double.parseDouble(cellules2[j].getText()));
                                    }
                                    boutonEditer2.setEnabled(true);
                                 }
                            }
                        }
                    }
                }
        );
        //Laisser cette instruction Ã  la fin de l'initialisation des composants
        //graphiques.
        fenetre.setVisible(true);
      
      
        /*************************
         * Ã‰COUTEURS
         *************************/
        //ajout d'un ecouteur sur la fenetre
        fenetre.addWindowListener(this); //voir redef methode windowClosing
        
        ecouteurBoutonNouvelle = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nouvelle();
            }
        };
          
        boutonNouvelle.addActionListener(ecouteurBoutonNouvelle);
        
        ecouteurLignePlus = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ajouterLigne();
            }
        };
          
        boutonLignePlus.addActionListener(ecouteurLignePlus);
        
        ecouteurColonnePlus = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ajouterColonne();
            }
        };
          
        boutonColonnePlus.addActionListener(ecouteurColonnePlus);
        
        ecouteurLigneMoins = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerLigne();
            }
        };
          
        boutonLigneMoins.addActionListener(ecouteurLigneMoins);
        
        ecouteurColonneMoins = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerColonne();
            }
        };
          
        boutonColonneMoins.addActionListener(ecouteurColonneMoins);
        
        ecouteurBoutonNouvelle2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nouvelle2();
            }
        };
          
        boutonNouvelle2.addActionListener(ecouteurBoutonNouvelle2);
        
        ecouteurLignePlus2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ajouterLigne2();
            }
        };
          
        boutonLignePlus2.addActionListener(ecouteurLignePlus2);
        
        ecouteurColonnePlus2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ajouterColonne2();
            }
        };
          
        boutonColonnePlus2.addActionListener(ecouteurColonnePlus2);
        
        ecouteurLigneMoins2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerLigne2();
            }
        };
          
        boutonLigneMoins2.addActionListener(ecouteurLigneMoins2);
        
        ecouteurColonneMoins2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerColonne2();
            }
        };
          
        boutonColonneMoins2.addActionListener(ecouteurColonneMoins2);
        
        ecouteurBoutonAddition = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               addition();
            }
        };
          
        boutonAddition.addActionListener(ecouteurBoutonAddition);
        
        ecouteurBoutonMultiplication = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               multiplication();
            }
        };
          
        boutonMultiplication.addActionListener(ecouteurBoutonMultiplication);
       
        ecouteurBoutonTransposee = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               transposee();
            }
        };
        boutonTransposee.addActionListener(ecouteurBoutonTransposee);
        
        ecouteurBoutonTransposee2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               transposee2();
            }
        };
        boutonTransposee2.addActionListener(ecouteurBoutonTransposee2);
        
        ecouteurBoutonSupprimerMatrice = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerMatrice();
            }
        };
        boutonSupprimerMatrice.addActionListener(ecouteurBoutonSupprimerMatrice);
        
        ecouteurBoutonSupprimerMatrice2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               supprimerMatrice2();
            }
        };
        boutonSupprimerMatrice2.addActionListener(ecouteurBoutonSupprimerMatrice2);
        
        ecouteurBoutonEditer = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               editer();
            }
        };
        boutonEditer.addActionListener(ecouteurBoutonEditer);
        
        ecouteurBoutonEditer2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               editer2();
            }
        };
        boutonEditer2.addActionListener(ecouteurBoutonEditer2);
        
    }
   
    @Override
    public void actionPerformed (ActionEvent e) {
      
        
      
    }
    
    
    
    public void nouvelle() {
        
        boutonNouvelle.setSelected(true);
        texteZone1Depart.setVisible(false);
        grilleMatrice.setVisible(false);
        choixNombreLC = new JPanel(null);
        choixNombreLC.setVisible(true);
        choixNombreLC.setBounds(100, 100, (LARG_FENETRE/9) * 2,HAUT_FENETRE/6);
        ((JPanel)choixNombreLC).setBorder(new LineBorder(Color.BLACK));
        choixNombreLC.setLayout(null);
        zone1.add(choixNombreLC);
        
        String[] listeChoix = { "1", "2", "3", "4", "5", "6", "7", "8"};
        
        JLabel nombreLignes = new JLabel();
        nombreLignes.setText("Nombre de lignes :"); 
        nombreLignes.setBounds(10, 15, 130, 20);
        choixNombreLC.add(nombreLignes);
        nbLignesReponse = new JComboBox(listeChoix);
        nbLignesReponse.setBounds(150, 15, 60, 20);
        nbLignesReponse.setEditable(false);
        nbLignesReponse.setSelectedIndex(0);
        choixNombreLC.add(nbLignesReponse);
        
        JLabel nombreColonnes = new JLabel();
        nombreColonnes.setText("Nombre de colonnes :"); 
        nombreColonnes.setBounds(10, 48, 130, 20);
        choixNombreLC.add(nombreColonnes);
        nbColonnesReponse = new JComboBox(listeChoix);
        nbColonnesReponse.setBounds(150, 48, 60, 20);
        nbColonnesReponse.setEditable(false);
        nbColonnesReponse.setSelectedIndex(0);
        choixNombreLC.add(nbColonnesReponse);
        
        JButton boutonOk = new JButton("Ok");
        boutonOk.setBackground(Color.WHITE);
        boutonOk.setBounds(150, 78, 50, 20);
        choixNombreLC.add(boutonOk);
        
        ecouteurLignes = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nbLignesS = (String)nbLignesReponse.getSelectedItem();
               nbLignes = Integer.parseInt(nbLignesS);
            }
        };
        
        nbLignesReponse.addActionListener(ecouteurLignes);
        
        ecouteurColonnes = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nbColonnesS =  (String) nbColonnesReponse.getSelectedItem();
               nbColonnes = Integer.parseInt(nbColonnesS);
            }
        };
        nbColonnesReponse.addActionListener(ecouteurColonnes);
        
        ecouteurBoutonOk = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ok();
            }
        };
          
        boutonOk.addActionListener(ecouteurBoutonOk);
    }
    public void nouvelle2() {
        
        boutonNouvelle2.setSelected(true);
        texteZone2Depart.setVisible(false);
        grilleMatrice2.setVisible(false);
        choixNombreLC2 = new JPanel(null);
        choixNombreLC2.setVisible(true);
        choixNombreLC2.setBounds(100, 100, (LARG_FENETRE/9) * 2,HAUT_FENETRE/6);
        ((JPanel)choixNombreLC2).setBorder(new LineBorder(Color.BLACK));
        choixNombreLC2.setLayout(null);
        zone2.add(choixNombreLC2);
        
        String[] listeChoix2 = { "1", "2", "3", "4", "5", "6", "7", "8"};
        
        JLabel nombreLignes2 = new JLabel();
        nombreLignes2.setText("Nombre de lignes :"); 
        nombreLignes2.setBounds(10, 15, 130, 20);
        choixNombreLC2.add(nombreLignes2);
        nbLignesReponse2 = new JComboBox(listeChoix2);
        nbLignesReponse2.setBounds(150, 15, 60, 20);
        nbLignesReponse2.setEditable(false);
        nbLignesReponse2.setSelectedIndex(0);
        choixNombreLC2.add(nbLignesReponse2);
        
        JLabel nombreColonnes2 = new JLabel();
        nombreColonnes2.setText("Nombre de colonnes :"); 
        nombreColonnes2.setBounds(10, 48, 130, 20);
        choixNombreLC2.add(nombreColonnes2);
        nbColonnesReponse2 = new JComboBox(listeChoix2);
        nbColonnesReponse2.setBounds(150, 48, 60, 20);
        nbColonnesReponse2.setEditable(false);
        nbColonnesReponse2.setSelectedIndex(0);
        choixNombreLC2.add(nbColonnesReponse2);
        
        JButton boutonOk2 = new JButton("Ok");
        boutonOk2.setBackground(Color.WHITE);
        boutonOk2.setBounds(150, 78, 50, 20);
        choixNombreLC2.add(boutonOk2);
        
        ecouteurLignes2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nbLignesS2 = (String)nbLignesReponse2.getSelectedItem();
               nbLignes2 = Integer.parseInt(nbLignesS2);
            }
        };
        
        nbLignesReponse2.addActionListener(ecouteurLignes2);
        
        ecouteurColonnes2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               nbColonnesS2 =  (String) nbColonnesReponse2.getSelectedItem();
               nbColonnes2 = Integer.parseInt(nbColonnesS2);
            }
        };
        nbColonnesReponse2.addActionListener(ecouteurColonnes2);
        
        ecouteurBoutonOk2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               ok2();
            }
        };
          
        boutonOk2.addActionListener(ecouteurBoutonOk2);
    }

    public void ok() {
        
        boutonEditer.setVisible(false);
        choixNombreLC.setVisible(false);
        boutonSauvegarder = new JButton("Sauvegarder");
        boutonSauvegarder.setBackground(Color.WHITE);
        boutonSauvegarder.setBounds((zone1.getWidth()/4) + 7, 300, 90, 25);
        boutonSauvegarder.setBorder(null);
        zone1.add(boutonSauvegarder);
        boutonLignePlus.setEnabled(true);
        boutonColonnePlus.setEnabled(true);
        boutonLigneMoins.setEnabled(true);
        boutonColonneMoins.setEnabled(true);
        grilleMatrice = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
        grilleMatrice.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
        (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
        zone1.add(grilleMatrice);
        
       
        
        
        cellules = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
        nouvelleMatrice = new TP3("", nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes);
        nouvelleMatrice.nbColonnes = nbColonnes;
        nouvelleMatrice.nbLignes = nbLignes;
        for (int i = 0; i < nouvelleMatrice.elements.size() ; i++) {
           
            nouvelleMatrice = new TP3("", nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes);
            zone1.add(grilleMatrice);

            cellules[i] = new JTextField();
            cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
            cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules[i].setBackground(Color.YELLOW);
            grilleMatrice.add(cellules[i]);
        }
        
        ecouteurBoutonSauvegarder = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

                sauvegarder();
            }
        };
          
        boutonSauvegarder.addActionListener(ecouteurBoutonSauvegarder);
    }
    public void ok2() {
        
        boutonEditer2.setVisible(false);
        choixNombreLC2.setVisible(false);
        boutonSauvegarder2 = new JButton("Sauvegarder");
        boutonSauvegarder2.setBackground(Color.WHITE);
        boutonSauvegarder2.setBounds((zone1.getWidth()/4) + 7, 300, 90, 25);
        boutonSauvegarder2.setBorder(null);
        zone2.add(boutonSauvegarder2);
        boutonLignePlus2.setEnabled(true);
        boutonColonnePlus2.setEnabled(true);
        boutonLigneMoins2.setEnabled(true);
        boutonColonneMoins2.setEnabled(true);
        grilleMatrice2 = new JPanel(new GridLayout(nouvelleMatrice2.nbLignes, nouvelleMatrice2.nbColonnes, 5, 6));  
        grilleMatrice2.setBounds( (zone2.getWidth()/2)- (nouvelleMatrice2.nbColonnes * 48 / 2), 
        (zone2.getHeight()/3)- (nouvelleMatrice2.nbLignes * 25 / 5), nouvelleMatrice2.nbColonnes * 48, nouvelleMatrice2.nbLignes * 25);
        zone2.add(grilleMatrice2);
        
        
        cellules2 = new JTextField [nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
        nouvelleMatrice2 = new TP3("", nouvelleMatrice2.nbLignes, nouvelleMatrice2.nbColonnes);
        
        for (int i = 0; i < nouvelleMatrice2.elements.size() ; i++) {
           
            nouvelleMatrice2 = new TP3("", nouvelleMatrice2.nbLignes, nouvelleMatrice2.nbColonnes);
            zone2.add(grilleMatrice2);

            cellules2[i] = new JTextField();
            cellules2[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
            cellules2[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules2[i].setBackground(Color.YELLOW);
            grilleMatrice2.add(cellules2[i]);
        }
        
        ecouteurBoutonSauvegarder2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

                sauvegarder2();
            }
        };
          
        boutonSauvegarder2.addActionListener(ecouteurBoutonSauvegarder2);
    }
        
    public void ajouterLigne() {
        
        if (nouvelleMatrice.nbLignes < 8){
            DecimalFormat df = new DecimalFormat("0.0###");
            
            nouvelleMatrice.elements.clear();
            for (int i = 0; i < nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes; i++) {
                
                nouvelleMatrice.elements.add(Double.parseDouble(cellules[i].getText()));
            }
            
            nouvelleMatrice.nbLignes++;
            
            grilleMatricePlus = new JPanel(new GridLayout(nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes, 5, 6));  
            grilleMatricePlus.setBounds( (zone1.getWidth()/2)- (nouvelleMatrice.nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nouvelleMatrice.nbLignes * 25 / 5), nouvelleMatrice.nbColonnes * 48, nouvelleMatrice.nbLignes * 25);
          
            
            cellulesPlus = new JTextField[nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            for (int i = 0 ; i < ((nouvelleMatrice.nbLignes - 1) * nouvelleMatrice.nbColonnes) ; i++) {
                
                cellulesPlus[i] = new JTextField();
                cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
                cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus[i].setBackground(Color.YELLOW);
                grilleMatricePlus.add(cellulesPlus[i]);
            }
            
            for (int i = (nouvelleMatrice.nbLignes - 1) * nouvelleMatrice.nbColonnes ; i < ((nouvelleMatrice.nbLignes - 1) * nouvelleMatrice.nbColonnes) + nouvelleMatrice.nbColonnes ; i++) {
                
                cellulesPlus[i] = new JTextField();
                cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus[i].setText("0.0");
                cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus[i].setBackground(Color.YELLOW);

                grilleMatricePlus.add(cellulesPlus[i]);
                nouvelleMatrice.elements.add(i, 0.0);
            }
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatricePlus);
            
            grilleMatrice = grilleMatricePlus;
            
            cellules = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes); i++) {
                cellules[i] = cellulesPlus[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText())); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 lignes!");
        }
    }
    public void ajouterLigne2() {
        
        if (nouvelleMatrice2.nbLignes < 8){
            DecimalFormat df = new DecimalFormat("0.0###");
            
            nouvelleMatrice2.elements.clear();
            for (int i = 0; i < nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes; i++) {
                
                nouvelleMatrice2.elements.add(Double.parseDouble(cellules2[i].getText()));
            }
            
            nouvelleMatrice2.nbLignes++;
            
            grilleMatricePlus2 = new JPanel(new GridLayout(nouvelleMatrice2.nbLignes, nouvelleMatrice2.nbColonnes, 5, 6));  
            grilleMatricePlus2.setBounds( (zone2.getWidth()/2)- (nouvelleMatrice2.nbColonnes * 48 / 2), 
            (zone2.getHeight()/3)- (nouvelleMatrice2.nbLignes * 25 / 5), nouvelleMatrice2.nbColonnes * 48, nouvelleMatrice2.nbLignes * 25);
          
            
            cellulesPlus2 = new JTextField[nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            for (int i = 0 ; i < ((nouvelleMatrice2.nbLignes - 1) * nouvelleMatrice2.nbColonnes) ; i++) {
                
                cellulesPlus2[i] = new JTextField();
                cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
                cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus2[i].setBackground(Color.YELLOW);
                grilleMatricePlus2.add(cellulesPlus2[i]);
            }
            
            for (int i = (nouvelleMatrice2.nbLignes - 1) * nouvelleMatrice2.nbColonnes ; i < ((nouvelleMatrice2.nbLignes - 1) * nouvelleMatrice2.nbColonnes) + nouvelleMatrice2.nbColonnes ; i++) {
                
                cellulesPlus2[i] = new JTextField();
                cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus2[i].setText("0.0");
                cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus2[i].setBackground(Color.YELLOW);

                grilleMatricePlus2.add(cellulesPlus2[i]);
                nouvelleMatrice2.elements.add(i, 0.0);
            }
            
            grilleMatrice2.setVisible(false);
            
            zone2.add(grilleMatricePlus2);
            
            grilleMatrice2 = grilleMatricePlus2;
            
            cellules2 = new JTextField [nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes); i++) {
                cellules2[i] = cellulesPlus2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText())); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 lignes!");
        }
    }
    
    private void ajouterColonne(){  
          
        if (nouvelleMatrice.nbColonnes < 8){
            
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            
            grilleMatricePlus = new JPanel(new GridLayout(nouvelleMatrice.nbLignes, (nouvelleMatrice.nbColonnes +1), 5, 6));  
            grilleMatricePlus.setBounds((zone1.getWidth()/2) - ((nouvelleMatrice.nbColonnes+1) * 48 / 2), 
            (zone1.getHeight()/3)- (nouvelleMatrice.nbLignes * 25 / 5), (nouvelleMatrice.nbColonnes +1) * 48, nouvelleMatrice.nbLignes * 25);
    
            cellulesPlus = new JTextField[nouvelleMatrice.nbLignes * (nouvelleMatrice.nbColonnes+1)];
            
            
            elements2 = new ArrayList<Double>();
            DecimalFormat df = new DecimalFormat("0.0###");
            int k = 0;
            int s = 1;
            for(int i = 0; i < nouvelleMatrice.nbLignes * (nouvelleMatrice.nbColonnes+1) ; i++){
                            
                if ((i % (((nouvelleMatrice.nbColonnes+1)*s)-1)) == 0 && i != 0){
                    
                    cellulesPlus[i] = new JTextField();
                    cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus[i].setText("0.0");
                    cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus[i].setBackground(Color.YELLOW);
                    grilleMatricePlus.add(cellulesPlus[i]);
                    elements2.add(0.0);
                    s++;
                    
                } else {
                    
                    cellulesPlus[i] = new JTextField();
                    cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus[i].setText(Double.toString(nouvelleMatrice.elements.get(k)));
                    cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus[i].setBackground(Color.YELLOW);
                    grilleMatricePlus.add(cellulesPlus[i]);
                    elements2.add(nouvelleMatrice.elements.get(k));
                    k++;
                    
                }
          
            }
            nouvelleMatrice.nbColonnes++;
            
            grilleMatrice.setVisible(false);
            grilleMatrice = grilleMatricePlus;
            zone1.add(grilleMatricePlus);
            grilleMatrice.setVisible(true);
            cellules = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            nouvelleMatrice.elements.clear();
            for (int i = 0 ; i < nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes ; i++) {
                cellules[i] = cellulesPlus[i];
                nouvelleMatrice.elements.add(elements2.get(i));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 colonnes!");
        }
    }
    private void ajouterColonne2(){  
          
        if (nouvelleMatrice2.nbColonnes < 8){
            
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            
            grilleMatricePlus2 = new JPanel(new GridLayout(nouvelleMatrice2.nbLignes, (nouvelleMatrice2.nbColonnes +1), 5, 6));  
            grilleMatricePlus2.setBounds((zone1.getWidth()/2) - ((nouvelleMatrice2.nbColonnes+1) * 48 / 2), 
            (zone2.getHeight()/3)- (nouvelleMatrice2.nbLignes * 25 / 5), (nouvelleMatrice2.nbColonnes +1) * 48, nouvelleMatrice2.nbLignes * 25);
    
            cellulesPlus2 = new JTextField[nouvelleMatrice2.nbLignes * (nouvelleMatrice2.nbColonnes+1)];
            
            
            elements2 = new ArrayList<Double>();
            DecimalFormat df = new DecimalFormat("0.0###");
            int k = 0;
            int s = 1;
            for(int i = 0; i < nouvelleMatrice2.nbLignes * (nouvelleMatrice2.nbColonnes+1) ; i++){
                            
                if ((i % (((nouvelleMatrice2.nbColonnes+1)*s)-1)) == 0 && i != 0){
                    
                    cellulesPlus2[i] = new JTextField();
                    cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus2[i].setText("0.0");
                    cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus2[i].setBackground(Color.YELLOW);
                    grilleMatricePlus2.add(cellulesPlus2[i]);
                    elements2.add(0.0);
                    s++;
                    
                } else {
                    
                    cellulesPlus2[i] = new JTextField();
                    cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus2[i].setText(Double.toString(nouvelleMatrice2.elements.get(k)));
                    cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus2[i].setBackground(Color.YELLOW);
                    grilleMatricePlus2.add(cellulesPlus2[i]);
                    elements2.add(nouvelleMatrice2.elements.get(k));
                    k++;
                    
                }
          
            }
            nouvelleMatrice2.nbColonnes++;
            
            grilleMatrice2.setVisible(false);
            grilleMatrice2 = grilleMatricePlus2;
            zone2.add(grilleMatricePlus2);
            grilleMatrice2.setVisible(true);
            cellules2 = new JTextField [nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            nouvelleMatrice2.elements.clear();
            for (int i = 0 ; i < nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes ; i++) {
                cellules2[i] = cellulesPlus2[i];
                nouvelleMatrice2.elements.add(elements2.get(i));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 colonnes!");
        }
    }
    
    private void supprimerLigne() {
        
        if (nouvelleMatrice.nbLignes > 1){
            
            
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            
            nouvelleMatrice.nbLignes = nouvelleMatrice.nbLignes - 1;
            
            grilleMatriceMoins = new JPanel(new GridLayout(nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes, 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- (nouvelleMatrice.nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nouvelleMatrice.nbLignes * 25 / 5), nouvelleMatrice.nbColonnes * 48, nouvelleMatrice.nbLignes * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins = new JTextField[nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes) ; i++) {
                cellulesMoins[i] = new JTextField();
                cellulesMoins[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesMoins[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
                cellulesMoins[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesMoins[i].setBackground(Color.YELLOW);
                grilleMatriceMoins.add(cellulesMoins[i]);
            }
            
            for (int i = (nouvelleMatrice.nbColonnes * (nouvelleMatrice.nbLignes+1))-1 ; i > (nouvelleMatrice.nbColonnes * nouvelleMatrice.nbLignes)-1 ; i--) {
                
                nouvelleMatrice.elements.remove(i);
                
            }
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une ligne!");
        }
    }
    private void supprimerLigne2() {
        
        if (nouvelleMatrice2.nbLignes > 1){
            
            
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            
            nouvelleMatrice2.nbLignes = nouvelleMatrice2.nbLignes - 1;
            
            grilleMatriceMoins2 = new JPanel(new GridLayout(nouvelleMatrice2.nbLignes, nouvelleMatrice2.nbColonnes, 5, 6));  
            grilleMatriceMoins2.setBounds( (zone2.getWidth()/2)- (nouvelleMatrice2.nbColonnes * 48 / 2), 
            (zone2.getHeight()/3)- (nouvelleMatrice2.nbLignes * 25 / 5), nouvelleMatrice2.nbColonnes * 48, nouvelleMatrice2.nbLignes * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins2 = new JTextField[nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes) ; i++) {
                cellulesMoins2[i] = new JTextField();
                cellulesMoins2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesMoins2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
                cellulesMoins2[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesMoins2[i].setBackground(Color.YELLOW);
                grilleMatriceMoins2.add(cellulesMoins2[i]);
            }
            
            for (int i = (nouvelleMatrice2.nbColonnes * (nouvelleMatrice2.nbLignes+1))-1 ; i > (nouvelleMatrice2.nbColonnes * nouvelleMatrice2.nbLignes)-1 ; i--) {
                
                nouvelleMatrice2.elements.remove(i);
                
            }
            
            grilleMatrice2.setVisible(false);
            
            zone2.add(grilleMatriceMoins2);
            
            grilleMatrice2 = grilleMatriceMoins2;
            
            cellules2 = new JTextField [nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes); i++) {
                cellules2[i] = cellulesMoins2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une ligne!");
        }
    }
    
    private String [] getListeNomMatrice(ArrayList<TP3> tableau) {
        
        String listeMatrice [] = new String [tableauMatrice.size()];
        String listeVide[] = new String [1];
        listeVide[0] = "";
        
       
        if (tableauMatrice.size() == 0){
           
            listeNomMatrice = listeVide;
            
        } else {
            for (int i = 0; i < tableauMatrice.size(); i++){
                listeMatrice[i] = tableauMatrice.get(i).nom;
            }
            listeNomMatrice = listeMatrice;
        }
       
       
       return listeNomMatrice;
    }
    
    
    private void supprimerColonne(){
        
         if (nouvelleMatrice.nbColonnes > 1){
            
           
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            grilleMatriceMoins = new JPanel(new GridLayout(nouvelleMatrice.nbLignes, (nouvelleMatrice.nbColonnes - 1), 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- ((nouvelleMatrice.nbColonnes - 1) * 24), 
            (zone1.getHeight()/3)- (nouvelleMatrice.nbLignes * 5), (nouvelleMatrice.nbColonnes - 1) * 48, nouvelleMatrice.nbLignes * 25);
            zone1.add(grilleMatriceMoins);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins = new JTextField[nouvelleMatrice.nbLignes * (nouvelleMatrice.nbColonnes - 1)];
            int j = 0;
            int s = 0;
            
            for(int i = 0; j < (nouvelleMatrice.nbLignes * (nouvelleMatrice.nbColonnes - 1)) ; i++){
                            
                if ((i != (nouvelleMatrice.nbColonnes - 1) && s == 0) || (s != 0 && i != ((s+1) * nouvelleMatrice.nbColonnes - 1))){
                    
                    cellulesMoins[j] = new JTextField();
                    cellulesMoins[j].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesMoins[j].setText(Double.toString(nouvelleMatrice.elements.get(i)));
                    cellulesMoins[j].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesMoins[j].setBackground(Color.YELLOW);
                    grilleMatriceMoins.add(cellulesMoins[j]);
                    j++;
                } else {
                    s++;
                }
          
            }
            for (int i = 0; i < nouvelleMatrice.nbLignes; i++) {
                nouvelleMatrice.elements.remove((i*nouvelleMatrice.nbColonnes)-(i-1));
            }
            
            nouvelleMatrice.nbColonnes--;
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText()));
            }     
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une colonne!");
        }
    }
    
    
    private void supprimerColonne2(){
        
         if (nouvelleMatrice2.nbColonnes > 1){
            
           
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            grilleMatriceMoins2 = new JPanel(new GridLayout(nouvelleMatrice2.nbLignes, (nouvelleMatrice2.nbColonnes - 1), 5, 6));  
            grilleMatriceMoins2.setBounds( (zone2.getWidth()/2)- ((nouvelleMatrice2.nbColonnes - 1) * 24), 
            (zone2.getHeight()/3)- (nouvelleMatrice2.nbLignes * 5), (nouvelleMatrice2.nbColonnes - 1) * 48, nouvelleMatrice2.nbLignes * 25);
            zone2.add(grilleMatriceMoins2);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins2 = new JTextField[nouvelleMatrice2.nbLignes * (nouvelleMatrice2.nbColonnes - 1)];
            int j = 0;
            int s = 0;
            
            for(int i = 0; j < (nouvelleMatrice2.nbLignes * (nouvelleMatrice2.nbColonnes - 1)) ; i++){
                            
                if ((i != (nouvelleMatrice2.nbColonnes - 1) && s == 0) || (s != 0 && i != ((s+1) * nouvelleMatrice2.nbColonnes - 1))){
                    
                    cellulesMoins2[j] = new JTextField();
                    cellulesMoins2[j].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesMoins2[j].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
                    cellulesMoins2[j].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesMoins2[j].setBackground(Color.YELLOW);
                    grilleMatriceMoins2.add(cellulesMoins2[j]);
                    j++;
                } else {
                    s++;
                }
          
            }
            for (int i = 0; i < nouvelleMatrice2.nbLignes; i++) {
                nouvelleMatrice2.elements.remove((i*nouvelleMatrice2.nbColonnes)-(i-1));
            }
            
            nouvelleMatrice2.nbColonnes--;
            
            grilleMatrice2.setVisible(false);
            
            zone2.add(grilleMatriceMoins2);
            
            grilleMatrice2 = grilleMatriceMoins2;
            
            cellules2 = new JTextField [nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes];
            for (int i = 0 ; i < (nouvelleMatrice2.nbLignes * nouvelleMatrice2.nbColonnes); i++) {
                cellules2[i] = cellulesMoins2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText()));
            }     
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une colonne!");
        }
    }
    
    private void addition() {
        
        if (cellules != null && cellules2 != null) {
            
            if (nouvelleMatrice.nbLignes == nouvelleMatrice2.nbLignes && nouvelleMatrice.nbColonnes == nouvelleMatrice2.nbColonnes) {
                
                for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                    nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
                }
                for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                    nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
                }
                System.out.println(nouvelleMatrice.elements.size());
                System.out.println(nouvelleMatrice2.elements.size());
                double resultat = 0;
                matriceResultat = new TP3("resultat", nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes);
                
                for (int i = 0 ; i < nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes; i++ ) {
                    resultat = nouvelleMatrice.elements.get(i) + nouvelleMatrice2.elements.get(i);
                    matriceResultat.elements.set(i, resultat);
                    
                } 
                
                nom4.setText(matriceResultat.nom);
                nom4.setVisible(true);
                matriceZone4.setText(affichageZone4(matriceResultat));
                matriceZone4.setVisible(true);
                boutonSauvegarder4.setVisible(true);
                
                ecouteurBoutonSauvegarder4 = new ActionListener() {           
                    @Override
                    public void actionPerformed(ActionEvent evenement) {
                        sauvegarder4(matriceResultat);
                    }
                };
          
                 boutonSauvegarder4.addActionListener(ecouteurBoutonSauvegarder4);
                
            } else {
                JOptionPane.showMessageDialog(null, "Les deux matrices ne sont pas de la meme taille");
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas sélectionné deux matrices");
        }
    }
    private void multiplication() {
        
        
        
        if (cellules != null && cellules2 != null) {
            
            if (nouvelleMatrice.nbColonnes == nouvelleMatrice2.nbLignes) {
                
                for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                    nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
                }
                for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                    nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
                }
                
                
                matriceResultat = new TP3("resultat", nouvelleMatrice.nbLignes, nouvelleMatrice2.nbColonnes);
                
                double resultat;
                for (int i = 1; i < nouvelleMatrice.nbLignes; i++) {
                   
                    for (int j = 1 ; j < nouvelleMatrice.nbColonnes; j++) {
                        
                        resultat = 0;
                        for(int k = 1; k < nouvelleMatrice2.nbColonnes+1 ; k++) {
                            
                            resultat = resultat + (getElement(i,k) * getElement2(k,j));
                            System.out.println(i + "\t" + j + "\t" + k + "\t" + resultat);
                            System.out.println(getElement(i,k) + " matrice1");
                            System.out.println(getElement2(k,j) + " matrice2");
                            
                        }
                        setElement(i, j , resultat );
                        System.out.println(resultat + " set i : " + i + "set j" + j);
                    }
                }
                
                nom4.setText(matriceResultat.nom);
                nom4.setVisible(true);
                matriceZone4.setText(affichageZone4(matriceResultat));
                matriceZone4.setVisible(true);
                boutonSauvegarder4.setVisible(true);
                
                ecouteurBoutonSauvegarder4 = new ActionListener() {           
                    @Override
                    public void actionPerformed(ActionEvent evenement) {
                        sauvegarder4(matriceResultat);
                    }
                };
          
                 boutonSauvegarder4.addActionListener(ecouteurBoutonSauvegarder4);
            } else {
                JOptionPane.showMessageDialog(null, "La taille des deux matrices ne correspond pas");
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas sélectionné deux matrices");
        }
    }
    public void sauvegarder(){
        
        for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
            nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
        }
        
        
        boutonSauvegarder.setVisible(false);
        boutonEditer.setVisible(true);
        grilleMatrice.setVisible(false);
        demandeNom = new JPanel(null);
        demandeNom.setVisible(true);
        demandeNom.setBounds(100, 100, (LARG_FENETRE/8) * 2,HAUT_FENETRE/7);
        ((JPanel)demandeNom).setBorder(new LineBorder(Color.BLACK));
        demandeNom.setLayout(null);
        zone1.add(demandeNom);
        
        nouveauNom = new JLabel();
        nouveauNom.setText("Nouveau nom :"); 
        nouveauNom.setBounds(10, 15, 200, 20);
        demandeNom.add(nouveauNom);
        nomSaisi = new JTextField();
        for (int i = 0; i < tableauMatrice.size(); i++) {
            if (nomSaisi.getText() == tableauMatrice.get(i).nom) {
                JOptionPane.showMessageDialog(null, "Le nom demande existe deja");
                sauvegarder();
            }
        }
        
        
        
        nomSaisi.setBounds(110, 15, 90, 20);
        nomSaisi.setEditable(true);
        demandeNom.add(nomSaisi);
        
        JButton boutonOkSauv = new JButton("Ok");
        boutonOkSauv.setBackground(Color.WHITE);
        boutonOkSauv.setBounds(150, 58, 50, 20);
        demandeNom.add(boutonOkSauv);
        
        ecouteurBoutonOkSauv = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               sauvegarderNomOk();
            }
        };
          
        boutonOkSauv.addActionListener(ecouteurBoutonOkSauv);  
    }
    
    public void sauvegarderNomOk(){
        
        nouvelleMatrice.nom = nomSaisi.getText();
        
        tableauMatrice.add(nouvelleMatrice); 
        
        demandeNom.setVisible(false);
         
        modeOperations();
        
    }
    
    public void modeOperations(){
               
        if (listeMatrices.getItemCount() != tableauMatrice.size()){
            listeMatrices.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
            listeMatrices2.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
        }
        boutonSupprimerMatrice.setEnabled(true); 
        boutonNouvelle.setEnabled(true);
        boutonEditer.setEnabled(true);
        boutonLignePlus.setEnabled(false);
        boutonColonnePlus.setEnabled(false);
        boutonLigneMoins.setEnabled(false);
        boutonColonneMoins.setEnabled(false);
        boutonTransposee.setEnabled(true);
        multPar.setEnabled(true);
        multReponse.setEnabled(true);
        
    }
    public void sauvegarder2(){
        
        for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
            nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
        }
        
        
        boutonSauvegarder2.setVisible(false);
        boutonEditer2.setVisible(true);
        grilleMatrice2.setVisible(false);
        demandeNom2 = new JPanel(null);
        demandeNom2.setVisible(true);
        demandeNom2.setBounds(100, 100, (LARG_FENETRE/8) * 2,HAUT_FENETRE/7);
        ((JPanel)demandeNom2).setBorder(new LineBorder(Color.BLACK));
        demandeNom2.setLayout(null);
        zone2.add(demandeNom2);
        
        nouveauNom2 = new JLabel();
        nouveauNom2.setText("Nouveau nom :"); 
        nouveauNom2.setBounds(10, 15, 200, 20);
        demandeNom2.add(nouveauNom2);
        nomSaisi2 = new JTextField();
        for (int i = 0; i < tableauMatrice.size(); i++) {
            if (nomSaisi2.getText() == tableauMatrice.get(i).nom) {
                JOptionPane.showMessageDialog(null, "Le nom demande existe deja");
                sauvegarder();
            }
        }
        
        
        
        nomSaisi2.setBounds(110, 15, 90, 20);
        nomSaisi2.setEditable(true);
        demandeNom2.add(nomSaisi2);
        
        JButton boutonOkSauv2 = new JButton("Ok");
        boutonOkSauv2.setBackground(Color.WHITE);
        boutonOkSauv2.setBounds(150, 58, 50, 20);
        demandeNom.add(boutonOkSauv2);
        
        ecouteurBoutonOkSauv2 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               sauvegarderNomOk2();
            }
        };
          
        boutonOkSauv2.addActionListener(ecouteurBoutonOkSauv2);  
    }
    
    public void sauvegarderNomOk2(){
        
        nouvelleMatrice2.nom = nomSaisi2.getText();
        
        tableauMatrice.add(nouvelleMatrice2); 
        
        demandeNom2.setVisible(false);
         
        modeOperations2();
        
    }
    
    public void modeOperations2(){
               
        if (listeMatrices2.getItemCount() != tableauMatrice.size()){
            listeMatrices2.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
            listeMatrices.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
        }
        boutonSupprimerMatrice2.setEnabled(true); 
        boutonNouvelle2.setEnabled(true);
        boutonEditer2.setEnabled(true);
        boutonLignePlus2.setEnabled(false);
        boutonColonnePlus2.setEnabled(false);
        boutonLigneMoins2.setEnabled(false);
        boutonColonneMoins2.setEnabled(false);
        boutonTransposee2.setEnabled(true);
        multPar2.setEnabled(true);
        multReponse2.setEnabled(true);
        
    }
    public double getElement (int noLigne, int noCol) { 
        
        int position;
        
        position = ((nouvelleMatrice.nbColonnes * (noLigne-1)) + noCol)-1;
       
        return nouvelleMatrice.elements.get(position);
    }
    
    public double getElement2 (int noLigne, int noCol) { 
        
        double resultat;
        int i = (noCol + (nouvelleMatrice2.nbColonnes * (noLigne-1) ))-1;
        resultat = nouvelleMatrice2.elements.get(i);
        return resultat;
    }
    
    public void setElement (int noLigne, int noCol, double element) {
        
       int position;    
       
       position = (matriceResultat.nbColonnes * (noLigne-1) + noCol);
            
        matriceResultat.elements.set(position, element);
    }
    public void setElement2 (int noLigne, int noCol, double element) {
        
        int i = ((matriceTransposee.nbColonnes * (noLigne-1)) + noCol)-1;
        matriceTransposee.elements.set(i, element);
    }
    public void setElement3 (int noLigne, int noCol, double element) {
        
        int i = (nouvelleMatrice2.nbColonnes * (noLigne-1)) + noCol;
        nouvelleMatrice2.elements.set(i, element);
    }
    private void transposee(){
        matriceTransposee = new TP3(nouvelleMatrice.nom,nouvelleMatrice.nbColonnes,nouvelleMatrice.nbLignes);
        
        double resultat = 0;
        for (int i = 0; i < nouvelleMatrice.nbLignes; i++) {
            System.out.println("i : " + i + " j : " );
            for (int j = 0; j < nouvelleMatrice.nbColonnes; j++ ) {
                System.out.println("i : " + i + " j : " + j);
                setElement2(j, i, getElement(i,j));
                System.out.println("i : " + i + " j : " + j);
            }
        }
        nouvelleMatrice = matriceTransposee;
        JTextField [] cellulesTransposee = new JTextField[nouvelleMatrice.nbLignes *nouvelleMatrice.nbColonnes];
        
        grilleTransposee = new JPanel(new GridLayout(nouvelleMatrice.nbLignes, nouvelleMatrice.nbColonnes, 5, 6));  
        grilleTransposee.setBounds( (zone1.getWidth()/2)- (nouvelleMatrice.nbColonnes * 48 / 2), 
        (zone1.getHeight()/3)- (nouvelleMatrice.nbLignes * 25 / 5), nouvelleMatrice.nbColonnes * 48, nouvelleMatrice.nbLignes * 25);
        cellulesTransposee = new JTextField [nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes];
        for (int i = 0 ; i < nouvelleMatrice.nbLignes*nouvelleMatrice.nbColonnes; i++) {
            cellulesTransposee[i] = new JTextField();
            cellulesTransposee[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellulesTransposee[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
            cellulesTransposee[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellulesTransposee[i].setBackground(Color.YELLOW);
            grilleTransposee.add(cellulesTransposee[i]);
        }
        grilleMatrice.setVisible(false);
        zone1.add(grilleTransposee);
        grilleMatrice = grilleTransposee;
        for (int i = 0 ; i < (nouvelleMatrice.nbLignes * nouvelleMatrice.nbColonnes); i++) {
                cellules[i] = cellulesTransposee[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText())); 
            }
    }
   
    private void transposee2(){
        TP3 m = new TP3(nouvelleMatrice2.nom,this.nbColonnes2,this.nbLignes2);
        
        
        for (int i = 0; i < nbLignes2; i++) {
            for (int j = 0; j < nbColonnes2; j++ ) {
                m.setElement2(j, i, getElement2(i,j));
            }
        }
        nouvelleMatrice2 = m;
        cellules2 = new JTextField[nbLignes2 *nbColonnes2];
        
        grilleTransposee2 = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
        grilleTransposee2.setBounds( (zone2.getWidth()/2)- (nbColonnes2 * 48 / 2), 
        (zone4.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
        
        for (int i = 0 ; i < nbLignes2*nbColonnes2; i++) {
            cellules2[i] = new JTextField();
            cellules2[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
            cellules2[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules2[i].setBackground(Color.YELLOW);
            grilleTransposee2.add(cellules2[i]);
        }
        grilleMatrice2.setVisible(false);
        zone2.add(grilleTransposee2);
        grilleMatrice2 = grilleTransposee2;
        
    }
    private void multpar(double nombre) {
        double resultat = 0;
        
        for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
           resultat = nombre*nouvelleMatrice.elements.get(i);
           nouvelleMatrice.elements.set(i, resultat);
        }
        cellules = new JTextField[nbLignes *nbColonnes];
        
        grilleMultPar = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
        grilleMultPar.setBounds( (zone2.getWidth()/2)- (nbColonnes * 48 / 2), 
        (zone4.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);

        for (int i = 0 ; i < nbLignes*nbColonnes; i++) {
            cellules[i] = new JTextField();
            cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
            cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules[i].setBackground(Color.YELLOW);
            grilleMultPar.add(cellules[i]);
        }
        grilleMatrice2.setVisible(false);
        zone2.add(grilleMultPar);
        grilleMatrice2 = grilleMultPar;
    }
    private void multpar2(double nombre) {
       double resultat = 0;
       
       for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
           resultat = nombre*nouvelleMatrice2.elements.get(i);
           nouvelleMatrice2.elements.set(i, resultat);
       }
       cellules2 = new JTextField[nbLignes2 *nbColonnes2];
        
        grilleMultPar2 = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
        grilleMultPar2.setBounds( (zone2.getWidth()/2)- (nbColonnes2 * 48 / 2), 
        (zone4.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
        
        for (int i = 0 ; i < nbLignes2*nbColonnes2; i++) {
            cellules2[i] = new JTextField();
            cellules2[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
            cellules2[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules2[i].setBackground(Color.YELLOW);
            grilleMultPar2.add(cellules2[i]);
        }
        grilleMatrice2.setVisible(false);
        zone2.add(grilleMultPar2);
        grilleMatrice2 = grilleMultPar2;
    }
    
    /**
     * A la fermeture de la fenetre, enregistrement de toutes les matrices
     * dans le fichier FIC_MATRICES.
     * @param e l'evenement de fermeture de fenetre.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        
        
                
        try {
            
            BufferedWriter ecrire2 = new BufferedWriter(new FileWriter(new File("matricefin.txt")));
            
            for (int i = 0; i < tableauMatrice.size(); i++){
                
                ecrire2.write(tableauMatrice.get(i).nom + ":");
                ecrire2.write(tableauMatrice.get(i).nbLignes + ";");
                ecrire2.write(tableauMatrice.get(i).nbColonnes + ";");
                
                for (int j = 0; j < tableauMatrice.get(i).nbLignes * tableauMatrice.get(i).nbColonnes; j++ ) {
                    ecrire2.write(Double.toString(tableauMatrice.get(i).elements.get(j)) + ";");
                    
                }
                ecrire2.write("\r\n");
            }
            ecrire2.close();
        }
        catch (IOException exception)
        {
            
        }
    }
    private void editer() {
        for (int i = 0; i < cellules.length; i++) {
            cellules[i].setEditable(true);
            cellules[i].setBackground(Color.YELLOW);
        }
        boutonEditer.setVisible(false);
        boutonSauvegarder = new JButton("Sauvegarder");
        boutonSauvegarder.setBackground(Color.WHITE);
        boutonSauvegarder.setBounds((zone1.getWidth()/4) + 7, 300, 90, 25);
        boutonSauvegarder.setBorder(null);
        boutonSauvegarder.setEnabled(true);
        zone1.add(boutonSauvegarder);
        boutonSauvegarder.setVisible(true);
        boutonLigneMoins.setEnabled(true);
        boutonLignePlus.setEnabled(true);
        boutonColonnePlus.setEnabled(true);
        boutonColonneMoins.setEnabled(true);
        boutonTransposee.setEnabled(false);
        multReponse.setEditable(false);
        ecouteurBoutonSauvegarder = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

                sauvegarder();
            }
        };
          
        boutonSauvegarder.addActionListener(ecouteurBoutonSauvegarder);
    }
    private void editer2() {
        for (int i = 0; i < cellules.length; i++) {
            cellules2[i].setEditable(false);
            cellules2[i].setBackground(Color.YELLOW);
        }
    }
    private void supprimerMatrice() {
        for (int i = 0; i < tableauMatrice.size(); i++) {
            if (listeMatrices.getSelectedItem() == tableauMatrice.get(i).nom) {
                listeMatrices.setVisible(false);
                tableauMatrice.remove(i);
                listeMatrices.removeItem(i);
                listeMatrices2.removeItem(i);
                System.out.println();
                listeMatrices.setVisible(true);
                listeMatricesPlus = new JComboBox(getListeNomMatrice(tableauMatrice));
                listeMatricesPlus.setBounds((zone1.getWidth()/4) - 10, 25, 110, 25);
                
                zone1.add(listeMatricesPlus);

                listeMatrices = listeMatricesPlus;
                texteZone1Depart.setVisible(false);
                listeMatrices.setVisible(true);
                grilleMatrice.setVisible(false);
                //listeMatrices.getComponent(i);
            }
        }
    }
    private void supprimerMatrice2() {
        for (int i = 0; i < tableauMatrice.size(); i++) {
            if (listeMatrices2.getSelectedItem() == tableauMatrice.get(i).nom) {
                listeMatrices.setVisible(false);
                tableauMatrice.remove(i);
                listeMatrices.removeItem(i);
                listeMatrices2.removeItem(i);
                listeMatrices2 = new JComboBox(getListeNomMatrice(tableauMatrice));
                listeMatrices2.setBounds((zone1.getWidth()/4) - 10, 25, 110, 25);
                listeMatrices2.setBackground(Color.WHITE);
                zone2.add(listeMatrices);
                listeMatrices2.setVisible(true);
                listeMatrices = new JComboBox(getListeNomMatrice(tableauMatrice));
                listeMatrices.setBounds((zone1.getWidth()/4) - 10, 25, 110, 25);
                listeMatrices.setBackground(Color.WHITE);
                zone1.add(listeMatrices);
                listeMatrices.setVisible(true);
            }
        }
        grilleMatrice.setVisible(false);
    }
    
    public void lectureStockageFichier(){
        FileReader fichierExistant;
        BufferedReader lecteur ;
        String line;
        int nbColonnesLecture;
        int nbLignesLecture;
        
        ArrayList<Double> elementTemp = new ArrayList<Double>();
        NumberFormat nf = NumberFormat.getInstance();
        try {
        
            fichierExistant = new FileReader(FIC_MATRICES);
            lecteur = new BufferedReader(new FileReader(FIC_MATRICES));
            try {
                
                while ((line = lecteur.readLine()) != null ) {
                    String nomLecture= "";
                    TP3 matriceLecture;
                    int i =0;
                    int j = 0;
                    String elem= "";
                    Double eleme;
                    
                    while (line.charAt(i) != ':') {
                        
                        nomLecture = nomLecture + line.charAt(i);
                        i++;
                        
                    }
                    
                    i++;
                    
                    nbLignesLecture = Character.getNumericValue(line.charAt(i));
                   
                    i = i+2;
                    nbColonnesLecture = Character.getNumericValue(line.charAt(i));
                   
                    i = i+2;
                    matriceLecture = new TP3(nomLecture, nbLignesLecture, nbColonnesLecture);
                    while (i < line.length()) {
                        elem = "";
                       while (line.charAt(i) != ';') {
                           
                           elem = elem + line.charAt(i);
                           i++;
                           
                       }
                       i++;
                       
                        try {
                            
                            eleme = nf.parse(elem).doubleValue();
                            matriceLecture.elements.set(j, eleme);
                        
                        } catch (ParseException ex) {
                            
                        }
                       
                       
                       j++;
                       
                    }
                    tableauMatrice.add(matriceLecture);
                    
                    
                }
                
                lecteur.close();
                
                
            } catch (IOException ioex) {
                
            }
            
        } catch (FileNotFoundException ioe) {
           
        }
    }
    public String affichageZone4(TP3 matriceAfficher){
        
        final DecimalFormat DEC_FORMAT = new DecimalFormat("0.0");
        final int ESP = 8; 
        int num;
        String sTmp;
        String s = "[";
            for (int i = 0 ; i < (matriceAfficher.nbLignes * matriceAfficher.nbColonnes) ; i++) {
            //etendre i sur ESP colonnes
            sTmp = "";
            num =  ESP - DEC_FORMAT.format(matriceAfficher.elements.get(i)).length();
            for (int j = 0 ; j < num ; j++) {
                sTmp = sTmp + " ";
            }
            sTmp = sTmp + DEC_FORMAT.format(matriceAfficher.elements.get(i));

            if (i != 0 && i % matriceAfficher.nbColonnes == 0) {
                s = s + "  ]\n[" + sTmp; 
            } else {
                s = s + sTmp;
            }
        }
        s = s + "  ]";
        return s;
    }
    public void sauvegarder4(TP3 matriceReponse){
        
        nom4.setVisible(false);
        matriceZone4.setVisible(false);
        demandeNom4 = new JPanel(null);
        demandeNom4.setVisible(true);
        demandeNom4.setBounds(270, 40, 250, 90);
        ((JPanel)demandeNom4).setBorder(new LineBorder(Color.BLACK));
        demandeNom4.setLayout(null);
        zone4.add(demandeNom4);
        
        nouveauNom4 = new JLabel();
        nouveauNom4.setText("Nouveau nom :"); 
        nouveauNom4.setBounds(10, 15, 100, 20);
        demandeNom4.add(nouveauNom4);
        nomSaisi4 = new JTextField();
        nomSaisi4.setBounds(110, 15, 90, 20);
        nomSaisi4.setEditable(true);
        demandeNom4.add(nomSaisi4);
        
        JButton boutonOkSauv4 = new JButton("Ok");
        boutonOkSauv4.setBackground(Color.WHITE);
        boutonOkSauv4.setBounds(150, 55, 50, 20);
        demandeNom4.add(boutonOkSauv4);
        
        ecouteurBoutonOkSauv4 = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent evenement) {

               sauvegarderNomOk4(matriceReponse);
            }
        };
          
        boutonOkSauv4.addActionListener(ecouteurBoutonOkSauv4);
    }
    public void sauvegarderNomOk4(TP3 matriceReponse){
        
        tableauMatrice.add(matriceReponse); 
        demandeNom4.setVisible(false);
        matriceReponse.nom = nomSaisi4.getText();
        nom4.setText(matriceReponse.nom);
        nom4.setVisible(true);
        matriceZone4.setVisible(true);
        
        listeMatrices.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
        listeMatrices2.addItem(tableauMatrice.get(tableauMatrice.size()-1).nom);
    }
    
    
    public static void main (String [] args) {
       new TP3();
    }
   
}
