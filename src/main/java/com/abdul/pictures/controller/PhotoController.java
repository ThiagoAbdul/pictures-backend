package com.abdul.pictures.controller;

import com.abdul.pictures.exception.PhotoNonSavedException;
import com.abdul.pictures.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin(origins = "${CLIENT_HOST}")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> postPhoto(@RequestParam MultipartFile file){
        try {
            photoService.postPhoto(file);
            return ResponseEntity.noContent().build();
        } catch (PhotoNonSavedException e) {
            return ResponseEntity.badRequest().body(e); // TODO
        }
    }
}
