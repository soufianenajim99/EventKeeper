package org.example;

import java.util.ArrayList;

public class Participant extends User{
    private ArrayList<Event> EventList;
    public Participant() {}
    public Participant(String username, int Id) {
        super(username, Id);
        this.EventList = new ArrayList<>();
        System.out.println("Child Participant Class here");
    }
    public void addEvent(Event event){
        this.EventList.add(event);
    }
    public void deleteEvent(Event event){
        this.EventList.remove(event);
    }

    @Override
    public String toString() {
        String result = "Participant{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                "Event Participating number : " + EventList.size()+ " Events";
        for(int i=0; i< EventList.size(); i++){
            result = result + "\n Event "+(i+1)+" EventName :  "+EventList.get(i).getName();
        }
        result = result + "}";
        return result;



    }
}
