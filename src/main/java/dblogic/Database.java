package dblogic;

import dblogic.DatabaseProperties;
import dblogic.PropertiesFactory;

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

    public List<Map<String, Integer>> selectAll(String... columnNames) {
        List<Map<String, Integer>> result = new ArrayList<>();

        String sql = """
                select * from ochko.ochko
                """;

        try(Connection connection = connect();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Map<String, Integer> fields = new HashMap<>();
                for (String columnName : columnNames) {
                    fields.put(columnName, resultSet.getInt(columnName));
                }
                result.add(fields);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void execute(String query) {
        try(Connection connection = connect();
            Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
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
                delete from ochko.ochko
                """;
        execute(query);
    }

}








/*
    private final Database database = Database.getInstance();
    private static final String WORD_ID= "id";
    private static final String WORD_NAME = "word";
    private static final String DEF_NAME = "definition";

 */
