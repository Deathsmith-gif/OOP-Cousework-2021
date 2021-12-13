
import java.util.ArrayList;

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

}
