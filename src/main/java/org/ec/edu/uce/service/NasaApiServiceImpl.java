package org.ec.edu.uce.service;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ec.edu.uce.model.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NasaApiServiceImpl implements NasaApiService {
    private static final String API_KEY = "DEMO_KEY"; // Reemplaza con tu clave API si la tienes
    private static final String BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";

    @Override
    public List<Photo> fetchPhotos(int sol, String camera) {
        List<Photo> photos = new ArrayList<>();
        String url = String.format("%s?sol=%d&camera=%s&api_key=%s", BASE_URL, sol, camera, API_KEY);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String json = EntityUtils.toString(response.getEntity());
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(json);
                JsonNode photosNode = rootNode.path("photos");

                if (photosNode.isArray()) {
                    for (JsonNode photoNode : photosNode) {
                        Photo photo = new Photo();
                        photo.setId(photoNode.path("id").asInt());
                        photo.setSol(photoNode.path("sol").asInt());
                        photo.setImgSrc(photoNode.path("img_src").asText());
                        photo.setEarthDate(photoNode.path("earth_date").asText());
                        photos.add(photo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return photos;
    }
}
