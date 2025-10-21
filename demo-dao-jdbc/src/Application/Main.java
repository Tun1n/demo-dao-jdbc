package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== Test 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("===== Test 2: seller findByDepartment =====");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("===== Test 3: seller findAll =====");
        list = sellerDao.findAll();
        for(Seller obj: list){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("===== Test 4: seller Insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("===== Test 5: seller Update =====");
        seller = sellerDao.findById(1);
        seller.setName("Marta wayne");
        sellerDao.update(seller);
        System.out.println("Update completed! ");

    }
}