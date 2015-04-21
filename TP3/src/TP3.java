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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private JLabel multPar;
    private JLabel multPar2;
    private JLabel nouveauNom;
    private JLabel nouveauNom2;
    
    private JTextArea texteZone1Depart;
    private JTextArea multReponse;
    private JTextArea additionReponse;
    private JTextArea texteZone2Depart;
    private JTextArea multReponse2;
    
    private ArrayList<Double> elements;
    private ArrayList<Double> elements2;
    private ArrayList<TP3> tableauMatrice = new ArrayList<TP3>();
    
    private JTextField [] cellules;
    private JTextField [] cellules2;
    private JTextField [] cellulesPlus;
    private JTextField [] cellulesPlus2;
    private JTextField [] cellulesMoins;
    private JTextField [] cellulesMoins2;
    private JTextField [] cellulesAddition;
    
    private JTextField nomSaisi;
    private JTextField nomSaisi2;
    
    
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
    private ActionListener ecouteurBoutonTransposee;
    private ActionListener ecouteurBoutonTransposee2;
    private ActionListener ecouteurBoutonmultPar;
    private ActionListener ecouteurBoutonmultPar2;
    
   
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
        boutonSupprimer = new JButton("Supprimer");
        boutonSupprimer.setBackground(Color.WHITE);
        boutonSupprimer.setBounds((zone1.getWidth()/4) * 2, 25, 110, 25);
        boutonSupprimer.setBorder(null);
        boutonSupprimer.setEnabled(false); 
        zone1.add(boutonSupprimer);
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
        listeMatrices2 = new JComboBox();
        listeMatrices2.setBounds((zone2.getWidth()/4) - 10, 25, 110, 25);
        listeMatrices2.setBackground(Color.WHITE);
        zone2.add(listeMatrices2);
        boutonSupprimer2 = new JButton("Supprimer");
        boutonSupprimer2.setBackground(Color.WHITE);
        boutonSupprimer2.setBounds((zone2.getWidth()/4) * 2, 25, 110, 25);
        boutonSupprimer2.setBorder(null);
        boutonSupprimer2.setEnabled(false);
        zone2.add(boutonSupprimer2);
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
        fenetre.getContentPane().add(zone4);
      
      
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
        
    }
   


    
    
   
    @Override
    public void actionPerformed (ActionEvent e) {
      
        
      
    }
    
    
    
    public void nouvelle() {
        
        boutonNouvelle.setSelected(true);
        texteZone1Depart.setVisible(false);
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
        
        
        cellules = new JTextField [nbLignes * nbColonnes];
        nouvelleMatrice = new TP3("baba", nbLignes, nbColonnes);
        
        for (int i = 0; i < nouvelleMatrice.elements.size() ; i++) {
            cellules[i] = new JTextField();
            cellules[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
            cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
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
        boutonSauvegarder2.setBounds((zone2.getWidth()/4) + 7, 300, 90, 25);
        boutonSauvegarder2.setBorder(null);
        zone2.add(boutonSauvegarder2);
        boutonLignePlus2.setEnabled(true);
        boutonColonnePlus2.setEnabled(true);
        boutonLigneMoins2.setEnabled(true);
        boutonColonneMoins2.setEnabled(true);
        grilleMatrice2 = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
        grilleMatrice2.setBounds( (zone2.getWidth()/2)- (nbColonnes2 * 48 / 2), 
        (zone2.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
        zone2.add(grilleMatrice2);
        
        
        cellules2 = new JTextField [nbLignes2 * nbColonnes2];
        nouvelleMatrice2 = new TP3("baba", nbLignes2, nbColonnes2);
        
        for (int i = 0; i < nouvelleMatrice2.elements.size() ; i++) {
            cellules2[i] = new JTextField();
            cellules2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
            cellules2[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules2[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules2[i].setBackground(Color.YELLOW);
                    
            grilleMatrice2.add(cellules2[i]);
            
            
            
        }
    }
        
    public void ajouterLigne() {
        
        if (nbLignes < 8){
            DecimalFormat df = new DecimalFormat("0.0###");
            
            nouvelleMatrice.elements.clear();
            for (int i = 0; i < nbLignes * nbColonnes; i++) {
                
                nouvelleMatrice.elements.add(Double.parseDouble(cellules[i].getText()));
            }
            
            nbLignes = nbLignes + 1;
            
            grilleMatricePlus = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
            grilleMatricePlus.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
          
            
            cellulesPlus = new JTextField[nbLignes * nbColonnes];
            for (int i = 0 ; i < ((nbLignes - 1) * nbColonnes) ; i++) {
                cellulesPlus[i] = new JTextField();
                cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus[i].setText(String.valueOf(nouvelleMatrice.elements.get(i)));
                cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus[i].setBackground(Color.YELLOW);
                
                grilleMatricePlus.add(cellulesPlus[i]);
            }
            
            for (int i = (nbLignes - 1) * nbColonnes ; i < ((nbLignes - 1) * nbColonnes) + nbColonnes ; i++) {
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
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesPlus[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText())); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 lignes!");
        }
    }
    public void ajouterLigne2() {
        
        if (nbLignes2 < 8){
            DecimalFormat df = new DecimalFormat("0.0###");
            
            
            for (int i = 0; i < nbLignes2 * nbColonnes2; i++) {
                
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText()));
            }
            
            nbLignes2 = nbLignes2 + 1;
            
            grilleMatricePlus2 = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
            grilleMatricePlus2.setBounds( (zone2.getWidth()/2)- (nbColonnes2 * 48 / 2), 
            (zone2.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
          
            
            cellulesPlus2 = new JTextField[nbLignes2 * nbColonnes2];
            for (int i = 0 ; i < ((nbLignes2 - 1) * nbColonnes2) ; i++) {
                cellulesPlus2[i] = new JTextField();
                cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus2[i].setText(String.valueOf(nouvelleMatrice2.elements.get(i)));
                cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesPlus2[i].setBackground(Color.YELLOW);
                
                grilleMatricePlus2.add(cellulesPlus2[i]);
            }
            
            for (int i = (nbLignes2 - 1) * nbColonnes2 ; i < ((nbLignes2 - 1) * nbColonnes2) + nbColonnes2 ; i++) {
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
            
            cellules2 = new JTextField [nbLignes2 * nbColonnes2];
            for (int i = 0 ; i < (nbLignes2 * nbColonnes2); i++) {
                cellules2[i] = cellulesPlus2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText())); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 lignes!");
        }
    }
    
    private void ajouterColonne(){  
          
        if (nbColonnes < 8){
            System.out.println(cellules.length);
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            System.out.println();
            grilleMatricePlus = new JPanel(new GridLayout(nbLignes, (nbColonnes +1), 5, 6));  
            grilleMatricePlus.setBounds((zone1.getWidth()/2) - ((nbColonnes+1) * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), (nbColonnes+1) * 48, nbLignes * 25);
    
            cellulesPlus = new JTextField[nbLignes * (nbColonnes+1)];
            System.out.println(cellulesPlus.length);
            System.out.println(nbColonnes);
            System.out.println(nbLignes);
            elements2 = new ArrayList<Double>();
            DecimalFormat df = new DecimalFormat("0.0###");
            int k = 0;
            int s = 1;
            for(int i = 0; i < nbLignes * (nbColonnes+1) ; i++){
                            
                if ((i % (((nbColonnes+1)*s)-1)) == 0 && i != 0){
                    System.out.println("if : " + i );
                    System.out.println(cellulesPlus.length);
                    cellulesPlus[i] = new JTextField();
                    cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus[i].setText("0.0");
                    cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus[i].setBackground(Color.YELLOW);
                    grilleMatricePlus.add(cellulesPlus[i]);
                    elements2.add(0.0);
                    s++;
                    
                } else {
                    System.out.println("else k : " + k);
                    System.out.println(nouvelleMatrice.elements.size() + " taille");
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
            nbColonnes++;
            
            grilleMatrice.setVisible(false);
            grilleMatrice = grilleMatricePlus;
            zone1.add(grilleMatricePlus);
            grilleMatrice.setVisible(true);
            cellules = new JTextField [nbLignes * nbColonnes];
            nouvelleMatrice.elements.clear();
            for (int i = 0 ; i < nbLignes * nbColonnes ; i++) {
                cellules[i] = cellulesPlus[i];
                nouvelleMatrice.elements.add(elements2.get(i));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 colonnes!");
        }
    }
    private void ajouterColonne2(){  
          
        if (nbColonnes2 < 8){
            System.out.println(cellules2.length);
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            System.out.println();
            grilleMatricePlus2 = new JPanel(new GridLayout(nbLignes2, (nbColonnes2 +1), 5, 6));  
            grilleMatricePlus2.setBounds((zone2.getWidth()/2) - ((nbColonnes2+1) * 48 / 2), 
            (zone2.getHeight()/3)- (nbLignes2 * 25 / 5), (nbColonnes2+1) * 48, nbLignes2 * 25);
    
            cellulesPlus2 = new JTextField[nbLignes2 * (nbColonnes2+1)];
            System.out.println(cellulesPlus2.length);
            System.out.println(nbColonnes2);
            System.out.println(nbLignes2);
            elements2 = new ArrayList<Double>();
            DecimalFormat df = new DecimalFormat("0.0###");
            int k = 0;
            int s = 1;
            for(int i = 0; i < nbLignes2 * (nbColonnes2+1) ; i++){
                            
                if ((i % (((nbColonnes2+1)*s)-1)) == 0 && i != 0){
                    System.out.println("if : " + i );
                    System.out.println(cellulesPlus2.length);
                    cellulesPlus2[i] = new JTextField();
                    cellulesPlus2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus2[i].setText("0.0");
                    cellulesPlus2[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus2[i].setBackground(Color.YELLOW);
                    grilleMatricePlus2.add(cellulesPlus2[i]);
                    elements2.add(0.0);
                    s++;
                    
                } else {
                    System.out.println("else k : " + k);
                    System.out.println(nouvelleMatrice2.elements.size() + " taille");
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
            nbColonnes2++;
            
            grilleMatrice2.setVisible(false);
            grilleMatrice2 = grilleMatricePlus2;
            zone2.add(grilleMatricePlus2);
            grilleMatrice2.setVisible(true);
            cellules2 = new JTextField [nbLignes2 * nbColonnes2];
            nouvelleMatrice2.elements.clear();
            for (int i = 0 ; i < nbLignes2 * nbColonnes2 ; i++) {
                cellules2[i] = cellulesPlus2[i];
                nouvelleMatrice2.elements.add(elements2.get(i));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 colonnes!");
        }
    }
    
    private void supprimerLigne() {
        
        if (nbLignes > 1){
            
            
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            
            nbLignes = nbLignes - 1;
            
            grilleMatriceMoins = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins = new JTextField[nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes) ; i++) {
                cellulesMoins[i] = new JTextField();
                cellulesMoins[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesMoins[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
                cellulesMoins[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesMoins[i].setBackground(Color.YELLOW);
                grilleMatriceMoins.add(cellulesMoins[i]);
            }
            
            for (int i = (nbColonnes * (nbLignes+1))-1 ; i > (nbColonnes * nbLignes)-1 ; i--) {
                
                nouvelleMatrice.elements.remove(i);
                
            }
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText()));
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
        
         if (nbColonnes > 1){
            
           
            for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
            }
            grilleMatriceMoins = new JPanel(new GridLayout(nbLignes, (nbColonnes - 1), 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- ((nbColonnes - 1) * 24), 
            (zone1.getHeight()/3)- (nbLignes * 5), (nbColonnes - 1) * 48, nbLignes * 25);
            zone1.add(grilleMatriceMoins);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins = new JTextField[nbLignes * (nbColonnes - 1)];
            int j = 0;
            int s = 0;
            
            for(int i = 0; j < (nbLignes * (nbColonnes - 1)) ; i++){
                            
                if ((i != (nbColonnes - 1) && s == 0) || (s != 0 && i != ((s+1) * nbColonnes - 1))){
                    
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
            for (int i = 0; i < nbLignes; i++) {
                nouvelleMatrice.elements.remove((i*nbColonnes)-(i-1));
            }
            
            nbColonnes--;
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
                nouvelleMatrice.elements.set(i, Double.parseDouble(cellules[i].getText()));
            }     
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une colonne!");
        }
    }
    private void supprimerLigne2() {
        
            if (nbLignes2 > 1){
            
            
           
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            
            nbLignes2--;
            
            grilleMatriceMoins2 = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
            grilleMatriceMoins2.setBounds( (zone2.getWidth()/2)- (nbColonnes2 * 48 / 2), 
            (zone2.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins2 = new JTextField[nbLignes2 * nbColonnes2];
            for (int i = 0 ; i < (nbLignes2 * nbColonnes2) ; i++) {
                cellulesMoins2[i] = new JTextField();
                cellulesMoins2[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesMoins2[i].setText(Double.toString(nouvelleMatrice2.elements.get(i)));
                cellulesMoins2[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesMoins2[i].setBackground(Color.YELLOW);
                grilleMatriceMoins2.add(cellulesMoins2[i]);
            }
            
            for (int i = (nbColonnes2 * (nbLignes2+1))-1 ; i > (nbColonnes2 * nbLignes2)-1 ; i--) {
                
                nouvelleMatrice2.elements.remove(i);
                
            }
            
            grilleMatrice2.setVisible(false);
            
            zone2.add(grilleMatriceMoins2);
            
            grilleMatrice2 = grilleMatriceMoins2;
            
            cellules2 = new JTextField [nbLignes2 * nbColonnes2];
            for (int i = 0 ; i < (nbLignes2 * nbColonnes2); i++) {
                cellules2[i] = cellulesMoins2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une ligne!");
        }
    }
    
    private void supprimerColonne2(){
        
            if (nbColonnes2 > 1){
            
           
            for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
            }
            grilleMatriceMoins2 = new JPanel(new GridLayout(nbLignes2, (nbColonnes2 - 1), 5, 6));  
            grilleMatriceMoins2.setBounds( (zone2.getWidth()/2)- ((nbColonnes2 - 1) * 24), 
            (zone2.getHeight()/3)- (nbLignes2 * 5), (nbColonnes2 - 1) * 48, nbLignes2 * 25);
            zone2.add(grilleMatriceMoins2);
            DecimalFormat df = new DecimalFormat("0.0###");

            cellulesMoins2 = new JTextField[nbLignes2 * (nbColonnes2 - 1)];
            int j = 0;
            int s = 0;
            
            for(int i = 0; j < (nbLignes2 * (nbColonnes2 - 1)) ; i++){
                            
                if ((i != (nbColonnes2 - 1) && s == 0) || (s != 0 && i != ((s+1) * nbColonnes2 - 1))){
                    
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
            for (int i = 0; i < nbLignes2; i++) {
                nouvelleMatrice2.elements.remove((i*nbColonnes2)-(i-1));
            }
            
            nbColonnes2--;
            
            grilleMatrice2.setVisible(false);
            
            zone2.add(grilleMatriceMoins2);
            
            grilleMatrice2 = grilleMatriceMoins2;
            
            cellules2 = new JTextField [nbLignes2 * nbColonnes2];
            for (int i = 0 ; i < (nbLignes2 * nbColonnes2); i++) {
                cellules2[i] = cellulesMoins2[i];
                nouvelleMatrice2.elements.set(i, Double.parseDouble(cellules2[i].getText()));
            }     
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une colonne!");
        }
    }
    
    private void addition() {
        
        if (nouvelleMatrice != null && nouvelleMatrice2 != null) {
            
            if (nbLignes == nbLignes2 && nbColonnes == nbColonnes2) {
                
                for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                    nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
                }
                for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                    nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
                }
                
                double resultat = 0;
                matriceResultat = new TP3("resultat", nbLignes, nbColonnes);
                
                for (int i = 0 ; i < nbLignes * nbColonnes; i++ ) {
                    resultat = nouvelleMatrice.elements.get(i) + nouvelleMatrice2.elements.get(i);
                    matriceResultat.elements.set(i, resultat);
                } 
                
                cellules = new JTextField[nbLignes *nbColonnes];
                
                
                additionReponse = new JTextArea();
                grilleResultat = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
                grilleResultat.setBounds( (zone4.getWidth()/2)- (nbColonnes2 * 48 / 2), 
                (zone4.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
            
                for (int i = 0 ; i < nbLignes*nbColonnes; i++) {
                    cellules[i] = new JTextField();
                    cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellules[i].setText(Double.toString(matriceResultat.elements.get(i)));
                    cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellules[i].setBackground(Color.YELLOW);
                    grilleResultat.add(cellules[i]);
                    
                }
            
                grilleResultat.setVisible(true);
                zone4.add(grilleResultat);
            } else {
                JOptionPane.showMessageDialog(null, "Les deux matrices ne sont pas de la meme taille");
            }
            
        }else {
            JOptionPane.showMessageDialog(null, "Vous n'avez pas sélectionné deux matrices");
        }
    }
    private void multiplication() {
        System.out.println("dans mutiplication");
        
        
        if (nouvelleMatrice != null && nouvelleMatrice2 != null) {
            
            if (nbColonnes == nbLignes2) {
                
                for (int i = 0; i < nouvelleMatrice.elements.size(); i++) {
                    nouvelleMatrice.elements.set(i,Double.parseDouble(cellules[i].getText()));
                }
                for (int i = 0; i < nouvelleMatrice2.elements.size(); i++) {
                    nouvelleMatrice2.elements.set(i,Double.parseDouble(cellules2[i].getText()));
                }
                
                
                matriceResultat = new TP3("resultat", nbLignes, nbColonnes2);
                
                double position;
                for (int i = 0; i < nbLignes; i++) {
                    for (int j = 0; j < nbColonnes2; j++) {
                        position = 0;
                        for(int k = 0; k < this.nbColonnes; k++) {
                            position = position + nouvelleMatrice.getElement(i,k) * nouvelleMatrice2.getElement2(k,j);
                            matriceResultat.setElement(i, j , position);
                            System.out.println(i + " : i " + k + " : k ");
                        }
                
                    }
                }
                
                cellules = new JTextField[nbLignes *nbColonnes];
                additionReponse = new JTextArea();
                grilleResultat = new JPanel(new GridLayout(nbLignes2, nbColonnes2, 5, 6));  
                grilleResultat.setBounds( (zone4.getWidth()/2)- (nbColonnes2 * 48 / 2), 
                (zone4.getHeight()/3)- (nbLignes2 * 25 / 5), nbColonnes2 * 48, nbLignes2 * 25);
            
                for (int i = 0 ; i < nbLignes*nbColonnes; i++) {
                    cellules[i] = new JTextField();
                    cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellules[i].setText(Double.toString(matriceResultat.elements.get(i)));
                    cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellules[i].setBackground(Color.YELLOW);
                    grilleResultat.add(cellules[i]);
                    System.out.println(cellules[i]);
                }
            
                grilleResultat.setVisible(true);
                zone4.add(grilleResultat);
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
        demandeNom.setBounds(100, 100, (LARG_FENETRE/4) * 2,HAUT_FENETRE/7);
        ((JPanel)demandeNom).setBorder(new LineBorder(Color.BLACK));
        demandeNom.setLayout(null);
        zone1.add(demandeNom);
        
        nouveauNom = new JLabel();
        nouveauNom.setText("Nouveau nom :"); 
        nouveauNom.setBounds(10, 15, 200, 20);
        demandeNom.add(nouveauNom);
        nomSaisi = new JTextField();
        nomSaisi.setBounds(110, 15, 140, 20);
        nomSaisi.setEditable(true);
        demandeNom.add(nomSaisi);
        
        nouvelleMatrice.nom = nomSaisi.getText();
        
        tableauMatrice.add(nouvelleMatrice);
        
        JButton boutonOkSauv = new JButton("Ok");
        boutonOkSauv.setBackground(Color.WHITE);
        boutonOkSauv.setBounds(150, 58, 50, 20);
        demandeNom.add(boutonOkSauv);
        
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
        demandeNom2.setBounds(100, 100, (LARG_FENETRE/4) * 2,HAUT_FENETRE/7);
        ((JPanel)demandeNom2).setBorder(new LineBorder(Color.BLACK));
        demandeNom2.setLayout(null);
        zone2.add(demandeNom2);
        
        nouveauNom2 = new JLabel();
        nouveauNom2.setText("Nouveau nom :"); 
        nouveauNom2.setBounds(10, 15, 200, 20);
        demandeNom2.add(nouveauNom2);
        nomSaisi2 = new JTextField();
        nomSaisi2.setBounds(110, 15, 140, 20);
        nomSaisi2.setEditable(true);
        demandeNom2.add(nomSaisi2);
        
        nouvelleMatrice2.nom = nomSaisi2.getText();
        
        tableauMatrice.add(nouvelleMatrice2);
        
        JButton boutonOkSauv2 = new JButton("Ok");
        boutonOkSauv2.setBackground(Color.WHITE);
        boutonOkSauv2.setBounds(150, 58, 50, 20);
        demandeNom2.add(boutonOkSauv2);
        
    }
    public double getElement (int noLigne, int noCol) { 
        
        int position;
        position = (this.nbColonnes * noLigne) + noCol;
       
        return nouvelleMatrice.elements.get(position);
    }
    public double getElement2 (int noLigne, int noCol) { 
        
        double resultat;
        int i = noCol + (this.nbColonnes2 * (noLigne) );
        resultat = nouvelleMatrice2.elements.get(i);
        return resultat;
    }
    
    public void setElement (int noLigne, int noCol, double element) {
        
       int position;    

        position = (this.nbColonnes * noLigne)+ noCol;
       
        this.elements.set(position, element);
    }
    public void setElement2 (int noLigne, int noCol, double element) {
        
        int i = noCol + (this.nbColonnes2 * (noLigne) );
        nouvelleMatrice2.elements.set(i, element);
    }
    private void transposee(){
        TP3 m = new TP3(nouvelleMatrice.nom,this.nbColonnes,this.nbLignes);
        
        double resultat = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++ ) {
                m.setElement(j, i, getElement(i,j));
            }
        }
        nouvelleMatrice = m;
        cellules = new JTextField[nbLignes *nbColonnes];
        
        grilleTransposee = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
        grilleTransposee.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
        (zone4.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
        
        for (int i = 0 ; i < nbLignes*nbColonnes; i++) {
            cellules[i] = new JTextField();
            cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules[i].setText(Double.toString(nouvelleMatrice.elements.get(i)));
            cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules[i].setBackground(Color.YELLOW);
            grilleTransposee.add(cellules[i]);
        }
        grilleMatrice.setVisible(false);
        zone1.add(grilleTransposee2);
        grilleMatrice = grilleTransposee;
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
                System.out.println(ioex.getMessage() + "Error reading file");
            }
            
        } catch (FileNotFoundException ioe) {
            System.out.println(ioe.getMessage() + "The file was not found");
        }
    }
    
    public static void main (String [] args) {
       new TP3();
    }
   
}
