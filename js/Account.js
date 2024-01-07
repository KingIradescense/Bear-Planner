//see java class for comments

class Account{
    constructor(username, password){
        this.username = username;
        this.password = password;
        calendar = new Planner[1][12]; 
        calendar[0][12] = new Planner[31]; 
        calendar[1][0] = new Planner[31]; 
        calendar[1][1] = new Planner[29]; 
        calendar[1][2] = new Planner[31]; 
        calendar[1][3] = new Planner[30]; 
        calendar[1][4] = new Planner[31]; 
        calendar[1][5] = new Planner[30];
        calendar[1][6] = new Planner[31]; 
        calendar[1][7] = new Planner[31]; 
        calendar[1][8] = new Planner[30]; 
        calendar[1][9] = new Planner[31]; 
        calendar[1][10] = new Planner[30]; 
        calendar[1][11] = new Planner[31];
        todo = new ArrayList<ToDoList>(0);
        mentalhealth = new ArrayList<Number>(0);
        settings = //...design settings
    }

    login(user, pass){
        //find matching elements reading from the text file
    }
    save(){
        //write save state to text file
    }
    compareTo(){
        //compare to another account in the text file. basically the username
    }

    get getToDoList(index){
        return this.todo.get(index);
    }
    get getPlanner(day, month, year){
        return calendar[year-2023][month][day];
    }

    newToDo(name, int, day, month, year, description){
        new_item = new ToDoList(name, int, day, month, year, description);
        todo.add(new_item);
    }
    newPlanner(name, description, start_hour, start_minute, end_hour, end_minute, repeat, repeat_days, repeat_months, end_date, year, month, day){
        new_item = new Planner(name, description, start_hour, start_minute, end_hour, end_minute, repeat, repeat_days, repeat_months, end_date);
        calendar[year-2023][month][day] = new_item;
    }

    getAverage(){
        count = 0;
        average = 0;
        for(i = 0; i < mentalhealth.size(); i++){
            count += mentalhealth.get(i);
        }
        average = count / mentalhealth.size();
        return average;
    }

    setToDoList(index, name, day, month, year, description){
        new_item = new ToDoList(name, day, month, year, description);
        todo.set(i, new_item);
    }

    removeToDoList(index){
        todo.remove(index);
    }
    removePlanner(day, month, year){
        calendar[year-2023][month][day] = null;
    }

    changeSettings(pos, val){
        //update int[] settings index pos with val. need to establish settings to implement this
    }

    mentalHealthCheck(){
        //take input from the UI. pretend the input is called new_mentalhealth
        mentalhealth.add(new_mentalhealth);
    }
    set updateUsername(username){
        //save current state to new position defined by new username
        this.username = username;
        //delete previous state from structure
    }
    set updatePassword(password){
        this.password = password;
        //ask to confirm or something. not necessary for this build
    }
    deleteAccount(){
        //require confirmation & full login input
        //delete object from structure
        //throw user to login screen
    }

    lines = //arraylist of mental health popups. have some function correlating average to lines indices 
    calendar;
    todo;
    mentalhealth;
    settings;
    username;
    password;
}