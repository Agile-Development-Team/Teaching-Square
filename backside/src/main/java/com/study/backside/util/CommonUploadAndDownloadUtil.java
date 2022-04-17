package com.study.backside.util;

import com.study.backside.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
@Component
public class CommonUploadAndDownloadUtil {
    /**
     * @param response 客户端响应
     * @throws java.io.IOException io异常
     */

    //主目录
    private static String filePath = System.getProperty("user.dir");
    public static void downLoad(HttpServletResponse response, String downloadUrl){
        if (Objects.isNull(downloadUrl)) {
            // 如果接收参数为空记录错误
            log.error("下载地址为空");
            return;
        }
        // 读文件
        try{
            downloadUrl = URLDecoder.decode(downloadUrl,"UTF-8");

        }catch (UnsupportedEncodingException e){
            log.error("url编码错误:{}",downloadUrl);
            e.printStackTrace();
        }
        File file = new File(downloadUrl);
        if (!file.exists()) {
            log.error("下载文件的地址不存在:{}", file.getPath());
            // 如果不存在则抛出异常，由全局异常处理类去处理。
            return;
        }
        // 获取文件名
        String fileName = file.getName();
        // 重置response
        response.reset();
        // ContentType，即告诉客户端所发送的数据属于什么类型
        response.setContentType("application/octet-stream; charset=UTF-8");
        // 获得文件的长度
        response.setHeader("Content-Length", String.valueOf(file.length()));
        // 设置编码格式，可正常显示中文
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        }catch (UnsupportedEncodingException e){
            log.error("编码格式异常");
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            // 发送给客户端的数据
            OutputStream outputStream = response.getOutputStream();
            // 读取文件
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int i = bis.read(buff);
            // 只要能读到，则一直读取
            while (i != -1) {
                // 将文件写出
                outputStream.write(buff, 0, buff.length);
                // 刷出
                outputStream.flush();
                i = bis.read(buff);
            }
        }catch (Exception e){
            log.error("下载文件失败");
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("关闭bis失败");
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("关闭fis失败");
                }
            }

        }
    }
    public static void upload(String destPath, MultipartFile file){

        // 生成文件
        File dest = new File(destPath);
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            // 打印日志
            log.info("上传成功，当前上传的文件保存在 {}",destPath);
        } catch (IOException e) {
            log.error(e.toString());
        }



    }

    //项目开始运行时创建student_homework和powerpoint两个文件夹
    public static void createDir(){
        try {
            //System.out.println("创建初始文件夹");
            String path1 = filePath + "\\src\\main\\resources\\student_homework";
            Path path = Paths.get(path1);
            Files.createDirectories(path);
            String path2 = filePath + "\\src\\main\\resources\\powerpoint";
            path = Paths.get(path2);
            Files.createDirectories(path);

        }catch (IOException e){
            log.error("/创建初始文件夹失败");

        }

    }
}
