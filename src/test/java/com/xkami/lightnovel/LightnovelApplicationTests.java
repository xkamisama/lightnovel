package com.xkami.lightnovel;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LightnovelApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void test(){
		//默认算法SHA-512
		DefaultHashService hashService = new DefaultHashService();
//		hashService.setHashAlgorithmName("SHA-512");
//		//私盐，默认无
//		hashService.setPrivateSalt(new SimpleByteSource("123"));
//		//是否生成公盐，默认false
//		hashService.setGeneratePublicSalt(true);
//		//用于生成公盐，默认就这个
//		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
//		//生成Hash值的迭代次数
//		hashService.setHashIterations(1);
		HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5").
				setSource(ByteSource.Util.bytes("hello")).setSalt(ByteSource.Util.bytes("123")).
				setIterations(2).build();
		String hex = hashService.computeHash(request).toHex();
		System.out.println(hex);
	}

	@Test
	public void Test1() {
		String a = ClassUtils.getDefaultClassLoader().getResource("/static").getPath();
		System.out.println(a);
	}
}
