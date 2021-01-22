package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) 
    {
    	
    	String createNewReservation = "INSERT INTO reservation\r\n" + 
    						"        (site_id, name, from_date, to_date, create_date)\r\n" + 
    						"        \r\n" + 
    						"VALUES (?, ?, ?, ?, CURRENT_DATE);";
    	//r.setReservationId() = Id(getNextReservationId());
    	
    	jdbcTemplate.update(createNewReservation, siteId, name, fromDate, toDate);
    	
    	String query = "SELECT reservation_id\r\n" +  
    			"FROM reservation\r\n" + 
    			"WHERE site _id = ? \r\n" + 
    			"        AND name = ?\r\n" + 
    			"        AND from_date = ?\r\n" + 
    			"        AND to_date = ?;";
    	
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(query, siteId, name, fromDate, toDate);
    	
    	int reservationId = rows.getInt("reservation_id");
    	
        return reservationId;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }

    private long getNextReservationId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_reservation_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

}
