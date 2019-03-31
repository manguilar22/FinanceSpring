package guru.aguilar.finance.implementation;

import guru.aguilar.finance.POJO.Stock;

import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class Stats {

    public Stats(){}

    public DoubleSummaryStatistics DoubleStatistics(List<Stock> data,ToDoubleFunction<? super Stock> mapper){
        return data.stream().collect(Collectors.summarizingDouble(mapper));
    }

    public LongSummaryStatistics LongStatistics(List<Stock> data, ToLongFunction<Stock> mapper){
        return data.stream().collect(Collectors.summarizingLong(mapper));
    }

    public Double summation(List<Stock> data, ToDoubleFunction<Stock> mapper){
        return data.stream().collect(Collectors.summingDouble(mapper));
    }

}