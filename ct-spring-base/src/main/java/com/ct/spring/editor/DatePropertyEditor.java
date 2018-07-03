package com.ct.spring.editor;

import java.beans.Expression;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

/**
 * Created by dell on 2018/7/1.
 */
public class DatePropertyEditor extends PropertyEditorSupport{
    private String format = "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text:"+text);
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            setValue(sf.parse(text));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
