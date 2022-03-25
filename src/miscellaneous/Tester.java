package miscellaneous;

import java.util.Scanner;

public class Tester {
	public void runTest(){
	Scanner sc = new Scanner(System.in);
	int esetszam;
	
	System.out.println("Üdv a tesztprogramunkban! Kilépés '0'-val\n\n");
	
	do {
		System.out.println("Melyik tesztesetet szeretné futtatni?\n\n"
				+ "1. \n"
				+ "2. \n"
				+ "3. \n"
				+ "4. \n"
				+ "5. \n"
				+ "6. \n"
				+ "7. \n"
				+ "8. \n"
				+ "9. \n"
				+ "10. \n"
				+ "11. \n"
				+ "12. \n"
				+ "13. \n"
				+ "14. \n"
				+ "15. \n"
				+ "16. \n"
				+ "17. \n"
				+ "18. \n"
				+ "19. \n"
				+ "---\n"
				+ "0. Kilépés");	//A kirajzolt menű
		esetszam=sc.nextInt()%20;	//V�laszt�s beolvas�sa
		
		Logger.disable();			//A logol�s letilt�sa a p�lya fel�p�t�s�nek idej�re
		
		switch(esetszam) {			//A v�lasznak megfelel� eset ind�t�sa
		case 0: continue;
		case 1: stepOnStorageWithIncreasedMatter();
			break;
		case 2: castForgettingAgent();
			break;
		case 3: castStun();
			break;
		case 4: dropEmptyField();
			break;
		case 5: dropNotEmptyField();
			break;
		case 6: blockAndReturn();
			break;
		case 7: partialBlockTrue();
			break;
		case 8: fullBlockTrue();
			break;
		case 9: stealEquipment();
			break;
		case 10: partialBlockFalse();
			break;
		case 11: virologistStepOnStorage();
			break;
		case 12: virologistStepOnShelter();
			break;
		case 13: virologistStepOnField();
			break;
		case 14: selfCast();
			break;
		case 15: pickupItem();
			break;
		case 16: doubleBlockAndReturn();
			break;
		case 17: cantPickupItem();
			break;
		case 18: learnChorea();
			break;
		case 19: moveWhileStunned();
			break;
		}
		System.out.println("Teszteset vége. A folytatáshoz írjon be valamit!");
		if(sc.next().equals("0")) esetszam=0;
	}	while(esetszam!=0);
	sc.close();
	System.out.println("Viszlát!");
	}
	
	public void stepOnStorageWithIncreasedMatter() {
	
	}

	public void castForgettingAgent() {
	}
	
	public void castStun() {
		
	}

	public void dropEmptyField() {
		
	}

	public void dropNotEmptyField() {
		
	}

	public void blockAndReturn() {
		
	}

	public void partialBlockTrue() {
		
	}

	public void fullBlockTrue() {
		
	}

	public void stealEquipment() {
		
	}

	public void partialBlockFalse() {
		
	}

	public void virologistStepOnStorage() {
		
	}

	public void virologistStepOnShelter() {
		
	}

	public void virologistStepOnField() {
		
	}

	public void selfCast() {
		
	}

	public void pickupItem() {
		
	}

	public void doubleBlockAndReturn() {
		
	}

	public void cantPickupItem() {
		
	}
	
	public void learnChorea() {
		
	}

	public void moveWhileStunned() {
		
	}

}
