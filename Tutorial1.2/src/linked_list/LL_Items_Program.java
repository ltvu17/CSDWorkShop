package linked_list;
import com.Menu;
public class LL_Items_Program {
    public static void main(String[] args){
        int choice=0;
        Menu menu = new Menu();
        menu.add("Add new item");
        menu.add("Remove an Item");
        menu.add("Modify item's price");
        menu.add("Modify item's guaranty");
        menu.add("Print all items");
        menu.add("Quit");
        LL_Items obj = new LL_Items();
        do{choice = menu.getUserChoice();
           switch(choice){
               case 1: obj.add();break;
               case 2: obj.remove(); break;
               case 3: obj.modifyPrice();break;
               case 4: obj.modifyGuaranty(); break;
               case 5: obj.printAll(); break;
           }
            
        }while(choice<6 && choice >0);
    }
   
}
