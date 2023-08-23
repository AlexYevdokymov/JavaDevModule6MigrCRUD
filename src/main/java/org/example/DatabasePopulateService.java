package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabasePopulateService {
    private final Connection connection = Database.getInstance().getConnection();
    public void insertWorker(String name, LocalDate birthday, Level level, int salary) throws SQLException {
        PreparedStatement insertSt = connection.prepareStatement(
                "INSERT INTO worker (name, birthday, level, salary)" +
                        "VALUES(?, ?, ?, ?)");
        insertSt.setString(1,name);
        insertSt.setString(2, birthday.toString());
        insertSt.setString(3, level.name());
        insertSt.setInt(4, salary);
        insertSt.executeUpdate();
    }
    public void insertClient(String name) throws SQLException {
        PreparedStatement insertSt = connection.prepareStatement(
                "INSERT INTO client (name) VALUES(?)");
        insertSt.setString(1, name);
        insertSt.executeUpdate();
    }
    public void insertProject(int client_id, LocalDate start_date, LocalDate finish_date) throws SQLException {
        PreparedStatement insertSt = connection.prepareStatement(
                "INSERT INTO project(client_id, start_date, finish_date) VALUES(?, ?, ?)");
        insertSt.setInt(1, client_id);
        insertSt.setString(2, start_date.toString());
        insertSt.setString(3, finish_date.toString());
        insertSt.executeUpdate();
    }
    public void insertProjectWorker(int project_id, int worker_id) throws SQLException {
        PreparedStatement insertSt = connection.prepareStatement(
                "INSERT INTO project_worker (project_id, worker_id) VALUES(?, ?)");
        insertSt.setInt(1, project_id);
        insertSt.setInt(2, worker_id);
        insertSt.executeUpdate();
    }
}
