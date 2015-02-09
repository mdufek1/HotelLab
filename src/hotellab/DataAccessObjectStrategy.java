/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotellab;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public interface DataAccessObjectStrategy {

    void addHotel(Map<String, Object> hotel) throws SQLException;

    List<Hotel> getAllHotels();

    String[] getConnection();

    DatabaseAccessorStrategy getDb();

    String getTable();

    void removeHotel(String where, String value) throws SQLException;

    void setConnection(String[] connection);

    void setDb(DatabaseAccessorStrategy db);

    void setTable(String table);

    void updateHotel(Map<String, Object> updateInfo, String where, String value) throws SQLException;
    
}
