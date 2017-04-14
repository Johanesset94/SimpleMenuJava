package lab4;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author johsj748 andbj206
 * Klassen meny
 *
 */
public class Menu implements MenuItem {
					
	protected String backOrExit;
	private String title;
	private List<MenuItem> menuElements = new ArrayList<MenuItem>();
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Skapar en tom meny med den givna rubriken.
	 */
	public Menu(String title){
		this.title = title;		
		backOrExit = "Tillbaka";
	}
	
	/**
	* Lägger till ett menyval till menyn.
	*/
	public void add(MenuItem item){
		menuElements.add(item);
	}
	
	
	
	/**
	 * @return Returnerar menyelementets titel
	 */
	@Override
	public String getTitle() {
		return title;
	}

	
	/**
	* Exekverar menyn enligt loopen definierad i punkterna (1) till (4).
	* (1) Skriver ut menyns rubrik med stora bokstäverunderstruket med '='.
	* Därefter följer en numrerad lista över alla menyelement i denna
	* meny, numrerade från 0.
	* (2) Användaren får sedan välja ett av alterntiven genom att ange
	* talet framför menyvalet. Vad händer om man inte anger ett
	* giltigt tal? Användarens menyval exekveras.
	* (3) Om menyval 0 valts så returnerar metoden. 0 motsvarar
	* alltså alltid av avsluta/tillbaka/återgå.	*
	* (4) gå till (1)
	*/
	@Override
	public void execute() {
		
		int userInput=-1;
		do{		
			
			// Printar ut menyns Rubrik och samtliga alternativ användaren har			
			System.out.println(title.toUpperCase());
			
			for(int i = 0; i<title.length(); i++){
				System.out.print("=");
			}
			
			System.out.println();
			
			System.out.println("0. "+backOrExit);
			
			int i = 0;
			for(MenuItem item: menuElements){
				i++;
				System.out.println(i + ". " +item.getTitle());				
			}
			
			System.out.println();
			System.out.println("Ange 0-" + (i) + ":");
			
			//Tar in en int från användaren. Om det inte är en siffra eller om den är i fel intervall fångas ett fel och menyn loopas om igen
			try{
				userInput = in.nextInt();
				if(userInput>i || userInput<0){
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e){
				System.out.println("Det du angav var inte en siffra mellan 0-"+i+"!");			
				userInput = -1;
				in.nextLine();
			}
			
			//Exekverar menyvalet användaren angav, annars återgår programmet till menyn en nivå ovan eller avsluta om sådan saknas om användaren anger 0.
			if(userInput>0){
				menuElements.get(userInput-1).execute();
			}
			
		}while(!(userInput==0));
		
	}
}
