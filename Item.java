package lab4;
import java.util.Scanner;
public class Item implements MenuItem{

	private String author, title, type;	
	private int itemNumber, price;	
	private Scanner in = new Scanner(System.in);
	
	public Item(String type, String title, String author, int price, int itemNumber){
		this.type = type;
		this.title = title;		
		this.author = author;
		this.price = price;
		this.itemNumber = itemNumber;
	}
	
	public Item(String type, String title){
		this.title = title;
	}
	
	
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public void execute() {
		
		System.out.println(type.toUpperCase());
		for(int i = 0; i<type.length(); i++){
			System.out.print("=");
		}
		System.out.println();
		
		System.out.println("Varunummer: "+itemNumber+"\nTitel: "+title+"\nFörfattare: "+author+"\nPris: "+price);
		in.nextLine();
	}

}
