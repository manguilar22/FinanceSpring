package guru.aguilar.finance;

import guru.aguilar.finance.POJO.FacebookStock;
import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.config.Finance;
import guru.aguilar.finance.imple.StockAnalysis;
import guru.aguilar.finance.interfaces.Statistics;
import guru.aguilar.finance.interfaces.Stock;
import javafx.css.StyleableStringProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
@PropertySource("default.properties")
@SpringBootApplication
public class FinanceApplication implements CommandLineRunner{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FinanceApplication.class, args);
	}

	@Autowired
	Environment env;

	@Override
	public void run(String... args) throws Exception {

		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(Finance.class);

		ReadFile readFile = aca.getBean(ReadFile.class);
		FacebookStock  facebookStock =aca.getBean("facebook",FacebookStock.class);


		readFile.setFile(env.getProperty("facebook.2018-07-09"));

		List<Stock> facebook = readFile.getStock();
		LinkedList<Map<?,?>> list = new LinkedList<>();

		facebookStock.setFacebookStock(facebook);

		facebookStock.toMap().entrySet().forEach(System.out::println);

		list.add(facebookStock.toMap());

		aca.close();
	}
}
