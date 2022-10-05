package com.example.proyecto.services;

import com.example.proyecto.services.interfaces.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServicesImpl implements IFileService {

    @Override
    public void upload(MultipartFile file) {
        private AmazonS3 s3client;

        private String ENDPOINT_URL = "https://s3.amazonaws.com";

        private String BUCKET_NAME = "******";

        private String ACCESS_KEY = "*******";

        private String SECRET_KEY = "*******";
    }
}
