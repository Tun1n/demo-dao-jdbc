package Application;


import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "um");
        System.out.println(obj);

        Seller sel = new Seller(21, "Bob","bob@gmail.com", new Date(), 3000.0, obj);
        System.out.println(sel);
    }
}