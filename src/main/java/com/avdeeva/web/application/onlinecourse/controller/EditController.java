package com.avdeeva.web.application.onlinecourse.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class EditController {

    @Value("${image.upload.path}")
    private String uploadFile;

    @Value("${image.upload.url}")
    private String uploadUrl;

    @PostMapping("/image/upload")
    public ModelAndView upload(ModelMap model, @RequestPart MultipartFile file) throws IOException {

        File uploadDir = new File(uploadFile);

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadFile + resultFileName));

       model.addAttribute("image", resultFileName);
       return new ModelAndView("redirect:/addNews", model);
    }


}
