package org.example;

import org.example.client.ClientService;
import org.example.database.Database;
import org.example.database.DatabaseMigrationService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseMigrationService.migrate();
        Database database = Database.getInstance();
        ClientService clientService = new ClientService(database.getConnection());
        System.out.println(clientService.listAll());
//        System.out.println(clientService.create("Alex"));
//        System.out.println(clientService.getById(4));
//        clientService.setName(3, "Abra Kadabra");
//        clientService.deleteById(6);//(клієнти з ID 1-5 пов'язані з проектами тому таким способ їх не видалити)
//        System.out.println(clientService.listAll());
    }
}