package org.ec.edu.uce.service;



import org.ec.edu.uce.model.*;
import java.util.List;
import java.util.stream.Collectors;



import org.ec.edu.uce.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoFilterService {
    public List<Photo> filterPhotosByCamera(List<Photo> photos, String camera) {
        return photos.stream()
                .filter(photo -> photo.getImgSrc().contains(camera))
                .collect(Collectors.toList());
    }
}

