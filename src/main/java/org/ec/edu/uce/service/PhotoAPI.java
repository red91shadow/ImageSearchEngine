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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PhotoAPI {

    private static final String API_KEY = "DEMO_KEY"; // Reemplazar con tu API Key
    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";

    public List<Photo> getPhotos(String sol) throws IOException {
        URL url = new URL(API_URL + "?sol=" + sol + "&api_key=" + API_KEY);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }

        Scanner scanner = new Scanner(url.openStream());
        String inline = "";
        while (scanner.hasNext()) {
            inline += scanner.nextLine();
        }
        scanner.close();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(inline);
        JsonNode photosNode = node.get("photos");

        return StreamSupport.stream(photosNode.spliterator(), false)
                .map(photoNode -> {
                    Photo photo = new Photo();
                    photo.setImg_src(photoNode.get("img_src").asText());
                    return photo;
                })
                .collect(Collectors.toList());
    }
}
