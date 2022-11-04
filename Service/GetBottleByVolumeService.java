package Service;

import java.util.ArrayList;

import Data.impl.BottleOfDrink;

public class GetBottleByVolumeService {
    public BottleOfDrink getProduct(ArrayList<BottleOfDrink> drinkProd, Double volume) {
        for (BottleOfDrink item : drinkProd) {
            if (item.getVolume().equals(volume)) {
                return item;
            }
        }
        return null;
    }

    public BottleOfDrink getProduct(ArrayList<BottleOfDrink> drinkProd, String volume) {
        for (BottleOfDrink item : drinkProd) {
            if (item.getVolume().equals(Double.valueOf(volume))) {
                return item;
            }
        }
        return null;
    }
}
