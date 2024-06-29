package org.ec.edu.uce;

import org.ec.edu.uce.controller.*;
import org.ec.edu.uce.service.*;
import org.ec.edu.uce.model.*;
import org.ec.edu.uce.view.ImageViewerView;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageViewerView view = new ImageViewerView();
            ImageViewerController controller = new ImageViewerController(view);
            view.setController(controller);
            view.setVisible(true);
        });
    }
}



