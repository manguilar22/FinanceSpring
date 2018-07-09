package guru.aguilar.finance.POJO;

import guru.aguilar.finance.interfaces.Stock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FacebookStock {

    private String timestamp;
    private List<Stock> stock;

    private Map<String,List<Stock>> map;

    // Constructor
    public FacebookStock(){}

    public void setFacebookStock(List<Stock> data){
        this.timestamp=data.get(0).getTimeStamp();
        this.stock=data;
        this.map=new HashMap<>();
    }

    public Map<String,List<Stock>> toMap(){
        this.map.put(timestamp,stock);
        return map;
    }


}
