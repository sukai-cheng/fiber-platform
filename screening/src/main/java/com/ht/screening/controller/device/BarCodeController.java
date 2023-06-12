package com.ht.screening.controller.device;

import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.BarCodeUtil;
import com.ht.screening.request.GenerateGenCodeRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
public class BarCodeController {

    @PostMapping("/generateGenCode")
    public AjaxResult gen(@RequestBody GenerateGenCodeRequest request) throws Exception {
        String barCodeToBase64 = BarCodeUtil.getBarCodeToBase64(request.getCode());
        return AjaxResult.success(barCodeToBase64);
    }
}
