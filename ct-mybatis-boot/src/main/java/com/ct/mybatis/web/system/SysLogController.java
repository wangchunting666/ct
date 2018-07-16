package com.ct.mybatis.web.system;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ct.mybatis.service.ISysLogService;
import com.ct.mybatis.vo.SysLog;
import com.ct.mybatis.web.common.SuperController;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
@Controller
@RequestMapping("/system/log")
public class SysLogController extends SuperController{
    @Autowired
    private ISysLogService sysLogService;
    /**
     * 进入日志页面
     */
    @RequiresPermissions("listLog")
    @RequestMapping("/page")
    public String page(Model model){
        return "system/log/list";
    }
    /**
     * 分页查询日志
     */
    @ResponseBody
    @RequiresPermissions("listLog")
    @RequestMapping("/list")
    public Object list(@RequestBody Map<String,Object> map){
        logger.debug(map);
        Map<String,Object> result = new HashMap<>();
        int pageNumber = Integer.valueOf(map.get("page").toString());
        int pageSize = Integer.valueOf(map.get("limit").toString());
        String search = map.get("search").toString();
        Page<SysLog> page = getPage(pageNumber,pageSize);
        page.setOrderByField("createTime");
        page.setAsc(false);
        // 查询分页
        EntityWrapper<SysLog> ew = new EntityWrapper<SysLog>();
        if(StringUtils.isNotBlank(search)){
            ew.where("(userName like CONCAT('%',{0},'%')", search)
                    .or("title like CONCAT('%',{0},'%'))", search);
            result.put("search", search);
        }
//        //日期查询
//        if(StringUtils.isNotBlank(daterange)){
//            model.addAttribute("daterange", daterange);
//            String[] dateranges = StringUtils.split(daterange, "-");
//            ew.addFilter(" createTime >= {0}", dateranges[0].trim().replaceAll("/","-") + " 00:00:00");
//            ew.addFilter(" createTime <= {0}", dateranges[1].trim().replaceAll("/","-") + " 23:59:59");
//        }
        Page<SysLog> pageData = sysLogService.selectPage(page, ew);
        return pageData;
    }

    /**
     * 获取参数
     */
    @RequestMapping("/params/{id}")
    @ResponseBody
    public String params(@PathVariable String id,Model model){
        SysLog sysLog = sysLogService.selectById(id);
        return sysLog.getParams();
    }
}

