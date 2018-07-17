package com.ct.mybatis.dao;

import com.ct.mybatis.vo.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<String> selectMenuIdsByuserId(String uid);

    List<String> selectResourceByUid(@Param("uid") String uid);
}
