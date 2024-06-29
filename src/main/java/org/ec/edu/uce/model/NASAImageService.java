package org.ec.edu.uce.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class NASAImageService {
    private static final String API_KEY = "DEMO_KEY";
    private static final String BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/";

    private final OkHttpClient client;
    private final Gson gson;

    public NASAImageService() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public List<String> getImages(String roverName, int sol, String cameraName) throws Exception {
        List<String> images = new ArrayList<>();

        String url = String.format("%s%s/photos?sol=%d&camera=%s&api_key=%s", BASE_URL, roverName, sol, cameraName, API_KEY);
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            JsonArray photos = jsonObject.getAsJsonArray("photos");

            for (int i = 0; i < photos.size(); i++) {
                JsonObject photo = photos.get(i).getAsJsonObject();
                String imgSrc = photo.get("img_src").getAsString();
                images.add(imgSrc);
            }
        }

        return images;
    }
}
