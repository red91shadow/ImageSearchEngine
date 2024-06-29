package org.ec.edu.uce.controller;

import java.util.List;


import org.ec.edu.uce.view.*;
import org.ec.edu.uce.model.*;
public class ImageViewerController {
    private final ImageViewerView view;
    private final NASAImageService service;

    public ImageViewerController(ImageViewerView view) {
        this.view = view;
        this.service = new NASAImageService();
    }

    public void loadImages(String roverName, int sol, String cameraName) {
        try {
            List<String> images = service.getImages(roverName, sol, cameraName);
            view.displayImages(images);
        } catch (Exception e) {
            e.printStackTrace();
            view.showError("Error loading images: " + e.getMessage());
        }
    }
}
