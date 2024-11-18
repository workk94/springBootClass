package com.example.uploadEx;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

@Controller
public class UploadController {


    @GetMapping("/upload")
    public String uploadForm(){
        return "form";
    }


    @PostMapping("/upload")
    public String upload(String title, MultipartFile  file , Model model) throws IOException {

        System.out.println( file.getOriginalFilename());
        String fileName  = file.getOriginalFilename();
        String fileDir=  "c:\\test\\upload\\" ; //
        String fullPath  = fileDir +  fileName;

        file.transferTo(  new File( fullPath));

        //return "redirect:/";
        model.addAttribute("fileName" , fileName);
        return "uploadOk";
    }




    @ResponseBody
    @RequestMapping( value="/images/{fileName:.*}" , method=RequestMethod.GET)
    public Resource imageDownload(@PathVariable String  fileName) throws MalformedURLException {
        System.out.println( "fileName" + fileName);
        return new  UrlResource("file:c:\\test\\upload\\"+ fileName);

    }



    @RequestMapping( value="/attach/{fileName:.*}" , method=RequestMethod.GET)
    public ResponseEntity<Resource> fileDownload(@PathVariable String  fileName) throws MalformedURLException, UnsupportedEncodingException, UnsupportedEncodingException {

        //서버의 리소스(자원)을 제공할 때 사용
        Resource  resource=  new  UrlResource("file:c:\\test\\upload\\"+ fileName);
        //파일이름이 한글문제로  encode작업함
        String encodedUploadFileName = URLEncoder.encode(fileName, "UTF-8");
        //응답헤더정보에 attachment라는 정보제공해야함(다운로드가 성공한다)
        String contentDispositon = "attachment; filename=\""+ encodedUploadFileName + "\"";
        return   ResponseEntity.ok().header( HttpHeaders.CONTENT_DISPOSITION, contentDispositon).body(resource);

    }


}
