public class CheckListElement {
    //This is a class that contains the information for an element of a checkList.
    private boolean checked;
    private String title;
    private String details;
    public CheckListElement(String title, String details){
        checked = false;
        this.title = title;
        this.details = details;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public void check(){
        if(checked){
            checked = false;
        }
        else{
            checked = true;
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public boolean checked(){
        return checked;
    }
    public String getTitle() {
        return title;
    }
    public String getDetails() {
        return details;
    }
}