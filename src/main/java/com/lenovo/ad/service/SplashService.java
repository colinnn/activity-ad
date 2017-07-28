package com.lenovo.ad.service;

import com.lenovo.ad.bean.game.SplashIntercept;
import com.lenovo.ad.dao.DictionaryDao;
import com.lenovo.ad.dao.SplashDao;
import com.lenovo.ad.util.AdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlm3 on 2017/7/20.
 */
@Service
public class SplashService {
    @Autowired
    private SplashDao splashDao;

    @Autowired
    private DictionaryDao dictionaryDao;

    public Map get_all_splash(String flagList){
        String onOrOff = dictionaryDao.get_val_by_id(AdUtil.DICTIONARY_SPLASH_INTERCEPT_ID);
        Map<String,SplashIntercept> splashInterceptMap = splashDao.get_all_splash();
        removeUnChange(splashInterceptMap,flagList);
        // 组合返回数据结构
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", onOrOff);
        jsonMap.put("data", splashInterceptMap.values());
        return jsonMap;
    }

    /**
     * 删除flag未变更的拦截对象
     *
     * @param splashInterceptMap
     * @param flagList
     */
    private void removeUnChange(Map<String,SplashIntercept> splashInterceptMap, String flagList) {
        if (flagList != null) {
            String[] flagArg = flagList.split(":");
            int flagSize = flagArg.length;
            for (String flag:flagArg) {
                splashInterceptMap.remove(flag);
            }
        }
    }
}
