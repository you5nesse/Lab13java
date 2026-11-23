package com.example.tp;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main2 {
	public static void main(String[] args) {
        String file = "chat.ser";

        // 1) Création d'un historique de chat
        List<ChatMessage> history = new ArrayList<>();
        history.add(new ChatMessage("Younesse", "Salam tout le monde"));
        history.add(new ChatMessage("Hamza", "How are you ?"));
        history.add(new ChatMessage("Oussama",   "Comment ça va ?"));

        // 2) Sauvegarde
        try {
            ChatHistory.save(file, history);
            System.out.println("Historique sauvegardé dans " + file);
        } catch (IOException e) {
            System.err.println("Erreur sauvegarde : " + e.getMessage());
            return;
        }

        // 3) Chargement
        List<ChatMessage> loaded;
        try {
            loaded = ChatHistory.load(file);
            System.out.println("Historique chargé :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur chargement : " + e.getMessage());
            return;
        }

        // 4) Affichage
        for (ChatMessage msg : loaded) {
            System.out.printf("  [%d chars] %s%n",
                msg.getLength(), msg);
        }
    }
}
