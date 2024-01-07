// Planner class, see Java for comments
//extends todolist but does not use variables/methods related to dates

class Planner extends ToDoList{
    constructor(name, description, start_hour, start_minute, end_hour, end_minute, repeat, repeat_days, repeat_months, end_date){
        this.name = name;
        this.description = description;
        this.start[0] = start_hour;
        this.start[1] = start_minute;
        this.end[0] = end_hour;
        this.end[1] = end_minute;
        this.repeat = repeat;
        if(repeat){
            this.repeat_days = repeat_days;
            this.repeat_months = repeat_months;
            this.end_date = end_date
            this.total_repeat = new Number[7][12];
            for(i = 0; i < 7; i++){
                if(repeat_days[i] == 1){
                    for(j = 0; j < 12; j++){
                        this.total_repeat[i][j] = this.repeat_months[j];
                    }
                }
            }
        }
        else{
            this.repeat_days = new Number[0];
            this.repeat_months = new Number[0];
            this.end_date = new Number[0];
            this.total_repeat = new Number[0][0];
        }
    }

    get getName(){
        return super.getName();
    }
    get getStartTime(){
        return start;
    }
    get getEndTime(){
        return end;
    }
    get getDate(){
        return super.getDate();
    }
    get getDescription(){
        return super.getDescription();
    }
    get getRepeatStatus(){
        return this.total_repeat;
    }
    get getIfRepeat(){
        return this.repeat;
    }
    get getCompleteStatus(){
        super.getStatus();
    }

    set setName(name){
        super.setName(name);
    }
    set setStartHour(start_hour){
        start[0] = start_hour;
    }
    set setStartMinute(start_minute){
        start[1] = start_minute;
    }
    set setEndHour(end_hour){
        end[0] = end_hour;
    }
    set setEndMinute(end_minute){
        end[1] = end_minute;
    }
    set setDescription(description){
        super.setDescription(description);
    }
    set setRepeatStatusOff(repeat){ //specifically for turning off repeats; assume false
        this.repeat = repeat;
    }
    setRepeatStatusOn(repeat_days, repeat_months, end_date){
        if(!this.repeat){
            this.repeat = true;
        }
        this.repeat_days = repeat_days;
        this.repeat_months = repeat_months;
        this.end_date = end_date;
        this.total_repeat = new Number[7][12];
        for(i = 0; i < 7; i++){
            if(repeat_days[i] == 1){
                for(j = 0; j < 12; j++){
                    this.total_repeat[i][j] = this.repeat_months[j];
                }
            }
        }
    }

    start;
    end;
    repeat;
    repeat_days;
    repeat_months;
    total_repeat;
    end_date;
}