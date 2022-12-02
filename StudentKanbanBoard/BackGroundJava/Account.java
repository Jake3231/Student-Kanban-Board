import java.util.LinkedList;

public class Account {
    private String userName;
    private String email;
    private String password;
    private String color;
    private LinkedList<Ticket> tickets;
    private long hold;
    public Account(String userName, String email, String password, long hold, LinkedList<Ticket> tickets, String color){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.hold = hold;
        this.tickets = tickets;
        this.color = color;
    }

    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public long getHold(){
        return hold;
    }
    public LinkedList<Ticket> getTickets() {
        return tickets;
    }
    public String getColor() {
        return color;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHold(long hold) {
        this.hold = hold;
    }
    public void setTickets(LinkedList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
