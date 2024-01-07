public class Account{
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        //give the private variables default values
        calendar = new Planner[1][12]; //initialize for 1 year Planner the future (from 2023), 12 months in a year
        calendar[0][12] = new Planner[31]; //December (this year) has 31 days
        calendar[1][0] = new Planner[31]; //January (next year) has 31 days
        calendar[1][1] = new Planner[29]; //February has 29 days
        calendar[1][2] = new Planner[31]; //March
        calendar[1][3] = new Planner[30]; //April
        calendar[1][4] = new Planner[31]; //May
        calendar[1][5] = new Planner[30]; //June
        calendar[1][6] = new Planner[31]; //July
        calendar[1][7] = new Planner[31]; //August
        calendar[1][8] = new Planner[30]; //September
        calendar[1][9] = new Planner[31]; //October
        calendar[1][10] = new Planner[30]; //November
        calendar[1][11] = new Planner[31]; //December
        // ^ hard-coded for the presentation
        // this constructor is a default constructor used to make an "empty" Account item on new user or to be reassigned for returning users
        ArrayList<ToDoList> todo = new ArrayList<ToDoList>();
        ArrayList<Integer> mentalhealth = new ArrayList<Integer>();
        int[] settings = //...design settings to implement this. each index pos relates to a predetermined setting (eg. color scheme) and each option 
        //correlates to some number stored at that pos
        //set default settings here
    }

    //account management
    public Account login(String user, String pass){
        //find matching account in the data structure, use compareTo
        //assign variables from matching Account to "this" Account
        //implement throw/catch here for reading
    }
    public void save(){
        //write new save state to file, use compareTo
        //save in String lines & convert back to proper types in login()?
        //implement throw/catch here for writing
    }
    public String compareTo(){ 
        //pull unique ID for locating account in data structure (compare usernames until match, then compare passwords)
    }

    //getters for specific elements
    public ToDoList getToDoList(int index){ //index given defaultly by the UI. arraylist added to in the order that tasks are made
        return todolist.get(index);
    }
    public Planner getPlanner(int day, int month, int year){ //for now, just pulls the calendar date because there's only one Planner object per tile. 
        //will have to update if we fix events. assume year is given as current year
        return calendar[year-2023][month][day]; //2023 is the "first" year shown in the calendar, therefore substract 2023 from any given year to get correlating index pos
        //eg. 2023 -> index pos 0
    }
    
    //new objects
    public void newToDo(String name, int day, int month, int year, String description){
        //create a new to-do task and add it to todo arraylist
        //use ToDoList constructor
        ToDoList new_item = new ToDoList(name, day, month, year, description);
        todo.add(new_item);
    }
    public void newPlanner(String name, String description, int start_hour, int start_minute, int end_hour, int end_minute, int day, int month, int year){ 
        //can also functionally work as setplanner as it provides where it goes in the array
        //create a new planner task and add it to planner arralyst
        //use Planner constructor
        Planner new_item = new Planner(name, description, start_hour, start_minute, end_hour, end_minute, day, month, year);
        calendar[year-2023][month][day] = new_item;
    } //polymorph planner item if the event is repeating. implement in the future to have recurring events appear in tiles correlating to their repeat pattern
      //would need to design a new algorithm
    public void newPlanner(String name, String description, int start_hour, int start_minute, int end_hour, int end_minute, int day, int month, int year, int[] repeat_days, int[] repeat_months, int[] end_date){
        Planner new_item = new Planner(name, description, start_hour, start_minute, end_hour, end_minute, day, month, year, repeat_days, repeat_months, end_date);
        calendar[year-2023][month][day] = new_item;
    }

    //get average mental health score
    public int getAverage(){
        int count = 0;
        double average = 0;
        for(int i = 0;  < mentalhealth.size() - 1; i++){
            count += mentalhealth.get(i);
        }
        average = count / mentalhealth.size();
        return average;
    }

    //setters
    public void setToDoList(int index, String name, int day, int month, int year, String description){
        //functionally a setter, but for individual objects in the arraylist
        ToDoList new_item = new ToDoList(name, day, month, year, description);
        todolist.set(i, new_item); //assumes given index is a legal input. 
        //would have to program this to be an edgecase or make it not possible to make an index that doesn't exist, eg. index is given defaultly by UI
    }
    
    //delete objects
    public void removeToDoList(int index){ //index given defaultly by UI
        todolist.remove(index);
    }
    public void removePlanner(int day, int month, int year){
        calendar[year-2023][month][day] = null; //when displaying Planner elements, if(null) -> show empty event/no event
        //possibly adjust this check to assign an empty Planner object to avoid null errors
    }

    //change settings
    public void changeSettings(int pos, int val){
        //update int[] settings index pos with val. need to establish settings for this
    }
    

    public void mentalHealthCheck(){ //perform the startup mental health check
        //throw a command to the UI to scan in the input. check for legal input on scan. add the input to the arraylist
    }
    
    //update username and password
    //require the user to enter twice to confirm
    public void updateUsername(String username){
        //move save data from original username to new username- use "compareTo" to determine new placement in data structure
        //reassign to new placement
        //delete previous from the data structure
        //update private username
    }
    public void updatePassword(String password){
        this.password = password;
        //update password, implement some confirmation steps
    }

    //account deletion
    public void deleteAccount(){
        //require the user to confirm
        //delete account from data structure
        //boot back to login screen
    }

    final private ArrayList<ArrayList<String>> lines = //etc etc...
    //insert quotes in array pos. 0-8 (not 9 because no one will have a perfect average)
    //special Lines object used because there may be multple Strings per pos desired. 
    //have this be defaultly set by Account constructor
    //maybe use percentages to weight it towards specific quotes but not make it impossible to see
    //others based on your current average
    //call on this in future push notifications implementation

    private Planner[][][] calendar; //stores planner objects- 3D to represent every date. subtract 2023 from whatever year is given for index pos of years. 1d = year, 2d = month, 3d = day
    private ArrayList<ToDoList> todo; //stores to-do list; date of creation attached but no "due" date
    private ArrayList<Integer> mentalhealth; //stores mental health scores. since they are just integers in this build, they can be handled directly by Account
    // ^ future implentation: MentalHealth object which stores scores by date so they can be get (display on calendar) / set (reassign because of an error or changed mind, etc)
    private int[] settings; //stores settings which can be saved;
    //associate positions with settings and the integer within with options
    //0 or 1 for disable or enable, etc.
    
    private String username; //use username as a unique ID in the data structure
    private String password; //not relevant to finding account in data structure, however two identical usernames cannot have the same password
}

//possibly have the Account object save at the end of each function

//dont forget exceptions & error handling

//note that things like the to-do list tasks and the planner will
//be generally visible as part of the UI
//the getters here would be used repeatedly in the same onscreen instance
//but also be used when looking at a specific event/task