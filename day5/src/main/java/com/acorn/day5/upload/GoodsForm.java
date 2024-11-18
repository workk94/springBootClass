package com.acorn.day5.upload;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class GoodsForm {
    String code;
    String name;
    MultipartFile file;
}
