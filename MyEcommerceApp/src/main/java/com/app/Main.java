package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.app.CartUserService.CartUserService;
import com.app.CartUserServiceImpl.CartUserServiceImpl;
import com.app.EmployeeDAO.EmployeeDAO;
import com.app.EmployeeDAOImpl.EmployeeDAOImpl;
import com.app.GetProductbyidDAO.GetProductbyidDAO;
import com.app.GetProductbyidDAOImpl.GetProductbyidDAOImpl;
import com.app.UserDAO.UserDAO;
import com.app.UserDAOImpl.UserDAOImpl;
import com.app.UserOrderDAO.UserOrderDAO;
import com.app.UserOrderDAOImpl.UserOrderDAOImpl;
import com.app.UserOrderService.UserOrderService;
import com.app.UserOrderServiceImpl.UserOrderServiceImpl;
import com.app.UserSearchDAO.UserSearchDAO;
import com.app.UserSearchDAOImpl.UserSearchDAOImpl;
import com.app.UserService.UserService;
import com.app.UserServiceImpl.UserServiceImpl;
import com.app.employeeService.EmployeeService;
import com.app.employeeServiceImpl.EmployeeServiceImpl;
import com.app.exception.BusinessException;
import com.app.logincredentials.Logincredentials;
import com.app.model.Cart;
import com.app.model.Order;
import com.app.model.Product;
import com.app.model.User;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		EmployeeService employeeservice = new EmployeeServiceImpl();
		UserService userservice = new UserServiceImpl();

		CartUserService cartuserservice = new CartUserServiceImpl();
		GetProductbyidDAO getproductbyiddao = new GetProductbyidDAOImpl();
		UserOrderService userorderservice = new UserOrderServiceImpl();
		UserOrderDAO userorderdao = new UserOrderDAOImpl();
		UserSearchDAO usersearchdao = new UserSearchDAOImpl();
		EmployeeDAO employeedao=new EmployeeDAOImpl();

		Scanner sc = new Scanner(System.in);
		int option = 0;
		log.info("Welcome to Ecommerce Console based Shopping Application\n");
		log.info("----------------------------------------------------------");
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
				if (Logincredentials.EmployeeLogin(euserid, epass)) {
					log.info("\n1)Add a product into List");
					log.info("2)View All product");
					log.info("3)Delete a product from product list");
					log.info("4)View Users");
					log.info("5)Process Orders by userid and cartid");
					int key = 0;
					do {
						try {
							key = Integer.parseInt(sc.nextLine());
						} catch (NumberFormatException e) {
							log.warn("Must have choice as 1-3", e);
						}
						switch (key) {
						case 1:
							log.info("Add details about the product\n");
							Product product = new Product();
							log.info("Enter Product Name");
							product.setPname(sc.nextLine());
							log.info("Enter Product Cost");
							product.setCost(Double.parseDouble(sc.nextLine()));
							try {
								if (employeeservice.createProduct(product) == 1)
									System.out.println("Product added successfully");
								product.PrintStream();

							} catch (BusinessException e) {
								log.warn("Product Not Created:", e);
							}
							log.info("Choose 1-4 Again");

							break;
						case 2:
							log.info("\nView All Products\n");
							try {
								List<Product> productlist = employeeservice.getAllProduct();

								for (Product product1 : productlist) {
									product1.PrintStream();
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
									System.out.println("Product deleted successfully");
								}
							} catch (BusinessException e) {
								System.out.println(e);
							}
							log.info("Choose 1-4 Again");
							break;
						case 4:
							System.out.println("Users are:\n");
							try {
								List<User> user = userservice.getAllUser();
								for (User user2 : user) {
									user2.PrintStream();
								}
							} catch (BusinessException e) {
								log.info(e);

							}
							log.info("\n\n1.Search user by user id");
							log.info("2.Search users by user firstname");
							log.info("3.Search users by user lastname");
							log.info("4.Search users by user email");
							int opt1 = Integer.parseInt(sc.nextLine());
							switch (opt1) {
							case 1:
								int id1 = 0;
								System.out.println("Enter user id to get user");
								try {
									id1 = Integer.parseInt(sc.nextLine());

								} catch (NumberFormatException e) {
									log.info(e);
								}
								try {
									User user = usersearchdao.GetUserById(id1);
									user.PrintStream();
								} catch (BusinessException e) {
									log.info(e);
								}
								break;
							case 2:
								System.out.println("Enter Firstname to search user");
								String firstname = sc.nextLine();
								try {
									List<User> user = usersearchdao.getUserByFirstName(firstname);
									for (User user2 : user) {
										user2.PrintStream();
									}

								} catch (BusinessException e) {
									log.info(e);
								}
								break;
							case 3:
								System.out.println("Enter lastname to search user");
								String lastname = sc.nextLine();
								try {
									List<User> user = usersearchdao.getUserByLastName(lastname);
									for (User user2 : user) {
										user2.PrintStream();
									}

								} catch (BusinessException e) {
									log.info(e);
								}
								break;
							case 4:

								String email = "";
								System.out.println("Enter user email to get user");
								try {
									email = sc.nextLine();

								} catch (NumberFormatException e) {
									log.info(e);
								}
								try {
									User user = usersearchdao.getUserByEmail(email);
									user.PrintStream();
								} catch (BusinessException e) {
									log.info(e);
								}
								break;

							default:
								break;
							}

							break;
						case 5:
							System.out.println("Users are:\n");
							try {
								List<User> user = userservice.getAllUser();
								for (User user2 : user) {
									user2.PrintStream();
								}
							} catch (BusinessException e) {
								log.info(e);

							}
							log.info("\nPlease select useremail to see his/her Orders");
							String str = sc.nextLine();

							try {
								
								List<Order> orderList1 = userorderdao.getOrderTable(str);
								for (Order order2: orderList1) {

									order2.PrintStream();
								}
							} catch (BusinessException e1) {
								log.info(e1);
							}
							log.info("1. Select Order id to mark it as Shipped");
							log.info("2. Exit");
							int option2 = Integer.parseInt(sc.nextLine());
							if (option2 == 1) {
								try {
									if (employeedao.MarkorderbyEmployee(option2) == 1) {
										System.out.println("Marked as shipped");
									}
								} catch (BusinessException e) {
									log.info("cannot mark");
								}
							}
							break;
						default:
							log.info("Employee Menu Again\n");
							break;
						}
					} while (key <= 5);
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
							System.out.println("You have registerred successfully.. Please login\n");
							// System.out.println(user);
						} else {
							log.info("You have registered Earlier Please login\n");
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
						log.info("Welcome to ShoppingisFun App\n");
						int option1 = 0;
						do {
							log.info("1. View Products");
							log.info("2. Add product into cart");
							log.info("3. View Cart");
							log.info("4. Logout");

							try {
								option1 = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Choose Integer Only between 1-3");
							}
							switch (option1) {
							case 1:
								try {
									List<Product> productlist = employeeservice.getAllProduct();
									System.out.println("List of Products\n");
									for (Product product1 : productlist) {
										product1.PrintStream();
									}
								} catch (BusinessException e) {
									log.info(e);

								}

								break;
							case 2:
								int id = 0;
								Cart cart = new Cart();
								try {
									List<Product> productlist = employeeservice.getAllProduct();
									System.out.println("List of Products\n");
									for (Product product1 : productlist) {
										product1.PrintStream();
									}
								} catch (BusinessException e) {
									log.info(e);

								}

								log.info("Select Product Id to add product into cart\n");
								try {
									id = Integer.parseInt(sc.nextLine());

									cart.setUsername(userid);
									cart.setProduct(getproductbyiddao.getProductById(id));
									if (cartuserservice.insertintocart(id, userid) == 1) {
										log.info("Product added into cart");
										cart.PrintStream();
									}
								} catch (BusinessException e) {
									log.info(e);

								}
								break;
							case 3:
								int total = 0;
								log.info("Your cart has these products\n");
								List<Cart> cartList = cartuserservice.getcartbyuserid(userid);
								for (Cart cart2 : cartList) {
									total += cart2.getProduct().getCost();
									cart2.PrintStream();
								}
								System.out.println("\nTotal is:- " + total);

								log.info("\n1.To place order select Product Id:");

								int cid = 0;
								int cid1 = 0;
								try {
									cid = Integer.parseInt(sc.nextLine());
									log.info("\n1.Please Select cartid parallely with productid:");
									cid1=Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.info(e);
								}

								if (userorderservice.CarttoOrder(userid, cid) == 1) {
									
									log.info("\nAdded into order and removing from cart paralelly \nNow pay "+total);
									cartuserservice.deletefromcart(cid1,userid);
								}
								
								
								List<Order> orderList=userorderdao.getOrderTable(userid);
								for (Order order : orderList) {
									order.PrintStream();
								}
								log.info("\nSelect Order id to Mark Status as Recieved");
								
								int oid1=0;
								try {
									oid1 = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException e) {
									log.info(e);
								}
								
								if(userservice.MarkOrder(oid1)==1)
								{
									log.info("Marked "+oid1+" as recieved");
								}

								break;
							default:
								log.info("Back to Main Menu\n");
								break;
							}

						} while (option1 != 4);
					} else {
						log.info("User Id doesnot exist Please Register\n");
					}
				} catch (BusinessException e) {
					log.warn(e);
				}
				break;
			default:
				log.info("Thank You for Using ApniDukan App!");
				break;
			}
		} while (option != 4);
	}
}
