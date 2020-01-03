package com.avdeeva.web.application.onlinecourse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EditController {

    @Value("${image.upload.path}")
    private String uploadPath;

    @Value("${image.upload.url}")
    private String uploadUrl;

   /* @PostMapping("/image/upload")
    @SneakyThrows
    public String upload(Model model, @RequestPart MultipartFile upload, @RequestParam("CKEditorFuncNum") String callback, HttpServletRequest request) {

        String sourceName = upload.getOriginalFilename();
        String sourceExt = FilenameUtils.getExtension(sourceName);

        File destFile;
        String destFileName;

        do {
            destFileName = RandomStringUtils.randomAlphabetic(8).concat(".").concat(sourceExt).toLowerCase();
            destFile = new File(uploadPath.concat(destFileName));
        } while (destFile.exists());
        destFile.getParentFile().mkdirs();
        upload.transferTo(destFile);

        model.addAttribute("imageUrl",request.getScheme().concat("://").concat(request.getServerName()).concat(":8080").concat(uploadUrl).concat(destFileName));

       /* StringBuffer sb = new StringBuffer();
        sb.append("<script type='text/javascript'> window.parent.CKEDITOR.tools.callFunction(");
        sb.append(callback);
        sb.append(",'");
        sb.append(imgUrl);
        sb.append("','image upload success!!!')</script>");

        model.addAttribute(sb.toString());

        return "addNews";
    }*/

    @PostMapping("/addNewNews")
    public String addNews (@RequestParam("editor") String text, Model model) {
        model.addAttribute("text", text);
        return "one-news";
    }
}
