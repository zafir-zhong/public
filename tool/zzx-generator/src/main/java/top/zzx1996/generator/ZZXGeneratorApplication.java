package top.zzx1996.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.zzx1996.generator.dao")
public class ZZXGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZZXGeneratorApplication.class, args);
	}
}
