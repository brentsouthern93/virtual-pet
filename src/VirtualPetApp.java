import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPet pet = new VirtualPet();

		// welcoming message and quit option info

		writeLine("Welcom to Virtual Pet Simulation. Your pet is your responsability!");
		writeLine("To leave the simulation at any time, type 'quit'");
		writeLine("Your virtual pet for this simulaiton is an imaginary creature *like a pokemon*!");
		writeLine("What do you want to name your pet?");
		pet.name = input.next();
		checkForQuit(pet.name);
		writeLine("Hello " + pet.name + "!" + " Welcome to the simulation!" + "\n"
				+ "Type \"stats\" to see your pet's stats.");

		// loop starts and does a series of "if" statements (if your pet is "_____", then tend to it)

		do {
			if (pet.isHungry()) {
				writeLine(pet.name + " is hungry." + "\n");
			}

			if (pet.isThirsty()) {
				writeLine(pet.name + " is thirsty." + "\n");
			}

			if (pet.needsToPoop()) {
				writeLine(pet.name + " needs to poop." + "\n");
			}

			if (pet.isBored()) {
				writeLine(pet.name + " wants to play." + "\n");
			}

			if (pet.isSleepy()) {
				writeLine(pet.name + " needs sleep." + "\n");
			}

			if (pet.isDead()) {
				writeLine("You let " + pet.name + " perish! You Bastard!");
				writeLine("Game Over");
				System.exit(0);
			}

			// action menu

			String menu = ("What would you like to do? " + "\n" + "1. Feed " + pet.name + "." + "\n"
					+ "2. Give water to " + pet.name + "." + "\n" + "3. Take " + pet.name + " to go poop." + "\n"
					+ "4. Play with " + pet.name + "." + "\n" + "5. Let " + pet.name + " sleep." + "\n"
					+ "6. Do nothing.");

			writeLine(menu);

			// user inputs what action the wanted to do from the menu

			String choice = input.next();
			checkForQuit(choice);

			// if user's choice is typing 'stats', they will see the pet's stats

			if (choice.toLowerCase().equals("stats")) {
				writeLine("Hunger level: " + pet.hunger + "\n" + "Thirst level: " + pet.thirst + "\n" + "Poop Level: "
						+ pet.waste + "\n" + "Boredom level: " + pet.boredom + "\n" + "Sleepiness level: "
						+ pet.sleepiness + "\n");
				continue;
			}

			// Asking user what action they would like to take to their alien.

			switch (choice) {
			case "1":
				choice = pet.feed();
				writeLine("You fed " + pet.name + "." + "\n");
				break;

			case "2":
				choice = pet.giveWater();
				writeLine("You gave " + pet.name + "a drink." + "\n");
				break;

			case "3":
				choice = pet.takeToPoop();
				writeLine("You take " + pet.name + " to the bathroom." + "\n");
				break;

			case "4":
				choice = pet.play();
				writeLine("You play with " + pet.name + "." + "\n");
				break;

			case "5":
				choice = pet.sleep();
				writeLine("You take " + pet.name + " to bed." + "\n");
				break;

			case "6":
				writeLine(pet.name + " wow, you're a lazy pet owner." + "\n");
				break;
			}

			// code to make it impossible for attributes to go under 0

			if (pet.hunger < 0) {
				pet.hunger = 0;
			}

			if (pet.thirst < 0) {
				pet.thirst = 0;
			}

			if (pet.waste < 0) {
				pet.waste = 0;
			}

			if (pet.boredom < 0) {
				pet.boredom = 0;
			}

			if (pet.sleepiness < 0) {
				pet.sleepiness = 0;
			}

			// when simulation ticks, a day goes by and stats go up

			writeLine("The simulation advanced a day." + "\n" + "All stats have increased by 5." + "\n");
			pet.tick();

		} while (pet.isAlive());

		input.close();
	}

	public static void writeLine(String message) {
		System.out.println(message);
	}

	public static void writeLine(int message) {
		System.out.println(message);
	}

	public static void checkForQuit(String input) {
		if (input.equalsIgnoreCase("quit")) {
			System.out.println("Sorry to see you leave! Come back again");
			System.exit(0);
		}
	}
}