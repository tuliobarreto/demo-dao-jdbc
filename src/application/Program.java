package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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
	}
}