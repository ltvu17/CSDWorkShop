package linked_list;

import com.Employee;
import java.util.Scanner;

public class LL_EmpList extends DLL {
    Scanner sc = null;
    public LL_EmpList(){
        super();
        sc = new Scanner(System.in);
    }
    private DLLNode<Employee> find(String code){
        DLLNode<Employee> ref ;
        if(this.isEmpty()){
            return null;
        }
        for(ref = this.getHeader(); ref != null; ref=ref.next){
                if(ref.info != null && ref.info.getCode().equals(code)) return ref;
        }
        return null;
    }
    public void add(){
        String code="", name; int salary=0;
        System.out.println("Add new employee");
        boolean proceed = false;
        do{
            System.out.println("Enter employee's code");
            code = sc.nextLine().toUpperCase();
            proceed= find(code)!= null;
            if(proceed == true) System.out.println("This code is duplicated");
        }
        while (proceed);
        do{
            System.out.println("Enter employee's name:");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if(proceed == true) System.out.println("Employee's name must be inputted");
        }while (proceed);
        do{
            System.out.println("Enter emplpyee's salary:");
            salary = Integer.parseInt(sc.nextLine());
            if(salary<=0) System.out.println("Employee's salary must be greater than 0.");
        }while (salary<=0);
        Employee emp = new Employee(code, name, salary);
        this.addLast(emp);
        System.out.println("This employee is added");
    }
    public void remove(){
        if(this.isEmpty()) System.out.println("The list is empty");
        else{
            String code = "";
            System.out.println("Enter the code of employee who will be removed");
            code = sc.nextLine().toUpperCase();
            DLLNode<Employee> ref = find(code);
            if(ref == null) System.out.println("He/She does not exist");
            else{
                this.remove(ref);
                System.out.println("This employee has been removed");
            }
        }
    }
    public void increaseSalary(){
        if(this.isEmpty()) System.out.println("The lsit is empty.");
        else{
            String code = "";
            System.out.println("Enter the code of employee who will be promoted:");
            code = sc.nextLine().toUpperCase();
            DLLNode<Employee> ref = find(code);
            if(ref == null) System.out.println("He/She does not exist");
            else{
                int oldSal = ref.info.getSalary();
                int newSal;
                do{
                    System.out.println("Old salary" + oldSal + ", new salary:");
                    newSal = Integer.parseInt(sc.nextLine());
                }
                while(newSal <= oldSal);
                ref.info.setSalary(newSal);
                System.out.println("His/Her salary has been updated");
            }
        }
    }
    public void print(){
        if(this.isEmpty()) System.out.println("empty");
        else {System.out.println("EMPLOYEE LIST");
             this.printAll();
        }
    }
}
