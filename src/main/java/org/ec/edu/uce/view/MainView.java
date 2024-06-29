package org.ec.edu.uce.view;


import org.ec.edu.uce.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private final PhotoController photoController;

    public MainView(PhotoController photoController) {
        this.photoController = photoController;
        setTitle("NASA Photo Search");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel solLabel = new JLabel("Sol:");
        JTextField solTextField = new JTextField(10);
        JLabel cameraLabel = new JLabel("Camera:");
        JTextField cameraTextField = new JTextField(10);
        JButton searchButton = new JButton("Search");

        inputPanel.add(solLabel);
        inputPanel.add(solTextField);
        inputPanel.add(cameraLabel);
        inputPanel.add(cameraTextField);
        inputPanel.add(searchButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        PhotoView photoView = new PhotoView();
        mainPanel.add(new JScrollPane(photoView), BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sol = Integer.parseInt(solTextField.getText());
                String camera = cameraTextField.getText();
                photoController.searchAndDisplayPhotos(sol, camera);
            }
        });

        add(mainPanel);
    }
}
