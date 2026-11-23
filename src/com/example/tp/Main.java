package com.example.tp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
/////////////////////////////////////////////////////test 1 /////////////////////////////////////////////////////
        final String filePath = "employees.ser";

        
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee(1, "Younesse", 4000.0, "pwdYounesse"));
        staff.add(new Employee(2, "Hamza",  4500.5, "pwdHamza"));
        staff.add(new Employee(3, "Oussama",    3800.75,"pwdOussama"));

        
        try {
            SerializationUtil.serializeEmployees(filePath, staff);
            System.out.println("→ Sérialisation réussie dans " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur de sérialisation : " + e.getMessage());
            return;
        }

        
        List<Employee> loaded;
        try {
            loaded = SerializationUtil.deserializeEmployees(filePath);
            System.out.println("→ Désérialisation réussie, objets restaurés :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur de désérialisation : " + e.getMessage());
            return;
        }

        // 4) Affichage des objets désérialisés
        for (Employee emp : loaded) {
            System.out.println("  " + emp);
        }

        // 5) Vérification du champ transient
        System.out.println("\nNote : le champ 'password' est transient, il n’a pas été enregistré → null.");
        

      
    }
}