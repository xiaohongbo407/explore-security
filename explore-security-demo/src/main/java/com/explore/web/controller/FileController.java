package com.explore.web.controller;

import com.explore.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by xiaohb on 2018/1/5.
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private String folder ="D:\\c4if5\\";
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        return  new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
             OutputStream outputStream = response.getOutputStream()){

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
