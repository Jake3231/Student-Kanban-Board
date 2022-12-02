import java.util.Scanner;

public class LoginUI{
    private HomePageUI homePage;
    private String userName;
    private String email;
    private String password;
    private Scanner terminalInput = new Scanner(System.in);
    private LoginManager loginManager = new LoginManager();
    public LoginUI(HomePageUI homePage){
        this.homePage = homePage;
    }
    public void createAccount(){
        System.out.println("Please enter a username.");
        //Check if the username is valid, if the user name is invalid the program will loop until a valid username is entered.
        do{
            userName = terminalInput.next();
            if(userName.length() < 4){
                System.out.println("The username is too short please enter a username with at least four characters.");                
            }
        }while(userName.length() < 4);
        System.out.println("Please enter an email address.");
        boolean valid = true;
        //Check if the email is valid, if the email is invalid the program will loop until a valid email is entered.
        do{
            userName = terminalInput.next();
            valid = loginManager.checkEmail(userName);
            if(valid == false){
                System.out.println("The email address entered had an error please enter a real email address.");
            }
        } while(valid == false);
        //Check if a valid password is submitted if an password the password is invalid the program will loop until a valid password is entered.
        do{
            System.out.println("Please enter a Password.");
            password = terminalInput.next();
            if(password.length() < 6){
                System.out.println("The Password is too short please enter a password with at least six characters.");
            }
        }while(password.length() < 6);
        //The account is created and a confirmation message is displayed
        System.out.println(loginManager.createNewAccount(userName, email, password));
    }

    //This option is available for when the userName and password are provided in the call.
    public void createAccount(String userNameInput, String emailInput, String passwordInput){
        System.out.println("Please enter a username.");
        //Check if the username is valid.
        userName = userNameInput;
        if(userName.length() < 4){
            System.out.println("The username is too short please enter a username with at least four characters.");                
        }
        else{
            System.out.println("Please enter an email address.");
            boolean valid = true;
            //Check if the email is a valid.
            email = emailInput;
            valid = loginManager.checkEmail(email);
            if(valid == false){
                System.out.println("The email address entered had an error please enter a real email address.");
            }
            else{
                //Check if a valid password is submitted.
                System.out.println("Please enter a Password.");
                password = passwordInput;
                if(password.length() < 6){
                    System.out.println("The Password is too short please enter a password with at least six characters.");
                }
                else{
                //The account is created and a confirmation message is displayed
                System.out.println(loginManager.createNewAccount(userName, email, password));
                }
            }
        }
    }

    public void login(){
        System.out.println("Please enter your email address.");
        boolean valid = true;
        //Check if the email is a valid, if the email is invalid the program will loop until a valid email is entered.
        do{
            email = terminalInput.next();
            valid = loginManager.checkEmail(email);
            if(valid == false){
                System.out.println("The email address entered had an error please enter a real email.");
            }
        } while(valid == false);
        //Check if a valid password is submitted if an password the password is invalid the program will loop until a valid password is entered.
        do{
            System.out.println("Please enter a Password.");
            password = terminalInput.next();
            if(password.length() < 6){
                System.out.println("The Password is too short please enter a real password.");
            }
        }while(password.length() < 6);
        Cloud result = loginManager.login(email, password);
        if(result == null){
            //We don't want people to know this information so the response is replaced with the following.
            System.out.println("Wrong Email Address and/or Password");
        }
        else{
            homePage.begin(result, email, password);
        }
    }

    //This option is available for when the userName and password are provided in the call.
    public void login(String emailInput, String passwordInput){
        System.out.println("Please enter your email address.");
        boolean valid = true;
        //Check if the email is a valid.
        email = emailInput;
        valid = loginManager.checkEmail(email);
        if(valid == false){
            System.out.println("The email address entered had an error please enter a real email address.");
        }
        else{
            //Check if a valid password is submitted.
            System.out.println("Please enter a Password.");
            password = passwordInput;
            if(password.length() < 6){
                System.out.println("The Password is too short please enter a real password.");
            }
            else{
                Cloud result = loginManager.login(email, password);
                if(result == null){
                    //We don't want people to know this information so the response is replaced with the following.
                    System.out.println("Wrong Email Address and/or Password");
                }
                else{
                    homePage.begin(result, email, password);
                }
            }
        }
    }
}