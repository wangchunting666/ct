package com.ct.util.image;

import com.ct.util.image.base.IImage;
import com.ct.util.image.base.ThumbImage;
import com.ct.util.image.vo.PressImage;
import com.ct.util.image.vo.PressText;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.awt.*;

/** 
* PressImageUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 9, 2018</pre> 
* @version 1.0 
*/ 
public class PressImageUtilTest {
    private final String orgin1 = "D:\\workspace\\image\\orgin\\1.jpg";
    private final String press1 = "D:\\workspace\\image\\press\\1.png";
    private final String result1 = "D:\\workspace\\image\\result\\2.jpg";
    private final String result2 = "D:\\workspace\\image\\result\\3.png";
    private PressImage pressImage;
    private PressText pressText;
    private IImage iImage;
    @Before
    public void before() throws Exception {
        pressImage = new PressImage();
        pressImage.setWaterImg(press1);
        pressImage.setOrginImg(orgin1);
        pressImage.setImg(result1);
        pressImage.setX(0);
        pressImage.setY(0);
        pressImage.setWidth(200);
        pressImage.setHeight(200);
        pressImage.setAlpha(0.5f);

        pressText = new PressText();
        pressText.setY(0);
        pressText.setImg(result1);
        pressText.setX(0);
        pressText.setAlpha(0.8f);
        pressText.setColor(new Color(0,0,0));
        pressText.setFontName(null);
        pressText.setFontSize(24);
        pressText.setFontStyle(0);
        pressText.setText("HELLO WORLD!!");
        pressText.setOriginImg(orgin1);

        iImage = new ThumbImage();
    }

    @After
    public void after() throws Exception {}

    @Test
    public void testRealize() throws Exception {
        iImage.rotate(orgin1,result2,1024,880,90);
    }
} 
