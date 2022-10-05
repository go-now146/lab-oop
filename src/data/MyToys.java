
package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
//hỗ trợ việc nhập check
public class MyToys {

    private static Scanner sc = new Scanner(System.in);
//    static String getString;

    //hàm dùng để nhập một số nguyên đích thực 
    public static int getAnInteger(String inputMsg, String errMsg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);// mời gọi
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }

    }

    public static int getAnInteger(String inputMsg, String errorMsg,
            int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    //hàm dùng để nhập số thực đích thực 

    public static double getAnDouble(String inputMsg, String errMsg) {
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }

    }

    public static double getAnDouble(String inputMsg, String errMsg,
            double lowerbound, double upperBound) {
        if (lowerbound > upperBound) {
            double tmp = lowerbound;
            lowerbound = upperBound;
            upperBound = tmp;
        }
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerbound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errMsg);

            }
        }

    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim();//trim là xóa dấu cách
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    //ép id  nhập theo định dạng nào đó 
    public static String getId(String inputMsg, String errorMsg, String format) {
        boolean match;
        String id;
        while (true) {
            System.out.println(inputMsg); // gọi nhập
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);

            } else {
                return id;
            }

        }
    }

    public static String getYN(String inputMsg, String errorMsg, String format) {
        boolean match;
        String id;
        while (true) {
            System.out.println(inputMsg);//moi nhap
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
             if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

}


