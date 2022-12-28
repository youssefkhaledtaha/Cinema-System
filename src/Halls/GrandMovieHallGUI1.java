package Halls;

import AddOns.CantineGUI;
import AddOns.ParkingGUI;
import MovieAndPlayData.ExceptionFileManager;
import MovieAndPlayData.Movie;
import Payment.InoviceGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class GrandMovieHallGUI1 extends JFrame {

    public ArrayList<Seat> mySeats;
    public Movie myMovie;
    public final int CHAIRS = 100;
    int ChairID;
    JButton Confirm;
    Seat selectedSeat;

    public GrandMovieHallGUI1(Movie myMovie) {

        this.myMovie = myMovie;
        this.mySeats = this.myMovie.mySeatsArrayList;

        setSize(1200, 650);
        setTitle("Grand Movie Gold");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        loadGui();

    }

    public void loadGui() {
        JPanel firstpanel = new JPanel();

        selectedSeat = new Seat(-1);

        for (int j = 0; j < CHAIRS; j++) {
            if (mySeats.get(j).isTaken) {
                if (mySeats.get(j).getTakenBy().equals(ExceptionFileManager.currCustomer.getUserName())) {
                    mySeats.get(j).getButton().setBackground(Color.cyan);
                    //selectedSeat = mySeats.get(j);
                } else {
                    mySeats.get(j).getButton().setBackground(Color.red);
                }
            } else {
                mySeats.get(j).getButton().setBackground(Color.green);
            }
            firstpanel.add(mySeats.get(j).getButton());
            mySeats.get(j).getButton().addActionListener(new SeatListen(mySeats.get(j)));

        }

        firstpanel.setBackground(Color.lightGray);

        JPanel secondpanel = new JPanel();
        secondpanel.add(new JLabel("SCREEN"));

        JPanel thirdpanel = new JPanel();
        Confirm = new JButton("Confirm Place");
        thirdpanel.add(Confirm);
        Confirm.addActionListener(new ActionListen());

        getContentPane().add((firstpanel), BorderLayout.CENTER);
        getContentPane().add((secondpanel), BorderLayout.NORTH);
        getContentPane().add((thirdpanel), BorderLayout.SOUTH);

        setVisible(false);
        setVisible(true);
    }

    public class ActionListen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (selectedSeat.getSeatNumber() != -1) {

                int Choice = JOptionPane.showConfirmDialog(null, " Are you Sure You Want this Place", "Confimration", JOptionPane.YES_NO_OPTION);

                if (Choice == 0) {

                    for (Movie i : ExceptionFileManager.myMoviesData) {
                        if (i.equals(myMovie)) {
                            i.mySeatsArrayList.get(selectedSeat.getSeatNumber() - 1).isTaken = true;
                            i.mySeatsArrayList.get(selectedSeat.getSeatNumber() - 1).setTakenBy(ExceptionFileManager.currCustomer.getUserName());
                            ExceptionFileManager.currCustomer.setMyRMovie(i);
                            ExceptionFileManager.currCustomer.setMovieSeatNo(selectedSeat.getSeatNumber());
                            ExceptionFileManager.currCustomer.movieCash = i.getMoviePrice();
                            ExceptionFileManager.currCustomer.totalCash += i.getMoviePrice();
                        }
                    }
                    ExceptionFileManager.saveMoviesData();

                    String currChoice = "Movie";

                    int Choice1 = JOptionPane.showConfirmDialog(null, "Do You Want A Parking Slot", "Parking", JOptionPane.YES_NO_OPTION);

                    if (Choice1 == 0) {

                        ParkingGUI myGUI = new ParkingGUI(currChoice);
                        myGUI.setVisible(true);
                        dispose();

                    } else if (Choice1 == 1) {

                        int Choice2 = JOptionPane.showConfirmDialog(null, "Do You Want Items From Cantine ", "Cantine Prompt", JOptionPane.YES_NO_OPTION);
                        if (Choice2 == 0) {

                            CantineGUI myGUI = new CantineGUI(currChoice);
                            myGUI.setVisible(true);
                            dispose();
                        } else if (Choice2 == 1) {
                            InoviceGUI myGUI = new InoviceGUI(currChoice);
                            myGUI.setVisible(true);
                            dispose();

                        }
                    }
                }
            }
        }
    }

    public class SeatListen implements ActionListener {

        Seat mySelectedSeat;

        public SeatListen(Seat mySelectedSeat) {
            this.mySelectedSeat = mySelectedSeat;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!mySelectedSeat.isTaken) {// || selectedSeat.getTakenBy().equals(ExceptionFileManager.currCustomer.getUserName())){
                selectedSeat.getButton().setBackground(Color.GREEN);
                selectedSeat = mySelectedSeat;
                selectedSeat.getButton().setBackground(Color.YELLOW);
            }
        }

    }
}
