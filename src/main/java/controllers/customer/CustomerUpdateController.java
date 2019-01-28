package controllers.customer;

import domain.Customer;
import domain.Project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Created by Andrey on 24.01.2019.
 */
public class CustomerUpdateController extends AbstractCustomerController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = getById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("jsp/customer/updateCustomer.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String projectsToDelete = request.getParameter("customerProjectsToDelete");
        deleteCustomersOldProjects(projectsToDelete);
        Customer customer = new Customer();
        long id = Long.parseLong(request.getParameter("customerId"));
        String name = request.getParameter("customerName");
        String country = request.getParameter("customerCountry");
        String projectsId = request.getParameter("customerProjects");
        Set<Project> projects = getProjects(projectsId);
        customer.setId(id);
        customer.setName(name);
        customer.setCountry(country);
        updateCustomer(customer);
        for (Project project : projects){
            project.setCustomer(customer);
            projects().updateDao(project);
        }
        response.sendRedirect("/customers");
    }

    private void deleteCustomersOldProjects(String ids){
        Set<Project> projects = getProjects(ids);
        for (Project project : projects){
            project.setCustomer(null);
            projects().updateDao(project);
        }
    }
}
