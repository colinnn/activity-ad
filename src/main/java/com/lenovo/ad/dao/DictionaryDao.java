package com.lenovo.ad.dao;

import com.lenovo.ad.repository.game.DictionaryRepository;
import com.lenovo.ad.bean.game.Dictionary;
import com.lenovo.ad.util.AdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by chenlm3 on 2017/7/20.
 */
@Repository
public class DictionaryDao {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Cacheable(value = AdUtil.CACHE_DICTIONARY, key = "'DictionaryService.getValById.'+#id", cacheManager = AdUtil.CACHE_MANAGER)
    public String get_val_by_id(String id){
        Dictionary dictionary = dictionaryRepository.findById(id);
        if (null==dictionary)
            return null;
        return dictionary.getValue();
    }
}
