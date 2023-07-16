package com.abdul.pictures.controller;

import com.abdul.pictures.entity.Photo;
import com.abdul.pictures.exception.PhotoNonSavedException;
import com.abdul.pictures.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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

    @GetMapping
    ResponseEntity<Page<Photo>> listPhotosPaginated(Pageable pageable){
        return ResponseEntity.ok(photoService.findAll(pageable));
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getPhotoById(@PathVariable Long id){
        byte[] content = photoService.findById(id);
        String filename = String.valueOf(System.currentTimeMillis());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .body(content);
    }
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
