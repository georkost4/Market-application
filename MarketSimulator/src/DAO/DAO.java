/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SoRa
 */
public interface DAO 
{
     public Connection getConnection() throws SQLException;
     public void setClass() throws ClassNotFoundException ;
    
}
