package Service;

import java.util.ArrayList;

import Data.impl.Crisps;

public class GetCrispsByWeigntService {
    
    public Crisps getProduct(ArrayList<Crisps> crispsProd, Integer weight) {
        for (Crisps item : crispsProd) {
            if (item.getWeight().equals(weight)) {
                return item;
            }
        }
        return null;
    }

    public Crisps getProduct(ArrayList<Crisps> crispsProd, String weight) {
        for (Crisps item : crispsProd) {
            if (item.getWeight().equals(Integer.valueOf(weight))) {
                return item;
            }
        }
        return null;
    }
}
