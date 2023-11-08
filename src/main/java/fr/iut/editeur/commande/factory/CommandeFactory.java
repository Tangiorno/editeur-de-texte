package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

public class CommandeFactory {

    private static CommandeFactory instance;

    public static CommandeFactory getInstance() {
        if(instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    private CommandeFactory() {}

    public Commande createCommand(String name, Document document, String[] parameters) {
        return switch (name) {
            case "ajouter" -> new CommandeAjouter(document, parameters);
            case "remplacer" -> new CommandeRemplacer(document, parameters);
            case "majuscules" -> new CommandeMajuscules(document, parameters);
            case "effacer" -> new CommandeEffacer(document, parameters);
            case "clear" -> new CommandeClear(document, parameters);
            default -> null;
        };
    }

}
