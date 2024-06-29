package org.ec.edu.uce;

import org.ec.edu.uce.controller.*;
import org.ec.edu.uce.service.*;
import org.ec.edu.uce.model.*;
import org.ec.edu.uce.view.*;


public class Main {
    public static void main(String[] args) {
        NasaApiService nasaApiService = new NasaApiServiceImpl();
        PhotoFilterService photoFilterService = new PhotoFilterService();
        PhotoView photoView = new PhotoView();
        PhotoController photoController = new PhotoController(nasaApiService, photoFilterService, photoView);

        MainView mainView = new MainView(photoController);
        mainView.setVisible(true);
    }
}

