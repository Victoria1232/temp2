package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

        // session object 
        HttpSession session = request.getSession();
        // logout param 
        String logout = request.getParameter("logout");
        // session username 
        String sessionUsername = (String) session.getAttribute("username");
        // session arraylist 
        ArrayList<String> sessionItems = (ArrayList<String>) session.getAttribute("items");

        // if session username is empty and items is empty 
        if (sessionUsername == null) {  // && sessionItems == null //  && items == null
            // set the users list to be empty 
            sessionItems = new ArrayList<>();
            // set the empty list to be the session list 
            session.setAttribute("items", sessionItems);
            // send them to register page 
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        // TEST
        // if logout is pressed 
        if (logout != null) { // logout != null

            request.setAttribute("logoutMessage", "You have been loged out");
            session.invalidate();
            request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        }

        
        // otherwise get session list set  items as the session list 
        /*
        ArrayList<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("orange");
        session.setAttribute("items", items);
        */
        // set the username to be session username 
        session.setAttribute("username", sessionUsername);
        session.setAttribute("items", sessionItems);

        // send them to the shopping list page
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        // empty array list 
        //ArrayList<String> items = new ArrayList<>();
        // username to be registered 
        String username = request.getParameter("username");

        String buttonText = request.getParameter("button");
            String radioButtonValue = request.getParameter("radioButton");
        ArrayList<String> sessionItems = (ArrayList<String>) session.getAttribute("items");
        String radioButton = request.getParameter("radioButton");
        String addItem = request.getParameter("add");
        //String action = request.getParameter("action");

        String deleteButton = request.getParameter("delete");
        String addButton = request.getParameter("addbutton");

    
       // int indexOfItem = sessionItems.indexOf(radioButtonValue);

       /*
        // if username is null or empty throw error send user back to register page 
        if (username == null || username.equals("")) {

            request.setAttribute("error", "Enter Name to register ");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        }
*/

        // if add button is clicked and add item input is not empty - add the item to the users list 
        if ( "Add Item".equalsIgnoreCase(buttonText) ) { // addItem != null &&
            // add the item they entered to the list 
            sessionItems.add(addItem);
            // set items as the session item again to update the old list 
            session.setAttribute("items", sessionItems);
            // set item to be the value of the check box to be displayed 
            request.setAttribute("item", addItem);
            // send everything to shopping list page 
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
            // otherwise if the delete bytton is pressed and a check box is selected - delete the checkbox item 
        } else if ("Delete".equalsIgnoreCase(buttonText) ) { // && radioButton != null

            // remove the check box value from the list 
            sessionItems.remove(radioButtonValue);
            // update the list 
            session.setAttribute("items", sessionItems);
             // send everything to shopping list page 
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        // if username is null or empty throw error send user back to register page 
        if (username == null || username.equals("")) {

            request.setAttribute("error", "Enter Name to register ");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        }
         //  set entered name to be username 
        session.setAttribute("username", username);

        // set items to be the users list
         session.setAttribute("items", sessionItems);
        // send them to shopping list 
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;

    }

}
