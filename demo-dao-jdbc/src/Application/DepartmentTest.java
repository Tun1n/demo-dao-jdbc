package Application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DepartmentTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== Department findAll");
        List<Department> list = departmentDao.findAll();
        for(Department dep : list){
            System.out.println(dep);
        }

        System.out.println();

        System.out.println("===== Department findById =====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println();

        System.out.println("===== Department Insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println();

        System.out.println("===== Department Update =====");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println();

        System.out.println("===== Department Delete =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();


    }
}
