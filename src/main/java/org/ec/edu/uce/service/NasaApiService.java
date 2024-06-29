package org.ec.edu.uce.service;


import org.ec.edu.uce.model.Photo;


import java.util.List;




import java.util.List;

public interface NasaApiService {
    List<Photo> fetchPhotos(int sol, String camera);
}

