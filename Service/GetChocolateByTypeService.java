package Service;

import java.util.ArrayList;

import Data.impl.Chocolate;

public class GetChocolateByTypeService {
    public Chocolate getProduct(ArrayList<Chocolate> chocolateProd, String keyWord) {
        for (Chocolate item : chocolateProd) {
            if (item.getType().equals(keyWord)) {
                return item;
            }
        }
        return null;
    }
}
