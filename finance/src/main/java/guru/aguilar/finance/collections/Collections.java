package guru.aguilar.finance.collections;

import guru.aguilar.finance.POJO.Stock;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collections {

    private static Function<? super Stock, ? extends Double> func;
    private static Predicate<? super Stock> predicate;

    public Collections(){}

    public void setFunc(Function<? super Stock, ? extends Double> toCollect){
        func = toCollect;
    }
    public void setFilter(Predicate<? super Stock> filter){ predicate = filter;}

    public Set<Double> toSet(List<Stock> data){
        Set<Double> set = data.stream().map(func).collect(Collectors.toSet());
        return set;
    }

    public Set<Stock> filteredSet(List<Stock> data){
        Set<Stock> set = data.stream().filter(predicate).collect(Collectors.toSet());
        return set;
    }

}