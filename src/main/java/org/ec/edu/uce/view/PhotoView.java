package org.ec.edu.uce.view;


import org.ec.edu.uce.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;



public class PhotoView extends JPanel {
    private List<Photo> photos;

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
        repaint();
    }

    public void displayPhotos(List<Photo> photos) {
        this.photos = photos;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (photos != null) {
            int x = 10;
            int y = 10;
            int imageWidth = 200;
            int imageHeight = 200;
            int padding = 10;

            for (Photo photo : photos) {
                try {
                    URL url = new URL(photo.getImgSrc());
                    BufferedImage image = ImageIO.read(url);
                    g.drawImage(image, x, y, imageWidth, imageHeight, this);
                    x += imageWidth + padding;
                    if (x > getWidth() - imageWidth) {
                        x = 10;
                        y += imageHeight + padding;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
