import java.time.Clock;

public class LoginManager{
    private int  secretPassword = 688740309;
    private Cloud cloud = new Cloud();
    private Clock clock = Clock.systemDefaultZone();

    public Cloud login(String email, String password){
        int i = cloud.find(email);
        if(i > -1){
            if(cloud.passwordsEqual(i, password, secretPassword)){
                if(cloud.getHold(i, password) > -3 && cloud.getHold(i, password) <= 0){
                    cloud.setHold(i, (long) 0, password);
                    return cloud;
                }
                else{
                    if(cloud.getHold(i, password) < clock.millis()){
                        cloud.setHold(i, (long) 0, password);
                        return cloud;
                    }
                    else{
                        System.out.println("A hold has been placed on your account until a few minutes have passed.");
                        return null;
                    }
                }
            }
            else{
                if(cloud.getHold(i, password) > -3 && cloud.getHold(i, password) <= 0){
                    cloud.setHold(i, cloud.getHold(i, password)-1, password);
                    return null;
                }
                else if(cloud.getHold(i, password) <= -3){
                    cloud.setHold(i, clock.millis()+60000, password);
                    System.out.println("Too many wrong attempts: A hold has been placed on your account until a few minutes have passed.");
                    return null;
                }
                else{
                    if(cloud.getHold(i, password) < clock.millis()){
                        cloud.setHold(i, (long) -1, password);
                        return null;
                    }
                    else{
                        System.out.println("Too many wrong attempts: A hold has been placed on your account until a few minutes have passed.");
                        return null;
                    }
                }
            }
        }
        else{
            return null;
        }
    }

    public String createNewAccount(String userName, String email, String password){

        if(cloud.createAccount(userName, email, password) == true){
            return "Account Created";
        }
        else{
            return "Account Already Exists";
        }
    }

    public boolean checkEmail(String email){
        boolean valid;
        int stage = -1;
        valid = true;
        for(int i = 0; i < email.length(); i++){
            if(i <= 255 && stage == -1){
                if(email.charAt(i) == '@' && i != 0){
                    stage = i;
                }
                else if(email.charAt(i) == '.' && email.charAt(i+1) == '.'){
                    //check for improper period usage.
                    valid = false;
                }
            }
            else if(stage > -1 && i-stage < 64){
                if(email.charAt(i) == '@'){
                    //make sure @ is not used twice
                    valid = false;
                }
                else if(email.charAt(i) == '.'){
                    //make sure the period is used once after the @
                    stage = 0;
                    if(email.length()-i-1 != 3 || email.charAt(i+1) == '.' || email.charAt(i+2) == '.' || email.charAt(i+3) == '.'){
                        //make sure chars after the period are three and do not contain any more periods
                        valid = false;
                    }
                }
                switch (email.charAt(i)){
                    case '!':
                    case '@':
                    case '#':
                    case '$':
                    case '%':
                    case '^':
                    case '&':
                    case '*':
                    case '(':
                    case ')':
                    case '-':
                    case '_':
                    case '=':
                    case '+':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                    case ';':
                    case ':':
                    case '"':
                    case ',':
                    case '/':
                    case '?':
                        valid = false;
                        //make sure these characters are not used in the domain section of the email address
                    default:
                }
            }
            else{
                //if the domain size is invalid
                valid = false;
            }
        }
        if(stage != 0){
            valid = false;
            //checks if the @ was used once and a period followed it.
        }
        return valid;
    }
}