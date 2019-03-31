package guru.aguilar.finance.collections;

import guru.aguilar.finance.POJO.Stock;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collections {

    private static Function<Stock,Double> func;
    private static Predicate<Stock> predicate;

    public Collections(){}

    public void setFunc(Function<Stock,Double> toCollect){
        func = toCollect;
    }
    public void setFilter(Predicate<Stock> filter){ predicate = filter;}

    public Set<Double> toSet(List<Stock> data){
        Set<Double> set = data.stream().map(func).collect(Collectors.toSet());
        return set;
    }

    public Set<Stock> filteredSet(List<Stock> data){
        Set<Stock> set = data.stream().filter(predicate).collect(Collectors.toSet());
        return set;
    }

    public Map<?,?> toMap(List<Stock> data,Function<Stock,?> keyValue, Function<Stock,?> value){
        Map<?,?> map = data.stream().collect(Collectors.toMap(keyValue,value,(oldValue,newValue)->newValue));
        return map;
    }

    public void iterateMap(Object k, Object v) {
        System.out.println(
                String.format("Key:\t%s\tValue:\t%s",
                String.valueOf(k),
                String.valueOf(v)));
    }

}