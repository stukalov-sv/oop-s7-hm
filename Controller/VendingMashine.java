package Controller;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

import Data.Product;

import Data.impl.Chocolate;
import Data.impl.BottleOfDrink;
import Data.impl.Crisps;
import Service.GetBottleByVolumeService;
import Service.GetChocolateByTypeService;
import Service.GetCrispsByWeigntService;
import Service.GetProductByCostService;
import Service.GetProductByNameService;

public class VendingMashine {
    static ArrayList<Chocolate> chocolateProd = new ArrayList<>();
    static ArrayList<BottleOfDrink> drinkProd = new ArrayList<>();
    static ArrayList<Crisps> crispsProd = new ArrayList<>();

    static GetProductByNameService gpbns = new GetProductByNameService();
    static GetProductByCostService gpbcs = new GetProductByCostService();
    static GetChocolateByTypeService gcbts = new GetChocolateByTypeService();
    static GetBottleByVolumeService gbbvs = new GetBottleByVolumeService();
    static GetCrispsByWeigntService gcbws = new GetCrispsByWeigntService();

    public VendingMashine() {
        chocolateProd.add(new Chocolate("Lindt", 1l, 20.5, "black"));
        chocolateProd.add(new Chocolate("Alpen Gold", 2l, 17.5, "milk"));
        drinkProd.add(new BottleOfDrink("Bonaqua", 3l, 12.5, 0.5));
        drinkProd.add(new BottleOfDrink("Cone forest", 4l, 9.5, 0.4));
        crispsProd.add(new Crisps("Pringles", 5l, 22.5, 120));
        crispsProd.add(new Crisps("Moscow potatoes", 6l, 15.5, 90));
    }  

    public static void logging (String content) {
        Logger logger = Logger.getAnonymousLogger();
        
        try {
            FileWriter write = new FileWriter("log.txt", true);
    
            if (gpbns.getProduct(chocolateProd, drinkProd, crispsProd, content) == null) {
                if (gcbts.getProduct(chocolateProd, content) == null) {
                    if (isNumber(content)) {
                        if (gcbws.getProduct(crispsProd, content) == null) {
                            write.write(gcbts.getProduct(chocolateProd, content) + "\n");
                        } else if (gcbws.getProduct(crispsProd, content) != null) {
                            write.write(String.valueOf(gcbws.getProduct(crispsProd, content)) + "\n");
                        } 
                    } else if (isDouble(content)) {
                        if (gbbvs.getProduct(drinkProd, content) == null) {
                            write.write(String.valueOf(gbbvs.getProduct(drinkProd, content)) + "\n");
                        } else if (gbbvs.getProduct(drinkProd, content) != null) {
                            write.write(String.valueOf(gbbvs.getProduct(drinkProd, content)) + "\n");
                        }
                    } else {
                        write.write(String.valueOf(gcbts.getProduct(chocolateProd, content)) + "\n");
                    }
                } else {
                    write.write(String.valueOf(gcbts.getProduct(chocolateProd, content)) + "\n");
                }
            } else {
                write.write(String.valueOf(gpbns.getProduct(chocolateProd, drinkProd, crispsProd, content)) + "\n");
            }       
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }   
        
    }
    
    public static void logging(Double content) {
        Logger logger = Logger.getAnonymousLogger();

        try {
            FileWriter write = new FileWriter("log.txt", true);
            if (gpbcs.getProduct(chocolateProd, drinkProd, crispsProd, content) == null) {
                if (gbbvs.getProduct(drinkProd, content) == null) {
                    write.write(String.valueOf(gbbvs.getProduct(drinkProd, content)) + "\n");
                } else {
                    write.write(String.valueOf(gbbvs.getProduct(drinkProd, content)) + "\n");
                }
            } else {
                write.write(String.valueOf(gpbcs.getProduct(chocolateProd, drinkProd, crispsProd, content)) + "\n");
            }
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        } 
    }
    
    public static void logging(Integer content) {
        Logger logger = Logger.getAnonymousLogger();
        
        try {
            FileWriter write = new FileWriter("log.txt", true);
            if (gcbws.getProduct(crispsProd, content) == null) {
                write.write(String.valueOf(gcbws.getProduct(crispsProd, content)) + "\n");
            } else {
                write.write(String.valueOf(gcbws.getProduct(crispsProd, content)) + "\n");
            }
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }
    }
    
    private static boolean isNumber(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static boolean isDouble(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
