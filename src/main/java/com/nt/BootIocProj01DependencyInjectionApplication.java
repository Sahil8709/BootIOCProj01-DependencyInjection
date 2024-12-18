package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication {
	
	@Bean(name="dt")
	public LocalDate createLDate() {
		return LocalDate.now();
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		
		// get target spring bean class obj ref
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		// invoke the b.method
		String resultMsg=finder.findSeason();
		//dispaly the results
		System.out.println(resultMsg);
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
