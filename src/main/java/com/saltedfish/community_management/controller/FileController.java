package com.saltedfish.community_management.controller;

import com.saltedfish.community_management.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 图片上传
 * @author Audient
 * @date 2020/5/28
 */
@RestController
@Slf4j
public class FileController {

    @Value("${file.upload-folder}")
    private String uploadFolder;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("d:/tmp");
        return factory.createMultipartConfig();
    }

    @PostMapping(value = "/uploadImg")
    public Result upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) throws Exception {

        Result result = new Result();
        Map<String,String> map = new HashMap<String,String>();

        //获取文件名
        String fileName = file.getOriginalFilename() ;
        log.info("上传的文件名是："+fileName);
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf(".")) ;
        log.info("上传的文件后缀名是："+suffixName);

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

        log.info(basePath);
        //文件上传路径
        String filePath = uploadFolder;
        //解决重名问题
        String newFileName = UUID.randomUUID().toString();
        fileName = newFileName.replace("-","") + suffixName;
        //
        File dest = new File(filePath + fileName);
        //检查是否存在目录
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        file.transferTo(dest);//存到设置的文件下
        log.info(dest.getAbsolutePath());
        log.info( "上传成功");

        String url = basePath+"/image/"+fileName;

        result.setStatus(HttpStatus.OK.value());
        map.put("location",url);
        result.setMessage("上传成功！");
        result.setData(map);
        log.info("result的数据是："+result.toString());
        return result;
    }

}
