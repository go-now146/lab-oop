package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class FoodShelf {

    private ArrayList<Food> listFood = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public void addFood() {
        String id, name, type, location, expiredDate;
        double weight;
        int pos ;
        String check;
        do {
            do {
                id = MyToys.getId("Plss, input ID:", "Wrong format must be FXXX", "^[F|f]\\d{3}$").toUpperCase();
                pos = searchByID(id);
                if (pos >= 0) {
                    System.out.println("The ID duplicated!" + "Input another one:");
                }
            } while (pos != -1);
            name = MyToys.getString("Plss, input name:", "Wrong format !!! Input again");
            type = MyToys.getString("Plss, input type: ", "wrong!! Input again");
            weight = MyToys.getAnDouble("Plss, input weight: ", "wrong!! Input again");
            location = MyToys.getString("Plss, input location: ", "Wrong !!! Input again");
            do {
                while (true) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    expiredDate = MyToys.getString("Input day of expired date(Format: yyyy/MM/dd): ",
                            "The format of day of sale is yyyy/MM/dd");
                    sdf.setLenient(false);
                    try {
                        sdf.parse(expiredDate);
                        break;
                    } catch (ParseException e) {
                        System.out.println("Invalid date");
                    }
                }
            } while (expiredDate.length() != 10);
            listFood.add(new Food(id, name, type, weight, location, expiredDate));
            System.out.println("The food is add successfully!");
            check = MyToys.getYN("Do you want to input another Food ??",
                    "Just inpyt Y/N !!", "^Y|N$");
        } while (!check.equalsIgnoreCase("N"));
    }

    public int searchByID(String id) {
        if (listFood.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void searchByName() {
        String name;
        int count = 0;
        String check;
        if (listFood.isEmpty()) {
            System.out.println("THE LIST IS EMPTY");
//            return;
        } else {
            do {
                name = MyToys.getString("Input name food you want to search: ", "Plss, input the name: ");
                for (int i = 0; i < listFood.size(); i++) {
                    if (listFood.get(i).getName().contains(name))  {//bao gồm
                        listFood.get(i).printFood();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("The food does not exist ");
                }
                check = MyToys.getYN("Do you want to find another Food ??",
                        "Just inpyt Y/N !!", "^Y|N$");

            } while (!check.equalsIgnoreCase("N"));
        }
    }

    public void removeByID() {
        String id;
        String check;
        int pos;
        id = MyToys.getString("Plss, input FoodID you want to remove: ", "Wrong!! Input again");
        pos = searchByID(id);
        System.out.println("--------------------------------------");
        if (pos == -1) {
            System.out.println("Not found");
        } else {
            do {
                check = MyToys.getYN( "Do you want to remove Food: ", "Just input Y|N !!", "^Y|N$");
                if ( check.equalsIgnoreCase("Y")) {
                    listFood .remove(pos);
                    System.out.println("Remove sucessfully");
                } else {
                    if (check.equalsIgnoreCase( "N")) {
                        listFood.remove(pos);
                        System.out.println("Remove failure");
                    }
                }
                
            }while ( check.equalsIgnoreCase("Y|N"));
        }
        
    }
    
    public void printListFood() {
        if (listFood.isEmpty()) {
            System.out.println("THE LIST IS EMPTY NOTHING TO PRINT");
            return;
        }
        Comparator date = new Comparator <Food> () {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpiredDate().compareTo(o1.getExpiredDate());
            }
        };
        Collections.sort(listFood, date);
        System.out.println("-----------------------------------");
        System.out.println("Here is the List Food");
        for(Food o : listFood) {
            o.printFood();
        }    
    }
    public void storeFile() {
        if( listFood.isEmpty()) {
            System.out.println(" THE LIST IS EMPTY");
        } else {
            String fileName;
            fileName = MyToys.getString("Plsss, Input the File Name: ", "Your input sucessful !!");
            try {
                FileWriter fw = new FileWriter ( fileName + "file.txt");
                BufferedWriter  bw = new BufferedWriter(fw);
                for( Food x: listFood) {
                    bw.write(x.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();        
            }catch (Exception e) {
                System.out.println("Failure !!");
                
            }
        }
    }
}
