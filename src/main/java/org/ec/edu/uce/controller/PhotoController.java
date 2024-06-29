package org.ec.edu.uce.controller;

import org.ec.edu.uce.controller.*;
import org.ec.edu.uce.service.*;
import org.ec.edu.uce.model.*;
import org.ec.edu.uce.view.*;


import java.io.IOException;
import java.util.List;






public class PhotoController {
    private final NasaApiService nasaApiService;
    private final PhotoFilterService photoFilterService;
    private final PhotoView photoView;

    public PhotoController(NasaApiService nasaApiService, PhotoFilterService photoFilterService, PhotoView photoView) {
        this.nasaApiService = nasaApiService;
        this.photoFilterService = photoFilterService;
        this.photoView = photoView;
    }

    public void searchAndDisplayPhotos(int sol, String camera) {
        List<Photo> photos = nasaApiService.fetchPhotos(sol, camera);
        List<Photo> filteredPhotos = photoFilterService.filterPhotosByCamera(photos, camera);
        photoView.setPhotos(filteredPhotos);
        photoView.displayPhotos(filteredPhotos);
    }
}

