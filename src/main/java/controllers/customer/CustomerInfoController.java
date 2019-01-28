package controllers.customer;

import domain.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrey on 24.01.2019.
 */
public class CustomerInfoController extends AbstractCustomerController {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long id = Long.parseLong(request.getParameter("id"));
        Customer customer = getById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("jsp/customer/customerInfo.jsp").forward(request, response);
    }
}
