import com.perscholas.controller.EmployeeController;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");

        EmployeeController e = new EmployeeController();
        e.showOfficeCodes_AsDepartment();
    }
}
