package org.example;

import java.util.ArrayList;

public class Participant extends User{
    private String address;
    private int age;
    private ArrayList<Event> EventList;
    public Participant() {
        this.EventList = new ArrayList<>();
    }
    public Participant(String username,String password,String address,int age) {
        super(username,password);
        this.age=age;
        this.address=address;
        this.EventList = new ArrayList<>();
        System.out.println("Child Participant Class here");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addEvent(Event event){
        this.EventList.add(event);
    }
    public void deleteEvent(Event event){
        this.EventList.remove(event);
    }

    public ArrayList<Event> getEventList() {
        return EventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        EventList = eventList;
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
