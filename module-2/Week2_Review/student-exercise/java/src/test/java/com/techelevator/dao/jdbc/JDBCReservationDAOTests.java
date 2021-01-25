package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JDBCReservationDAOTests extends BaseDAOTests {

    private ReservationDAO dao;

    @Before
    public void setup() {
        dao = new JDBCReservationDAO(dataSource);
    }

    @Test
    public void createReservation_Should_ReturnNewReservationId() 
    {
    	//Arrange
    	int siteId = 1;
    	String expectedName = "TEST NAME";
    	LocalDate startDate = LocalDate.now().plusDays(1); 
    	LocalDate endDate = LocalDate.now().plusDays(3);
    	//Act
        int reservationCreated = dao.createReservation(siteId,
                expectedName,startDate, endDate);
        //Assert
        Reservation newReservation = dao.getReservationById(reservationCreated);
        assertNotNull(newReservation);
        assertEquals(expectedName, newReservation.getName());
    }
    
    @Test
    public void getAllReservationsForTheNext30Days_Should_ReturnNew21Reservations() 
    {
    	int expectedCount = 21;
    	
    	int actualCount = dao.getAllReservationsForTheNext30Days(
    	).size();

         assertEquals(expectedCount,actualCount);
    	
    }

}
