package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Admin currentAdmin = new Admin();

        ArrayList<Event> events = new ArrayList<>();
//        JOptionPane.showMessageDialog(null, "Hello");
//        JOptionPane.showMessageDialog(null, "Hello 2", "My Message", JOptionPane.ERROR_MESSAGE);

//        String value = JOptionPane.showInputDialog("Please enter a number");

//        System.out.println(value);
        Scanner myObj = new Scanner(System.in);
        String name;
        String option;
        do{
//            System.out.println(currentAdmin.username);
            System.out.println("Sign in as : ");
            System.out.println("1) Administrator: ");
            System.out.println("2) Participant : ");

            name = myObj.nextLine();
            switch(name) {
                case "1":
                    do{
                        if(currentAdmin.getUsername()==null){
                            System.out.println("************** Entrer Votre Nom : ***********");
                            String AdminName = myObj.nextLine();
                            currentAdmin.setUsername(AdminName);
                            currentAdmin.setId(1);
                            System.out.println("************ Admin "+currentAdmin.getUsername()+" registered Succefully ! **************");
                        }

                        System.out.println("Choisir une Option : ");
                        System.out.println("1) Ajouter un evenement : ");
                        System.out.println("2) Modifier un evenement : ");
                        System.out.println("3) Supprimer un evenements : ");
                        System.out.println("4) Afficher la liste des événements : ");
                        System.out.println("5) Rechercher des événements par critère (date, lieu, type) : ");
                        System.out.println("6) Ajouter un participant : ");
                        System.out.println("7) Modifier un participant : ");
                        System.out.println("8) Supprimer un participant : ");
                        System.out.println("9) Afficher la liste des participants : ");
                        System.out.println("10) Generer Rapports : ");
                        System.out.println("11) Quitter : ");

                        option = myObj.nextLine();
                        switch (option){
                            case "1" :
                                System.out.println("*************Ajouter un evenement**************");
                                System.out.println("Entrer le nom d'evenement : ");
                                String nameEvent=myObj.nextLine();
                                System.out.println("Entrer Date de Debut d'evenement : ");
                                String dateDebut=myObj.nextLine();
                                System.out.println("Entrer Date de Fin d'evenement : ");
                                String dateFin=myObj.nextLine();
                                Event event = new Event(events.size()+1,nameEvent,currentAdmin,dateDebut,dateFin);
                                events.add(event);
                                System.out.println("************* evenement Ajouter Avec Success !**************");

                                break;
                            case "2" :
                                System.out.println("*************Modifier un evenement**************");
                                System.out.println("Entrer le Id d'evenement a modifier : ");
                                int EventMod=myObj.nextInt();
                                System.out.println("Entrer le nom d'evenement : ");
                                String nameEventMod=myObj.nextLine();
                                events.get(EventMod).setName(nameEventMod);
                                System.out.println("Entrer Date de Debut d'evenement : ");
                                String dateDebutEventMod=myObj.nextLine();
                                events.get(EventMod).setStartDate(dateDebutEventMod);
                                System.out.println("Entrer Date de Fin d'evenement : ");
                                String dateFinEventMod=myObj.nextLine();
                                events.get(EventMod).setEndDate(dateFinEventMod);
                                System.out.println("************* evenement Modifier Avec Success !**************");
                                break;
                            case "3" :
                                System.out.println("*****************Supprimer un evenements******************");
                                System.out.println("Entrer le Id d'evenement a Supprimer : ");
                                int EventDel=myObj.nextInt();
                                events.remove(events.get(EventDel));
                                System.out.println("************* evenement Supprimer Avec Success !**************");
                                break;
                            case "4" :
                                System.out.println("*************liste des événements **************");
                                for (Event eve : events) {

                                        System.out.println(eve.getName());


                                };
                                break;
                             case "5" :
                                System.out.println("Rechercher des événements par critère (date, lieu, type) : ");
                                break;
                            default:
                                System.out.println("*************Invalide Code****************");
                        }
                    }while (!option.equals("11"));
                    System.out.println("Admin");
                    break;
                case  "2":
                    System.out.println("participant");
                    break;
                default:
                    System.out.println("hey");
            }
        }while(!(name.equals("1") || name.equals("2")));
//        Admin admin = new Admin("admin",5);
//        Event event = new Event(1,"Event1",admin,"8/8/8","7/7/7");
//        Event event2 = new Event(1,"Event2",admin,"8/8/8","7/7/7");
//        Event event3 = new Event(1,"Event3",admin,"8/8/8","7/7/7");
//        Participant p1 = new Participant("pa1",456);
//        Participant p2 = new Participant("pa2",453);
//        Participant p3 = new Participant("pa3",454);
//        Participant p4 = new Participant("pa4",455);
//        event.addParticipant(p1);
//        event.addParticipant(p2);
//        event.addParticipant(p3);
//        event.addParticipant(p4);
//        event.addParticipant(p4);
//        p1.addEvent(event);
//        p1.addEvent(event2);
//        p1.addEvent(event3);
//
//        System.out.println("*************************EventList*******************");
//        System.out.println(event);
//        System.out.println("*************************ParticipantInfo*************");
//        System.out.println(p1);
//        User user1 = new User("marco",45);
//        Admin admin1 = new Admin("sam",78);
//        System.out.println(admin1.getUsername());
//        System.out.println(user1);

    }
}