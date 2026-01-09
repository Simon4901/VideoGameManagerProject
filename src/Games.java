import java.util.ArrayList;

public class Games {
    public static ArrayList<Games> gameList = new ArrayList<>();

    public String Name;

    public int USK;
//add comment 13454
    public String Genre;

    public double Metascore;

    public int Spieleranzahl;

    public boolean multiplayer;

    public Games(String Name, int USK, String Genre, double Metascore, int Spielerzahl, boolean Multiplayer) {
        this.Name = Name;
        this.USK = USK;
        this.Genre = Genre;
        this.Metascore = Metascore;
        this.Spieleranzahl = Spielerzahl;
        this.multiplayer = Multiplayer;
    }
    public static void initObjects(){
        gameList.add(new Games("test", 18, "Genre", 10, 4, true));
        gameList.add(new Games("Halo", 18, "Shooter", 8, 4, true));
        gameList.add(new Games("Assasins Creed 2", 16, "Adventure", 10, 1, false));
    }
    @Override
    public String toString() {
        return Name + USK + Genre + Metascore + Spieleranzahl + multiplayer;
    }

}
