package guru.aguilar.finance.config;

import guru.aguilar.finance.POJO.ReadFile;
import guru.aguilar.finance.POJO.Stock;
import guru.aguilar.finance.collections.Collections;
import guru.aguilar.finance.implementation.Stats;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Finance {

    @Bean
    public Stock stock(){ return new Stock(); }

    @Bean
    public ReadFile readFile() { return new ReadFile(); }

    @Bean
    public Stats stats(){ return new Stats(); }

    @Bean
    public Collections set(){ return new Collections(); }

}
