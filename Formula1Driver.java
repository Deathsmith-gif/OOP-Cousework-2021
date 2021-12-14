import java.util.Comparator;
//Java comparator Imported to compare some values

public class Formula1Driver extends Driver {
//FormularDriver extends to Driver as it inherits the data from the Driver
    private int position;
    private int fPos;
    private int sPos;
    private int tPos;
    private int points;
    private int nRaces;
    /**
     * construcor 
     * 
     * @param dName Drivers Name
     * @param location Drivers Location
     * @param teamName Driver Team Name
     * @param fPos Number of First Positions
     * @param sPos Number of Second Positions
     * @param tPos Number of Third Positions
     * @param points TOtal points by the driver
     * @param nRaces Number of races Driver has raced on
     */

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
    /**
     * Used to set the Number of First second and third
     * @param first= FirstPositions
     * @param second= SecondtPositions
     * @param tpos= ThirdPositions
     */
    public void setfPos(int first){
        fPos=first;
    }
    public void setsPos(int second){
        sPos=second;
    }
    public void setTpos(int third){
        tPos=third;
    }
    /**
     * Set the total points , Drivers positon and the number of races
     * @param score points
     * @param pos Position
     * @param nRaces Number of races
     */
    public void setpoints(int score){
        points=score;
    }
    public void setpos(int pos){
        position=pos;
    }
    public void setnRaces(int nRaces) {
        this.nRaces = nRaces;
    }

    /**
     * return the fristPosition. second,third,points,Position,Number of races
     */
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
    /**
     * This Fucntion is used to output the details inside the object in a specific format for the table Fucntion.
     */
    @Override
    public String toString() {
        return String.format("%20s %20s %23s %15s %15s %15s %15s %15s",
        getname(), getlocation(), getteam(),
        getfpos(), getspos(),gettpos(),
        getpoints(),getnRaces());
    }
    /** 
     * Compare the points in the fucntion 
     * @return in the decending order
    */
    public static Comparator<Formula1Driver> Points = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int points1 = d1.getpoints();
            int points2 = d2.getpoints();
            return points2 - points1;
        }
    };

    @Override
    public void details() {
        // TODO Auto-generated method stub
        
    }
        

}

// points + pos + name + number of races+ locatuion team
