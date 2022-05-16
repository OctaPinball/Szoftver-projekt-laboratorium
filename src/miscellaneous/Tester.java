package miscellaneous;

import java.io.IOException;
import java.util.Scanner;

import agents.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import movement.*;

/**
 * A szkeleton teszteléséhez szükséges korábban használt osztály
 */
public class Tester {

	public void runTest() throws CloneNotSupportedException, IOException{
		Scanner sc = new Scanner(System.in);
		int esetszam;

		System.out.println("Üdv a tesztprogramunkban! Kilépés '0'-val\n\n");

		do {
			System.out.println("Melyik tesztesetet szeretné futtatni?\n\n"
					+ "1. Step on storage with increased matter\n"
					+ "2. Cast forgetting agent\n"
					+ "3. Cast stun\n"
					+ "4. Drop empty field\n"
					+ "5. Drop Not Empty Field\n"
					+ "6. Block And Return\n"
					+ "7. Partial Block True\n"
					+ "8. Full Block True\n"
					+ "9. Steal Equipment\n"
					+ "10. Partial Block False\n"
					+ "11. Virologist Step On Storage\n"
					+ "12. Virologist Step On Shelter\n"
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
	}


	
	public void stepOnStorageWithIncreasedMatter() throws CloneNotSupportedException, IOException {
		// Inicializáslás
		Sack sc = new Sack();
		Shelter s = new Shelter(0,0,0);
		Virologist v = new Virologist();
		Field f = new Field(0,0,0);
		v.changeField(f);
		f.spawnEquipment(sc);
		sc.pickupEquipment(v);
		//v.addEquipment(sc);
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
		Logger.register(v.getMovement(), "nm");

		// Tesztelés
		v.getMovement().move(v, s);
	}

	public void castForgettingAgent() throws CloneNotSupportedException, IOException {
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
		fa.cast(v2);
	}
	
	public void castStun() throws CloneNotSupportedException, IOException {
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
		s.cast(v2);
	}

	public void dropEmptyField() {
		// Inicializáslás
		Virologist v = new Virologist();
		Field f = new Field(0,0,0);
		Cape c = new Cape();
		v.changeField(f);
		f.addVirologist(v);
		f.spawnEquipment(c);
		c.pickupEquipment(v);
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
		// Inicializáslás
		Virologist v = new Virologist();
		Field f = new Field(0,0,0);
		Cape c = new Cape();
		Glove g = new Glove();
		v.changeField(f);
		f.addVirologist(v);
		f.spawnEquipment(c);
		c.pickupEquipment(v);
		f.spawnEquipment(g);
		
		
		// Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(f, "f");
		Logger.register(c, "c");
		Logger.register(g, "g");
		
		// Tesztelés
		c.dropEquipment();
	}

	public void blockAndReturn() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		Field f1 = new Field(0,0,0);
		Glove g = new Glove();
		BlockAndReturn bar = new BlockAndReturn();
		Chorea c = new Chorea();
		v1.learnAgent(c);
		f1.spawnEquipment(g);
		g.pickupEquipment(v2);
		v2.setBlock(bar);

		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(g, "g");
		Logger.register(c, "c");
		Logger.register(bar, "bar");
		Logger.register(f1, "f1");

		///Test
		c.cast(v2);
	}

	public void partialBlockTrue() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		Field f = new Field(0,0,0);
		Cape c = new Cape();
		Chorea ch = new Chorea();
		v2.changeField(f);
		f.addVirologist(v2);
		v1.learnAgent(ch);
		f.spawnEquipment(c);
		c.pickupEquipment(v2);

		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(c, "c");
		Logger.register(ch, "ch");

		///Test
		ch.cast(v2);
	}

	public void fullBlockTrue() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v1 = new Virologist();
		Stun st = new Stun();
		FullBlock b = new FullBlock();
		v1.setBlock(b);

		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(st, "st");
		Logger.register(b, "fb");

