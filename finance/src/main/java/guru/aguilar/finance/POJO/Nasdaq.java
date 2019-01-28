package guru.aguilar.finance.POJO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Nasdaq {

    private Double IndexValue;
    private Double High;
    private Double Low;
    private Double TotalMarketValue;
    private Double DividendMarketValue;
    private String date;


    public Nasdaq(){}

    public Nasdaq(Double indexValue, Double high, Double low,
                  Double totalMarketValue, Double dividendMarketValue,
                  String date) {
        this.IndexValue= indexValue;
        this.High = high;
        this.Low = low;
        this.TotalMarketValue = totalMarketValue;
        this.DividendMarketValue = dividendMarketValue;
        this.date = date;
    }

    public Nasdaq fastload(String [] splitString){
        return new Nasdaq(
                Double.parseDouble(splitString[0]),
                Double.parseDouble(splitString[1]),
                Double.parseDouble(splitString[2]),
                Double.parseDouble(splitString[3]),
                Double.parseDouble(splitString[4]),
                String.valueOf(splitString[5])
        );
    }

    public Double getIndexValue() {
        return IndexValue;
    }

    public void setIndexValue(Double indeValue) {
        IndexValue = indeValue;
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

    public Double getTotalMarketValue() {
        return TotalMarketValue;
    }

    public void setTotalMarketValue(Double totalMarketValue) {
        TotalMarketValue = totalMarketValue;
    }

    public Double getDividendMarketValue() {
        return DividendMarketValue;
    }

    public void setDividendMarketValue(Double dividendMarketValue) {
        DividendMarketValue = dividendMarketValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Nasdaq{" +
                "IndexValue=" + IndexValue +
                ", High=" + High +
                ", Low=" + Low +
                ", TotalMarketValue=" + TotalMarketValue +
                ", DividendMarketValue=" + DividendMarketValue +
                ", date='" + date + '\'' +
                '}';
    }
}
