package MovieAndPlayData;

import Users.Admin;
import Users.AdminPanelMovieGUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminAddMovieGUI extends JFrame {

    JLabel lblAddMovie;
    JLabel lblMovieName;
    JLabel lblMovieLength;
    JLabel lblMovieLanguage;
    JLabel lblMovieGenre;
    JLabel lblMovieDesc;
    JLabel lblCategories;
    JLabel lblMoviePrice;
    JLabel lblMoviePrice2;
    JLabel lblMoviePrice3;

    JTextField txtfMovieName;
    JTextField txtfMovieLength;
    JTextField txtfMovieDesc;
    JTextField txtfMoviePrice;
    JTextField txtfMoviePrice2;
    JTextField txtfMoviePrice3;
    JTextField txtmoviecategory;

    JComboBox comboLang;
    JComboBox comboGenre;
    JComboBox comboCategories;

    JButton Save;

    JButton Back;

    Container cont;

    private final int LANGUAGES = 3;
    private final int GENRES = 7;
    private final int CATEGORIES = 3;

    public AdminAddMovieGUI() {

        setSize(630, 480);
        setTitle("Add Movie");

        lblAddMovie = new JLabel("Add Movie");
        lblMovieName = new JLabel("Enter Movie Name: ");
        lblMovieLength = new JLabel("Enter Movie Length: ");
        lblMovieLanguage = new JLabel("Enter Movie Language: ");
        lblMovieGenre = new JLabel("Enter Movie Genre: ");
        lblMovieDesc = new JLabel("Enter Movie Description: ");
        lblMoviePrice = new JLabel("Enter Movie Price Platinum: ");
        lblMoviePrice2 = new JLabel("Enter Movie Price Gold: ");
        lblMoviePrice3 = new JLabel("Enter Movie Price Silver: ");

        txtfMovieName = new JTextField(20);
        txtfMovieLength = new JTextField(20);
        txtfMovieDesc = new JTextField(20);
        txtfMoviePrice = new JTextField(20);
        txtfMoviePrice2 = new JTextField(20);
        txtfMoviePrice3 = new JTextField(20);
        //movie seat , movie seat size

        Save = new JButton("Save");

        Back = new JButton("Back");

        String[] Lang = {"Arabic", "English", "French"};

        comboLang = new JComboBox();
        for (int i = 0; i < LANGUAGES; i++) {
            comboLang.addItem(Lang[i]);
        }

        String[] Genre = {"Comedy", "Action", "Drama", "Horror", "Family", "Adventure", "SCI-FI"};

        comboGenre = new JComboBox();
        for (int i = 0; i < GENRES; i++) {
            comboGenre.addItem(Genre[i]);
        }

        cont = getContentPane();
        cont.setLayout(null);

        cont.add(lblAddMovie);
        lblAddMovie.setBounds(270, 20, 100, 25);
        //------------------------------------------------------
        cont.add(lblMovieName);
        lblMovieName.setBounds(150, 60, 150, 25);
        cont.add(txtfMovieName);
        txtfMovieName.addFocusListener(new movieTxtFocusListener());
        txtfMovieName.setBounds(300, 60, 100, 25);
        //
        cont.add(lblMovieLength);
        lblMovieLength.setBounds(150, 90, 150, 25);
        cont.add(txtfMovieLength);
        txtfMovieLength.addFocusListener(new movieTxtFocusListener());
        txtfMovieLength.setBounds(300, 90, 100, 25);
        //
        cont.add(lblMovieLanguage);
        lblMovieLanguage.setBounds(150, 120, 150, 25);
        //
        cont.add(comboLang);
        comboLang.setBounds(300, 120, 100, 25);
        //
        cont.add(lblMovieGenre);
        lblMovieGenre.setBounds(150, 150, 150, 25);
        //
        cont.add(comboGenre);
        comboGenre.setBounds(300, 150, 100, 25);
        //
        cont.add(lblMovieDesc);
        lblMovieDesc.setBounds(150, 180, 150, 25);
        cont.add(txtfMovieDesc);
        txtfMovieDesc.addFocusListener(new movieTxtFocusListener());
        txtfMovieDesc.setBounds(300, 180, 100, 25);
        //
        cont.add(txtfMoviePrice2);
        txtfMoviePrice2.setBounds(300, 240, 125, 25);
        txtfMoviePrice2.addFocusListener(new movieTxtFocusListener());
        //
        cont.add(lblMoviePrice);
        lblMoviePrice.setBounds(150, 210, 150, 25);
        //
        cont.add(txtfMoviePrice);
        txtfMoviePrice.setBounds(300, 210, 100, 25);
        txtfMoviePrice.addFocusListener(new movieTxtFocusListener());
        //
        cont.add(lblMoviePrice2);
        lblMoviePrice2.setBounds(150, 240, 100, 25);
        //
        cont.add(lblMoviePrice3);
        lblMoviePrice3.setBounds(150, 270, 100, 25);
        //
        cont.add(txtfMoviePrice3);
        txtfMoviePrice3.setBounds(300, 270, 100, 25);
        txtfMoviePrice.addFocusListener(new movieTxtFocusListener());
        //
        cont.add(Save);
        Save.setBounds(150, 310, 100, 25);
        Save.addActionListener(new movieWatcher());
        //
        cont.add(Back);
        Back.setBounds(150, 340, 100, 25);
        Back.addActionListener(new back());
    }

    public class movieTxtFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            javax.swing.border.Border myBorder = BorderFactory.createLineBorder(Color.RED, 1);
            if (e.getSource().equals(txtfMovieName)) {
                if (txtfMovieName.getText().equals("")) {
                    txtfMovieName.setBorder(myBorder);
                } else {
                    txtfMovieName.setBorder(null);
                }
            } else if (e.getSource().equals(txtfMovieLength)) {
                if (txtfMovieLength.getText().equals("")) {
                    txtfMovieLength.setBorder(myBorder);
                } else {
                    txtfMovieLength.setBorder(null);
                }
            } else if (e.getSource().equals(txtfMovieDesc)) {
                if (txtfMovieDesc.getText().equals("")) {
                    txtfMovieDesc.setBorder(myBorder);
                } else {
                    txtfMovieDesc.setBorder(null);
                }
            } else if (e.getSource().equals(txtfMoviePrice)) {
                if (txtfMoviePrice.getText().equals("")) {
                    txtfMoviePrice.setBorder(myBorder);
                } else {
                    txtfMoviePrice.setBorder(null);
                }
            }
            else if (e.getSource().equals(txtfMoviePrice2)) {
                if (txtfMoviePrice2.getText().equals("")) {
                    txtfMoviePrice2.setBorder(myBorder);
                } else {
                    txtfMoviePrice2.setBorder(null);
                }
            }
            else if (e.getSource().equals(txtfMoviePrice3)) {
                if (txtfMoviePrice3.getText().equals("")) {
                    txtfMoviePrice3.setBorder(myBorder);
                } else {
                    txtfMoviePrice3.setBorder(null);
                }
            }
        }
    }

    public class movieWatcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!txtfMovieDesc.getText().equals("") && !txtfMovieLength.getText().equals("") && !txtfMovieName.getText().equals("") && !txtfMoviePrice.getText().equals("")&& !txtfMoviePrice2.getText().equals("")&& !txtfMoviePrice3.getText().equals("")) {
                Movie myMovie = new Movie();
                 myMovie.setMovieName(txtfMovieName.getText());                  
                myMovie.setMovieLength(Double.parseDouble(txtfMovieLength.getText()));
                myMovie.setMovieLanguage(comboLang.getSelectedItem().toString());
                myMovie.setMovieGenre(comboGenre.getSelectedItem().toString());
                myMovie.setMovieDescription(txtfMovieDesc.getText());
                myMovie.setMoviePrice(Double.parseDouble(txtfMoviePrice.getText()));
                myMovie.setMoviePrice2(Double.parseDouble(txtfMoviePrice2.getText()));
                myMovie.setMoviePrice3(Double.parseDouble(txtfMoviePrice3.getText()));
                Admin myAdmin = new Admin();
                if (myAdmin.addMovieArray(myMovie)) {
                    JOptionPane.showMessageDialog(cont, "Movie Successfully Added!");
                } else {
                    JOptionPane.showMessageDialog(cont, "Error !!");
                }
            }
        }

    }

    public class back implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminPanelMovieGUI myGUI = new AdminPanelMovieGUI();
            dispose();
            myGUI.setVisible(true);
        }
    }
}
