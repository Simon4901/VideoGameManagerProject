public class Games {


    public String Name;

    public int USK;

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
    @Override
    public String toString() {
        return Name + USK + Genre + Metascore + Spieleranzahl + multiplayer;
    }

}
