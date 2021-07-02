package com.techmahindra.imageapplication.service;

import com.techmahindra.imageapplication.helper.ApiResponse;
import com.techmahindra.imageapplication.models.Image;

public interface ImageService {
    ApiResponse readAll();

    ApiResponse getById(long imgId);

    ApiResponse createNewImage(Image image);

}
