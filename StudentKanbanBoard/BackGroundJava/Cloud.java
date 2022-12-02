import java.util.*;

public class Cloud{
    private LinkedList<Account> accounts = new LinkedList<>();
    
    public boolean createAccount(String userName, String email, String password){
        if(findUserName(userName) == -1 && find(email) == -1){
            LinkedList<Ticket> tickets = new LinkedList<>();
            Account newAccount = new Account(userName, email, password, (long) 0, tickets, "dark");
            accounts.add(newAccount);
            return true;
        }
        else{
            return false;
        }
    }
    public int findUserName(String userName){
        //This finds the account using the user name and returns the index;
        for(int i = 0; i < accounts.size(); i ++){
            if(accounts.get(i).getUserName().equals(userName) == true){
                return i;
            }
        }
        return -1;
    }
    public int find(String email){
        //This finds the account using the email and returns the index;
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getEmail().equals(email) == true){
                return i;
            }
        }
        return -1;
    }
    public LinkedList<Ticket> getTickets(int index, String password){
        if(accounts.get(index).getPassword().equals(password)){
            return ((LinkedList<Ticket>) accounts.get(index).getTickets());
        }
        else{
            return null;
        }
    }
    public String getColor(int index, String password){
        if(accounts.get(index).getPassword().equals(password)){
            return ((String) accounts.get(index).getColor());
        }
        else{
            return null;
        }
    }
    public String getUserName(int index, String password){
        if(accounts.get(index).getPassword().equals(password)){
            return ((String) accounts.get(index).getUserName());
        }
        return null;
    }
    
    public void setUserName(int index, String password, String userName){
        if(accounts.get(index).getPassword().equals(password)){
            accounts.get(index).setUserName(userName);
        }
    }

    public void setEmail(int index, String password, String email){
        if(accounts.get(index).getPassword().equals(password)){
            accounts.get(index).setEmail(email);;
        }
    }

    public void setPassword(int index, String password, String newPassword){
        if(accounts.get(index).getPassword().equals(password)){
            accounts.get(index).setPassword(newPassword);
        }
    }

    public void setColor(int index, String password, String color){
        if(accounts.get(index).getPassword().equals(password)){
            accounts.get(index).setColor(color);
        }
    }

    public boolean passwordsEqual(int index, String password, int secretPassword){
        if(secretPassword == 688740309){
            return accounts.get(index).getPassword().equals(password);
        }
        return false;
    }

    public long getHold(int index, String password){
        if(password.equals(accounts.get(index).getPassword())){
            return ((long) accounts.get(index).getHold());
        }
        return -1;
    }

    public void setHold(int index, long hold, String password){
        if(password.equals(accounts.get(index).getPassword())){
            accounts.get(index).setHold(hold);
        }
    }
}