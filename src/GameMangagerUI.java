import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class GameMangagerUI extends JFrame{
    //UI Elements
    private JPanel panel;
    private JButton button1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JPanel mainPanel;

    //Function for the Window
    public GameMangagerUI() {
        setTitle("GameMangager");
        setSize(1500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        //button, which adds the input to the list but doesnt safe it for now!!
        //and it prints out the list in the Text Area but there is nor right formation yet
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Games.initObjects();                //initialising 3 Objects which gets saved to the list on the button press. Still need to figure out where to set it
                    StringBuilder sb = new StringBuilder();
                    String eingabe = textField1.getText();
                    Games.add(eingabe);
                    for (Games o : Games.gameList){
                        sb.append(o).append("\n");
                    }
                    textArea1.setText(sb.toString());
            }
        });
    }
    //main to start the project and create the window. DO NOT TOUCH!!
    public static void main(String[] args) {
        GameMangagerUI gameMangagerUI = new GameMangagerUI();
    }
}
