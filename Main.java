import java.io.FileWriter;
import java.util.logging.Logger;

import Controller.VendingMashine;

public class Main {
    public static void main(String[] args) {
        logging("Alenka");
        logging("Lindt");
        logging("Cone forest");
        logging("Moscow potatoes");
        logging("black");
        logging("120");
        logging("0.5");
        logging(90);
        logging(22.5);
        logging(17.5);
        logging(9.5);
    }

    public static void logging (String content) {
        VendingMashine vm = new VendingMashine();
        Logger logger = Logger.getAnonymousLogger();
        
        try {
            FileWriter write = new FileWriter("log.txt", true);

            if (vm.getProductByName(content) == null) {
                if (vm.getByType(content) == null) {
                    if (isNumber(content)) {
                        if (vm.getByWeight(content) == null) {
                            write.write(String.valueOf(vm.getByType(content)) + "\n");
                        } else if (vm.getByWeight(content) != null) {
                            write.write(String.valueOf(vm.getByWeight(content)) + "\n");
                        } 
                    } else if (isDouble(content)) {
                        if (vm.getByVolume(content) == null) {
                            write.write(String.valueOf(vm.getByType(content)) + "\n");
                        } else if (vm.getByVolume(content) != null) {
                            write.write(String.valueOf(vm.getByVolume(content)) + "\n");
                        }
                    } else {
                        write.write(String.valueOf(vm.getByType(content)) + "\n");
                    }
                } else {
                    write.write(String.valueOf(vm.getByType(content)) + "\n");
                }
            } else {
                write.write(String.valueOf(vm.getProductByName(content)) + "\n");
            }       
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }   
        
    }

    public static void logging(Double content) {
        VendingMashine vm = new VendingMashine();
        Logger logger = Logger.getAnonymousLogger();

        try {
            FileWriter write = new FileWriter("log.txt", true);
            if (vm.getProductByCost(content) == null) {
                if (vm.getByVolume(content) == null) {
                    write.write(String.valueOf(vm.getByVolume(content)) + "\n");
                } else {
                    write.write(String.valueOf(vm.getByVolume(content)) + "\n");
                }
            } else {
                write.write(String.valueOf(vm.getProductByCost(content)) + "\n");
            }
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        } 
    }

    public static void logging(Integer content) {
        VendingMashine vm = new VendingMashine();
        Logger logger = Logger.getAnonymousLogger();
        
        try {
            FileWriter write = new FileWriter("log.txt", true);
            if (vm.getByWeight(content) == null) {
                write.write(String.valueOf(vm.getByWeight(content)) + "\n");
            } else {
                write.write(String.valueOf(vm.getByWeight(content)) + "\n");
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
