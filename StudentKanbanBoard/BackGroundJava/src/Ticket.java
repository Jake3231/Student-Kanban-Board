import java.util.LinkedList;

public class Ticket implements Comparable<Ticket>{
    private String color;
    private String title;
    private String details;
    private LinkedList<CheckListElement> checkLists;
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startTime;
    private int endYear;
    private int endMonth;
    private int endDay;
    private int endTime;

    public Ticket(String color, String title, String details, int startYear, int startMonth, int startDay, int startTime, int endYear, int endMonth, int endDay, int endTime){
        this.color = color;
        this.title = title;
        this.details = details;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startTime = startTime;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endTime = endTime;
    }

    public void setColor(String color) {
        this.color = color;
        openTicket();
    }
    public void setTitle(String title) {
        this.title = title;
        openTicket();
    }
    public void setDetails(String details) {
        this.details = details;
        openTicket();
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }
    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }
    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public void setCheckLists(LinkedList<CheckListElement> checkLists){
        this.checkLists = checkLists;
    }
    public void addCheckList(CheckListElement checkList){
        if(checkLists == null){
            checkLists = new LinkedList<>();
        }
        checkLists.add(checkList);
        openTicket();
    }
    public void setCheck(String checkList, boolean checked){
        getCheckList(checkList).setChecked(checked);
        openTicket();
    }
    public void check(String checkList){
        getCheckList(checkList).check();
        openTicket();
    }
    public void setCheckListTitle(String checkList, String title){
        getCheckList(checkList).setTitle(title);
        openTicket();
    }
    public void setCheckListDetails(String checkList, String details){
        getCheckList(checkList).setDetails(details);
        openTicket();
    }
    public CheckListElement removeCheckList(String title){
        for(int i = 0; i < checkLists.size(); i++){
            if(checkLists.get(i).getTitle().equals(title)){
                CheckListElement temp = checkLists.remove(i);
                openTicket();
                return temp;
            }
        }
        return null;
    }
    public void openTicket(){
        System.out.println("Open Ticket:");
        System.out.println("Title: "+title);
        System.out.println("Details: "+details);
        if(checkLists == null){
            checkLists = new LinkedList<>();
        }
        System.out.println("Check List: ");
        for(int i = 0; i < checkLists.size(); i++){
            System.out.println("Item "+i+": Title: "+checkLists.get(i).getTitle());
            System.out.println("Item "+i+": Checked: "+checkLists.get(i).checked());
            if(checkLists.get(i).getDetails() != null){
                System.out.println("Item "+i+": Details: "+checkLists.get(i).getDetails());
            }
            System.out.println("");
        }
    }
    public boolean getCheck(String checkList){
        return getCheckList(checkList).checked();
    }
    public String getColor() {
        return color;
    }
    public String getTitle() {
        return title;
    }
    public String getDetails() {
        return details;
    }
    public int getStartYear() {
        return startYear;
    }
    public int getStartMonth() {
        return startMonth;
    }
    public int getStartDay() {
        return startDay;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndYear() {
        return endYear;
    }
    public int getEndMonth() {
        return endMonth;
    }
    public int getEndDay(){
        return endDay;
    }
    public int getEndTime() {
        return endTime;
    }
    public LinkedList<CheckListElement> getCheckLists(){
        return checkLists;
    }

    public CheckListElement getCheckList(String checkList){
        for(int i = 0; i < checkLists.size(); i++){
            if(checkLists.get(i).getTitle().equals(checkList)){
                return checkLists.get(i);
            }
        }
        return null;
    }

    @Override
    public int compareTo(Ticket ticket){
        //This compareTo method compares the tickets based on the due date.
        if(endYear < ticket.endYear){
            return -4;
        }
        else if(endYear > ticket.endYear){
            return 4;
        }
        else{
            if(endMonth < ticket.endMonth){
                return -3;
            }
            else if(endMonth > ticket.endMonth){
                return 3;
            }
            else{
                if(endDay < ticket.endDay){
                    return -2;
                }
                else if(endDay > ticket.endDay){
                    return 2;
                }
                else{
                    if(endTime < ticket.endTime){
                        return -1;
                    }
                    else if(endTime > ticket.endTime){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }
}