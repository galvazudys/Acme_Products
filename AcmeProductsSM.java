/**
 * @(#)Acmeproducts.java
 *
 * Acmeproducts application
 *
 * @author
 * @version 1.00 2017/4/2
 */
import java.util.*;

public class AcmeProductsSM
{
	//Declering variables
	static String[] productId = new String[1000];
    static String[] productName = new String[1000];
    static String[] productDescription = new String[1000];
    static float[] productPrice = new float[1000];
    static int[] stockLevel = new int[1000];
    static int[] reOrderLevel = new int[1000];
	static String product = "";
	static String addId ="";
	static String description = "";
	static	int stock = 0;
    static  float price = 0;
    static  String retieveProduct="";
    static  int retrieveId=0;
    static  int reOrder = 0;
    static  String productDetail="";

	//Main method
    public static void main(String[] args)
    {

		// Initialise product arrays for testing 
    	productId[0] = "1";
    	productName[0] = "Dining Chair";
    	productDescription[0] = "Oak Dining Chair";
    	productPrice[0] = 40.00f;
    	stockLevel[0] = 100;
    	reOrderLevel[0] = 20;

    	productId[1] = "2";
    	productName[1] = "Dining Table";
    	productDescription[1] = "Oak Dining Table";
    	productPrice[1] = 400.00f;
    	stockLevel[1] = 20;
    	reOrderLevel[1] = 5;

    	productId[2] = "3";
    	productName[2] = "Bed";
    	productDescription[2] = "Oak Four Poster Bed";
    	productPrice[2] = 600.00f;
    	stockLevel[2] = 10;
    	reOrderLevel[2] = 3;

    	productId[3] = "4";
    	productName[3] = "Arm Chair";
    	productDescription[3] = "Floral Arm Chair";
    	productPrice[3] = 250.00f;
    	stockLevel[3] = 50;
    	reOrderLevel[3] = 10;
		Scanner sc = new Scanner(System.in);

    	//menu method
    	String option = "";
    	do
    	{
    		option = menu();
    		System.out.println("Menu Option is:" + option);
    	}
        while (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") || option.equals("5") || option.equals("6"));
    }

	//main menu method
    public static String menu()
    {
    	System.out.println("Acme Products");
    	System.out.println("");
    	System.out.println("1. Retrieve an existing product details by name");
    	System.out.println("2. Input new product details.");
    	System.out.println("3. Edit and existing product details");
    	System.out.println("4. Check for any stock at/below reorder level.");
    	System.out.println("5. Check stock level by name.");
    	System.out.println("6. Check stock value");
    	System.out.println("Press any other key to exit");
    	Scanner sc = new Scanner(System.in);

		//after taking input from user its calls method from option.
    	String Option = sc.nextLine();
    	if (Option.equals("1"))
    		Retrieve();
    	if (Option.equals("2"))
    		InputNew();
    	if (Option.equals("3"))
    		EditExisting();
    	if (Option.equals("4"))
    		ReOrderLevels();
    	if (Option.equals("5"))
    		StockLevelByName();
    	if (Option.equals("6"))
    		StockValue();

    	return Option;
    }

	//option 1 method
    public static int Retrieve()
    {
    	System.out.println("Using Retrieve Method");
    	System.out.println("Enter Product Name to Retrieve");
    	Scanner sc = new Scanner(System.in);
    	String ProductName = sc.next().toLowerCase();

        int productIndex=-1;
    	for (int i=0; i < 1000; i++)
    	{
			//check or product exist, if not display message for user
			if(productName[i] == null)
			{
				System.out.println("No Product Present! Try Again..");
				break;
			}
    		if (productName[i].toLowerCase().equals(ProductName))
    		{
            	System.out.println("Product Id:" + productId[i]);
            	System.out.println("Product Name:" + productName[i]);
            	System.out.println("Product Description:" + productDescription[i]);
            	System.out.println("Product Price:" + productPrice[i]);
            	System.out.println("Product Stock Level:" + stockLevel[i]);
            	System.out.println("Product Re-Order Level:" + reOrderLevel[i]);
                productIndex = i;
                break;
    		}
    	}
    	return productIndex;
    }

	//Option 2 method
    public static void InputNew()
    {
    	System.out.println("In InputNew Method");
    	System.out.println("Enter name of product: "); // Asking user enter name of product
		Scanner sc = new Scanner(System.in);
        product = sc.next().toLowerCase(); //taking input from USer
        //Looping over array and checking or value in array is empty,if empty we assign entered value to emty pleace holder.
        for(int i = 0;i<productName.length;i++){
            if(productName[i]==null){
                productName[i]= product;
                break;
            }
        }
		//find item index in array
        int itemId=Arrays.asList(productName).indexOf(product);

        //ID
        System.out.println("Enter Item Id: ");
        addId = sc.next();
        productId[itemId] = addId;

        //Description
        System.out.println("Enter Description of Product: ");
        sc.nextLine();//consume line so nextLine() method would read line
        description = sc.nextLine();
        productDescription[itemId] = description;

        //Stock quantity
        System.out.println("Enter Stock you have now: ");
        stock = sc.nextInt();
        stockLevel[itemId] = stock;

        //Re-Order Levels
        System.out.println("Please Set Re-Order level for Product: ");
        reOrder = sc.nextInt();
        reOrderLevel[itemId] = reOrder;

        //price
        System.out.println("Enter Price: ");
        price = sc.nextFloat();
        productPrice[itemId]=price;

    }

	//option 3 method
    public static void EditExisting()
    {
    	System.out.println("In EditExisting Method");
    	System.out.println("Please enter product detail to be edited:");
    	int i = Retrieve();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("a) Product Id:"  + productId[i]);
        System.out.println("b) Product Name:" + productName[i]);
        System.out.println("c) Product Description:" + productDescription[i]);
        System.out.println("d) Product Price:" + productPrice[i]);
        System.out.println("e) Product Stock Level:" + stockLevel[i]);
        System.out.println("f) Product Re-Order Level:" + reOrderLevel[i]);
		
		//checks for option from user and takes input of new value 
    	productDetail=sc.nextLine();
        if (productDetail.equals("a"))
    	{
        	System.out.println("Enter new Id for this Product:");
        	productId[i]=sc.nextLine();
    	}

        if (productDetail.equals("b"))
    	{
        	System.out.println("Enter new Name for this Product:");
        	productName[i]=sc.nextLine();
    	}
    	if (productDetail.equals("c"))
    	{
    		System.out.println("Enter new Description for this Product:");
        	productDescription[i]=sc.nextLine();
    	}
    	if (productDetail.equals("d"))
    	{
    		System.out.println("Enter new Price for this Product:");
    		productPrice[i]=sc.nextFloat();
    	}
    	if  (productDetail.equals("e"))
    	{
    		System.out.println("Enter new Stock Level for this Product:");
        	stockLevel[i]=sc.nextInt();
    	}
    	if  (productDetail.equals("f"))
    	{
    		System.out.println("Enter new Re-Order Levels for this Product:");
        	reOrderLevel[i]=sc.nextInt();
    	}
    }

	//Option 4 mothod
    public static void ReOrderLevels()
    {
    	System.out.println("In ReOrderLevels Method");

        int countBelowStock=0;
    	for (int i=0; i < 1000; i++)
    	{
			//checks or any value lower then re-order level
    		if (stockLevel[i]<reOrderLevel[i])
    		{
            	System.out.println("Product Id:" + productId[i]);
            	System.out.println("Product Name:" + productName[i]);
            	System.out.println("Product Description:" + productDescription[i]);
            	System.out.println("Product Price:" + productPrice[i]);
            	System.out.println("Product Stock Level:" + stockLevel[i]);
            	System.out.println("Product Re-Order Level:" + reOrderLevel[i]);
                countBelowStock = countBelowStock + 1;
    		}
    	}
    	if (countBelowStock == 0)
    	{
    		System.out.println("There are no products below stock levels.");
    	}
    }

	//option 5 method
    public static void StockLevelByName()
    {
    	System.out.println("In StockLevelByName Method");
 		System.out.println("Please enter product :");

    	Scanner sc = new Scanner(System.in);
    	String ProductName = sc.next().toLowerCase();


    	for (int i=0; i < 1000; i++)
    	{

			if(productName[i] == null)
			{
				//check or product exist, if not display message for user
				System.out.println("No Product Present! Try Again..");
				break;
			}			
    		if (productName[i].toLowerCase().equals(ProductName))
    		{
				//if exist,it's loops and finds product and calc and prints				
				System.out.println("Product Stock Level for "+ productName[i] +(" is: ") + stockLevel[i]);
            	sc.nextLine();
			 	break;
    		}
    	}
    }

//Option 6 method
	public static void StockValue()
    {
    	System.out.println("In StockValue Method");
    	System.out.println("Please enter product :");
		
    	Scanner sc = new Scanner(System.in);
    	String ProductName = sc.next().toLowerCase();


    	for (int i=0; i < 1000; i++)
    	{
			//check or product exist, if not display message for user
			if(productName[i] == null)
			{
				System.out.println("No Product Present! Try Again..");
				break;
			}
    		if (productName[i].toLowerCase().equals(ProductName)) 
    		{
				//if exist,it's loops and finds product and calc and prints
				System.out.println("Product Stock Value for "+ productName[i] +(" is: ") + (" ")+stockLevel[i]*productPrice[i]);
            	sc.nextLine();
			 	break;
    		}

    	}
    }
}
