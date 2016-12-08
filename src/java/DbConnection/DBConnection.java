/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mumdict.SearchWords;

/**
 *
 * @author ayush
 */
public class DBConnection {
    public ArrayList dbConnect(String words) {
        String string=null;
          ArrayList messageData = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
                   // List<SearchWords> users = new ArrayList<SearchWords>();
		ResultSet rs = null;
		try {
//			new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:mysql://localhost:3306/entries";
			String connectionUser = "root";
			String connectionPassword = "ayush";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM entries WHERE word = ?");//stmt = conn.createStatement();
         statement.setString(1, words);
			rs = statement.executeQuery();
            while (rs.next()) {
               String str="("+rs.getString("wordtype")+") :: " + rs.getString("definition");
               messageData.add(str);
            }
//                     string=rs.getString(words);
//                             System.out.print("aaaaaa" + string);

	    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
                return messageData;
	}
    
//    public class SearchWords{
//       String words;
//
//        public SearchWords() {
//        }
//       
//       
//       
//        public void setWord(String word) {
//            this.words = word;
//        }
//    }
}
