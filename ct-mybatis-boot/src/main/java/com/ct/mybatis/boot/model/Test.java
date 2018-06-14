package com.ct.mybatis.boot.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("s_test")
public class Test extends Model<Test> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统主键
     */
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    @TableField("t_name")
    private String name;
    /**
     * 内容
     */
    @TableField("t_content")
    private String content;
    /**
     * 备注
     */
    @TableField("t_remark")
    private String remark;
    /**
     * 创建时间
     */
    private String cdate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Test{" +
        ", id=" + id +
        ", name=" + name +
        ", content=" + content +
        ", remark=" + remark +
        ", cdate=" + cdate +
        "}";
    }
}
