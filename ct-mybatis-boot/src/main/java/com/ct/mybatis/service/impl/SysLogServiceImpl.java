package com.ct.mybatis.service.impl;

import com.ct.mybatis.vo.SysLog;
import com.ct.mybatis.dao.SysLogMapper;
import com.ct.mybatis.service.ISysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
    public static final Logger logger = LogManager.getLogger(SysLogServiceImpl.class);
    @Override
    public void insertLog(String title, String uname, String url, String parms) {
        // TODO Auto-generated method stub
        SysLog sysLog  =new SysLog();
        sysLog.setCreateTime(new Date());
        sysLog.setTitle(title);
        sysLog.setUserName(uname);
        sysLog.setUrl(url);
        sysLog.setParams(parms);
        super.insert(sysLog);
        logger.debug("记录日志:"+sysLog.toString());
    }
}
