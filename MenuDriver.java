package lab4;

/**
 * @author johsj748 andbj206
 *
 */
public class MenuDriver {	
		
	private static Menu mainMenu, addItem, itemList;
	
	
	/**
	 * Bygger upp och exekverar ett menysystem, d�r anv�ndaren n�stan kan v�lja varor och l�gga till en lista.
	 */
	static public void main(String[] args){
		
		mainMenu = new MainMenu("Huvudmeny");
		
		itemList = new Menu("Varulista");
		addItem = new Menu("L�gg till vara");
		mainMenu.add(itemList);
		mainMenu.add(addItem);
		
		MenuItem book = new Book("Bok");
		MenuItem movie = new Menu("Film");
		MenuItem clothes = new Menu("Kl�der");
	
		
		addItem.add(book);
		addItem.add(movie);
		addItem.add(clothes);
				
		
		mainMenu.execute();
	}
	
	
	/**
	 * L�gger till en vara i listan.
	 * @param i Vara som l�ggs till i listan.
	 */
	static public void addToItemList(MenuItem i){
		itemList.add(i);
	}
	

}
