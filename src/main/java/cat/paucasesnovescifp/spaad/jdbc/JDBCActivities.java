package cat.paucasesnovescifp.spaad.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCActivities {
    
    public static List<String> getAllLocalities(String idIlla) {
        List<String> localityNames = new ArrayList<>();
        String query = "SELECT l.nomLocalitat FROM Illes i JOIN Localitats l ON i.idIlla = l.idIlla WHERE i.idIlla = ?";
        
        try (Connection conn = JDBC_DB.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, idIlla);
                
                try (ResultSet resultSet = stmt.executeQuery()) {
                    while (resultSet.next()) {
                        localityNames.add(resultSet.getString("nomLocalitat"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return localityNames;
    }
    
    public static Boolean removeCenter(String idCenter) {
        Boolean isRemoved = true;
        String query = "DELETE FROM Centres WHERE idCentre = ?";
        
        try (Connection conn = JDBC_DB.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, idCenter);
                
                int result = stmt.executeUpdate();
                
                if (result == 0) {
                    isRemoved = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            isRemoved = null;
        }
        
        return isRemoved;
    }
    
    public static void implementProcedure() {
        String procedureDLL = """
            CREATE PROCEDURE getCenter(IN idIllaInput CHAR(3), OUT centersOutput INT)
            BEGIN
                SET centersOutput = (SELECT COUNT(*)
                                     FROM Centres
                                              JOIN interins.Localitats L ON L.idLocalitat = Centres.idLocalitat
                                              JOIN interins.Illes I ON I.idIlla = L.idIlla
                                     WHERE I.idIlla = idIllaInput
                                     GROUP BY I.idIlla);
            END;
            """;
        
        try (Connection conn = JDBC_DB.getConnection()) {
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(procedureDLL);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static int callProcedure(String idIlla) {
        int result = 0;
        String call = "CALL getCenter(?, ?)";
        
        try (Connection conn = JDBC_DB.getConnection()) {
            try (CallableStatement stmt = conn.prepareCall(call)) {
                stmt.setString(1, idIlla);
                stmt.registerOutParameter(2, 0);
                stmt.execute();
                result = stmt.getInt(2);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return result;
    }
}
