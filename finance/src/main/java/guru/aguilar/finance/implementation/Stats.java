package guru.aguilar.finance.implementation;

import guru.aguilar.finance.POJO.Stock;

import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class Stats {

    public Stats(){}

    public DoubleSummaryStatistics DoubleStatistics(List<Stock> data,ToDoubleFunction<Stock> mapper){
        return data.stream().collect(Collectors.summarizingDouble(mapper));
    }

    public LongSummaryStatistics LongStatistics(List<Stock> data, ToLongFunction<Stock> mapper){
        return data.stream().collect(Collectors.summarizingLong(mapper));
    }

    public Double summation(List<Stock> data, ToDoubleFunction<Stock> mapper){
        return data.stream().collect(Collectors.summingDouble(mapper));
    }

    public Double averaging(List<Stock> data, ToDoubleFunction<Stock> mapper){
        return data.stream().collect(Collectors.averagingDouble(mapper));
    }

    public Map<String,Double> getStats(List<Stock> data,ToDoubleFunction<Stock> mapper){
        Map<String, Double> map = new HashMap<>();
        map.put("Count",Double.valueOf(data.size()));
        map.put("Summation",this.summation(data,mapper));
        map.put("Average",this.averaging(data,mapper));
        return map;
    }

}