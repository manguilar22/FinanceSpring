package guru.aguilar.finance.POJO;

import guru.aguilar.finance.interfaces.StockRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    @Override
    public List<Stock> getStock() throws Exception {
        List<Stock> data = new ArrayList<>();
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String[] stock = in.nextLine().split(",");
            data.add(new Stock().fastload(stock));
        }
        in.close();
        return data;
    }


}
