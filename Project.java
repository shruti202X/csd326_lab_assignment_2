import java.util.*;

class Employee {
    String employeeID;
    String name;
    int age;
    int salary;

    Employee(String employeeID, String name, int age, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return employeeID + " " + name + " " + age + " " + salary;
    }
}

class EmployeeTable {
    private List<Employee> employees;

    public EmployeeTable(List<Employee> employees) {
        this.employees = employees;
    }

    public void sortByAge() {
        employees.sort(Comparator.comparingInt(Employee::getAge));
    }

    public void sortByName() {
        employees.sort(Comparator.comparing(Employee::getName));
    }

    public void sortBySalary() {
        employees.sort(Comparator.comparingInt(Employee::getSalary));
    }

    public void printData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

public class Project {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("161E90", "Ramu", 35, 59000),
                new Employee("171E22", "Tejas", 30, 82100),
                new Employee("171G55", "Abhi", 25, 100000),
                new Employee("152K46", "Jaya", 32, 85000)
        );

        EmployeeTable employeeTable = new EmployeeTable(employeeList);

        Scanner scan = new Scanner(System.in);

        System.out.println("|S.No.| Sort by     |");
        System.out.println("---------------------");
        System.out.println("|  1  | Age         |");
        System.out.println("|  2  | Name        |");
        System.out.println("|  3  | Salary      |");
        System.out.println("---------------------");
        System.out.print("Enter S.No. of attribute to sort employee's: ");
        int op = scan.nextInt();
        scan.nextLine();
        if(op == 1){
            employeeTable.sortByAge();
            employeeTable.printData();
        }else if(op == 2){
            employeeTable.sortByName();
            employeeTable.printData();
        }else if(op == 3){
            employeeTable.sortBySalary();
            employeeTable.printData();
        }else{
            System.out.println("Wrong S.No. entered.");
        }
        scan.close();
    }
}
