package com.ct.util.image.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * Created by Herdsric-M-003 on 2018/7/10.
 */
public abstract class AbstarctImage implements IImage{
    private static Logger logger = LogManager.getLogger(AbstarctImage.class.getName());
    protected final String REGEXURL = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$";
    protected final String NOTFOUNDERROR = "文件不存在";
    protected final String NOTOPERATORERROR = "暂不支持该操作";
    protected final String PRESSERROR = "加水印图片错误";
    protected final String PICTRUE_FORMATE_PNG = "png";
    protected Image getImage(String img){
        try {
            if(isUrl(img)){
                return ImageIO.read(new URL(img));
            }
            return ImageIO.read(new File(img));
        }catch (Exception e){
            logger.error(NOTFOUNDERROR,e);
            return null;
        }
    }

    protected BufferedImage getBufferedImage(String img){
        try {
            if(isUrl(img)){
                return ImageIO.read(new URL(img));
            }
            return ImageIO.read(new File(img));
        }catch (Exception e){
            logger.error(NOTFOUNDERROR,e);
            return null;
        }
    }

    protected boolean isUrl(String url){
        Pattern pattern = Pattern.compile(REGEXURL);
        return pattern.matcher(url).matches();
    }
}
