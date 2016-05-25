/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for declaring basic methods
 * for getting access to the database
 * @author SoRa
 */
public interface DAO 
{

    /**
     * Gets a link to database .
     * @return <b>Connection<b> link to the database. 
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException;

    /**
     * Sets the class which JDBC driver is in.
     * @throws ClassNotFoundException .
     */
    public void setClass() throws ClassNotFoundException ;
    
}
