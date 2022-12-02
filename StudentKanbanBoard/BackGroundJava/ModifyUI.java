public class ModifyUI {
    private Cloud cloud;
    private HomePageUI homePage;
    private LoginManager loginManager = new LoginManager();
    private String userName;
    private String email;
    private String password;
    private String color;
    private int index;

    public void begin(HomePageUI homePage, Cloud cloud, int index, String email, String password, String color){
        this.homePage = homePage;
        this.cloud = cloud;
        this.index = index;
        userName = cloud.getUserName(index, password);
        this.email = email;
        this.password = password;
        this.color = color;
        display();
    }

    public void display(){
        //displays all the necessary information for this page.
        System.err.println("Display Modify Page");
        System.err.println("UserName: "+userName);
        System.err.println("Email Adress: "+email);
        System.err.println("Password: "+password);
        System.err.println("BackGround Color: "+color+"\n");
    }

    public void changeUserName(String userName){
        //This changes the userName but first check to make sure the new userName is valid.
        if(this.userName.equals(userName)){
            System.err.println("The username entered is your current username please enter a different username.");
        }
        else if(userName.length() < 4){
            System.out.println("The username is too short please enter a username with at least four characters.");                
        }
        else if(cloud.findUserName(userName) != -1){
            System.out.println("The username entered already exists please enter a different username");
        }
        else{
            cloud.setUserName(index, password, userName);
            this.userName = userName;
        }
        display();
    }

    public void changeEmail(String email){
        //This changes the email address but firsts checks to make sure the email address is valid.
        if(this.email.equals(email)){
            System.err.println("The email address entered is your current email address. Please enter a different email address.");
        }
        else if(loginManager.checkEmail(email) == false){
            System.out.println("The email address entered had an error please enter a real email address.");
        }
        else if(cloud.find(email) != -1){
            System.out.println("The email address entered already exists. Please enter a different email address.");
        }
        else{
            cloud.setEmail(index, password, email);
            this.email = email;
        }
        display();
    }

    public void changePassword(String newPassword){
        //This changes the password but first checks to see if the new password is valid or if it is not the current password.
        if(password.equals(newPassword)){
            System.err.println("The password entered is the same password as your current password. Please enter a different password.");
        }
        else if(newPassword.length() < 6){
            System.out.println("The Password is too short please enter a password with at least six characters.");
        }
        else{
            cloud.setPassword(index, password, newPassword);
            this.password = newPassword;
        }
        display();
    }

    public void changeColor(){
        //This changes the color from dark to light or from light to dark.
        if(color.equals("dark")){
            cloud.setColor(index, password, "light");
            this.color = "light";
        }
        else{
            cloud.setColor(index, password, "dark");
            this.color = "dark";
        }
        display();
    }

    public void close(){
        //This exits the modify page and goes back to the home page.
        homePage.begin(cloud, email, password);
    }
}