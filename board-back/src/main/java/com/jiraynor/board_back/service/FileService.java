package com.jiraynor.board_back.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {


    String upload(MultipartFile file, Integer boardNumber);

    Resource getImage(String filename);

}
