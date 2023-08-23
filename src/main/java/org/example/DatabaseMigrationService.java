package org.example;


import org.flywaydb.core.Flyway;

public class DatabaseMigrationService {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./db",null,null)
                .load();
        flyway.migrate();
    }
}
