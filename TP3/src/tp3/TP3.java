/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
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
    private JButton boutonSupprimer;
    private JTextArea texteZone1Depart;
    private JButton boutonNouvelle;
    private JButton boutonEditer;
    private JButton boutonLignePlus;
    private JButton boutonColonnePlus;
    private JButton boutonLigneMoins;
    private JButton boutonColonneMoins;
    private JButton boutonTransposee;
    private JButton boutonSauvegarder;
    private JLabel multPar;
    private JTextArea multReponse;
    private JComboBox listeMatrices2;
    private JButton boutonSupprimer2;
    private JTextArea texteZone2Depart;
    private JButton boutonNouvelle2;
    private JButton boutonEditer2;
    private JButton boutonLignePlus2;
    private JButton boutonColonnePlus2;
    private JButton boutonLigneMoins2;
    private JButton boutonColonneMoins2;
    private JButton boutonTransposee2;
    private JButton boutonSauvegarder2;
    private JLabel multPar2;
    private JTextArea multReponse2;
    private JButton boutonAddition;
    private JButton boutonMultiplication;
    private ActionListener ecouteurBoutonNouvelle;
    private ActionListener ecouteurBoutonOk;
    private JTextField [] cellules;
    private String nbLignesS;
    private String nbColonnesS;
    private int nbLignes;
    private int nbColonnes;
    private JComboBox nbLignesReponse;
    private JComboBox nbColonnesReponse;
    private ActionListener ecouteurLignes;
    private ActionListener ecouteurColonnes;
    private ActionListener ecouteurLignePlus;
    private ActionListener ecouteurColonnePlus;
    private ActionListener ecouteurLigneMoins;
    private ActionListener ecouteurColonneMoins;
   
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
    private JPanel grilleMatrice;
    private JPanel grilleMatricePlus;
    private JPanel grilleMatriceMoins;
   
 

    /**
     * Constructeur qui initialise l'application.
    */
    public TP3() {
        init(); 
    }
   
    /**
    * Initialisation des composants graphiques.
    */
    private void init() {
      
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
        listeMatrices = new JComboBox();
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
        boutonAddition.setEnabled(false);
        zone3.add(boutonAddition);
        boutonMultiplication = new JButton(" * ");
        boutonMultiplication.setBackground(Color.WHITE);
        boutonMultiplication.setBounds(((zone3.getWidth())- 35)/2, (zone3.getHeight()/2)+ 20, 35, 25);
        boutonMultiplication.setBorder(null);
        boutonMultiplication.setEnabled(false);
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
    }  
   
    @Override
    public void actionPerformed (ActionEvent e) {
      
        
      
    }
    
    /**
     * A la fermeture de la fenetre, enregistrement de toutes les matrices
     * dans le fichier FIC_MATRICES.
     * @param e l'evenement de fermeture de fenetre.
     */
    @Override
    public void windowClosing(WindowEvent e) {
       //TODO...
    }
    
    private void nouvelle() {
        
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
        nbLignesReponse.setBounds(150, 15, 40, 20);
        nbLignesReponse.setEditable(false);
        nbLignesReponse.setSelectedIndex(0);
        choixNombreLC.add(nbLignesReponse);
        
        JLabel nombreColonnes = new JLabel();
        nombreColonnes.setText("Nombre de colonnes :"); 
        nombreColonnes.setBounds(10, 48, 130, 20);
        choixNombreLC.add(nombreColonnes);
        nbColonnesReponse = new JComboBox(listeChoix);
        nbColonnesReponse.setBounds(150, 48, 40, 20);
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

    private void ok() {
        
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
        for (int i = 0; i < cellules.length ; i++) {
            cellules[i] = new JTextField();
            cellules[i].setFont(new Font("Courier", Font.PLAIN, 12));
            cellules[i].setText("0.0");
            cellules[i].setHorizontalAlignment(SwingConstants.LEFT);
            cellules[i].setBackground(Color.YELLOW);
                    
            grilleMatrice.add(cellules[i]);
        }

    }
    
    private void ajouterLigne() {
        
        if (nbLignes < 8){
            
            nbLignes = nbLignes + 1;
            
            grilleMatricePlus = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
            grilleMatricePlus.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            JTextField [] cellulesPlus = new JTextField[nbLignes * nbColonnes];
            for (int i = 0 ; i < ((nbLignes - 1) * nbColonnes) ; i++) {
                cellulesPlus[i] = new JTextField();
                cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesPlus[i].setText(df.format(Double.parseDouble(cellules[i].getText())));
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
            }
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatricePlus);
            
            grilleMatrice = grilleMatricePlus;
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesPlus[i];
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 lignes!");
        }
    }
    
    private void ajouterColonne(){  
          
        if (nbColonnes < 8){
            nbColonnes = nbColonnes + 1;
            
            grilleMatricePlus = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
            grilleMatricePlus.setBounds((zone1.getWidth()/2) - (nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
    
            JTextField [] cellulesPlus = new JTextField[nbLignes * nbColonnes];
            int k = 0;
            int s = 0;
            int temp = 0;
            DecimalFormat df = new DecimalFormat("0.0###");
            
            for(int i = 0; i < (nbLignes * nbColonnes) ; i++){
                            
                if ((k < (nbLignes * (nbColonnes - 1))) && (temp != ((nbColonnes * (s+1)) - 1) || temp == 0) ){
                    cellulesPlus[i] = new JTextField();
                    cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus[i].setText(df.format(Double.parseDouble(cellules[k].getText())));
                    cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus[i].setBackground(Color.YELLOW);
                    grilleMatricePlus.add(cellulesPlus[i]);
                    k = k + 1;
                    temp = temp + 1;
                } else {
                    cellulesPlus[i] = new JTextField();
                    cellulesPlus[i].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesPlus[i].setText("0.0");
                    cellulesPlus[i].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesPlus[i].setBackground(Color.YELLOW);
                    grilleMatricePlus.add(cellulesPlus[i]);
                    s = s + 1;
                    temp = temp + 1;
                }
          
            }
            
            grilleMatrice.setVisible(false);
            
            grilleMatrice = grilleMatricePlus;
            
            zone1.add(grilleMatricePlus);
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesPlus[i];
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice ne peut contenir plus de 8 colonnes!");
        }
    }
    
    private void supprimerLigne() {
        
        if (nbLignes > 1){
            
            nbLignes = nbLignes - 1;
            
            grilleMatriceMoins = new JPanel(new GridLayout(nbLignes, nbColonnes, 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- (nbColonnes * 48 / 2), 
            (zone1.getHeight()/3)- (nbLignes * 25 / 5), nbColonnes * 48, nbLignes * 25);
            DecimalFormat df = new DecimalFormat("0.0###");

            JTextField [] cellulesMoins = new JTextField[nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes) ; i++) {
                cellulesMoins[i] = new JTextField();
                cellulesMoins[i].setFont(new Font("Courier", Font.PLAIN, 12));
                cellulesMoins[i].setText(df.format(Double.parseDouble(cellules[i].getText())));
                cellulesMoins[i].setHorizontalAlignment(SwingConstants.LEFT);
                cellulesMoins[i].setBackground(Color.YELLOW);
                
                grilleMatriceMoins.add(cellulesMoins[i]);
            }
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
            }
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une ligne!");
        }
    }
    
    private void supprimerColonne(){
        
         if (nbColonnes > 1){
                       
            grilleMatriceMoins = new JPanel(new GridLayout(nbLignes, (nbColonnes - 1), 5, 6));  
            grilleMatriceMoins.setBounds( (zone1.getWidth()/2)- ((nbColonnes - 1) * 24), 
            (zone1.getHeight()/3)- (nbLignes * 5), (nbColonnes - 1) * 48, nbLignes * 25);
            zone1.add(grilleMatriceMoins);
            DecimalFormat df = new DecimalFormat("0.0###");

            JTextField [] cellulesMoins = new JTextField[nbLignes * (nbColonnes - 1)];
            int j = 0;
            int s = 0;
            
            for(int i = 0; j < (nbLignes * (nbColonnes - 1)) ; i++){
                            
                if ((i != (nbColonnes - 1) && s == 0) || (s != 0 && i != ((s+1) * nbColonnes - 1))){
                    
                    cellulesMoins[j] = new JTextField();
                    cellulesMoins[j].setFont(new Font("Courier", Font.PLAIN, 12));
                    cellulesMoins[j].setText(df.format(Double.parseDouble(cellules[i].getText())));
                    cellulesMoins[j].setHorizontalAlignment(SwingConstants.LEFT);
                    cellulesMoins[j].setBackground(Color.YELLOW);
                    grilleMatriceMoins.add(cellulesMoins[j]);
                    j = j + 1;
                } else {
                    s = s + 1;
                }
          
            }
            
            nbColonnes = nbColonnes - 1;
            
            grilleMatrice.setVisible(false);
            
            zone1.add(grilleMatriceMoins);
            
            grilleMatrice = grilleMatriceMoins;
            
            cellules = new JTextField [nbLignes * nbColonnes];
            for (int i = 0 ; i < (nbLignes * nbColonnes); i++) {
                cellules[i] = cellulesMoins[i];
            }     
        } else {
            JOptionPane.showMessageDialog(null, "La matrice doit contenir au moins une colonne!");
        }
    }
    
     
    
    public static void main (String [] args) {
       new TP3();
    }
   
}
