package com.saraya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	String url ="jdbc:mysql://localhost:3306/dabr-db";
	String user="root";
	String password="";
	// Class.forName("com.mysql.cj.jdbc.Driver");
	public ArrayList<String> getMonRegime(String prenom_nom) throws SQLException {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet result=null;
		ArrayList<String> nameList=new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(url, user, password);
			pstm=conn.prepareStatement("SELECT `prenom_nom` FROM `inscription_dabr_inscription_list`");
			result=pstm.executeQuery();
			while(result.next()) {
				String name=result.getString(prenom_nom);
				//System.out.println(name);
				nameList.add(name);
				
			}
			
		} catch (ClassNotFoundException ec) {
			//System.out.println("No suitable driver for DB found");
			ec.printStackTrace();
		} catch (SQLException se) {
			//System.out.print("SQL Exception occurred");
			se.printStackTrace();
		} finally {
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
		}
		return nameList;
	}
	
//	public static void main(String[] args) throws SQLException {
//		StudentDAO sd= new StudentDAO();
//		System.out.println("Result "+sd.getMonRegime("prenom_nom"));
//	}

}
