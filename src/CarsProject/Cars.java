/**
 * 
 */
package CarsProject;
import java.io.*;

/**
 * @author vlads
 *
 */
public class Cars {
	
	private String brand;
	private String model;
	private String fuelType;
	private String color;
	private double price;
	private int quantity;
	
	// Constructor
	
	public Cars ( String bnd, String md, String fuel, String clr, double pr, int qnt) {
		
		brand = bnd;
		model = md;
		fuelType = fuel;
		color = clr;
		price = pr;
		quantity = qnt;
	}
	
	// Display
	
	public static void DisplayOnScreen (Cars [] cars, int i) {
		
		System.out.println("Brand = "+cars[i].brand);
		System.out.println("Modelul = "+cars[i].model);
		System.out.println("Tip Incastrare = "+cars[i].fuelType);
		System.out.println("Culoarea = "+cars[i].color);
		System.out.println("Pretul = "+cars[i].price);
		System.out.println("Cantitatea = "+cars[i].quantity);
		System.out.println("***************************************************");
	}
	
	// Search by Brand and Price
	
	public static void SearchByBrandAndPrice(Cars [] cars, int n, String brandToSearch, double searchPrice) {
		
		for(int i = 0; i < n; i++)
			if(cars[i].brand.equals(brandToSearch) && cars[i].price == searchPrice)
			{
				System.out.println("Car brand "+brandToSearch+" with the price "
			+searchPrice+" is at position "+(i+1));
			}
			else			
			System.out.println("The car you searched is not in the store");			
	}
	
	//Delete by 2 properties/criteria
	
	public static int Delete(Cars [] cars, int n, String deleteBrand, String deleteModel) {
		
		for(int i = 0; i < n; i++)
			if(cars[i].brand.equals(deleteBrand) && cars[i].model.equals(deleteModel))
			{
				for(int j=i; j < n-1; j++)
					cars[j] = cars[j+1];
				n--;
			}
		return n;
	}
	
	// Search and display by 1 criteria
	
	public static void SearchAndDisplay ( Cars [] cars, int n, String searchModel) {
		for (int i = 0; i < n; i++)
			if(cars[i].model.equals(searchModel))
			{
				System.out.print("Model found!\n");
				DisplayOnScreen( cars, i);
			}
			else
				System.out.println("The model you are looking for is not in store!");
	}
	
	// Sort by price
	
	public static void SortByPrice( Cars [] cars, int n) {
		
		boolean ordered;
		Cars aux;
		
		ordered=false;
		while(!ordered)
		{
			ordered=true;
			for(int i = 0; i < n-1; i++)
				if(cars[i].price < cars[i+1].price)
				{
					aux = cars[i];
					cars[i] = cars[i+1];
					cars[i+1] = aux;
					ordered=false;
				}
		}
		System.out.println("Tabloul ordonat dupa pret este:");
		for(int i=0; i < n; i++)
			DisplayOnScreen(cars,i);
	}
		
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Cars [] cars = new Cars[20];
		int n;
		String br, mod, fType, col, brC, modelToSearch;
		double pr, priceToSearch;
		int q, option;
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the number of cars: ");
    	n = Integer.parseInt(bReader.readLine());
    	
    	for(int i=0; i<n; i++)
    	{
    		System.out.println("*******Adding New Car*******");
    		System.out.print("Brand: ");
    		br = bReader.readLine();
    		System.out.print("Model: ");
    		mod = bReader.readLine();
    		System.out.print("Fuel Type: ");
    		fType = bReader.readLine();
    		System.out.print("Color: ");
    		col = bReader.readLine();
    		System.out.print("Price: ");
    		pr = Double.parseDouble(bReader.readLine());
    		System.out.print("Quantity: ");
    		q = Integer.parseInt(bReader.readLine());
    		
    		cars[i] = new Cars(br, mod, fType, col, pr, q);
    	}
    	do
    	{
    		System.out.println("Menu");
            System.out.println("1.Display Cars");
            System.out.println("2.Search by Brand & Pret");
            System.out.println("3.Display by Model");
            System.out.println("4.Delete by Brand && Price");
            System.out.println("5.Sort by Price");
            System.out.println("6.*********DUTZU SURPRIZE*********");
            System.out.println("7.Exit");
        	System.out.print("\nEnter option: ");
        	
        	option = Integer.parseInt(bReader.readLine());
        	
        	switch(option)
        	{
        	case 1:        		
        		System.out.println("\nThe available Cars in Shop are:");
            	for(int i = 0; i<n; i++)
            		DisplayOnScreen(cars, i);
            	break;
            	
        	case 2:
        		System.out.println("-------Search by Brand & Price-------");
            	System.out.print("Enter the Brand you are looking for:");
            	brC = bReader.readLine();
            	System.out.print("\nIntroduceti pretul cautat:");
            	priceToSearch = Double.parseDouble(bReader.readLine());
            	SearchByBrandAndPrice(cars,n, brC, priceToSearch);
            	break;
            	
        	case 3:
        		System.out.println("----------Display by Model----------");
        		System.out.print("Enter the Modelul you are looking for: ");
        		modelToSearch = bReader.readLine();
        		SearchAndDisplay(cars, n, modelToSearch);    		
        		break;
        		
        	case 4:
        		System.out.println("----------Delete by Brand & Model----------");
            	System.out.print("Enter Brand:");
            	brC = bReader.readLine();
            	System.out.print("\nEnter Model:");
            	modelToSearch = bReader.readLine();
            	Delete(cars, n, brC, modelToSearch);
        		break;
        		
        	case 5:
        		System.out.println("----------Sort by Price----------");
        		SortByPrice(cars, n);
        		break;
        		
        	case 6:
        		System.out.println("----------DUTZU SURPRIZE----------");
        		for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (i == j) {
                            System.out.print(" " + 1 + " ");
                        } else {
                            System.out.print(" 26 ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            	default:
            		break;
        	}
    	}while(option != 7);
    	
	}

}
