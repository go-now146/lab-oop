/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import data.FoodShelf;
import menu.Menu;

/**
 *
 * @author Admin
 */
public class Program {

    public static void main(String[] args) {
        Menu menu = new Menu(" Food Management - @2021 by SE150874 - Ngo Thi Kim Loan");
        menu.addNewOption("1. Add a new food");
        menu.addNewOption("2. Search a food by name ");
        menu.addNewOption("3. Remove the food by ID");
        menu.addNewOption("4. Print the food list in the descending order of expired date");
        menu.addNewOption("5. Store file");
        menu.addNewOption("6. Quit");
        FoodShelf fs = new FoodShelf();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    fs.addFood();
                    break;
                }
                case 2: {
                    fs.searchByName();
                    break;
                }
                case 3: {
                    fs.removeByID();
                    break;
                }
                case 4: {
                    fs.printListFood();
                    break;
                }
                case 5: {
                    fs.storeFile();
                    break;
                }
                case 6: {
                    System.out.println("Goodbye!!! See you next time");
                    break;
                }
            }
        } while (choice != 6);
    }

}
