package guru.aguilar.finance.interfaces;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Stock {



    private String timeStamp;
    private String UUID;

    private Double Open;
    private Double High;
    private Double Low;
    private Double Close;
    private Double Volume;
    private Double AdjOpen;
    private Double AdjHigh;
    private Double AdjLow;
    private Double AdjClose;
    private Double AdjVolume;

    public Stock(){}

    /**
     * @param timeStamp
     * @param open
     * @param high
     * @param low
     * @param close
     * @param volume
     * @param adjOpen
     * @param adjHigh
     * @param adjLow
     * @param adjClose
     * @param adjVolume
     */
    public Stock(String timeStamp,Double open, Double high, Double low,
                 Double close, Double volume, Double adjOpen,
                 Double adjHigh, Double adjLow, Double adjClose, Double adjVolume) {

        Open = open;
        High = high;
        Low = low;
        Close = close;
        Volume = volume;
        AdjOpen = adjOpen;
        AdjHigh = adjHigh;
        AdjLow = adjLow;
        AdjClose = adjClose;
        AdjVolume = adjVolume;

        // UUID
        this.UUID= new UUID(0,1).randomUUID().toString();

        this.timeStamp=timeStamp;
    }


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Double getOpen() {
        return Open;
    }

    public void setOpen(Double open) {
        Open = open;
    }

    public Double getHigh() {
        return High;
    }

    public void setHigh(Double high) {
        High = high;
    }

    public Double getLow() {
        return Low;
    }

    public void setLow(Double low) {
        Low = low;
    }

    public Double getClose() {
        return Close;
    }

    public void setClose(Double close) {
        Close = close;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    public Double getAdjOpen() {
        return AdjOpen;
    }

    public void setAdjOpen(Double adjOpen) {
        AdjOpen = adjOpen;
    }

    public Double getAdjHigh() {
        return AdjHigh;
    }

    public void setAdjHigh(Double adjHigh) {
        AdjHigh = adjHigh;
    }

    public Double getAdjLow() {
        return AdjLow;
    }

    public void setAdjLow(Double adjLow) {
        AdjLow = adjLow;
    }

    public Double getAdjClose() {
        return AdjClose;
    }

    public void setAdjClose(Double adjClose) {
        AdjClose = adjClose;
    }

    public Double getAdjVolume() {
        return AdjVolume;
    }

    public void setAdjVolume(Double adjVolume) {
        AdjVolume = adjVolume;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "timeStamp='" + timeStamp + '\'' +
                ", UUID='" + UUID + '\'' +
                ", Open=" + Open +
                ", High=" + High +
                ", Low=" + Low +
                ", Close=" + Close +
                ", Volume=" + Volume +
                ", AdjOpen=" + AdjOpen +
                ", AdjHigh=" + AdjHigh +
                ", AdjLow=" + AdjLow +
                ", AdjClose=" + AdjClose +
                ", AdjVolume=" + AdjVolume +
                '}';
    }
}
