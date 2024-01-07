//ToDoList class, see Java for comments
//only keeps track of date on its own to show when the task was created
//planner doesn't utilize this due to the calendar arraylist in Account.js

class ToDoList{
    constructor(name, day, month, year, description){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
    }

    get getName(){
        return this.name;
    }
    get getDate(){
        return this.date;
    }
    get getDescription(){
        return this.description;
    }
    get getStatus(){
        return this.status;
    }

    set setName(name){
        this.name = name;
    }
    set setDay(day){
        this.date[0] = day;
    }
    set setMonth(month){
        this.date[1] = month;
    }
    set setYear(year){
        this.year[2] = year;
    }
    set setDescription(description){
        this.description = description;
    }
    set setStatus(status){
        this.status = status;
    }

    name;
    date;
    description;
    complete;
}