public class ToDoList implements Date{
    public ToDoList(String name, int day, int month, int year, String description){
        this.name = name;
        this.date[0] = day;
        this.date[1] = month;
        this.date[2] = year;
        this.description = description;
        this.complete = false; //task is "not complete" on creation by default
    }

    //getters
    public String getName(){
        return name;
    }
    public int[] getDate(){
        //... override from interface
        //... day, month, and year. whatever is reading this will have to pull values individually from returned array
        return date;
    }
    public String getDescription(){
        return description;
    }
    public boolean getCompleteStatus(){
        return complete;
    }

    //setters
    //have to make sure these are legal inputs
    public void setName(String name){
        this.name = name;
    }
    public void setDay(int day){
        //... override from interface
        this.date[0] = day;
    }
    public void setMonth(int month){
        this.date[1] = month;
    }
    public void setYear(int year){
        this.date[2] = year;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setStatus(boolean complete){ //this generally presumes that the input is "true", however, can be used if a task was mistakenly marked complete
        //can only be corrected until save state is written; Account save() method will wipe tasks which have been "completed"
        this.complete = complete;
    }
    

    private String name;
    private int[] date; //0 = day, 1 = month, 2 = year
    private String description;
    private boolean complete;
}