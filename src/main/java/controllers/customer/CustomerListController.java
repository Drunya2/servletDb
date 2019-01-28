package controllers.customer;

import domain.Customer;
import repository.CrudRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Andrey on 24.01.2019.
 */
public class CustomerListController extends AbstractCustomerController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CrudRepository<Customer, Long> customerRepository = customers();
        List<Customer> customers = customerRepository.getList();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("jsp/customer/customersPage.jsp").forward(request, response);
    }
}
