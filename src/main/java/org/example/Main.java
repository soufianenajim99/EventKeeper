package org.example;

import Enums.EventType;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Admin currentAdmin = new Admin();
        Participant currentParticipant = new Participant();

        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Participant> participants = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Admin admin = new Admin("admin",5,"pass");
        try{
            Event event = new Event("Event1","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            Event event2 = new Event("Event2","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            Event event3 = new Event("Event3","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            events.add(event);
            events.add(event2);
            events.add(event3);

        }catch (ParseException e){
            System.out.println(e);

        }
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
                        clearConsole();
                        if(currentAdmin.getUsername()==null){
                            System.out.println("************** Entrer Votre Nom : ***********");
                            String AdminName = myObj.nextLine();
                            currentAdmin.setUsername(AdminName);
                            System.out.println("************** Entrer Votre Mot de passe : ***********");
                            String AdminPass = myObj.nextLine();
                            currentAdmin.setPassword(AdminPass);
                            currentAdmin.setId(1);
                            System.out.println("************ Admin "+currentAdmin.getUsername()+" registered Succefully ! **************");
                        }
                        clearConsole();

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
                        System.out.println("10) Afficher les inscriptions d'un événement : ");
                        System.out.println("11) Generer Rapports : ");
                        System.out.println("12) Logout : " + currentAdmin.getUsername());
                        System.out.println("13) Quitter : ");

                        option = myObj.nextLine();
                        switch (option){
                            case "1" :
                                System.out.println("************* Ajouter un evenement **************");
                                try{
                                    System.out.println("Entrer le nom d'evenement : ");
                                    String nameEvent=myObj.nextLine();
                                    System.out.println("Entrer la localisation d'evenement : ");
                                    String locaEvent=myObj.nextLine();
                                    System.out.println("Entrer Date de Debut d'evenement (dd/MM/yyyy) : ");
                                    String startDate=myObj.nextLine();
                                    Date dateDebut = dateFormat.parse(startDate);

                                    System.out.println("Entrer Date de Fin d'evenement (dd/MM/yyyy) : ");

                                    String endDate=myObj.nextLine();
                                    Date dateFin = dateFormat.parse(endDate);

                                    System.out.println("Choose event type (CONFERENCES, SEMINAIRES, REUNIONS, ATELIERS): ");
                                    String eventTypeStr = myObj.nextLine().toUpperCase();
                                    EventType eventType = EventType.valueOf(eventTypeStr);
                                    Event event = new Event(nameEvent,locaEvent,dateDebut,dateFin,eventType,currentAdmin);
                                    events.add(event);
                                    System.out.println("************* Evenement Ajouter Avec Success !**************");
                                } catch (ParseException e) {
                                    System.out.println("Invalid date format. Please use the format dd/MM/yyyy.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid event type. Please enter a valid event type.");
                                }

                                break;
                            case "2" :
                                try{
                                    System.out.println("************* Modifier un evenement **************");
                                    for (Event eve : events) {
                                        System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                                    };
                                    System.out.println("Entrer le Id d'evenement a modifier : ");
                                    int EventMod=myObj.nextInt()-1;
                                    myObj.nextLine();
                                    System.out.println("Entrer le nouveau nom d'evenement : ");
                                    String nameEventMod=myObj.nextLine();

                                    if(!nameEventMod.isEmpty()){
                                        events.get(EventMod).setName(nameEventMod);
                                    }
                                    System.out.println("Entrer la nouvelle Date de Debut d'evenement (dd/MM/yyyy) : ");
                                    String startDate=myObj.nextLine();
                                    if(!startDate.isEmpty()){
                                        Date dateDebut = dateFormat.parse(startDate);

                                        events.get(EventMod).setStartDate(dateDebut);
                                    }

                                    System.out.println("Entrer la nouvelle Date de Fin d'evenement (dd/MM/yyyy) : ");
                                    String endDate=myObj.nextLine();

                                    if(!endDate.isEmpty()){
                                        Date dateFin = dateFormat.parse(endDate);
                                        events.get(EventMod).setEndDate(dateFin);
                                    }

                                    System.out.println("Entrer la nouvelle Localisation : ");
                                    String localisation=myObj.nextLine();

                                    if(!localisation.isEmpty()){
                                        events.get(EventMod).setLocalisation(localisation);
                                    }

                                    System.out.println("Choose event type (CONFERENCES, SEMINAIRES, REUNIONS, ATELIERS): ");
                                    String eventTypeStr = myObj.nextLine().toUpperCase();

                                    if(!eventTypeStr.isEmpty()){
                                        EventType eventType = EventType.valueOf(eventTypeStr);
                                        events.get(EventMod).setEventType(eventType);
                                    }
                                    System.out.println("************* Evenement Modifier Avec Success !  **************");

                                } catch (ParseException e) {
                                    System.out.println("Invalid date format. Please use the format dd/MM/yyyy.");
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid event type. Please enter a valid event type.");
                                }
                                break;
                            case "3" :
                                System.out.println("***************** Supprimer un evenements  ******************");
                                System.out.println("Entrer le Id d'evenement a Supprimer : ");
                                int EventDel=myObj.nextInt();
                                events.remove(events.get(EventDel));
                                System.out.println("************* evenement Supprimer Avec Success !**************");
                                break;
                            case "4" :
                                System.out.println("************* liste des événements **************");

                                for (Event eve : events) {
                                    System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                                };
                                int eventChoice;
                                do {
                                    System.out.println("Entrez l'ID de l'événement pour voir les détails (ou entrez 0 pour retourner) : ");
                                    while (!myObj.hasNextInt()) {
                                        System.out.println("Veuillez entrer un numéro valide.");
                                        myObj.next();
                                    }
                                    eventChoice = myObj.nextInt();

                                    if (eventChoice > 0 && eventChoice <= events.size()) {
                                        Event selectedEvent = events.get(eventChoice - 1);
                                        System.out.println("ID : " + selectedEvent.getId());
                                        System.out.println("Nom : " + selectedEvent.getName());
                                        System.out.println("Date de début : " + selectedEvent.getStartDate());
                                        System.out.println("Date de fin : " + selectedEvent.getEndDate());
                                        System.out.println("Localisation : " + selectedEvent.getLocalisation());
                                        System.out.println("Type : " + selectedEvent.getEventType());
                                    } else {
                                        System.out.println("ID invalide. Veuillez essayer de nouveau.");
                                    }
                                } while (eventChoice != 0);
                                break;
                            case "5":
                                System.out.println("************* Rechercher des événements par critère **************");
                                System.out.println("Choisir un critère de recherche : ");
                                System.out.println("1) Par Date");
                                System.out.println("2) Par Localisation");
                                System.out.println("3) Par Type");
                                System.out.println("4) Retourner au Menu Principal");

                                String searchOption = myObj.nextLine();
                                switch (searchOption) {
                                    case "1": // Search by Date
                                        try {
                                            System.out.println("Entrer la Date de recherche (dd/MM/yyyy) : ");
                                            String searchDate = myObj.nextLine();
                                            Date dateToSearch = dateFormat.parse(searchDate);

                                            System.out.println("Résultats de recherche pour la date : " + searchDate);
                                            for (Event event : events) {
                                                if (event.getStartDate().equals(dateToSearch) || event.getEndDate().equals(dateToSearch)) {
                                                    System.out.println("ID: " + event.getId() + " Nom: " + event.getName() + " Type: " + event.getEventType());
                                                }
                                            }
                                        } catch (ParseException e) {
                                            System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
                                        }
                                        break;

                                    case "2": // Search by Location
                                        System.out.println("Entrer le lieu de recherche : ");
                                        String searchLocation = myObj.nextLine();

                                        System.out.println("Résultats de recherche pour le lieu : " + searchLocation);
                                        for (Event event : events) {
                                            if (event.getLocalisation() != null && event.getLocalisation().equalsIgnoreCase(searchLocation)) {
                                                System.out.println("ID: " + event.getId() + " Nom: " + event.getName() + " Type: " + event.getEventType());
                                            }
                                        }
                                        break;

                                    case "3": // Search by Type
                                        System.out.println("Choisir un type d'événement à rechercher (CONFERENCES, SEMINAIRES, REUNIONS, ATELIERS) : ");
                                        String searchTypeStr = myObj.nextLine().toUpperCase();
                                        try {
                                            EventType searchType = EventType.valueOf(searchTypeStr);

                                            System.out.println("Résultats de recherche pour le type : " + searchType);
                                            for (Event event : events) {
                                                if (event.getEventType() == searchType) {
                                                    System.out.println("ID: " + event.getId() + " Nom: " + event.getName() + " Lieu: " + event.getLocalisation());
                                                }
                                            }
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Type d'événement invalide. Veuillez entrer un type valide.");
                                        }
                                        break;

                                    case "4":
                                        System.out.println("Retourner au Menu Principal...");
                                        break;

                                    default:
                                        System.out.println("Option invalide. Veuillez choisir une option de recherche valide.");
                                        break;
                                }
                                break;


                            case "6":
                                System.out.println("Ajouter un participant :");
                                break;
                            case "7":
                                System.out.println("Modifier un participant");
                                break;
                            case "8":
                                System.out.println("Supprimer un participant");
                                break;
                            case "9":
                                System.out.println("Afficher la liste des participants");

                                break;
                            case "10":
                                System.out.println("Generer Rapports");
                                break;
                            default:
                                System.out.println("************* Invalide Code****************");
                        }
                    }while (!option.equals("13"));
                    System.out.println("Admin");
                    break;
                case  "2":
                    System.out.println("participant");
                    do{
                        if(currentParticipant.getUsername()==null){
                            System.out.println("************** Entrer Votre Nom : ***********");
                            String ParticipantName = myObj.nextLine();
                            currentParticipant.setUsername(ParticipantName);
                            System.out.println("************** Entrer Votre Mot de passe : ***********");
                            String PartPass = myObj.nextLine();
                            currentParticipant.setPassword(PartPass);
                            System.out.println("************** Entrer Votre age : ***********");
                            int PartAge = myObj.nextInt();
                            currentParticipant.setAge(PartAge);
                            myObj.nextLine();
                            System.out.println("************** Entrer Votre address : ***********");
                            String PartAdr = myObj.nextLine();
                            currentParticipant.setAddress(PartAdr);
                            currentParticipant.setId(participants.size());
                            participants.add(currentParticipant);
                            System.out.println("************ Participant "+currentParticipant.getUsername()+" registered Succefully ! **************");
                        }

                        System.out.println("Choisir une Option : ");
                        System.out.println("1) Afficher la liste des événements : ");
                        System.out.println("2) inscrire à des événements : ");
                        System.out.println("3) consulter mes inscriptions : ");
                        System.out.println("4) Désinscrire d'un événement : ");
                        System.out.println("5) Rechercher des événements par critère (date, lieu, type) : ");
                        System.out.println("11) Logout : " + currentParticipant.getUsername());
                        System.out.println("12) Quitter : ");
                        option = myObj.nextLine();
                      switch (option) {
                          case "1" :
                              System.out.println("************* liste des événements **************");
                              for (Event eve : events) {
                                  System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                              };
                              int eventChoice;
                              do {
                                  System.out.println("Entrez l'ID de l'événement pour voir les détails (ou entrez 0 pour retourner) : ");
                                  while (!myObj.hasNextInt()) {
                                      System.out.println("Veuillez entrer un numéro valide.");
                                      myObj.next();
                                  }
                                  eventChoice = myObj.nextInt();

                                  if (eventChoice > 0 && eventChoice <= events.size()) {
                                      Event selectedEvent = events.get(eventChoice - 1);
                                      System.out.println("ID : " + selectedEvent.getId());
                                      System.out.println("Nom : " + selectedEvent.getName());
                                      System.out.println("Date de début : " + selectedEvent.getStartDate());
                                      System.out.println("Date de fin : " + selectedEvent.getEndDate());
                                      System.out.println("Localisation : " + selectedEvent.getLocalisation());
                                      System.out.println("Type : " + selectedEvent.getEventType());
                                  } else if (eventChoice != 0) {
                                      System.out.println("ID invalide. Veuillez essayer de nouveau.");
                                  }
                              } while (eventChoice != 0);
                              break;
                          case "2":
                              System.out.println("************* liste des événements **************");
                              for (Event eve : events) {
                                  System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                              };

                              do {
                                  System.out.println("Entrez l'ID de l'événement pour Inscrire a cet evenement (ou entrez 0 pour retourner) : ");

                                  while (!myObj.hasNextInt()) {
                                      System.out.println("Veuillez entrer un numéro valide.");

                                      myObj.next();
                                  }
                                  int eventChoiceI = myObj.nextInt();

                                  if (eventChoiceI > 0 && eventChoiceI <= events.size()) {
                                      Event selectedEvent = events.get(eventChoiceI - 1);
                                      selectedEvent.addParticipant(currentParticipant);
                                      System.out.println("Vous desormez Inscrit dans cet evenement");
                                  } else {
                                      System.out.println("ID invalide. Veuillez essayer de nouveau.");
                                  }
                              } while (myObj.nextInt()-1 != 0);
                              break;
                      }
                    }while(!option.equals("12"));

                    break;
                default:
                    System.out.println("hey");
            }
        }while(!(name.equals("1") || name.equals("2")));


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

//        System.out.println("*************************EventList*******************");
//        System.out.println(event);
//        System.out.println("*************************ParticipantInfo*************");
//        System.out.println(p1);
//        User user1 = new User("marco",45);
//        Admin admin1 = new Admin("sam",78);
//        System.out.println(admin1.getUsername());
//        System.out.println(user1);

    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}