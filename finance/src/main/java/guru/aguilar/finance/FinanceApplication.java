package guru.aguilar.finance;

import guru.aguilar.finance.POJO.FacebookStock;
import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.config.Finance;
import guru.aguilar.finance.imple.StockAnalysis;
import guru.aguilar.finance.interfaces.Statistics;
import guru.aguilar.finance.interfaces.Stock;
import javafx.css.StyleableStringProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FinanceApplication.class, args);

		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(Finance.class);

		ReadFile readFile = aca.getBean("readFile",ReadFile.class);
		FacebookStock  facebookStock =aca.getBean("facebook",FacebookStock.class);
		StockAnalysis statistics = aca.getBean("analysis",StockAnalysis.class);

        readFile.setFile("classpath:stocks/2018-07-0901:24:18.911302Facebook.txt");


        List<Stock> facebook = readFile.getStock();

        statistics.setMarketData(facebook, e -> e.getHigh());

        System.out.println("Summation:\t"+statistics.average());


        aca.close();
	}
}
