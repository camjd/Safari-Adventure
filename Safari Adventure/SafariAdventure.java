import java.util.Scanner;
import java.util.Random;

public class SafariAdventure{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Display welcome message
        displayWelcome();

        // Keep track of points
        int totalPoints = 0;
        // Track if they are dead
        boolean isDead = false;
        
        // Each day until 5 days
        for (int day = 1; day <= 5; ++day){
            System.out.println("\nDAY " + day + "...");

            // Choose where to explore
            String area;
            boolean eventsComplete = false;
            do {
                System.out.print("\nWhere would you like to explore? (Jungle, River, Desert, Mountains): ");
                area = scanner.nextLine().toLowerCase();
                
                // Check that they chose a correct area
                if (area.equals("jungle") || area.equals("river") || area.equals("desert") || area.equals("mountains")) {
                    System.out.println("\nYou chose the " + area + " to explore!");
                    System.out.println("Exploring " + area + "...");

                    // Start the events and count them
                    int eventCounter = 1;
                    int dayPoints = 0;
                    while(eventCounter <= 3) {

                        // Ask to start the next event
                        String nextEvent;
                        System.out.print("\nStart the next event? (Y or N): ");
                        nextEvent = scanner.nextLine();
                        
                        // Event counter
                        System.out.print("\nEvent " + eventCounter + ": \n");

                        // Yes to nextEvent
                        if (nextEvent.equalsIgnoreCase("y")) {
                            // 0 to 4 possible events
                            Random rand = new Random();
                            int event = rand.nextInt(5);

                            // Possible events
                            switch (event) {
                                case 0:
                                    System.out.println("You spotted a bird!" + "\n(Too small to track. Moving on.)");
                                    break;
                                case 1:
                                    System.out.println("You found edible berries! (+15 points)");
                                    dayPoints += 15;
                                    break;
                                case 2:
                                {
                                    String escape = "";
                                        // A monster appears!
                                        System.out.print("A monster appears!" + "\nType 'run' to escape! : ");

                                        // Escape the monster loop
                                        while(!escape.equalsIgnoreCase("run")){
                                                escape = scanner.nextLine();

                                            if (!escape.equals("run")){
                                                System.out.print("The monster is still there! Type 'run': ");
                                            }
                                    }
                                    int escapeChance = rand.nextInt(10);

                                    if (escapeChance >= 3) {
                                        System.out.println("\nYou escaped safely, ending the day early.");
                                        eventCounter = 4;
                                        break;
                                    } else {
                                        System.out.println("\nYou tried to run.. and the monster ate you. GAME OVER.");
                                        eventCounter = 4;
                                        day = 6;
                                        isDead = true;
                                        break;
                                    }

                                }
                                case 3:
                                    System.out.println("You discovered treasure! (+10 points)");
                                    dayPoints += 10;
                                    break;
                                case 4:
                                    System.out.println("You sprained your leg.. Oh no! (-5 points)");
                                    dayPoints -= 5;
                                    break;
                                default:
                                    break;
                            }   
                        } else {
                            System.out.println("You chose to skip this event.");
                        }

                        // Count events
                        eventCounter++;
                        if (eventCounter >= 3) {
                            eventsComplete = true;
                        }
                    }

                    // Print out day points if they are alive
                    if (isDead == false) {
                        System.out.println("\nDay summary: " + dayPoints + " added.");
                        System.out.println("-----------------------------");
                        totalPoints += dayPoints;
                    }

                } else {
                    System.out.println("\nChoose a correct area please.");
                }
            } while (eventsComplete == false);
        }

        if (isDead == false) {
            System.out.println("\nSafari complete! You collected " + totalPoints + " points in total!");
            System.out.println("You survived and completed the adventure!");
        } else {
            System.out.println("The safari was never complete... You are inside a monster stomach.");
        }

        scanner.close();
    }

    // METHOD — Welcome message
    public static void displayWelcome(){
        System.out.println("\n🌄 Welcome to Safari Adventure!");
    }

}