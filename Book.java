package lab4;

import java.util.Scanner;

public class Book implements MenuItem{
	
	
	private String title;
	private Scanner in = new Scanner(System.in);
	
	private String bookTitle="Emil i Lönneberga", author ="Astrid Lindgren";
	private int itemNumber = 6, price = 45;
	private char enviromentalDeclaration = 'n';
	
	public Book(String title){
		this.title = title;		
	}
	
	@Override
	public String getTitle() {		
		return title;
	}

	@Override
	public void execute() {
		System.out.println("LÄGG TILL " +title.toUpperCase());
		for(int i = 0; i<title.length()+10; i++){
			System.out.print("=");
		}
		System.out.println();
		
		System.out.println("Varunummer: "+itemNumber+"\nTitel: "+bookTitle+"\nFörfattare: "+author+"\nPris: "+price+"\nMiljömärkt: "+enviromentalDeclaration);
		in.nextLine();
		
		MenuDriver.addToItemList(new Item(title, bookTitle, author, price, itemNumber));
		
	}

}
