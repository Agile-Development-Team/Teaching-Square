package com.study.backside.controller;

import com.study.backside.request.UpHomeworkRe;
import com.study.backside.response.HomeworkStuRes;
import com.study.backside.response.Result;
import com.study.backside.service.FileService;
import com.study.backside.util.CommonUploadAndDownloadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

     @Autowired
     private FileService fileService;

    private Logger log = LoggerFactory.getLogger("FileController");

    // 上传作业
    @CrossOrigin(origins = "*")
    @PostMapping("/uploadHomework")
    public Result fileUploads(@RequestParam("file") MultipartFile file,
                              @RequestParam("number") String number,
                              @RequestParam("courseId") int courseId,
                              @RequestParam("homeworkId") int homeworkId){
        try {
            return fileService.uploadHomework(number, courseId, homeworkId, file);
        }catch (DataAccessException e){
            log.error("/file/uploadHomework");
        }
        return new Result(500,false,"访问数据库失败");

    }

    /**
     * 学生上传作业
     *
     *
     *
    @CrossOrigin(origins = "*")
    @PostMapping("/uploadHomework")
    public Result fileUploads(UpHomeworkRe re){
        return fileService.uploadHomework(re.getNumber(),re.getCourseId(),re.getHomeworkId(),re.getFile());

    }
    */

    // 发布课程资源
    @CrossOrigin(origins = "*")
    @PostMapping("/addResource")
    public Result uploadResource(@RequestParam("courseId") int courseId,
                                 @RequestParam("title") String title,
                                 @RequestParam("file") MultipartFile file){
        try {
            return fileService.uploadResource(courseId,title,file);
        }catch (DataAccessException e){
            log.error("/file/addResource");
            log.error(e.getMessage());
        }
        return new Result(500,false,"访问数据库失败");

    }


//    //下载文件
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,@RequestParam("link") String link){
        try {
            CommonUploadAndDownloadUtil.downLoad(response, link);
        }catch (DataAccessException e){
            log.error("/file/download error");
        }
    }




}
