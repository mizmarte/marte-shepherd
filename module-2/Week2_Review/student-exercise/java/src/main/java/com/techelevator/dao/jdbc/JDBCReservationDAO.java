package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
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
    	int newId = getNextReservationId();
    	
    	String createNewReservation = "INSERT INTO reservation\r\n" + 
    			"(reservation_id, site_id, name, from_date, to_date)\r\n" + 
    			"VALUES(?,?,?,?,?);";
    	
    	
    	
    	jdbcTemplate.update(createNewReservation, newId, siteId, name, fromDate, toDate);
    	
    	return newId;
    }
    public Reservation getReservationById(int reservationId)
    {	
    	Reservation reservation = null;
    	String query = "SELECT reservation_id\r\n" + 
    			"        ,site_id\r\n" + 
    			"        ,name\r\n" + 
    			"        ,from_date\r\n" + 
    			"        ,to_date\r\n" +
    			"        ,create_date\r\n" +
    			"FROM reservation\r\n" + 
    			"WHERE reservation_id = ?;";
    	
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(query, reservationId);
    	
    	while (rows.next())
    	{
    		reservation = mapRowToReservation(rows);
    	}
    	
        return reservation;
    }
    @Override
    public List<Reservation> getAllReservationsForTheNext30Days()
    {
    	List<Reservation> reservations = new ArrayList<Reservation>();
    	
    	String query = "SELECT r.reservation_id \r\n" + 
    			"        ,r.site_id\r\n" + 
    			"        ,r.name\r\n" + 
    			"        ,r.from_date\r\n" + 
    			"        ,r.to_date\r\n" +
    			"        ,r.create_date\r\n" +
    			"FROM reservation AS r\r\n" + 
    			"INNER JOIN site AS s\r\n" + 
    			"ON r.site_id = s.site_id\r\n" + 
    			"INNER JOIN campground AS c\r\n" + 
    			"ON s.campground_id = c.campground_id\r\n" + 
    			"WHERE from_date BETWEEN CURRENT_DATE + 1 AND CURRENT_DATE + 30 \r\n" +  
    			"        AND park_id = ?;";
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(query);
    	
    	while (rows.next())
    	{
    		Reservation reservation = mapRowToReservation(rows);
    		
    		reservations.add(reservation);	
    	}
    	
    	return reservations;
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

    private int getNextReservationId() 
    {
    	String nextIdQuery = "SELECT nextval('reservation_reservation_id_seq') AS id;";
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet(nextIdQuery);
		if(nextIdResult.next()) 
		{
			return nextIdResult.getInt("id");
		} else 
		{
			throw new RuntimeException("Something went wrong while getting an id for the new reservation");
		}
	}

	

}
