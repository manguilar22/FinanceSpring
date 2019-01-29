package guru.aguilar.finance;

import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.POJO.Stock;
import guru.aguilar.finance.config.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@PropertySource("classpath:default.properties")
public class FinanceApplication implements CommandLineRunner {


    @Autowired
    private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(FinanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(Finance.class);
		ReadFile read = aca.getBean("readFile",ReadFile.class);
		read.setFile(env.getProperty("amazon.2019-01-28"));

		List<Stock> amazon = read.getStock();
		amazon.forEach(System.out::println);
	}
}

