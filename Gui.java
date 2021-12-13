import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// import static Forumala1ChampionshipManager.raceDriver;

public class Gui extends JFrame {
        static Forumala1ChampionshipManager fcm = new Forumala1ChampionshipManager();
        public static void main(String[] args) {

                String[] columnNames = { "Driver Name", "Driver Team", "No. of 1st", "No. of 2nd", "No. of 3rd",
                                "Points", "No. of Races" };
                String[] columnNames2 = { "Date","Driver Name","Position"};
                Object[][] values = new Object[Forumala1ChampionshipManager.raceDriver.size()][7];
                for (int i = 0; i < values.length; i++) {
                        values[i][0] = Forumala1ChampionshipManager.raceDriver.get(i).getname();
                        values[i][1] = Forumala1ChampionshipManager.raceDriver.get(i).getteam();
                        values[i][2] = Forumala1ChampionshipManager.raceDriver.get(i).getfpos();
                        values[i][3] = Forumala1ChampionshipManager.raceDriver.get(i).getspos();
                        values[i][4] = Forumala1ChampionshipManager.raceDriver.get(i).gettpos();
                        values[i][5] = Forumala1ChampionshipManager.raceDriver.get(i).getpoints();
                        values[i][6] = Forumala1ChampionshipManager.raceDriver.get(i).getnRaces();
                }

                JTable table = new JTable(values, columnNames);
                JFrame frame = new JFrame("F1 Driver data");
                JPanel panel = new JPanel();
                JPanel randomPanel = new JPanel();
                frame.add(new JScrollPane(table));
                frame.setSize(1280, 720);
                frame.setVisible(true);
                table.setAutoCreateRowSorter(true);
                frame.setLayout(new GridLayout(1, 4));

                JButton randButton = new JButton("Generate random Positions");
                JButton raceButton = new JButton("Generate a random race");
                JButton dateButton = new JButton("Sort races with date");
                JButton driverSearch = new JButton("Search for a driver");
                randButton.setBounds(25, 100, 95, 30);
                raceButton.setBounds(25, 100, 95, 30);
                dateButton.setBounds(25, 100, 95, 30);
                panel.add(randButton);
                panel.add(raceButton);
                panel.add(dateButton);
                panel.add(driverSearch);
                frame.add(panel);
                randButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                fcm.randomrRace();
                                System.out.println("Working");
                                Object[][] G =fcm.StringRace();
                                JTable table = new JTable(values, columnNames);
                                JFrame frame = new JFrame("Random Table Values");
                                JPanel randomPanel = new JPanel();
                                frame.add(new JScrollPane(table));
                                frame.setSize(1280, 720);
                                frame.setVisible(true);
                                table.setAutoCreateRowSorter(true);
                                frame.add(panel);
                        }
                        
                });
                raceButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                System.out.println("Working");

                        }
                });
                dateButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                System.out.println("Working");

                        }
                });
                driverSearch.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                System.out.println("Working");

                        }
                });

        }

}