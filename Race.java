
import java.util.Comparator;

public class Race {
  /**
   * To hold race data
   */
  private String rDate;
  private String driverName;
  private int rPosition;

  /**
   * Constructor
   * @param rDate Race date
   * @param driverName Driver Name
   * @param rPosition Race position
   */

  public Race (String rDate,  String driverName,int rPosition) {
    this.rDate = rDate;
    this.driverName = driverName;
    this.rPosition = rPosition;
  }
  public Race(){

  }
  /**
   * Set the date
   * @param date 
   */
  public void setdate(String date) {
    rDate = date;
  }
  /**
   * Set the Driver Name in RACE class
   * @param name
   */  
  public void setDriverName(String name) {
    driverName=name;
  }
  /**
   * Get the Date
   * @return rDate The date of the race
   */
  public String getDate(){
    return rDate;
  }
  /**
   * Return the Dricvre Name
   * @return Drivers Name
   */
  public String getDriverName(){
    return driverName;
  }
  /**
   * Sets the drivers position
   * @param position
   */
  public void setPosition(int position) {
    rPosition = position;
  }
  /**
   * returns the drivers position
   * @return rPosition
   */
  public int getPosition() {
    return rPosition;
  }
  /** 
   * This fucntion is used to sort the dates for the GUI button fucntion
  */
  public static Comparator<Race> dates = new Comparator<Race>() {
    @Override
    public int compare(Race d1, Race d2) {
        String date1 = d1.getDate();
        String date2 = d2.getDate();
        return date2.compareTo(date1);
    }
};

}
