package guru.aguilar.finance.POJO;

import guru.aguilar.finance.interfaces.Stock;
import guru.aguilar.finance.interfaces.StockRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Scope("prototype")
public class ReadFile  implements StockRead,ResourceLoaderAware {

    @Autowired
    private ResourceLoader resourceLoader;

    private String fileName;

    private File file;

    public ReadFile(String fileName){
        this.fileName=fileName;
    }

    public ReadFile(){}

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }

    @Override
    public void setFile(String fileName) throws Exception{
        this.file=resourceLoader.getResource(fileName).getFile();
    }

    @Override
    public File getFile() {
        return file;
    }


    /**
     *
     * @return Get Stock Data
     * @throws Exception
     */
    public List<Stock> getStock() throws Exception {
        List<Stock> data = new ArrayList<>();
        Scanner in = new Scanner(file);
        String ts=String.valueOf(in.nextLine());
        System.out.println("TimeStamp:\t"+ts);
        while (in.hasNext()) {
            String [] stock = in.nextLine().split(",");
            data.add(new Stock(
                    ts,
                    Double.parseDouble(stock[0]),
                    Double.parseDouble(stock[1]),
                    Double.parseDouble(stock[2]),
                    Double.parseDouble(stock[3]),
                    Double.parseDouble(stock[4]),
                    Double.parseDouble(stock[5]),
                    Double.parseDouble(stock[6]),
                    Double.parseDouble(stock[7]),
                    Double.parseDouble(stock[8]),
                    Double.parseDouble(stock[9])));
        }
        in.close();
        return data;
    }



}
