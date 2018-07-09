package guru.aguilar.finance.imple;

import guru.aguilar.finance.interfaces.Statistics;
import guru.aguilar.finance.interfaces.Stock;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StockAnalysis implements Statistics {

    private DoubleSummaryStatistics dss = new DoubleSummaryStatistics();

    public StockAnalysis(){}


    public void setMarketData(List<Stock> data,Consumer<Stock> c){
        data.forEach(c);
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
}

