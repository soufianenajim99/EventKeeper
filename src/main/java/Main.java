import Enums.EventType;
import org.example.Admin;
import org.example.Event;
import org.example.Participant;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Admin currentAdmin = new Admin();
        ArrayList<Admin> admins = new ArrayList<>();
        Participant currentParticipant = new Participant();
        Console cons = System.console();
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Participant> participants = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Admin admin = new Admin("admin","pass");
        try{
            Event event = new Event("Event1","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            Event event2 = new Event("Event2","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            Event event3 = new Event("Event3","paris",dateFormat.parse("8/8/8"),dateFormat.parse("8/5/8"),EventType.CONFERENCES,admin);
            events.add(event);
            events.add(event2);
            events.add(event3);

        }catch (ParseException e){
            System.out.println("Error : "+e);
        }

        Scanner myObj = new Scanner(System.in);

        String name;
        String option;

        outerswitch:
        do{
            System.out.println("Sign in as : ");
            System.out.println("1) Administrator: ");
            System.out.println("2) Participant : ");

            name = myObj.nextLine();

            switch(name) {
                case "1":
                    System.out.println("1) Register a new Administrator");
                    System.out.println("2) Log in as an existing Administrator");
                    String adminChoice = myObj.nextLine();
                    if(adminChoice.equals("1")){
                        if(currentAdmin.getUsername()==null){
                            System.out.println("************** Entrer Votre Nom : ***********");
                            String AdminName = myObj.nextLine();
                            currentAdmin.setUsername(AdminName);
                            System.out.println("************** Entrer Votre Mot de passe : ***********");
                            char[] AdminPass = cons.readPassword("Password : ");
                            StringBuilder builder = new StringBuilder();
                            for(char c: AdminPass){
                                builder.append(c);
                            }
                            currentAdmin.setPassword(builder.toString());
                             admins.add(currentAdmin);
                            System.out.println("************ Admin "+currentAdmin.getUsername()+" registered Succefully ! **************");
                        }
                    }else if (adminChoice.equals("2")) {
                        // Log in as an existing Admin
                        System.out.println("Enter Admin username:");
                        String adminUsername = myObj.nextLine();
                        System.out.println("Enter Admin password:");
                        String adminPassword = myObj.nextLine();

                        // Check if the admin exists
                        boolean isAdminFound = false;
                        for (Admin admine : admins) {
                            if (admine.getUsername().equals(adminUsername) && admine.getPassword().equals(adminPassword)) {
                                isAdminFound = true;
                                System.out.println("Welcome, " + adminUsername + "!");
                                currentAdmin=admine;
                                break;
                            }
                        }

                        if (!isAdminFound) {
                            System.out.println("Invalid credentials. Please try again.");
                            break outerswitch;
                        }
                    } else {
                        System.out.println("Invalid option.");
                        break outerswitch;

                    }
                    do{




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
                        System.out.println("11) Logout : " + currentAdmin.getUsername());
                        System.out.println("12) Quitter : ");

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
                                    }
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
                                int EventDel=myObj.nextInt()-1;
                                events.remove(events.get(EventDel));
                                System.out.println("************* evenement Supprimer Avec Success !**************");
                                break;
                            case "4" :
                                System.out.println("************* liste des événements **************");

                                for (Event eve : events) {
                                    System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                                }
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

                                        System.out.println("Nombre d'inscriptions : " + selectedEvent.getParticipants().size());
                                        for (Participant participant : selectedEvent.getParticipants()) {
                                            System.out.println("Participant: " + participant.getUsername());
                                        }
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

                                    case "2":
                                        System.out.println("Entrer le lieu de recherche : ");
                                        String searchLocation = myObj.nextLine();

                                        System.out.println("Résultats de recherche pour le lieu : " + searchLocation);
                                        for (Event event : events) {
                                            if (event.getLocalisation() != null && event.getLocalisation().equalsIgnoreCase(searchLocation)) {
                                                System.out.println("ID: " + event.getId() + " Nom: " + event.getName() + " Type: " + event.getEventType());
                                            }
                                        }
                                        break;

                                    case "3":
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

                                System.out.print("Entrez le nom du Participant : ");
                                String username = myObj.nextLine();


                                System.out.print("Entrez le mot de passe : ");
                                String password = myObj.nextLine();

                                System.out.print("Entrez l'adresse : ");
                                String address = myObj.nextLine();

                                int age = 0;
                                while (true) {
                                    System.out.print("Entrez l'âge (numéro entier) : ");
                                    if (myObj.hasNextInt()) {
                                        age = myObj.nextInt();
                                        myObj.nextLine();
                                        break;
                                    } else {
                                        System.out.println("Âge invalide, veuillez entrer un numéro entier.");
                                        myObj.next();
                                    }
                                }


                                Participant newParticipant = new Participant(username, password, address, age);
                                participants.add(newParticipant);
                                System.out.println("Participant ajouté avec succès : " + newParticipant);

                                break;
                            case "7":
                                System.out.println("Modifier un participant :");

                                if (participants.isEmpty()) {
                                    System.out.println("Aucun participant à modifier.");
                                    break;
                                }


                                for (int i = 0; i < participants.size(); i++) {
                                    System.out.println((i + 1) + ". " + participants.get(i));
                                }

                                System.out.print("Entrez le numéro du participant à modifier : ");
                                int participantIndex = -1;
                                while (true) {
                                    if (myObj.hasNextInt()) {
                                        participantIndex = myObj.nextInt() - 1; // Convert to 0-based index
                                        myObj.nextLine();
                                        if (participantIndex >= 0 && participantIndex < participants.size()) {
                                            break;
                                        } else {
                                            System.out.println("Numéro invalide, veuillez entrer un numéro valide.");
                                        }
                                    } else {
                                        System.out.println("Entrée invalide, veuillez entrer un numéro.");
                                        myObj.next();
                                    }
                                }

                                // Retrieve the participant to modify
                                Participant participantToModify = participants.get(participantIndex);

                                System.out.print("Entrez le nouveau nom du Participant (laissez vide pour ne pas modifier) : ");
                                String newUsername = myObj.nextLine();
                                if (!newUsername.isEmpty()) {
                                    participantToModify.setUsername(newUsername);
                                }

                                System.out.print("Entrez le nouveau mot de passe (laissez vide pour ne pas modifier) : ");
                                String newPassword = myObj.nextLine();
                                if (!newPassword.isEmpty()) {
                                    participantToModify.setPassword(newPassword);
                                }

                                System.out.print("Entrez la nouvelle adresse (laissez vide pour ne pas modifier) : ");
                                String newAddress = myObj.nextLine();
                                if (!newAddress.isEmpty()) {
                                    participantToModify.setAddress(newAddress);
                                }

                                System.out.print("Entrez le nouvel âge (numéro entier, laissez vide pour ne pas modifier) : ");
                                String ageInput = myObj.nextLine();
                                if (!ageInput.isEmpty()) {
                                    try {
                                        int newAge = Integer.parseInt(ageInput);
                                        participantToModify.setAge(newAge);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Âge invalide, aucune modification appliquée à l'âge.");
                                    }
                                }

                                System.out.println("Participant modifié avec succès : " + participantToModify);
                                System.out.println(participants);
                                break;
                            case "8":
                                System.out.println("Supprimer un participant :");

                                if (participants.isEmpty()) {
                                    System.out.println("Aucun participant à supprimer.");
                                    break;
                                }


                                for (int i = 0; i < participants.size(); i++) {
                                    System.out.println((i + 1) + ". " + participants.get(i));
                                }

                                System.out.print("Entrez le numéro du participant à supprimer : ");
                                int participantToDelete = -1;
                                while (true) {
                                    if (myObj.hasNextInt()) {
                                        participantToDelete = myObj.nextInt() - 1; // Convertir en index basé sur 0
                                        myObj.nextLine();
                                        if (participantToDelete >= 0 && participantToDelete < participants.size()) {
                                            break;
                                        } else {
                                            System.out.println("Numéro invalide, veuillez entrer un numéro valide.");
                                        }
                                    } else {
                                        System.out.println("Entrée invalide, veuillez entrer un numéro.");
                                        myObj.next();
                                    }
                                }


                                Participant removedParticipant = participants.remove(participantToDelete);
                                System.out.println("Participant supprimé avec succès : " + removedParticipant);
                                break;
                            case "9":
                                System.out.println("Sélectionner un participant pour voir ses détails :");

                                if (participants.isEmpty()) {
                                    System.out.println("Aucun participant à afficher.");
                                    break;
                                }


                                for (int i = 0; i < participants.size(); i++) {
                                    System.out.println((i + 1) + ". " + participants.get(i).getUsername()); // Affiche seulement le nom du participant
                                }

                                System.out.print("Entrez le numéro du participant pour voir les détails : ");
                                int participantIndexToView = -1;
                                while (true) {
                                    if (myObj.hasNextInt()) {
                                        participantIndexToView = myObj.nextInt() - 1; // Convertir en index basé sur 0
                                        myObj.nextLine();
                                        if (participantIndexToView >= 0 && participantIndexToView < participants.size()) {
                                            break;
                                        } else {
                                            System.out.println("Numéro invalide, veuillez entrer un numéro valide.");
                                        }
                                    } else {
                                        System.out.println("Entrée invalide, veuillez entrer un numéro.");
                                        myObj.next();
                                    }
                                }


                                Participant selectedParticipant = participants.get(participantIndexToView);
                                System.out.println("Détails du participant :");
                                System.out.println("Nom : " + selectedParticipant.getUsername());
                                System.out.println("Mot de passe : " + selectedParticipant.getPassword());
                                System.out.println("Adresse : " + selectedParticipant.getAddress());
                                System.out.println("Âge : " + selectedParticipant.getAge());
                                break;

                            case "10":

                                System.out.println("************* Rapport de la plateforme **************");


                                System.out.println("Nombre d'événements créés : " + events.size());


                                System.out.println("Nombre de participants sur la plateforme : " + participants.size());


                                System.out.println("Nombre d'inscriptions pour chaque événement :");
                                for (Event eve : events) {
                                    System.out.println("Événement: " + eve.getName() + " (ID: " + eve.getId() + ")");
                                    System.out.println("Nombre d'inscriptions: " + eve.getParticipants().size());
                                }

                                break;
                            case "11":
                                System.out.println("***** " + currentAdmin.getUsername() + " Disconnected ************");
                                currentAdmin= new Admin();
                                System.out.println("***** " + currentAdmin.getUsername() + " ************");
                                name = "0";
                                continue outerswitch;
                            default:
                                System.out.println("************* Try Again ****************");
                        }
                    }while (!option.equals("12"));
                    System.out.println("Admin");
                    break;
                case  "2":
                    System.out.println("1) Register as a new Participant");
                    System.out.println("2) Log in as an existing Participant");
                    String participantChoice = myObj.nextLine();

                    if (participantChoice.equals("1")) {
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
//
                            participants.add(currentParticipant);
                            System.out.println("************ Participant "+currentParticipant.getUsername()+" registered Succefully ! **************");
                        }
                    } else if (participantChoice.equals("2")) {

                        System.out.println("Enter Participant username:");
                        String participantUsername = myObj.nextLine();
                        System.out.println("Enter Participant password:");
                        String participantPassword = myObj.nextLine();


                        boolean isParticipantFound = false;
                        for (Participant participant : participants) {
                            if (participant.getUsername().equals(participantUsername) && participant.getPassword().equals(participantPassword)) {
                                isParticipantFound = true;
                                currentParticipant = participant;
                                System.out.println("Welcome, " + participantUsername + "!");

                                break;
                            }
                        }

                        if (!isParticipantFound) {
                            System.out.println("Invalid credentials. Please try again.");
                            break outerswitch;
                        }
                    } else {
                        System.out.println("Invalid option.");
                        break outerswitch;
                    }



                    do{
                        System.out.println("Choisir une Option : ");
                        System.out.println("1) Afficher la liste des événements : ");
                        System.out.println("2) inscrire à des événements : ");
                        System.out.println("3) consulter mes inscriptions : ");
                        System.out.println("4) Désinscrire d'un événement : ");
                        System.out.println("5) Rechercher des événements par critère (date, lieu, type) : ");
                        System.out.println("6) Logout : " + currentParticipant.getUsername());
                        System.out.println("12) Quitter : ");
                        option = myObj.nextLine();
                      switch (option) {
                          case "1" :
                              System.out.println("************* liste des événements **************");
                              for (Event eve : events) {
                                  System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                              }
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
                              }

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
                                      currentParticipant.addEvent(selectedEvent);

                                      System.out.println("Vous desormez Inscrit dans cet evenement");
                                  } else {
                                      System.out.println("ID invalide. Veuillez essayer de nouveau.");
                                  }
                              } while (myObj.nextInt() != 0);
                              break;
                              case "3":
                                  System.out.println("************* liste des événements auquelle je suis inscrit  **************");

                                  for (Event eve: currentParticipant.getEventList()){
                                      System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                                  }

                              break;
                              case "4":
                                  System.out.println("************* liste des événements auquelle je suis inscrit  **************");
                                  for (Event eve: currentParticipant.getEventList()){
                                      System.out.println("********** Id : " +eve.getId() +") "+eve.getName());
                                  }
                                      int EventChoice;

                                          System.out.println("Entrez l'ID de l'événement a deinscrire (ou entrez 0 pour retourner) : ");
                                          while (!myObj.hasNextInt()) {
                                              System.out.println("Veuillez entrer un numéro valide.");
                                              myObj.next();
                                          }
                                          EventChoice = myObj.nextInt();

                                          if (EventChoice > 0 && EventChoice <= events.size()) {
                                              Event selectedEvent = events.get(EventChoice - 1);
                                              currentParticipant.deleteEvent(selectedEvent);
                                              System.out.println("vous desormez deinscrit de cet evenement");
                                          } else {
                                              System.out.println("ID invalide. Veuillez essayer de nouveau.");
                                          }
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
                                  case "1":
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
                                  System.out.println("***** " + currentParticipant.getUsername() + " Disconnected ************");
                                  currentParticipant= new Participant();

                                  System.out.println("***** " + currentParticipant.getUsername() + " ************");
                                  name = "0";
                                  continue outerswitch;
                      }
                    }while(!option.equals("12"));

                    break;



            }
        }while(!(name.equals("1") || name.equals("2")));


    }

}