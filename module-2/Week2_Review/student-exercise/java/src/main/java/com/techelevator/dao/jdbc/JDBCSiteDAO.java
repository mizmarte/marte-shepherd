package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) 
    {
    	List<Site> sites = new ArrayList<Site>();
    	
    	String query = "SELECT\r\n" + 
    			"        p.name\r\n" + 
    			"        ,COUNT(s.site_id) AS site_count\r\n" + 
    			"        ,c.campground_id\r\n" + 
    			"            \r\n" + 
    			"FROM park AS p\r\n" + 
    			"INNER JOIN campground AS c\r\n" + 
    			"ON p.park_id = c.park_id\r\n" + 
    			"INNER JOIN site AS s\r\n" + 
    			"ON c.campground_id = s.campground_id\r\n" + 
    			"WHERE s.max_rv_length > 0 AND c.park_id =?\r\n" + 
    			"GROUP BY p.name, c.campground_id\r\n" + 
    			"ORDER BY c.campground_id, COUNT(s.site_id);";
    	
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(query,parkId);
    	
    	
    	while(rows.next())
    	{ 
    		Site site = mapRowToSite(rows);
    		
    		sites.add(site);
    	}
    	
    	return sites;
    }
    
    @Override
    public List<Site> getCurrentlyAvailableSitesInAPark()
    {
    	List<Site> sites = new ArrayList<Site>();
    	return sites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
