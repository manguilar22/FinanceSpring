package guru.aguilar.finance.interfaces;


import java.io.File;
import java.io.IOException;

public interface StockRead{

    public void setFile(String fileName) throws Exception;

    public File getFile();

}