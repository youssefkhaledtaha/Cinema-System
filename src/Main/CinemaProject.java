package Main;
import AddOns.GraphicalStats;
import MovieAndPlayData.Movie;
import Users.Admin;
import Users.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
import javax.swing.JFrame;
    
public class CinemaProject { 

    static Scanner Input = new Scanner(System.in);
    static Admin myAdmin = new Admin();
    static Customer myCustomer = new Customer();
    static Movie myMovie = new Movie();
    static int Choice = 0;
    static int Login = 0;
    static String CurrUserName = "";

       
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        GraphicalStats myGUI = new GraphicalStats();
      myGUI.setVisible(true);
      MainGUI MG = new MainGUI();
      MG.setVisible(true);
      MG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
    
    
}
 


