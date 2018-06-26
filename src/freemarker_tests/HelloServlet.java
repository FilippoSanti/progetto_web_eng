package freemarker_tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    private List<Employee> employeesList = new ArrayList<Employee>();

    {
        employeesList.add(new Employee("001", "Rahul", "Bangalore"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("employees", employeesList);
        request.getRequestDispatcher("/WEB-INF/views/test.ftl").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String city = request.getParameter("city");

        if(null != name && !name.isEmpty() ) {
            employeesList.add(new Employee(id,name, city));
        }
        doGet(request, response);
    }
}