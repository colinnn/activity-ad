package com.lenovo.ad.repository.game;

/**
 * Created by chenlm3 on 2017/7/20.
 */

import com.lenovo.ad.bean.game.Dictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends CrudRepository<Dictionary, Long>{
    public List<Dictionary> findAll();

    Dictionary findById(String id);
}