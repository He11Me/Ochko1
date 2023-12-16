package dblogic;

import dblogic.DatabaseProperties;
import dblogic.PropertiesFactory;
import gamelogic.Consts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database instance;
    private static final DatabaseProperties properties = PropertiesFactory.getProperties();
    public Database() {
        init();
    }
    public synchronized static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    private void init() {
        createSchema();
        createTable();
    }
    private void createSchema() {
        String query = """
                create schema if not exists ochko;
                """;
        execute(query);

    }
    private void createTable() {
        String query = """
                create table if not exists ochko.ochko(
                    id int serial primary key,
                    player_id int,
                    card_id int,
                    suit_id int
                )
                """;

        execute(query);
    }
    public void put(int player_id, int card_id, int suit_id) {
        String sql = """
        insert into ochko.ochko
        (player_id, card_id, suit_id)
        values
        ('%d', '%d', '%d')
        """;
        execute(String.format(sql, player_id, card_id, suit_id));
    }
    public void updateById(int id, Map<String, Integer> columnNames) {
        String query = """
                update ochko.ochko
                set %s
                where id = %d
                """;
        StringBuilder s = new StringBuilder();
        for (String columnName : columnNames.keySet()) {
            s.append(columnName).append(" = ").append("'").append(columnNames.get(columnName)).append("'").append(", ");
        }
        s = new StringBuilder(s.substring(0, s.length() - Consts.TWO));
        String update = String.format(query, s.toString(), id);
        execute(update);

    }
    public void deleteById(int id) {
        String sql = """
                delete from ochko.ochko
                where id = %d
                """;
        String delete = String.format(sql, id);
        execute(delete);
    }
    public Map<String, String> selectById(int id, String... columnNames) {
        Map<String, String> result = new HashMap<>();
        String query = """
                Select * from ochko.ochko
                where id = %d
                """;
        String select = String.format(query, id);
        try(Connection connection = connect(); Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);
            while(set.next()) {
                for(String columnName : columnNames) {
                    result.put(columnName, set.getString(columnName));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    public List<Map<String, String>> selectAll(String... columnNames) {
        List<Map<String, String>> result = new ArrayList<>();
        String sql = """
                select * from ochko.ochko
                """;
        try(Connection connection = connect();
            Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Map<String, String> fields = new HashMap<>();
                for (String columnName : columnNames) {
                    fields.put(columnName, set.getString(columnName));
                }
                result.add(fields);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public void execute(String query) {
        try(Connection connection = connect();
            Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection connect() throws Exception {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getLogin(),
                properties.getPassword()
        );
    }
    public void clear() {
        String query = """
                TRUNCATE TABLE ochko.ochko RESTART IDENTITY;
                """;
        execute(query);
    }

}