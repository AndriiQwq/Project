package game;

import characters.*;
import java.util.*;
import java.io.*;
import SLList.*;

public class Game implements Serializable {
	private List<Ogre> ogres;
	private List<Knight> knights;

	transient private Iterator<Ogre> iterOgres;
	transient private Iterator<Knight> iterKnights;
	
	transient private Ogre fightingOgre;
	transient private Knight fightingKnight;

	private int numberOfWarriors;

	public int getNumberOfWarriors() {
		return numberOfWarriors;
	}
	
	static int findEnergyDifference(Energy being1, Energy being2) {
		return being1.getEnergy() - being2.getEnergy();
	}

	public void createWarriors(int nKnights, int nBraveKnights, int nBadOgres, GameSetup gameSetup)
		throws UnevenNumberOfWarriorsException {
		if (nBadOgres > nKnights + nBraveKnights)
			throw new UnevenNumberOfWarriorsException();

		numberOfWarriors = nKnights + nBraveKnights;
		knights = new ArrayList<>();
		ogres = new ArrayList<>();

		gameSetup.setup(knights, ogres, nKnights, nBraveKnights, nBadOgres);

		initClash();
	}
	
	public Game() {
	}

	public Game(int nKnights, int nBraveKnights, int nBadOgres, GameSetup gameSetup) //{
		throws UnevenNumberOfWarriorsException {
		createWarriors(nKnights, nBraveKnights, nBadOgres, gameSetup);
	}

	public void clash1on1(Knight knight, Ogre ogre) {
		knight.attack(ogre);
	}

	public void initClash() {
		iterOgres = ogres.iterator();
		iterKnights = knights.iterator();
	}

	public String nextClash1on1() {
		fightingKnight = iterKnights.next();
		fightingOgre = iterOgres.next();
		
		clash1on1(fightingKnight, fightingOgre);
		
		return knights.indexOf(fightingKnight) + ":"
			+ "knight " + fightingKnight.getEnergy()
			+ " / " + "ogre " + fightingOgre.getEnergy()
			+ " " + fightingKnight.showSword()
			+ "\n";
	}
	
	public String clash() {
		String report = "";
				
		while (iterOgres.hasNext())
			report = report + nextClash1on1();

		return report;
	}
	
	private int calculateEnergy(List<? extends Energy> list) {
		int energy = 0;
		
		for (Energy e : list)
			energy += e.getEnergy();
		
		return energy;
	}
	
	public int ogresEnergy() {
		return calculateEnergy(ogres);
	}

	public int knightsEnergy() {
		return calculateEnergy(knights);
	}

	public void save() throws ClassNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.out"));
		out.writeObject(this);
		out.close();
	}
	
	public void load() throws ClassNotFoundException, IOException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.out"));
		Game loadedGame = (Game) in.readObject();
		in.close();
		
		ogres = loadedGame.ogres;
		knights = loadedGame.knights;
		numberOfWarriors = loadedGame.numberOfWarriors;

		iterOgres = ogres.iterator();
		iterKnights = knights.iterator();
	}

	public int countWarriors(Class<? extends Warrior> Type) {
		int n = 0;

		for (Warrior warrior : knights)
			if (Type.isInstance(warrior))
				n++;

		for (Warrior warrior : ogres)
			if (Type.isInstance(warrior))
				n++;

		return n;
	}
}
