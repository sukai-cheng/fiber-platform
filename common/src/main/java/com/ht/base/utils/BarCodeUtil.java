package com.ht.base.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class BarCodeUtil {

    /**
     * description: 生成条形码
     *
     * @param contents 条形码内容
     * @param width    条形码宽
     * @param height   条形码高
     * @param imgPath  图片存储路径
     * @return void
     * @version v1.0
     * @author w
     * @date 2020年8月27日 上午11:30:12
     */
    public static void genBarCode(String contents, int width, int height, String imgPath) {
        int codeWidth = 3 + // start guard
                (7 * 6) + // left bars
                5 + // middle guard
                (7 * 6) + // right bars
                3; // end guard
        codeWidth = Math.max(codeWidth, width);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.CODE_128, codeWidth, height, null);

            MatrixToImageWriter
                    .writeToFile(bitMatrix, "png", new File(imgPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * description: 解析条形码
     *
     * @param imgPath
     * @return String
     * @version v1.0
     * @author w
     * @date 2020年8月27日 上午11:30:27
     */
    public static String decode(String imgPath) {
        BufferedImage p_w_picpath = null;
        try {
            //读取条形码图片文件
            p_w_picpath = ImageIO.read(new File(imgPath));
            if (p_w_picpath == null) {
                System.out.println("条形码图片不存在.");
            }

            LuminanceSource source = new BufferedImageLuminanceSource(p_w_picpath);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));


            //基于条形码图片文件解码获得其结果
            Result result = new MultiFormatReader().decode(bitmap, null);

            //从结果中获得原始文本
            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * description: 生成二维码的 Buffer 二进制文件
     *
     * @param width
     * @param height
     * @return BufferedImage
     * @throws Exception
     * @version v1.0
     * @author w
     * @date 2020年9月7日 下午5:33:03
     */
    public static void genQRCodeToBuffer(String contents, int width, int height, String fileName) throws Exception {
        try {

            //创建EAN-13条形码文件的位图矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.CODE_128, width, height, null);

            //从入参获取文件格式
            String fileFormat = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            //从入参创建文件对象
            File outputFile = new File(fileName);

            //吧位图矩阵写入指定的图片文件中
            MatrixToImageWriter.writeToFile(bitMatrix, fileFormat, outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //绘制图片到流
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }

        Code39Bean bean = new Code39Bean();

        // 精细度
        final int dpi = 150;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.0f / dpi);

        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        String format = "image/png";
        try {

            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBarCodeToBase64(String code){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        generate(code, outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(outputStream.toByteArray());
    }


    public static void main(String[] args) {
//        String url = "D:\\\\workspace\\\\project\\\\gx-lasishaixuan-backend\\\\common\\\\src\\\\main\\\\java\\\\com\\\\ht\\\\base\\\\utils\\\\test.png";
//        genBarCode("05S23E8371XXP",98,25,"D:\\workspace\\project\\gx-lasishaixuan-backend\\common\\src\\main\\java\\com\\ht\\base\\utils\\test.png");
//        String res = decode("D:\\workspace\\project\\gx-lasishaixuan-backend\\common\\src\\main\\java\\com\\ht\\base\\utils\\test.png");
//        System.out.println(res);
        String barCodeToBase64 = getBarCodeToBase64("05S23E8371XXP");
        System.out.println(barCodeToBase64);
    }
}
