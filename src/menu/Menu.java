
package menu;

import data.MyToys;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList<>();
    
    public Menu (String menuTitle){
        this.menuTitle = menuTitle;
        
    } 
    public void addNewOption(String newOption){
        optionList.add(newOption);
        
    }
    public void printMenu(){
        if( optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
       }
        System.out.println("-----------------------------");
        System.out.println("Welcom to " + menuTitle);
        for(String o : optionList) {
            System.out.println(o);
        }
  
    }
    public int getChoice(){
        int maxOption = optionList.size();
        String inputMsg = "Choose[1......"+maxOption+"]";
        String errorMsg = "You are required to choose the option 1..." + maxOption;
        return MyToys.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
}
