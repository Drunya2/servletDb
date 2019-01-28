package controllers.customer;

import domain.Customer;
import domain.Developer;
import domain.Project;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Created by Andrey on 24.01.2019.
 */
public class CustomerAddController extends AbstractCustomerController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("jsp/customer/addCustomer.jsp").forward(request, response);
    }

    @Override
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("customerName");
        String country = request.getParameter("customerCountry");
        String projectsId = request.getParameter("customerProjects");
        Set<Project> projects = getProjects(projectsId);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCountry(country);
        CrudRepository<Customer, Long> customerRepository = customers();
        customerRepository.createDao(customer);
        for (Project project : projects){
            project.setCustomer(getLast());
            projects().updateDao(project);
        }
        response.sendRedirect("/customers");
    }
}
