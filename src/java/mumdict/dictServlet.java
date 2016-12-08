/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mumdict;
import DbConnection.DBConnection;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayush
 */
public class dictServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getRequestDispatcher("/dict.html").forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SearchWords> map = new ArrayList<SearchWords>();
         String lookupword=request.getParameter("search");
        System.out.print("hajkjhada" + lookupword);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        DbConnection.DBConnection db=new DbConnection.DBConnection();
        map =db.dbConnect(lookupword);
          response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
        
      
       
       
       
    }

   

}
