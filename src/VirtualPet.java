public class VirtualPet {

	boolean isAlive() {
		return true;
	}
	
	String name;
	
	int hunger = 40;
	int thirst = 40;
	int waste = 40;
	int boredom = 40;
	int sleepiness = 40;

	void tick() {
		hunger += 5;
		thirst += 5;
		waste += 5;
		boredom += 5;
		sleepiness += 5;
	}

	String feed() {
		hunger -= 40;
		thirst += 12;
		waste += 22;
		return "";
	}

	String giveWater() {
		thirst -= 40;
		waste += 12;
		return "";
	}

	String takeToPoop() {
		waste -= 50;
		boredom += 25;
		return "";
	}

	String play() {
		boredom -= 40;
		hunger += 8;
		thirst += 12;
		return "";
	}
	String sleep() {
		sleepiness -= 50;
		hunger += 25;
		thirst += 25;
		waste += 30;
		return "";
	}

	boolean isHungry() {
		return hunger >= 60;
	}
	
	boolean isThirsty() {
		return thirst >= 60;
	}
	
	boolean needsToPoop() {
		return waste >= 80;
	}
	
	boolean isBored() {
		return boredom >= 60;
	}
	
	boolean isSleepy() {
		return sleepiness >= 80;
	}
	
	boolean isDead() {
		return hunger > 100 || thirst > 100 || waste > 120 || sleepiness > 150;
		
	}
}
