package Service;

import java.util.ArrayList;

import Data.Product;
import Data.impl.BottleOfDrink;
import Data.impl.Chocolate;
import Data.impl.Crisps;

public class GetProductByCostService {
    public Product getProduct(ArrayList<Chocolate> chocolateProd, 
                                ArrayList<BottleOfDrink> drinkProd, 
                                ArrayList<Crisps> crispsProd, 
                                Double keyWord) {
        for (Product item : chocolateProd) {
            if (item.getCost().equals(keyWord)) {
                return item;
            }
        }
        for (Product item : drinkProd) {
            if (item.getCost().equals(keyWord)) {
                return item;
            }
        }
        for (Product item : crispsProd) {
            if (item.getCost().equals(keyWord)) {
                return item;
            }
        }
        return null;
    }
}
