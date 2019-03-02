package guru.aguilar.finance.POJO;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class Stock {

    private Double open; 
    private Double close; 
    private Double high; 
    private Double low; 
    private Double volume; 
    private Double adjOpen; 
    private Double adjClose; 
    private Double adjHigh; 
    private Double adjLow; 
    private Double adjVolume; 
    private String date; 


    public Stock(){ }

    public Stock(Double open, Double close, Double high, Double low, Double volume, Double adjOpen, Double adjClose, Double adjHigh, Double adjLow, Double adjVolume, String date) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.adjOpen = adjOpen;
        this.adjClose = adjClose;
        this.adjHigh = adjHigh;
        this.adjLow = adjLow;
        this.adjVolume = adjVolume;
        this.date = date;
    }

    public Stock fastload(String [] stock){
        return new Stock(
                Double.parseDouble(stock[0]),
                Double.parseDouble(stock[1]),
                Double.parseDouble(stock[2]),
                Double.parseDouble(stock[3]),
                Double.parseDouble(stock[4]),
                Double.parseDouble(stock[5]),
                Double.parseDouble(stock[6]),
                Double.parseDouble(stock[7]),
                Double.parseDouble(stock[8]),
                Double.parseDouble(stock[9]),
                stock[10]);
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAdjOpen() {
        return adjOpen;
    }

    public void setAdjOpen(Double adjOpen) {
        this.adjOpen = adjOpen;
    }

    public Double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(Double adjClose) {
        this.adjClose = adjClose;
    }

    public Double getAdjHigh() {
        return adjHigh;
    }

    public void setAdjHigh(Double adjHigh) {
        this.adjHigh = adjHigh;
    }

    public Double getAdjLow() {
        return adjLow;
    }

    public void setAdjLow(Double adjLow) {
        this.adjLow = adjLow;
    }

    public Double getAdjVolume() {
        return adjVolume;
    }

    public void setAdjVolume(Double adjVolume) {
        this.adjVolume = adjVolume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                ", adjOpen=" + adjOpen +
                ", adjClose=" + adjClose +
                ", adjHigh=" + adjHigh +
                ", adjLow=" + adjLow +
                ", adjVolume=" + adjVolume +
                ", date='" + date + '\'' +
                '}';
    }

}
