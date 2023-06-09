package com.ht.screening.controller.device;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Deprecated
public class BarCodeController {

    @RequestMapping(value = {"/gen"})
    public void gen(String name , HttpServletRequest request , HttpServletResponse response) throws Exception {
        System.out.println(" name :" + name);
        if(null == name || name == "") {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(" name can't be blank ，名字不能为空");
            return;
        }

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
//        BufferedImage genQRCodeToBuffer = BarCodeUtil.genQRCodeToBuffer(name);
//        ImageIO.write(genQRCodeToBuffer , "jpeg" ,response.getOutputStream());
    }
}
