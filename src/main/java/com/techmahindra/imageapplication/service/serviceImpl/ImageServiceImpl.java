package com.techmahindra.imageapplication.service.serviceImpl;

import com.techmahindra.imageapplication.dao.ImageDao;
import com.techmahindra.imageapplication.helper.ApiResponse;
import com.techmahindra.imageapplication.models.Image;
import com.techmahindra.imageapplication.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    ImageDao imageDao;

    @Override
    public ApiResponse readAll() {
        LOGGER.info(">>>>Entering into readAll ");
        List<Image> images = imageDao.findAll();
        LOGGER.info("<<<<<Exiting from readAll ");
        return new ApiResponse(HttpStatus.OK, "success", images);
    }

    @Override
    public ApiResponse createNewImage(Image image) {
        LOGGER.info(">>>>Entering into createNewImage ");
        imageDao.save(image);
        LOGGER.info("<<<<<Exiting from createNewImage ");
        return new ApiResponse(HttpStatus.OK, "success", image);
    }

    @Override
    public ApiResponse getById(long imgId) {
        LOGGER.info(">>>>Entering into getById ");
        Optional<Image> img = imageDao.findById(imgId);
        LOGGER.info("<<<<<Exiting from getById ");
        return img.map(image -> new ApiResponse(HttpStatus.OK, "success", image)).orElseGet(() -> new ApiResponse(HttpStatus.NOT_FOUND, "Image with given imgId not found."));
    }
}
