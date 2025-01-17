import java.util.Scanner;

public class TicketChanges {
    private String makeChanges;
    private int changeSelection;

    Scanner in = new Scanner(System.in);
	public String check(){
		System.out.print("Would you like to make any changes to your reservation? (Y/N)");
		//Scanner	in = new Scanner(System.in);
		makeChanges = in.next();
		return makeChanges;
	}
    public void print(){
        System.out.println("What would you like to change on your ticket?");
        System.out.println("Press 1 to change the name on the ticket");
        System.out.println("Press 2 to change the reserved seat");
        System.out.println("Press 3 to cancel your ticket");
    }
    public int getSelection(){
        //Scanner in = new Scanner(System.in);
        changeSelection = in.nextInt();
        System.out.print("Your selection:" + changeSelection);
        System.out.println();
        return changeSelection;
    }


    public void cases(Ticket ticket1, Flight chosenFlight, int changeSelection){
        //intelij suggested this, an enhanced switch
        switch (changeSelection) {
            case 1 : {
                System.out.print("Enter a new name: ");
                String name = in.next();
                ticket1.setName(name);
                chosenFlight.reserveSeat(ticket1.getSeatNum(), name);
                System.out.println();
                System.out.println("Name has been successfully changed.");
                ticket1.print();
                break;
            }
            case 2 : {
                chosenFlight.cancelSeatReservation(ticket1.getSeatNum());
                chosenFlight.getOpenSeats();
                System.out.print("Enter a new seat number: ");
                int newSeat = in.nextInt();
                chosenFlight.reserveSeat(newSeat, ticket1.getName());
                //do we need another obj? 
                Ticket ticket2 = new Ticket(chosenFlight.getSourceCity(), chosenFlight.getDestinationCity(), chosenFlight.getIdentifier(), newSeat, ticket1.getName(), chosenFlight.getPrice(), chosenFlight.getFlightTime(), chosenFlight.getSeatList().get(newSeat - 1).getClassType(), chosenFlight.getSeatUpcharge(newSeat));
                System.out.println();
                System.out.println("Seat has been successfully changed.");
                ticket2.print();
                break;
            }
            case 3 : {
                ticket1.cancelTicket();
                ticket1.print();
                System.out.println("Ticket canceled.");
                break;
            }
            default : System.out.println("No valid selection");
        }
    }

	public TicketChanges(Ticket ticket1, Flight chosenFlight, int changeSelection){
        

    }
}

