package guru.aguilar.finance;

import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.POJO.Stock;
import guru.aguilar.finance.collections.Collections;
import guru.aguilar.finance.config.Finance;
import guru.aguilar.finance.implementation.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.*;
import java.util.function.BiConsumer;

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
		Collections collections = aca.getBean("collections", Collections.class);
        Stats stats = aca.getBean("stats",Stats.class);

        read.setFile(env.getProperty("amazon.2019-01-28"));

		List<Stock> amazon = read.getStock();
		Double a = stats.summation(amazon,Stock::getClose);
        System.out.println("Summation:\t"+a);
	}
}

