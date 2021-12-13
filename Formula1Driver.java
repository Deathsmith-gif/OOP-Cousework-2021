import java.util.Comparator;

public class Formula1Driver extends Driver {
 
    private int position;
    private int fPos;
    private int sPos;
    private int tPos;
    private int points;
    private int nRaces;

    public Formula1Driver(String dName, String location, String teamName, int fPos, int sPos, 
        int tPos,int points, int nRaces) {
        super(dName, location, teamName);
        this.fPos = fPos;
        this.sPos = sPos;
        this.tPos = tPos;
        this.points = points; 
        this.nRaces = nRaces;
    }
    
    public Formula1Driver(){
        super();
    }
    public void setfPos(int first){
        fPos=first;
    }
    public void setsPos(int second){
        sPos=second;
    }
    public void setTpos(int third){
        tPos=third;
    }

    public void setpoints(int score){
        points=score;
    }
    public void setpos(int pos){
        position=pos;
    }
    public void setnRaces(int nRaces) {
        this.nRaces = nRaces;
    }
    public int getfpos(){
        return fPos;
    }
    public int getspos(){
        return sPos;
    }
    public int gettpos(){
        return tPos;
    }
    public int getpoints(){
        return points;
    }
    public int getpos(){
        return position;
    }
    public int getnRaces() {
        return nRaces;
    }
    @Override
    public String toString() {
        return String.format("%20s %20s %23s %15s %15s %15s %15s %15s",
        getname(), getlocation(), getteam(),
        getfpos(), getspos(),gettpos(),
        getpoints(),getnRaces());
    }
    public static Comparator<Formula1Driver> Points = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int points1 = d1.getpoints();
            int points2 = d2.getpoints();
            return points2 - points1;
        }
    };
        

}

// points + pos + name + number of races+ locatuion team
