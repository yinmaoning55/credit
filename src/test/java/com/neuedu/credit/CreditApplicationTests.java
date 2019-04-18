package com.neuedu.credit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CreditApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
//		restTemplate.getForObject("/info/upsert/anything",Object.class);
	}
	@Test
	public void upsertPhoTest(){
		String[] areas = new String[]{
				"北京","保定","上海","深圳","武汉",
				"广州","杭州","西安","成都","南京"
		};

		for (int i = 0; i < 10; i++) {
			long n = 920078781289001L;
			n += i;
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("upsert into ph_enterprise values (")
					.append(2+i+",'")
					.append(n).append("N','")
					.append(areas[i])
					.append("卫酒集团有限公司',")
					.append("'开业','")
					.append(2010+i)
					.append("-10-30')");
			restTemplate.getForObject("/info/upsert/"+stringBuilder.toString(),Object.class);
		}
	}

}
