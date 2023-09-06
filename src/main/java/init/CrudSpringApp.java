package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrudSpringApp {


	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(CrudSpringApp.class, args).getBeanDefinitionNames();
	}

}
