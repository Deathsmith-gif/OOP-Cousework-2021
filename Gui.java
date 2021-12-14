import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame {

        public Gui(Forumala1ChampionshipManager fcm) {
                // fcm is a instance of Forumala1ChampionshipManager

                String[] columnNames = { "Driver Name", "Driver Team", "No. of 1st", "No. of 2nd", "No. of 3rd",
                                "Points", "No. of Races" };
                String[] columnNames2 = { "Date", "Driver Name", "Position" };
                String[] columnNames3 = { "Driver Name", "Date", "Position" };
                String[] columnNames4 = { "Driver Name", "Date", "Position" };
                String[] columnNames5 = { "Driver Name", "Date", "Position" };
                fcm.sortForTable();
                GridLayout Layout = new GridLayout(10,20);
                /** 
                 * 4 table models for 4 tables, tableModel1 for the defualt  data from dricers
                 * tablemodel2 for Ranodm Positions
                 * tablemodel3 for sort the table with dates
                 * tablemodel4 for the probabilty races
                */

                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                DefaultTableModel tableModel2 = new DefaultTableModel(columnNames2, 0);
                DefaultTableModel tableModel3 = new DefaultTableModel(columnNames3, 0);
                DefaultTableModel tableModel4 = new DefaultTableModel(columnNames4, 0);
                DefaultTableModel tableModel5 = new DefaultTableModel(columnNames5, 0);


                JTable table = new JTable(tableModel);
                JTable table2 = new JTable(tableModel2);
                JTable table3 = new JTable(tableModel3);
                JTable table4 = new JTable(tableModel4);
                JTable table5 = new JTable(tableModel5);

                for (Formula1Driver i : Forumala1ChampionshipManager.raceDriver) {
                        Object[] driver = { i.getname(), i.getteam(), i.getfpos(), i.getspos(), i.gettpos(),
                                        i.getpoints(), i.getnRaces(), };
                        tableModel.addRow(driver);
                }
                JLabel tablename1 = new JLabel("The data");
                JLabel tablename2 = new JLabel("The Random Postions");
                JLabel tablename3 = new JLabel("Sorting with dates");
                JLabel tablename4 = new JLabel("Search Results");
                JLabel tablename5=new JLabel("Probailty RAce");

                add(tablename1);
                add(new JScrollPane(table));
                add(tablename2);
                add(new JScrollPane(table2));
                add(tablename3);
                add(new JScrollPane(table5));
                add(tablename4);
                add(new JScrollPane(table4));
                add(tablename5);
                add(new JScrollPane(table3));
                

                setLayout(Layout);
                // four buttons for the functionaltiy 
                JButton randButton = new JButton("Generate random Positions");
                JButton raceButton = new JButton("Generate a random race");
                JButton dateButton = new JButton("Sort races with date");
                JButton driverSearch = new JButton("Search for a driver");
                Dimension size = new Dimension(100, 50);
                randButton.setMaximumSize(size);
                JTextField Search = new JTextField();
                Search.setText("Enter what you seek here");
                add(randButton);
                add(raceButton);
                add(dateButton);
                add(Search);
                add(driverSearch);

                /** 
                 * This fucntion is to add the sorting funtions into the Points and the numbe of first pos
                */

                TableRowSorter<TableModel> s = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(s);
                java.util.List<RowSorter.SortKey> sortList = new ArrayList<>(5);
                sortList.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
                sortList.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
                s.setSortKeys(sortList);


                /**  
                 * Use to generate a random Race on the click of the buton randButton
                */
                randButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                                //fcm.randomos taken from the FormulaChapionship manager
                                fcm.randomrPos();
                                //Emptying the table
                                tableModel.setRowCount(0);
                                // updating table
                                for (Formula1Driver i : Forumala1ChampionshipManager.raceDriver) {
                                        Object[] driver = { i.getname(), i.getteam(), i.getfpos(), i.getspos(),
                                                        i.gettpos(), i.getpoints(), i.getnRaces(), };
                                        tableModel.addRow(driver);
                                }
                                //Used to ignore the pre-existing data where the syntax is -1
                                for (Race j : Forumala1ChampionshipManager.RandomDriverList) {
                                        if (j.getPosition() == -1) {
                                                continue;
                                        }
                                        Object[] driver = { j.getDate(), j.getDriverName(), j.getPosition() };
                                        tableModel2.addRow(driver);
                                }

                        }

                });
                //Function to work with the random probabilty race
                raceButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                               fcm.randomRace();
                               for (Race j : Forumala1ChampionshipManager.RandomDriverList) {
                                if (j.getPosition() == -1) {
                                        continue;
                                }
                                Object[] driver = { j.getDate(), j.getDriverName(), j.getPosition() };
                                tableModel2.addRow(driver);
                        }
                        }
                });
                //funtions to sort with the date
                dateButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                fcm.sortDate();
                                for (Race j : Forumala1ChampionshipManager.RandomDriverList) {
                                        if ((j.getPosition() != -1)) {
                                                Object[] driver = { j.getDriverName(), j.getDate(),
                                                                j.getPosition() };
                                                tableModel5.addRow(driver);
                                        }
                                }
                        }
                });
                //funciton to search with the search
                driverSearch.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String t = Search.getText();
                                for (Formula1Driver i : Forumala1ChampionshipManager.raceDriver) {
                                        if (t.equalsIgnoreCase(i.getname())) {
                                                for (Race j : Forumala1ChampionshipManager.RandomDriverList) {
                                                        if (t.equalsIgnoreCase(j.getDriverName()) && (j.getPosition() != -1)) {
                                                                Object[] driver = { j.getDriverName(), j.getDate(),j.getPosition() };
                                                                tableModel4.addRow(driver);
                                                        }
                                                }

                                        }
                                }

                        }
                });

        }

}