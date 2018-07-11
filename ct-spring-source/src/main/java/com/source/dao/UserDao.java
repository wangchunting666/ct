package com.source.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Herdsric-M-003 on 2018/7/11.
 */
public interface UserDao {
    List<Map<String,Object>> selectAll(Map<String,Object> map);
}
