package com.example.proyecto.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    void upload(MultipartFile file);
}
