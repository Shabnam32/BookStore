package com.game.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

import com.game.test.MySqlConnection;

import com.game.test.*;

import com.game.*;

public class Book {
  
    public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("*************************************************************************************");
        System.out.println("=====================  WELCOME TO MY ONLINE BOOK STORE ================================");
        System.out.println("**************************************************************************************");   
        
		System.out.println("\t\t Login Here!!!");
	//System.out.println("\t\t Customer Login Here");
		System.out.println("==============================================================================");
		System.out.println("Enter here to login:");
		int choice = Integer.parseInt(br.readLine());

		if (choice==1) {

			System.out.println("==============================================================================");
			System.out.println("===========================    LOGIN DETAILS  ================================");
			System.out.println("==============================================================================");

			System.out.print("\t Enter your username:");
			String userName = br.readLine();
			System.out.print("\t Enter your password:");
			String userPassword = br.readLine();
       
        try {
        	Connection conn = MySqlConnection.getConnection();
    		
        	PreparedStatement ps = conn.prepareStatement("select Password from admin where Username=?");
			ps.setString(1, userName);
			ResultSet result = ps.executeQuery();
			String password = null;
			boolean login = false;
			while (result.next()) {
				password = result.getString("Password");
				login = true;
			}

			if (password.equals(userPassword)) {
				System.out
						.println("==============================================================================");
				System.out
						.println("===========================   Login successful ================================");
				System.out
						.println("==============================================================================");
				System.out.println("============================== WELCOME " + userName.toUpperCase()
						+ " ===============================");
				System.out
						.println("==============================================================================");
				
        	
            // Creates a line to the database for running queries
            Statement statement = conn.createStatement();
            Scanner input = new Scanner(System.in);
           while(true){
                
                printMenu();
                                int menuSelection = input.nextInt();
                input.nextLine();
              
                if(menuSelection == 1){
                    enterBook(statement);
                }
                else if(menuSelection == 2){
                    updateBook(statement);
                }
              
                else if(menuSelection == 3){
                    deleteBook(statement);
                }
     
                else if(menuSelection == 4){
                    searchBooks(statement);
                }
              
                else if(menuSelection == 5){
                    generateSale(statement);
                }
                else if(menuSelection == 0){
                    System.out.println("Thank you for using our services! See you soon!");
                    System.exit(0);
                    break;
                }
               
                else{
                	System.out.println("==============================================================================");   
                    
                    System.out.println("Please enter a valid integer between 1 and 5 and try " +
                            "again.");
                    System.out.println("==============================================================================");   
                    
                }
              
                
            }
           
			}
        }
        // If an error occurs, prints the stack
        catch (Exception e) {
			System.out.println(e);
			System.out.println("==============================================================================");
			System.out.println("===========================  Wrong username/password  ========================");
			System.out.println("==============================================================================");

		}}
        
        }
		//else if (choice == 2) {

			/*System.out.println("==============================================================================");
			System.out.println("===========================    LOGIN DETAILS  ================================");
			System.out.println("==============================================================================");

			System.out.print("\t Enter your username:");
			String userName = br.readLine();
			System.out.print("\t Enter your password:");
			String userPassword = br.readLine();

			Connection conn = MySqlConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from customer where userame=?");
			ps.setString(1, userName);
			ResultSet result = ps.executeQuery();
			String password = null;
			boolean login = false;
			while (result.next()) {
				password = result.getString("password");
				login = true;
			}
			 
				
					
				if (password.equals(userPassword)) {
					System.out
							.println("==============================================================================");
					System.out
							.println("===========================   Login successful ================================");
					System.out
							.println("==============================================================================");
					System.out.println("============================== WELCOME " + userName.toUpperCase()
							+ " ===============================");
					System.out
							.println("==============================================================================");
					 Statement statement = conn.createStatement();
			            Scanner input = new Scanner(System.in);
					while(true){
		                
		                print();
		                              
										int menuSelection = input.nextInt();
		                input.nextLine();
		              
						if(menuSelection == 1){
		                    searchBooks(statement);
		                }
		              
		                else if(menuSelection == 2){
		                   viewbooks(statement,userName);
		                }
		                else if(menuSelection == 0){
		                    System.out.println("Thank you for using our services! See you soon!");
		                    System.exit(0);
		                    break;
		                }
		                else{
		                	System.out.println("==============================================================================");   
		                    
		                    System.out.println("Please enter a valid integer between 1 and 2 and try " +
		                            "again.");
		                    System.out.println("==============================================================================");   
		                    
		                }
			}
							
				}
    }
		else {
				
					System.out.println("==============================================================================");
					System.out.println("===========================  Wrong username/password  ========================");
					System.out.println("==============================================================================");

				}
		        
		        }
   		
			
					
    
    

public static void print(){
    	System.out.println("==============================================================================");   
        
        System.out.println("""
    What would you like to do?

    1- Search Books
    2-View Books
   
    0 - Exit""");
        System.out.println("==============================================================================");   
        
    }
    
    private static void searchbook(ResultSet results) throws SQLException {
        while (results.next()) {
            System.out.println(
                    "ID: " + results.getString("id") + "\n"
                    + "Title: " + results.getString("title") + "\n"
                    + "Author: " + results.getString("author") + "\n"
                    + "Quantity: " + results.getInt("qty") + "\n");
        }
    }
    private static void viewbook(ResultSet results) throws SQLException {
		
	// TODO Auto-generated method stub
    while (results.next()) {
        System.out.println(
                "ID: " + results.getString("id") + "\n"
                + "Title: " + results.getString("title") + "\n"
               );
    }
		
	}
*/

	
    public static void printMenu(){
    	System.out.println("==============================================================================");   
        
        System.out.println("""
    What would you like to do?
    1 - Add a New Book
    2 - Update a Book Entry
    3 - Delete a Book
    4 - Search Books
    5 - Create a Sale Notice for Highest Quantity Product
    0 - Exit""");
        System.out.println("==============================================================================");   
        
    }

    public static void enterBook(Statement statement) throws SQLException {
        // Asks the user for the details of the book they want to enter
        Scanner input = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("What is the ID of the book?");
            id = input.nextLine();
            ResultSet results = checkID(statement, id);
            // If the ID already exists, asks user to try again
            if (results.isBeforeFirst()) {
                System.out.println("This ID already exists, please try again.");
            }
            else {
                break;
            }
        }
        System.out.println("What is the title of the book?");
        String title = input.nextLine();
        System.out.println("Who is the author of the book?");
        String author = input.nextLine();
        System.out.println("How many copies are in stock?");
        int qty = input.nextInt();
        input.nextLine();
        // Adds the book to the table
        String query = "INSERT INTO books VALUES('%s','%s','%s',%s)".
                formatted(id, title, author, qty);
        statement.executeUpdate(query);
        System.out.println("Book has been added.");
    }

    
    public static void updateBook(Statement statement) throws SQLException {
        Scanner input = new Scanner(System.in);
        String idSelection;
       
        printSummary(statement);
       
       
        while (true) {
            System.out.println("What is the ID of the book you would like to update?");
            idSelection = input.nextLine();
            ResultSet results = checkID(statement, idSelection);
          
            if (!results.isBeforeFirst()) {
                System.out.println("The ID you entered was not found, please try again.");
            } else {
                break;
            }
        }
       
       while(true){
            System.out.println("""
                    Which field would you like to update?
                    1 - ID
                    2 - Name
                    3 - Author
                    4 - Quantity""");
            int fieldSelection = input.nextInt();
            input.nextLine();
            boolean validSelection = false;
            
            if (fieldSelection == 1) {
                validSelection = true;
                changeID(statement, input, idSelection);
            }
           
            else if (fieldSelection == 2) {
                validSelection = true;
                changeTitle(statement, input, idSelection);
            }
           
            else if (fieldSelection == 3) {
                validSelection = true;
                changeAuthor(statement, input, idSelection);
            }
           
            else if (fieldSelection == 4) {
                validSelection = true;
                changeQty(statement, input, idSelection);
            }
           
            if (!validSelection) {
                System.out.println("Input not recognised, please enter a number from 1 to 4.");
            }
            
            else {
                System.out.println("Book has been updated successfully.");
                break;
            }
            
            
        }
        
    }

   
    
    private static void changeQty(Statement statement, Scanner input, String idSelection) throws SQLException {
        System.out.println("What would you like to change the quantity to?");
        String updateQty = input.nextLine();
        statement.executeUpdate(
                "UPDATE books SET qty='%s' WHERE id='%s';"
                        .formatted(updateQty, idSelection));
    }

   
    private static void changeAuthor(Statement statement, Scanner input, String idSelection) throws SQLException {
        System.out.println("What would you like to change the author of the book to?");
        String updateAuthor = input.nextLine();
        statement.executeUpdate(
                "UPDATE books SET author='%s' WHERE id='%s';"
                        .formatted(updateAuthor, idSelection));
    }

   
    private static void changeTitle(Statement statement, Scanner input, String idSelection) throws SQLException {
        System.out.println("What would you like to change the title of the book to?");
        String updateName = input.nextLine();
        statement.executeUpdate(
                "UPDATE books SET title='%s' WHERE id='%s';"
                        .formatted(updateName, idSelection));
    }

    private static void changeID(Statement statement, Scanner input, String idSelection) throws SQLException {
        while (true) {
            try {
                System.out.println("What would you like to change the ID to?");
                String updateID = input.nextLine();
                statement.executeUpdate(
                        "UPDATE books SET id='%s' WHERE id='%s';"
                                .formatted(updateID, idSelection));
                break;
            }
            
            catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("The ID you selected already exists. Please try again.");
            }
        }
    }

   
    private static ResultSet checkID(Statement statement, String idSelection) throws SQLException {
        return statement.executeQuery("SELECT * FROM books WHERE id = '%s';".
                formatted(idSelection));
    }

   
    public static void deleteBook(Statement statement) throws SQLException {
        Scanner input = new Scanner(System.in);
       
        printSummary(statement);
        
        String idSelection;
        while (true) {
            System.out.println("Please enter the ID of the book you would like to delete:");
            idSelection = input.nextLine();
            ResultSet results = checkID(statement, idSelection);
            
            if (!results.isBeforeFirst()) {
                System.out.println("The ID you entered was not found, please try again.");
            } else {
                break;
            }
        }
        
        statement.executeUpdate("DELETE FROM books WHERE id='%s';".formatted(idSelection));
        System.out.println("Book has been deleted.");
    }

    
    public static void searchBooks(Statement statement) throws SQLException {
        Scanner input = new Scanner(System.in);
        // Asks the user what they would like to search for
        while (true) {
            System.out.println("Please enter the search term you would like to enter");
            String searchTerm = input.nextLine();
            // Executes an SQL query with the search term
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM books " +
                            "WHERE id LIKE \"%" + searchTerm + "%\"" +
                            "OR title LIKE \"%" + searchTerm + "%\"" +
                            "OR author LIKE \"%"+ searchTerm + "%\"");
            // If no results are found, prints a message and asks if they would like to try again
            if (!results.isBeforeFirst()) {
                noResults(statement, input);
                return;
            }
            // If results are found, prints them in an easy-to-read format
            else {
                printResults(results);
                break;
            }
        }
    }

   
    private static void printSummary(Statement statement) throws SQLException{
        ResultSet results = statement.executeQuery("SELECT * FROM books;");
        while(results.next()){
            System.out.println(results.getString("id")+ " - "
                    + results.getString("title"));
        }
    }

    
    private static void printResults(ResultSet results) throws SQLException {
        while (results.next()) {
            System.out.println(
                    "ID: " + results.getString("id") + "\n"
                    + "Title: " + results.getString("title") + "\n"
                    + "Author: " + results.getString("author") + "\n"
                    + "Quantity: " + results.getInt("qty") + "\n");
        }
    }

   
    private static void noResults(Statement statement, Scanner input) throws SQLException {
        while (true) {
            System.out.println("No results were found, would you like to try again? (y/n)");
            String tryAgain = input.nextLine();
            // If they select y, restarts the method
            if (tryAgain.equals("y")) {
                searchBooks(statement);
            }
            // If they select n, exits the method
            else if (tryAgain.equals("n")){
                return;
            }
           
            else {
                System.out.println("Input not recognised, please enter either y or n and try " +
                        "again");
            }
            
        }
    }

    public static void generateSale(Statement statement) throws SQLException{
        ResultSet results = statement.executeQuery("SELECT title, qty FROM books " +
                "WHERE qty=(SELECT max(qty) from books);");
        results.next();
        System.out.println(results.getString("title") + " is on sale now! " +
                "Hurry, only " + results.getString("qty") + " copies left!");
    }
    
}


