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
	* L�gger till ett menyval till menyn.
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
	* (1) Skriver ut menyns rubrik med stora bokst�verunderstruket med '='.
	* D�refter f�ljer en numrerad lista �ver alla menyelement i denna
	* meny, numrerade fr�n 0.
	* (2) Anv�ndaren f�r sedan v�lja ett av alterntiven genom att ange
	* talet framf�r menyvalet. Vad h�nder om man inte anger ett
	* giltigt tal? Anv�ndarens menyval exekveras.
	* (3) Om menyval 0 valts s� returnerar metoden. 0 motsvarar
	* allts� alltid av avsluta/tillbaka/�terg�.	*
	* (4) g� till (1)
	*/
	@Override
	public void execute() {
		
		int userInput=-1;
		do{		
			
			// Printar ut menyns Rubrik och samtliga alternativ anv�ndaren har			
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
			
			//Tar in en int fr�n anv�ndaren. Om det inte �r en siffra eller om den �r i fel intervall f�ngas ett fel och menyn loopas om igen
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
			
			//Exekverar menyvalet anv�ndaren angav, annars �terg�r programmet till menyn en niv� ovan eller avsluta om s�dan saknas om anv�ndaren anger 0.
			if(userInput>0){
				menuElements.get(userInput-1).execute();
			}
			
		}while(!(userInput==0));
		
	}
}
