package lab4;

/**
 * @author johsj748 andbj206
 *
 */
public class MenuDriver {	
		
	private static Menu mainMenu, addItem, itemList;
	
	
	/**
	 * Bygger upp och exekverar ett menysystem, där användaren nästan kan välja varor och lägga till en lista.
	 */
	static public void main(String[] args){
		
		mainMenu = new MainMenu("Huvudmeny");
		
		itemList = new Menu("Varulista");
		addItem = new Menu("Lägg till vara");
		mainMenu.add(itemList);
		mainMenu.add(addItem);
		
		MenuItem book = new Book("Bok");
		MenuItem movie = new Menu("Film");
		MenuItem clothes = new Menu("Kläder");
	
		
		addItem.add(book);
		addItem.add(movie);
		addItem.add(clothes);
				
		
		mainMenu.execute();
	}
	
	
	/**
	 * Lägger till en vara i listan.
	 * @param i Vara som läggs till i listan.
	 */
	static public void addToItemList(MenuItem i){
		itemList.add(i);
	}
	

}
