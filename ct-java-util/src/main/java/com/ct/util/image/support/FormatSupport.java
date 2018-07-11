package com.ct.util.image.support;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Herdsric-M-003 on 2018/7/9.
 */
public class FormatSupport {
    private static final String path1 = "D:\\workspace\\image\\orgin\\1.jpg";
    private static final String path2 = "D:\\workspace\\image\\orgin\\2.png";
    private static final String path3 = "D:\\workspace\\image\\orgin\\3.png";
    private static final String path4 = "D:\\workspace\\image\\orgin\\4.png";
    private static final String path5 = "D:\\workspace\\image\\orgin\\5.png";

    public static void multiImage() throws Exception{
        BufferedImage first_bi = ImageIO.read(new File(path1)),
                second_bi = ImageIO.read(new File(path2));
        IIOImage first_IIOImage = new IIOImage(first_bi, null, null);
        IIOImage second_IIOImage = new IIOImage(second_bi, null, null);

        ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
        ImageOutputStream iss1 = ImageIO.createImageOutputStream(new File(path5));
        writer.setOutput(iss1);

        writer.write(null, first_IIOImage, null);
        if (writer.canInsertImage(1)) {
            writer.writeInsert(1, second_IIOImage, null);
        } else {
            System.err.println("Writer can’t append a second image!");
        }
    }

    public static void imageWriter() throws Exception{
        BufferedImage bi1 = ImageIO.read(new File(path1));
        ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
        ImageOutputStream iss = ImageIO.createImageOutputStream(new File(path4));
        writer.setOutput(iss);
        writer.write(bi1);
    }

    public static void thumbnails() throws Exception{
        ImageReader reader = ImageIO.getImageReadersByFormatName("jpg").next();
        ImageInputStream iis1 = ImageIO.createImageInputStream(new File(path1));
        reader.setInput(iis1, true);
        //System.out.println(reader.getNumImages(false));
        //BufferedImage bi1 = reader.readThumbnail(0, 0);
        //ImageIO.write(bi1, "png", new File(path4));
    }

    public static void format() throws Exception{
        String readFormats[] = ImageIO.getReaderFormatNames();
        String writeFormats[] = ImageIO.getWriterFormatNames();
        System.out.println("Readers: " + Arrays.asList(readFormats));
        System.out.println("Writers: " + Arrays.asList(writeFormats));
    }
    public static void read() throws Exception{
        BufferedImage bi1 = ImageIO.read(new File(path1));
        ImageIO.write(bi1, "png", new File(path2));
    }
    public static void imageReader() throws Exception{
        Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)readers.next();
        System.out.println(reader.toString());

        ImageInputStream iis = ImageIO.createImageInputStream(new File(path1));
        reader.setInput(iis, true);
    }
    public static void imageReadParam() throws Exception{
        Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)readers.next();

        ImageInputStream iis = ImageIO.createImageInputStream(new File(path1));
        reader.setInput(iis, true);

        //System.out.println(reader.getNumImages(false));

        ImageReadParam irp1 = reader.getDefaultReadParam();
        int irp1Index = 0;
        Rectangle r1 = new Rectangle(0,0,reader.getHeight(irp1Index)/2,reader.getWidth(irp1Index)/2);
        irp1.setSourceRegion(r1);
        BufferedImage bi1 = reader.read(irp1Index,irp1);

        ImageIO.write(bi1, "png", new File(path2));

        ImageReadParam irp2 = reader.getDefaultReadParam();
        irp2.setSourceSubsampling(3, 3, 0, 0);
        BufferedImage bi2 = reader.read(0, irp2);

        ImageIO.write(bi2, "png", new File(path3));

    }
}
