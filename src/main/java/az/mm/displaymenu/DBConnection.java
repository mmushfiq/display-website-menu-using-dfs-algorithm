package az.mm.displaymenu;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class DBConnection {
    
    static {
        createMenu();
    }

    private static Connection getDBConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root&serverTimezone=UTC");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return connection;
    }

    private static void createMenu(){
        try (Connection connection = getDBConnection();
             BufferedReader br = new BufferedReader(new FileReader("src/main/resources/create.sql")); ) {

            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) 
                sb.append(str);
            
            for(String sql: sb.toString().split(";"))
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql);){
                    preparedStatement.execute();
                }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static Map<Integer, List<Submenu>> getMenu() {
        Map<Integer, List<Submenu>> adjMap = new LinkedHashMap();
        String sql = "Select * from test.menu;";

        try (Connection connection = getDBConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();) {

            while (rs.next()) {
                Submenu s = new Submenu(rs.getInt("parent_id"), rs.getInt("id"), rs.getString("name"));
                if (adjMap.containsKey(s.from())) 
                    adjMap.get(s.from()).add(s);
                else {
                    List<Submenu> menuList = new LinkedList();
                    menuList.add(s);
                    adjMap.put(s.from(), menuList);
                }
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        return adjMap;
    }
}