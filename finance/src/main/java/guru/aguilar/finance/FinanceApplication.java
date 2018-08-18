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

	private AnnotationConfigApplicationContext aca;
	private ReadFile readFile; 

	@Override
	public void run(String... args) throws Exception {
		/////////////////////////////////////////////////////////////////May throw error, check compilation
		this.aca = AnnotationConfigApplicationContext(Finance.class);
		this.readfile=aca.getBean(ReadFile.class);
		//////////////////////////////////////////////////////////////////////////////////
		FacebookStock  facebookStock =aca.getBean("facebook",FacebookStock.class);

		List<Stock> fb = getStock("facebook.2018-07-09");
		List<Stock> goog = getStock("google.2018-07-09");
		List<Nasdaq> nasdaq = getStock("nasdaq.2018-08-07");

		fb.forEach(System.out::println);
		goog.forEach(System.out::println);
		nasdaq.forEach(System.out::println);

		aca.close();
	}
	
	private List<Stock> getStock(String s) throws Exception { 
		this.readFile.setFile(env.getProperty(s));
		return this.readFile.getStock(); 
	}
	
}

				
