package com.acorn.day5.upload;

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
import java.util.UUID;

@Controller
public class UploadController {

    private String fileDir = "c:\\test\\upload\\";

    //폼화면
    @GetMapping("/upload")
    public String uploadForm( ){
        return "upload/form-item";
    }

    @PostMapping("/upload")
    //업로드 처리
    public String upload(GoodsForm goodsForm, Model model) throws IOException {
        //
        System.out.println(goodsForm.getCode());
        System.out.println(goodsForm.getName());
        System.out.println(goodsForm.getFile());

        // 1.원본파일 가져오기
        // 2.저장이름 만들기(유니크한)
        MultipartFile file = goodsForm.getFile();
        String originName = file.getOriginalFilename();

        //저장이름 만들기
        //UUID 이용해서 저장 이름 만들기                   // "스냅샷1.png"
        String uuid = UUID.randomUUID().toString();  // "dsifljds;sdifjaslf132214" + ".png"
        int pos = originName.lastIndexOf(".");
        String ext = originName.substring(pos + 1);

        String saveName = uuid + "." + ext;
        System.out.println(saveName);

        //3. 파일 업로드
        String savePath = fileDir + saveName;
        file.transferTo(new File(savePath));

        // 4.데이터저장(GoodsDto - code, name, originName, saveName)
        // 저장하기 위한 GoodsDto 생성
        String code = goodsForm.getCode();
        String name = goodsForm.getName();

        GoodsDto dto= new GoodsDto();
        dto.setCode(code);
        dto.setName(name);
        dto.setOriginName(originName);
        dto.setSaveName(saveName);

        System.out.println("저장할 상품 정보");
        System.out.println(dto.getOriginName());
        System.out.println(dto.getSaveName());
        System.out.println(dto.getCode());
        System.out.println(dto.getName());
        // 5. 저장 (데이터 베이스에 저장)

        model.addAttribute("fileName", saveName);

        return "upload/upload-ok";
    }


    // c:\\test\\upload\\저장된이름파일
    @ResponseBody
    @RequestMapping( value="/images/{fileName:.*}" , method = RequestMethod.GET)
    public Resource image(@PathVariable(name="fileName") String fileName) throws MalformedURLException {

        System.out.println( fileName);
        return new UrlResource("file:c:\\test\\upload\\" + fileName);
    }


    @RequestMapping( value="/attach/{fileName:.*}" , method=RequestMethod.GET)
    public ResponseEntity<Resource> fileDownload(@PathVariable(name="fileName") String  fileName) throws MalformedURLException, UnsupportedEncodingException, UnsupportedEncodingException {

        //서버의 리소스(자원)을 제공할 때 사용
        Resource  resource=  new  UrlResource("file:c:\\test\\upload\\"+ fileName);
        //파일이름이 한글문제로  encode작업함
        String encodedUploadFileName = URLEncoder.encode(fileName, "UTF-8");
        //응답헤더정보에 attachment라는 정보제공해야함(다운로드가 성공한다)
        String contentDispositon = "attachment; filename=\""+ encodedUploadFileName + "\"";
        return   ResponseEntity.ok().header( HttpHeaders.CONTENT_DISPOSITION, contentDispositon).body(resource);

    }
}
