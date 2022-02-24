import javax.swing.*;
import java.awt.*;

public class View {
    JFrame frame;
    JPanel pan1, pan2;
    JButton btnQuitter;
    JButton btnAjouter;
    JButton btnDroite;
    JButton btnGauche;
    JTextField txfAjout;
    JComboBox<String> cmbEndroit;
    JList<String> list1;
    JList<String> list2;
    DefaultListModel<String> model1;
    DefaultListModel<String> model2;
    String[] tabEndroits = {"Début", "Milieu", "Fin"};
    String[] tabFruits = {"Ananas", "Melon", "Cantaloupe", "Pomme", "Banane",
    "Raisin", "Mangue", "Pamplemousse", "Melon", "Clémentine"};


    public View(){
        frame = new JFrame("C1 Atelier5 - JList");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(330,400));
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);

        pan1 = new JPanel();
        pan1.setLayout(new FlowLayout());

        pan2 = new JPanel();
        pan2.setLayout(new FlowLayout(FlowLayout.CENTER));

        model1 = new DefaultListModel<>();
        for (String elem: tabFruits)
            model1.addElement(elem);

        list1 = new JList<>(model1);
        list1.setFixedCellWidth(100);

        model2 = new DefaultListModel<>();

        list2 = new JList<>(model2);
        list2.setFixedCellWidth(100);

        txfAjout = new JTextField();
        txfAjout.setPreferredSize(new Dimension(100,30));

        cmbEndroit = new JComboBox<>(tabEndroits);
        cmbEndroit.setSelectedItem("Fin");

        btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(e -> btnQuitterAction());

        btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> btnAjouterAction());
        
        btnDroite = new JButton(">>");
        btnDroite.addActionListener(e -> btnDroiteAction());
        
        btnGauche = new JButton("<<");
        btnGauche.addActionListener(e -> btnGaucheAction());

        pan1.add(txfAjout);
        pan1.add(cmbEndroit);
        pan1.add(btnAjouter);

        pan2.add(btnDroite);
        pan2.add(btnGauche);

        frame.add(pan1,BorderLayout.NORTH);
        frame.add(new JScrollPane(list1),BorderLayout.WEST);
        frame.add(new JScrollPane(list2),BorderLayout.EAST);
        frame.add(pan2,BorderLayout.CENTER);
        frame.add(btnQuitter,BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    private void btnGaucheAction() {
        if (model2.getSize() != 0)
            for (int i=0; i<model2.getSize();i ++)
                model1.add(i,model2.getElementAt(i));
    }

    private void btnDroiteAction() {
        if (model1.getSize() != 0)
            for (int i=0; i<model1.getSize(); i++)
                model2.add(i,model1.getElementAt(i));
    }

    private void btnAjouterAction() {
        if (!txfAjout.getText().equals("")){
            if (cmbEndroit.getSelectedIndex() == 0)
                model1.add(0,txfAjout.getText());
            else if (cmbEndroit.getSelectedIndex() == 1)
                model1.add((model1.getSize()/2),txfAjout.getText());
            else if (cmbEndroit.getSelectedIndex() == 2)
                model1.add(model1.getSize(),txfAjout.getText());
        }

    }

    private void btnQuitterAction() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
