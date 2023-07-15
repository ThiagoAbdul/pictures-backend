package com.abdul.pictures.service;

import com.abdul.pictures.entity.Photo;
import com.abdul.pictures.exception.PhotoNonSavedException;
import com.abdul.pictures.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Log4j2
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Transactional
    public void postPhoto(MultipartFile file) throws PhotoNonSavedException {
        try{
            Photo photo = new Photo(file.getBytes());
            photoRepository.save(photo);
        }
        catch (Exception e){
            log.info(e.getMessage());
            throw new PhotoNonSavedException(e);
        }

    }
}