		///Test
		st.cast(v1);
	}

	public void stealEquipment() throws IOException {
		// Inicializáslás
		Field f1 = new Field(0,0,0);
		Field f2 = new Field(0,0,0);
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		Cape cape = new Cape();
		
		v1.changeField(f1);
		v2.changeField(f2);
		f1.addVirologist(v1);
		f2.addVirologist(v2);
		f1.addNeighbor(f2);
		f2.addNeighbor(f1);
		f2.spawnEquipment(cape);
		cape.pickupEquipment(v2);
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(f1, "f1");
		Logger.register(f2, "f2");
		Logger.register(cape, "c");

		///Tesztelés
		v1.stealEquipment(cape, v2);
	}

	public void partialBlockFalse() throws CloneNotSupportedException, IOException {
		// Inicializálás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		ForgettingAgent fa = new ForgettingAgent();
		Field f = new Field(0,0,0);
		Cape cape = new Cape();
		f.spawnEquipment(cape);
		f.addVirologist(v2);
		v1.learnAgent(fa);
		cape.pickupEquipment(v2);
		
		// Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(fa, "fa");
		Logger.register(cape, "cape");
		
		// Tesztelés
		fa.cast(v2);
	}

	public void virologistStepOnStorage() throws CloneNotSupportedException, IOException {
		// Inicializáslás
		Virologist v = new Virologist();
		Storage storage = new Storage(0,0,0);
		Field field = new Field(0,0,0);
		field.addNeighbor(storage);
		storage.addNeighbor(field);
		field.addVirologist(v);
		v.changeField(field);
		
		// Logger enable and register
		Logger.enable();
		Logger.register(storage, "storage");
		Logger.register(field, "field");
		Logger.register(v, "v");
		Logger.register(v.getMovement(), "nm");
		
		// Tesztelés
		v.getMovement().move(v, storage);
		
	}

	public void virologistStepOnShelter() throws CloneNotSupportedException, IOException {
		// Inicializáslás
		Virologist v = new Virologist();
		Shelter shelter = new Shelter(0,0,0);
		Field field = new Field(0,0,0);
		field.addNeighbor(shelter);
		shelter.addNeighbor(field);
		field.addVirologist(v);
		v.changeField(field);
		
		// Logger enable and register
		Logger.enable();
		Logger.register(shelter, "shelter");
		Logger.register(field, "field");
		Logger.register(v, "v");
		Logger.register(v.getMovement(), "nm");
		
		// Tesztelés
		v.getMovement().move(v, shelter);
	}

	public void virologistStepOnField() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v = new Virologist();
		Field f1 = new Field(0,0,0);
		Field f2 = new Field(0,0,0);
		f1.addNeighbor(f2);
		f2.addNeighbor(f1);
		f1.addVirologist(v);
		v.changeField(f1);
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(v.getMovement(), "nm");
		Logger.register(f1, "f1");
		Logger.register(f2, "f2");
		
		///Test
		v.getMovement().move(v,f2);
	}

	public void selfCast() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v = new Virologist();
		Protection p = new Protection();
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(p, "p");
		
		///Test
		p.cast(v);
		
	}

	public void pickupItem() {
		///Inicializáslás
		Virologist v = new Virologist();
		Glove g = new Glove();
		Field f = new Field(0,0,0);
		f.addVirologist(v);
		v.changeField(f);
		f.spawnEquipment(g);
		
		///Logger enable and register
		Logger.enable();
		Logger.register(v, "v");
		Logger.register(g, "g");
		Logger.register(f, "f");
		
		///Test
		g.pickupEquipment(v);
	}

	public void doubleBlockAndReturn() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v1 = new Virologist();
		Virologist v2 = new Virologist();
		Field f1 = new Field(0,0,0);
		Field f2 = new Field(0,0,0);
		Glove g1 = new Glove();
		Glove g2 = new Glove();
		Chorea c = new Chorea();

		f1.addVirologist(v1);
		v1.changeField(f1);
		f1.spawnEquipment(g1);
		g1.pickupEquipment(v1);
		f2.addVirologist(v2);
		v2.changeField(f2);
		f2.spawnEquipment(g2);
		g2.pickupEquipment(v2);
		v1.learnAgent(c);
		

		///Logger enable and register
		Logger.enable();
		Logger.register(v1, "v1");
		Logger.register(v2, "v2");
		Logger.register(g1, "g1");
		Logger.register(g2, "g2");
		Logger.register(c, "c");

		///Test
		c.cast(v2);
	}

	public void cantPickupItem() {
		///Inicializáslás
		Virologist v = new Virologist();
		Cape c = new Cape();
		Glove g1 = new Glove();
		Glove g2 = new Glove();
		Sack s = new Sack();
		Field f1 = new Field(0,0,0);

		f1.spawnEquipment(c);
		c.pickupEquipment(v);
		f1.spawnEquipment(g1);
		g1.pickupEquipment(v);
		f1.spawnEquipment(s);
		s.pickupEquipment(v);
		f1.spawnEquipment(g2);


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

	public void learnChorea() throws CloneNotSupportedException, IOException {
		///Inicializáslás
		Virologist v = new Virologist();
		Chorea c = new Chorea();
		Laboratory l = new Laboratory(0,0,0);

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
		Field target = new Field(0,0,0);

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
