import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<Games> gameList = new ArrayList<>();
        gameList.add(new Games("test", 18, "Genre", 10, 4, true));
        System.out.println(gameList);

        //Games a = new Games("Test", 18, "spiel", 10, 4, false);
        //System.out.println(a.Name);
        //Scanner input = new Scanner(System.in);
        //System.out.println("Welcome to the Game Manager, type a game");
        //void string eingabe(){
        //Scanner input = new Scanner(System.in);
        //System.out.println("Welcome to the Game Manager, type a game");
        //String Name = input.nextLine();
        //int USK = input.nextInt();
        //String Genre = input.nextLine();
        //int Metascore = input.nextInt();
        //int Player = input.nextInt();
        //boolean multiplayer = input.nextBoolean();
        //Games c = new Games(Name, USK, Genre, Metascore, Player, multiplayer);
        //System.out.println(c.Name + c.Genre + c.Metascore + c.USK + c.Spieleranzahl + c.multiplayer);

    }
}