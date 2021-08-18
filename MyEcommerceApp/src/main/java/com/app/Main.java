package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.employeeService.EmployeeService;
import com.app.employeeServiceImpl.EmployeeServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		EmployeeService employeeservice = new EmployeeServiceImpl();

		Scanner sc = new Scanner(System.in);
		int option = 0;
		log.info("Welcome to Ecommerce App");
		log.info("--------------------------------------");

		do {
			log.info("\n1)For Employee\n2)For Customer");

			try {
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.warn("Must have choice as 1 or 2", e);
			}

			switch (option) {
			case 1:
				log.info("Hello employee Please Login!\n");
				log.info("Enter Employee Id:\n");
				String euserid = sc.nextLine();
				log.info("Enter password\n");
				String epass = sc.nextLine();
				if (euserid.equals("mahesh217") && epass.equals("2170@")) {
					log.info("1)Add a product into List");
					log.info("2)View All product");
					log.info("3)Delete a product from product list");
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

							Product product = new Product();
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
								if((employeeservice.deleteProduct(id))==1) {
									System.out.println("product deleted successfully");
								}
							} catch (BusinessException e) {
								System.out.println(e);
							}
							break;

						default:
							log.info("Press 1-3 for Employee Menu Again");
							break;
						}
					} while (key <= 3);
				} else {
					log.info("You are Not an employee.. if you are customer please login\n");
				}

				break;
			case 2:
				log.info("1) New User Please SignUp");
				log.info("2) Login");
				int opt=Integer.parseInt(sc.nextLine());
				switch (opt) {
				case 1:
					do {
					log.info("Enter id:");
					String newuserid=sc.nextLine();
					log.info("Enter password");
					String newuserpass=sc.nextLine();
					log.info("Reenter password");
					String newuserpass1=sc.nextLine();
					
					if(newuserid.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$"))
					{
						if(newuserpass.equals(newuserpass1)) {
							
						}else {
							log.info("Password mismatch.. ReEnter password");
						}
					}else {
						log.info("Please enter valid ");
					}
					
					
					
					
					
					break;

				default:
					break;
				}
				}while()

				break;

			default:
				log.info("Internal Problem Contact Admin");
				break;
			}
		} while (option == 1 || option == 2);
	}

}

//"^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$"
