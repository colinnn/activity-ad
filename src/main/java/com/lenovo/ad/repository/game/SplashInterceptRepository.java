package com.lenovo.ad.repository.game;

/**
 * Created by chenlm3 on 2017/7/20.
 */

import com.lenovo.ad.bean.game.SplashIntercept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SplashInterceptRepository extends CrudRepository<SplashIntercept, Long>{

    List<SplashIntercept> findAll();

}