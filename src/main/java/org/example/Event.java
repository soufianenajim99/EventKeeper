package org.example;

import Enums.EventType;

import java.util.ArrayList;
import java.util.Date;

public class Event {

    private int Id;
    private String Name;
    public static int counter=1;
    private Date StartDate;
    private Date EndDate;
    private EventType EventType;
    private String Localisation;
    private Admin admin;
    private ArrayList<Participant> participants;


    public Event(String name,String Localisation, Date startDate, Date endDate, Enums.EventType eventType, Admin admin) {
        this();
        Id = counter;
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
        EventType = eventType;
        this.Localisation = Localisation;
        this.admin = admin;
        counter++;

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

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public Enums.EventType getEventType() {
        return EventType;
    }

    public void setEventType(Enums.EventType eventType) {
        EventType = eventType;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String localisation) {
        Localisation = localisation;
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
                ", Localisation=" + Localisation +
                 ", has " + participants.size() +" Participant ";
          for(int i=0; i< participants.size(); i++){
          result = result + "\n Participants "+(i+1)+" Username :  "+participants.get(i).getUsername();
           }
          result = result + "}";
          return result;
     }
}