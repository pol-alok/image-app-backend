package com.techmahindra.imageapplication.controller;

import com.techmahindra.imageapplication.helper.ApiResponse;
import com.techmahindra.imageapplication.models.Image;
import com.techmahindra.imageapplication.service.ImageService;
import com.techmahindra.imageapplication.utils.CommonHelperFunctions;
import com.techmahindra.imageapplication.utils.Constants;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    ImageService imageService;

    @GetMapping("/")
    @ApiOperation(value = "Find all images ",notes = "Make a get request on this api without any body",response = ResponseEntity.class)
    public ResponseEntity<?> allImage() {
        LOGGER.info(">>>>>Entering into allImage ");
        try {
            ApiResponse apiResponse = imageService.readAll();
            LOGGER.info("<<<<<Exiting from allImage");
            return CommonHelperFunctions.buildResponseEntity(apiResponse);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from allImage with exception");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_MESSAGE));
        }
    }

    @GetMapping("/show/{id}")
    @ApiOperation(value = "Find by Id ",notes = "Make a get request on this api with image id mandatory fields in body",response = ResponseEntity.class)
    public ResponseEntity<?> findById(@PathVariable(required = false,name = "id") Long imageId) {
        LOGGER.info(">>>>>Entering into findById");
        try {
            ApiResponse apiResponse = imageService.getById(imageId);
            LOGGER.info("<<<<<Exiting from findById");
            return CommonHelperFunctions.buildResponseEntity(apiResponse);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from findById with exception");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_MESSAGE));
        }

    }

    @PostMapping(value = "/new", consumes = "application/json")
    @ApiOperation(value = "Create new image. ",notes = "Make a post request on this api with all mandatory fields in body",response = ResponseEntity.class)
    public ResponseEntity<?> newImage(@RequestBody Image newImage) {
        LOGGER.info(">>>>>Entering into newImage ");
        try {
            LOGGER.info("<<<<<Exiting from newImage");
            ApiResponse apiResponse = imageService.createNewImage(newImage);
            return CommonHelperFunctions.buildResponseEntity(apiResponse);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from newImage");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_MESSAGE));
        }
    }
}
