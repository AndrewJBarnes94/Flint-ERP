package com.brocodesoftware.Flint_ERP_backend;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
public class FlintErpBackendApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(FlintErpBackendApplication.class);
		
		Arrays.stream( ctx.getBeanDefinitionNames() )
		.sorted()
		.forEach(System.out::println);
		
		FileSystem fs = ctx.getBean( FileSystem.class );
		System.out.println( DataSize.ofBytes( fs.getFreeDiskSpace() ).toGigabytes() + " GB");
		
		
	}

}
