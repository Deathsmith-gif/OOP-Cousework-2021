import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.time.LocalDate;

public class Forumala1ChampionshipManager implements ChampionShipManager {
    private Scanner input = new Scanner(System.in);
    // raceDriver an array for FormulaDriver Object
    static ArrayList<Formula1Driver> raceDriver = new ArrayList<Formula1Driver>();
    // RandomDriverList is an array list for Race Object
    static ArrayList<Race> RandomDriverList = new ArrayList<Race>();
    // arrayTeam is a hashset to hold the team names to compare for uniqueness
    private HashSet<String> ArrayTeam = new HashSet<String>();
    private int points = 0;
    // details is an instance of Race
    private Race details = new Race();
    // Race data is a FIle to store the data
    File RaceData = new File("Race Data.txt");

    // This fucntion will create new objects of Forumula1Driver and input it into
    // the object and the arrayList
    // valid to valid3 used in validating the integer
    public void CreateDriver() {
        int fpos = 0;
        int spos = 0;
        int tpos = 0;
        String teamName = " ";
        int position = 0;
        int nRaces = 0;
        Boolean valid = false;
        Boolean valid2 = false;
        Boolean valid3 = false;
        System.out.println("Enter the drivers name please");
        String name = input.nextLine();
        System.out.println("Please enter the team name");
        teamName = input.nextLine().toLowerCase();
        // check if the arraylist is empthy before adding so it can omit the comparison
        if (ArrayTeam.isEmpty()) {
            ArrayTeam.add(teamName);
        } else {
            while (valid == false) {
                if (ArrayTeam.contains(teamName)) {
                    System.out.println("That team already exists Please enter a unique name");
                    System.out.println("These are the current teams");
                    System.out.println();
                    for (String j : ArrayTeam) {
                        System.out.println(j);
                    }
                    System.out.println("Please enter the team name");
                    teamName = input.nextLine().toLowerCase();
                } else {
                    valid = true;
                }
            }
        }
        ArrayTeam.add(teamName);
        System.out.println("Please enter the location of the racer");
        String location = input.nextLine();
        while (valid2 == false) {
            try {
                System.out.println("Please enter the number of races he has raced on");
                nRaces = Integer.parseInt(input.nextLine());
                valid2 = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        int counter = nRaces;
        while (valid3 == false) {
            try {
                while (counter > 0) {
                    System.out.println("Please enter his position in the race");
                    position = Integer.parseInt(input.nextLine());
                    if (position == 1) {
                        points = points + 25;
                        fpos = fpos + 1;
                    } else if (position == 2) {
                        points = points + 18;
                        spos = spos + 1;
                    } else if (position == 3) {
                        points = points + 15;
                        tpos = tpos + 1;
                    } else if (position == 4) {
                        points = points + 12;
                    } else if (position == 5) {
                        points = points + 10;
                    } else if (position == 6) {
                        points = points + 8;
                    } else if (position == 7) {
                        points = points + 6;
                    } else if (position == 8) {
                        points = points + 4;
                    } else if (position == 9) {
                        points = points + 2;
                    } else if (position == 10) {
                        points = points + 1;
                    }
                    counter--;
                }
                valid3 = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an Integer");
            }
        }
        // The data from the user is taken into variables and then inserting directly
        // into the Formula1Driver under RaceGuy instance
        Formula1Driver raceguy = new Formula1Driver(name, location, teamName, fpos, spos, tpos, points,
                nRaces);
        // object is addes into the arrayList
        raceDriver.add(raceguy);

    }

    // This fucntion removes the whole object out of the Formula1driver
    public void DeleteDriver() {
        String temp = " ";
        int temp2 = 0;
        Boolean valid = false;
        System.out.println("These are the current drivers");
        for (int i = 0; i < raceDriver.size(); i++) {
            System.out.print(i + " ");
            temp = raceDriver.get(i).getname();
            System.out.println(temp);
        }
        System.out.println("Whom do you want to delete?");
        while (valid == false) {
            try {
                temp2 = Integer.parseInt(input.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        raceDriver.remove(temp2);

    }

    // this Funtion changes the Driver's Team to somthing else
    public void ChangeDriver() {
        String temp = " ";
        String temp2 = " ";
        String temp3 = " ";
        int cNumber = 0;
        int nNumber = 0;
        System.out.println("These are the current drivers");
        for (int i = 0; i < raceDriver.size(); i++) {
            temp = raceDriver.get(i).getname();
            temp2 = raceDriver.get(i).getteam();
            System.out.println(i + " " + temp + " " + temp2);
        }
        System.out.println("Please input the Number of the team member you want to change team");
        cNumber = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the number of the team you want to put the Driver into");
        nNumber = Integer.parseInt(input.nextLine());
        // the index of the driver is taken
        for (int j = 0; j < raceDriver.size(); j++) {
            if (j == nNumber) {
                temp3 = raceDriver.get(j).getteam();
            }
        }
        // and swapped with the setter
        for (int k = 0; k < raceDriver.size(); k++) {
            if (k == cNumber) {
                raceDriver.get(k).setteam(temp3);
            }

        }
        // The teams are then printed
        System.out.println("Team changed Sucuessfully");
        for (int i = 0; i < raceDriver.size(); i++) {
            temp = raceDriver.get(i).getname();
            temp2 = raceDriver.get(i).getteam();
            System.out.println(i + " " + temp + " " + temp2);
        }
    }

    // This shows all the data obtained by the driver
    public void ShowStats() {
        String temp = " ";
        int dNumber = 0;
        Boolean valid = false;

        if ((raceDriver.isEmpty())) {
            System.out.println("There are no drivers in the system to display");

        } else {
            System.out.println("All the current Drivers");
            for (int i = 0; i < raceDriver.size(); i++) {
                temp = raceDriver.get(i).getname();
                System.out.println(i + " " + temp);
            }
            while (valid == false) {
                try {
                    // gets an index from the user to display
                    System.out.println("Which drivers Stats you want to see?");
                    dNumber = Integer.parseInt(input.nextLine());
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer");
                }
            }

            for (int j = 0; j < raceDriver.size(); j++) {
                if (j == dNumber) {
                    // All the data is outputted by that index
                    System.out.println("Driver Name : " + raceDriver.get(j).getname());
                    System.out.println("Driver is from : " + raceDriver.get(j).getlocation());
                    System.out.println("The Drivers Team : " + raceDriver.get(j).getteam());
                    System.out.println("The number the driver has got First place : " + raceDriver.get(j).getfpos());
                    System.out.println("The number the driver has got Second place : " + raceDriver.get(j).getspos());
                    System.out.println("The number the driver has got Third place : " + raceDriver.get(j).gettpos());
                    System.out.println(
                            "Numbe of points the driver as acculumated this season : " + raceDriver.get(j).getpoints());
                    System.out.println("The Number of races he has gone to : " + raceDriver.get(j).getnRaces());
                }
            }
        }

    }

    public void ShowTable() {
        // The points are sorted by the comparator defiend in Formula1Driver
        Collections.sort(raceDriver, Formula1Driver.Points);
        // the structure for the table
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%20s %20s %23s %15s %15s %15s %15s %15s", "|    Driver name     | ", "| Location  |",
                "|       Team   |",
                "| No. First  |", "| No. Second |", "| No. Third |", "| Total Points |", "| Total races |");
        System.out.println();
        // Printing the sorted data in a specific format defiend in Formula1Driver
        for (int j = 0; j < raceDriver.size(); j++) {
            System.out.println(raceDriver.get(j));
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // This fucntion sorts the Points
    @Override
    public void sort() {

        Collections.sort(raceDriver, Formula1Driver.Points);
        for (Formula1Driver str : raceDriver) {
            System.out.println(str);
        }
    }

    // Used to sort the dates in the Race class for the GUI
    public void sortForTable() {
        Collections.sort(raceDriver, Formula1Driver.Points);
    }

    // Add a race to the data
    public void AddRace() {
        Boolean valid3 = false;
        int userInput = 0;

        // A random Date is generated by a predefined fucntion (Line 587)
        String date = randomDate();
        System.out.println(date);
        System.out.println("These are the current data in the System ");
        for (int i = 0; i < raceDriver.size(); i++) {
            String temp = raceDriver.get(i).getname();
            System.out.println(i + " " + temp);
        }

        System.out.println(
                "Which driver do you want to update?(Enter the number in front of the driver OR enter -1 if you want to stop updating)");
        // details.setDriverName(raceDriver.get(position).getname());
        while (valid3 == false) {
            try {
                userInput = Integer.parseInt(input.nextLine());
                if (userInput == -1) {
                    valid3 = true;
                } else {
                    // Variables a to m are dummy varaibales to hold the data from the getters and
                    // incremnt the points
                    int position = 0;
                    for (Formula1Driver updateDriver : raceDriver) {
                        if (raceDriver.get(userInput).equals(updateDriver)) {
                            System.out.println("Please enter his position in the race");
                            position = Integer.parseInt(input.nextLine());
                            switch (position) {
                                case 1:
                                    int a = raceDriver.get(userInput).getpoints();
                                    a = a + 25;
                                    raceDriver.get(userInput).setpoints(a);
                                    int b = raceDriver.get(userInput).getfpos();
                                    b = b + 1;
                                    raceDriver.get(userInput).setfPos(b);
                                    break;
                                case 2:
                                    int c = raceDriver.get(userInput).getpoints();
                                    c = c + 18;
                                    raceDriver.get(userInput).setpoints(c);
                                    int d = raceDriver.get(userInput).getfpos();
                                    d = d + 1;
                                    raceDriver.get(userInput).setsPos(d);
                                    break;
                                case 3:
                                    int e = (raceDriver.get(userInput).getpoints());
                                    e = e + 18;
                                    raceDriver.get(userInput).setpoints(e);
                                    int f = raceDriver.get(userInput).gettpos();
                                    f = f + 1;
                                    raceDriver.get(userInput).setTpos(f);
                                    break;
                                case 4:
                                    int g = (raceDriver.get(userInput).getpoints());
                                    g = g + 12;
                                    raceDriver.get(userInput).setpoints(g);
                                    break;
                                case 5:
                                    int h = (raceDriver.get(userInput).getpoints());
                                    h = h + 10;
                                    raceDriver.get(userInput).setpoints(h);
                                    break;
                                case 6:
                                    int i = (raceDriver.get(userInput).getpoints());
                                    i = i + 8;
                                    raceDriver.get(userInput).setpoints(i);
                                    break;
                                case 7:
                                    int j = (raceDriver.get(userInput).getpoints());
                                    j = j + 18;
                                    raceDriver.get(userInput).setpoints(j);
                                    break;
                                case 8:
                                    int k = (raceDriver.get(userInput).getpoints());
                                    k = k + 8;
                                    raceDriver.get(userInput).setpoints(k);
                                    break;
                                case 9:
                                    int l = (raceDriver.get(userInput).getpoints());
                                    l = l + 18;
                                    raceDriver.get(userInput).setpoints(l);
                                    break;
                                case 10:
                                    int m = (raceDriver.get(userInput).getpoints());
                                    m = m + 18;
                                    raceDriver.get(userInput).setpoints(m);
                                    break;
                            }
                        }
                        // Race class is updated after the Case
                        details.setPosition(position);
                        details.setDriverName(raceDriver.get(userInput).getname());
                    }
                }

                // since date is common to all the races it will be updated directly
                details.setdate(date);
                System.out.println("Please enter the next driver index");

            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
    }

    public void Store() throws IOException {
        FileWriter writeFunc = new FileWriter("Race Data.txt");
        String temp = " ";
        // The data is stored with SPECIFIC SYMBOLS like !, @, so the data can be
        // accessed in the Load and printed to a File
        for (int i = 0; i < raceDriver.size(); i++) {
            temp = ((raceDriver.get(i).getname()) + "!" + (raceDriver.get(i).getlocation()) + "@"
                    + (raceDriver.get(i).getteam()) + "#" +
                    (raceDriver.get(i).getfpos()) + "$" + (raceDriver.get(i).getspos()) + "%"
                    + (raceDriver.get(i).gettpos()) + "^" + (raceDriver.get(i).getpoints()) + "&"
                    + (raceDriver.get(i).getnRaces()) + "*");

            writeFunc.write(temp + "\n");
        }
        writeFunc.close();
        System.out.println("Wrote it sucessfully :p");
    }

    public void LoadFile() throws FileNotFoundException {
        Scanner readFile = new Scanner(RaceData);
        String racerName = " ";
        String racerLocation = " ";
        String racerTeam = " ";
        int racerFpos = 0;
        int racerSpos = 0;
        int racerTpos = 0;
        int racerPoints = 0;
        int racerNRaace = 0;
        String temp = " ";
        int linepos1 = 0;
        int linepos2 = 0;
        int lineLength = 0;
        String date = " ";
        int pos = -1;
        // While the file has a next readable file it will loop though the file and
        // assign the specific Data into the variables
        while (readFile.hasNextLine()) {
            temp = readFile.nextLine();
            lineLength = temp.length();
            linepos2 = temp.indexOf("!");
            racerName = temp.substring(0, linepos2);
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("@");
            racerLocation = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("#");
            racerTeam = temp.substring(linepos1, linepos2);
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("$");
            racerFpos = Integer.parseInt(temp.substring(linepos1, linepos2));
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("%");
            racerSpos = Integer.parseInt(temp.substring(linepos1, linepos2));
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("^");
            racerTpos = Integer.parseInt(temp.substring(linepos1, linepos2));
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("&");
            racerPoints = Integer.parseInt(temp.substring(linepos1, linepos2));
            linepos1 = 0;
            linepos1 = linepos2 + 1;
            linepos2 = 0;
            linepos2 = temp.indexOf("*");
            racerNRaace = Integer.parseInt(temp.substring(linepos1, linepos2));
            // The varaibales are used to then add the object into a object
            Formula1Driver raceguy = new Formula1Driver(racerName, racerLocation, racerTeam, racerFpos, racerSpos,
                    racerTpos, racerPoints, racerNRaace);
            // Array list also updated
            ArrayTeam.add(racerTeam);
            // Updating the class Race
            Race upRace = new Race(date, racerName, pos);
            raceDriver.add(raceguy);
            RandomDriverList.add(upRace);

        }
        readFile.close();
        System.out.println("Files Sucessfully loaded");
        ArrayList<Integer> randomDriver = new ArrayList<Integer>();
        for (int i = 1; i < raceDriver.size(); i++) {
            randomDriver.add((i));
        }
        Collections.shuffle(randomDriver);

    }

    public void randomrPos() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String randomDriverName = " ";
        int randomDriverPos = 0;
        // Array list given values from 1 to 10
        for (int i = 1; i <= 10; i++) {
            arrayList.add((i));
        }
        // Shuffled so the values are random
        Collections.shuffle(arrayList);

        // for the size they are given radom values
        for (int i = 0; i < raceDriver.size(); i++) {
            int temp = arrayList.get(i);
            switch (temp) {
                case 1:
                    int a = raceDriver.get(i).getpoints();
                    a = a + 25;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 1;
                    raceDriver.get(i).setpoints(a);
                    int b = raceDriver.get(i).getfpos();
                    b = b + 1;
                    raceDriver.get(i).setfPos(b);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 2:
                    int c = raceDriver.get(i).getpoints();
                    c = c + 18;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 2;
                    raceDriver.get(i).setpoints(c);
                    int d = raceDriver.get(i).getspos();
                    d = d + 1;
                    raceDriver.get(i).setsPos(d);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 3:
                    int e = (raceDriver.get(i).getpoints());
                    e = e + 18;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 3;
                    raceDriver.get(i).setpoints(e);
                    int f = raceDriver.get(i).gettpos();
                    f = f + 1;
                    raceDriver.get(i).setTpos(f);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 4:
                    int g = (raceDriver.get(i).getpoints());
                    g = g + 12;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 4;
                    raceDriver.get(i).setpoints(g);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 5:
                    int h = (raceDriver.get(i).getpoints());
                    h = h + 10;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 5;
                    raceDriver.get(i).setpoints(h);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 6:
                    int l = (raceDriver.get(i).getpoints());
                    l = l + 8;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 6;
                    raceDriver.get(i).setpoints(l);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 7:
                    int j = (raceDriver.get(i).getpoints());
                    j = j + 18;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 7;
                    raceDriver.get(i).setpoints(j);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 8:
                    int k = (raceDriver.get(i).getpoints());
                    k = k + 8;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 8;
                    raceDriver.get(i).setpoints(k);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 9:
                    int v = (raceDriver.get(i).getpoints());
                    l = v + 18;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 9;
                    raceDriver.get(i).setpoints(v);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
                case 10:
                    int m = (raceDriver.get(i).getpoints());
                    m = m + 18;
                    randomDriverName = raceDriver.get(i).getname();
                    randomDriverPos = 10;
                    raceDriver.get(i).setpoints(m);
                    raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
                    break;
            }
            // Race class updated
            Race upRace = new Race();
            upRace = new Race(randomDate(), randomDriverName, randomDriverPos);
            RandomDriverList.add(upRace);
        }

    }

    // Fucntion used to return the values the drivers for the GUI
    public Object[][] StringRace() {

        Object[][] values2 = new Object[Forumala1ChampionshipManager.raceDriver.size()][3];
        for (int i = 0; i < values2.length; i++) {
            values2[i][0] = RandomDriverList.get(i).getDate();
            values2[i][1] = RandomDriverList.get(i).getDriverName();
            values2[i][2] = RandomDriverList.get(i).getPosition();
        }
        return (values2);
    }

    // Line 583 to 599 used to generate the random dates
    private int dateRange(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private LocalDate MakeRandomDate(int startYear, int endYear) {
        int day = dateRange(1, 28);
        int month = dateRange(1, 12);
        int year = dateRange(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    // To call the date in String Form
    public String randomDate() {
        LocalDate randomDate = MakeRandomDate(2000, 2020);
        String date = randomDate.toString();
        return date;

    }

    // Sorting the dates in decending Order
    public void sortDate() {
        Collections.sort(RandomDriverList, Race.dates);
    }

    public void randomRace() {
        //Arrays to use in the fucntion
        ArrayList<String> driverList = new ArrayList<String>();
        ArrayList<String> shuffle = new ArrayList<String>();
        ArrayList<Integer> newPos = new ArrayList<Integer>();
        //Filling arraylist Driverlist with the names
        for (int i = 0; i <= raceDriver.size(); i++) {
            driverList.add(raceDriver.get(i).getname());
        }
        //Shuffling the drivers
        Collections.shuffle(driverList);
        //adding the Same driver 40 times due to the probabilty
        for (int j = 0; j < 40; j++) {
            shuffle.add(driverList.get(0));
        }
        for (int j = 0; j < 30; j++) {
            shuffle.add(driverList.get(1));
        }
        for (int j = 0; j < 10; j++) {
            shuffle.add(driverList.get(2));
            shuffle.add(driverList.get(3));
        }
        for (int j = 0; j < 2; j++) {
            shuffle.add(driverList.get(4));
            shuffle.add(driverList.get(5));
            shuffle.add(driverList.get(6));
            shuffle.add(driverList.get(7));
            shuffle.add(driverList.get(8));
        }
        Collections.shuffle(shuffle);
        String winner = shuffle.get(0);
        int winnerIndex = 0;
        for (int i = 0; i <= raceDriver.size(); i++) {
            if (winner.equals(raceDriver.get(i).getname())) {
                winnerIndex = i;
                int a = raceDriver.get(i).getpoints();
                a = a + 25;
                raceDriver.get(i).setpoints(a);
                int b = raceDriver.get(i).getfpos();
                b = b + 1;
                raceDriver.get(i).setfPos(b);
                raceDriver.get(i).setnRaces((raceDriver.get(i).getnRaces()) + 1);
            }
        }
        for (int i = 2; i <= raceDriver.size(); i++) {
            newPos.add(i);
        }
        Collections.shuffle(newPos);
        int newLength = raceDriver.size();
        for (int k = 0; k < newLength-1; k++) {
            if (k != winnerIndex && newPos.get(k).equals(2)) {
                int c = raceDriver.get(k).getpoints();
                c = c + 18;
                raceDriver.get(k).setpoints(c);
                int d = raceDriver.get(k).getspos();
                d = d + 1;
                raceDriver.get(k).setsPos(d);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(3)) {
                int e = (raceDriver.get(k).getpoints());
                e = e + 15;
                raceDriver.get(k).setpoints(e);
                int f = raceDriver.get(k).gettpos();
                f = f + 1;
                raceDriver.get(k).setTpos(f);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
                break;
            } else if (k != winnerIndex && newPos.get(k).equals(4)) {
                int g = (raceDriver.get(k).getpoints());
                g = g + 12;
                raceDriver.get(k).setpoints(g);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(5)) {
                int h = (raceDriver.get(k).getpoints());
                h = h + 10;
                raceDriver.get(k).setpoints(h);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(6)) {
                int l = (raceDriver.get(k).getpoints());
                l = l + 8;
                raceDriver.get(k).setpoints(l);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(7)) {
                int l = (raceDriver.get(k).getpoints());
                l = l + 6;
                raceDriver.get(k).setpoints(l);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(8)) {
                int l = (raceDriver.get(k).getpoints());
                l = l + 4;
                raceDriver.get(k).setpoints(l);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(9)) {
                int l = (raceDriver.get(k).getpoints());
                l = l + 2;
                raceDriver.get(k).setpoints(l);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            } else if (k != winnerIndex && newPos.get(k).equals(10)) {
                int l = (raceDriver.get(k).getpoints());
                l = l + 1;
                raceDriver.get(k).setpoints(l);
                raceDriver.get(k).setnRaces((raceDriver.get(k).getnRaces()) + 1);
            }


        }

    }

}
