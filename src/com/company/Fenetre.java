package com.company;

import com.company.classes.Etudiant;
import com.company.dao.IDao;
import com.company.service.EtudiantService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenetre extends JFrame {
    private IDao<Etudiant> liste = new EtudiantService();
    private JPanel contentPane;
    private JTextField txtPre;
    private JTextField txtNom;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTable table;
    private DefaultTableModel model;
    private static int cpt;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenetre frame = new Fenetre();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Fenetre() {
        super("Gestionnaire étudiants");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 400);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(5, 5));


        JPanel panelDroit = new JPanel();
        contentPane.add(panelDroit, BorderLayout.EAST);
        panelDroit.setLayout(new GridLayout(3, 1, 5, 5));
        JButton btnAdd = new JButton("Ajouter");
        panelDroit.add(btnAdd);
        JButton btnDel = new JButton("Supprimer");
        panelDroit.add(btnDel);
        JButton btnMod = new JButton("Modifier");
        panelDroit.add(btnMod);


        JPanel panelCentre = new JPanel();
        contentPane.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setLayout(new GridLayout(2, 0, 5, 5));
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informations Etudiant", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelCentre.add(panelInfo);
        JLabel labelNom = new JLabel("Nom :");
        JLabel labelPrenom = new JLabel("Prenom :");
        JLabel labelSexe = new JLabel("Sexe :");
        JLabel labelFiliere = new JLabel("Filière :");
        txtPre = new JTextField();
        txtPre.setColumns(10);
        txtNom = new JTextField();
        txtNom.setColumns(10);
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Scientifique", "Economique et Sociale", "Littéraire"}));
        JRadioButton rdbtnFemme = new JRadioButton("F");
        rdbtnFemme.setSelected(true);
        buttonGroup.add(rdbtnFemme);
        JRadioButton rdbtnHomme = new JRadioButton("H");
        buttonGroup.add(rdbtnHomme);
        GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
        gl_panelInfo.setHorizontalGroup(
                gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelInfo.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addComponent(labelNom, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(23)
                                                .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(66)
                                                .addComponent(labelSexe, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6)
                                                .addComponent(rdbtnHomme, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2)
                                                .addComponent(rdbtnFemme, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addComponent(labelPrenom, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(txtPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(66)
                                                .addComponent(labelFiliere, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
        );
        gl_panelInfo.setVerticalGroup(
                gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelInfo.createSequentialGroup()
                                .addGap(23)
                                .addGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(labelNom))
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(labelSexe))
                                        .addComponent(rdbtnFemme)
                                        .addComponent(rdbtnHomme))
                                .addGap(18)
                                .addGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(labelPrenom))
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(txtPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panelInfo.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(labelFiliere))
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
        );
        panelInfo.setLayout(gl_panelInfo);
        JPanel panelListe = new JPanel();
        panelListe.setBorder(new TitledBorder(null, "Liste des Etudiants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelCentre.add(panelListe);
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "ID", "Nom", "Prenom", "Sexe", "Filière"
                }
        ));
        model = (DefaultTableModel) table.getModel();
        panelListe.setLayout(new BorderLayout(0, 0));
        scrollPane.setViewportView(table);
        panelListe.add(scrollPane);


        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char sexe;
                if(rdbtnHomme.isSelected()) {
                    sexe = 'H';
                }
                else {
                    sexe = 'F';
                }
                liste.create(new Etudiant(txtNom.getText(), txtPre.getText(), sexe,(String) comboBox.getSelectedItem()));
                model.insertRow(model.getRowCount(), new Object[] {liste.findById(cpt).getId(),
                        liste.findById(cpt).getNom(), liste.findById(cpt).getPrenom(),
                        liste.findById(cpt).getSexe(), liste.findById(cpt).getFiliere()});
                cpt ++;
                System.out.println(liste.findAll());
            }
        });
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liste.delete(liste.findById(table.getSelectedRow()));
                model.removeRow(table.getSelectedRow());
                System.out.println(liste.findAll());
            }
        });
        btnMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char sexe;
                if(rdbtnHomme.isSelected()) {
                    sexe = 'H';
                }
                else {
                    sexe = 'F';
                }
                liste.update(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)),
                        txtNom.getText(), txtPre.getText(), sexe, (String) comboBox.getSelectedItem());
                model.setValueAt(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getNom(), table.getSelectedRow(), 1);
                model.setValueAt(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getPrenom(), table.getSelectedRow(), 2);
                model.setValueAt(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getSexe(), table.getSelectedRow(), 3);
                model.setValueAt(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getFiliere(), table.getSelectedRow(), 4);
                System.out.println(liste.findAll());
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtNom.setText(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getNom());
                txtPre.setText(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getPrenom());
                if(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getSexe() == 'H') {
                    rdbtnHomme.setSelected(true);
                }
                else {
                    rdbtnFemme.setSelected(true);
                }
                comboBox.setSelectedItem(liste.findById((int) model.getValueAt(table.getSelectedRow(), 0)).getFiliere());
            }
        });
    }
}
