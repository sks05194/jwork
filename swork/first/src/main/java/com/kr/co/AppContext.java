package com.kr.co;

import org.springframework.context.annotation.*;

@Configuration
public class AppContext {
	/* <bean id="stv" class="com.kr.co.Samsung" init-method="initSamsung" /> */
	@Bean(initMethod = "initSamsung", destroyMethod = "destroySamsung")
	public Samsung stv() {
		Samsung s = new Samsung();
		return s;
	}

	/* <bean id="greeter" class="com.kr.co.Greeter" /> */
//	@Bean
//	public Greeter greeter() {
//		Greeter g = new Greeter("0");
//		g.setFormat("%s, 안녕하세요!");
//		return g;
//	}

	@Bean @Scope("prototype")
	public Greeter greeter() {
		Greeter g = new Greeter("0");
		g.setFormat("%s, 안녕하세요!");
		return g;
	}

	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter("1");
		g.setFormat("%s, 시작합니다!");
		return g;
	}

//	@Bean @Lazy
//	public Greeter greeter1() {
//		Greeter g = new Greeter("1");
//		g.setFormat("%s, 시작합니다!");
//		return g;
//	}

	@Bean
	public int inter() {
		return 50;
	}
}