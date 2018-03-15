package com.ct.client.controller;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Herdsric-M-003 on 2018/2/9.
 */
public class CommonRequest {
    private static Logger logger = LogManager.getLogger(CommonRequest.class.getName());
    public static String requestGet(String url){
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse response = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(url);
                response = httpclient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String result = CommonRequestUtils.getStrByEntity(entity);
                return result;
            }catch (Exception e){
                logger.error("HttpClientGet请求失败",e);
                throw e;
            }finally {
                if(response != null){response.close();}
                if(httpclient != null){httpclient.close();}
            }
        }catch (Exception e){
            logger.error("HttpClient请求失败",e);
            return null;
        }
    }
    public static String requestPost(String url, Map<String,String> paramMap){
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse response = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(url);
                List<NameValuePair> nameValuePairList = new ArrayList<>();
                paramMap.keySet().forEach(key -> {
                    nameValuePairList.add(new BasicNameValuePair(key,paramMap.get(key)));
                });
                HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairList);
                httpPost.setEntity(httpEntity);
                response = httpclient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = CommonRequestUtils.getStrByEntity(entity);
                return result;
            }catch (Exception e){
                logger.error("HttpClientPost请求失败",e);
                throw e;
            }finally {
                if(response != null){response.close();}
                if(httpclient != null){httpclient.close();}
            }
        }catch (Exception e){
            logger.error("HttpClient请求失败",e);
            return null;
        }
    }

    public static String requestPostByStr(String url, String param){
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse response = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new StringEntity(param));
                httpPost.addHeader("Content-Type", "application/json");
                response = httpclient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = CommonRequestUtils.getStrByEntity(entity);
                return result;
            }catch (Exception e){
                logger.error("HttpClientPost请求失败",e);
                throw e;
            }finally {
                if(response != null){response.close();}
                if(httpclient != null){httpclient.close();}
            }
        }catch (Exception e){
            logger.error("HttpClient请求失败",e);
            return null;
        }
    }

    public static void main(String[] args){
        String ddd = CommonRequest.requestPostByStr("http://localhost:8808/encrypt","123456");
        System.out.println(ddd);
    }
}
