package com.ct.util.image.base;

import com.ct.util.image.vo.PressImage;
import com.ct.util.image.vo.PressText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Herdsric-M-003 on 2018/7/10.
 */
public class JdkImage extends AbstarctImage{
    private static Logger logger = LogManager.getLogger(JdkImage.class.getName());
    @Override
    public void realize(String orginImg, String img, int width, int height) {
        BufferedImage image = getBufferedImage(orginImg);
        realize(image,img,width,height);
    }

    @Override
    public void realize(String orginImg, String img, float realize) {
        BufferedImage image = getBufferedImage(orginImg);
        int width  = (int)(image.getWidth()*realize);
        int height = (int)(image.getHeight()*realize);
        realize(image,img,width,height);
    }

    @Override
    public void rotate(String orginImg, String img, int width, int height, double depree) {
        throw new RuntimeException(NOTOPERATORERROR);
    }

    @Override
    public void imagePress(PressImage pressImage) {
        try {
            Image orginImage = getImage(pressImage.getOrginImg());
            int targetWidth  = orginImage.getWidth(null);
            int targetHeight = orginImage.getHeight(null);
            BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(orginImage, 0, 0, targetWidth, targetHeight, null);

            Image waterImage = getImage(pressImage.getWaterImg());// 水印文件
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, pressImage.getAlpha()));
            g.drawImage(waterImage, pressImage.getX(), pressImage.getY(), pressImage.getWidth(), pressImage.getHeight(), null); // 水印文件结束
            g.dispose();
            ImageIO.write(bufferedImage,PICTRUE_FORMATE_PNG, new File(pressImage.getImg()));
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void textPress(PressText pressText) {
        try {
            Image orginImage = getImage(pressText.getOriginImg());
            int targetWidth  = orginImage.getWidth(null);
            int targetHeight = orginImage.getHeight(null);
            BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(orginImage, 0, 0, targetWidth, targetHeight, null);

            g.setFont(new Font(pressText.getFontName(), pressText.getFontStyle(), pressText.getFontSize()));
            g.setColor(pressText.getColor());
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, pressText.getAlpha()));
            g.drawString(pressText.getText(), pressText.getX(), pressText.getY() + pressText.getFontSize());

            g.dispose();
            ImageIO.write(bufferedImage, PICTRUE_FORMATE_PNG, new File(pressText.getImg()));
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void makeCircularImg(String srcFilePath, String circularImgSavePath, int targetSize, int cornerRadius) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(srcFilePath));
        BufferedImage circularBufferImage = roundImage(bufferedImage,targetSize,cornerRadius);
        ImageIO.write(circularBufferImage, PICTRUE_FORMATE_PNG, new File(circularImgSavePath));
    }

    private void realize(BufferedImage image, String img, int width, int height){
        try {
            BufferedImage result = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            Graphics g = result.getGraphics();
            g.drawImage(image.getScaledInstance(width, height,Image.SCALE_SMOOTH),0,0,null);
            g.dispose();

            ImageIO.write(result,PICTRUE_FORMATE_PNG, new File(img));
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    private BufferedImage roundImage(BufferedImage image, int targetSize, int cornerRadius) {
        BufferedImage outputImage = new BufferedImage(targetSize, targetSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = outputImage.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, targetSize, targetSize, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return outputImage;
    }
}
