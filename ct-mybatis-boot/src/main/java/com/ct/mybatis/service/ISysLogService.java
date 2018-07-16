package com.ct.mybatis.service;

import com.ct.mybatis.vo.SysLog;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysLogService extends IService<SysLog> {
    /**
     * 记录日志
     * @param title
     * @param uname
     * @param url
     * @param parms
     */
    void insertLog(String title,String uname,String url,String parms);
}
