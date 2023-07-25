package linked_list;

import com.Items;
import java.util.Scanner;

public class LL_Items extends SLL{
    Scanner sc = null;
    public LL_Items(){
        super();
        sc = new Scanner(System.in);
    }
    public SLLNode<Items> find(String code){
        SLLNode<Items> ref;
        for(ref= this.getHead(); ref!= null; ref = ref.next)
            if(ref.info.getCode().equals(code)) return ref;
        return null;
    }
    public void add(){
        String code ="", name = ""; int price= 0, guaranty=0;
        System.out.println("Add new item");
        boolean proceed = false;
        do{
            System.out.println("Entet item's code");
            code= sc.nextLine().toUpperCase();
            proceed = find(code)!= null;
            if(proceed == true) System.out.println("This code is duplicated");
        }
        while(proceed);
        do{
            System.out.println("Enter item's name");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if(proceed == true) System.out.println("Item's name must be inputed");
        }
        while(proceed);
        do{
            System.out.println("Enter item's price");
            price = Integer.parseInt(sc.nextLine().trim());
            proceed = (price < 0);
            if(proceed == true) System.out.println("Item's price must be greater than 0");
        }
        while(proceed);
        do{
            System.out.println("Enter item's guatanty");
            guaranty = Integer.parseInt(sc.nextLine().trim());
            proceed = (guaranty < 0);
            if(proceed == true) System.out.println("Item's guaranty must be greater than 0");
        }
        while(proceed);
        Items item = new Items(code, name, price, guaranty);
        this.addToTail(item);
        System.out.println("This item is addded");
    }
    public void remove(){
        if(this.isEmpty()) System.out.println("The list is empty");
        else{
            String code = "";
            System.out.println("Enter the code of item will be removed");
            code = sc.nextLine().toUpperCase();
            SLLNode<Items> item = find(code);
            if(item == null) System.out.println("The item does not exist.");
            else{ this.delete(item);        
        }
        }
    }
    public void modifyPrice(){
        if(isEmpty()) System.out.println("The list is empty");
        else{
            String code = "";
            System.out.println("Enter the code of item need to modify");
            code = sc.nextLine().toUpperCase();
            SLLNode<Items> item = find(code);
            if(item == null) System.out.println("Item not found");
            else{
                int newPrice=0;
                int oldPrice = item.info.getPrice();
                System.out.println("Enter new price");
                newPrice = Integer.parseInt(sc.nextLine());
                item.info.setPrice(newPrice);
                System.out.println("Price has been updated");
            }
        }
    }
     public void modifyGuaranty(){
        if(isEmpty()) System.out.println("The list is empty");
        else{
            String code = "";
            System.out.println("Enter the code of item need to modify");
            code = sc.nextLine().toUpperCase();
            SLLNode<Items> item = find(code);
            if(item == null) System.out.println("Item not found");
            else{
                int newGua=0;
                int oldGua = item.info.getGuaranty();
                System.out.println("Enter new guaranty");
                newGua = Integer.parseInt(sc.nextLine());
                item.info.setPrice(newGua);
                System.out.println("Guaranty has been updated");
            }
        }
    }
    public void printAll(){
        System.out.println("Code\tName\tPrice\tGuaranty");
        super.printAll();
    }
}
