import java.util.ArrayList;

public class Games {
    //created a List for the Games
    public static ArrayList<Games> gameList = new ArrayList<>();
//Attributes for the list, but it can be expended
    public String Name;

    public int USK;

    public String Genre;

    public int Metascore;

    public int Spieleranzahl;

    public double Preis;
//Constructor
    public Games(String Name, int USK, String Genre, int Metascore, int Spielerzahl, double Preis) {
        this.Name = Name;
        this.USK = USK;
        this.Genre = Genre;
        this.Metascore = Metascore;
        this.Spieleranzahl = Spielerzahl;
        this.Preis = Preis;
    }
    //Creates 3 Objects and ads them to the List
    public static void initObjects(){
        gameList.add(new Games("test", 18, "Genre", 10, 4, 10.99));
        gameList.add(new Games("Halo", 18, "Shooter", 8, 4, 9.99 ));
        gameList.add(new Games("Assasins Creed 2", 16, "Adventure", 10, 1, 12.99));
    }
    //little Function to add something to the list, need more because it only fills the Name of the Game for now
    public static void add (String eingabe, int Usk, String Genre, int Metascore, int Spielerzahl, double Preis) {//add price
        gameList.add(new Games(eingabe, Usk, Genre, Metascore, Spielerzahl, Preis));
    }

    //DO NOT TOUCH, i dont know if we need it but maybe we do. it makes the whole list to a single String
    @Override
    public String toString() {
        return String.format("%-20s %-5d %-12s %-10d %-10d %-5.2f €", Name, USK, Genre, Metascore, Spieleranzahl, Preis);
    }




}
