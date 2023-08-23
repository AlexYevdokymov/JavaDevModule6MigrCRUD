package org.example.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final PreparedStatement createSt;
    private final PreparedStatement getByIdSt;
    private final PreparedStatement listAllSt;
    private final PreparedStatement setNameSt;
    private final PreparedStatement deleteByIdSt;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?)",PreparedStatement.RETURN_GENERATED_KEYS);
        getByIdSt = connection.prepareStatement(
                "SELECT id, name FROM client WHERE id = ?");
        listAllSt = connection.prepareStatement(
                "SELECT id, name FROM client");
        setNameSt = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?");
        deleteByIdSt = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?");
    }
    public long create(String name) throws SQLException {
        if (name.length() < 2) throw new SQLException();
        long key = -1;
        createSt.setString(1, name);
        createSt.executeUpdate();
        ResultSet rs = createSt.getGeneratedKeys();
        if (rs.next()) {
            key = rs.getLong(1);
        }
        rs.close();
        return key;
    }
    public String getById(long id) throws SQLException {
        String result = "No such client";
        getByIdSt.setLong(1,id);
        ResultSet rs = getByIdSt.executeQuery();
        if (!rs.next()) return result;
        else result = rs.getString("name");
        rs.close();
        return result;
    }
    public void setName(long id, String name) throws SQLException {
        setNameSt.setString(1, name);
        setNameSt.setLong(2, id);
        setNameSt.executeUpdate();
    }
    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1, id);
        deleteByIdSt.executeUpdate();
    }
    public List<Client> listAll() throws SQLException {
        List<Client> result = new ArrayList<>();
        ResultSet rs = listAllSt.executeQuery();
        while (rs.next()) {
            Client client = new Client();
            client.setId(rs.getLong("id"));
            client.setName(rs.getString("name"));
            result.add(client);
        }
        rs.close();
        return result;
    }
}
