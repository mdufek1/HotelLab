/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotellab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mike
 */
public class HotelDAO implements DataAccessObjectStrategy {
    DatabaseAccessorStrategy db = new MySqlAccessor();
    String[] connection;
    String table;

    public HotelDAO(String[] connection, String table) {
        this.connection = connection;
        this.table = table;
    }

    
    @Override
    public List<Hotel> getAllHotels(){
        List<Hotel> list = new ArrayList<>();
        db.openConnection(connection[0], connection[1], connection[2], connection[3]);
        List<Map<String,Object>> rawList = db.retreiveAllRecordsFromTable("hotel");
        System.out.println(list.size());
        for(Map<String, Object> rec : rawList){ 
            System.out.println(rec);
        }
        
        return list;
    }
    
    @Override
    public void addHotel(Map<String, Object> hotel) throws SQLException{
        db.openConnection(connection[0], connection[1], connection[2], connection[3]);
        db.addNewRecord(table, hotel);
    }
    @Override
    public void updateHotel(Map<String, Object> updateInfo, String where, String value) throws SQLException{
        db.openConnection(connection[0], connection[1], connection[2], connection[3]);
        db.updateRecords(table, updateInfo, where, value);
    }
    @Override
    public void removeHotel(String where, String value) throws SQLException{
        db.openConnection(connection[0], connection[1], connection[2], connection[3]);
        db.deleteRecords(table, where, value);
    }

    @Override
    public DatabaseAccessorStrategy getDb() {
        return db;
    }

    @Override
    public void setDb(DatabaseAccessorStrategy db) {
        this.db = db;
    }

    @Override
    public String[] getConnection() {
        return connection;
    }

    @Override
    public void setConnection(String[] connection) {
        this.connection = connection;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public void setTable(String table) {
        this.table = table;
    }
    

}
