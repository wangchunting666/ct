package com.ct.mybatis.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ct.mybatis.vo.SysSetting;
import com.ct.mybatis.dao.SysSettingMapper;
import com.ct.mybatis.service.ISysSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统设置表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-17
 */
@Service
public class SysSettingServiceImpl extends ServiceImpl<SysSettingMapper, SysSetting> implements ISysSettingService {
    @Cacheable(value = "settingCache")
    @Override
    public List<SysSetting> findAll() {
        // TODO Auto-generated method stub
        return this.selectList(new EntityWrapper<SysSetting>().orderBy("sort",true));
    }
}
