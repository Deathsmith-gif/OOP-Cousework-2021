//This is the Driver class where the information about the driver is being stored. It is also an abstract class
public abstract class Driver {
    /** 
     * These are the Parameters taken into the Driver Object 
     * @param dName is the drivers 
     * @param location is the drivers country
     * @param teamName is the drivers team Name
    */
    private String dName;
    private String location;
    private String teamName;

    public abstract void details();

    //This is the constructor for Driver

    public Driver(String dName, String location, String teamName) {
        this.dName = dName;
        this.location = location;
        this.teamName = teamName;
    }
    //default constructor
    public Driver() {

    }

    /**
     * Used to set the drivers name
     * @param name used to set the driver name
     */

    public void setname(String name) {
        dName = name;
    }
    /**
     * Used to return the drivers name
     * @return the Drivers Name
     */


    public String getname() {
        return dName;
    }

    /**
     * Used to set the location of the Driver
     * @param place used to set the location
     */

    public void setlocation(String place) {
        location = place;
    }
    /**
     * Used to return the drivers location
     * @return The locatio of the driver
     */

    public String getlocation() {
        return location;
    }
    /**
     * Used to set the Team name
     * @param tName teamName
    */

    public void setteam(String tName) {
        teamName = tName;
    }

    /**
     * Used to return the team from the driver
     * @return the team name
    */

    public String getteam() {
        return teamName;
    }

    /** 
     * used to convert the dname from the Object
    */

    public String toString() {
        return " " +
                "Driver Name=" + dName;
    }

}
