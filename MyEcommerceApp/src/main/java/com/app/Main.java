package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.CartUserService.CartUserService;
import com.app.CartUserServiceImpl.CartUserServiceImpl;
import com.app.GetProductbyidDAO.GetProductbyidDAO;
import com.app.GetProductbyidDAOImpl.GetProductbyidDAOImpl;
import com.app.UserService.UserService;
import com.app.UserServiceImpl.UserServiceImpl;
import com.app.employeeService.EmployeeService;
import com.app.employeeServiceImpl.EmployeeServiceImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;
import com.app.model.User;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		EmployeeService employeeservice = new EmployeeServiceImpl();
		UserService userservice = new UserServiceImpl();
		Product product = new Product();
		CartUserService cartuserservice = new CartUserServiceImpl();
		GetProductbyidDAO getproductbyiddao = new GetProductbyidDAOImpl();

		Scanner sc = new Scanner(System.in);
		int option = 0;
		log.info("Welcome to Ecommerce App");
		log.info("-------------------------");
		do {
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
								List<User> user = userservice.getAllUser();
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

					user.setUserEmail(email);
					user.setFname(fname);
					user.setLname(lname);
					user.setUserpass(newuserpass);

					try {
						if (userservice.createUser(user) == 1) {
							System.out.println("User added successfully.. Please login");
							System.out.println(user);
						} else {
							log.info("You have registered Earlier Please login");
						}

					} catch (BusinessException e) {
						log.warn(e);
					}

					break;
				}
			case 3:
				log.info("Please Enter UserId");
				String userid = sc.nextLine();
				log.info("Enter Password:");
				String str2 = sc.nextLine();
				User user = new User();
				try {
					if (userservice.checkLogin(userid) == 1) {
						log.info("------Welcome-----");
						int option1 = 0;
						do {
							log.info("1. View Products");
							log.info("2. Add product into cart");
							log.info("3. View Cart");

							try {
								option1 = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Choose Integer Only between 1-3");
							}
							switch (option1) {
							case 1:
								log.info("Products are-");
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
							case 2:
								log.info("Select Product Id to add product into cart");
								int id = 0;
								Cart cart = new Cart();

								try {
									id = Integer.parseInt(sc.nextLine());

									cart.setUsername(userid);
									cart.setProduct(getproductbyiddao.getProductById(id));
									if (cartuserservice.insertintocart(id, userid) == 1) {
										log.info("Product added into cart");
										System.out.println(cart);
									}
								} catch (BusinessException e) {
									log.info(e);

								}

							default:
								break;
							}

						} while (option1 != 4);
					} else {
						log.info("User Id doesnot exist Please Register");
					}
				} catch (BusinessException e) {
					log.warn(e);
				}
				break;
			default:
				log.info("Internal Problem Occured Please contact admin");
				break;
			}
		} while (option != 4);
	}
}
