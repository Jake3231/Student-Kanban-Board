import java.util.LinkedList;

public class HomePageUI {
    private String email;
    private int index;
    private String password;
    private String color;
    private LinkedList<Ticket> tickets;
    private Cloud cloud;
    private ModifyUI modifyUI;

    public HomePageUI(ModifyUI modifyUI){
        this.modifyUI = modifyUI;
    }
    public void begin(Cloud cloud, String email, String password){
        //When it is time for to move to the homePage the variable for the account stored in the cloud will be transferred to the homePageUI
        this.cloud = cloud;
        this.email = email;
        this.password = password;
        index = cloud.find(this.email);
        color = cloud.getColor(index, password);
        tickets = cloud.getTickets(index, password);
        display();
    }
    public void display(){
        //This will provide all the necessary details to display the homePage
        System.out.println("display homePage");
        System.out.println("Homepage color: "+color);
        for(int i = 0; i < tickets.size(); i++){
            System.out.println("Ticket"+i+": Color: "+((Ticket) tickets.get(i)).getColor());
            System.out.println("Ticket"+i+": Title: "+((Ticket) tickets.get(i)).getTitle());
            System.out.print("Ticket"+i+": StartDate: "+((Ticket) tickets.get(i)).getStartYear()+":");
            System.out.print(((Ticket) tickets.get(i)).getStartMonth()+":");
            System.out.print(((Ticket) tickets.get(i)).getStartDay()+":");
            System.out.println(((Ticket) tickets.get(i)).getStartTime());
            System.out.print("Ticket"+i+": DueDate: "+((Ticket) tickets.get(i)).getEndYear()+":");
            System.out.print(((Ticket) tickets.get(i)).getEndMonth()+":");
            System.out.print(((Ticket) tickets.get(i)).getEndDay()+":");
            System.out.println(((Ticket) tickets.get(i)).getEndTime()+"\n");
        }
        System.out.println("");
    }

    public void addTicket(String color, String title, String details, int startYear, int startMonth, int startDay, int startTime, int endYear, int endMonth, int endDay, int endTime){
        //This searches through the list of tickets to place the new ticket in a sorted spot.
        //The tickets are sorted in order of earliest due date to latest.
        Ticket ticket = new Ticket(color, title, details, startYear, startMonth, startDay, startTime, endYear, endMonth, endDay, endTime);
        if(tickets.size() == 0 || tickets.get(tickets.size()-1).compareTo(ticket) <= 0){
            tickets.add(ticket);
        }
        else{
            for(int i = tickets.size()-2; i > -1; i--){
                if(tickets.get(i).compareTo(ticket) <= 0){
                    tickets.add(i+1, ticket);
                    i = -1;
                }
            }
        }
        display();
    }

    public void removeTicket(String ticket){
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).getTitle().equals(ticket)){
                tickets.remove(i);
                i = tickets.size();
            }
        }
        display();
    }

    public void addCheckList(String ticket, String title, String details){
        //This adds a checkList item to the ticket's checkLists.
        CheckListElement newCheckList = new CheckListElement(title, details);
        getTicket(ticket).addCheckList(newCheckList);
    }
    
    public CheckListElement removeCheckList(String ticket, String title){
        //This removes a checkList item from the ticket's checkLists.
        return getTicket(ticket).removeCheckList(title);
    }

    public void openTicket(String ticket){
        //This provides the necessary details to open the ticket and display more information.
        getTicket(ticket).openTicket();
    }

    public void check(String ticket, String checkList){
        //This sets a checkList item's check box to the opposite of what it is currently.
        getTicket(ticket).check(checkList);
    }

    public void setCheckListTitle(String ticket, String checkList, String title){
        //This sets a checkList item's title
        getTicket(ticket).setCheckListTitle(checkList, title);
    }

    public void setCheckListDetails(String ticket, String checkList, String details){
        //This sets a checkList items's details
        getTicket(ticket).setCheckListDetails(checkList, details);
    }

    public void setTicketColor(String ticket, String color){
        getTicket(ticket).setColor(color);
    }

    public void setTitle(String ticket, String title){
        getTicket(ticket).setTitle(title);
    }

    public void setDetails(String ticket, String details){
        getTicket(ticket).setDetails(details);
    }
    public void setStartDate(String ticket, int year, int month, int day, int time){
        Ticket tempTicket = getTicket(ticket);
        tempTicket.setStartYear(year);
        tempTicket.setStartMonth(month);
        tempTicket.setStartDay(day);
        tempTicket.setStartTime(time);
    }
    public void setDueDate(String ticket, int year, int month, int day, int time){
        Ticket tempTicket = getTicket(ticket);
        tempTicket.setStartYear(year);
        tempTicket.setStartMonth(month);
        tempTicket.setStartDay(day);
        tempTicket.setStartTime(time);
    }

    public Ticket getTicket(String ticket){
        for(int i = 0; i < tickets.size(); i++){
            if(((Ticket) tickets.get(i)).getTitle().equals(ticket)){
                return tickets.get(i);
            }
        }
        return null;
    }

    public void closeTicket(){
        display();
    }

    public void openModifyUI(){
        //This moves to the modify page UI class.
        modifyUI.begin(this, cloud, index, email, password, color);
    }
}