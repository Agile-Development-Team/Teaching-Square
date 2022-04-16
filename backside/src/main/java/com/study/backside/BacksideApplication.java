package com.study.backside;

import com.study.backside.util.CommonUploadAndDownloadUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.backside.mapper")
public class BacksideApplication {

    public static void main(String[] args) {
        SpringApplication.run(BacksideApplication.class, args);
        CommonUploadAndDownloadUtil.createDir();
    }

}
