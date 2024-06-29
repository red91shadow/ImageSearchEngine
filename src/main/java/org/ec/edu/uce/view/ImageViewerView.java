package org.ec.edu.uce.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import org.ec.edu.uce.controller.*;
public class ImageViewerView extends JFrame {
    private final JTextField roverNameField;
    private final JTextField solField;
    private final JTextField cameraNameField;
    private final JButton loadButton;
    private final JPanel imagePanel;
    private ImageViewerController controller;

    public ImageViewerView() {
        setTitle("NASA Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        roverNameField = new JTextField(10);
        solField = new JTextField(5);
        cameraNameField = new JTextField(5);
        loadButton = new JButton("Load Images");

        inputPanel.add(new JLabel("Rover Name:"));
        inputPanel.add(roverNameField);
        inputPanel.add(new JLabel("Sol:"));
        inputPanel.add(solField);
        inputPanel.add(new JLabel("Camera:"));
        inputPanel.add(cameraNameField);
        inputPanel.add(loadButton);

        add(inputPanel, BorderLayout.NORTH);

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 3, 10, 10));
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        add(scrollPane, BorderLayout.CENTER);

        loadButton.addActionListener(e -> {
            String roverName = roverNameField.getText();
            int sol = Integer.parseInt(solField.getText());
            String cameraName = cameraNameField.getText();
            controller.loadImages(roverName, sol, cameraName);
        });
    }

    public void setController(ImageViewerController controller) {
        this.controller = controller;
    }

    public void displayImages(List<String> images) {
        imagePanel.removeAll();
        for (String imgSrc : images) {
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(new ImageIcon(imgSrc).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
            imagePanel.add(label);
        }
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
