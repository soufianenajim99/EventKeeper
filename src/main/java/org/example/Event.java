package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Event {

    private int Id;
    private String Name;
    private String StartDate;
    private String EndDate;
    private Admin admin;
    private ArrayList<Participant> participants;


    public Event(int id, String name, Admin admin, String startDate, String endDate) {
        Id = id;
        Name = name;
        this.admin=admin;
        StartDate = startDate;
        EndDate = endDate;
        this.participants = new ArrayList<>();
     
    }

    public Event() {
        this.participants = new ArrayList<>(); 
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void addParticipant(Participant p1){
        this.participants.add(p1);
    }

    public ArrayList<Participant> getParticipants(){
        return this.participants;
    }

    public void deleteParticipants(Participant p1){
        this.participants.remove(p1);
    }

    public Number getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @Override
    public String toString() {
        String result =
             "Event{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Admin='" + admin + '\'' +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                 ", has " + participants.size() +" Participant ";
          for(int i=0; i< participants.size(); i++){
          result = result + "\n Participants "+(i+1)+" Username :  "+participants.get(i).getUsername();
           }
          result = result + "}";
          return result;
     }
}