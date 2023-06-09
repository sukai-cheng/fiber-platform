package com.ht.screening.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.print.PrintService;
import java.awt.print.*;
import java.io.IOException;

@RestController
public class PrintController {
    @PostMapping("/print1")
    public void print(String printName,@RequestPart("multipartFile") MultipartFile multipartFile) throws IOException, PrinterException {
//        // 使用打印机的名称
//        String printName = "\\\\172.17.1.127\\Canon-print";

        /*
            保存上传的文件到"e:\\"
         */
//        String pdfPath = "e:\\";
//        File file = new File(pdfPath+headerImg.getOriginalFilename());
//        InputStream inputStream = headerImg.getInputStream();
//        FileOutputStream out = new FileOutputStream(file);
//        IoUtil.copy(headerImg.getInputStream(),out);
//        out.write(headerImg.getBytes());
//        out.close();

        // 读取pdf文件
        PDDocument document = PDDocument.load(multipartFile.getInputStream());
        // 创建打印任务
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName(multipartFile.getOriginalFilename());
        // 遍历所有打印机的名称
        for (PrintService ps : PrinterJob.lookupPrintServices()) {
            String psName = ps.toString();
            // 选用指定打印机
            if (psName.equals(printName)) {
                job.setPrintService(ps);
                break;
            }
        }

        job.setPageable(new PDFPageable(document));

        Paper paper = new Paper();
        // 设置打印纸张大小
        paper.setSize(598,842); // 1/72 inch
        // 设置打印位置 坐标
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins
        // custom page format
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);
        // override the page format
        Book book = new Book();
        // append all pages 设置一些属性 是否缩放 打印张数等
        book.append(new PDFPrintable(document, Scaling.ACTUAL_SIZE), pageFormat, 1);
        job.setPageable(book);
        // 开始打印
        job.print();
    }
}
