package guru.aguilar.finance.config;


import guru.aguilar.finance.POJO.FacebookStock;
import guru.aguilar.finance.POJO.Nasdaq;
import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.imple.StockAnalysis;
import guru.aguilar.finance.interfaces.Statistics;
import guru.aguilar.finance.interfaces.Stock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"guru.aguilar.finance.*"})
public class Finance {

    @Bean
    public Stock stock(){ return  new Stock(); }

    @Bean
    public Nasdaq nasdaq(){ return new Nasdaq(); }

    @Bean
    public FacebookStock facebook(){ return new FacebookStock(); }

    @Bean
    public ReadFile readFile(){ return  new ReadFile(); }

    @Bean
    public Statistics analysis(){ return  new StockAnalysis(); }


}
