package guru.aguilar.finance.imple;

import guru.aguilar.finance.POJO.Nasdaq;
import java.util.Comparator;

public class Sort implements Comparator<Nasdaq>{

        @Override
        public int compare(Nasdaq a , Nasdaq b){
            return 0;
        }

        public static int IndexValueAscending(Nasdaq a, Nasdaq b) {
            return Double.compare(a.getIndexValue(),b.getIndexValue());
        }

        public static int IndexValueDescending(Nasdaq a, Nasdaq b) {
        return Double.compare(b.getIndexValue(),a.getIndexValue());
        }

}


