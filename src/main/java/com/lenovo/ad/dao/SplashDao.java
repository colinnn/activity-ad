package com.lenovo.ad.dao;

import com.lenovo.ad.repository.game.SplashInterceptRepository;
import com.lenovo.ad.bean.game.SplashIntercept;
import com.lenovo.ad.util.AdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlm3 on 2017/7/20.
 */
@Repository
public class SplashDao {
    @Autowired
    private SplashInterceptRepository splashInterceptRepository;

    @Cacheable(value = AdUtil.CACHE_SPLASH_INTERCEPT,key = "'SplashInterceptService.getList'",cacheManager = AdUtil.CACHE_MANAGER)
    public Map<String,SplashIntercept> get_all_splash(){
        List<SplashIntercept> list = splashInterceptRepository.findAll();
        Map<String,SplashIntercept> result = new HashMap<>();
        for (SplashIntercept splash : list)
            result.put(splash.getFlag(),splash);
        return result;
    }
}
