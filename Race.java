
import java.util.ArrayList;
import java.util.Comparator;

public class Race {
  // make racedate , list of driver , driver pos
  ArrayList<String> driverList = new ArrayList<String>();
  ArrayList<Integer> driverPos = new ArrayList<Integer>();
  private String rDate;
  private String driverName;
  private int rPosition;

  public Race (String rDate,  String driverName,int rPosition) {
    this.rDate = rDate;
    this.driverName = driverName;
    this.rPosition = rPosition;
  }
  public Race(){

  }
  public void setdate(String date) {
    rDate = date;
  }  
  public void setDriverName(String name) {
    driverName=name;
  }
  public String getDate(){
    return rDate;
  }
  public String getDriverName(){
    return driverName;
  }
  public void setPosition(int position) {
    rPosition = position;
  }
  public int getPosition() {
    return rPosition;
  }
  public static Comparator<Race> dates = new Comparator<Race>() {
    @Override
    public int compare(Race d1, Race d2) {
        String date1 = d1.getDate();
        String date2 = d2.getDate();
        return date2.compareTo(date1);
    }
};

}
