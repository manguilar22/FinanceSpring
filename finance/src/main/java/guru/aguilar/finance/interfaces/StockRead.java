package guru.aguilar.finance.interfaces;

import guru.aguilar.finance.POJO.Stock;

import java.io.File;
import java.util.List;

public interface StockRead {

    public void setFile(String fileName) throws Exception;

    public File getFile();

    public List<Stock> getStock() throws Exception;
}
