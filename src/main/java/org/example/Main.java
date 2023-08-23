package org.example;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        databasePopulateService.insertWorker("Tom Jackson",LocalDate.now().minusYears(27),Level.Senior,7240);
        databasePopulateService.insertClient("Yasin Cengiz");
        databasePopulateService.insertProject(1,LocalDate.now().minusMonths(15),LocalDate.now().minusMonths(6));
        databasePopulateService.insertProjectWorker(1,1);

    }
}