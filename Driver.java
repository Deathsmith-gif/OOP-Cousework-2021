
abstract class Driver {
    private String dName;
    private String location;
    private String teamName;

    // public abstract void details();

    public Driver(String dName, String location, String teamName) {
        this.dName = dName;
        this.location = location;
        this.teamName = teamName;
    }

    public Driver() {

    }

    public void setname(String name) {
        dName = name;
    }

    public String getname() {
        return dName;
    }

    public void setlocation(String place) {
        location = place;
    }

    public String getlocation() {
        return location;
    }

    public void setteam(String tName) {
        teamName = tName;
    }

    public String getteam() {
        return teamName;
    }

    public String toString() {
        return " " +
                "Driver Name=" + dName;
    }

}
