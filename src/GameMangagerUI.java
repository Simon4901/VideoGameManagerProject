import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class GameMangagerUI extends JFrame{
    //UI Elements

    private JButton button1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton hinzufügenButton;
    private JLabel Nachricht;

    //Function for the Window
    public GameMangagerUI() {
        setTitle("GameMangager");
        setSize(1500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        //Now the function just prints out the list in TextArea1 without Formation, needs to be done!
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    StringBuilder sb = new StringBuilder();
                    for (Games o : Games.gameList){
                        sb.append(o).append("\n");
                    }
                    textArea1.setText(sb.toString());
            }
        }); //function for taking the inputs and saving them to list not complete! Needs Exception handling
        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eingabe = textField1.getText();
                textField1.setText("");
                Nachricht.setText("Gebe nun die USK ein!");


            }
        });
    }
    //main to start the project and create the window. DO NOT TOUCH!!
    public static void main(String[] args) {
        GameMangagerUI gameMangagerUI = new GameMangagerUI();
        Games.initObjects();                //initialising 3 Objects which gets saved to the list on the button press. Still need to figure out where to set it
    }
}
