package MovieAndPlayData;

import Users.Admin;
import Users.Customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionFileManager {

    String Path = "D:\\JAVA\\";

    public static HashMap<String, Admin> myAdminsData = new HashMap<String, Admin>();
    public static HashMap<String, Customer> myCustomersData = new HashMap<String, Customer>();

    public static ArrayList<Movie> myMoviesData = new ArrayList<Movie>();
    

    public static Customer currCustomer;

    public static boolean loadAdminsData() {

        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream(new FileInputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\AdminsHashMap.bin"));
            myAdminsData = (HashMap<String, Admin>) Bin.readObject();
            Bin.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

    public static boolean loadCustomersData() {

        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream(new FileInputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\CustomersHashMap.bin"));
            myCustomersData = (HashMap<String, Customer>) Bin.readObject();
            Bin.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

    public static boolean loadMoviesData() {
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream(new FileInputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\MoviesArrayList.bin"));
            myMoviesData = (ArrayList<Movie>) Bin.readObject();
            Bin.close();
        } catch (IOException ex) {
            Logger.getLogger(ExceptionFileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExceptionFileManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return true;
        }
    

   /* public static boolean loadPlaysData() {
        ObjectInputStream Bin;
        try {
            Bin = new ObjectInputStream(new FileInputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\PlaysArrayList.bin"));
          //  myPlaysData = (ArrayList<Play>) Bin.readObject();
            Bin.close();
            System.out.println("Loaded");
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return false;
        }
    }*/

    public static boolean saveAdminsData() {
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\AdminsHashMap.bin"));
            Bout.writeObject(myAdminsData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean saveCustomerData() {
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\CustomersHashMap.bin"));
            Bout.writeObject(myCustomersData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean saveMoviesData() {
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\MoviesArrayList.bin"));
            Bout.writeObject(myMoviesData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
    }

   /* public static boolean savePlaysData() {
        ObjectOutputStream Bout;
        try {
            Bout = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DE\\Desktop\\UNI\\Fall2021\\OOP\\Cinema ProjectLOLL\\Cinema Project\\FILES\\\\PlaysArrayList.bin"));
            Bout.writeObject(myPlaysData);
            Bout.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }*/

}
