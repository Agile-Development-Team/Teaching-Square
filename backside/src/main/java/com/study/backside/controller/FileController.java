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

    /**
     * 学生上传作业
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/uploadHomework")
    public Result fileUploads(@RequestParam("file") MultipartFile file,
                              @RequestParam("number") String number,
                              @RequestParam("courseId") int courseId,
                              @RequestParam("homeworkId") int homeworkId){
        try {
            Result res = fileService.uploadHomework(number, courseId, homeworkId, file);
            if(res.isSuccess()){
                String filePath = System.getProperty("user.dir") + "\\src\\main\\";
                // 获取上传的文件名称
                String fileName = file.getOriginalFilename();
                // 时间 和 日期拼接
                String newFileName = number+"_"+courseId+"_"+homeworkId+"_"+fileName;
                // 得到文件保存的位置以及新文件名
                String destPath = filePath + "resources\\student_homework"+ File.separator+newFileName;
                //存放文件
                CommonUploadAndDownloadUtil.upload(destPath,file);

            }
            return res;
        }catch (DataAccessException e){
            log.error("/file/uploadHomework");
            log.error(e.getMessage());
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

    /**
     * 发布课程资源课件ppt等
     */
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


    /**
     * 下载文件
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,@RequestParam("link") String link){
        try {
            CommonUploadAndDownloadUtil.downLoad(response, link);
        }catch (DataAccessException e){
            log.error("/file/download error");
            log.error(e.getMessage());
        }
    }




}
