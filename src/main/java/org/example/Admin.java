package org.example;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Event> EventList;
    public Admin() {}
    public Admin(String username,String password) {
        super(username,password);
        this.EventList = new ArrayList<>();

    }


    public void addEvent(Event event){
        this.EventList.add(event);
    }
    public void deleteEvent(Event event){
        this.EventList.remove(event);
    }

    @Override
    public String toString() {
        String result = "Admin{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                "Number of Events" + EventList.size() + " events";
        for (int i = 0; i < EventList.size(); i++) {
            result = result + "\n Event"+(i+1)+"EventName :  "+EventList.get(i).getName();
        }
        result = result + "}";
        return result;
    }
}
