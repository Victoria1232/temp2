
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mfgperez
 */
public class ShoppingListServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
       
       /**
        * on load if session obj username exsists go to shopping list 
        *  get the username and list items and send it to shopping list 
        * 
        *  if logout is not null 
        * invalidate the session object 
        */
       
        
    
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
        
   
       
   }
   
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
 
         HttpSession session = request.getSession();
       
         /**
          *  if regestered name is not null continue 
          * add register name to a session object and call it username 
          * send info to shopping list jsp 
          * 
          *  in shopping list jsp add all items entered to an array list 
          * then save it to a session object and call it items 
          */
    
         
         getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
         return;
         
   
      
        
   }
}
