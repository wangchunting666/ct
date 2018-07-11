package com.ct.util.image.base;

import com.ct.util.image.vo.PressImage;
import com.ct.util.image.vo.PressText;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Coordinate;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Herdsric-M-003 on 2018/7/10.
 */
public class ThumbImage extends AbstarctImage{
    private static Logger logger = LogManager.getLogger(ThumbImage.class.getName());
    //keepAspectRatio 是否按比例指定大小
    @Override
    public void realize(String orginImg, String img, int width, int height) {
        try {
            Thumbnails.of(orginImg).size(width, height).keepAspectRatio(false).toFile(img);
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void realize(String orginImg, String img, float realize) {
        try {
            Thumbnails.of(orginImg).scale(realize).toFile(img);
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void rotate(String orginImg, String img, int width, int height, double depree) {
        try {
            BufferedImage image = getBufferedImage(orginImg);
            Thumbnails.of(orginImg).size(image.getWidth(), image.getHeight()).rotate(depree).toFile(img);
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void imagePress(PressImage pressImage) {
        try {
            BufferedImage image = getBufferedImage(pressImage.getOrginImg());
            Thumbnails.of(pressImage.getOrginImg())
                    .size(image.getWidth(),image.getHeight())
                    .watermark(Positions.TOP_LEFT, getBufferedImage(pressImage.getWaterImg()),pressImage.getAlpha())
                    .outputQuality(0.8f)
                    .toFile(pressImage.getImg());
        }catch (Exception e){
            logger.error(PRESSERROR,e);
        }
    }

    @Override
    public void textPress(PressText pressText) {
        throw new RuntimeException(NOTOPERATORERROR);
    }

    @Override
    public void makeCircularImg(String srcFilePath, String circularImgSavePath, int targetSize, int cornerRadius) throws IOException {
        throw new RuntimeException(NOTOPERATORERROR);
    }
}
