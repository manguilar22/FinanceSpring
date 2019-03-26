package guru.aguilar.finance.implementation;

import guru.aguilar.finance.POJO.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Stats {

    private static ToDoubleFunction<? super Stock> mapper;

    public Stats(){}

    public DoubleSummaryStatistics DoubleStatistics(List<Stock> data,ToDoubleFunction<? super Stock> mapper){
        return data.stream().collect(Collectors.summarizingDouble(mapper));
    }

    }