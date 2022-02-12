package com.study.backside.service;

import com.study.backside.mapper.HomeworkMapper;
import com.study.backside.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileService {
    // 设置固定的日期格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 将 yml 中的自定义配置注入到这里
    @Value("${gorit.file.root.path}")
    private String filePath;

    @Resource
    private HomeworkMapper homeworkMapper;
    // 日志打印
    private Logger log = LoggerFactory.getLogger("FileController");
    public Result uploadHomework(String number,int courseId,int homeworkId,MultipartFile file){
        // 得到格式化后的日期
        String format = sdf.format(new Date());
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 时间 和 日期拼接
        String newFileName = format + "_" + fileName;
        // 得到文件保存的位置以及新文件名
        File dest = new File(filePath + newFileName);
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            // 打印日志
            log.info("上传成功，当前上传的文件保存在 {}",filePath + newFileName);
            //将存储路径存放至数据库表
            int res = homeworkMapper.uploadHomework(number,courseId,homeworkId,filePath+newFileName,"0");
            if(res==1){
                return new Result(200,true,"上传成功");
            }
            return new Result(400,false,"上传失败");




        } catch (IOException e) {
            log.error(e.toString());
        }
        // 待完成 —— 文件类型校验工作
        return new Result(400,false,"上传失败");
    }
}
