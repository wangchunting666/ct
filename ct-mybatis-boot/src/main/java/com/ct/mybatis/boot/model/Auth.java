package com.ct.mybatis.boot.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-13
 */
@TableName("s_auth")
public class Auth extends Model<Auth> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("RID")
    private Integer rid;
    /**
     * 功能ID
     */
    @TableField("FID")
    private Integer fid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    @Override
    protected Serializable pkVal() {
        return this.rid;
    }

    @Override
    public String toString() {
        return "Auth{" +
        ", rid=" + rid +
        ", fid=" + fid +
        "}";
    }
}
