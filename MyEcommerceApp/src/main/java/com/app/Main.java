package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.UserService.UserService;
import com.app.UserServiceImpl.UserServiceImpl;
import com.app.employeeService.EmployeeService;
import com.app.employeeServiceImpl.EmployeeServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.model.User;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		EmployeeService employeeservice = new EmployeeServiceImpl();
		UserService userservice = new UserServiceImpl();
		Product product = new Product();

		Scanner sc = new Scanner(System.in);
		int option = 0;
		log.info("Welcome to Ecommerce App");
		log.info("-------------------------");

		log.info("\n1)For Employee\n2)Customer Register\n3)Customer Login\n4)Exit");

		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			log.warn("Must have choice as 1-4", e);
		}

		switch (option) {
		case 1:
			log.info("Hello Mahesh Please Login!\n");
			log.info("Enter Employee Id:\n");
			String euserid = sc.nextLine();
			log.info("Enter password\n");
			String epass = sc.nextLine();
			if (euserid.equals("mahesh217") && epass.equals("2170@")) {
				log.info("1)Add a product into List");
				log.info("2)View All product");
				log.info("3)Delete a product from product list");
				log.info("4)View Users");
				int key = 0;
				do {
					try {
						key = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						log.warn("Must have choice as 1-3", e);
					}
					switch (key) {
					case 1:
						log.info("Add details about the product");

						
						// mahesh id is auto generated dont be fool as always
						log.info("Enter Product Name");
						product.setPname(sc.nextLine());
						log.info("Enter Product Cost");
						product.setCost(Double.parseDouble(sc.nextLine()));
						try {
							if (employeeservice.createProduct(product) == 1)
								System.out.println("Product added successfully");
							System.out.println(product);

						} catch (BusinessException e) {
							log.warn("Product Not Created:", e);
						}

						break;
					case 2:
						log.info("View All Products ");
						try {
							List<Product> productlist = employeeservice.getAllProduct();
							System.out.println("List of Products");
							for (Product product1 : productlist) {
								System.out.println(product1);
							}
						} catch (BusinessException e) {
							log.info(e);

						}
						break;
					case 3:

						System.out.println("Enter a product id to delete");
						int id = Integer.parseInt(sc.nextLine());
						try {
							if ((employeeservice.deleteProduct(id)) == 1) {
								System.out.println("product deleted successfully");
							}
						} catch (BusinessException e) {
							System.out.println(e);
						}
						break;
					case 4:
						System.out.println("Users are:");
						try {
							List<User> user=userservice.getAllUser(); 
							for (User user2 : user) {
								System.out.println(user2);
							}
						} catch (BusinessException e) {
							log.info(e);

						}
					default:
						log.info("Press 1-4 for Employee Menu Again");
						break;
					}
				} while (key <= 3);
			} else {
				log.info("You are Not an employee.. if you are customer please login\n");
			}

			break;
		case 2:
			log.info("Enter Email");
			String email = sc.nextLine();
			log.info("Enter FirstName");
			String fname = sc.nextLine();
			log.info("Enter lastName");
			String lname = sc.nextLine();
			log.info("Enter password");
			String newuserpass = sc.nextLine();
			if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$")) {
				User user = new User();
				// mahesh id is auto generated dont be fool as always
				user.setUserEmail(email);
				user.setFname(fname);
				user.setLname(lname);
				user.setUserpass(newuserpass);

				try {
					if (userservice.createUser(user) == 1)
						System.out.println("User added successfully");
					System.out.println(user);

				} catch (BusinessException e) {
					log.warn("You have registered Earlier Please login");
				}

				log.info("What You Like to do Today");
				log.info("1.Do Shopping ");
				log.info("2.View Your Cart");
				int opt1 = 0;
				try {
					opt1 = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					log.warn(e);
				}
				switch (opt1) {
				case 1:
					log.info("View All Products ");
					try {
						List<Product> productlist = employeeservice.getAllProduct();
						System.out.println("List of Products");
						for (Product product1 : productlist) {
							System.out.println(product1);
						}
					} catch (BusinessException e) {
						log.info(e);

					}

					break;

				default:
					break;
				}

			} else {
				log.info("Please enter valid email");
			}

			break;

		default:
			break;
		}

		// break;
		// default:log.info("Internal Problem Contact Admin");
		// break;
	}
}
