package guru.aguilar.finance.collections;

import guru.aguilar.finance.POJO.Stock;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MakeSet {

    private static Function<? super Stock, ? extends Double> func;

    public MakeSet(){}

    public void setFunc(Function<? super Stock, ? extends Double> toCollect){
        func = toCollect;
    }

    public Set<Double> toSet(List<Stock> data){
        Set<Double> set = data.stream().map(func).collect(Collectors.toSet());
        return set;
    }
}