import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Interface extends JFrame {

    // Storing information in file
    public File info;

    // Window constants - width and height
    private int WIDTH;
    private int HEIGHT;

    // Window elements - panels
    private JPanel main;
    private JPanel utilities;
    private JPanel additions;

    // Window elements - text fields
    private JTextField password;
    private JTextField login;
    private JTextField server;

    // Window elements - text area and scroll pane
    private JTextArea area;
    private JScrollPane scrollPane;

    // Window elements - buttons
    private final int button_width = 100;
    private final int button_height = 50;
    private JButton connect;
    private JButton clear;

    public Interface(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        info = new File("data");
    }

    public void openInterface(){
        // Setting the window size, window close operation, setting visibility
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Defining the panels
        main = new JPanel();
        utilities = new JPanel();

        // Defining the buttons
        connect = new JButton("Connect");
        connect.setSize(button_width, button_height);
        connect.addActionListener(new ConnectListener());
        clear = new JButton("Clear");
        clear.setSize(button_width, button_height);
        clear.addActionListener(new TextAreaListener());

        // Defining the text fields
        password = new JTextField(10); // the width length of the text field is 10 points
        password.setText("Input password...");

        login = new JTextField(10); // the width length of the text field is 10 points
        login.setText("Input username...");
        login.requestFocus();

        server = new JTextField(10);  // the width length of the text field is 10 points
        server.setText("Input server url");

        // Defining the text area
        area = new JTextArea(5, 12); // the width length of the text area is 12 points, height - 5 points
        scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Adding the elements into the main panel
        main.add(login, BorderLayout.CENTER);
        main.add(password, BorderLayout.CENTER);
        main.add(server, BorderLayout.CENTER);
        main.add(scrollPane, BorderLayout.SOUTH);
        main.add(clear, BorderLayout.SOUTH);

        // Adding the elements into the utility panel
        utilities.add(connect, BorderLayout.CENTER);

        // Adding the panels into the frame
        this.getContentPane().add(utilities, BorderLayout.SOUTH);
        this.getContentPane().add(main, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public String getLogin(){
        return login.getText();
    }

    public String getPassword(){
        return password.getText();
    }

    public String getServerUrl(){
        return server.getText();
    }

    private class TextAreaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            area.setText(" ");
        }
    }

    private class ConnectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                info.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(info.getName()));
                writer.write(getLogin() + "\n" + getPassword() + "\n" + getServerUrl());
                writer.close();
            } catch (IOException exception) {

            }
        }
    }
}
