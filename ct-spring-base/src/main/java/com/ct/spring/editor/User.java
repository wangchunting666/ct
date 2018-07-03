package com.ct.spring.editor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dell on 2018/7/1.
 */
public class User implements Serializable{
    private Date createTime;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
