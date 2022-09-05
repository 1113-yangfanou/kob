package com.kob.backend.controller.user.account;

import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;


    @GetMapping("/user/account/info/")
    public Map<String, String> getinfo() {
        return infoService.getinfo();
    }

    @PostMapping("/user/account/upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        //获得文件后缀名: a
        String a = file.getOriginalFilename().substring(begin, last);
        String fileName=user.getUsername()+a;  //我存储的文件名是该用户的账号加文件后缀名，比如201521.jpg
        String filePath = "C:/Users/15392/Desktop/spingboot/kob/web/src/assets/images";
        //这个是你的存储路径，为了方便，我用的是绝对路径，直接把文件放在项目的资源文件夹里
        File dest = new File(filePath + fileName);
        Map<String, String> map = new HashMap<>();
        try {
            file.transferTo(dest); //存储！
            //数据库存放的地址，存的是项目相对路径，这个看你们自己
            user.setPthoto(filePath);
            return infoService.upload(user);
        } catch (IOException e) {

        }
        map.put("message", "error");
        return map;
    }

}
