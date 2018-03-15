package com.ct.client.controller;

import org.apache.http.HttpEntity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Herdsric-M-003 on 2018/2/11.
 */
public class CommonRequestUtils {
    protected static String getStrByEntity(HttpEntity entity) throws Exception{
        InputStream is = entity.getContent();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int length = 0;
        while((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toString("UTF-8");
    }
}
