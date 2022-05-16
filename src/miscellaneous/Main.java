package miscellaneous;

import java.io.IOException;

import graphic.MainMenu;

/**
 * A program elindításáért felelős osztály, létrehozza a menüt
 */
public class Main {
	public static void main(String[] args) throws CloneNotSupportedException, IOException {
		//Tester tester = new Tester();
		//tester.runTest();
		//Control.runControl();
		MainMenu mainmenu = new MainMenu();
		mainmenu.f.setVisible(true);
	}
}
