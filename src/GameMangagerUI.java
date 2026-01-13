import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private double tempMetascore;
    private int tempSpieleranzahl;
    private boolean tempMultiplayer;
    private int tempPreis;

    // Function for the Window and konstructor
    public GameMangagerUI() {
        setTitle("GameMangager");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);

        // prints out the list in TextArea1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        double value;
                        try {
                            value = Double.parseDouble(input);
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
                        Nachricht.setText("Multiplayer? (ja / nein):");
                        step = 5;
                        textField1.setText("");
                        return;
                    }

                    // Multiplayer
                    if (step == 5) {
                        if (input.equalsIgnoreCase("ja")) {
                            tempMultiplayer = true;
                        } else if (input.equalsIgnoreCase("nein")) {
                            tempMultiplayer = false;
                        } else {
                            throw new IllegalArgumentException("Bitte 'ja' oder 'nein' eingeben.");
                        }

                        Nachricht.setText("Preis eingeben:");
                        step = 6;
                        textField1.setText("");
                        return;


                    }
                    // Preis
                    if (step == 6) {
                        try {
                            tempPreis = Integer.parseInt(input);

                            if (tempPreis < 0) {
                                throw new IllegalArgumentException("Preis darf nicht negativ sein.");
                            }

                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Preis muss eine ganze Zahl sein.");
                        }


                        // Saving
                        Games.add(tempName, tempUSK, tempGenre, tempMetascore, tempSpieleranzahl, tempMultiplayer, tempPreis);


                        // Reset für nächstes Spiel
                        step = 0;
                        Nachricht.setText("Name eingeben:");
                        textField1.setText("");
                    }


                    } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
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
