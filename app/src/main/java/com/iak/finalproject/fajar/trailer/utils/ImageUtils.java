package com.iak.finalproject.fajar.trailer.utils;


public class ImageUtils {

    public static final String BASE_IMAGE_URL
            = "http://image.tmdb.org/t/p/";

    public static String generateImageUrl(String imagePath) {
        return BASE_IMAGE_URL + "w185" + imagePath;
    }
}
