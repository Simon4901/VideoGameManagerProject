import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class GameMangagerUI extends JFrame {
    // UI Elements
    private JButton button1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton hinzufügenButton;
    private JLabel Nachricht;
    private JComboBox comboBox1;
    private JComboBox comboBox2;


    //For filling the list and Exceptionhandling
    private int step = 0;
    private String tempName;
    private int tempUSK;
    private String tempGenre;
    private int tempMetascore;
    private int tempSpieleranzahl;
    private double tempPreis;

    // Function for the Window and constructor
    public GameMangagerUI() {
        setTitle("GameMangager");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setResizable(false);
        setVisible(true);
        comboBox1.addItem("A - Z");
        textArea1.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // prints out the list in TextArea1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Kategorie = comboBox2.getSelectedItem().toString();
                String Filter = comboBox1.getSelectedItem().toString();
                if (Kategorie.equals("Name")) {
                    if (Filter.equals("A - Z")) {
                        Games.gameList.sort(Comparator.comparing((Games g) -> g.Name));
                    }
                    else if (Filter.equals("Z - A")) {
                        Games.gameList.sort(Comparator.comparing((Games g)-> g.Name).reversed());
                    }
                }
                else  if (Kategorie.equals("Genre")) {
                    if (Filter.equals("A - Z")) {
                        Games.gameList.sort(Comparator.comparing((Games g)-> g.Genre));
                    }
                    else if (Filter.equals("Z - A")) {
                        Games.gameList.sort(Comparator.comparing((Games g)-> g.Genre).reversed());
                    }
                }
                else if  (Kategorie.equals("Spieleranzahl")) {
                    if (Filter.equals("High-to-Low")) {
                        Games.gameList.sort(Comparator.comparingInt( g -> g.Spieleranzahl));
                    }
                    else if (Filter.equals("Low-to-High")) {
                        Games.gameList.sort(Comparator.comparingInt((Games g)-> g.Spieleranzahl).reversed());
                    }
                }
                else if (Kategorie.equals("Preis")) {
                    if (Filter.equals("High-to-Low")) {
                        Games.gameList.sort(Comparator.comparingDouble( g -> g.Preis));
                    }
                    else if (Filter.equals("Low-to-High")) {
                        Games.gameList.sort(Comparator.comparingDouble((Games g)-> g.Preis).reversed());
                    }
                }
                else if (Kategorie.equals("USK")){
                    if (Filter.equals("High-to-Low")) {
                        Games.gameList.sort(Comparator.comparingInt(g-> g.USK));
                    }
                    else if (Filter.equals("Low-to-High")) {
                        Games.gameList.sort(Comparator.comparingInt((Games g)-> g.USK).reversed());
                    }
                }
                else if (Kategorie.equals("Metascore")) {
                    if (Filter.equals("High-to-Low")) {
                        Games.gameList.sort(Comparator.comparingInt(g -> g.Metascore));
                    }
                    else if (Filter.equals("Low-to-High")) {
                        Games.gameList.sort(Comparator.comparingInt((Games g) -> g.Metascore).reversed());
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (Games o : Games.gameList) {
                    sb.append(o).append("\n");
                }
                textArea1.setText(sb.toString());
            }
        });

        // Button to add all elements to list step-by-step and exception handling
        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = textField1.getText().trim();

                    // Name
                    if (step == 0) {
                        if (input.isEmpty())
                            throw new IllegalArgumentException("Name darf nicht leer sein.");

                        tempName = input;
                        Nachricht.setText("USK eingeben (0, 6, 12, 16, 18):");
                        step = 1;
                        textField1.setText("");
                        return;
                    }

                    // USK
                    if (step == 1) {
                        int value;
                        try {
                            value = Integer.parseInt(input);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("USK muss eine Zahl sein.");
                        }

                        if (value != 0 && value != 6 && value != 12 && value != 16 && value != 18)
                            throw new IllegalArgumentException("USK muss 0, 6, 12, 16 oder 18 sein.");

                        tempUSK = value;
                        Nachricht.setText("Genre eingeben:");
                        step = 2;
                        textField1.setText("");
                        return;
                    }

                    // Genre
                    if (step == 2) {
                        if (input.isEmpty())
                            throw new IllegalArgumentException("Genre darf nicht leer sein.");

                        tempGenre = input;
                        Nachricht.setText("Metascore eingeben (0 - 100):");
                        step = 3;
                        textField1.setText("");
                        return;
                    }

                    // Metascore
                    if (step == 3) {
                        int value;
                        try {
                            value = Integer.parseInt(input);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Metascore muss eine Zahl sein.");
                        }

                        if (value < 0 || value > 100)
                            throw new IllegalArgumentException("Metascore muss zwischen 0 und 100 liegen.");

                        tempMetascore = value;
                        Nachricht.setText("Spieleranzahl eingeben:");
                        step = 4;
                        textField1.setText("");
                        return;
                    }

                    // Playercount
                    if (step == 4) {
                        int value;
                        try {
                            value = Integer.parseInt(input);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Spieleranzahl muss eine Zahl sein.");
                        }

                        if (value < 1)
                            throw new IllegalArgumentException("Spieleranzahl muss mindestens 1 sein.");

                        tempSpieleranzahl = value;
                        Nachricht.setText("Preis eingeben:");
                        step = 5;
                        textField1.setText("");
                        return;
                    }
                    // Preis
                    if (step == 5) {
                        try {
                            tempPreis = Double.parseDouble(input);

                            if (tempPreis < 0) {
                                throw new IllegalArgumentException("Preis darf nicht negativ sein.");
                            }

                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Preis muss eine ganze Zahl sein.");
                        }


                        // Saving
                        Games.add(tempName, tempUSK, tempGenre, tempMetascore, tempSpieleranzahl, tempPreis);


                        // Reset für nächstes Spiel
                        step = 0;
                        Nachricht.setText("Name eingeben:");
                        textField1.setText("");
                        textField1.setText("");
                    }


                    } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String auswahl = (String) comboBox2.getSelectedItem();
                comboBox1.removeAllItems();
                comboBox1.setEnabled(true);
                if ("Name".equals(auswahl) || "Genre".equals(auswahl)) {
                    comboBox1.addItem("A - Z");
                    comboBox1.addItem("Z - A");
                }
                else if ("USK".equals(auswahl) || "Metascore".equals(auswahl) || "Preis".equals(auswahl) || "Spieleranzahl".equals(auswahl)) {
                    comboBox1.addItem("High-to-Low");
                    comboBox1.addItem("Low-to-High");
                }
                else {
                    comboBox1.setEnabled(false);
                }

            }
        });
    } // <-- Konstruktor endet hier

    // main to start the project
    public static void main(String[] args) {
        GameMangagerUI gameMangagerUI = new GameMangagerUI();
        Games.initObjects();
    }
}
