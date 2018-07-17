package com.ct.mybatis.service;

import com.ct.mybatis.vo.SysSetting;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统设置表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysSettingService extends IService<SysSetting> {
    List<SysSetting> findAll();
}
