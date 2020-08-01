package top.jloeve.aigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.jloeve.aigou.mappers")
public class AigouApplication {
  public static void main(String[] args) {
    SpringApplication.run(AigouApplication.class, args);
  }
}
