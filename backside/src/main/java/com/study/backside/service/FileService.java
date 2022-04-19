package com.study.backside.service;

import com.study.backside.bean.Powerpoint;
import com.study.backside.mapper.HomeworkMapper;
import com.study.backside.mapper.PowerpointMapper;
import com.study.backside.response.Result;
import com.study.backside.util.CommonUploadAndDownloadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileService {
    // 设置固定的日期格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 将 yml 中的自定义配置注入到这里
    //@Value("${gorit.file.root.path}")
    private String filePath = System.getProperty("user.dir") + "\\src\\main\\";

    @Resource
    private HomeworkMapper homeworkMapper;
    @Resource
    private PowerpointMapper powerpointMapper;
    public Result uploadHomework(String number,int courseId,int homeworkId,MultipartFile file) throws DataAccessException {

        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 时间 和 日期拼接
        String newFileName = number+"_"+courseId+"_"+homeworkId+"_"+fileName;
        // 得到文件保存的位置以及新文件名
        String destPath = filePath + "resources\\student_homework"+ File.separator+newFileName;

        //将存储路径存放至数据库表

        List<Integer> ids = homeworkMapper.getStudentHomeworkById(number,courseId,homeworkId);
        String grade = "0";
        if(ids.size()==0) {

            int res = homeworkMapper.uploadHomework(number, courseId, homeworkId, destPath, grade);
            if(res==1) {

                return new Result(200, true, "上传成功");
            }
            return new Result(400, false, "上传失败");



        }
        else{
            homeworkMapper.updateHomework(number, courseId, homeworkId, destPath, grade);

            return new Result(200, true, "更新成功");
        }



    }
    public Result uploadResource(int courseId,String title,MultipartFile file) throws DataAccessException{
        int cnt = powerpointMapper.getResourcesCount(courseId);
        int pptId = cnt+1;
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 课程id和pptId拼接
        String newFileName = courseId+"_"+pptId+"_"+fileName;
        // 得到文件保存的位置以及新文件名
        String destPath = filePath + "resources\\powerpoint"+ File.separator+newFileName;


        //存放至数据库
        Date currentDate = new Date();
        SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        int res = powerpointMapper.addResource(new Powerpoint(courseId,pptId,title,SimpleDateFormat.format(currentDate.getTime()),destPath));
        Result re = new Result(400, false, "上传失败");;
        if(res==1) {
            re =  new Result(200, true, "上传成功");
        }
        if(re.isSuccess()){
            //存放文件

            CommonUploadAndDownloadUtil.upload(destPath,file);
        }
        return re;


    }


}
