package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/*Department obj = new Department(1, "Books");
		System.out.println(obj);
		System.out.println("==========================");
		System.out.println("==========================");
		Seller seller = new Seller(21, "Bob", 
			"bob@gmail", new Date(), 
			3000.0, obj);
		System.out.println(seller);
		*/
		SellerDao sellerDao = DaoFactory.creatSellerDao();

		System.out.println("\n\n==== TESTE 1: seller fidById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n\n==== TESTE 2: seller fidByIdDepartmentId ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list){
			System.out.println(obj);
		}

		System.out.println("\n\n==== TESTE 3: seller fidAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list){
			System.out.println(obj);
		}

		System.out.println("\n\n==== TESTE 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", 
					"greg@gamil.com", 
					new Date(), 4000.0, dep
				);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());


		System.out.println("\n\n==== TESTE 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}