package com.ct.ehcache.service;

import com.ct.ehcache.Dog;

/**
 * Created by Herdsric-M-003 on 2018/6/15.
 */
public interface EhcacheService {
    public String getTimestamp(String param);

    public String getDataFromDB(String key);

    public void removeDataAtDB(String key);

    public String refreshData(String key);

    public Dog findById(String userId);

    public boolean isReserved(String userId);

    public void removeUser(String userId);

    public void removeAllUser();
}
