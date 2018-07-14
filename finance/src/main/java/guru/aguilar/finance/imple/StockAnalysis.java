package guru.aguilar.finance.imple;

import guru.aguilar.finance.interfaces.Statistics;
import guru.aguilar.finance.interfaces.Stock;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
@Component
@Scope("prototype")
public class StockAnalysis implements Statistics {

    private DoubleSummaryStatistics dss = new DoubleSummaryStatistics();

    public StockAnalysis(){}

    public void setHigh(List<Stock> data){
        data.forEach(e -> dss.accept(e.getHigh()));
    }
    public void setLow(List<Stock> data){
        data.forEach(e -> dss.accept(e.getLow()));
    }
    public void setClose(List<Stock> data){
        data.forEach(e -> dss.accept(e.getClose()));
    }

    @Override
    public Long getCount() {
        return dss.getCount();
    }

    @Override
    public Double summation() {
        return dss.getSum();
    }

    @Override
    public Double getMin() {
        return dss.getMin();
    }

    @Override
    public Double average() {
        return dss.getAverage();
    }

    @Override
    public Double getMax() {
        return dss.getMax();
    }

    public void getBanner(){
        System.out.println(String.format("\n\n[+]=======================%s=====[+]\n",StockAnalysis.class));
        System.out.println("Items:\t"+getCount());
        System.out.println("Sum:\t"+summation());
        System.out.println("Average:\t"+average());
        System.out.println("Minimium:\t"+getMin());
        System.out.println("Maximium:\t"+getMax());
        System.out.println("-----------------------------------");
    }

}

