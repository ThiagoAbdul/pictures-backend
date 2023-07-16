package com.abdul.pictures.service;

import com.abdul.pictures.entity.Photo;
import com.abdul.pictures.exception.PhotoNonSavedException;
import com.abdul.pictures.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Log4j2
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Transactional(readOnly = true)
    public Page<Photo> findAll(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }
    public byte[] findById(Long id){
        return photoRepository.findById(id).orElseThrow(RuntimeException::new).getContent();
    }

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
