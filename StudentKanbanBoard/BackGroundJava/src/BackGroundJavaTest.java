// import java.time.Clock;

public class BackGroundJavaTest{
    public static void main(String[] args){
        // Clock clock = Clock.systemDefaultZone();
        ModifyUI modifyUI = new ModifyUI();
        HomePageUI homePage = new HomePageUI(modifyUI);
        LoginUI test = new LoginUI(homePage);
        System.out.println("\n1, userName should not work");
        test.createAccount("", "Chaz-Berger@protonmail.com", "testZero");

        System.out.println("\n2, userName should not work");
        test.createAccount("fry", "Chaz-Berger@protonmail.com", "testZero");
        
        System.out.println("\n3, should work");
        test.createAccount("cola", "Chaz-Berger@protonmail.com", "testZero");

        System.out.println("\n4, should work except the email already exists so this should be rejected.");
        test.createAccount("fries", "Chaz-Berger@protonmail.com", "testZero");

        System.out.println("\n5, should work except the username already exists so this should be rejected.");
        test.createAccount("cola", "Chaz_Berger@protonmail.com", "testZero");

        System.out.println("\n6, email should not work");
        test.createAccount("schmoe", "", "testOne");

        System.out.println("\n7, email should not work");
        test.createAccount("schmoe", "joe..schmoe@gmail.com", "testOne");

        System.out.println("\n8, should work");
        test.createAccount("schmoe","joe.schmoe@gmail.com", "testOne");

        System.out.println("\n9, email should not work");
        test.createAccount("joeSchmoe", "joeSchmoegmail.com", "testTwo");

        System.out.println("\n10, email should not work");
        test.createAccount("joeSchmoe", "joeSchmoe@gm#il.com", "testTwo");

        System.out.println("\n11, email should not work");
        test.createAccount("joeSchmoe", "joeSchmoe@gmailcom", "testTwo");

        System.out.println("\n12, email should not work");
        test.createAccount("joeSchmoe", "joeSchmoe@gmail.co", "testTwo");

        System.out.println("\n13, email should not work");
        test.createAccount("joeSchmoe", "joeSchmoe@gmail.comm", "testTwo");

        System.out.println("\n14, email should work");
        test.createAccount("joeSchmoe", "joeSchmoe@gmail.com", "testTwo");

        System.out.println("\n15, password should not work");
        test.createAccount("bigMac", "Ronald_macDonald@gmail.com", "");

        System.out.println("\n16, password should not work");
        test.createAccount("bigMac", "Ronald_macDonald@gmail.com", "testO");

        System.out.println("\n17, password should work");
        test.createAccount("bigMac", "Ronald_macDonald@gmail.com", "testThree");

        System.out.println("\n18, email should not work");
        test.login("Ronald_macDonaldgmail.com", "testThree");

        System.out.println("\n19, account doesn't exist and should not sign in.");
        test.login("hacker@sus.com", "testOne");

        System.out.println("\n20, wrong password should not work");
        test.login("joeSchmoe@gmail.com", "testOne");

        System.out.println("\n21, wrong password should not work");
        test.login("Ronald_macDonald@gmail.com", "testOne");

        System.out.println("\n22, should work, and hold count should be reset");
        test.login("Ronald_macDonald@gmail.com", "testThree");

        homePage.addTicket("Red", "Get Burger", "Get a big cheese burger", 2022, 11, 23, 16, 2022, 11, 23, 17);
        homePage.addTicket("Blue", "Eat Burger", "Self Explanitory.", 2022, 11, 23, 17, 2022, 11, 23, 18);
        homePage.addTicket("Purple", "Poop Burger", "Do not do so too quickly or else it will make a mess, and do not do so too slowly or it could be painful.", 2022, 11, 23, 18, 2022, 11, 24, 21);
        homePage.addCheckList("Poop Burger", "Flush Toilet", "Do this after the buisiness is complete");
        homePage.addCheckList("Poop Burger", "Wash Hands", "Don't be gross");
        homePage.setTitle("Poop Burger", "Naturally Dispose of Burger");
        homePage.setDetails("Naturally Dispose of Burger", "Do this carefully.");
        homePage.setCheckListTitle("Naturally Dispose of Burger", "Wash Hands", "Rinse Hands");
        homePage.setCheckListDetails("Naturally Dispose of Burger", "Rinse Hands", "This is optional.");
        homePage.setStartDate("Naturally Dispose of Burger", 2022, 11, 23, 17);
        homePage.setDueDate("Naturally Dispose of Burger", 2022, 12, 25, 0);
        homePage.removeCheckList("Naturally Dispose of Burger", "Rinse Hands");
        homePage.check("Naturally Dispose of Burger", "Flush Toilet");
        homePage.closeTicket();
        homePage.addTicket("Green", "Eat Healthy", "Try to eat healthy foods for a week.", 2022, 11, 23, 17, 2022, 11, 24, 0);
        homePage.removeTicket("Eat Healthy");
        homePage.openModifyUI();

        modifyUI.changeColor();
        modifyUI.changeEmail("Chaz-Berger@protonmail.com");
        modifyUI.changeEmail("Chaz-Berger@gmail.com");
        modifyUI.changeEmail("Chaz-Berger@gmail.com");
        modifyUI.changeUserName("cola");
        modifyUI.changeUserName("fries");
        modifyUI.changeUserName("fries");
        modifyUI.changePassword("testFour");
        modifyUI.close();
    }
}