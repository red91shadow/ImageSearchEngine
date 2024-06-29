package org.ec.edu.uce.service;


import org.ec.edu.uce.model.*;

import java.util.List;
import java.util.stream.Collectors;


public class PhotoFilterService {
    public List<Photo> filterPhotosByCamera(List<Photo> photos, String camera) {
        return photos.stream()
                .filter(photo -> photo.getImg_src().contains(camera))
                .collect(Collectors.toList());
    }
}

