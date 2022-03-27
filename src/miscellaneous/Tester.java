package miscellaneous;

import java.util.Scanner;

import agents.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import movement.*;

public class Tester {
	public void runTest(){
		Scanner sc = new Scanner(System.in);
		int esetszam;

		System.out.println("Üdv a tesztprogramunkban! Kilépés '0'-val\n\n");

		do {
			System.out.println("Melyik tesztesetet szeretné futtatni?\n\n"
					+ "1. Step on storage with increased matter\n"
					+ "2. Cast forgetting agent\n"
					+ "3. Cast stun\n"
					+ "4. Drop empty field\n"
					+ "5. \n"
					+ "6. \n"
					+ "7. \n"
					+ "8. \n"
					+ "9. \n"
					+ "10. \n"
					+ "11. \n"
					+ "12. \n"
					+ "13. Virologist step on field\n"
					+ "14. Virologist self cast\n"
					+ "15. Virologist picks up equipment\n"
					+ "16. Virologist double block and return\n"
					+ "17. Virologist can't pick up item\n"
					+ "18. Virologist learns chorea\n"
					+ "19. Virologist tries to move while stunnedL\n"
					+ "---\n"
					+ "0. Kilépés");	//A kirajzolt menű
			esetszam=sc.nextInt()%20;	//Választás beolvasása

			Logger.disable();			//A logolás letiltása a pálya felépítésének idejére

			switch(esetszam) {			//A válasznak megfelelő eset indítása
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
	Scanner sc = new Scanner(System.in);
	int esetszam;

	System.out.println("Üdv a tesztprogramunkban! Kilépés '0'-val\n\n");

	do {
		System.out.println("Melyik tesztesetet szeretné futtatni?\n\n"
				+ "1. Step on storage with increased matter\n"
				+ "2. Cast forgetting agent\n"
				+ "3. Cast stun\n"
				+ "4. Drop empty field\n"
				+ "5. \n"
				+ "6. \n"
				+ "7. \n"
				+ "8. \n"
				+ "9. \n"
				+ "10. \n"
				+ "11. \n"
				+ "12. \n"
				+ "13. Virologist step on field\n"
				+ "14. Virologist self cast\n"
				+ "15. Virologist picks up equipment\n"
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
		// Inicializáslás
		Sack sc = new Sack();
		Shelter s = new Shelter();
		Virologist v = new Virologist();
		Field f = new Field();
		v.changeField(f);
		v.addEquipment(sc);
		sc.getEffect();
		f.addVirologist(v);
		f.addNeighbor(s);
		s.addNeighbor(f);

		// Logger enable and register
		Logger.enable();
		Logger.register(sc, "sc");
		Logger.register(s, "s");
		Logger.register(v, "v");
		Logger.register(f, "f");

		// Tesztelés
		v.getMovement().move(v, s);
	}

	public void castForgettingAgent() {
		// Inicializálás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		ForgettingAgent fa = new ForgettingAgent();
		v1.learnAgent(fa);

		// Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(fa, "fa");

		// Tesztelés
		fa.cast(v2, 1);
	}
	
	public void castStun() {
		// Inicializáslás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		Stun s = new Stun();
		v1.learnAgent(s);

		// Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(s, "s");

		// Tesztelés
		s.cast(v2, 1);
	}

	public void dropEmptyField() {
		// Inicializáslás
		Virologist v = new Virologist();
		Field f = new Field();
		Cape c = new Cape();
		v.addEquipment(c);
		v.changeField(f);
		f.addVirologist(v);

		// Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(f, "f");
		Logger.register(c, "c");

		// Tesztelés
		c.dropEquipment();

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
		///Inicializáslás
		Virologist v = new Virologist();
		Field f1 = new Field();
		Field f2 = new Field();
		//f1.addNeighbor(f2);
		//f2.addNeighbor(f1);
		v.changeField(f1);
		//f1.addVirologist(v);
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(v.getMovement(), "nm");
		Logger.register(f1, "f1");
		Logger.register(f2, "f2");
		
		///Test
		//v.getMovement().move(v,f2);
	}

	public void selfCast() {
		///Inicializáslás
		Virologist v = new Virologist();
		Protection p = new Protection();
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(p, "p");
		//*** FIGYELEM!!! HIÁNYZIK EGY OSZTÁLY REGELÉSE!!!! PROTECTION COPY ***
		
		///Test
		//p.cast(v, 1);
		
	}

	public void pickupItem() {
		///Inicializáslás
		Virologist v = new Virologist();
		Glove g = new Glove();
		Field f = new Field();
		//f.addVirologist(v);
		v.changeField(f);
		//f.spawnEquipment(g);
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(g, "g");
		Logger.register(f, "f");
		
		///Test
		//g.pickupItem(v);
	}

	public void doubleBlockAndReturn() {
		///Inicializáslás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		BlockAndReturn bar_1 = new BlockAndReturn();
		BlockAndReturn bar_2 = new BlockAndReturn();
		Chorea c = new Chorea();

		v1.learnAgent(c);

		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(bar_1, "bar_1");
		Logger.register(bar_2, "bar_2");
		Logger.register(c, "c");

		///Test
		c.cast(v1,1);
	}

	public void cantPickupItem() {
		///Inicializáslás
		Virologist v = new Virologist();
		Cape c = new Cape();
		Glove g1 = new Glove();
		Glove g2 = new Glove();
		Sack s = new Sack();

		c.pickupEquipment(v);
		v.addEquipment(c);
		g1.pickupEquipment(v);
		v.addEquipment(g1);
		s.pickupEquipment(v);
		v.addEquipment(s);


		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(c, "c");
		Logger.register(g1, "g1");
		Logger.register(g2, "g2");
		Logger.register(s, "s");



		///Test
		g2.pickupEquipment(v);
	}

	public void learnChorea() {
		///Inicializáslás
		Virologist v = new Virologist();
		Chorea c = new Chorea();
		Laboratory l = new Laboratory();

		v.changeField(l);
		l.addAgent(c);

		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(c, "c");
		Logger.register(l, "l");

		///Test
		l.stepOn(v);

	}

	public void moveWhileStunned() {
		///Inicializáslás
		Virologist v = new Virologist();
		Stun stun = new Stun();
		Stunned s = new Stunned();
		Field target = new Field();

		v.addActiveAgent(stun);

		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(stun, "stun");
		Logger.register(s, "s");
		Logger.register(target, "target");

		///Test
		s.move(v,target);
	}

}
