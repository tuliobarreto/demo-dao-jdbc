package application;

import java.util.Date;

import model.dao.DaoFactory;
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
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
	}
}