package controllers.customer;

import domain.Customer;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCountry(country);
        CrudRepository<Customer, Long> customerRepository = customers();
        customerRepository.createDao(customer);
        response.sendRedirect("/customers");
    }
}
