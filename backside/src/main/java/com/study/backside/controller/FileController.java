package com.study.backside.controller;

import com.study.backside.response.Result;
import com.study.backside.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

     @Autowired
     private FileService fileService;
    // 文件上传 （可以多文件上传）
    @CrossOrigin(origins = "*")
    @PostMapping("/uploadHomework")
    public Result fileUploads(HttpServletRequest request, @RequestParam("file") MultipartFile file,
                              @RequestParam("number") String number,
                              @RequestParam("courseId") int courseId,
                              @RequestParam("homeworkId") int homeworkId) throws IOException {
        return fileService.uploadHomework(number,courseId,homeworkId,file);

    }
}
