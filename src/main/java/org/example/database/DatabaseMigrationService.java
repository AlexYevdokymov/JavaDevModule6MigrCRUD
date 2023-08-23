package org.example.database;


import org.flywaydb.core.Flyway;

public class DatabaseMigrationService {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./db",null,null)
                .load();
        flyway.migrate();
    }
}
