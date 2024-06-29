package org.ec.edu.uce.controller;

import org.ec.edu.uce.controller.*;
import org.ec.edu.uce.service.*;
import org.ec.edu.uce.model.*;
import org.ec.edu.uce.view.*;


import java.io.IOException;
import java.util.List;



import org.ec.edu.uce.model.*;
import org.ec.edu.uce.service.*;

import java.io.IOException;
import java.util.List;

public class PhotoController {

    private PhotoAPI photoAPI;

    public PhotoController(PhotoAPI photoAPI) {
        this.photoAPI = photoAPI;
    }

    public List<Photo> getPhotos(String sol) {
        try {
            return photoAPI.getPhotos(sol);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


