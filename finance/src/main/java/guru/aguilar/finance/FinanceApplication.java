package guru.aguilar.finance;

import guru.aguilar.finance.POJO.FacebookStock;
import guru.aguilar.finance.POJO.Nasdaq;
import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.config.Finance;
import guru.aguilar.finance.imple.Sort;
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

import java.util.*;

@PropertySource("default.properties")
@SpringBootApplication
public class FinanceApplication implements CommandLineRunner{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FinanceApplication.class, args);
	}

	@Autowired
	Environment env;

	private AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(Finance.class);
	private ReadFile readFile = aca.getBean(ReadFile.class);

	@Override
	public void run(String... args) throws Exception {

		FacebookStock  facebookStock =aca.getBean("facebook",FacebookStock.class);

		List<Stock> fb = getFacebookStock();
		List<Stock> goog = getFacebookStock();
		List<Nasdaq> nasdaq = getNasdaqStock();

		fb.forEach(System.out::println);
		goog.forEach(System.out::println);
		nasdaq.forEach(System.out::println);

		aca.close();
	}

	private List<Stock> getGoogleStock() throws Exception{
		this.readFile.setFile(env.getProperty("google.2018-07-09"));
		return this.readFile.getStock();
	}
	private List<Stock> getFacebookStock() throws Exception{
		this.readFile.setFile(env.getProperty("facebook.2018-07-09"));
		return this.readFile.getStock();
	}
	private List<Nasdaq> getNasdaqStock() throws Exception{
		this.readFile.setFile(env.getProperty("nasdaq.2018-08-07"));
		return this.readFile.getNasdaq();
	}
}

