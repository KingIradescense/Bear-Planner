public class Planner extends ToDoList implements Date{ //can probably remove date information from this class because Account keeps track of it regardless. leave it for now
    public Planner(String name, String description, int start_hour, int start_minute, int end_hour, int end_minute, int day, int month, int year){
        //assign these to the private variables. use ToDoList constructor
        //have start_minute and end_minute only be multiples of 5 or 10
        super(String name, int day, int month, int year, String description);
        this.start[0] = start_hour;
        this.start[1] = start_minute;
        this.end[0] = end_hour;
        this.end[1] = end_minute;
        repeat = false;
    }
    //polymorph for the scenario in which an event is repeating. must include which days, on what time basis, and end date
    //also, don't allow users to span more than 1 day with a Planner object (end_hour/end_minute must be numerically after start_hour/minutee)
    //also check if the times are legal
    public Planner(String name, String description, int start_hour, int start_minute, int end_hour, int end_minute, int day, int month, int year, int[] repeat_days, int[] repeat_months, int[] end_date){
        super(String name, int day, int month, int year, String description);
        this.start[0] = start_hour;
        this.start[1] = start_minute;
        this.end[0] = end_hour;
        this.end[1] = end_minute;
        repeat = true;
        this.repeat_days = repeat_days;
        this.repeat_months = repeat_months;
        this.end_date = end_date;
        this.total_repeat = new int[7][12]; //initialize total_repeat; 1D should be days in a week and 2D should be months in a year
        for(int i = 0; i < repeat_days.length; i++){ //basically: if the day is repeating, attach assocaited information from repeat_months. otherwise, leave it empty
            if(repeat_days[i] == 1){
                for(int j = 0; j < repeat_months.length; j++){
                    this.total_repeat[i][j] = repeat_months[j];
                }
            }
        }
    }

    //getters
    public String getName(){
        //... use ToDoList getter
        super.getName();
    }
    public int[] getStartTime(){
        //... both start_hour and start_minute
        return start;
    }
    public int[] getEndTime(){
        //... both end_hour and end_minute
        return end;
    }
    public int[] getDate(){
        //... day, month, and year
        //use ToDoList getter
        //override from interface
        super.getDate();
    }
    public String getDescription(){
        //... use ToDoList getter
        super.getDescription();
    }
    public int[][] getRepeatStatus(){
        //... return everything associated with the repeat if the repeat is true; use initial getIfRepeat() check in Account
        return total_repeat;
    }
    public boolean getIfRepeat(){
        //return whether or not the event is a repeating event
        return repeat;
    }
    public int[] getCompleteStatus(){
        //...ToDoList getter
        super.getCompleteStatus();
    }

    //setters
    //*have to make sure these are legal inputs
    public void setName(String name){
        //... use ToDoList setter
        super.setName();
    }
    public void setStartHour(int start_hour){
        this.start[0] = start_hour;
    }
    public void setStartMinute(int start_minute){
        this.start[1] = start_minute;
    }
    public void setEndHour(int end_hour){
        this.end[0] = end_hour;
    }
    public void setEndMinute(int end_minute){
        this.end[1] = end_minute;
    }
    public void setDay(int day){
        //... use ToDoList setter
        //override from interface
        super.setDay();
    }
    public void setMonth(int month){
        //... use ToDlist setter
        super.setMonth();
    }
    public void setYear(int year){
        //... use ToDoList setter
        super.setYear();
    }
    public void setDescription(String description){
        //... use ToDoList setter
        super.setDescription();
    }
    public void setRepeatStatus(boolean repeat){ //for the scenario that an event is no longer repeating, i.e. assume input repeat = false
        this.repeat = repeat;
    }
    public void setRepeatStatus(int[] repeat_days, int[] repeat_months, int[] end_date){ //for the scenario that an event is made to be repeating or editing repeat parameters
        if(!repeat){
            repeat = true;
        }
        this.repeat_days = repeat_days;
        this.repeat_months = repeat_months;
        this.end_date = end_date;
        this.total_repeat = new int[7][12]; 
        for(int i = 0; i < repeat_days.length; i++){ 
            if(repeat_days[i] == 1){
                for(int j = 0; j < repeat_months.length; j++){
                    this.total_repeat[i][j] = repeat_months[j];
                }
            }
        }
    }

    //don't need a method to delete objects here; only one in Account to remove a Planner object
    //from its private arraylist

    private int[] start; //0 = start_hour, 1 = start_minute
    private int[] end; //0 = end_hour, 1 = end_minute
    private boolean repeat;
    private int[] repeat_days; //0-6 sunday-saturday. 0 = do not repeat on this day, 1 = repeat on this day
    private int[] repeat_months; //0-11 months, 0 if not repeating at all, 1 = monthly, 2 = bi-weekly
    private int[][] total_repeat; //2d array of the above two. originally separated for simplicity, possibly nix. use as a return type
    private int[] end_date; //final date of repeat
}