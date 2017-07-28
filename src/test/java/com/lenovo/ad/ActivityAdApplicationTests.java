package com.lenovo.ad;

import com.lenovo.ad.repository.game.SplashInterceptRepository;
import com.lenovo.ad.service.SplashService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityAdApplicationTests {
	@Autowired
	private  SplashInterceptRepository splashInterceptRepository;
	@Autowired
	private SplashService splashService;
	@Test
	public void contextLoads() {
		for (int i=0;i<100000;i++){
			new Thread(()->{
				System.out.println("thread"+Thread.currentThread().getName()+splashService.get_all_splash(""));
			}).start();
		}
	}

}
